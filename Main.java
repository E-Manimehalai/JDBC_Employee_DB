package EmployeeApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee DB App ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(name, email, salary));
                    break;
                case 2:
                    dao.viewEmployees();
                    break;
                case 3:
                    System.out.print("ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String nname = sc.nextLine();
                    System.out.print("New Email: ");
                    String nemail = sc.nextLine();
                    System.out.print("New Salary: ");
                    double nsalary = sc.nextDouble();
                    dao.updateEmployee(new Employee(uid, nname, nemail, nsalary));
                    break;
                case 4:
                    System.out.print("ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteEmployee(did);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
