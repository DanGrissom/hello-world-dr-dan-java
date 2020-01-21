/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Threads
//			a) How to generate and execute new threads 
//			b) Scoping of variables used in thread (e.g., static, final, etc.)
//			c) How to synchronize existing threads
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.LinkedList;
import java.util.Scanner;

public class Lesson_01_Threads {

	// Init list-related variables
	private static LinkedList<Integer> ll = new LinkedList<Integer>();
	private final static int numItems = 20000000;
	
	// Init thread-related variables
	private static int numThreads;
	private static int itemsPerThread;
	private static int nextThreadNum = 0;
	private static int threadsCompleted = 0;
	private static boolean keyFound = false;
	
	// Init timer-related variables
	private static long start;
	
	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will start execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {

		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use threads to speed up execution of certain tasks.");
		System.out.println("===========================================================================");
		
		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);
		
		// Prompt user for some values
		System.out.print("How many threads would you like to use: ");
		numThreads = scan.nextInt();
		itemsPerThread = numItems / numThreads;
		//System.out.printf("%s threads each search %,d items\n", numThreads, itemsPerThread);
		
		// Populate a linked list with a lot of items
		for (int i = 0; i < numItems; i++)
			ll.add(i);
		
		// Init timer
		System.out.println("Initializing timer and search process...");
		start = System.currentTimeMillis();
		
		// Launch a bunch of threads that each search through a sub-portion of the list
		for (int i = 0; i < numThreads; i++) {
			
			// Thread sync - If any other thread already found the key, don't generate more search threads
			if (keyFound)
				break;
			
			// Otherwise, key has not been found, keep generating new threads to search new sub-portions of the list
			new Thread() {
				public void run() {
					
					// Get thread number and compute beginning and end index
					int threadNum = nextThreadNum++;
					int beg = threadNum * itemsPerThread;
					int end = (threadNum+1) * itemsPerThread - 1;
					
					// Begin search sub-process
					final int key = 50000; 
					System.out.printf("Starting Thread %s (i = [%,d - %,d])...\n", ++threadNum, beg, end);
					searchList(ll, beg, end, key);
					
					// Search is done! Print current elapsed time
					long elapsedTime = System.currentTimeMillis() - start;
					System.out.printf("Ending thread %s at %,d ms\n", threadNum, elapsedTime);
					
					// Check if last thread
					threadsCompleted++;
					if (threadsCompleted == numThreads)
						System.out.printf("\n\nLast thread (#%s) complete at %,d ms\n", threadNum, elapsedTime);
				}
			}.start();
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	// Iterates through a sub-portion of the given linked list in search of the
	// provided key; if it finds it, simply prints where it found it
	//		Parameters:
	//			ll - A linked list containing many integers
	//			startIndex - An int representing the index at which to start searching
	//			endIndex - An int representing the index at which to end searching
	//			key - An int representing the value to search for in the linked list
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void searchList(LinkedList<Integer> ll, int startIndex, int endIndex, int key) {
		for (int i = startIndex; i <= endIndex; i++) {
			if (ll.get(i) == key) {
				System.out.printf("FOUND %s at index %s!\n", key, i);
				keyFound = true;	// Alert other threads that the key has been found
				break;
			}
			
			// Thread sync - If any other thread already found the key, quit searching my indices
			if (keyFound)
				break;
		}
	}
}
