package org.lpee.testPFA.metier;

import java.util.List;

import org.lpee.testPFA.dao.IDocumentDao;
import org.lpee.testPFA.entities.ActionCorrective;
import org.lpee.testPFA.entities.ActionCurative;
import org.lpee.testPFA.entities.ArchiveDocument;
import org.lpee.testPFA.entities.Categorie;
import org.lpee.testPFA.entities.Chapitre;
import org.lpee.testPFA.entities.Document;
import org.lpee.testPFA.entities.Domaine;
import org.lpee.testPFA.entities.FicheAnomalie;
import org.lpee.testPFA.entities.Origine;
import org.lpee.testPFA.entities.Personnel;
import org.lpee.testPFA.entities.Processus;
import org.lpee.testPFA.entities.TypeDocument;
import org.lpee.testPFA.entities.document_personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
@Component
public class DocumentMetierImpl implements IDocumentmetier {
    @Autowired
	private IDocumentDao  dao;
    
	public void setDao(IDocumentDao dao) {
		this.dao = dao;
	}

	@Override
	public Document addDocument(Document doc, String Td, Long P) {
		// TODO Auto-generated method stub
		return dao.addDocument(doc, Td, P);
	}

	@Override
	public FicheAnomalie addFicheAnomalie(FicheAnomalie F, Long P, Long O,
			Long D, String Per, Long C) {
		// TODO Auto-generated method stub
		return dao.addFicheAnomalie(F, P, O, D, Per, C);
	}

	@Override
	public document_personnel addDocumentToPersonnel(String D, String P) {
		return dao.addDocumentToPersonnel(D, P);
		
	}

	@Override
	public Document ConsulterDocument(String doc) {
		// TODO Auto-generated method stub
		return dao.ConsulterDocument(doc);
	}

	@Override
	public FicheAnomalie ConsulterFicheAnomalie(Long F) {
		// TODO Auto-generated method stub
		return dao.ConsulterFicheAnomalie(F);
	}

	@Override
	public List<Document> getDocuments() {
		// TODO Auto-generated method stub
		return dao.getDocuments();
	}

	@Override
	public List<FicheAnomalie> getFicheAnomalies() {
		// TODO Auto-generated method stub
		return dao.getFicheAnomalies();
	}

	@Override
	public List<Domaine> getDomaines() {
		System.out.println("ssssssssssssssssssssssssssssssssssssssssssssss- IMplementation -sssssssssssssssssssssssssssssssssssssssss");
		return dao.getDomaines();
	}

	@Override
	public List<Origine> getOrigines() {
		// TODO Auto-generated method stub
		return dao.getOrigines();
	}

	@Override
	public List<Processus> getProcessus() {
		// TODO Auto-generated method stub
		return dao.getProcessus();
	}

	



	@Override
	public List<Document> getDocumentByType(String T) {
		// TODO Auto-generated method stub
		return dao.getDocumentByType(T);
	}

	@Override
	public Domaine addDomaine(Domaine d) {
		// TODO Auto-generated method stub
		return dao.addDomaine(d);
	}

	@Override
	public void archiverDocument(Document d) {
		ArchiveDocument a=new ArchiveDocument();
		a.setChemin(d.getChemin());
		dao.addArchiveDocument(a, d.getRefDoc());
		dao.updateDocument(d);
		
	}

	@Override
	public Origine addOrigine(Origine O) {
		// TODO Auto-generated method stub
		return dao.addOrigine(O);
	}

	@Override
	public Processus addProcessus(Processus p) {
		// TODO Auto-generated method stub
		return dao.addProcessus(p);
	}

	@Override
	public Personnel addPersonnel(Personnel p) {
		// TODO Auto-generated method stub
		return dao.addPersonnel(p);
	}

	@Override
	public ActionCorrective addaActionCorrective(ActionCorrective a) {
		// TODO Auto-generated method stub
		return dao.addaActionCorrective(a);
	}

	@Override
	public ActionCurative addActionCurative(ActionCurative a) {
		// TODO Auto-generated method stub
		return dao.addActionCurative(a);
	}

	@Override
	public ArchiveDocument addArchiveDocument(ArchiveDocument a, String Rd) {
		// TODO Auto-generated method stub
		return dao.addArchiveDocument(a, Rd);
	}

