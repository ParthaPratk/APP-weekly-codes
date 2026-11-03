
import java.sql.*;
import java.util.Scanner;

public class BookManagement {

    static Scanner sc = new Scanner(System.in);

    // Establish database connection
    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/librarydb",
            "root", "qwerty"
        );
    }

    // 1. Insert a new book
    static void insertBook() throws SQLException {
        Connection con = getConnection();

        String sql = "INSERT INTO LibraryBook VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        ps.setInt(1, id);
        ps.setString(2, title);
        ps.setString(3, author);
        ps.setDouble(4, price);
        ps.setString(5, "Available");

        ps.executeUpdate();

        System.out.println("Book added successfully!");

        ps.close();
        con.close();
    }

    // 2. Search for a book by ID
    static void searchBook() throws SQLException {
        Connection con = getConnection();

        String sql = "SELECT * FROM LibraryBook WHERE BookID = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Book ID: " + rs.getInt("BookID"));
            System.out.println("Title: " + rs.getString("Title"));
            System.out.println("Author: " + rs.getString("Author"));
            System.out.println("Price: " + rs.getDouble("Price"));
            System.out.println("Availability: " +
                               rs.getString("Availability"));
        } else {
            System.out.println("Book not found.");
        }

        rs.close();
        ps.close();
        con.close();
    }

    // 3. Display all available books
    static void showAvailableBooks() throws SQLException {
        Connection con = getConnection();

        String sql =
            "SELECT * FROM LibraryBook WHERE Availability = 'Available'";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        boolean found = false;

        while (rs.next()) {
            found = true;

            System.out.println(
                rs.getInt("BookID") + " | " +
                rs.getString("Title") + " | " +
                rs.getString("Author") + " | " +
                rs.getDouble("Price") + " | " +
                rs.getString("Availability")
            );
        }

        if (!found) {
            System.out.println("No available books.");
        }

        rs.close();
        ps.close();
        con.close();
    }

    // 4. Issue a book
    static void issueBook() throws SQLException {
        Connection con = getConnection();

        String sql =
            "UPDATE LibraryBook SET Availability = 'Issued' " +
            "WHERE BookID = ? AND Availability = 'Available'";

        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book not found or already issued.");
        }

        ps.close();
        con.close();
    }

    // Main menu
    public static void main(String[] args) throws SQLException {
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Insert Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display Available Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertBook();
                    break;

                case 2:
                    searchBook();
                    break;

                case 3:
                    showAvailableBooks();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
