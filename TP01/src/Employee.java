public class Employee {
    final private String SHOW_INFORMATION_TEXT = "%s %s, %s. Fonction: %s\n%d années dans l'entreprise. Salaire : %,.1fCHF par mois, %,.0fCHF";

    private String name;
    private String firstName;
    private String address;
    private String fonction;
    private int yearsInTheCompany;
    private double netMensualSalary;

    public Employee(String name, String firstName, String address, String fonction, int yearsInTheCompany, double netMensualSalary) {
        this.name = name;
        this.firstName = firstName;
        this.address = address;
        this.fonction = fonction;
        this.yearsInTheCompany = yearsInTheCompany;
        this.netMensualSalary = netMensualSalary;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getFonction() {
        return fonction;
    }

    public int getYearsInTheCompany() {
        return yearsInTheCompany;
    }

    public double getNetMensualSalary() {
        return netMensualSalary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setYearsInTheCompany(int yearsInTheCompany) {
        this.yearsInTheCompany = yearsInTheCompany;
    }

    public double getBonus() {
        return getNetMensualSalary() * (1 + Double.valueOf(getYearsInTheCompany()) / 100);
    }

    public void showInformation() {
        System.out.println(String.format(SHOW_INFORMATION_TEXT, getName(), getFirstName(), getAddress(), getFonction(), getYearsInTheCompany(), getNetMensualSalary(), getBonus()));
    }
}
