/**
 * Created by eamonc on 13/10/2016.
 */
public class Employee {
        private int Employee_id;
        private String Name;
        private String Address;
        private String Ni_num;
        private String IBAN_num;
        private double Salary;

        public int getId() {
            return Employee_id;
        }
        public void setId(int id) {
            this.Employee_id = id;
        }

        public String getName() {
            return Name;
        }
        public void setName(String name) {
            this.Name = name;
        }

        public String getAddress() {
            return Address;
        }
        public void setAddress(String address) {
            this.Address = address;
        }

        public String getNi_num() {
            return Ni_num;
        }
        public void setNi_num(String ni_num) {
            this.Ni_num = ni_num;
        }

        public String getIBAN_num() {
        return IBAN_num;
    }
        public void setIBAN_num(String iban_num) {
        this.IBAN_num = iban_num;
    }

        public double getSalary() {
            return Salary;
        }
        public void setSalary(double salary) {
            this.Salary = salary;
        }

}
