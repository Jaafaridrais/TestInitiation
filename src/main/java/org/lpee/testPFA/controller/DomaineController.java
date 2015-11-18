package org.lpee.testPFA.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.lpee.testPFA.entities.Domaine;
import org.lpee.testPFA.entities.Origine;
import org.lpee.testPFA.metier.IDocumentmetier;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@ManagedBean(name="domaineController")

@SessionScoped
@Component
public class DomaineController implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	
	
	private static final long serialVersionUID = 1L;
	private  List<Domaine> listedomaines;
	private BarChartModel model=new BarChartModel();
	private Domaine selected=new Domaine();
	
	public DomaineController()
	{
	} 
	public List<Domaine> listDomaine()
	{
		listedomaines=new ArrayList<Domaine>();
		listedomaines.addAll((List<Domaine>)docMetier.getDomaines());
		return listedomaines;
	}
	public void ajoutEventD(ActionEvent actionEvent) {
		selected=new Domaine();
		//cb.ajoutEvent(actionEvent);

	}
    public String prepareCreate()
    {
    	selected=new Domaine();
    	return "Create";
    }
	public String create()
	{
		docMetier.addDomaine(selected);
		return "List";
	}
	public String edit()
	{
		docMetier.upadateDomaine(selected);
		return "List";
	}
	public String prepareEdite()
	{
		
		return "Edit"; 
	}
	public String redirectEdit()
	{
		return "Edit";
	}
	public void delete()
	{
		docMetier.deleteDomaine(selected);
		
	}
	public Domaine getSelected() {
	        return selected;
	    }

	    public void setSelected(Domaine selected) {
	        this.selected = selected;
	    }
	public List<Domaine> getListedomaines() {
		return listedomaines;
	}
	public void setListedomaines(List<Domaine> listedomaines) {
		this.listedomaines = listedomaines;
	}

	public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}

	 public List<SelectItem> listDomaineSelect() {
		    List<SelectItem> mesElements=new ArrayList<SelectItem>();
		    listedomaines=new ArrayList<Domaine>();
		    listedomaines= docMetier.getDomaines();
			for (Domaine obj : listedomaines) {
		           mesElements.add(new SelectItem(obj.getId(),obj.getLibelle()));
		     }
			
			return mesElements;
		}
	public BarChartModel getModel() {
		return model;
	}
	public void setModel(BarChartModel model) {
		this.model = model;
	}
	

}
