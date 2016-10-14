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
                            "root", "T!a1a!ng0");

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


    public List<Employee> CreateEmployee(String name, String address, String ni_num, String iban_num, double salary, int bu_id, int type_id) {
        Connection conn = null;

        List<Employee> employees = new ArrayList<Employee>();

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/TheFamily?useSSL=false", "root", "T!a1a!ng0");
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

    // Method to add Sales Employee - sean //
    public void createSalesEmployee(String name, String address, String ni_num, String iban_num,
                                    double salary, int bu_id, int type_id,
                                    double commission_rate, double sales_total){
        Connection conn = null;

        List<Employee> employees = new ArrayList<Employee>();

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/TheFamily?useSSL=false", "root", "T!a1a!ng0");
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
                    DriverManager.getConnection("jdbc:mysql://localhost/TheFamily?useSSL=false", "root", "T!a1a!ng0");
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
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
        return employees;
    }

}
