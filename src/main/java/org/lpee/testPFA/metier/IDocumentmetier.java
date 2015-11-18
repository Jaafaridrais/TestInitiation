package org.lpee.testPFA.metier;

import java.util.List;

import org.lpee.testPFA.entities.*;


public interface IDocumentmetier {
	public Document addDocument(Document doc, String Td, Long P);
	public Domaine addDomaine(Domaine d);
	public FicheAnomalie addFicheAnomalie(FicheAnomalie F, Long P, Long O, Long D, String Per, Long C);
	public document_personnel addDocumentToPersonnel(String D, String P);
	public Document ConsulterDocument(String doc);
	public FicheAnomalie ConsulterFicheAnomalie(Long F);
	public List<Document> getDocuments();
	public List<FicheAnomalie> getFicheAnomalies();
	public List<Domaine> getDomaines();
	public List<Origine> getOrigines();
	public List<Processus> getProcessus();
	public List<document_personnel> getPersonneldoc(String doc);
	public List<Document> getDocumentByType(String T);
	public List<document_personnel> getDocumentPerByPer(String P);
	public void archiverDocument(Document d);
	public Origine addOrigine(Origine O);
	public Processus addProcessus(Processus p);
	public Personnel addPersonnel(Personnel p);
	public ActionCorrective addaActionCorrective(ActionCorrective a);
	public ActionCurative addActionCurative(ActionCurative a);
	public ArchiveDocument addArchiveDocument(ArchiveDocument a, String Rd);
	public Categorie addCategorie(Categorie c);
	//public FormulaireEssai addFormulaireEssai(FormulaireEssai f,String Td, Long P);
	//public List<FormulaireEssai> getFormulaires();
	//public FormulaireEssai consulterFormulaire(String form);
	public TypeDocument addTypeDocument(TypeDocument t, Long i);
	public List<ArchiveDocument> getArchiveDocumentByDoc(String REF);
	public List<TypeDocument> getTypeDocument();
	public List<Personnel> getPersonnel();
	public Document updateDocument(Document d);
	public List<FicheAnomalie> getFicheByResponsable(String res);
	public FicheAnomalie TraiterFicheAnomalie(FicheAnomalie f, Long CodeA, Long IdA);
	public FicheAnomalie cloturerFicheAnomalie(FicheAnomalie f );
	public Domaine upadateDomaine(Domaine d);
	public void deleteDomaine(Domaine d);
	public Processus upadateProcessus(Processus p);
	public void deleteProcessus(Processus p);
	public Personnel upadatePersonnel(Personnel p);
	public void deletePersonnel(Personnel p);
	public Origine upadateOrigine(Origine o);
	public void deleteOrigine(Origine o);
	public Categorie upadateCategorie(Categorie c);
	public void deleteCategorie(Categorie c);
	public ActionCorrective upadateActionCorrective(ActionCorrective a);
	public ActionCurative upadateActionCurative(ActionCurative a);
	public List<Categorie> getCategories();
	public TypeDocument upadateTypeDocument(TypeDocument t);
	public Document addDocument(Document d);
	public TypeDocument addTypeDocument(TypeDocument t);
	public Categorie  getCtegorieById(Long c);
	public FicheAnomalie updateFicheAnomalie(FicheAnomalie f);
	public Chapitre addChapitre(Chapitre C);
	public List<Chapitre> getChapitres();
	public Chapitre updateChapitre(Chapitre C);
	public List<Long> getDomainebyFiche(String annee);
	public int getNumberDomaine(Long d, String annee);
	public Domaine getDomaineById(Long d);
	public List<Long> getOriginebyFiche(String annee);
	public int getNumberOriginee(Long o, String annee);
	public Origine getOrigineById(Long o);
	public List<Long> getProcessusbyFiche(String annee);
	public int getNumberProcessus(Long p, String annee);
	public Processus getProcessusById(Long p);
	public List<Long> getChapitrebyFiche(String annee);
	public int getNumberChapitre(Long c, String annee);
	public Chapitre getChapitreById(Long c);
	public List<FicheAnomalie> getFicheNoTraitee(String matricule);
	public List<FicheAnomalie> getFicheNoappliquee(String matricule);
	public List<FicheAnomalie> getFicheNoverifier();
	public List<FicheAnomalie> getFicheverifier();
	public List<FicheAnomalie> getFicheverifierC();
	public List<Personnel> getUserById();
	public Personnel getPersonnelById(String mat);
	public void deleteChapitre(Chapitre ch);
	public void deleteTypeDocument(TypeDocument t);
	public void supprimertype(TypeDocument type);
	public TypeDocument getType(String type);
	public List<FicheAnomalie> getFiches(String annee);

	
}
