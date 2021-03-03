# AguirreAssignment06
Assignment #6  Mattson

For this assignment you will create new programs to demonstrate your knowledge of Exception handling.  (use the following UML class diagram)

Assignment6UML2.PNG                

DepositTooLargeException

    Extend RuntimeException and use as custom exception
    Overload constructor for default constructor and one with message

InsufficientFundsException

    Extend RuntimeException and use as custom exception
    Overload constructor for default constructor and one with message

Customer

    Create data as shown
    Create getters and setters for data
    Create a toString for data as shown in example session
    Create deposit method with the following rule: Customers cannot deposit anything >= 10,000. If they do, then:
        Throw an DepositTooLargeException(do not handle here with try catch, just throw)
        Send a message in the exception "You have exceeded the maximum deposit amount for this branch. Transaction suspended."
    Create withdraw method with the following rule: Customers cannot withdraw more money than they have. If they do, then:
        Throw an InsuficientFundsException (do not handle here with try catch, just throw)
        Send the a message in the exception "You do not have enough money to withdraw $" + variable + ". You are short $" + variable+ " Transaction suspended."

BankDriver

This startup BankDriver program is provided under Files here.

    Create an Array of Customer with a physical size of 3
    Create a Scanner object for user input
    Create appropriate variables to collect data and use with your loop
    Create a loop with a sentinel value to exit, such as -1
    In the loop create a menu with the following statement and options

Welcome to Weber State Bank. How may I help you
                   1) Create New Customer
                    2) Remove a Customer
                    3) Print Customer List
                   4) Print a Specific Customer
                   5) Load Customer Data From File
                   6) Make a deposit
                    7) Make a withdrawal
                   -1)To Exit);

For  each of these options, do the following:

1) Create New Customer

    Get user input for all data required by the Customer constructor
    Get the opening balance third. This is so you have to flush the buffer before getting the ssn
    When getting the opening balance you will need to do some input validation.  If the user enters the wrong type of data, you must throw catch the appropriate exception.  For this part only, put it in a loop so they cannot continue until they have entered a positive number
    Create a customer object with your collected data
    Add the customer to your customers array.  
    Don't forget to increment your logical counter if successful
    Catch and handle any potential Exceptions 
    Remember to catch generic Exception at the end to handle any undefined exceptions by you

 

2) Remove a Customer

    Ask the user to enter the index of the customer to delete (this is the Array index)
    Remove the customer from the Array
    If customer is not at that index, catch exception and go back to menu
    Give message that Customer was removed at the given index position
    Do NOT decrement you logical counter. We want to create a hole in your array for testing null pointers.
    Catch any potential exceptions and add Exception to the end

3) Print Customer List

    Print the toString of all customers in the Array
    You can use Arrays.toString or make you own loop

4) Print a Specific Customer

    Ask the user to enter the index of the customer to print(this is the Array index
    If customer is not at that index, catch exception and go back to menu
    Print the customer's toString
    Handle any possible Exceptions like Index out of bounds, or Null pointer as well as generic Exception

5) Load Customer Data From File

    You will need to load the customer.txt file that I provided here.  Create a folder called res in your project and place the file there
    Use the try-with-resource statement to load your file.  This can be done as a Scanner in the try statement
    After you have loaded the file, assign the four pieces of data to variables
    Create a Customer object
    Add the new customer to the array and increment your logical counter
    Give feedback to the user that the Customer was Successfully added at an index position -- you assign next available spot.
    Handle any possible Exceptions like Index out of bounds, Input Mismatch or No Such Element as well as generic Exception

6) Make a Deposit

    Ask the user to enter the index of the customer to make a deposit
    If customer is not at that index, catch exception and go back to menu
    Make a temporary Customer from the given index position
    Check if that customer is NULL. If so, throw the appropriate Exception
    Next, ask the user the Amount they wish to Deposit
    Deposit the amount into the customer's account
    Catch any exceptions that can be thrown from the deposit method
    Handle any possible Exceptions like Index out of bounds, or Input Mismatch as well as generic Exception

