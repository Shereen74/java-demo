import java.io.*;
import java.sql.*;
import java.util.*;
import java.time.LocalDate;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/Company";
    static final String USER = "postgres";
    static final String PASS = "1234";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        Data data = new Data();


        List<String> options = new ArrayList<String>();
        options.add("Option 1: View all employees");
        options.add("Option 2: Search for an employee using ID");
        options.add("Option 3: Insert new employee");
        options.add("Option 4: Delete an employee");

        data.displayOptions(options);

        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        input.nextLine();
        // Handling user choice

            if (choice >= 1 && choice <= options.size()) { //
                String selectedOption = options.get(choice - 1);
                System.out.println("You selected: " + selectedOption);

                if (choice == 1) {
                    data.getAllEmployees();
                }
                if (choice == 2) {
                    System.out.println("Enter employee ID");
                    String id = input.nextLine();
                    data.getEmployee(id);
                }
                if (choice == 3) {
                    System.out.println("Please enter the following data to insert new employee");

                    System.out.print("ID: ");
                    String id = input.nextLine();

                    System.out.print("First Name: ");
                    String firstName = input.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = input.nextLine();

                    System.out.print("Date Of Birth (format: DD/MM/YYYY): ");
                    String dob = input.nextLine();

                    System.out.print("Contact Number: ");
                    String contact = input.nextLine();

                    System.out.print("Email: ");
                    String email = input.nextLine();

                    boolean onVacation = false;

                    Employees emp1 = new Employees();
                    emp1.setId(id);
                    emp1.setFirstName(firstName);
                    emp1.setLastName(lastName);
                    emp1.setDob(dob);
                    emp1.setContactNum(contact);
                    emp1.setEmail(email);
                    emp1.setOnVacation(onVacation);

                    data.insertNewEmp(emp1);
                    System.out.println(emp1);

                }
                if(choice == 4){
                    String id = input.nextLine();
                    data.deleteEmp(id);
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }


        //--------------------------------Creating employees table-------

//        String sqlQuery = "CREATE TABLE IF NOT EXISTS Employees (" +
//                "empID VARCHAR(255) PRIMARY KEY," +
//                "firstName VARCHAR(30) NOT NULL," +
//                "lastName VARCHAR(30) NOT NULL," +
//                "dob VARCHAR(30) NOT NULL," +
//                "contact VARCHAR(20) NOT NULL," +
//                "email VARCHAR(50) NOT NULL," +
//                "onVacation BOOLEAN" +
//                ")";
//
//        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//             PreparedStatement statement = connection.prepareStatement(sqlQuery);
//        ) {
//            System.out.println("Connected to the database successfully...");
//            int results = statement.executeUpdate();
//            System.out.println(results + " rows affected. " + " Table created successfully...");
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }







//        System.out.println("Please enter the following data to insert new employee");
//        System.out.print("ID: ");
//        String id = input.nextLine();
//        System.out.print("First Name: ");
//        String firstName = input.nextLine();
//        System.out.print("Last Name: ");
//        String lastName = input.nextLine();
//        System.out.print("Date Of Birth (format: DD/MM/YYYY): ");
//        String dob = input.nextLine();
//        System.out.print("Contact Number: ");
//        String contact = input.nextLine();
//        System.out.print("Email: ");
//        String email = input.nextLine();
//        boolean onVacation = false;
//
//        Employees emp1 = new Employees();
//        emp1.setId(id);
//        emp1.setFirstName(firstName);
//        emp1.setLastName(lastName);
//        emp1.setDob(dob);
//        emp1.setContactNum(contact);
//        emp1.setEmail(email);
//        emp1.setOnVacation(onVacation);
//
//        data.insertNewEmp(emp1);
//        System.out.println(emp1);






        //Using set and hashset
//        Set<String> mySet = new HashSet<>();
//        HashSet<String> myHashSet = new HashSet<>();
//
//        mySet = new LinkedHashSet<>();
//
//        mySet.add("A");
//        mySet.add("Z");
//        mySet.add("C");
//
//        myHashSet.add("A");
//        myHashSet.add("Z");
//        myHashSet.add("C");



