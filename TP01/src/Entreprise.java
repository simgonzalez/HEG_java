import java.util.ArrayList;

public class Entreprise {
    public enum EnterpriseType {
        PUBLIQUE,
        PRIVEE,
        SEMI_PUBLIQUE;
    }
    final private String SHOW_INFORMATION_TEXT = "Entreprise %s détenue par %s dans le domaine %s\nL'entreprise possède %d batiments pour %d employés";
    private String name;
    private String address;
    private EnterpriseType type;
    private int noBuilding;
    private String domain;
    //private ArrayList<Employee> employees;
    private int noEmployee; //= employees.size();
    private String mainHolder;

    public Entreprise(String name, String address, EnterpriseType type, int noBuilding, String domain, int noEmployee, String mainHolder) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.noBuilding = noBuilding;
        this.domain = domain;
        this.noEmployee = noEmployee;
        this.mainHolder = mainHolder;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getMainHolder() {
        return this.mainHolder;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getEmployeeNo() {
        return this.noEmployee;
    }

    public int getBuildingNo() {
        return this.noBuilding;
    }

    public void setNoBuilding(int noBuilding) {
        this.noBuilding = noBuilding;
    }

    public void setNoEmployee(int noEmployee) {
        this.noEmployee = noEmployee;
    }

    public void setType(EnterpriseType type) {
        if (type.equals(EnterpriseType.PUBLIQUE)) {
            this.mainHolder = "L'état";
        } else {
            if (this.mainHolder.equals("L'état")) {
                this.mainHolder = "TBD";
            }
        }
        this.type = type;
    }

    public String getType() {
        switch (type) {
            case PUBLIQUE:
                return "publique";
            case PRIVEE:
                return "privée";
            case SEMI_PUBLIQUE:
                return "semi-publique";
        }
        return "ERROR";
    }

    public void showInformations() {
        showInformations(false);
    }

    public void showInformations(boolean isShowPartial) {
        System.out.println(getName() + ", " + getAddress());
        if (!isShowPartial) {
            System.out.println(String.format(SHOW_INFORMATION_TEXT, getType(), getMainHolder(), getDomain(), getBuildingNo(), getEmployeeNo()));
        }
    }
}
