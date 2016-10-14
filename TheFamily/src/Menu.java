import java.util.List;
import java.util.Scanner;

/**
 * Created by annem on 14/10/2016.
 */
public class Menu {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        String choiceMainMenu;

        int choiceHRMenu = 0;
        int choiceReportMenu;
        int choiceFINANCEMenu;
        String name, address, niNum, ibanNum, bicNum;
        double salary, comRate, totalSales;

        int buId, roleId;
        final String HR = "HR";
        final String FINANCE = "FINANCE";

        DatabaseAccess db = new DatabaseAccess();

        List<Employee> employees = db.getEmployees();
        List<String> fromReport;

        System.out.println("THE FAMILY DATABASE");
        System.out.println("\nLogin: Please enter your department: ");
        choiceMainMenu = keyboard.nextLine();

        do {

            switch (choiceMainMenu) {
                case HR:
                    System.out.println("\n1. Add new employee");
                    System.out.println("2. Generate a report");
                    System.out.println("0. Exit the System");
                    System.out.println("Please enter your choice: ");
                    choiceHRMenu = keyboard.nextInt();

                    if (choiceHRMenu == 1) {

                        System.out.println("New Employee");
                        System.out.println("Name");
                        name = keyboard.next();

                        System.out.println("Address");
                        address = keyboard.next();

                        System.out.println("NI number");
                        niNum = keyboard.next();
                        // method to convert to upper case and create spaces
                        // or do we need spaces

                        System.out.println("IBAN");
                        ibanNum = keyboard.next();

                        System.out.println("BIC");
                        bicNum = keyboard.next();

                        System.out.println("Salary");
                        salary = keyboard.nextDouble();

                        System.out.println("1. Evolve");
                        System.out.println("2. SMART");
                        System.out.println("3. Enterprise");
                        System.out.println("Business Unit:");
                        buId = keyboard.nextInt();

                        System.out.println("1. Sales");
                        System.out.println("2. Consultant");
                        System.out.println("3. Architect");
                        System.out.println("Role:");
                        roleId = keyboard.nextInt();

                        if (roleId == 1) {

                            System.out.println("Commission Rate");
                            comRate = keyboard.nextDouble();

                            System.out.println("Total Sales");
                            totalSales = keyboard.nextDouble();

                           db.createSalesEmployee(name, address, niNum, ibanNum, salary, buId, roleId, comRate, totalSales);
                           employees = db.getEmployees();

                            employees.stream()
                                    .map(x ->
                                            String.format("%s, %s, %s, %s, %s, %s, %s, %s",
                                                    x.getId(),
                                                    x.getName(),
                                                    x.getAddress(),
                                                    x.getNi_num(),
                                                    x.getIBAN_num(),
                                                    x.getSalary(),
                                                    x.getBu_id(),
                                                    x.getType_id())
                                    ).forEach(System.out::println);

                        } else {

                            db.CreateEmployee(name, address, niNum, ibanNum, salary, buId, roleId);
                            employees = db.getEmployees();

                            employees.stream()
                                    .map(x ->
                                            String.format("%s, %s, %s, %s, %s, %s, %s, %s",
                                                    x.getId(),
                                                    x.getName(),
                                                    x.getAddress(),
                                                    x.getNi_num(),
                                                    x.getIBAN_num(),
                                                    x.getSalary(),
                                                    x.getBu_id(),
                                                    x.getType_id())
                                    ).forEach(System.out::println);

                        }

                    } else if (choiceHRMenu == 2) {
                        System.out.println("Available reports: ");
                        System.out.println("1. Employees by Business Unit");
                        System.out.println("Please enter your choice: ");
                        choiceReportMenu = keyboard.nextInt();

                        if (choiceReportMenu == 1) {

                            fromReport = db.EmpPerBu();
                            fromReport.stream()
                                .forEach(System.out::println);
                        }
                    }
                    break;

                case FINANCE:
                    System.out.println("1. Generate a report");
                    System.out.println("Please enter your choice: ");
                    choiceFINANCEMenu = keyboard.nextInt();


                    if (choiceFINANCEMenu == 1) {
                        System.out.println("Work in progress");
                    }
            }
        } while ((choiceHRMenu != 0));
    }// main
}