	@Override
	public Categorie addCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.addCategorie(c);
	}



	@Override
	public TypeDocument addTypeDocument(TypeDocument t, Long i) {
		// TODO Auto-generated method stub
		return dao.addTypeDocument(t, i);
	}

	@Override
	public List<ArchiveDocument> getArchiveDocumentByDoc(String REF) {
		// TODO Auto-generated method stub
		return dao.getArchiveDocumentByDoc(REF);
	}

	@Override
	public List<TypeDocument> getTypeDocument() {
		// TODO Auto-generated method stub
		return dao.getTypeDocument();
	}

	@Override
	public List<Personnel> getPersonnel() {
		// TODO Auto-generated method stub
		return dao.getPersonnel();
	}

	@Override
	public Document updateDocument(Document d) {
		// TODO Auto-generated method stub
		return dao.updateDocument(d);
	}

	@Override
	public List<FicheAnomalie> getFicheByResponsable(String res) {
		// TODO Auto-generated method stub
		return dao.getFicheByResponsable(res);
	}

	@Override
	public FicheAnomalie TraiterFicheAnomalie(FicheAnomalie f, Long CodeA,
			Long IdA) {
		// TODO Auto-generated method stub
		return dao.TraiterFicheAnomalie(f, CodeA, IdA);
	}

	@Override
	public FicheAnomalie cloturerFicheAnomalie(FicheAnomalie f) {
		// TODO Auto-generated method stub
		return dao.cloturerFicheAnomalie(f);
	}

	@Override
	public Domaine upadateDomaine(Domaine d) {
		
		return dao.upadateDomaine(d);
	}

	@Override
	public void deleteDomaine(Domaine d) {
		dao.deleteDomaine(d);
		
	}

	@Override
	public Processus upadateProcessus(Processus p) {
		
		return dao.upadateProcessus(p);
	}

	@Override
	public void deleteProcessus(Processus p) {
		dao.deleteProcessus(p);
		
	}

	@Override
	public Personnel upadatePersonnel(Personnel p) {
		// TODO Auto-generated method stub
		return dao.upadatePersonnel(p);
	}

	@Override
	public void deletePersonnel(Personnel p) {
	    dao.deletePersonnel(p);
		
	}

	@Override
	public Origine upadateOrigine(Origine o) {
		// TODO Auto-generated method stub
		return dao.upadateOrigine(o);
	}

	@Override
	public void deleteOrigine(Origine o) {
		dao.deleteOrigine(o);
		
	}

	@Override
	public Categorie upadateCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.upadateCategorie(c);
	}

	@Override
	public void deleteCategorie(Categorie c) {
		dao.deleteCategorie(c);
		
	}


	@Override
	public ActionCorrective upadateActionCorrective(ActionCorrective a) {
		// TODO Auto-generated method stub
		return dao.upadateActionCorrective(a);
	}



	@Override
	public ActionCurative upadateActionCurative(ActionCurative a) {
		// TODO Auto-generated method stub
		return dao.upadateActionCurative(a);
	}

	@Override
	public List<Categorie> getCategories() {
		// TODO Auto-generated method stub
		return dao.getCategories();
	}

	@Override
	public TypeDocument upadateTypeDocument(TypeDocument t) {
		// TODO Auto-generated method stub
		return dao.upadateTypeDocument(t);
	}

	@Override
	public Document addDocument(Document d) {
		
		return dao.addDocument(d);
	}

	@Override
	public TypeDocument addTypeDocument(TypeDocument t) {
		// TODO Auto-generated method stub
		return dao.addTypeDocument(t);
	}

	@Override
	public Categorie getCtegorieById(Long c) {
		// TODO Auto-generated method stub
		return dao.getCtegorieById(c);
	}

	@Override
	public FicheAnomalie updateFicheAnomalie(FicheAnomalie f) {
		// TODO Auto-generated method stub
		return dao.updateFicheAnomalie(f);
	}

	@Override
	public Chapitre addChapitre(Chapitre C) {
		// TODO Auto-generated method stub
		return dao.addChapitre(C);
	}

	@Override
	public List<Chapitre> getChapitres() {
		// TODO Auto-generated method stub
		return dao.getChapitres();
	}

	@Override
	public Chapitre updateChapitre(Chapitre C) {
		// TODO Auto-generated method stub
		return dao.updateChapitre(C);
	}

	@Override
	public List<Long> getDomainebyFiche(String annee) {
		// TODO Auto-generated method stub
		return dao.getDomainebyFiche(annee);
	}

	@Override
	public int getNumberDomaine(Long d, String annee) {
		// TODO Auto-generated method stub
		return dao.getNumberDomaine(d, annee);
	}

	@Override
	public Domaine getDomaineById(Long d) {
		// TODO Auto-generated method stub
		return dao.getDomaineById(d);
	}

	@Override
	public List<Long> getOriginebyFiche(String annee) {
		// TODO Auto-generated method stub
		return dao.getOriginebyFiche(annee);
	}

	@Override
	public int getNumberOriginee(Long o, String annee) {
		// TODO Auto-generated method stub
		return dao.getNumberOriginee(o, annee);
	}

	@Override
	public Origine getOrigineById(Long o) {
		// TODO Auto-generated method stub
		return dao.getOrigineById(o);
	}

	@Override
	public List<Long> getProcessusbyFiche(String annee) {
		// TODO Auto-generated method stub
		return dao.getProcessusbyFiche(annee);
	}

	@Override
	public int getNumberProcessus(Long p, String annee) {
		// TODO Auto-generated method stub
		return dao.getNumberProcessus(p, annee);
	}

	@Override
	public Processus getProcessusById(Long p) {
		// TODO Auto-generated method stub
		return dao.getProcessusById(p);
	}

	

	@Override
	public int getNumberChapitre(Long p, String annee) {
		// TODO Auto-generated method stub
		return dao.getNumberChapitre(p, annee);
	}

	@Override
	public Chapitre getChapitreById(Long p) {
		// TODO Auto-generated method stub
		return dao.getChapitreById(p);
	}

	@Override
	public List<FicheAnomalie> getFicheNoTraitee(String matricule) {
		// TODO Auto-generated method stub
		return dao.getFicheNoTraitee(matricule);
	}

	@Override
	public List<FicheAnomalie> getFicheNoappliquee(String matricule) {
		// TODO Auto-generated method stub
		return dao.getFicheNoappliquee(matricule);
	}

	@Override
	public List<FicheAnomalie> getFicheNoverifier() {
		// TODO Auto-generated method stub
		return dao.getFicheNoverifier();
	}

	@Override
	public List<FicheAnomalie> getFicheverifier() {
		// TODO Auto-generated method stub
		return dao.getFicheverifier();
	}

	@Override
	public List<FicheAnomalie> getFicheverifierC() {
		// TODO Auto-generated method stub
		return dao.getFicheverifierC();
	}

	@Override
	public List<Personnel> getUserById() {
		// TODO Auto-generated method stub
		return dao.getUserById();
	}

	@Override
	public Personnel getPersonnelById(String mat) {
		// TODO Auto-generated method stub
		return dao.getPersonnelById(mat);
	}

	@Override
	public void deleteChapitre(Chapitre ch) {
		dao.deleteChapitre(ch);
		
	}

	@Override
	public void deleteTypeDocument(TypeDocument t) {
		dao.deleteTypeDocument(t);
		
	}

	@Override
	public List<document_personnel> getDocumentPerByPer(String P) {
		// TODO Auto-generated method stub
		return dao.getDocumentPerByPer(P);
	}

	@Override
	public List<document_personnel> getPersonneldoc(String doc) {
		// TODO Auto-generated method stub
		return dao.getPersonneldoc(doc);
	}

	@Override
	public void supprimertype(TypeDocument type) {
		dao.supprimertype(type);
		
	}

	@Override
	public TypeDocument getType(String type) {
		
		return dao.getType(type);
	}

	

	@Override
	public List<Long> getChapitrebyFiche(String annee) {
		// TODO Auto-generated method stub
		return dao.getChapitrebyFiche(annee);
	}

	@Override
	public List<FicheAnomalie> getFiches(String annee) {
		// TODO Auto-generated method stub
		return dao.getFiches(annee);
	}

	


}