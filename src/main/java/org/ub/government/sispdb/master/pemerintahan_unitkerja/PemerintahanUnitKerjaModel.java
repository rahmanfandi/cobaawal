package org.ub.government.sispdb.master.pemerintahan_unitkerja;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ub.government.sispdb.commons.CommonLogHelper;
import org.ub.government.sispdb.model.Kabupaten;
import org.ub.government.sispdb.model.Kabupaten;
import org.ub.government.sispdb.model.Kabupaten;
import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Propinsi;
import org.ub.government.sispdb.model.TabulatorEnumerator;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.jpaservice.IkanJenisJpaService;
import org.ub.government.sispdb.model.jpaservice.IkanJenisJpaServiceImpl;
import org.ub.government.sispdb.model.jpaservice.IkanSubKelasJpaService;
import org.ub.government.sispdb.model.jpaservice.IkanSubKelasJpaServiceImpl;
import org.ub.government.sispdb.model.jpaservice.KabupatenJpaService;
import org.ub.government.sispdb.model.jpaservice.KabupatenJpaServiceImpl;
import org.ub.government.sispdb.model.jpaservice.PropinsiJpaService;
import org.ub.government.sispdb.model.jpaservice.PropinsiJpaServiceImpl;
import org.ub.government.sispdb.model.jpaservice.SysvarJpaService;
import org.ub.government.sispdb.model.jpaservice.SysvarJpaServiceImpl;
import org.ub.government.sispdb.model.jpaservice.TabulatorEnumeratorJpaService;
import org.ub.government.sispdb.model.jpaservice.UnitKerjaJpaService;
import org.ub.government.sispdb.model.jpaservice.UnitKerjaJpaServiceImpl;
import org.ub.government.sispdb.model.jpaservice.UserLogJpaService;
import org.ub.government.sispdb.model_enum.EnumOrganizationLevel;
import org.ub.government.sispdb.model_enum.EnumStatusOperasiForm;
import org.ub.government.sispdb.model_table.ComboBoxModel_IkanSubKelas;
import org.ub.government.sispdb.model_table.TableModel_WilayahKabupaten;
import org.ub.government.sispdb.model_table.TableModel_WilayahKabupaten;


public class PemerintahanUnitKerjaModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//1. DAO SERVICE: Utama
	protected SysvarJpaService sysvarJpaService;
	protected KabupatenJpaService kabupatenJpaService;
	
	private PropinsiJpaService propinsiJpaService;
	
	//1.2 Dao Service Pembantu: ComboBox dll
	protected UnitKerjaJpaService unitKerjaJpaService;
	
	//2. ENTITY: 
	/*
	 * Header Opsional/Pembantu untuk Vaadin 8
	 * digunakan untuk update data jpa. Ingat-ingat sifat JPA
	 */
	protected Kabupaten itemHeader = new Kabupaten();

	protected TabulatorEnumerator userActive = new TabulatorEnumerator();	 //TABULATOR SEPERTI HALNYA USER
	
	/*
	 * 3. LIST Utama: Detil ada jika form transaksi -> Diganti set untuk menghindari inkonsitensi
	 * Set mempunyai method LEBIH SEDIKIT dibanding List. ex.Method objek.get(i) tidak ada
	 */
	protected Map<Integer, Kabupaten> listHeader = new HashMap<>();
	protected TableModel_WilayahKabupaten tableModelHeader = new TableModel_WilayahKabupaten(new ArrayList<>());
	protected ComboBoxModel_IkanSubKelas comboModel_Group2 = null;
	
//		Set List<FtSalesd> listDetil = new ArrayList<FtSalesd>();

	//3.2 LIST Pembantu: ComboBox dll
	protected Set<UnitKerja> listGrup0 = new HashSet<UnitKerja>();
	protected List<Propinsi> listGrup1 = new ArrayList<Propinsi>();
				
	//4. Variable Others: Utama dan Pendukung
