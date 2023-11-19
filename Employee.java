//Employee class that inherits from Company
public class Employee extends Company{
    //class attributes
    private String sFirstName; //Employee's First Name
    private String sLastName; //Employee's Last Name
    private String sEmail; //Employee Email
    private double dSalary = 0.00; //Employee's salary
    private int nCompanyYear = 0; //How many years Employee has been with company
    private String sEmployeeId; //Employee ID
    private String profession = "Undefined";//profession
    //constant
    private final double RATE_INCREASE = 0.0100; //rate increase
    private final double STARTING_SALARY = 0.00; //Starting salary
    //start of default constructor
    public Employee(){
    } //end of default constructor
    //first Employee overloader calc
    public Employee(String sFirstName, String sLastName) {
        this.sFirstName = sFirstName;
        this.sLastName = sLastName;
        new Email(sFirstName, sLastName, this);
        nCompanyYear = 0;
        sEmployeeId = PREFIX + ++nId;
    }//end of first calc
    //second Employee overloader calc
    public Employee(String sFirstName, String sLastName, int nYearsAtCompany, String sProfession) {
        this.sFirstName = sFirstName;
        this.sLastName = sLastName;
        new Email(sFirstName, sLastName, this);
        this.nCompanyYear = nCompanyYear;
        sEmployeeId = PREFIX + ++nId;
        setdDefaultSalary();
    }//end of second calc
    //third Employee overloader calc
    public Employee(String sFirstName, String sLastName, int nYearsAtCompany) {
        this.sFirstName = sFirstName;
        this.sLastName = sLastName;
        new Email(sFirstName, sLastName, this);
        this.nCompanyYear = nCompanyYear;
        sEmployeeId = PREFIX + ++nId;
    }//end of third calc
    //start of First Name getter
    public String getsFirstName() {
        return sFirstName;
    }//end of First name getter
    //start of first name setter
    public void setsFirstName(String sFirstName) {
        this.sFirstName = sFirstName;
    }//end of first name setter
    //start of last name getter
    public String getsLastName() {
        return sLastName;
    } //end of last name getter
    //start of last name setter
    public void setsLastName(String sLastName) {
        this.sLastName = sLastName;
    }//end of last name setter
    //start of email getter
    public String getsEmail() {
        return sEmail;
    }//end of email getter
    //start of email setter
    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    } //end of email setter
    //start of salary getter
    public double getdSalary() {
        return dSalary;
    }//end of salary getter
    //start of salary setter
    public void setdSalary(double dSalary) {
        this.dSalary = dSalary;
    }//end of salary setter
    public void setdDefaultSalary() {
        this.dSalary = calculateSalary(STARTING_SALARY, getnCompanyYear(), RATE_INCREASE);
    }
    //start of company year getter
    public int getnCompanyYear() {
        return nCompanyYear;
    }//end of company year getter
    //start of employee ID getter
    public String getsID() {
        return sEmployeeId;
    }//end of employee ID getter
    //start of calculation
    protected double calculateSalary(double dSalary, int nYears, double dRate) {
        if (nYears > 0) {
            return calculateSalary(dSalary + (dSalary * dRate), --nYears, dRate);
        }
        return dSalary;
    }//end of calculation
    //start of profession getter
    public String getProfession() {
        return profession;
    } //end of profession getter
    //start of profession setter
    public void setProfession(String profession) {
        this.profession = profession;
    } //end of profession setter
}//End of Employee class