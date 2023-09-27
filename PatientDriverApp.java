/*
 * Class: CMSC203 
 * Instructor:
 * Description: Displays patient and procedure information, as well as total charges
 * Due: 09/26/2003
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Calderon
*/


import java.text.DecimalFormat;


public class PatientDriverApp {
	public static void main(String[] args) 
	{
		
		
		Patient fill = new Patient("Jenny", "Elaine", "Santori", "123 Main Street", "MyTown","CA", 01234, "3015343212", "Bill Santori", "777-555-1212");
		
		System.out.println("Patient info:");
		
		displayPatient(fill);
		System.out.println();

	
	
	Procedure procedure1 = new Procedure();
	Procedure procedure2 = new Procedure("X-ray", "7/20/2019");
	Procedure procedure3 = new Procedure("Blood test", "7/20/2019", "Dr Smith",1400.75);
	
	procedure1.setProcedureName("Physical Exam");
	procedure1.setProcedureDate("7/20/2019");
	procedure1.setProcedureDoctor("Dr. Irvine");
	procedure1.setProcedureCharges(3250.0);
	
	procedure2.setProcedureDoctor("Dr.Jamison");
	procedure2.setProcedureCharges(5500.43);
	
	
	
	displayProcedure(procedure1);
	System.out.println();
	displayProcedure(procedure2);
	System.out.println();
	displayProcedure(procedure3);
	System.out.println();
	
	
	
	
	System.out.println("Total Charges: " + calculateTotalCharges(procedure1, procedure2, procedure3));
	
	System.out.println();
	
	System.out.println("Student Name: " + "Kevin Calderon");
	System.out.println("MC#: " + "M21141938");
	System.out.println("Due Date: " + "09/26/2023");
	
	
	
	}
	
	public static void displayPatient (Patient p)
	{
		System.out.println(p.toString());
	}
	
	
	public static void displayProcedure (Procedure p)
	{
		//System.out.println("Procedure: " + p.getProcedureName() + "\nProcedureDate: " + p.getProcedureDate() + "\nPractitioner: " + p.getProcedureDoctor() + "\nCharge: " + p.getProcedureCharges());
		System.out.println(p);
		
	}
	
	public static String calculateTotalCharges (Procedure a, Procedure b, Procedure c)
	{
		double total = 0;
		
		
		total += a.getProcedureCharges();
		
		total += b.getProcedureCharges();
		
		total += c.getProcedureCharges();
		
		DecimalFormat format = new DecimalFormat("##,###.00");
		String number = format.format(total);
		
		return number;
		
		
		
	}

}
