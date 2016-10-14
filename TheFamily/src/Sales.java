/**
 * Created by seano on 13/10/2016.
 * TheFamily - table class for Sales.
 */

public class Sales {

    private int Sales_id;
    private double Commission_rate;
    private double Sales_total;

    public int getSales_id() {
        return Sales_id;
    }

    public void setSales_id(int sales_id) {
        Sales_id = sales_id;
    }

    public double getCommission_rate() {
        return Commission_rate;
    }

    public void setCommission_rate(double commission_rate) {
        Commission_rate = commission_rate;
    }

    public double getSales_total() {
        return Sales_total;
    }
    public void setSales_total(double sales_total) {
        Sales_total = sales_total;
    }

}
