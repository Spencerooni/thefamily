/**
 * Created by seano on 13/10/2016.
 * TheFamily - table class for BU.
 */

public class BU {

    private int Bu_id;
    private String Bu_name;

    public int getBu_id() {
        return Bu_id;
    }

    public void setBu_id(int bu_id) {
        Bu_id = bu_id;
    }

    public String getName() {
        return Bu_name;
    }

    public void setName(String name) {
        this.Bu_name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
