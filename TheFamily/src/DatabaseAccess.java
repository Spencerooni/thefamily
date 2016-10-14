import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

    public List<Employee> getEmployees() {
        Connection conn = null;
        List<Employee> employees = new ArrayList<Employee>();
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/TheFamily?useSSL=false",
                            "root", "password");

            PreparedStatement prep1 = conn.prepareStatement(
                    "Select Employee_id, Name, Address, Ni_num, IBAN_num, Salary, Bu_id, Type_id from Employee order by Employee_id desc");

            ResultSet result = prep1.executeQuery();

            while (result.next()) {
                Employee employee = new Employee();
                employee.setId(result.getInt("Employee_id"));
                employee.setName(result.getString("Name"));
                employee.setAddress(result.getString("Address"));
                employee.setNi_num(result.getString("Ni_num"));
                employee.setIBAN_num(result.getString("IBAN_num"));
                employee.setSalary(result.getDouble("Salary"));
                employee.setBu_id(result.getInt("Bu_id"));
                employee.setType_id(result.getInt("Type_id"));

                employees.add(employee);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }

        return employees;
    }


    public Employee CreateEmployee(String name, String address, String ni_num, String iban_num, double salary, int bu_id, int type_id) {
        Connection conn = null;

        List<Employee> employees = new ArrayList<Employee>();

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/TheFamily?useSSL=false", "root", "password");
            String sql = String.format("insert into Employee (Name, Address, Ni_num, IBAN_num, Salary, Bu_id, Type_id) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')", name, address, ni_num, iban_num, salary, bu_id, type_id);

            System.out.println(sql);

            PreparedStatement employeePrep = conn.prepareStatement(sql);

            int id = employeePrep.executeUpdate();
            System.out.println(id);


        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }

        return employees;
    }

    /////////////////HORRIBLE METHOD - SEAN /////////////////////////////
    ////////////////////////////////////////////////////////////////////

//    public List<Employee> getSalesEmployees() {
//        Connection conn = null;
//        List<Employee> salesEmployees = new ArrayList<Employee>();
//        try {
//            conn =
//                    DriverManager.getConnection("jdbc:mysql://localhost/TheFamily?useSSL=false",
//                            "root", "password");
//
//            PreparedStatement salesEmpPrep1 = conn.prepareStatement(
//                    "Select Employee_id, Name, Address, Ni_num, IBAN_num, Salary, Bu_id, Type_id, Sales_id from Employee order by Employee_id desc");
//
//            PreparedStatement salesEmpPrep2 = conn.prepareStatement(
//                    "Select Sales_id, Commission_rate, Sales_total from Sales");
//
//            ResultSet result1 = salesEmpPrep1.executeQuery();
//            ResultSet result2 = salesEmpPrep2.executeQuery();
//
//            while (result1.next()) {
//                Employee salesEmployee = new Employee();
//                salesEmployee.setId(result1.getInt("Employee_id"));
//                salesEmployee.setName(result1.getString("Name"));
//                salesEmployee.setAddress(result1.getString("Address"));
//                salesEmployee.setNi_num(result1.getString("Ni_num"));
//                salesEmployee.setIBAN_num(result1.getString("IBAN_num"));
//                salesEmployee.setSalary(result1.getDouble("Salary"));
//                salesEmployee.setBu_id(result1.getInt("Bu_id"));
//                salesEmployee.setType_id(result1.getInt("Type_id"));
//                salesEmployee.setSales_id(result1.getInt("Sales_id"));
//
//                Sales salesEmployee1 = new Sales();
//                salesEmployee1.setCommission_rate(result2.getDouble("Commission_rate");
//                salesEmployee1.setSales_total(result2.getDouble("Sales_total"));
//
//
//                salesEmployees.add(salesEmployee + salesEmployee1);
//            }
//        } catch (SQLException ex) {
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//
//        }
//
//        return salesEmployees;
//    }

    // Method to add Sales Employee - sean //
    public void createSalesEmployee(String name, String address, String ni_num, String iban_num,
                                    double salary, int bu_id, int type_id,
                                    double commission_rate, double sales_total){
        Connection conn = null;

        List<Employee> employees = new ArrayList<Employee>();

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/TheFamily?useSSL=false", "root", "password");
            String empSql = String.format("insert into Employee (Name, Address, Ni_num, IBAN_num, Salary, Bu_id, Type_id) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')", name, address, ni_num, iban_num, salary, bu_id, type_id);
            String salesSql = String.format("insert into Sales (Commission_rate, Sales_total) values ('%s', '%s')", commission_rate, sales_total);

            System.out.println(empSql);
            System.out.println(salesSql);

            PreparedStatement salesEmployeePrep = conn.prepareStatement(salesSql);
            PreparedStatement empPrep = conn.prepareStatement(empSql);

            int se = salesEmployeePrep.executeUpdate();
            int emp = empPrep.executeUpdate();


            System.out.println(se + "\n" + emp);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }

    }


    public List<String> EmpPerBu() {
        Connection conn = null;
        List<String> employees = new ArrayList<String>();

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/TheFamily?useSSL=false", "root", "password");
            String sql = String.format("select * from emp_per_bu");

            System.out.println(sql);

            PreparedStatement empbuPrep = conn.prepareStatement(sql);

            ResultSet result = empbuPrep.executeQuery();

            while (result.next()) {
                Employee employee = new Employee();
                employee.setName(result.getString("Employee"));

                BU bu = new BU();
                bu.setName(result.getString("BusinessUnit"));

                String fin = employee.toString() + " " + bu.toString();

                employees.add(fin);

                System.out.println(fin);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }

        return employees;
    }

}
