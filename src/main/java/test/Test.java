package test;

import java.util.Iterator;
import java.util.List;

import org.lpee.testPFA.entities.Domaine;
import org.lpee.testPFA.metier.IDocumentmetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
      IDocumentmetier metier=(IDocumentmetier) app.getBean("metier");
    //  metier.addDomaine(new Domaine("domaine1"));
 List<Domaine> ds=metier.getDomaines();
 for (int i = 0; i < ds.size(); i++) {
	System.out.println(ds.get(i).getLibelle());
}
 
 
      
	}

}
