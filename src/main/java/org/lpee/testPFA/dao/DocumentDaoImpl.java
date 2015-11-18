package org.lpee.testPFA.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lpee.testPFA.entities.*;
import org.springframework.stereotype.Component;


@Component
public class DocumentDaoImpl implements IDocumentDao {
	@PersistenceContext
    private EntityManager em;
	@Override
	public Document addDocument(Document doc, String Td, Long P) {
		TypeDocument T=em.find(TypeDocument.class, Td);
		Processus proc=em.find(Processus.class, P);
		T.setIndice(T.getIndice()+1);
		doc.setRefDoc(T.getRef()+"/"+T.getIndice()+"/"+210);
		T.setDateMAJ(new Date());
		doc.setTypeDocument(T);
		doc.setProcessus(proc);
		em.persist(doc);
		return doc;
	}
	public Document addDocument(Document d)
	{
		em.persist(d);
		return d;
		
	}
	
	@Override
	public FicheAnomalie addFicheAnomalie(FicheAnomalie F, Long P, Long O,
			Long D, String Per, Long C) {
		Date date=new Date();
		String [] tab=date.toString().split(" ");
		String ref=tab[tab.length-1];
		List<TypeDocument> liste=this.getTypeDocument();
		int k=-1;
		for(int i=0;i<liste.size();i++)
		{
			if(liste.get(i).getRef().equals(ref))
			{
				k=i;
				break;
			}
		}
		if(k==-1)
		{
			TypeDocument type=new TypeDocument();
			type.setRef(ref);
			type.setIntituleTypeDoc("fiche de progres "+ref);
			addTypeDocument(type, 11l);
		}
		TypeDocument T=em.find(TypeDocument.class, ref);
		T.setIndice(T.getIndice()+1);
		T.setDateMAJ(new Date());
		F.setTypeDocument(T);
		Domaine domaine=em.find(Domaine.class,D);
		Processus proc=em.find(Processus.class, P);
		Origine origine=em.find(Origine.class, O);
		Personnel persoone=em.find(Personnel.class, Per);
		Chapitre chapitre=em.find(Chapitre.class, C);
		F.setPersonnel(persoone);
		F.setProcessus(proc);
		F.setOrigine(origine);
		F.setDomaine(domaine);
		F.setChapitre(chapitre);
		em.persist(F);
		return F;
	}

	@Override
	public document_personnel addDocumentToPersonnel(String D, String P) {
		document_personnel dp=new document_personnel();
	Document doc=em.find(Document.class, D);
	Personnel per=em.find(Personnel.class, P);
	dp.setDocument(doc);
	dp.setPersonnel(per);
	em.persist(dp);
     return dp;
	}

	@Override
	public Document ConsulterDocument(String doc) {
		Document document=em.find(Document.class, doc);
		return document;
	}

	@Override
	public FicheAnomalie ConsulterFicheAnomalie(Long F) {
		FicheAnomalie fiche=em.find(FicheAnomalie.class, F);
		return fiche;
	}

	@Override
	public List<Document> getDocuments() {
		System.out.println("doc hhhhhhhhhhhhhhhh");
		Query req=em.createQuery("select d from Document d");
		return req.getResultList();
	}

	@Override
	public List<FicheAnomalie> getFicheAnomalies() {
		Query req=em.createQuery("select f from FicheAnomalie f ");
		
		return req.getResultList();
	}

	@Override
	public List<Domaine> getDomaines() {
		Query req=em.createQuery("select d from Domaine d");
		return req.getResultList();
	}

	@Override
	public List<Origine> getOrigines() {
		Query req=em.createQuery("select o from Origine o");
		return req.getResultList();
	}

	@Override
	public List<Processus> getProcessus() {
		Query req=em.createQuery("select p from Processus p");
		return req.getResultList();
	}

	

	@Override
	public List<Document> getDocumentByType(String T) {
		Query req=em.createQuery("select d from Document d where d.typeDocument.ref like :x");
		req.setParameter("x", T);
		
		return req.getResultList();
	}

