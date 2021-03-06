
/**
 * @author: Adam Aguirre
 * Assignment 06
 * 3/2/21
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDriver {
	public static int nextIn = 0;

	public static void main(String[] args) {
		Customer[] customers = new Customer[3];
		Scanner input = new Scanner(System.in);
		int custCount = 0; // track logical size of array.
		int choice = 0; // menu option choice
		String fName, lName, ssn;
		double balance = 0;

		while (choice != -1) {
			System.out.println("Welcome to Weber State Bank. How May I Help You" + "\n\t1) Create New Customer"
					+ "\n\t2) Remove A Customer" + "\n\t3) Print Customer List" + "\n\t4) Print a Specific Customer"
					+ "\n\t5) Load Customer Data From File" + "\n\t6) Make a Deposit" + "\n\t7) Make a Withdrawl"
					+ "\n\t-1) Exit Program");
			choice = input.nextInt();
			input.nextLine();
			if (choice == -1)
				break;

			// ********** Choice 1 ************
			if (choice == 1) {
				// Get input for all customer data -- 4 fields.
				// make sure your ask for opening balance third (use a loop) throw exception if
				// wrong type
				// keep looping until you get a good number.
				// then make sure you flush the buffer
				// create customer object
				// add the customer to the array
				// increment logical counter -- custCount
				// handle all other possible exceptions. Index out of bounds. And Exception as
				// default.
				System.out.println("Enter a first name");
				fName = input.nextLine();
				System.out.println("Enter a last name");
				lName = input.nextLine();
				while (true) {
					try {
						System.out.println("Enter the initial deposit(numbers only)");
						balance = input.nextInt();
						break;
					} catch (InputMismatchException e) {
						input.nextLine();
					}
				}
				input.nextLine();
				System.out.println("Enter a ssn");
				ssn = input.nextLine();
				// input.close();
				Customer newCustomer = new Customer(fName, lName, balance, ssn);

				customers[getNext(customers)] = newCustomer;
				custCount++;
			}

			// ********** Choice 2 ************
			if (choice == 2) {
				// ask for the index to remove
				// set that index position of array to null;
				// Exceptions to handle. Out of bounds. And Exception as default.
				// dont decrement logical counter
				System.out.println("What index should be removed?");
				int index = input.nextInt();
				input.nextLine();

				try {
					if (customers[index] == null)
						throw new NullPointerException("Customer does not exist");
					customers[index] = null;
					System.out.println("Customer " + index + " was removed.");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid customer number");
					continue;
				} catch (NullPointerException e) {
					System.out.println("Customer does not exist");
					continue;
				} catch (Exception e) {
					System.out.println("Customer was not found");
				}
			}

			// ********** Choice 3 ************
			if (choice == 3) {
				// use a printline statement to print Arrays.toString(name);
				System.out.println(Arrays.toString(customers));
			}

			// ********** Choice 4 ************
			if (choice == 4) {
				// ask for the index of customter to print
				// retrieve the customer
				// print that customer's tostring
				// Capture index out of bounds and null pointer.
				System.out.println("What customer index should be printed");
				int index = input.nextInt();
				input.nextLine();
				try {
					if (customers[index] == null)
						throw new NullPointerException("Customer does not exist");
					System.out.println(customers[index]);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Customer index out of range");
				} catch (NullPointerException e) {
					System.out.println("Customer does not exist");
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			// ********** Choice 5 ************
			if (choice == 5) {

				// Use try with resource
				// Open the file that is provided in the assignment.
				// handle any exceptions to file not opening or not found
				// assign data for customer from Scanner file. inputData.next();
				// dont forget to flush the buffer after a number.
				// create a temporary customer.
				// add customer to the array.
				// print out the success to customer with index.
				// increment the logical counter.
				// handle any exceptions.
				try (Scanner scan = new Scanner(new File("customer.txt"))) {
					scan.useDelimiter(" ");
					fName = scan.next();
					lName = scan.next();
					balance = scan.nextDouble();
					ssn = scan.next();

					Customer newCustomer = new Customer(fName, lName, balance, ssn);
					int index = getNext(customers);
					customers[index] = newCustomer;
					custCount++;
					System.out.println("Successfully added customer at index " + index);

				} catch (FileNotFoundException e) {
					System.out.println(e);
				} catch (InputMismatchException e) {
					System.out.println("One of your elements does not match expected format(possible for bad numbers)");
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			// ********** Choice 6 ************
			if (choice == 6) {
				// ask for customer index
				// pull the customer out of array and make temp cust
				// handle possible null
				// make a deposit for customer, and handle possible exception.
				// print balance information
				// handle any additional exceptions
				System.out.println("What index of customer should make deposite");
				int index = input.nextInt();
				input.nextLine();
				System.out.println("Deposite amount:");
				int amount = input.nextInt();
				input.nextLine();
				try {
					if (customers[index] == null)
						throw new NullPointerException("Customer does not exist");
					if (amount >= 10000)
						throw new DepositTooLargeException("Amount must be smaller than 10,000");
					customers[index].deposit(amount);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Customer index is out of bounds");
					continue;
				} catch (NullPointerException e) {
					System.out.println("Customer does not exist");
					continue;
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			// ********** Choice 7 ************
			if (choice == 7) {
				// ask for customer index
				// pull customer out of array and make temp cust
				// handle possible null;
				// make withdraw for cust, and handle possible exception
				// print balance info
				// handle any additional exceptions
				System.out.println("What index of customer should make withdrawal");
				int index = input.nextInt();
				input.nextLine();
				System.out.println("Withdrawal amount:");
				int amount = input.nextInt();
				input.nextLine();
				try {
					if (customers[index] == null)
						throw new NullPointerException("Customer does not exist");
					if (amount > customers[index].getBalance())
						throw new InsufficientFundsException("Withdrawl amount exceeds funds in account");
					customers[index].withdrawl(amount);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Customer index is out of bounds");
					continue;
				} catch (NullPointerException e) {
					System.out.println("Customer does not exist");
					continue;
				} catch (Exception e) {
					System.out.println(e);
				}

			}

		} // end loop

		System.out.println("************************************************************");
		System.out.println("Thank you for Coming to Weber State Bank, Have a Good Day!");
		System.out.println("************************************************************");

	}

	public static int getNext(Customer[] c) {
		/**
		 * Wasn't sure how to handle putting customers in the array so I set it to
		 * prioritize nulls and then just kind of do one after no null values exist
		 */
		int next = nextIn;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == null) {
				next = i;
				break;
			}
		}
		nextIn++;
		if (nextIn > 2) {
			nextIn = 0;
		}

		return next;
	}
} // end main class
