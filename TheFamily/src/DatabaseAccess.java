import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

    public List<Employee> getEmployee(int numberOfEmployees){
        Connection conn = null;
        List<Employee> employees = new ArrayList<Employee>();
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/TheFamily?useSSL=false",
                            "root", "password");

            Statement statement = null;

            statement = conn.createStatement();

            ResultSet result1 = statement.executeQuery(String.format(
                    "Select Employee_id, Name, Address, Ni_num, IBAN_num, Salary from Employee order by Employee_id desc limit %s",
                    numberOfEmployees));

            PreparedStatement prep1 = conn.prepareStatement(String.format(
                    "Select Employee_id, Name, Address, Ni_num, IBAN_num, Salary from Employee order by Employee_id desc limit %s",
                    numberOfEmployees));

            ResultSet result = prep1.executeQuery();

            while (result.next()){
                Employee employee = new Employee();
                employee.setId(result.getInt("Employee_id"));
                employee.setName(result.getString("Name"));
                employee.setAddress(result.getString("Address"));
                employee.setNi_num(result.getString("Ni_num"));
                employee.setIBAN_num(result.getString("IBAN_num"));
                employee.setSalary(result.getDouble("Salary"));

                employees.add(employee);
            }
        } catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }

        return employees;
    }

    //public void CreateEmployee(String )
}
