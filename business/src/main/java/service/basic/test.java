package service.basic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.dao.ReportDao;
import domain.entity.AccSt;
import domain.entity.Account;
import domain.entity.Gallery;
import domain.entity.Mointor;
import domain.entity.Organization;
import domain.entity.Report;
import domain.entity.ReportLookup;
import domain.entity.ReportType;
import domain.entity.StMo;
import domain.entity.Student;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahaleem
 */
public class test {
    public static void main( String[] args )
    {
    	
//    	ReportDao e=new ReportDao();
//    	e.findAllEntities(Report.class);
//    	e.findEntityById(5, Report.class);
//        System.out.println("Maven + Hibernate + MySQL");
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction=null;
//        transaction=session.beginTransaction();
//  
//
//        Organization mdrsty= new Organization();
//        mdrsty.setEmail("@mdrsty");
//        mdrsty.setName("ahhmed gamal adel modernschool");
//        mdrsty.setOwner("gemi");
//        mdrsty.setScale("very large");
//        mdrsty.setMobile("01146629609");
//                
//////        stock.setStockCode("4715");es
//////        stock.setStockName("GENM");
////        
//        
               
       
//        Student kid= new Student( mdrsty, "zyad Ahmed Adel Gemi", "/path", 4);
//        Account baba=new Account( "Ahmed Adel Gemi", "@gmaul", " Ahmed Adel Gemi 5456465", "/path", 1, mdrsty);
//       AccSt accountstudent=new AccSt(baba, kid);
//         Gallery kidportfilio= new Gallery( "/path", "Ahmed Adel Gemi swrt shm el nseem",kid);
//        
//        
//          session.save(mdrsty);
//          Query q= session.getNamedQuery("Organization.findById");
//          q.setInteger(0, 1);
//          List<Organization>mdars=q.list();
//          for (Organization mdrsa : mdars) {
//            mdrsty=mdrsa;
//            }
//          Mointor modrs= new Mointor("Ahmed Adel Gemi ",mdrsty, "Ahmed Adel Gemi sad@a", "01322", "modrss 7asb");
//          ReportType teby=new ReportType("Ahmed Adel Gemi a");
//          teby.setOrgId(mdrsty);
//          ReportLookup lookup= new ReportLookup();
//          lookup.setReportTypeId(teby);
//          lookup.setAttribute1("Ahmed Adel Gemi as");
//          lookup.setAttribute3("Ahmed Adel Gemi aweq");
//          Report zyadtebyreport=new Report();
//          StMo s= new StMo();
//          s.setMoId(modrs);
//          s.setStId(kid);
//          session.save(s);
//      
//         zyadtebyreport.setTypeId(teby);
//         zyadtebyreport.setStMonId(s);
//         zyadtebyreport.setValue1("Ahmed Adel Gemi dqwd");
//         zyadtebyreport.setValue2("Ahmed Adel Gemindklsa");
//      session.save(modrs);
//        session.save(kid);
//        session.save(teby);
//        session.save(lookup);
//        session.save(zyadtebyreport);
//        session.save(baba);
//        session.save(accountstudent);
//       session.save(kidportfilio);
////        //session.delete(stock);
//        
//        session.getTransaction().commit();
       
        
    }
}
