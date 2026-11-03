
import java.sql.*;
import java.util.Scanner;

public class LibraryBookManagement {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/library",
            "root", "qwerty"
        );

        int choice;

        do {
            System.out.println("\n1. Insert Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display Available Books");
            System.out.println("4. Issue Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Author: ");
                String author = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();
                sc.nextLine();

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Book VALUES (?, ?, ?, ?, ?)"
                );

                ps.setInt(1, id);
                ps.setString(2, title);
                ps.setString(3, author);
                ps.setDouble(4, price);
                ps.setString(5, "Available");

                ps.executeUpdate();
                System.out.println("Book inserted successfully.");
                ps.close();
            }

            else if (choice == 2) {
                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM Book WHERE BookID = ?"
                );
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    System.out.println("Title: " +
                        rs.getString("Title"));
                    System.out.println("Author: " +
                        rs.getString("Author"));
                    System.out.println("Price: " +
                        rs.getDouble("Price"));
                    System.out.println("Availability: " +
                        rs.getString("Availability"));
                } else {
                    System.out.println("Book not found.");
                }

                rs.close();
                ps.close();
            }

            else if (choice == 3) {
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(
                    "SELECT * FROM Book WHERE Availability = 'Available'"
                );

                while (rs.next()) {
                    System.out.println(
                        rs.getInt("BookID") + " " +
                        rs.getString("Title") + " " +
                        rs.getString("Author") + " " +
                        rs.getDouble("Price")
                    );
                }

                rs.close();
                st.close();
            }

            else if (choice == 4) {
                System.out.print("Enter Book ID to issue: ");
                int id = sc.nextInt();

                PreparedStatement ps = con.prepareStatement(
                    "UPDATE Book SET Availability = 'Issued' " +
                    "WHERE BookID = ? AND Availability = 'Available'"
                );
                ps.setInt(1, id);

                int rows = ps.executeUpdate();

                if (rows > 0)
                    System.out.println("Book issued successfully.");
                else
                    System.out.println("Book unavailable or not found.");

                ps.close();
            }

        } while (choice != 0);

        con.close();
        sc.close();
    }
}
