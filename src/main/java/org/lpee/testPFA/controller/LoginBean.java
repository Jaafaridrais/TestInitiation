package org.lpee.testPFA.controller;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.lpee.testPFA.entities.Personnel;
import org.lpee.testPFA.metier.IDocumentmetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



 
@ManagedBean(name = "loginBean")
@SessionScoped
@Component
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Autowired
	private  IDocumentmetier docMetier;
//	public static String mat;
    private Personnel selected =  new Personnel();
    private String password;
    private String message, uname;
    private Personnel finded;
    public Personnel getFinded() {
		return finded;
	}

	public void setFinded(Personnel finded) {
		this.finded = finded;
	}


    
  
    
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getPassword() {
     
            return password;
       
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
       
            return uname;
        
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }

	public Personnel getSelected() {
		return selected;
	}

	public void setSelected(Personnel selected) {
		this.selected = selected;
	}


public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}
	public void isConnect(ComponentSystemEvent event){
		 
		FacesContext fc = FacesContext.getCurrentInstance();
	 
		if (fc.getExternalContext().getSessionMap().get("teste")==null){
	 
			ConfigurableNavigationHandler nav 
			   = (ConfigurableNavigationHandler) 
				fc.getApplication().getNavigationHandler();
	 
			nav.performNavigation("login");
		}			
	  }
public String login()
{
	finded=new Personnel();
	finded.setProfile("null");
	
	List<Personnel> liste=new ArrayList<Personnel>();
	liste=docMetier.getPersonnel();

	for(int i=0;i<liste.size();i++)
	{

		if((liste.get(i).getMatricule().equals(uname)) &&(liste.get(i).getMotdePasse().equals(password)))
		{
			finded=liste.get(i);
		}
	}
	//finded = docMetier.getUserById(uname,password).get(0);
	if (finded.getProfile().equals("null"))
	{
		//Message error
		return "login";
	}
	else
	{
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSessionMap().put("teste",finded.getMatricule());
		     
		if (finded.getProfile().equals("user"))
			
			return "AccueilU";

		else 
			return "Accueil" ;
		
	}
}
public void logout2(ComponentSystemEvent event)
{
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("teste",null);
	 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

}

	public void logout() throws IOException{
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("teste",null);
		 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		 ConfigurableNavigationHandler nav 
		   = (ConfigurableNavigationHandler) 
		   FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
		 
		 nav.performNavigation("login");
		 FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		 
		
	}
	public String iscon(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
			if(facesContext.getExternalContext().getSessionMap().get("teste")!=null){
			return "true";}
			else{
			return "false";}
	}
	public String rediAdmin(){
    Personnel p=new Personnel();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    String m=facesContext.getExternalContext().getSessionMap().get("teste").toString();
    p=docMetier.getPersonnelById(m);
		if(p!=null){
			if(p.getProfile().equals("admin"))
				return "true";
			else
				return "false";
		}else
			return "false";
	}

	public String rediPersonnel(){
		   Personnel p=new Personnel();
		    FacesContext facesContext = FacesContext.getCurrentInstance();
		    String m=facesContext.getExternalContext().getSessionMap().get("teste").toString();
		    p=docMetier.getPersonnelById(m);
			if(p!=null)
			{
				 if(p.getProfile().equals("user"))
					 
			         return "true";
		       else
			         return "false";
	        }
			else
			{
				return "false";
			}
	}
	public String redirect404(){
		System.err.println("404");
		return "404?faces-redirect=true";
	}
	public String redirectLogin(){
		System.err.println("login redirect");
		return "login?faces-redirect=true";
	}
}
