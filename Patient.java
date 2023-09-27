/*
 * Class: CMSC203 
 * Instructor:
 * Description: Patient information, name, address, contact information methods
 * Due: 09/26/2003
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Calderon
*/

public class Patient
{
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	private String streetAddress = "";
	private String city = "";
	private String state = "";
	private int zipCode;
	private String phoneNumber;
	private String emergencyContactName = "";
	private String emergencyContactNumber = "";
	
	public Patient ()
	{
		
	}
	
	public Patient (String a, String b, String c)
	{
		firstName = a;
		middleName = b;
		lastName = c;
	}
	
	public Patient (String first, String second, String third, String address, String city, String state, int postalCode, String phone, String emergencyName, String emergencyNumber)
	{
		firstName = first;
		middleName = second;
		lastName = third;
		streetAddress = address;
		this.city = city;
		this.state = state;
		zipCode = postalCode;
		phoneNumber = phone;
		emergencyContactName = emergencyName;
		emergencyContactNumber = emergencyNumber;
	}
	
	// GETTERS
	
	public String getFirstName ()
	{
		return firstName;
	}
	
	public String getMiddleName ()
	{
		return middleName;
	}
	
	public String getLastName ()
	{
		return lastName;
	}
	
	public String getStreetAddress ()
	{
		return streetAddress;
	}
	
	public String getCity ()
	{
		return city;
	}
	
	public String getState ()
	{
		return state;
	}
	
	public int getZipCode ()
	{
		return zipCode;
	}
	
	public String getPhoneNumber ()
	{
		return phoneNumber;
	}
	
	public String getEmergencyContactName ()
	{
		return emergencyContactName;
	}
	
	public String getEmergencyContactNumber ()
	{
		return emergencyContactNumber;
	}
	
	
	
	// SETTERS

	public void setFirstName (String a)
	{
		firstName = a;
	}
	
	public void setMiddleName (String b)
	{
		middleName = b;
	}
	
	public void setLastName (String c)
	{
		lastName = c;
	}
	
	public void setStreetAddress (String street)
	{
		streetAddress = street;
	}
	
	public void setCity (String city)
	{
		this.city = city;
	}
	
	public void setState (String state)
	{
		this.city = state;;
	}
	
	public void setZipCode (int code)
	{
		zipCode = code;
	}
	
	public void setPhoneNumber (String number)
	{
		phoneNumber = number;
	}
	
	public void setEmergencyContactName (String emergencyName)
	{
		emergencyContactName = emergencyName;
	}
	
	public void setEmergencyContactNumber (String emergencyNumber)
	{
		emergencyContactNumber = emergencyNumber;
	}
	
	
	
	public String buildFullName ()
	{
		String builtName = (firstName + " " + middleName + " " + lastName);
		return builtName;
	}
	
	public String buildAddress ()
	{
		String builtAddress = (streetAddress + " " + city + " " + state + " " + zipCode );
		return builtAddress;
	}
	
	public String buildEmergencyContact ()
	{
		String builtEmergencyContact = (emergencyContactName + " " + emergencyContactNumber);
		return builtEmergencyContact;
	}
	
	public String toString ()
	{
		String str = "";
		str += "Name: " + buildFullName() + "\nAddress: " + buildAddress() + "\nEmergencyContact: " + buildEmergencyContact();
		return str;
	}

}
