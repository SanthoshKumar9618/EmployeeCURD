import models.Employee;
import services.EmployeeService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
            System.out.println("\n=== Employee CRUD Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    service.addEmployee(new Employee(id, name, dept, salary));
                    System.out.println("Employee Added!");
                    break;

                case 2:
                    System.out.println("\n--- Employees List ---");
                    service.getAllEmployees().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Dept: ");
                    String newDept = sc.nextLine();

                    System.out.print("New Salary: ");
                    double newSal = sc.nextDouble();

                    if (service.updateEmployee(uid, newName, newDept, newSal))
                        System.out.println("Employee Updated!");
                    else
                        System.out.println("Employee Not Found!");
                    break;

                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();

                    if (service.deleteEmployee(did))
                        System.out.println("Employee Deleted!");
                    else
                        System.out.println("Employee Not Found!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

             
                default:
                    System.out.println("Invalid Option!");
            }
        }
        }
    }
}
