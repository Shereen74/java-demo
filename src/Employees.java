import java.io.Serializable;
import java.time.*;

public class Employees implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String dob;
    private String contactNum;
    private String email;
    private boolean onVacation;

    private Data data;


    public Employees() {
    }

    public Employees(String id, String firstName, String lastName, String dob, String contactNum, String email, boolean onVacation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.contactNum = contactNum;
        this.email = email;
        this.onVacation = onVacation;
    }

    public Employees(String firstName, String lastName, String dob, String contactNum, String email, boolean onVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.contactNum = contactNum;
        this.email = email;
        this.onVacation = onVacation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOnVacation() {
        return onVacation;
    }

    public void setOnVacation(boolean onVacation) {
        this.onVacation = onVacation;
    }

    public static void calcAge(int year){
        LocalDate currentDate = LocalDate.now();
        int currYear = currentDate.getYear();
        int age = currYear - year;
        System.out.println(age);
        //throws and throw exception
        /*if(age < 18) {
            throw new ArithmeticException("Permission denied.");
        } else throw new ArithmeticException("Permission granted");
        */
        if(age < 18){
            throw new ArithmeticException("Permission denied");
        } else {
            System.out.println("Permission granted.");
        }
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", email='" + email + '\'' +
                ", onVacation=" + onVacation +
                '}';
    }

//    public static void addNewEmployee(String firstName, String lastName, String dob, String contactNum, String email, boolean onVacation){
//
//    }
}
