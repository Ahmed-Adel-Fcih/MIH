/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;
import dao.model.Account;
import dao.model.Mointor;
import dao.model.Student;
import ejb.mointormanagement.MointorManagementEjb;
import ejb.studentmanagement.AccountManagementEJB;
import ejb.studentmanagement.StudentManagementBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import webservice.json.AssignStudentsToAccountRequest;
import webservice.json.AssignStudentsToMointorRequest;

/**
 *
 * @author ahaleem
 */

@Path(value="/")
public class OrganizationBackEnd {
    MointorManagementEjb mointorManagementEjb=null;
    private void getMointorManagementEjbInstance()
    {
        if(mointorManagementEjb==null)
            mointorManagementEjb=new MointorManagementEjb();
    
    }
    StudentManagementBean studentManagementBean=null;
    private void getStudentManagementBeanInstance()
    {
        if(studentManagementBean==null)
            studentManagementBean=new StudentManagementBean();
    
    }
    AccountManagementEJB accountManagementEJB=null;
    private void getAccountManagementEJBInstance()
    {
        if(accountManagementEJB==null)
            accountManagementEJB=new AccountManagementEJB();
    
    }
  
    
   @POST
   @Path(value = "/addmointor")
   public void addMointor( Mointor mointor)  {
        try {
            getMointorManagementEjbInstance();
            mointorManagementEjb.addMointor(mointor);
        } catch (Exception ex) {
            Logger.getLogger(OrganizationBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   @POST
   @Path(value = "/addstudent")
   public void addStudent( Student student)  {
       getStudentManagementBeanInstance();
        try {
          
            studentManagementBean.addStudent(student);
        } catch (Exception ex) {
            Logger.getLogger(OrganizationBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   @POST
   @Path(value = "/addaccount")
   public void addAccount(Account account)  {
       getAccountManagementEJBInstance();
        try {
          accountManagementEJB.addAccount(account);
            
        } catch (Exception ex) {
            Logger.getLogger(OrganizationBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   @POST
   @Path(value = "/assignstudentstoaccount")
   public void assignStudentsToAccount(AssignStudentsToAccountRequest req)  {
       getAccountManagementEJBInstance();
        try {
              accountManagementEJB.assignStudentsToAccount(req.getAccount(),req.getStudents());
            
        } catch (Exception ex) {
            Logger.getLogger(OrganizationBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    @POST
   @Path(value = "/assignstudentstomointor")
   public void assignStudentsToMointor(AssignStudentsToMointorRequest req)  {
       getMointorManagementEjbInstance();
        try {
              mointorManagementEjb.assignStudentsToMointor(req.getMointor(),req.getStudents());
            
        } catch (Exception ex) {
            Logger.getLogger(OrganizationBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   @GET
   @Path(value = "/getorganizationstudents")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Student> getOrganizationStudents(@QueryParam(value = "orgid") int orgid)  {
       getStudentManagementBeanInstance();
       List<Student> students = null;
        try {
             students=studentManagementBean.findAllOrganizationStudents( orgid);
        } catch (Exception ex) {
            Logger.getLogger(OrganizationBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
   }
   @GET
   @Path(value = "/getorganizationmointors")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Mointor> getOrganizationMointors(@QueryParam(value = "orgid") int orgid)  {
       getMointorManagementEjbInstance();
       List<Mointor> mointors = null;
        try {
             mointors=mointorManagementEjb.findAllOrganizatioMointors( orgid);
        } catch (Exception ex) {
            Logger.getLogger(OrganizationBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mointors;
   }
   @GET
   @Path(value = "/getorganizationaccounts")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Account> getOrganizationaccounts(@QueryParam(value = "orgid") int orgid)  {
       getAccountManagementEJBInstance();
       List<Account> accounts = null;
        try {
             accounts=accountManagementEJB.findAllOrganizatioAccounts( orgid);
        } catch (Exception ex) {
            Logger.getLogger(OrganizationBackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
   }
}
