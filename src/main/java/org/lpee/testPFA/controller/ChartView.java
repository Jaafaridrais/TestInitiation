package org.lpee.testPFA.controller;

import javax.annotation.PostConstruct;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
 
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.stereotype.Component;
 
@ManagedBean(name="chartView")

@SessionScoped
@Component
public class ChartView implements Serializable {
	private static final long serialVersionUID = 1L;
    private BarChartModel barModel=new BarChartModel();
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public String init() {
    	ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);
 
        barModel.addSeries(boys);
        barModel.addSeries(girls);
      
        
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
        
       Axis xAxis = barModel.getAxis(AxisType.X);
       xAxis.setLabel("Gender");
        
       Axis yAxis = barModel.getAxis(AxisType.Y);
       yAxis.setLabel("Births");
       yAxis.setMin(0);
       yAxis.setMax(200);
        return "View";
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    @SuppressWarnings("unused")
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
        createHorizontalBarModel();
    }
     
    private String createBarModel() {
    	
    	 
         ChartSeries boys = new ChartSeries();
         boys.setLabel("Boys");
         boys.set("2004", 120);
         boys.set("2005", 100);
         boys.set("2006", 44);
         boys.set("2007", 150);
         boys.set("2008", 25);
  
         ChartSeries girls = new ChartSeries();
         girls.setLabel("Girls");
         girls.set("2004", 52);
         girls.set("2005", 60);
         girls.set("2006", 110);
         girls.set("2007", 135);
         girls.set("2008", 120);
  
         barModel.addSeries(boys);
         barModel.addSeries(girls);
       
         
         barModel.setTitle("Bar Chart");
         barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
        return "View";
    }
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 82);
        girls.set("2007", 35);
        girls.set("2008", 120);
 
        horizontalBarModel.addSeries(boys);
        horizontalBarModel.addSeries(girls);
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");        
    }
 
}