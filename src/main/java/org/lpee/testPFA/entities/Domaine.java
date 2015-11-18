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
public class Domaine implements Serializable{
    /**
	 * 
	 */
	


	public Domaine() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
	private Long id;
	private String libelle;
	@OneToMany(mappedBy="domaine",cascade=CascadeType.ALL)
	private Collection<FicheAnomalie> ficheAnomalies;
	
	
	public Domaine(Long id ,String libelle) {
	this.id=id;
		this.libelle = libelle;
	}
	public Domaine(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Long getIdDomaine() {
		return id;
	}
	public void setIdDomaine(Long idDomaine) {
		this.id = idDomaine;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<FicheAnomalie> getFicheAnomalies() {
		return ficheAnomalies;
	}
	public void setFicheAnomalies(Collection<FicheAnomalie> ficheAnomalies) {
		this.ficheAnomalies = ficheAnomalies;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
