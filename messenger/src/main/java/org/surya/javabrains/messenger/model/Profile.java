package org.surya.javabrains.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {
	
	public Profile()
	{
		
	}
	
	public long id;
	public Date created;
	public String firstName;
	public String middleName;
	public String lastName;
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getCreated() {
		return created;
	}



	public void setCreated(Date created) {
		this.created = created;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getMiddleName() {
		return middleName;
	}



	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	
	
	
	
	public Profile(long id,String firstName,String middleName,String lastName) {
		this.id=id;
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.created=new Date();
	}

}