7) Make a Withdrawal

    Ask the user to enter the index of the customer to make a withdrawal
    If customer is not at that index, catch exception and go back to menu
    Make a temporary Customer from the given index position
    Check if that customer is NULL. If so, throw the appropriate Exception
    Next, ask the user the Amount they wish to Withdraw
    Withdraw the amount from the customer's account
    Catch any exceptions that can be thrown from the withdraw method
    Handle any possible Exceptions like Index out of bounds, or Input Mismatch as well as generic Exception

-1) Exit the Program

Files

customer.txtPreview the document  

BankDriver.javaPreview the document  

Data Required

See UML

Methods Required

See UML

Analysis

The requirements were broken down above; here is a short list:

1) Create new Exceptions

2) Create  Customer Class

3) Create BankDriver Class

4) Flesh out BankDriver class according to specifications

5) After each successful or unsuccessful menu option, the program should reprint the menu

6) You should provide an appropriate error message for all Exceptions caught

7) Your program flow and messages may be slightly different than mine.  I am mostly concerned that you are catching all appropriate Exceptions and giving good feedback.  

Sample Session: When you run the BankDriver class your terminal output should look like this.

Menu

Welcome to Weber State Bank. How may I help you 
    1) Create New Customer
    2) Remove A Customer
    3) Print Customer List
    4) Print a Specific Customer
    5) Load Customer Data From File
    6) Make a deposit
    7) Make a withdrawal
    -1)To Exit

Option 1

What is the customer's first name: 
Bob
What is the customer's last name: 
Johnson
What is the customer's opening balance (numbers only): 
$1,000
You can only enter numbers for opening balance, try again. --Fail
What is the customer's opening balance (numbers only): 
1000 
What is the customer's SSN: 
222-33-4455

Option 2

Enter the Customer Index to Delete: 
1
Customer Removed at Index Position 1

Option 3

***Customer List***
[Customer [fName=Bob, lName=Johnson, ssn=22-44-5544, balance=1000.0]
, Customer [fName=Ben, lName=Jones, ssn=123-45-6789, balance=450.0]
, null]

Option 4

Fail

Enter the Customer Index to Print
3
java.lang.ArrayIndexOutOfBoundsException: 3 Sorry, That Customer Index is Out Of Range.

Fail

Enter the Customer Index to Print
2
java.lang.NullPointerException:  Sorry, That Customer Does Not Exist.

Success

Enter the Customer Index to Print
1
Customer [fName=Ben, lName=Jones, ssn=123-45-6789, balance=450.0]

Option 5

Fail

One of your data elements does not match the expected format (possible for bad number)

Success

Customer Successfully Added at Index Position 2 

Option 6

Fail

Enter the Customer Index to Deposit
0
Enter the Amount You Wish to Deposit
11000
Chapter7.DepositTooLargeException: You have exceeded the maximum deposit amount for this branch. Transaction suspended.

Success

Enter the Customer Index to Deposit
0
Enter the Amount You Wish to Deposit
9000
New Customer Balance: 9450.0

Option 7

Fail

Enter the Amount You Wish to Withdraw
6000
Chapter7.InsufficientFundsException: You do not have enough money to withdraw $6000.0. You are short $-5550.0 Transaction suspended.

Success

Enter the Customer Index to Withdraw
1
Enter the Amount You Wish to Withdraw
300
New Customer Balance: 150.0

 

Deliverable

For this assignment, you will need to zip all appropriate files for the project into one .zip file.  Your file name should be <lastnameAssignment06.zip> You will only submit your ZIP file.  Your output should match mine. Use my session example for the parameters to pass to your constructor.

Documentation

Make sure that you use comments for  all assignments.  As a minimum you should have comments for Author, Date, and Notes. Put this above your code and above the class declaration.

Not applicable for this assignment. Name it Student.java

Attach the.zip file and submit the program through Canvas.

NOTE: Proper indentation, commenting, Java programming conventions, and general readability are an important part of programming that can set apart a good programmer from an excellent programmer. Part of your score on each assignment (approximately 10%) will be based on those readability elements.
