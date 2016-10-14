import java.util.Scanner;

/**
 * Created by annem on 14/10/2016.
 */
public class Menu {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        String choiceMainMenu;
        int choiceHRMenu;
        int choiceReportMenu;
        int choiceAdminMenu;
        String ADMIN = "ADMIN";
        String choiceSalesEmp;
        int choiceFINANCEMenu;
        String name, address, niNum, ibanNum, bicNum;
        double salary;
        int buId, roleId;
        final String HR = "HR";
        final String FINANCE = "FINANCE";

        System.out.println("THE FAMILY DATABASE");
        System.out.println("\nLogin: Please enter your department: ");
        choiceMainMenu = keyboard.nextLine();

        switch (choiceMainMenu)
        {
            case HR:
                System.out.println("\n1. Add new employee");
                System.out.println("2. Generate a report");
                System.out.println("Please enter your choice: ");
                choiceHRMenu = keyboard.nextInt();

                if (choiceHRMenu == 1)
                {
                    System.out.println("Add new sales employee? (y/n): ");
                    choiceSalesEmp = keyboard.nextLine();

                    if ((choiceSalesEmp.equals("y")) || (choiceSalesEmp.equals("Y")))
                    {
                        // do the sales employee stuff in here
                    } else if ((choiceSalesEmp.equals("n")) || (choiceSalesEmp.equals("N")))
                    {
                        System.out.println("New Employee");
                        System.out.println("Name");
                        name = keyboard.nextLine();

                        System.out.println("Address");
                        address = keyboard.nextLine();

                        System.out.println("NI number");
                        niNum = keyboard.nextLine();
                        // method to convert to upper case and create spaces
                        // or do we need spaces

                        System.out.println("IBAN");
                        ibanNum = keyboard.nextLine();

                        System.out.println("BIC");
                        bicNum = keyboard.nextLine();

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

                        // put in here the excute update query
                    }
                } else if (choiceHRMenu == 2)
                {
                    System.out.println("Available reports: ");
                    System.out.println("1. Employees by Business Unit");
                    System.out.println("Please enter your choice: ");
                    choiceReportMenu = keyboard.nextInt();

                    if (choiceReportMenu == 1)
                    {
                        // do the Employees by BU report
                    } else
                    {
                        // Invalid input, back to HR Reports Menu
                    }

                }
                break;

            case FINANCE:
                System.out.println("1. Generate a report");
                System.out.println("Please enter your choice: ");
                choiceFINANCEMenu = keyboard.nextInt();

                if (choiceFINANCEMenu == 1)
                {
                    // do the report containing each employee and their gross pay for the current pay period
                } else
                {
                    // Invalid input, back to HR Reports Menu
                }
        }


    }// main

}
