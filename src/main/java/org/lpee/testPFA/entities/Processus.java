package org.lpee.testPFA.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Processus implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String intitule;
	@OneToMany(mappedBy="processus",cascade=CascadeType.ALL)
	private Collection<FicheAnomalie> ficheAnomalies;
	@OneToMany(mappedBy="processus",cascade=CascadeType.ALL)
	private Collection<Document> documents;
	public Processus() {
		super();
	}
	public Processus(String intitule) {
		super();
		this.intitule = intitule;
	}
	
	public Collection<FicheAnomalie> getFicheAnomalies() {
		return ficheAnomalies;
	}
	public void setFicheAnomalies(Collection<FicheAnomalie> ficheAnomalies) {
		this.ficheAnomalies = ficheAnomalies;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Collection<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}
	
	

}
