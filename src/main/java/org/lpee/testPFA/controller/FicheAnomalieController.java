package org.lpee.testPFA.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.lpee.testPFA.entities.ActionCorrective;
import org.lpee.testPFA.entities.ActionCurative;
import org.lpee.testPFA.entities.FicheAnomalie;
import org.lpee.testPFA.metier.IDocumentmetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@ManagedBean(name="ficheAnomalieController")

@SessionScoped
@Component
public class FicheAnomalieController  implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	private String per;
	private Long idProcessus;
	private Long idOrigine;
    private Long id;
    private Long numChpitre;
	private ActionCorrective  selectCorrective,newCorrective;
	private ActionCurative newCuractive,selectCurative;
	private static final long serialVersionUID = 1L;
	private  List<FicheAnomalie> listeFicheAnomalie;
	private  List<FicheAnomalie> listeAnomalieE1;
	private  List<FicheAnomalie> listeAnomalieET;
	private  List<FicheAnomalie> listeAnomalieT;
	private  List<FicheAnomalie> listeAnomalieV;
	private  List<FicheAnomalie> listeAnomalieC;
	private List<ActionCorrective> listACorrective;
	private List<ActionCurative>   listACurative;
	
	
	private FicheAnomalie selected=new FicheAnomalie();
	
	public FicheAnomalieController ()
	{
	} 
	
	public List<ActionCorrective> getListACorrective() {
		return listACorrective;
	}



	public void setListACorrective(List<ActionCorrective> listACorrective) {
		this.listACorrective = listACorrective;
	}

	public List<ActionCurative> getListACurative() {
		return listACurative;
	}

	public void setListACurative(List<ActionCurative> listACurative) {
		this.listACurative = listACurative;
	}


	public List<FicheAnomalie> listFicheAnomalie()
	{ 
		listeFicheAnomalie=new ArrayList<FicheAnomalie>();
		listeFicheAnomalie.addAll((List<FicheAnomalie>)docMetier.getFicheAnomalies());
		return listeFicheAnomalie;
	}
	public List<FicheAnomalie> listeAnomaliesE1()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String m=facesContext.getExternalContext().getSessionMap().get("teste").toString();
		System.out.println("matricule= "+m);
		
		listeAnomalieE1=new ArrayList<FicheAnomalie>();
		listeAnomalieE1.addAll((List<FicheAnomalie>)docMetier.getFicheNoTraitee(m));
		return listeAnomalieE1;
	}
	public List<FicheAnomalie> listeAnomaliesET()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String m=facesContext.getExternalContext().getSessionMap().get("teste").toString();
		System.out.println("matricule= "+m);
		listeAnomalieET=new ArrayList<FicheAnomalie>();
		listeAnomalieET.addAll((List<FicheAnomalie>)docMetier.getFicheNoappliquee(m));
		return listeAnomalieET;
	}
	public List<FicheAnomalie> listeAnomaliesT()
	{
		listeAnomalieT=new ArrayList<FicheAnomalie>();
		listeAnomalieT.addAll((List<FicheAnomalie>)docMetier.getFicheNoverifier());
		return listeAnomalieT;
	}
	public List<FicheAnomalie> listeAnomaliesV()
	{
		listeAnomalieV=new ArrayList<FicheAnomalie>();
		listeAnomalieV.addAll((List<FicheAnomalie>)docMetier.getFicheverifier());
		return listeAnomalieV;
	}
	public List<FicheAnomalie> listeAnomaliesC()
	{
		listeAnomalieC=new ArrayList<FicheAnomalie>();
		listeAnomalieC.addAll((List<FicheAnomalie>)docMetier.getFicheverifierC());
		return listeAnomalieC;
	}
    public String prepareCreate()
    {
    	selected=new FicheAnomalie();
    	return "Createanomalie";
    }
	public String create()
	{  
	
		docMetier.addFicheAnomalie(selected, idProcessus, idOrigine, id, per,numChpitre );
		
		return "Listanomalie";
	}
	public String traiter()
	{
		docMetier.addaActionCorrective(selectCorrective);
		docMetier.addActionCurative(selectCurative);
		selected.setActionCorrective(selectCorrective);
		selected.setActionCurative(selectCurative);
		selected.setEtatFiche("encourT");
		docMetier.updateFicheAnomalie(selected);
		return "ListFicheanomalie";
	}

	public String prepareApplication()
	{
		    
		    selected.setEtatFiche("traitee");
	        selected.getActionCorrective().setDateReel(new Date());
	        selected.getActionCurative().setDateReel(new Date());
	        docMetier.upadateActionCorrective(selected.getActionCorrective());
	        docMetier.upadateActionCurative(selected.getActionCurative());
			docMetier.updateFicheAnomalie(selected);
		    return "ListanomalieET";
	}
	public String prepareValidation()
	{
		
		return "ValiderActions";
	}
	public String retour()
	{
		
		return "ListanomalieC";
	}
	public String prepareAffichage()
	{
		
		return "AfficherFicheC";
	}
	public String Valider()
	{
	
		if(selected.getAppCorrective() && selected.getAppCurative() && selected.getEfficaciteCorrective() && selected.getEfficaciteCurative())
		{
			selected.setEtatFiche("solde");
		}
		else
		{
			selected.setEtatFiche("nosolde");
		}
		docMetier.updateFicheAnomalie(selected);
		return "ListanomalieV";
	}
	public String Verifier()
	{
		selected.setDateVerification(new Date());
		selected.setEtatFiche("verifiee");
		docMetier.updateFicheAnomalie(selected);
		return "ListanomalieT";
	}
	public String prepareTraite()
	{
		selectCorrective =new ActionCorrective();
		selectCurative= new ActionCurative();
		
		return "TraiterAnomalie";
	}
	public String prepareVerification()
	{
		
		return "VerifierActions";
	}
	
	public FicheAnomalie getSelected() {
	        return selected;
	    }

	    public void setSelected(FicheAnomalie selected) {
	        this.selected = selected;
	    }
	public List<FicheAnomalie> getListeFicheAnomalie() {
		return listeFicheAnomalie;
	}
	public void setListeFicheAnomalie(List<FicheAnomalie> listeFicheAnomalie) {
		this.listeFicheAnomalie = listeFicheAnomalie;
	}

	public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}


	public String getPer() {
		return per;
	}

	public void setPer(String pe) {
		per = pe;
	}

	public Long getIdProcessus() {
		return idProcessus;
	}

	public void setIdProcessus(Long idProcessus) {
		this.idProcessus = idProcessus;
	}

	public Long getIdOrigine() {
		return idOrigine;
	}

	public void setIdOrigine(Long idOrigine) {
		this.idOrigine = idOrigine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
	public String prepareAjoutActionCorretive()
    {
		newCorrective=new ActionCorrective();
    	return "AjouterAction";
    }
	public String AjoutActionCorretive()
	{
		docMetier.addaActionCorrective(newCorrective);
		return "TraiterAnomalie";
	}


	public String prepareAjoutActionCurative()
    {
		newCuractive=new ActionCurative();
    	return "AjouterActionCurative";
    }
	public String AjoutActionCurative()
	{
		docMetier.addActionCurative(newCuractive);
		return "TraiterAnomalie";
	}

	public ActionCorrective getSelectCorrective() {
		return selectCorrective;
	}

	public void setSelectCorrective(ActionCorrective selectCorrective) {
		this.selectCorrective = selectCorrective;
	}

	public ActionCorrective getNewCorrective() {
		return newCorrective;
	}

	public void setNewCorrective(ActionCorrective newCorrective) {
		this.newCorrective = newCorrective;
	}

	public ActionCurative getNewCuractive() {
		return newCuractive;
	}

	public void setNewCuractive(ActionCurative newCuractive) {
		this.newCuractive = newCuractive;
	}

	public ActionCurative getSelectCurative() {
		return selectCurative;
	}

	public void setSelectCurative(ActionCurative selectCurative) {
		this.selectCurative = selectCurative;
	}

	public Long getNumChpitre() {
		return numChpitre;
	}

	public void setNumChpitre(Long numChpitre) {
		this.numChpitre = numChpitre;
	}

	public List<FicheAnomalie> getListeAnomalieE1() {
		return listeAnomalieE1;
	}

	public void setListeAnomalieE1(List<FicheAnomalie> listeAnomalieE1) {
		this.listeAnomalieE1 = listeAnomalieE1;
	}

	public List<FicheAnomalie> getListeAnomalieET() {
		return listeAnomalieET;
	}

	public void setListeAnomalieET(List<FicheAnomalie> listeAnomalieET) {
		this.listeAnomalieET = listeAnomalieET;
	}

	public List<FicheAnomalie> getListeAnomalieT() {
		return listeAnomalieT;
	}

	public void setListeAnomalieT(List<FicheAnomalie> listeAnomalieT) {
		this.listeAnomalieT = listeAnomalieT;
	}

	public List<FicheAnomalie> getListeAnomalieV() {
		return listeAnomalieV;
	}

	public void setListeAnomalieV(List<FicheAnomalie> listeAnomalieV) {
		this.listeAnomalieV = listeAnomalieV;
	}

	public List<FicheAnomalie> getListeAnomalieC() {
		return listeAnomalieC;
	}

	public void setListeAnomalieC(List<FicheAnomalie> listeAnomalieC) {
		this.listeAnomalieC = listeAnomalieC;
	}
	
    
	
}
