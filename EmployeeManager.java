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
        String sFileName = "Employee.txt";
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
        inputFile.close(); //file is closed
    }//end of reading file
    public static void tokenize(ArrayList<String>fileContent,ArrayList<Employee>employees){
        for (String sLine: fileContent) {
            String [] tokens = sLine.split(",");
            Employee number = new Employee();
            employees.add(number);
        }
    }
    //start of printout
    private static void printCompanyEmployees(ArrayList<Employee>employees) {
        String sStars = String.format("%120s", " ").replace(' ', '*');
        String sDashed = String.format("%120s", " ").replace(' ', '-');
        System.out.printf("%s", sStars);
        System.out.printf("%n| %-12s | %-20s | %-20s | %-40s | %-20s",
                "EmployeeId ","First Name", "Last Name", "Email Address", "Salary");
        System.out.printf("%n%s", sDashed);
               for (Employee employee: employees) {
                   System.out.printf("%n| %-12s | %-20s | %-20s | %-40s | %-20.2f",
                           employee.getsID(),
                           employee.getsFirstName(),
                           employee.getsLastName(),
                           employee.getsEmail(),
                           employee.getdSalary());
               }
        System.out.printf("%n%s%n", sStars);
    }//end of print out
}//end of Employee Manager