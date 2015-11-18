package org.lpee.testPFA.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class TypeDocument implements Serializable{
	@Id
	private String ref;
	private String intituleTypeDoc;
	@Temporal(TemporalType.DATE)
	private Date dateMAJ;
	private Long indice;

	@OneToMany(mappedBy="typeDocument",cascade=CascadeType.REMOVE)
	private Collection<Document> documents;
	@OneToMany(mappedBy="typeDocument",cascade=CascadeType.REMOVE)
	private  Collection<FicheAnomalie> ficheAnomalies;
	@ManyToOne
	@JoinColumn(name="IDCATEGORIE")
	private Categorie categorie;
	public  Collection<Document> getDocuments() {
		return documents;
	}
	public void setDocuments( Collection<Document> documents) {
		this.documents = documents;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public TypeDocument() {
		super();
		this.dateMAJ = new Date();
		this.indice = 0l;
	}
	public TypeDocument(String ref, String intituleTypeDoc, Date dateMAJ,
			Long indice) {
		super();
		this.ref = ref;
		this.intituleTypeDoc = intituleTypeDoc;
		this.dateMAJ = new Date();
		this.indice = 0l;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getIntituleTypeDoc() {
		return intituleTypeDoc;
	}
	public void setIntituleTypeDoc(String intituleTypeDoc) {
		this.intituleTypeDoc = intituleTypeDoc;
	}
	public Date getDateMAJ() {
		return dateMAJ;
	}
	public void setDateMAJ(Date dateMAJ) {
		this.dateMAJ = dateMAJ;
	}
	public Long getIndice() {
		return indice;
	}
	public void setIndice(Long indice) {
		this.indice = indice;
	}
	public  Collection<FicheAnomalie> getFicheAnomalies() {
		return ficheAnomalies;
	}
	public void setFicheAnomalies( Collection<FicheAnomalie> ficheAnomalies) {
		this.ficheAnomalies = ficheAnomalies;
	}
	
	

}
