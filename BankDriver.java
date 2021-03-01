
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankDriver {

	public static void main(String[] args) {
		Customer[] customers = new Customer[3];
		Scanner input = new Scanner(System.in);
		int custCount = 0;  // track logical size of array.		
		int choice = 0;  // menu option choice
		String fName, lName, ssn;
		double balance = 0; 

		while(choice != -1) {
			System.out.println("Welcome to Weber State Bank. How May I Help You"
					+ "\n\t1) Create New Customer"
					+ "\n\t2) Remove A Customer"
					+ "\n\t3) Print Customer List"
					+ "\n\t4) Print a Specific Customer"
					+ "\n\t5) Load Customer Data From File"
					+ "\n\t6) Make a Deposit"
					+ "\n\t7) Make a Withdrawl"
					+ "\n\t-1) Exit Program");
			choice = input.nextInt();
			if(choice == -1) break;

			// ********** Choice 1 ************
			if(choice == 1) {
				// Get input for all customer data -- 4 fields.  
				// make sure your ask for opening balance third (use a loop) throw exception if wrong type
				//    keep looping until you get a good number.
				// then make sure you flush the buffer
				// create customer object
				// add the customer to the array
				// increment logical counter -- custCount
				// handle all other possible exceptions. Index out of bounds.  And Exception as default. 
				String fName;
				String lName;
				double deposit;
				String ssn;

				Scanner scan = new Scanner(System.in);
				System.out.println("Enter a first name");
				fName = scan.nextLine;
				System.out.println("Enter a last name");
				lName = scan.nextLine;
				System.out.println("Enter the initial deposit");
				deposit = scan.
				System.out.println("Enter a ssn);
			}

			// ********** Choice 2 ************
			if(choice == 2) {
				// ask for the index to remove 
				// set that index position of array to null;
				// Exceptions to handle.  Out of bounds. And Exception as default.
				// dont decrement logical counter
			}
			
			

			// ********** Choice 3 ************
			if(choice == 3) {
				// use a printline statement to print Arrays.toString(name);
			}

			// ********** Choice 4 ************
			if(choice == 4) {
				// ask for the index of customter to print
				// retrieve the customer 
				// print that customer's tostring
				// Capture index out of bounds and null pointer. 
			}

			// ********** Choice 5 ************
			if(choice == 5) {
				
				// Use try with resource
				// Open the file that is provided in the assignment. 
				// handle any exceptions to file not opening or not found
				// assign data for customer from Scanner file.  inputData.next();
				// dont forget to flush the buffer after a number. 
				// create a temporary customer. 
				// add customer to the array.
				// print out the success to customer with index.
				// increment the logical counter.
				// handle any exceptions.  
			}

			// ********** Choice 6 ************
			if(choice == 6) {
				// ask for customer index
				// pull the customer out of array and make temp cust
				// handle possible null
				// make a deposit for customer, and handle possible exception. 
				// print balance information
				// handle any additional exceptions
			}

			// ********** Choice 7 ************
			if(choice == 7) {
				// ask for customer index
				// pull customer out of array and make temp cust
				// handle possible null;
				// make withdraw for cust, and handle possible exception
				// print balance info
				// handle any additional exceptions
				
			}

		}// end loop


		System.out.println("************************************************************");
		System.out.println("Thank you for Coming to Weber State Bank, Have a Good Day!");
		System.out.println("************************************************************");


	}
} //end main class
