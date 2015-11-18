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
public class Categorie implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	private String libelleCategorie;
	@OneToMany(mappedBy="categorie",cascade=CascadeType.REMOVE)
	private Collection<TypeDocument> typeDocuments;
	public Categorie( String libelleCategorie) {
		super();

		this.libelleCategorie = libelleCategorie;
	}
	public Categorie() {
		super();
	}
	
	public Collection<TypeDocument> getTypeDocuments() {
		return typeDocuments;
	}
	public void setTypeDocuments(Collection<TypeDocument> typeDocuments) {
		this.typeDocuments = typeDocuments;
	}
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLibelleCategorie() {
		return libelleCategorie;
	}
	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}

	

}
