import java.sql.ResultSet;
import java.util.HashMap;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Data {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/Company";
    public static final String USER = "postgres";
    public static final String PASS = "1234";

    public void displayOptions(List<String> options) {
        System.out.println("Select an option:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public void getAllEmployees() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sqlQuery = "SELECT * FROM Employees";
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
                 ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    // Retrieve values by column name or index
                    int id = rs.getInt("empID");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String dob = rs.getString("dob");
                    String contactNum = rs.getString("contact");
                    String email = rs.getString("email");
                    Boolean onVacation = rs.getBoolean("onVacation");


                    // Do something with the retrieved values
                    System.out.println("ID: " + id);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("DOB: " + dob);
                    System.out.println("Contact Number: " + contactNum);
                    System.out.println("Email: " + email);
                    System.out.println("On Vacation: " + onVacation);
                    System.out.println("---------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void getEmployee(String empID) {
        String sqlQuery = "SELECT * FROM Employees WHERE empID = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ) {
            System.out.println("Connected to the database successfully...");
            statement.setString(1, empID);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String id = rs.getString("empID");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String dob = rs.getString("dob");
                    String contactNum = rs.getString("contact");
                    String email = rs.getString("email");
                    Boolean onVacation = rs.getBoolean("onVacation");

                    System.out.println("ID: " + id);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("DOB: " + dob);
                    System.out.println("Contact Number: " + contactNum);
                    System.out.println("Email: " + email);
                    System.out.println("On Vacation: " + onVacation);
                    System.out.println("---------------------");
                } else System.out.println("Employee with ID " + empID + " not found.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //Insert New Employee
    public void insertNewEmp(Employees emp) {
        Scanner input = new Scanner(System.in);
        String query = "INSERT INTO Employees (empID, firstName, lastName, dob, contact, email, onVacation) VALUES (?,?,?,?,?,?,?)";


        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(query);
        ) {
            System.out.println("Connected to the database successfully...");
            statement.setString(1, emp.getId());
            statement.setString(2, emp.getFirstName());
            statement.setString(3, emp.getLastName());
            statement.setString(4, emp.getDob());
            statement.setString(5, emp.getContactNum());
            statement.setString(6, emp.getEmail());
            statement.setBoolean(7, emp.isOnVacation());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("Failed to insert employee. Please try again.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmp(String empID) {
        String sqlQuery = "DELETE FROM Employees WHERE id = ? OR empID IS NULL";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ) {
            System.out.println("Connected to the database successfully...");

            statement.setString(1, empID);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + empID + " deleted successfully.");
            } else {
                System.out.println("No employee found with ID " + empID + ". Deletion failed.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}