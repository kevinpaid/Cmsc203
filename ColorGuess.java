/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Color guessing game
 * Due: 09/12/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kevin Calderon
*/

import java.util.Scanner;
import java.util.Random;

public class ColorGuess {
	
	
	public static void main (String [] args)
	{
		final String  COLOR_RED = "red";
		final String COLOR_GREEN = "green";
		final String COLOR_BLUE = "blue";
		final String COLOR_ORANGE = "orange";
		final String COLOR_YELLOW = "yellow";  
		final int TOTAL_ROUNDS = 10;
		int numOfColorsCorrect = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		
		
		
		System.out.print("Describe yourself: ");
		String description = scanner.nextLine();
		
		
		System.out.print("Due date: ");
		String dueDate = scanner.nextLine();
		
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		
		
		Random rand = new Random();
		
		
		
		
		for (int round = 1; round <= TOTAL_ROUNDS; round++)
		{
			String randomColor = "";
			String userChoice = "";
			
			
			
			System.out.println("Round " + round + "\n");
			System.out.println("I am thinking of a color.");
			System.out.println("Is it Red, Green, Blue, Orange, or Yellow?");
			System.out.println("Enter your guess:");
			userChoice = scanner.nextLine();
			System.out.print("\n");
			
			
			
			
			if (!((userChoice.equals(COLOR_RED)) || (userChoice.equals(COLOR_GREEN)) || (userChoice.equals(COLOR_BLUE)) || (userChoice.equals(COLOR_ORANGE)) || (userChoice.equals(COLOR_YELLOW))))
			{
				while (!((userChoice.equals(COLOR_RED)) || (userChoice.equals(COLOR_GREEN)) || (userChoice.equals(COLOR_BLUE)) || (userChoice.equals(COLOR_ORANGE)) || (userChoice.equals(COLOR_YELLOW))))
				{
					System.out.println("You entered incorrect color. Is it Red, Green, Blue, Orange, or Yellow?");
					System.out.println("Enter your guess again:");
					userChoice = scanner.nextLine();
				}
			}
			
			
			
			int randomNumber = rand.nextInt(0, 5);
			
			switch (randomNumber)
			{
				case 0: randomColor = COLOR_RED;
					break;
				case 1: randomColor = COLOR_GREEN;
					break;
				case 2: randomColor = COLOR_BLUE;
					break;
				case 3: randomColor = COLOR_ORANGE;
					break;
				case 4: randomColor = COLOR_YELLOW;
					break;
			
			}
			
			System.out.println("I was thinking of " + randomColor + ".");
			
			
			if ( userChoice.equals(randomColor) )
			{
				numOfColorsCorrect++;
			}
			
			
		}
		
		scanner.close();
		
		System.out.println("Game over\n");
		
		System.out.println("You guessed " + numOfColorsCorrect + " out of " + TOTAL_ROUNDS + " colors correctly.");
		
		System.out.println("User Name: " + name);
		
		System.out.println("User Description: " + description);
		
		System.out.println("Due Date: " + dueDate);
		
		
		
		
		
	}

}