//	protected String statusOperasiForm = "OPEN"; //Form Baru ini tidak Pakai
	protected EnumStatusOperasiForm statusOperasiForm = EnumStatusOperasiForm.OPEN;
	protected boolean kodeBolehSama = false;
	//4.2 Log Sistem
	protected UserLogJpaService logSistemJpaService;		
	protected TabulatorEnumeratorJpaService userJpaService;
	protected boolean aktifkanPerekamanSistem =  true;
	protected String remoteHostInfo = "";
	
	public PemerintahanUnitKerjaModel(){
		initVariable();
		initVariableData();
	}
	
	public void initVariable(){
		sysvarJpaService = new SysvarJpaServiceImpl();
		kabupatenJpaService = new KabupatenJpaServiceImpl();
		
		propinsiJpaService = new PropinsiJpaServiceImpl();
		
		unitKerjaJpaService = new UnitKerjaJpaServiceImpl();
		userActive = new TabulatorEnumerator();
		remoteHostInfo = "lokal"; 
		//Sudah Dihindari tapi tidak isa untuk pisah dari Komponen View
//		setSysvarJpaService((((DashboardUI) getUI().getCurrent()).getSysvarJpaService()));
//		setfAreaJpaService((((DashboardUI) getUI().getCurrent()).getfAreaJpaService()));
//		fRegionJpaService  =((DashboardUI) getUI().getCurrent()).getfRegionJpaService();
//		fDivisionJpaService =((DashboardUI) getUI().getCurrent()).getfDivisionJpaService();
//	
//		userJpaService = (((DashboardUI) getUI().getCurrent()).getUserJpaService());
//		setLogSistemJpaService((((DashboardUI) getUI().getCurrent()).getUserLogJpaService()));		
//
//		userActive = ((DashboardUI) getUI().getCurrent()).getUserActive();
//		remoteHostInfo= ((DashboardUI) getUI().getCurrent()).getRemoteHostInfo();
		
	}
	public void initVariableData(){
		reloadListHeader();
		reloadListOthers();		
	}
	
	public void saveToDatabase() {
		/*
		 * Digunakan untuk AddNew dan Update(Edit)
		 * - Jika Header ID=0 maka Berarti NewForm
		 */
		if (itemHeader.getID()==0) { //Berarti New
			itemHeader.setCreated(new Date());
			itemHeader.setLastModified(new Date());
					
			itemHeader.setModifiedBy(userActive.getUserID());
			
			kabupatenJpaService.createObject(itemHeader);
			listHeader.put(itemHeader.getID(), itemHeader);
			
			CommonLogHelper.createLogCommon(userJpaService, logSistemJpaService)
				.setUserBean(userActive)
				.setOperasi("Create New: Screen " + this.getClass().getSimpleName() + ": " + itemHeader.getKode1() + " >> " + remoteHostInfo)
				.writeWithThread();
			
		}else { //Berarti edit
			itemHeader.setLastModified(new Date());
			itemHeader.setModifiedBy(userActive.getUserID());
			
			kabupatenJpaService.updateObject(itemHeader);
			
			CommonLogHelper.createLogCommon(userJpaService, logSistemJpaService)
				.setUserBean(userActive)
				.setOperasi("Update: Screen " + this.getClass().getSimpleName() + ": " + itemHeader.getKode1() + " >> " + remoteHostInfo)
				.writeWithThread();
			
		}		
	}
	public void deleteFromDatabase(Kabupaten domain_NullIfSingleDelete) {
		if (domain_NullIfSingleDelete==null) {
			kabupatenJpaService.removeObject(itemHeader);
			
			CommonLogHelper.createLogCommon(userJpaService, logSistemJpaService)
				.setUserBean(userActive)
				.setOperasi("Delete Single: Screen " + this.getClass().getSimpleName() + ": " + itemHeader.getKode1() + " >> " + remoteHostInfo)
				.writeWithThread();
			
		}else {
			kabupatenJpaService.removeObject(domain_NullIfSingleDelete);
			
			CommonLogHelper.createLogCommon(userJpaService, logSistemJpaService)
				.setUserBean(userActive)
				.setOperasi("Delete Multi: Screen " + this.getClass().getSimpleName() + ": " + domain_NullIfSingleDelete.getKode1() + " >> " + remoteHostInfo)
				.writeWithThread();
			
		}
		
	}
	
	public Kabupaten isKodeSudahAdaPerCompany(String kodeToCek, PemProv fcompanyBean) {
		/*
		 * NOTES: SubKelasIkan Sama semua
		 */
//		Kabupaten returnValue = new Kabupaten();
		Kabupaten returnValue = null;
		List<Kabupaten> listToFind = kabupatenJpaService.findAllByField("kode1", kodeToCek.trim(), null);
		
		for (Kabupaten domain: listToFind) {
			try {
//				if (domain.getFdivisionBean().getFcompanyBean().equals(fcompanyBean) ) {
					returnValue = new Kabupaten();
					returnValue = domain;
					break;
//				}
			}catch (Exception e) {
			}
		}
		return returnValue;
	}
	
	
	public void reloadListHeader(){
		try {
			Set<Kabupaten> list = new HashSet<>();
			//Untuk jenis ikan tidak, berlaku kode sama dengan semua jadi tidak ada user Organization Level
//			if (userActive.getOrganizationLevel().equals(EnumOrganizationLevel.PEMPROP)) {			
//				list = new HashSet<Kabupaten>(ikanSubKelasJpaService.findAllByDivisionAndShareToCompany(userActive.getUnitKerjaBean().ge, false));
//				
//			}else if (userActive.getOrganizationLevel().equals(EnumOrganizationLevel.PEMDA)) {
//				list = new HashSet<Kabupaten>(ikanSubKelasJpaService.findAllByCompanyOnly(userActive.getUnitKerjaBean().getFcompanyBean().getID(), false));
//				
//			}else if (userActive.getOrganizationLevel().equals(EnumOrganizationLevel.SATKER)) {
//				list = new HashSet<Kabupaten>(ikanSubKelasJpaService.findAllByCompanyOnly(userActive.getUnitKerjaBean().getFcompanyBean().getID(), false));
			
//			} else {
				list = new HashSet<Kabupaten>(kabupatenJpaService.findAll());
//			}
			for (Kabupaten domain: list) listHeader.put(domain.getID(), domain);
			
		}catch (Exception e) {
		}
		
	}
	public void reloadListHeaderWithCriteria(Kabupaten domainCriteria){
		reloadListHeader();
		
//		Set<Kabupaten> listTemp = new HashSet<Kabupaten>(listHeader);
//		listHeader = new HashSet<Kabupaten>();
//		for (Kabupaten domain: listTemp) {
//			if (		//Jika kosong maka dianggep 
//					domain.getKode1().trim().toUpperCase().contains(domainCriteria.getKode1().trim().toUpperCase())
//					&&
//					domain.getDescription().trim().toUpperCase().contains(domainCriteria.getDescription().trim().toUpperCase())
//					) {
//				
//				listHeader.add(domain);
//				
//			}
//		}
		
	}
	
	public void reloadListDetil(long id){
		long idToFind = id;
		if (id==0){
			idToFind = itemHeader.getID();
		}
		
//		//1. AMBIL DETIL DENGAN MENGGUNAKAN KODE HEADER
//		List<FtSalesd> listDetilById = new ArrayList<FSkpd>(getFtDcvdJpaService().findAllByIdHeader(idToFind));
//		
//		//2. PERBAIKI CONTENT TRANSIENT
//		listDetil = new ArrayList<FtSalesd>();
//		listDetil = helper.updateAndCalculateItemDetilFromList(listDetilById);
		
//		//4. MASUKKAN KE DALAM LIST:: tidak perlu di Vaadin 8
//		getTableDetil().refreshRowCache();
	}

	public void reloadListOthers(){
		try {
			if (userActive.getOrganizationLevel().equals(EnumOrganizationLevel.PEMPROP) ) {
				listGrup0 = new HashSet<UnitKerja>(unitKerjaJpaService.findAllByPemProvOnly(userActive.getUnitKerjaBean().getSatuanKerjaBean().getPemdaBean().getPemProvBean() ));
//				listGrup10 = new HashSet<FRegion>(fRegionJpaService.findAllByDivisionAndShareToCompany(userActive.getFdivisionBean(), true));
			}else if (userActive.getOrganizationLevel().equals(EnumOrganizationLevel.PEMDA) ) {
				listGrup0 = new HashSet<UnitKerja>(unitKerjaJpaService.findAllByPemdaOnly(userActive.getUnitKerjaBean().getSatuanKerjaBean().getPemdaBean() ));
				
			}else if (userActive.getOrganizationLevel().equals(EnumOrganizationLevel.SATKER) ) {
				listGrup0 = new HashSet<UnitKerja>(unitKerjaJpaService.findAllBySatuanKerjaOnly(userActive.getUnitKerjaBean().getSatuanKerjaBean() ));
//				listGrup10 = new HashSet<FRegion>(fRegionJpaService.findAll());
			} else {
				listGrup0 = new HashSet<UnitKerja>(unitKerjaJpaService.findAll());
				
			}
		}catch (Exception e) {
		}
		
		listGrup1 = propinsiJpaService.findAll();
		
	}
	public void resetNewObject_Header(){
		itemHeader = new Kabupaten();
		itemHeader.setKode1("");
//		itemHeader.setStatusActive(true);
	}
	public void resetDetil(){
//		itemDetil = new FtSalesd();
//		itemDetil.setFtSaleshBean(itemHeader);
	}
	public int getNomorUrutDetilNext(){
		/*
		 * Untuk Nomer Urut transaksi detil. ex. Pembelian, Penjualan, Transfer Gudang, Stok Opname
		 */
		int nextNomorUrut = 0;
//		for (FSkpd domainDetil: listDetil){
//			if (domainDetil.getNourut() >nextNomorUrut) {
//				nextNomorUrut = domainDetil.getNourut();
//			}
//		}
		
		return nextNomorUrut+1;
	}
	
	

}
