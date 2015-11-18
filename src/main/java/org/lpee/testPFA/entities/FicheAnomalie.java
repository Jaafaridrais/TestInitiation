package org.lpee.testPFA.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class FicheAnomalie implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numFiche;
	@Temporal(TemporalType.DATE)
	private Date dateFiche;
	private String constat;
	private String etatFiche;
	private Boolean appCurative;
	private Boolean appCorrective;
	@Temporal(TemporalType.DATE)
	private Date dateVerification;
	private String critereCurative;
	private String critereCorrective;
	private Boolean efficaciteCurative;
	private Boolean efficaciteCorrective;
	private String commentaire;
	private String risque;
	private String analyse;
	@ManyToOne
	@JoinColumn(name="IDORIGINE")
	private Origine origine;
	@ManyToOne
	@JoinColumn(name="NUMCHAPITRE")
	private Chapitre chapitre;
	@ManyToOne
	@JoinColumn(name="CODECURRATIVE")
	private ActionCorrective actionCorrective ;
	@ManyToOne
	@JoinColumn(name="IDACTION")
	private ActionCurative actionCurative ;
	@ManyToOne
	@JoinColumn(name=("IDProcessus"))
	private Processus processus;
	@ManyToOne
	@JoinColumn(name="IDDomaine")
	private Domaine domaine;
	@ManyToOne
	@JoinColumn(name="MATRICULE")
	private Personnel personnel;
	@ManyToOne
	@JoinColumn(name="REF")
	private TypeDocument typeDocument;
	
	
	

		public FicheAnomalie(Long numFiche, String constat,
			 Boolean appCurative, Boolean appCorrective,
			Date dateVerification, String critereCurative,
			String critereCorrective, Boolean efficaciteCurative,
			Boolean efficaciteCorrective, String commentaire, String risque,
			String analyse, Origine origine,Chapitre chapitre,  ActionCorrective actionCorrective,
			ActionCurative actionCurative, Processus processus,
			Domaine domaine, Personnel personnel, TypeDocument typeDocument) {
		super();
		this.numFiche = numFiche;
		this.dateFiche = new Date();
		this.constat = constat;
		this.etatFiche = "etat1";
		this.appCurative = appCurative;
		this.appCorrective = appCorrective;
		this.dateVerification = dateVerification;
		this.critereCurative = critereCurative;
		this.critereCorrective = critereCorrective;
		this.efficaciteCurative = efficaciteCurative;
		this.efficaciteCorrective = efficaciteCorrective;
		this.commentaire = commentaire;
		this.risque = risque;
		this.analyse = analyse;
		this.origine = origine;
		this.chapitre = chapitre;
		this.actionCorrective = actionCorrective;
		this.actionCurative = actionCurative;
		this.processus = processus;
		this.domaine = domaine;
		this.personnel = personnel;
		this.typeDocument = typeDocument;
	}
		
		


	public FicheAnomalie() {
		super();
		this.etatFiche = "etat1";
		this.dateFiche = new Date();
		// TODO Auto-generated constructor stub
	}
	
	public Long getNumFiche() {
		return numFiche;
	}
	public void setNumFiche(Long numFiche) {
		this.numFiche = numFiche;
	}
	public Date getDateFiche() {
		return dateFiche;
	}
	public void setDateFiche(Date dateFiche) {
		this.dateFiche = dateFiche;
	}
	public String getConstat() {
		return constat;
	}
	public void setConstat(String constat) {
		this.constat = constat;
	}
	public String getEtatFiche() {
		return etatFiche;
	}
	public void setEtatFiche(String etatFiche) {
		this.etatFiche = etatFiche;
	}
	public Boolean getAppCurative() {
		return appCurative;
	}
	public void setAppCurative(Boolean appCurative) {
		this.appCurative = appCurative;
	}
	public Boolean getAppCorrective() {
		return appCorrective;
	}
	public void setAppCorrective(Boolean appCorrective) {
		this.appCorrective = appCorrective;
	}
	public Date getDateVerification() {
		return dateVerification;
	}
	public void setDateVerification(Date dateVerification) {
		this.dateVerification = dateVerification;
	}
	public String getCritereCurative() {
		return critereCurative;
	}
	public void setCritereCurative(String critereCurative) {
		this.critereCurative = critereCurative;
	}
	public String getCritereCorrective() {
		return critereCorrective;
	}
	public void setCritereCorrective(String critereCorrective) {
		this.critereCorrective = critereCorrective;
	}
	public Boolean getEfficaciteCurative() {
		return efficaciteCurative;
	}
	public void setEfficaciteCurative(Boolean efficaciteCurative) {
		this.efficaciteCurative = efficaciteCurative;
	}
	public Boolean getEfficaciteCorrective() {
		return efficaciteCorrective;
	}
	public void setEfficaciteCorrective(Boolean efficaciteCorrective) {
		this.efficaciteCorrective = efficaciteCorrective;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Origine getOrigine() {
		return origine;
	}
	public void setOrigine(Origine origine) {
		this.origine = origine;
	}
	public ActionCorrective getActionCorrective() {
		return actionCorrective;
	}
	public void setActionCorrective(ActionCorrective actionCorrective) {
		this.actionCorrective = actionCorrective;
	}
	public ActionCurative getActionCurative() {
		return actionCurative;
	}
	public void setActionCurative(ActionCurative actionCurative) {
		this.actionCurative = actionCurative;
	}
	public Processus getProcessus() {
		return processus;
	}
	public void setProcessus(Processus processus) {
		this.processus = processus;
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public TypeDocument getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}
	public String getRisque() {
		return risque;
	}
	public void setRisque(String risque) {
		this.risque = risque;
	}
	public String getAnalyse() {
		return analyse;
	}
	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}

	public Chapitre getChapitre() {
		return chapitre;
	}

	public void setChapitre(Chapitre chapitre) {
		this.chapitre = chapitre;
	}

	

	

}
