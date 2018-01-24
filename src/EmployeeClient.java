
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

// **********************************************************************
// Programmer:      Erika Tvaskis
// Class:           CS30S
// Assignment 3:    Employee Payroll
// Description:     Prints the employee payroll list and locates specific info	
// Input:           Reads data from data file	
// Output:          Prints to output 
// ***********************************************************************

public class EmployeeClient 
    { //Begin class
    public static void main(String args[]) throws IOException  
    {  // begin main
    
//DECLARATION OF VARIABLES
    String strin;                       //String that reads file
    String delim = "[ ]+";              //Delimiter string for splitting input string
    String[] tokens;                    //Array for splitting strings
    String Decision;                    //Declaring Decision as String
    String Specifics;                   //Declaring Specifics as String
    Scanner Scanner;                    //Declaring Scanner as Scanner
    Scanner = new Scanner(System.in);   //Scanner for file
                       
    Double HourlyWage;  //Declaring HourlyWage as Double
    Double TotalHours;  //Declaring TotalHours as Double
    
    int Counter = 0;        //Counter for loading list loop  
    int ChosenEmployee = 0; //Declaring x as int 
    
    BufferedReader fin = null;  //Declaring fin as BufferedReader
    NumberFormat Dollar =NumberFormat.getCurrencyInstance(); //Dollar Formatting
    ArrayList <Employee> Employees = new ArrayList(); //Creating Array List
    
//GETTING BANNER AND PRINTING IT
    ProgramInfo programInfo = new ProgramInfo(); 
    System.out.println(programInfo.getBanner("Employee Payroll"));

//READING DATA FILE
    try {
        fin = new BufferedReader(new FileReader("EmployeeData.txt"));
    } //Closing bracket for try statement 
    catch (FileNotFoundException e) {
        System.out.println("file not found");
    } //Closing bracekt for catch statement
   
//LOAD ARRAY LIST
    strin = fin.readLine();    
    //Reads file line and assigns strin to it
    while (strin != null) {
        tokens = strin.split(delim);
        HourlyWage = Double.parseDouble(tokens[0]);
        TotalHours = Double.parseDouble(tokens[1]);
        //Splitting strin
        Employees.add(new Employee(HourlyWage, TotalHours));
        //Adding HourlyWage and Total Hours to Employees (Array List)
        Counter++;
        strin = fin.readLine();
    } //Closing bracket for while loop
    
//TABLE FORMAT
    System.out.println("***********************************************************************************************");
    System.out.format("%8s %12s %12s %12s %12s %12s \n","| Employee ID |","| Hourly Wage |","| Hours Worked |","| Regular Pay |","| Overtime Pay |","| Gross Pay |");//prints a table 
    for(Employee i: Employees) 
        System.out.format("%9s%17s%16s%18s%16s%16s%n", i.getEmployeeID(),Dollar.format(i.getHourlyWage()),i.getTotalHours() , Dollar.format(i.getRegularPay()) ,Dollar.format(i.getOvertimePay()) , Dollar.format(i.getGrossPay()) , "\n");
    System.out.println("***********************************************************************************************");
    
//SPECIFIC INFO
    System.out.println();
    System.out.println("Would you like to know specific information? -1 for no.");
    Decision = Scanner.nextLine();
    
//WHILE LOOP
    while (!(Decision.equals("-1"))) {
    System.out.println("Which employee would you like to know something specific about? Enter 1-5");
        try {
            ChosenEmployee = Integer.parseInt(Scanner.nextLine());
        } //Closing bracket for try
        catch (NumberFormatException e) {
            System.out.println("Please enter a numerical value");
            return;
        } //Closing bracket for catch
        if (ChosenEmployee > 5 || ChosenEmployee < 1) {
            System.out.println("Please enter a proper value");
            return;
        } //Closing bracket for if statement
    ChosenEmployee = ChosenEmployee - 1;
    System.out.println("What would you like to know?");
    System.out.println("Enter ID, HW (hourly wage), TH (total hours), RP (reg pay), OP (overtime pay), or GP (gross pay)");
    Specifics = Scanner.nextLine();
    switch (Specifics) {
        case "ID":
            System.out.println(Employees.get(ChosenEmployee).getEmployeeID());     
            break;
        case "HW":
            System.out.println(Dollar.format(Employees.get(ChosenEmployee).getHourlyWage())); 
            break;
        case "TH":
            System.out.println(Employees.get(ChosenEmployee).getTotalHours());   
            break;
        case "RP":
            System.out.println(Dollar.format(Employees.get(ChosenEmployee).getRegularPay()));    
            break;
        case "OP":
            System.out.println(Dollar.format(Employees.get(ChosenEmployee).getOvertimePay()));
            break;
        case "GP":
            System.out.println(Dollar.format(Employees.get(ChosenEmployee).getGrossPay())); 
            break;
        default:
            System.out.println("Please enter correct information"); 
            
    } //Closing bracket for switch
    System.out.println();
    System.out.println("Would you like to know more specific information? -1 for no");
    Decision = Scanner.nextLine();
    } //Closing bracket for while loop
    
    System.out.println();
    fin.close();
     
   } //End main
} //End class

