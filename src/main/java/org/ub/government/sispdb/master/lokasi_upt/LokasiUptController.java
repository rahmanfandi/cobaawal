package org.ub.government.sispdb.master.lokasi_upt;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import org.ub.government.sispdb.model.Upt;
import org.ub.government.sispdb.master.lokasi_upt.LokasiUptView.OnViewListener;
import org.ub.government.sispdb.model.IkanSubKelas;
import org.ub.government.sispdb.model_enum.EnumStatusOperasiForm;

public class LokasiUptController implements OnViewListener{
	protected LokasiUptModel model;
	protected LokasiUptView view;

	public LokasiUptController(LokasiUptView view) {
		model = new LokasiUptModel();
		this.view = view;
	}

	@Override
	public void aksiBtnReloadFromDb() {
		model.reloadListHeader();
		model.reloadListOthers();
		
		view.reloadDataProviderHeader();
		view.reloadDataProviderOthers();
		
		view.reloadDataGrid1();
		view.reloadDataGrid2();
		view.reloadComponentComboBox();
	}
	@Override
	public void aksiBtnFilter() {		
//		view.setTableModelFilter();
		view.setTableModelOrFilter();
	}

	@Override
	public void aksiBtnNewForm() {
		model.resetNewObject_Header();
		model.itemHeader.setStatusActive(true);
		
		view.readBinderHeader();
		view.getTf_ID().requestFocus();
		
		model.statusOperasiForm = EnumStatusOperasiForm.ADD_NEW;
		view.setFormButtonAndTextState();
		
	}

	@Override
	public void aksiBtnEditForm() {
		if (view.getjTable1().getSelectedRow() <0) {
			JOptionPane.showMessageDialog(view, "Belum ada data yang dipilih", "Warning", JOptionPane.WARNING_MESSAGE);
		}else {
		
			view.readBinderHeader();
			
			view.getTf_Description().requestFocus();
			
			model.statusOperasiForm = EnumStatusOperasiForm.EDIT_FORM;
			view.setFormButtonAndTextState();
		}
	}

	@Override
	public void aksiBtnDeleteForm() {
		if (model.statusOperasiForm.equals(EnumStatusOperasiForm.OPEN)) {
			boolean isValidDelete = true;
			/*
			 * CEK APAKAH SUDAH DIPAKAI MELAKUKAN TRANSAKSI
			 */
			if (model.itemHeader.getTangkaphSet().size() >0) isValidDelete = false;
			if (JOptionPane.showConfirmDialog(view, "Yakin hapus data", "Konfirm Hapus", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) isValidDelete = false;
			
			if (isValidDelete) {
				model.statusOperasiForm = EnumStatusOperasiForm.DEL_STAT;
				
				model.deleteFromDatabase(null);
				view.updateDataGrid1();
				
				model.resetNewObject_Header();
				view.readBinderHeader();
				
				
				model.statusOperasiForm = EnumStatusOperasiForm.OPEN;
			}
		}
		
	}

	@Override
	public void aksiBtnSaveForm() {
		view.writeBinderHeader();
		boolean isValidKodeKembar = true;
		boolean isValidIsian = true;
		
		//Pengecekan kode kembar hanya untuk Add New Saja
		if (model.statusOperasiForm.equals(EnumStatusOperasiForm.ADD_NEW)) {
			if (model.isKodeSudahAdaPerCompany(model.itemHeader.getKode1(), null) !=null) {
				isValidKodeKembar =false;
			}
		}//end if status operasiform
		if (view.getCombo_Group1().getSelectedIndex() <0) isValidIsian = false;
			
		
				
		if (isValidKodeKembar && isValidIsian) {
			
			model.saveToDatabase();
	
			//Update View
			view.updateDataGrid1();
			
			model.statusOperasiForm = EnumStatusOperasiForm.OPEN;
			view.setFormButtonAndTextState();
		}else {
			if (isValidKodeKembar ==false) JOptionPane.showMessageDialog(view, "Kode Sudah Pernah Ada/Dipakai", "Confilct Code", JOptionPane.ERROR_MESSAGE);
			if (isValidIsian ==false) JOptionPane.showMessageDialog(view, "Isian masih belum Valid", "Isian tidak Balid", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void aksiBtnCancelForm() {
		
		model.statusOperasiForm = EnumStatusOperasiForm.OPEN;
		view.setFormButtonAndTextState();
		
	}

	@Override
	public void aksiBtnCloseForm() {
		view.dispose();
	}

	@Override
	public void aksiPrintForm() {
		
	}

	@Override
	public void aksiTable1_ListSelection(ListSelectionEvent event) {
		try {
			if(! (model.statusOperasiForm.equals(EnumStatusOperasiForm.ADD_NEW) || model.statusOperasiForm.equals(EnumStatusOperasiForm.EDIT_FORM)) ) {
		        try{
                    int selectedRow = view.getjTable1().getSelectedRow();
                    Upt domainBean = new Upt();
                    domainBean = (Upt) model.tableModelHeader.get(selectedRow);
                    model.itemHeader = domainBean;
                    
                    view.readBinderHeader();
		        
		        }catch(Exception ex){}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
