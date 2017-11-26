package org.surya.javabrains.messenger.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.surya.javabrains.messenger.model.Profile;
import org.surya.javabrains.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService ps=new ProfileService();
	@GET 
	public List<Profile> allProfiles() {
		return ps.getallProfiles();
		
	}
	
	@GET
	@Path("/{profileid}")
	public Profile Profile(@PathParam("profileid") String Firstname) {
		
		return ps.getProfile(Firstname);
		
	}
	
	
	@POST
	public Profile addProfile(Profile profile) {
		profile.created=new Date();
		profile.id=ps.getallProfiles().size()+1;
		ps.createProfile(profile);
		return ps.getProfile(profile.firstName);
		
	}
	
	@PUT
	@Path("/{fname}")
	public Profile upmyProfile(@PathParam("fname") String fname, Profile profile)
	{
		profile.setId(ps.getallProfiles().size()+1);
		
		return ps.updateProfile(profile);
		
	}
	
	@DELETE
	@Path("/{fname}")
	public void Delete(@PathParam("fname") String fname)
	{
		
				ps.deleteProfile(fname);
				return;
	}
	
	
}
