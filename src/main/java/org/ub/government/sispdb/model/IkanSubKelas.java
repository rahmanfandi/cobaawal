package org.ub.government.sispdb.model;



import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="ikan_subkelas")
public class IkanSubKelas {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@Column(name="KODE1", length=15)
	private String kode1;
	@Column(name="KODE2", length=20)
	private String kode2;
	
	@Column(name="DESCRIPTION", length=100)
	private String description;
	@Column(name="NOTES", length=350)
	private String notes;
	
	@OneToMany(mappedBy="ikanSubKelasBean", fetch=FetchType.LAZY)	
	@Fetch(FetchMode.JOIN)
	private Set<IkanJenis> ikanJenisSet;
	
	@Column(name="STATUS_ACTIVE")
	private boolean statusActive = true;

	@Column(name="CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();
	@Column(name="LAST_MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified = new Date();
	@Column(name="MODIFIED_BY", length=20) 
	private String modifiedBy = "";
	
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
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Set<IkanJenis> getIkanJenisSet() {
		return ikanJenisSet;
	}
	public void setIkanJenisSet(Set<IkanJenis> ikanJenisSet) {
		this.ikanJenisSet = ikanJenisSet;
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
		IkanSubKelas other = (IkanSubKelas) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IkanSubKelas [ID=" + ID + ", kode1=" + kode1 + "]";
	}

	
}