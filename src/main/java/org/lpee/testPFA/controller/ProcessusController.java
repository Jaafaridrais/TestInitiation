package org.lpee.testPFA.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.lpee.testPFA.entities.Processus;
import org.lpee.testPFA.metier.IDocumentmetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@ManagedBean(name="processusController")

@SessionScoped
@Component
public class ProcessusController implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	
	
	private static final long serialVersionUID = 1L;
	private  List<Processus> listeProcessus;
	
	private Processus selected=new Processus();
	
	public ProcessusController()
	{
	} 
	public void ajoutEventP(ActionEvent actionEvent) {
		selected=new Processus();
		//cb.ajoutEvent(actionEvent);

	}
	public List<Processus> listProcessus()
	{
		listeProcessus=new ArrayList<Processus>();
		listeProcessus.addAll((List<Processus>)docMetier.getProcessus());
		return listeProcessus;
	}
    public String prepareCreate()
    {
    	selected=new Processus();
    	return "Createpro";
    }
	public String create()
	{
		docMetier.addProcessus(selected);
		return "Listpro";
	}
	public String edit()
	{
		docMetier.upadateProcessus(selected);
		return "Listpro";
	}
	public String prepareEdite()
	{
		
		return "Editpro"; 
	}
	public String redirectEdit()
	{
		return "Edit";
	}
	public void delete()
	{
		
		
		docMetier.deleteProcessus(selected);
		
	}
	public Processus getSelected() {
	        return selected;
	    }

	    public void setSelected(Processus selected) {
	        this.selected = selected;
	    }
	public List<Processus> getListeProcessus() {
		return listeProcessus;
	}
	public void setListeProcessus(List<Processus> listeProcessus) {
		this.listeProcessus = listeProcessus;
	}

	public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}

	 public List<SelectItem> listProcessusSelect() {
		    List<SelectItem> mesElements=new ArrayList<SelectItem>();
		    listeProcessus= docMetier.getProcessus();
			for (Processus obj : listeProcessus) {
		           mesElements.add(new SelectItem(obj.getId(),obj.getIntitule()));
		     }
			
			return mesElements;
		}


}
