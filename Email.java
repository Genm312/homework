//Email class that inherits from Employee
public class Email extends Employee{
    private final String AT = "@";//email @
    private final String HANDLE = ".net";//email website handle
    private final String DOT = ".";//email period
    //start of overloaded constructor
    public Email (String sFirstName, String sLastName, Employee employee) {
        employee.setsEmail(sFirstName + DOT + sLastName + AT + COMPANY_NAME + HANDLE); //sets proper email
    }//end of overloaded constructor
}//end of Email class