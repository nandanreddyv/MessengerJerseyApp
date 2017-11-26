package org.surya.javabrains.messenger.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;






import org.surya.javabrains.messenger.database.DatabaseClass;
import org.surya.javabrains.messenger.model.Profile;


public class ProfileService {
	
	
	private Map<String, Profile> profiles=DatabaseClass.getProfiles();
	public ProfileService()
	{
		profiles.put("Surya", new Profile(1l,"Surya", "Nandan", "Reddy"));
		profiles.put("Sambi", new Profile(2l,"Sambi", "V", "Reddy"));
	}
	

public List<Profile> getallProfiles()
{
	
	
	return new ArrayList<Profile>(profiles.values());
	
	
	}

public Profile getProfile(String firstname)
{
	
	
	return profiles.get(firstname);
	
	
	}


public Profile createProfile(Profile profile) {
	
	profiles.put(profile.firstName, profile);
	
	
	return profiles.get(profile.firstName);
	
}


public Profile updateProfile(Profile profile) {
	if (!profiles.isEmpty())
	{
		profiles.put(profile.firstName, profile);
	}
	
	return profiles.get(profile.firstName);
	
}

public Profile deleteProfile(String fname)
{  
	
	return profiles.remove(fname);
	

}
}
