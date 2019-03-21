/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.sispdb_gui.menu_utama;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.ub.government.sispdb.master.ikan_jenis.IkanJenisView;
import org.ub.government.sispdb.master.ikan_subkelas.IkanSubKelasView;
import org.ub.government.sispdb.master.lokasi_upt.LokasiUptView;
import org.ub.government.sispdb.master.pemerintahan_pemda.PemerintahanPemdaView;
import org.ub.government.sispdb.master.pemerintahan_pemprop.PemerintahanPempropView;
import org.ub.government.sispdb.master.pemerintahan_satker.PemerintahanSatkerView;
import org.ub.government.sispdb.master.pemerintahan_unitkerja.PemerintahanUnitKerjaView;
import org.ub.government.sispdb.master.wilayah_desa.WilayahDesaView;
import org.ub.government.sispdb.master.wilayah_kabupatenkota.WilayahKabupatenView;
import org.ub.government.sispdb.master.wilayah_kecamatan.WilayahKecamatanView;
import org.ub.government.sispdb.master.wilayah_propinsi.WilayahPropinsiView;
import org.ub.government.sispdb.sispdb_gui.master_ikanjenis.IkanJenis_IntFrame;
import org.ub.government.sispdb.sispdb_gui.master_ikansubkelas.IkanSubKelas_IntFrame;
import org.ub.government.sispdb.sispdb_gui.master_wilayah.WilayahIntFrame;
import org.ub.government.sispdb.sispdb_gui.tabulasi_perikanan_laut.TabulasiPerikananLautIntFrame;
import org.ub.government.sispdb.sispdb_gui.utilitas.tabulasi_to_text.TabExtractToTextFrame;


/**
 *
 * @author yhawin
 */
public class MainMenuApp extends MainMenuFrame implements MainMenuListenerInter{

    WilayahIntFrame wilayahView = null;
    
    IkanJenisView jenisIkanView = null;
    IkanSubKelasView subKelasView = null;
    LokasiUptView uptView = null;

    WilayahDesaView wilayahDesaView = null;
    WilayahKecamatanView wilayahKecamatanView = null;
    WilayahKabupatenView wilayahKabupatenView = null;
    WilayahPropinsiView wilayahPropinsiView = null;

    PemerintahanUnitKerjaView pemerintahanUnitKerjaView = null;
    PemerintahanSatkerView pemerintahanSatkerView = null;
    PemerintahanPemdaView pemerintahanPemdaView = null;
    PemerintahanPempropView pemerintahanPempropView = null;
 
    TabulasiPerikananLautIntFrame tabulasiPerikananLautView = null;

    TabExtractToTextFrame tabExtractToTextView = null;
    
    public MainMenuApp(){
        initMenuListener();
        initViews();
        
        getMenuItemIkan().setVisible(false);
    }
    public void initMenuListener() {
    	
        getMenuItemParameterSistem().addActionListener(e -> menuItem_SettingParamenterSistem_ActionPerformed(e));
        getMenuItemPengguna().addActionListener(e -> menuItem_SettingPengguna_ActionPerformed(e));
        getMenuItem_InisialisasiDataAwal().addActionListener(e -> menuItem_SettingInisialisasiDataAwal_ActionPerformed(e));
    
        getMenuItemLogPengguna().addActionListener(e -> menuItem_SettingLogPengguna_ActionPerformed(e));

//        getMenuItemIkan().addActionListener(e -> menuItem_MasterIkan_ActionPerformed(e)); //TIDAK ADA
        getMenuItemJenisIkan().addActionListener(e -> menuItem_MasterJenisIkan_ActionPerformed(e));
        getMenuItemSubKelas().addActionListener(e -> menuItem_MasterSubKelas_ActionPerformed(e));

        getMenuItem_AlatTangkap().addActionListener(e -> menuItem_MasterAlatTangkap_ActionPerformed(e));
        getMenuItem_JenisPerairan().addActionListener(e -> menuItem_MasterJenisPerairan_ActionPerformed(e));

        getMenuItemUpt().addActionListener(e -> menuItem_MasterLokasiUpt_ActionPerformed(e));

        getMenuItem_Desa().addActionListener(e -> menuItem_MasterWilayahDesa_ActionPerformed(e));
        getMenuItem_Kecamatan().addActionListener(e -> menuItem_MasterWilayahKecamatan_ActionPerformed(e));
        getMenuItem_KabupatenKota().addActionListener(e -> menuItem_MasterWilayahKabupatenKota_ActionPerformed(e));
        getMenuItem_Propinsi().addActionListener(e -> menuItem_MasterWilayahPropinsi_ActionPerformed(e));
        
        getMenuItemUnitKerja().addActionListener(e -> menuItem_MasterPemerintahanUnitKerja_ActionPerformed(e));
        getMenuItemSatuanKerja().addActionListener(e -> menuItem_MasterPemerintahanSatker_ActionPerformed(e));
        getMenuItemPemDa().addActionListener(e -> menuItem_MasterPemerintahanPemDa_ActionPerformed(e));
        getMenuItemPemProp().addActionListener(e -> menuItem_MasterPemerintahanPemProv_ActionPerformed(e));

        getMenuItemPerikananTangkapLaut().addActionListener(e -> menuItem_TabulasiPerikananTangkapLaut_ActionPerformed(e));
        getMenuItemPerikananUmumDarat().addActionListener(e -> menuItem_TabulasiPerikananTangkapLaut_ActionPerformed(e));

        getMenuItemTabulasiKeText().addActionListener(e -> menuItem_UtilitasDataTabulasiKeExcel_ActionPerformed(e));
        getMenuItemExtractKeExcel().addActionListener(e -> menuItem_UtilitasDataTabulasiKeExcel_ActionPerformed(e));
        
    }

