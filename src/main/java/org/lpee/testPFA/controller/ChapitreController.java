package org.lpee.testPFA.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.lpee.testPFA.entities.Chapitre;
import org.lpee.testPFA.metier.IDocumentmetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@ManagedBean(name="chapitreController")

@SessionScoped
@Component
public class ChapitreController implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	
	
	private static final long serialVersionUID = 1L;
	private  List<Chapitre> listechapitres;
	
	private Chapitre selected=new Chapitre();
	
	public ChapitreController()
	{
	} 
	public void ajoutEventC(ActionEvent actionEvent) {
		selected=new Chapitre();
		//cb.ajoutEvent(actionEvent);

	}
	public List<Chapitre> listChapitre()
	{
		listechapitres=new ArrayList<Chapitre>();
		listechapitres.addAll((List<Chapitre>)docMetier.getChapitres());
		return listechapitres;
	}
    public String prepareCreate()
    {
    	selected=new Chapitre();
    	return "CreateCh";
    }
	public String create()
	{
		docMetier.addChapitre(selected);
		return "ListCh";
	}
	public String edit()
	{
		docMetier.updateChapitre(selected);
		return "ListCh";
	}
	public String prepareEdite()
	{
		
		return"EditCh"; 
	}
	public String redirectEdit()
	{
		return "EditCh";
	}
	public void delete()
	{
	
		
		docMetier.deleteChapitre(selected);
		
	}
	public Chapitre getSelected() {
	        return selected;
	    }

	    public void setSelected(Chapitre selected) {
	        this.selected = selected;
	    }
	public List<Chapitre> getListechapitres() {
		return listechapitres;
	}
	public void setListechapitres(List<Chapitre> listechapitres) {
		this.listechapitres = listechapitres;
	}

	public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}

	 public List<SelectItem> listChapitreSelect() {
		    List<SelectItem> mesElements=new ArrayList<SelectItem>();
		    listechapitres=new ArrayList<Chapitre>();
		    listechapitres= docMetier.getChapitres();
			for (Chapitre obj : listechapitres) {
		           mesElements.add(new SelectItem(obj.getNumChapitre(),obj.getDesignation()));
		     }
			
			return mesElements;
		}


}
