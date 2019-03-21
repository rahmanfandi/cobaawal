package org.ub.government.sispdb.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="upt")
public class Upt {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@ManyToOne
	@JoinColumn(name="unitKerjaBean", referencedColumnName="ID")
	private UnitKerja unitKerjaBean;
	
	@ManyToOne
	@JoinColumn(name="tabulatorEnumeratorBean", referencedColumnName="ID")
	private TabulatorEnumerator tabulatorEnumeratorBean;
	
	@ManyToOne
	@JoinColumn(name="jenisPerairanBean", referencedColumnName="ID")
	private JenisPerairan jenisPerairanBean;
	
	@ManyToOne
	@JoinColumn(name="desaBean", referencedColumnName="ID")
	private Desa desaBean;
	
	@OneToMany(mappedBy="uptBean", fetch=FetchType.LAZY)	
	@Fetch(FetchMode.JOIN)
	private Set<Tangkaph> tangkaphSet;


	@Column(name="KODE1", length=15)
	private String kode1;
	@Column(name="KODE2", length=20)
	private String kode2;
	@Column(name="DESCRIPTION", length=100)
	private String description;

	@Column(name="ADDRESS1", length=120)
	private String address1;
	
	@Column(name="STATUS_ACTIVE")
	private boolean statusActive = true;

	/*
	 * ADA YANG UPT DAN ADA UPTNYA YANG TIDAK
	 * JIka bukan UPT makan Alamat Non Aktif
	 */
	@Column(name="UPT")
	private boolean upt = true;
	
	@Column(name="CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name="LAST_MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	@Column(name="MODIFIED_BY", length=20) 
	private String modifiedBy;
	
	
	
	
	public boolean isStatusActive() {
		return statusActive;
	}


	public void setStatusActive(boolean statusActive) {
		this.statusActive = statusActive;
	}


	public int getID() {
		return ID;
	}
	
	
	public void setID(int iD) {
		ID = iD;
	}
	public UnitKerja getUnitKerjaBean() {
		return unitKerjaBean;
	}
	public void setUnitKerjaBean(UnitKerja unitKerjaBean) {
		this.unitKerjaBean = unitKerjaBean;
	}
	public TabulatorEnumerator getTabulatorEnumeratorBean() {
		return tabulatorEnumeratorBean;
	}
	public void setTabulatorEnumeratorBean(TabulatorEnumerator tabulatorEnumeratorBean) {
		this.tabulatorEnumeratorBean = tabulatorEnumeratorBean;
	}
	public JenisPerairan getJenisPerairanBean() {
		return jenisPerairanBean;
	}
	public void setJenisPerairanBean(JenisPerairan jenisPerairanBean) {
		this.jenisPerairanBean = jenisPerairanBean;
	}
	public Desa getDesaBean() {
		return desaBean;
	}
	public void setDesaBean(Desa desaBean) {
		this.desaBean = desaBean;
	}
	public Set<Tangkaph> getTangkaphSet() {
		return tangkaphSet;
	}
	public void setTangkaphSet(Set<Tangkaph> tangkaphSet) {
		this.tangkaphSet = tangkaphSet;
	}
	public String getKode1() {
		return kode1;
	}
	public void setKode1(String kode1) {
		this.kode1 = kode1;
	}
	public String getKode2() {
		return kode2;
	}
	public void setKode2(String kode2) {
		this.kode2 = kode2;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public boolean isUpt() {
		return upt;
	}


	public void setUpt(boolean upt) {
		this.upt = upt;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Upt other = (Upt) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Upt [ID=" + ID + ", kode1=" + kode1 + "]";
	}

	
}