    @Override
    public void menuItemLogout_ActionPerformed(ActionEvent evt) {
    }

    @Override
    public void menuItem_SettingParamenterSistem_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItem_SettingPengguna_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void menuItem_SettingLogPengguna_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItem_SettingInisialisasiDataAwal_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void menuItem_MasterIkan_ActionPerformed(ActionEvent evt) {
    }


    @Override
    public void menuItem_MasterJenisIkan_ActionPerformed(ActionEvent evt) {
        if (jenisIkanView ==null) jenisIkanView = new IkanJenisView();
        if (! jenisIkanView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            jenisIkanView.setPreferredSize(dim);
            jenisIkanView.setVisible(true);
            getjDesktopPane1().add(jenisIkanView);
        }
        jenisIkanView.requestFocusInWindow();
        jenisIkanView.toFront();
        
    }
    @Override
    public void menuItem_MasterSubKelas_ActionPerformed(ActionEvent evt) {
        if (subKelasView ==null) subKelasView = new IkanSubKelasView();
        if (! subKelasView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            subKelasView.setPreferredSize(dim);
            subKelasView.setVisible(true);
            getjDesktopPane1().add(subKelasView);
        }
        subKelasView.requestFocusInWindow();
        subKelasView.toFront();
        
    }

    @Override
    public void menuItem_TabulasiPerikananTangkapLaut_ActionPerformed(ActionEvent evt) {
        if (tabulasiPerikananLautView ==null) tabulasiPerikananLautView = new TabulasiPerikananLautIntFrame();
        if (! tabulasiPerikananLautView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            tabulasiPerikananLautView.setPreferredSize(dim);
            tabulasiPerikananLautView.setVisible(true);
            getjDesktopPane1().add(tabulasiPerikananLautView);
        }
        tabulasiPerikananLautView.requestFocusInWindow();
        tabulasiPerikananLautView.toFront();
    }

    @Override
    public void menuItem_TabulasiPerikananUmumDarat_ActionPerformed(ActionEvent evt) {
        
    }

    @Override
    public void menuItem_TabulasiLaporanLaporan_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItem_TabulasiExtractToExcel_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItem_UtilitasDataTabulasiKeExcel_ActionPerformed(ActionEvent evt) {
        if (tabExtractToTextView ==null) tabExtractToTextView = new TabExtractToTextFrame();
        if (! tabExtractToTextView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            tabExtractToTextView.setPreferredSize(dim);
            tabExtractToTextView.setVisible(true);
            getjDesktopPane1().add(tabExtractToTextView);
        }
        tabExtractToTextView.requestFocusInWindow();
        tabExtractToTextView.toFront();
    }

    @Override
    public void menuItem_UtilitasSycnTaDariExcel_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItem_UtilitasDataMasterKeExcel_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void menuItemKeluar_ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

