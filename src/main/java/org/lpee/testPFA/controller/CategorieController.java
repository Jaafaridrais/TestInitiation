
package org.lpee.testPFA.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.lpee.testPFA.entities.*;
import org.lpee.testPFA.metier.IDocumentmetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@ManagedBean(name="categorieController")

@SessionScoped
@Component
public class CategorieController  implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	
	
	private static final long serialVersionUID = 1L;
	private  List<Categorie> listeCategories;
	
	private Categorie selected=new Categorie();
	
	public CategorieController()
	{
	} 
	public void ajoutEventC(ActionEvent actionEvent) {
		selected=new Categorie();
		//cb.ajoutEvent(actionEvent);

	}
	public List<Categorie> listCategorie()
	{
		listeCategories=new ArrayList<Categorie>();
		listeCategories.addAll((List<Categorie>)docMetier.getCategories());
		return listeCategories;
	}
    public String prepareCreate()
    {
    	selected=new Categorie();
    	return "Create";
    }
	public String create()
	{
		docMetier.addCategorie(selected);
		return "Listcat";
	}
	public String edit()
	{
		docMetier.upadateCategorie(selected);
		return "Listcat";
	}
	public String prepareEdite()
	{
		
		return "Editcat"; 
	}
	public String redirectEdit()
	{
		return "Editcat";
	}
	public void delete()
	{
		
	docMetier.deleteCategorie(selected);
	
	}
	public Categorie getSelected() {
	        return selected;
	    }

	    public void setSelected(Categorie selected) {
	        this.selected = selected;
	    }
	public List<Categorie> getListeCategorie() {
		return listeCategories;
	}
	public void setListeCategorie(List<Categorie> listeCategories) {
		this.listeCategories = listeCategories;
	}

	public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}
	//public SelectItem[] getItemsAvailableSelectOne() {
   //     return JsfUtil.getSelectItems(docMetier.getCategories(), true);
   // }
	 public List<SelectItem> listCategoriesSelect() {
		    List<SelectItem> mesElements=new ArrayList<SelectItem>();
	    	listeCategories= docMetier.getCategories();
			for (Categorie obj : listeCategories) {
		           mesElements.add(new SelectItem(obj.getIdCategorie(),obj.getLibelleCategorie()));
		     }
			
			return mesElements;
		}
	 

	      
}


