package org.lpee.testPFA.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Origine")
public class Origine implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrigine;
	private String libelleOrigine;
	@OneToMany(mappedBy="origine",cascade=CascadeType.ALL)
	private Collection<FicheAnomalie> ficheanomalie;
	public Collection<FicheAnomalie> getFicheanomalie() {
		return ficheanomalie;
	}
	public void setFicheanomalie(Collection<FicheAnomalie> ficheanomalie) {
		this.ficheanomalie = ficheanomalie;
	}
	public Long getIdOrigine() {
		return idOrigine;
	}
	public void setIdOrigine(Long idOrigine) {
		this.idOrigine = idOrigine;
	}
	public String getLibelleOrigine() {
		return libelleOrigine;
	}
	public void setLibelleOrigine(String libelleOrigine) {
		this.libelleOrigine = libelleOrigine;
	}
	public Origine() {
		super();

	}
	public Origine( String libelleOrigine) {
		super();

		this.libelleOrigine = libelleOrigine;
	}
	
}