//        System.out.println("1st iteration");
//        for(String i: mySet){
//
//            System.out.println("Value\t" + i);
//        }
//
//        System.out.println();
//
//        System.out.println("2nd iteration");
//        for(String i: myHashSet){
//            System.out.println("Value\t" + i);
//        }

//        System.out.println("Enter a letter to check whether it's present");
//        while(true) {
//            String value = input.nextLine();
//            if (mySet.contains(value)) {
//                System.out.println("I found it!");
//                break;
//            } else {
//                System.out.println("Couldn't find it. Please choose another letter to search for");
//            }
//        }
//        System.out.println("Enter your favourite items");
//        while(true){
//            String item = input.nextLine(); //User input
//            if(item.equalsIgnoreCase("Done")){ //lw el user input kan done a3ml break
//                break;
//            } else  //Otherwise, add the next item
//            mySet.add(item);
//
//        }

        //---------Reading from a file--------
        /*
        File file = new File("C:\\Users\\shereen.elnady\\Desktop\\OOP Notes.txt");
        Scanner input = new Scanner(file);

        while(input.hasNextLine()){
            String line = input.nextLine();
            System.out.println(line);
        }
        input.close(); */

//       try{
//           emp.calcAge(2000);
//       } catch (Exception e) {
//           System.out.println(e);
//       }

//
//       HashMap<String, Employees> data = new HashMap<String, Employees>();
//
//        Employees emp1 = new Employees("S123", "Shereen", "Ibrahim", "23/04/2000", "345432", "shery123@gmail.com", false);
//        Employees emp2 = new Employees("A128", "Mohamed", "Ghareeb", "25/12/1999", "3032452", "mo123@gmail.com", true);
//        System.out.println("Writing array of objects...");
//        Employees[] emp = {new Employees("S124", "Sarah", "Ahmed", "23/04/2000", "345432", "sarah123@gmail.com", false),
//                new Employees("S125", "Farah", "Ayman", "23/05/2000", "345432", "farah123@gmail.com", true),
//                new Employees("S126", "Waleed", "Ibrahim", "23/04/1999", "345432", "waleed123@gmail.com", false)
//        };

//        Employees[] emp = {new Employees("S111", "Mariam", "Ahmed", "23/04/2000", "345432", "mariam@gmail.com", false),
//                new Employees("S129", "Ehab", "Ayman", "23/05/2000", "345432", "ehab@gmail.com", true),
//                new Employees("S114", "Mark", "Ibrahim", "23/04/1999", "345432", "mark@gmail.com", false)
//        };
//        try(FileOutputStream fs = new FileOutputStream("employees.txt", true)){
//
//            ObjectOutputStream os = new ObjectOutputStream(fs);
//            os.writeObject(emp);
//            os.close();
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        } catch(IOException e){
//            e.printStackTrace();
//        }


        //Reading our file...
//        System.out.println("Reading objects..");
//        try (FileInputStream fi = new FileInputStream("employees.txt");
//             ObjectInputStream oi = new ObjectInputStream(fi)) {
//
//            Object object = oi.readObject();
//
//            if (object instanceof Employees[]) {
//                Employees[] employees = (Employees[]) object;
//
//                for (Employees employee : employees) {
//                    System.out.println(employee);
//                }
//            } else {
//                System.out.println("The content of 'data.bin' is not an array of Employees.");
//            }
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//       String key1 = emp1.getId();
//       data.put(key1, emp1);
//       System.out.println(data.get(key1));

       //--------------------------------------------------------------------------------
//        System.out.println("Please enter 3 names (first and last names only");
//        String firstName = input.nextLine();
//        String lastName = input.nextLine();
//        String[][] names = new String[1][2];
//
////Each iteration should store 1 first name and 1 last name
//        for(int i = 0; i < names.length; i++){
//            for(int j = 0; j < names[i].length; j++) {
//                names[i][j] = input.nextLine();
//            }
//        }
//        for(int i = 0; i < names.length; i++){
//            for(int j = 0; j < names[i].length; j++) {
//                System.out.print(names[i][j] + "\t");
//            }
//        }

    }
}