	@Override
	public Domaine addDomaine(Domaine d) {
		em.persist(d);
		return d;
	}

	@Override
	public Origine addOrigine(Origine O) {
		em.persist(O);
		return O;
	}

	@Override
	public Processus addProcessus(Processus p) {
		em.persist(p);
		return p;
	}

	@Override
	public Personnel addPersonnel(Personnel p) {
		em.persist(p);
		return p;
	}

	@Override
	public ActionCorrective addaActionCorrective(ActionCorrective a) {
		em.persist(a);
		return a;
	}

	@Override
	public ActionCurative addActionCurative(ActionCurative a) {
		em.persist(a);
		return a;
	}

	@Override
	public ArchiveDocument addArchiveDocument(ArchiveDocument a, String Rd) {
		Document doc=em.find(Document.class,Rd);
		a.setDocument(doc);
		em.persist(a);
		return a;
	}

	@Override
	public Categorie addCategorie(Categorie c) {
		em.persist(c);
		return c;
	}

//	@Override
//	public FormulaireEssai addFormulaireEssai(FormulaireEssai f,String Td, Long P) {
//		TypeDocument T=em.find(TypeDocument.class, Td);
//		Processus proc=em.find(Processus.class, P);
//		T.setIndice(T.getIndice()+1);
//		f.setRefDoc(T.getRef()+"/"+T.getIndice()+"/"+210);
//		T.setDateMAJ(new Date());
//		f.setTypeDocument(T);
//		f.setProcessus(proc);
//		em.persist(f);
//		return f;
//	}

	@Override
	public TypeDocument addTypeDocument(TypeDocument t, Long c) {
		Categorie cat=em.find(Categorie.class, c);
		t.setCategorie(cat);
		em.persist(t);
		return t;
	}

	@Override
	public List<ArchiveDocument> getArchiveDocumentByDoc(String REF) {
		Query req=em.createQuery("select d from ArchiveDocument d where d.document.refDoc=:x");
		req.setParameter("x", REF);
		return req.getResultList();
	}

	@Override
	public List<TypeDocument> getTypeDocument() {
		Query req=em.createQuery("select t from TypeDocument t where t.ref not like :x");
		req.setParameter("x", "ref");
		return req.getResultList();
	}

	@Override
	public List<Personnel> getPersonnel() {
		Query req=em.createQuery("select p from Personnel p");
		return req.getResultList();
	}

	@Override
	public Document updateDocument(Document d) {
	
		em.merge(d);
		return d;
	}

	@Override
	public List<FicheAnomalie> getFicheByResponsable(String res) {
		Query req=em.createQuery("select f from FicheAnomalie f where f.personnel.matricule=:x");
		req.setParameter("x", res);
		return req.getResultList();
	}

	@Override
	public FicheAnomalie TraiterFicheAnomalie(FicheAnomalie f, Long CodeA,
			Long IdA) {
		ActionCorrective a=em.find(ActionCorrective.class, CodeA);
		f.setActionCorrective(a);
		ActionCurative action=em.find(ActionCurative.class, IdA);
		f.setActionCurative(action);
		em.merge(f);
		return f;
	}

	@Override
	public FicheAnomalie cloturerFicheAnomalie(FicheAnomalie f) {
		em.merge(f);
		return f;
	}

	@Override
	public Domaine upadateDomaine(Domaine d) {
		em.merge(d);
		return d;
	}

	@Override
	public void deleteDomaine(Domaine d) {
		d=em.merge(d);
	em.remove(d);
	}

	@Override
	public Processus upadateProcessus(Processus p) {
		em.merge(p);
		return p;
	}

	@Override
	public void deleteProcessus(Processus p) {
		p=em.merge(p);
		em.remove(p);
		
	}

	@Override
	public Personnel upadatePersonnel(Personnel p) {
	
        em.merge(p);
		return p;
	}

