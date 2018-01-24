
import java.text.NumberFormat;

// **********************************************************************
// Programmer:      Erika Tvaskis
// Class:           CS30S
// Assignment 3:    Employee Payroll 
// Description:     Creates employee object and caluclates different pays
// ***********************************************************************

public class Employee 
    { //Begin class
    
//CLASS VARIABLES
    private static int nextEmployeeID = 1000;   //Unique ID number

//INSTANCE CONSTANTS
    private final double OvertimeRate = 1.5;    //Declare overtime rate
    private final int WeeklyHours = 40;         //Declare weekly hours
     
//INSTANCE VARIABLES
    private double HourlyWage = 0.0;    //HourlyWage of employee
    private double TotalHours = 0.0;    //TotalHours of employee
    private int n = 0;                  //Declaring n as int
    private int EmployeeID = 0;         //Employee ID
    
//CONSTRUCTORS 
     
/********************************************************
* Purpose: Create a new employee with default properties
* Interface:
* In:   none      
* Out:  none
********************************************************/
    public Employee(){
        EmployeeID = nextEmployeeID++;  //Assign and increment ID
        HourlyWage = 0; //set HourlyWage to zero
        TotalHours = 0; //set TotalHours to zero
    } //End of default constructor    
    
/********************************************************
* Purpose: Create a new employee with initialized properties
* Interface:
* In:   none
* Out:  none
********************************************************/
    public Employee(double hw, double th){
        EmployeeID = nextEmployeeID++;  //Assign and increment ID
        HourlyWage = hw;    //set HourlyWage to hw
        TotalHours = th;    //set TotalHours to th
    } //End of default constructor
    
//ACCESSORS

/********************************************************
* Purpose: Get the employee's hourly wage
* Interface:
* In:  none 
* Returns: HourlyWage: double
********************************************************/
    public double getHourlyWage(){
        return HourlyWage;
    } //End of getHourlyWage()
    
/********************************************************
* Purpose: Get the employee's total hours
* Interface:
* In:  none 
* Returns: TotalHours: double
********************************************************/
    public double getTotalHours(){
        return TotalHours;
    } //End of getTotalHours()
    
/********************************************************
* Purpose: Get the ID of the employee
* Interface:
* In:  none 
* Returns: ID: integer
********************************************************/
    public int getEmployeeID(){
        return EmployeeID;
    } //End of getEmployeeID()
    
/********************************************************
* Purpose: Calculate the regular pay
* Interface:
* In: none 
* Out: RegularPay: double
********************************************************/
    public double getRegularPay(){
        return HourlyWage * TotalHours;
    } //End getRegularPay()
    
/********************************************************
* Purpose: Calculate the overtime pay (overtime pay alone)
* Interface:
* In: none 
* Out: OvertimePay: double
********************************************************/
    public double getOvertimePay(){
        double OvertimeHours;
        double OvertimePay;
        OvertimeHours = TotalHours - WeeklyHours;                                        
        OvertimeHours = Math.max(0, OvertimeHours);
        OvertimePay = HourlyWage * OvertimeHours * OvertimeRate;                                
        return OvertimePay;
    } //End getOvertimePay()
  
/********************************************************
* Purpose: Calculate the gross pay
* Interface:
* In: none 
* Out: GrossPay: double
********************************************************/
    public double getGrossPay(){                 
        return this.getOvertimePay() + this.getRegularPay();
    } //End getOvertimePay()

/********************************************************
* Purpose: Return a formatted string of the employee's info
* Interface:
* In: none 
* Out: EmployeeInfo: String
********************************************************/
    public String toString(){
        String EmployeeInfo;   //formatted string with all e mployee info
        NumberFormat Dollar =NumberFormat.getCurrencyInstance();
        EmployeeInfo = "Employee Id: " + EmployeeID + "\n";
        EmployeeInfo += "Hourly Wage: " + Dollar.format(this.getHourlyWage()) + "\n";
        EmployeeInfo += "Total Hours: " + Dollar.format(this.getTotalHours()) + "\n";
        EmployeeInfo += "Regular Pay: " + Dollar.format(this.getRegularPay()) + "\n";
        EmployeeInfo += "Overtime Pay: " + Dollar.format(this.getOvertimePay()) + "\n";
        EmployeeInfo += "Gross Pay: " + Dollar.format(this.getGrossPay()) + "\n";
        return EmployeeInfo;
    } //End toString()
    
} //End class
