import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Class for Print out Employees
public class EmployeeManager {
    //start of main
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> fileContent = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();

        readFileContent(fileContent);
        tokenize(fileContent,employees);
        printCompanyEmployees(employees);
    }//end of main
    //reads the File content
    private static void readFileContent(ArrayList<String> fileContent) throws FileNotFoundException {
        boolean bFileExists = false;
        String sFileName = "Employees2.txt";
        File file = new File(sFileName);
        Scanner inputFile = new Scanner (file);
        //check if file exists
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            //adds lines for each employee
            while (scanner.hasNext()) {
                fileContent.add(scanner.nextLine());
            }//end of adding lines for each employee
        }//end of check if File exists
        inputFile.close();//file is closed
    }//end of reading file
    //tokenizing the file
    public static void tokenize(ArrayList<String>fileContent,ArrayList<Employee>employees){
       //adding lines to printout
        for (String sLine: fileContent) {
            String [] tokens = sLine.split("#");
            Employee number = new Employee(tokens[0], tokens[1]);
            employees.getProfession(tokens[2]);
            employees.getnCompanyYear(tokens[3]);
            EmployeeManager software = new SoftwareEngineerEmployee ("SWE", "Software Engineer");
            EmployeeManager project = new ProjectManagerEmployee ("PM", "Project Manager");
            EmployeeManager anything = new Employee("N/A", "Undefined");
            employees.add(number);
        }//end of adding lines
    }//end of tokenize
    //start of printout
    private static void printCompanyEmployees(ArrayList<Employee>employees) {
        String sStars = String.format("%120s", " ").replace(' ', '*');
        String sDashed = String.format("%120s", " ").replace(' ', '-');
        System.out.printf("%s", sStars);
        System.out.printf("%n| %-12s | %-20s | %-20s | %-20s | %-40s | %-20s | %-10s", "EmployeeId ",
                "Profession", "First Name", "Last Name", "Email Address", "Salary", "Years at Company");
        System.out.printf("%n%s", sDashed);
        //start of categories
               for (Employee employee: employees) {
                   System.out.printf("%n| %-12s | %-20s | %-20s | %-40s | %-20.2f",
                           employee.getsID(),
                           employee.getProfession(),
                           employee.getsFirstName(),
                           employee.getsLastName(),
                           employee.getsEmail(),
                           employee.getdSalary(),
                           employee.getnCompanyYear());
               }//end of categorizing
        System.out.printf("%n%s%n", sStars);
    }//end of print out
}//end of Employee Manager