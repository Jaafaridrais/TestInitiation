package org.lpee.testPFA.entities;


import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Personnel {
	@Id
	private String matricule;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateEmbauche;
	private String diplome;
	private String grade;
	private String profile;
	private String motdePasse;
	
	@OneToMany(mappedBy="personnel",cascade=CascadeType.ALL)
	private Collection<FicheAnomalie> ficheAnomalies;
	
	@OneToMany(mappedBy="personnel",cascade=CascadeType.ALL)
	private Collection<document_personnel> documentpersonnels;
	
	public Collection<FicheAnomalie> getFicheAnomalies() {
		return ficheAnomalies;
	}
	public void setFicheAnomalies(Collection<FicheAnomalie> ficheAnomalies) {
		this.ficheAnomalies = ficheAnomalies;
	}
	public Personnel(String matricule, String nom, String prenom,
			Date dateEmbauche, String diplome, String grade) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.diplome = diplome;
		this.grade = grade;
	}
	public Personnel() {
		super();
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getMotdePasse() {
		return motdePasse;
	}
	public void setMotdePasse(String motdePasse) {
		this.motdePasse = motdePasse;
	}
	public Collection<document_personnel> getDocumentpersonnels() {
		return documentpersonnels;
	}
	public void setDocumentpersonnels(
			Collection<document_personnel> documentpersonnels) {
		this.documentpersonnels = documentpersonnels;
	}
	

}
