package org.lpee.testPFA.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ArchiveDocument  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String chemin;
	@Temporal(TemporalType.DATE)
	private Date dateArchivate;
	@ManyToOne
	@JoinColumn(name="IDdoc")
	private Document document;
	public ArchiveDocument() {
		super();
		this.dateArchivate = new Date();
		// TODO Auto-generated constructor stub
	}

	
	

	public ArchiveDocument(String chemin,  Document document) {
		super();
		this.chemin = chemin;
		this.dateArchivate = new Date();
		this.document = document;
	}




	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDateArchivate() {
		return dateArchivate;
	}
	public void setDateArchivate(Date dateArchivate) {
		this.dateArchivate = dateArchivate;
	}




	public String getChemin() {
		return chemin;
	}




	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	
	
	

}