	@Override
	public void deletePersonnel(Personnel p) {
		p=em.merge(p);
		em.remove(p);
		
	}

	@Override
	public Origine upadateOrigine(Origine o) {
		em.merge(o);
		return o;
	}

	@Override
	public void deleteOrigine(Origine o) {
		o=em.merge(o);
		em.remove(o);
		
	}

	@Override
	public Categorie upadateCategorie(Categorie c) {
		em.merge(c);
		return c;
	}

	@Override
	public void deleteCategorie(Categorie c) {
		c=em.merge(c);
		em.remove(c);
		
	}


	@Override
	public ActionCorrective upadateActionCorrective(ActionCorrective a) {
		em.merge(a);
		return a;
	}

	

	@Override
	public ActionCurative upadateActionCurative(ActionCurative a) {
		em.merge(a);
		return a;
	}

	@Override
	public List<Categorie> getCategories() {
		Query req=em.createQuery("select p from Categorie p");
		return req.getResultList();
	}

	@Override
	public TypeDocument upadateTypeDocument(TypeDocument t) {
		em.merge(t);
		return t;
	}
	@Override
	public TypeDocument addTypeDocument(TypeDocument t) {
		em.persist(t);
		return t;
	}
	@Override
	public Categorie getCtegorieById(Long c) {
		Categorie cat=em.find(Categorie.class, c);
		
		return cat;
	}
	@Override
	public FicheAnomalie updateFicheAnomalie(FicheAnomalie f) {
		em.merge(f);
		return f;
	}
	@Override
	public Chapitre addChapitre(Chapitre C) {
		em.persist(C);
		return C;
	}
	@Override
	public List<Chapitre> getChapitres() {
		Query req=em.createQuery("select c from Chapitre c");
		return req.getResultList();
	}
	@Override
	public Chapitre updateChapitre(Chapitre C) {
		em.merge(C);
		return C;
	}

	@Override
	public int getNumberDomaine(Long d, String annee) {
		Query req=em.createQuery("select c from FicheAnomalie c where c.typeDocument.ref=:x and c.domaine.id="+d);
		req.setParameter("x", annee);
		return req.getResultList().size();
	}
	@Override
	public Domaine getDomaineById(Long d) {
      Domaine dom=em.find(Domaine.class, d);
      return dom;
	}
	@Override
	public List<Long> getOriginebyFiche(String annee) {
		Query req=em.createQuery("select distinct c.origine.idOrigine from FicheAnomalie  c where c.typeDocument.ref like :x");
			req.setParameter("x", annee);
		return req.getResultList();
	}
	@Override
	public int getNumberOriginee(Long o, String annee) {
	Query req=em.createQuery("select c from FicheAnomalie c where c.typeDocument.ref=:x and c.origine.idOrigine="+o);
	req.setParameter("x", annee);
		return req.getResultList().size();
	}
	@Override
	public Origine getOrigineById(Long o) {
		Origine origine=em.find(Origine.class, o);
		return origine;
	}
	@Override
	public List<Long> getProcessusbyFiche(String annee) {
		Query req=em.createQuery("select distinct  c.processus.id from FicheAnomalie c where c.typeDocument.ref like :x");
		req.setParameter("x", annee);
		return req.getResultList();
	}
	@Override
	public int getNumberProcessus(Long p, String annee) {
       Query req=em.createQuery("select c from FicheAnomalie c where c.typeDocument.ref=:x and c.processus.id="+p);
       req.setParameter("x", annee);
		return req.getResultList().size(); 
	}
	@Override
	public Processus getProcessusById(Long p) {
		Processus proc=em.find(Processus.class, p);
		return proc;
	}
	@Override
	public List<Long> getChapitrebyFiche(String annee) {
		Query req=em.createQuery("select distinct  c.chapitre.numChapitre from FicheAnomalie c where c.typeDocument.ref like :x");
		req.setParameter("x", annee);
		return req.getResultList();
	}
	@Override
	public int getNumberChapitre(Long c, String annee) {
		 Query req=em.createQuery("select c from FicheAnomalie c where  c.typeDocument.ref=:x and c.chapitre.numChapitre="+c);
		 req.setParameter("x", annee);
			return req.getResultList().size(); 
	}
	@Override
	public Chapitre getChapitreById(Long c) {
		Chapitre ch=em.find(Chapitre.class, c);
		return ch;
	}
	@Override
	public List<FicheAnomalie> getFicheNoTraitee(String matricule) {
		Query req=em.createQuery("select f from FicheAnomalie f where f.personnel.matricule=:y and etatFiche=:x");
		req.setParameter("x", "etat1");
		req.setParameter("y", matricule);
		return req.getResultList();
	}
	@Override
	public List<FicheAnomalie> getFicheNoappliquee(String matricule) {
		Query req=em.createQuery("select f from FicheAnomalie f where f.personnel.matricule=:y and etatFiche=:x");
		req.setParameter("x", "encourT");
		req.setParameter("y", matricule);
		return req.getResultList();
	}
	@Override
	public List<FicheAnomalie> getFicheNoverifier() {
		Query req=em.createQuery("select f from FicheAnomalie f where etatFiche=:x");
		req.setParameter("x", "traitee");
		return req.getResultList();
	}
	@Override
	public List<FicheAnomalie> getFicheverifier() {
		Query req=em.createQuery("select f from FicheAnomalie f where etatFiche=:x");
		req.setParameter("x", "verifiee");
		return req.getResultList();
	}
	@Override
	public List<FicheAnomalie> getFicheverifierC() {
		Query req=em.createQuery("select f from FicheAnomalie f where etatFiche=:x or etatFiche=:y");
		req.setParameter("x", "solde");
		req.setParameter("y", "nosolde");
		return req.getResultList();
	}
	@Override
	public List<Personnel> getUserById() {
		Query req=em.createQuery("select f from Personnel f");
		
	
		return req.getResultList();
	}
	
