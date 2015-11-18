
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


@ManagedBean(name="origineController")

@SessionScoped
@Component
public class OrigineController  implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	
	
	private static final long serialVersionUID = 1L;
	private  List<Origine> listeOrigines;
	
	private Origine selected=new Origine();
	
	public OrigineController()
	{
	} 
	public void ajoutEventO(ActionEvent actionEvent) {
		selected=new Origine();
		//cb.ajoutEvent(actionEvent);

	}
	public List<Origine> listOrigine()
	{
		listeOrigines=new ArrayList<Origine>();
		listeOrigines.addAll((List<Origine>)docMetier.getOrigines());
		return listeOrigines;
	}
    public String prepareCreate()
    {
    	selected=new Origine();
    	return "Createorigine";
    }
	public String create()
	{
		docMetier.addOrigine(selected);
		return "Listorigine";
	}
	public String edit()
	{
		docMetier.upadateOrigine(selected);
		return "Listorigine";
	}
	public String prepareEdite()
	{
		
		return "Editorigine"; 
	}
	public String redirectEdit()
	{
		return "Editorigine";
	}
	public void delete()
	{
	
		docMetier.deleteOrigine(selected);
		
	}
	public Origine getSelected() {
	        return selected;
	    }

	    public void setSelected(Origine selected) {
	        this.selected = selected;
	    }
	public List<Origine> getListeOrigine() {
		return listeOrigines;
	}
	public void setListeOrigine(List<Origine> listeOrigines) {
		this.listeOrigines = listeOrigines;
	}

	public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}


	 public List<SelectItem> listOrigineSelect() {
		    List<SelectItem> mesElements=new ArrayList<SelectItem>();
		    listeOrigines=new ArrayList<Origine>();
		    listeOrigines= docMetier.getOrigines();
			for (Origine obj : listeOrigines) {
		           mesElements.add(new SelectItem(obj.getIdOrigine(),obj.getLibelleOrigine()));
		     }
			
			return mesElements;
		}


}

