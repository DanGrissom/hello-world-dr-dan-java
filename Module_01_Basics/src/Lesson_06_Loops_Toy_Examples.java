/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// In this lesson you will learn:
//		1) Loop Constructs
//			a) FOR loop (for when we know how many times we need to do something)
//			b) WHILE loop (for when we do NOT know how many times we need to do something)
//			c) DO WHILE loop (for when we know we need to do something at LEAST once, but not sure how many times after that)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Lesson_06_Loops_Toy_Examples {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn the FOR, WHILE and DO-WHILE loop constructs (toy examples) ");
		System.out.println("===========================================================================");
		
		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);
		
		// Prompt user for a number
		System.out.print("Please enter a positive integer: ");
		int num = scan.nextInt();
		
		///////////////////////////////////////////////////////////////////////
		// FOR LOOP DEMOS
		///////////////////////////////////////////////////////////////////////
		// Print all numbers in range [0, num)
		System.out.println( "\nPrint all numbers in range [0, " + num + "):" );
		for (int i = 0; i < num; i++)
			System.out.println(i);
		
		// Print all numbers in range [0, num]
		System.out.println( "\nPrint all numbers in range [0, " + num + "]:" );
		for (int i = 0; i <= num; i++)
			System.out.println(i);
		
		// Print EVEN numbers in range [0, num)
		System.out.println( "\nPrint EVEN numbers in range [0, " + num + "):" );
		for (int i = 0; i < num; i++)
			if (i % 2 == 0)
				System.out.println(i);
		
		// Print EVEN numbers in range [0, num)
		System.out.println("\nPrint EVEN numbers in range [0, " + num + "):");
		for (int i = 0; i < num; i+=2)
			System.out.println(i);
		
		///////////////////////////////////////////////////////////////////////
		// WHILE LOOP DEMOS
		///////////////////////////////////////////////////////////////////////
		// Print MULTIPLES OF 3 in range [0, num)
		System.out.println("\nPrint MULTIPLES OF 3 in range [0, " + num + "):");
		int i = 0;
		while (i < num) {
			if (i % 3 == 0)
				System.out.println(i);
			i++;
		}
		
		// Sum numbers until user enter -1
		System.out.print("\nPlease enter numbers to sum (-1 to quit): ");
		num = scan.nextInt();
		int sum = 0;
		int count = 0;
		while (num >= 0) {
			sum += num;
			count++;
			
			System.out.print("Enter another number to sum (-1 to quit): ");
			num = scan.nextInt();
		}
		System.out.println("Sum of " + count + " numbers = " + sum + "\n");
		
		///////////////////////////////////////////////////////////////////////
		// DO WHILE LOOP DEMOS
		///////////////////////////////////////////////////////////////////////
		// Sum numbers until user enter -1
		sum = 0;
		count = 0;
		do {
			System.out.print("Enter a number to sum (-1 to quit): ");
			num = scan.nextInt();
			
			if (num >= 0) {
				sum += num;
				count++;
			}
		} while(num >= 0);
		System.out.println("Sum of " + count + " numbers = " + sum);
		
		// Sum numbers until user enter -1
		sum = 0;
		count = 0;
		do {
			System.out.print("Enter a number to sum (-1 to quit): ");
			num = scan.nextInt();
			
			if (num < 0)
				break;	// continue
			
			sum += num;
			count++;
		} while(num >= 0);
		System.out.println("Sum of " + count + " numbers = " + sum);
	}

}
