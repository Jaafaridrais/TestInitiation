package org.lpee.testPFA.entities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import javax.management.RuntimeErrorException;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Access(AccessType.FIELD)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Document implements Serializable {
	@Id
	 private String refDoc;
	 private Integer indiceDoc;
	 private String intituleDoc;
	 private String chemin;
	 @Temporal(TemporalType.DATE)
	 private Date dateApplication; 
	 private String documentRatachement;
	 private String methodeEssai;
	 @Temporal(TemporalType.DATE)
	 private Date dateHomologation;
	 private Boolean acredite;
	 @ManyToOne
	 @JoinColumn(name=("REF"))
	 private TypeDocument typeDocument;
	 @ManyToOne
	 @JoinColumn(name=("IDProcessus"))
	 private Processus processus;
	 @OneToMany(mappedBy="document")
	 private Collection<ArchiveDocument> archivedocuments;
	 @OneToMany(mappedBy="document")
	 private Collection<document_personnel> documentpersonnels;
	public TypeDocument getTypeDocument() {
		return typeDocument;
	}
   




	public Collection<ArchiveDocument> getArchivedocuments() {
		return archivedocuments;
	}





	public void setArchivedocuments(Collection<ArchiveDocument> archivedocuments) {
		this.archivedocuments = archivedocuments;
	}





	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}

	

	public void setIndiceDoc(Integer indiceDoc) {
		this.indiceDoc = indiceDoc;
	}

	public TypeDocument getTD() {
		return typeDocument;
	}

	public void setTD(TypeDocument tD) {
		typeDocument = tD;
	}

	public Document() {
		super();
		this.indiceDoc = 0;
		this.dateApplication = new Date();
	}


	public Document(String refDoc, Integer indiceDoc, String intituleDoc,
			String chemin, Date dateApplication, String documentRatachement,
			String methodeEssai, Date dateHomologation, Boolean acredite) {
		super();
		this.refDoc = refDoc;
		this.indiceDoc = indiceDoc;
		this.intituleDoc = intituleDoc;
		this.chemin = chemin;
		this.dateApplication = dateApplication;
		this.documentRatachement = documentRatachement;
		this.methodeEssai = methodeEssai;
		this.dateHomologation = dateHomologation;
		this.acredite = acredite;
	}










	public String getRefDoc() {
		return refDoc;
	}
	public void setRefDoc(String refDoc) {
		this.refDoc = refDoc;
	}
	public int getIndiceDoc() {
		return indiceDoc;
	}
	public void setIndiceDoc(int indiceDoc) {
		this.indiceDoc = indiceDoc;
	}
	public String getIntituleDoc() {
		return intituleDoc;
	}
	public void setIntituleDoc(String intituleDoc) {
		this.intituleDoc = intituleDoc;
	}
	public Date getDateApplication() {
		return dateApplication;
	}
	public void setDateApplication(Date dateApplication) {
		this.dateApplication = dateApplication;
	}
	public String getDocumentRatachement() {
		return documentRatachement;
	}
	public void setDocumentRatachement(String documentRatachement) {
		this.documentRatachement = documentRatachement;
	}

	public Processus getProcessus() {
		return processus;
	}

	public void setProcessus(Processus processus) {
		this.processus = processus;
	}





	public String getChemin() {
		return chemin;
	}





	public void setChemin(String chemin) {
		this.chemin = chemin;
	}





	public String getMethodeEssai() {
		return methodeEssai;
	}





	public void setMethodeEssai(String methodeEssai) {
		this.methodeEssai = methodeEssai;
	}





	public Date getDateHomologation() {
		return dateHomologation;
	}





	public void setDateHomologation(Date dateHomologation) {
		this.dateHomologation = dateHomologation;
	}





	public Boolean getAcredite() {
		return acredite;
	}





	public void setAcredite(Boolean acredite) {
		this.acredite = acredite;
	}





	public Collection<document_personnel> getDocumentpersonnels() {
		return documentpersonnels;
	}





	public void setDocumentpersonnels(
			Collection<document_personnel> documentpersonnels) {
		this.documentpersonnels = documentpersonnels;
	}
    

}
