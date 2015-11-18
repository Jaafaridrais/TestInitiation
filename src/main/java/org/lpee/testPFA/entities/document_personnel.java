package org.lpee.testPFA.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: document_personnel
 *
 */
@Entity

public class document_personnel implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="IDdoc")
	private Document document;
	@ManyToOne
	@JoinColumn(name="IDper")
	private Personnel personnel;
	public document_personnel() {
		super();
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
   
}
