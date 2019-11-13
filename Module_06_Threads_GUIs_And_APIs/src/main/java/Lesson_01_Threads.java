/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//In this lesson you will learn:
//		1) Threads
//			a) How to generate and execute new threads 
//			b) Scoping of variables used in thread (e.g., static, final, etc.)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Scanner;

public class Lesson_01_Threads {

	// Init list-related variables
	private static LinkedList<Integer> ll = new LinkedList<Integer>();
	private final static int numItems = 200000;
	
	// Init thread-related variables	
	private static int numThreads;
	private static int itemsPerThread;
	private static int nextThreadNum = 0;
	private static int threadsCompleted = 0;
	
	// Init timer-related variables
	private static long start;
	private static DecimalFormat df = new DecimalFormat("0,000");
	
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
		
		// Populate a linked list with a lot of items
		for (int i = 0; i < numItems; i++)
			ll.add(i);
		
		// Init timer
		System.out.println("Initializing timer and search process...");
		start = System.currentTimeMillis();
		
		// Launch a bunch of threads that each search through a sub-portion of the list
		for (int i = 0; i < numThreads; i++) {
			new Thread() {
				public void run() {
					
					// Get thread number and compute beginning and end index
					int threadNum = nextThreadNum++;
					int beg = threadNum * itemsPerThread;
					int end = (threadNum+1) * itemsPerThread - 1;
					if (threadNum == numThreads-1)
						end = ll.size()-1;
					//System.out.println(beg + " - " + end);

					// Begin search sub-process
					System.out.printf("Starting Thread %s (i = [%s, %s])...\n", threadNum, beg, end);
					searchList(ll, beg, end, -1);
					
					// Search is done! Print current timestamp
					long elapsedTime = System.currentTimeMillis() - start;
					System.out.printf("Ending thread %s at %sms\n", threadNum, df.format(elapsedTime));
					
					// Check if last thread
					if (++threadsCompleted == numThreads)
						System.out.printf("\n\nLast thread complete at %sms\n", df.format(elapsedTime));
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
	public static void searchList(LinkedList<Integer> ll, int startIndex, int endIndex, int key) {
		for (int i = startIndex; i <= endIndex; i++)
			if (ll.get(i) == key)
				System.out.printf("FOUND %s at index %s!\n", key, i);
	}
}
