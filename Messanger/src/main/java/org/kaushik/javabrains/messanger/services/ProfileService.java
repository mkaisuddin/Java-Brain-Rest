package org.kaushik.javabrains.messanger.services;

import java.util.ArrayList;
import java.util.Map;

import org.kaushik.javabrains.messanger.database.DatabaseClass;
import org.kaushik.javabrains.messanger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ArrayList<Profile> getAllProfile(){
		return new ArrayList<Profile> (profiles.values());
	}

	public Profile getProfile(String profileName){
		//return profiles.getProfileName(profileName);
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId((long) (profiles.size()+1));
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName() == null) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}
