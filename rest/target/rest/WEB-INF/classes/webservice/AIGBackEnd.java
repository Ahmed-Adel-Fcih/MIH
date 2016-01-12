/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dao.model.Organization;
import ejb.organizationmanagement.OrganizationManagementEjb;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ahaleem
 */

@Path(value="/")
@Produces(MediaType.APPLICATION_JSON)
public class AIGBackEnd {

    OrganizationManagementEjb organizationmanagement=null;
    private void getOrganizationManagementEJBInstance()
    {
        if(organizationmanagement==null)
            organizationmanagement=new OrganizationManagementEjb();
    
    }
    @POST
    @Path(value = "/setupOrganization")
    public void setupOrganization(Organization organization)
    { 
         getOrganizationManagementEJBInstance();
         organizationmanagement.setupOrganization(organization);
    }
   @GET
   @Path(value = "/findorganization")
   public Organization findOrganization(@QueryParam(value = "orgid") int orgid) throws Exception {
        getOrganizationManagementEJBInstance();
        return organizationmanagement.GetOrganization(orgid);
   }
}
