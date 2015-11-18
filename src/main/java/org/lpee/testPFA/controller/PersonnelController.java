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


@ManagedBean(name="personnelController")

@SessionScoped
@Component
public class PersonnelController  implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	
	
	private static final long serialVersionUID = 1L;
	private  List<Personnel> listePersonnels;
	
	private Personnel selected=new Personnel();
	
	public PersonnelController()
	{
	} 
	public void ajoutEventP(ActionEvent actionEvent) {
		selected=new Personnel();
		//cb.ajoutEvent(actionEvent);

	}
	public List<Personnel> listPersonnel()
	{
		listePersonnels=new ArrayList<Personnel>();
		listePersonnels.addAll((List<Personnel>)docMetier.getPersonnel());
		return listePersonnels;
	}
    public String prepareCreate()
    {
    	selected=new Personnel();
    	return "Createper";
    }
	public String create()
	{
		docMetier.addPersonnel(selected);
		return "Listper";
	}
	public String edit()
	{
		docMetier.upadatePersonnel(selected);
		return "Listper";
	}
	public String prepareEdite()
	{
		
		return "Editper"; 
	}
	
	public void delete()
	{
	
		docMetier.deletePersonnel(selected);
		
	}
	public Personnel getSelected() {
	        return selected;
	    }

	    public void setSelected(Personnel selected) {
	        this.selected = selected;
	    }
	public List<Personnel> getListePersonnel() {
		return listePersonnels;
	}
	public void setListePersonnel(List<Personnel> listePersonnels) {
		this.listePersonnels = listePersonnels;
	}

	public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}

	public List<SelectItem> listPersonnelSelect() {
	    List<SelectItem> mesElements=new ArrayList<SelectItem>();
	    listePersonnels= docMetier.getPersonnel();
		for (Personnel obj : listePersonnels) {
	           mesElements.add(new SelectItem(obj.getMatricule(),obj.getNom()+" "+obj.getPrenom()));
	     }
		
		return mesElements;
	}



}