	@Override
	public Personnel getPersonnelById(String mat) {
		Personnel personnel=em.find(Personnel.class, mat);
		return personnel;
	}
	@Override
	public void deleteChapitre(Chapitre ch) {
		ch=em.merge(ch);
		em.remove(ch);
		
	}
	@Override
	public void deleteTypeDocument(TypeDocument t) {
		t=em.merge(t);
		em.remove(t);
		
	}
	
	@Override
	public List<document_personnel> getDocumentPerByPer(String P) {
		Query req=em.createQuery("select d from document_personnel d where d.personnel.matricule like :x");
		req.setParameter("x", P);
		
		return req.getResultList();
	}
	
	@Override
	public List<document_personnel> getPersonneldoc(String doc) {
		Query req=em.createQuery("select d from document_personnel d where d.document.refDoc like :x");
		req.setParameter("x", doc);
		
		return req.getResultList();
	}
	@Override
	public void supprimertype(TypeDocument type) {
		type=em.merge(type);
		em.remove(type);
	
		
	}
	@Override
	public TypeDocument getType(String type) {
		TypeDocument T=em.find(TypeDocument.class, type);
		return T;
	}
	@Override
	public List<TypeDocument> getTypeDoc() {
		Query req=em.createQuery("select d from document_personnel d where d.document.refDoc like :x");
		req.setParameter("x", "fiche de progres");
		
		return req.getResultList();
	}
	@Override
	public List<Long> getDomainebyFiche(String annee) {
	
			Query req=em.createQuery("select distinct c.domaine.id from FicheAnomalie c where c.typeDocument.ref like :x");
			req.setParameter("x", annee);
			return req.getResultList();
		
	}
	@Override
	public List<FicheAnomalie> getFiches(String annee) {
		Query req=em.createQuery("select f from FicheAnomalie f where f.typeDocument.ref=:x");
		req.setParameter("x", annee);
		return req.getResultList();
	}

	
	

}