    @Override
    public void menuItem_UtilitasSycnMasterDariExcel_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	@Override
	public void menuItem_MasterAlatTangkap_ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuItem_MasterJenisPerairan_ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuItem_MasterLokasiUpt_ActionPerformed(ActionEvent evt) {
        if (uptView ==null) uptView = new LokasiUptView();
        if (! uptView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            uptView.setPreferredSize(dim);
            uptView.setVisible(true);
            getjDesktopPane1().add(uptView);
        }
        uptView.requestFocusInWindow();
        uptView.toFront();
	}
	@Override
	public void menuItem_MasterWilayahPropinsi_ActionPerformed(ActionEvent evt) {
        if (wilayahPropinsiView ==null) wilayahPropinsiView = new WilayahPropinsiView();
        if (! wilayahPropinsiView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            wilayahPropinsiView.setPreferredSize(dim);
            wilayahPropinsiView.setVisible(true);
            getjDesktopPane1().add(wilayahPropinsiView);
        }
        wilayahPropinsiView.requestFocusInWindow();
        wilayahPropinsiView.toFront();
	}
	@Override
	public void menuItem_MasterWilayahKabupatenKota_ActionPerformed(ActionEvent evt) {
        if (wilayahKabupatenView ==null) wilayahKabupatenView = new WilayahKabupatenView();
        if (! wilayahKabupatenView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            wilayahKabupatenView.setPreferredSize(dim);
            wilayahKabupatenView.setVisible(true);
            getjDesktopPane1().add(wilayahKabupatenView);
        }
        wilayahKabupatenView.requestFocusInWindow();
        wilayahKabupatenView.toFront();
	}
	@Override
	public void menuItem_MasterWilayahKecamatan_ActionPerformed(ActionEvent evt) {
        if (wilayahKecamatanView ==null) wilayahKecamatanView = new WilayahKecamatanView();
        if (! wilayahKecamatanView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            wilayahKecamatanView.setPreferredSize(dim);
            wilayahKecamatanView.setVisible(true);
            getjDesktopPane1().add(wilayahKecamatanView);
        }
        wilayahKecamatanView.requestFocusInWindow();
        wilayahKecamatanView.toFront();
	}
	@Override
	public void menuItem_MasterWilayahDesa_ActionPerformed(ActionEvent evt) {
        if (wilayahDesaView ==null) wilayahDesaView = new WilayahDesaView();
        if (! wilayahDesaView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            wilayahDesaView.setPreferredSize(dim);
            wilayahDesaView.setVisible(true);
            getjDesktopPane1().add(wilayahDesaView);
        }
        wilayahDesaView.requestFocusInWindow();
        wilayahDesaView.toFront();
	}
	@Override
	public void menuItem_MasterPemerintahanPemProv_ActionPerformed(ActionEvent evt) {
        if (pemerintahanPempropView ==null) pemerintahanPempropView = new PemerintahanPempropView();
        if (! pemerintahanPempropView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            pemerintahanPempropView.setPreferredSize(dim);
            pemerintahanPempropView.setVisible(true);
            getjDesktopPane1().add(pemerintahanPempropView);
        }
        pemerintahanPempropView.requestFocusInWindow();
        pemerintahanPempropView.toFront();
	}
	@Override
	public void menuItem_MasterPemerintahanPemDa_ActionPerformed(ActionEvent evt) {
        if (pemerintahanPemdaView ==null) pemerintahanPemdaView = new PemerintahanPemdaView();
        if (! pemerintahanPemdaView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            pemerintahanPemdaView.setPreferredSize(dim);
            pemerintahanPemdaView.setVisible(true);
            getjDesktopPane1().add(pemerintahanPemdaView);
        }
        pemerintahanPemdaView.requestFocusInWindow();
        pemerintahanPemdaView.toFront();
	}
	@Override
	public void menuItem_MasterPemerintahanSatker_ActionPerformed(ActionEvent evt) {
        if (pemerintahanSatkerView ==null) pemerintahanSatkerView = new PemerintahanSatkerView();
        if (! pemerintahanSatkerView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            pemerintahanSatkerView.setPreferredSize(dim);
            pemerintahanSatkerView.setVisible(true);
            getjDesktopPane1().add(pemerintahanSatkerView);
        }
        pemerintahanSatkerView.requestFocusInWindow();
        pemerintahanSatkerView.toFront();
	}
	@Override
	public void menuItem_MasterPemerintahanUnitKerja_ActionPerformed(ActionEvent evt) {
        if (pemerintahanUnitKerjaView ==null) pemerintahanUnitKerjaView = new PemerintahanUnitKerjaView();
        if (! pemerintahanUnitKerjaView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            pemerintahanUnitKerjaView.setPreferredSize(dim);
            pemerintahanUnitKerjaView.setVisible(true);
            getjDesktopPane1().add(pemerintahanUnitKerjaView);
        }
        pemerintahanUnitKerjaView.requestFocusInWindow();
        pemerintahanUnitKerjaView.toFront();
	}

    
    
}
