package org.lpee.testPFA.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;













import org.lpee.testPFA.metier.IDocumentmetier;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@ManagedBean(name="bean1")

@SessionScoped
@Component
public class Bean1 implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	private static final long serialVersionUID = 1L;
   


public Bean1() {
	super();

}
private BarChartModel model;
@PostConstruct
public void init()
{
	createCategoryModel();
}

public void createCategoryModel(){ 
	ChartSeries serie = new ChartSeries();
	Date date=new Date();
	String [] tab=date.toString().split(" ");
	String annee=tab[tab.length-1];
	//annee="2014";
	serie.setLabel("Origine");
	List<Long> listo=new ArrayList<Long>();
	int totalo=docMetier.getFiches(annee).size();
	listo=docMetier.getOriginebyFiche(annee);
	System.out.println("size="+listo.size());
	for(int i=0;i<listo.size();i++)
	{
		
		float a=docMetier.getNumberOriginee(listo.get(i),annee);
		float b=(a/totalo)*100;
		serie.set(docMetier.getOrigineById(listo.get(i)).getLibelleOrigine(),b);
		System.out.println("size="+listo.size());
		System.out.println("i="+i);
		
	}
	model = new BarChartModel();

	model.addSeries(serie);
	
	model.setTitle("Répartition des fiches d'anomalies par origine pour l'année "+annee);
	model.setLegendPosition("ne");
	Axis xAxiso = model.getAxis(AxisType.X);
	xAxiso.setLabel("les origines");
	Axis yAxiso = model.getAxis(AxisType.Y);
	yAxiso.setLabel("pourcentage de fiche d'anomalie");
	yAxiso.setMin(0);
	yAxiso.setMax(100);
	

}

public BarChartModel getModel() {
	return model;
}

public void setModel(BarChartModel model) {
	this.model = model;
}

public IDocumentmetier getDocMetier() {
	return docMetier;
}

public void setDocMetier(IDocumentmetier docMetier) {
	this.docMetier = docMetier;
}

public void actualiser()
{
	createCategoryModel();
	
}




}