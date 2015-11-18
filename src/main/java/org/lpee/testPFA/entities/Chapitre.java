package org.lpee.testPFA.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Chapitre implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numChapitre;
	private String designation;
	@OneToMany(mappedBy="chapitre",cascade=CascadeType.ALL)
	private Collection<FicheAnomalie> ficheAnomalies;
	public Chapitre(String designation) {
		super();
		this.designation = designation;
	}
	
	public Chapitre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNumChapitre() {
		return numChapitre;
	}
	public void setNumChapitre(Long numChapitre) {
		this.numChapitre = numChapitre;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Collection<FicheAnomalie> getFicheAnomalies() {
		return ficheAnomalies;
	}
	public void setFicheAnomalies(Collection<FicheAnomalie> ficheAnomalies) {
		this.ficheAnomalies = ficheAnomalies;
	}
	
	
	

}
