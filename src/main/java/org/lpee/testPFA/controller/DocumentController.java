package org.lpee.testPFA.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;






import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.lpee.testPFA.entities.ArchiveDocument;
import org.lpee.testPFA.entities.Document;
import org.lpee.testPFA.entities.Personnel;
import org.lpee.testPFA.entities.document_personnel;
import org.lpee.testPFA.metier.IDocumentmetier;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@ManagedBean(name="documentController")

@SessionScoped
@Component
public class DocumentController implements Serializable{
	@Autowired
	private  IDocumentmetier docMetier;
	private String type;
    private String fileName;
    String NomFichierD;
    File file1 = null;
	private Long idp;
	private UploadedFile uploadedFile;
    private byte[] file;
	private static final long serialVersionUID = 1L;
	private  List<Document> listeDocument;
	private List<Personnel> listpersonnel;
	private List<Personnel> selectedPersonnel;
	private List<Personnel> personnels;
	private List<Document> listdocper;
	private DefaultStreamedContent fileDow ;
	private Document selected=new Document();
	private Document doc=new Document();
	private ArchiveDocument archive=new ArchiveDocument();
	
	public DocumentController()
	{
	} 
	
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
    
	public List<Personnel> getListpersonnel() {
		return listpersonnel;
	}

	public void setListpersonnel(List<Personnel> listpersonnel) {
		this.listpersonnel = listpersonnel;
	}

	public List<Personnel> getSelectedPersonnel() {
		return selectedPersonnel;
	}

	public void setSelectedPersonnel(List<Personnel> selectedPersonnel) {
		this.selectedPersonnel = selectedPersonnel;
	}

	

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
   
	public DefaultStreamedContent getFileDow() {
		return fileDow;
	}

	public void setFileDow(DefaultStreamedContent fileDow) {
		this.fileDow = fileDow;
	}
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNomFichierD() {
		return NomFichierD;
	}

	public void setNomFichierD(String nomFichierD) {
		NomFichierD = nomFichierD;
	}

	public File getFile1() {
		return file1;
	}

