import java.util.List;

/**
 * Created by eamonc on 13/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        DatabaseAccess db = new DatabaseAccess();
        List<Employee> employees = db.getEmployee(4);

        employees.stream()
                .map(x ->
                String.format("%s","%s","%s","%s","%s","%s",
                        x.getId(),
                        x.getName(),
                        x.getAddress(),
                        x.getNi_num(),
                        x.getIBAN_num(),
                        x.getSalary())
                ).forEach(System.out::println);
    }

}
