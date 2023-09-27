/*
 * Class: CMSC203 
 * Instructor:
 * Description: Procedure methods, getters, setters, etc
 * Due: 09/26/2003
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Calderon
*/

public class Procedure
{
	private String procedureName = "";
	private String procedureDate = "";
	private String procedureDoctor = "";
	private double procedureCharges;
	
	public Procedure ()
	{
		
	}
	
	public Procedure (String a, String b)
	{
		procedureName = a;
		procedureDate = b;
	}
	
	public Procedure (String a, String b, String c, double x)
	{
		
		procedureName = a;
		procedureDate = b;
		procedureDoctor = c;
		procedureCharges = x;
		
	}
	
	// GETTERS
	
	public String getProcedureName ()
	{
		return procedureName;
	}
	
	public String getProcedureDate ()
	{
		return procedureDate;
	}
	
	public String getProcedureDoctor ()
	{
		return procedureDoctor;
	}
	
	public double getProcedureCharges ()
	{
		return procedureCharges;
	}
	
	// SETTERS
	
	public void setProcedureName (String name)
	{
		procedureName = name;
	}
	
	public void setProcedureDate (String date)
	{
		procedureDate = date;
	}
	
	public void setProcedureDoctor (String doc)
	{
		procedureDoctor = doc;
	}
	
	public void setProcedureCharges (double charge)
	{
		procedureCharges = charge;
	}
	
	public String toString ()
	{
		String str = "";
		str += "Procedure: " + getProcedureName() + "\nProcedureDate: " + getProcedureDate() + "\nPractitioner: " + getProcedureDoctor() + "\nCharges: " + getProcedureCharges();
		
		return str;
	}

}
