package org.lpee.testPFA.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
@ManagedBean(name="bean")

@SessionScoped
@Component
public class Bean implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	private String annee;
	private int ans;
	private static final long serialVersionUID = 1L;
private BarChartModel model=new BarChartModel();


public Bean() {
	
}
@PostConstruct
public void init()
{
	//annee="2015";
	createCategoryModel();
}


public void createCategoryModel(){ 
	ChartSeries serie = new ChartSeries();
		Date date=new Date();
	String [] tab=date.toString().split(" ");
	annee=tab[tab.length-1];
	System.out.println("Ans ="+tab[tab.length-1]);
	//annee="2014";
	System.out.println("Anss ="+annee);
	serie.setLabel("domaines");
	List<Long> listd=new ArrayList<Long>();
	int total=docMetier.getFiches(annee).size();
	listd=docMetier.getDomainebyFiche(annee);
	for(int i=0;i<listd.size();i++)
	{	
		float a=docMetier.getNumberDomaine(listd.get(i), annee);
		float b=(a/total)*100;
		serie.set(docMetier.getDomaineById(listd.get(i)).getLibelle(),(int)b );		
	}
	model = new BarChartModel();

	model.addSeries(serie);
	
	model.setTitle("Répartition des fiches d'anomalies par domaine pour l'année "+annee);
	model.setLegendPosition("ne");
	Axis xAxis = model.getAxis(AxisType.X);
	xAxis.setLabel("les domaine");
	Axis yAxis = model.getAxis(AxisType.Y);
	yAxis.setLabel("pourcentage de fiche d'anomalie");
	yAxis.setMin(0);
	yAxis.setMax(100);
	

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

public String getAnnee() {
	return annee;
}
public void setAnnee(String annee) {
	this.annee = annee;
}
public int getAns() {
	return ans;
}
public void setAns(int ans) {
	this.ans = ans;
}





}