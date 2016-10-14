import java.util.List;

/**
 * Created by eamonc on 13/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        DatabaseAccess db = new DatabaseAccess();
        List<Employee> employees = db.getEmployees();

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

        db.CreateEmployee("S. O''Hara", "75 Woodland Walk, Limavady", "JX 22 22 33 L", "XX79 3704 0044 0532 0630 00", 20000, 1, 1);

        System.out.println("Employee Added to the System!");

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

        db.EmpPerBu();

        //db.createSalesEmployee("E. Compston", "12 Mount Charles", "JU 11 30 24 K", "UI23 3794 1095 0532 0630 00", 24000, 1, 1, 1, 0.25f, 39000);
        //System.out.println("Sales Employee Added to the System!");

        ///////// SOMETHING HERE ////////////


    }
}