	public void setFile1(File file1) {
		this.file1 = file1;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public ArchiveDocument getArchive() {
		return archive;
	}

	public void setArchive(ArchiveDocument archive) {
		this.archive = archive;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getIdp() {
		return idp;
	}

	public void setIdp(Long idp) {
		this.idp = idp;
	}
	public List<Personnel> lpersonnels()
	{
		personnels=new ArrayList<Personnel>();
		List<Personnel> liste1=new ArrayList<Personnel>();
		List<document_personnel> liste2=new ArrayList<document_personnel>();
		liste1.addAll((List<Personnel>)docMetier.getPersonnel());
		liste2.addAll((List<document_personnel>)docMetier.getPersonneldoc(selected.getRefDoc()));
		for(int i=0;i<liste1.size();i++)
		{
			int k=-1;
			for(int j=0;j<liste2.size();j++)
			{
				if(liste1.get(i).getMatricule().equals(liste2.get(j).getPersonnel().getMatricule()))
				{
					k=j;
					break;
				}
			}
			if(k==-1)
			{
				personnels.add(liste1.get(i));
			}
		}
		return personnels;
	}
	public List<Document> listdocsbyper()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String m=facesContext.getExternalContext().getSessionMap().get("teste").toString();
		System.out.println("matricule= "+m);
		listdocper=new ArrayList<Document>();
		List<document_personnel> liste=new ArrayList<document_personnel>();
		liste.addAll((List<document_personnel>)docMetier.getDocumentPerByPer(m));
		for(int i=0;i<liste.size();i++)
		{
			listdocper.add(liste.get(i).getDocument());
		}

		return listdocper;
	}
    public List<Personnel> listPersonnels()
    {
    	listpersonnel=new ArrayList<Personnel>();
    	listpersonnel.addAll((List<Personnel>)docMetier.getPersonnel());
    	return listpersonnel;
    }
	public List<Document> listDocument()
	{
		listeDocument=new ArrayList<Document>();
		listeDocument.addAll((List<Document>)docMetier.getDocuments());
		return listeDocument;
	}
    public String prepareCreate()
    {
    	selected=new Document();
    	return "Createdoc";
    }
    public String prepareCreatef()
    {
    	selected=new Document();
    	return "Createessai";
    }
	public String create()
	{  
		
		docMetier.addDocument(selected,type,idp);
		return "diffuse";
	}
	public String diffuse()
	{  
       return "diffuse1";
	}
	public void edit()
	{
		docMetier.updateDocument(selected);
		//return "Listdoc";
	}
	public String prepareEdite()
	{
		return "Editdoc"; 
	}
	public String diffuser()
	{
		for (Personnel per : selectedPersonnel) {
			docMetier.addDocumentToPersonnel(selected.getRefDoc(), per.getMatricule());
		}
		return "Listdoc";
	}
	public String annuuler()
	{
		return "Listdoc";
	}
	public String prepareDiffuser()
	{
		selectedPersonnel=new ArrayList<Personnel>();
		return "diffuse"; 
	}
	public String prepreArchive()
	{
		archive=new ArchiveDocument();
		archive.setChemin(selected.getChemin());
		docMetier.addArchiveDocument(archive, selected.getRefDoc());
		
		return "archive";
	}
	public void  archiver()
	{
		archive=new ArchiveDocument();
		archive.setChemin(selected.getChemin());
		docMetier.addArchiveDocument(archive, selected.getRefDoc());
		selected.setIndiceDoc(selected.getIndiceDoc()+1);
		docMetier.updateDocument(selected);
		//return "Listdoc";
	}
	
	public String delete(Document d)
	{
		selected=new Document();
		selected=d;
		//docMetier.deleteDocument(selected);
		return "List";
	}
	public Document getSelected() {
	        return selected;
	    }

	    public void setSelected(Document selected) {
	        this.selected = selected;
	    }
	public List<Document> getListeDocument() {
		return listeDocument;
	}
	public void setListeDocument(List<Document> listeDocument) {
		this.listeDocument = listeDocument;
	}

	public IDocumentmetier getDocMetier() {
		return docMetier;
	}

	public void setDocMetier(IDocumentmetier docMetier) {
		this.docMetier = docMetier;
	}

	 public List<SelectItem> listDocumentSelect() {
		    List<SelectItem> mesElements=new ArrayList<SelectItem>();
		    listeDocument= docMetier.getDocuments();
			for (Document obj : listeDocument) {
		           mesElements.add(new SelectItem(obj.getIntituleDoc(),obj.getIntituleDoc()));
		     }
			
			return mesElements;
		}

    public void doUpload(FileUploadEvent event)throws IOException
    {
    	uploadedFile=event.getFile();
    	String NomFichier = event.getComponent().getAttributes().get("NomFichier").toString();
    	// Prepare filename prefix and suffix for an unique filename in upload folder.
      //  String prefix = FilenameUtils.getBaseName(uploadedFile.getFileName());
        String suffix = FilenameUtils.getExtension(uploadedFile.getFileName()); 
        
        OutputStream output = null;
        try {
            // Create file with unique name in upload folder and write to it.
        	file1 = new File("./upload");
        	if(!file1.exists())
        		file1.mkdir();
        	file1 = File.createTempFile(NomFichier + "_", "." + suffix, new File("./upload"));
            output = new FileOutputStream(file1);
            IOUtils.copy(uploadedFile.getInputstream(), output);
          
            // choix de Update ou Add
            selected.setChemin(file1.getName());
           
        	
        	
        	// Show succes message.
            FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        	FacesContext.getCurrentInstance().addMessage(null, msg); 
        	
        	
        } catch (IOException e) {
            // Cleanup.
            //if (file != null) file.delete();

            // Show error message.
            FacesMessage msg = new FacesMessage("Erreur d'upload ", event.getFile().getFileName());  
        	FacesContext.getCurrentInstance().addMessage(null, msg); 

            // Always log stacktraces (with a real logger).
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(output);
        }
		
    	
    }
 
    	public void FileDownloaddoc() throws FileNotFoundException  { 
        	Map<String, String> p =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        	
        	String id= p.get("id");  	
        	doc=docMetier.ConsulterDocument(id);
    		file1 = new File("./upload/"+doc.getChemin());
    		if(file1.exists())
    		{
    		InputStream s = new FileInputStream(file1);
    		fileDow = new DefaultStreamedContent(s, "application/pdf", doc.getChemin());
    		}
    		else
    		{
    			
    				fileDow=null;
    				FacesContext context = FacesContext.getCurrentInstance();
    	    		context.addMessage(null, new FacesMessage("Télécharger:", "il n'existe aucun fichier à télécharger. Veuillez ajouter un nouveau fichier"));
    			
    		}
        }

		public Document getDoc() {
			return doc;
		}

		public void setDoc(Document doc) {
			this.doc = doc;
		}

		public List<Document> getListdocper() {
			return listdocper;
		}

		public void setListdocper(List<Document> listdocper) {
			this.listdocper = listdocper;
		}
		
       
     


}
