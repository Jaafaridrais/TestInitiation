
package org.lpee.testPFA.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.lpee.testPFA.entities.*;
import org.lpee.testPFA.metier.IDocumentmetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@ManagedBean(name="typeDocController")

@SessionScoped
@Component
public class TypeDocController  implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	
	private Long id;
	
	private static final long serialVersionUID = 1L;
	private  List<TypeDocument> listeTypeDocument;
	private List<Document> listdocument;
	private TypeDocument selected=new TypeDocument();
	
	public TypeDocController()
	{
	} 
	public void ajoutEventP(ActionEvent actionEvent) {
		selected=new TypeDocument();
		//cb.ajoutEvent(actionEvent);

	}
	public List<Document> getListdocument() {
		return listdocument;
	}

	public void setListdocument(List<Document> listdocument) {
		this.listdocument = listdocument;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<TypeDocument> listTypeDocument()
	{
		listeTypeDocument=new ArrayList<TypeDocument>();
		listeTypeDocument.addAll((List<TypeDocument>)docMetier.getTypeDocument());
		return listeTypeDocument;
	}
    public String prepareCreate()
    {
    	
    	selected=new TypeDocument();
        return "Createtype";
    }
	public String create()
	{
		
		
		docMetier.addTypeDocument(selected,id);
		
		return "Listtype";
	}
	public String edit()
	{
		docMetier.upadateTypeDocument(selected);
		return "Listtype";
	}
	public String prepareEdite()
	{
		
		return"Edittype"; 
	}
	public String afficher()
	{
		listdocument=new ArrayList<Document>();
		listdocument.addAll((List<Document>)docMetier.getDocumentByType(selected.getRef()));
		
		return "listdocument"; 
	}
	public String redirectEdit()
	{
		return "Edittype";
	}
	public void supprimer()
	{
	
		docMetier.deleteTypeDocument(selected);
		
	}
	public void delete()
	{
		TypeDocument t=docMetier.getType("testt");
		docMetier.deleteTypeDocument(t);
		
	}
	public TypeDocument getSelected() {
	        return selected;
	    }

	    public void setSelected(TypeDocument selected) {
	        this.selected = selected;
	    }
	public List<TypeDocument> getListeTypeDocument() {
		return listeTypeDocument;
	}
	public void setListeTypeDocument(List<TypeDocument> listeTypeDocument) {
		this.listeTypeDocument = listeTypeDocument;
	}

	public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}
	
    
	 public List<SelectItem> listTypeDocumentSelect() {
		    List<SelectItem> mesElements=new ArrayList<SelectItem>();
		    listeTypeDocument= docMetier.getTypeDocument();
			for (TypeDocument obj : listeTypeDocument) {
		           mesElements.add(new SelectItem(obj.getRef(),obj.getIntituleTypeDoc()));
		     }
			
			return mesElements;
		}



}

