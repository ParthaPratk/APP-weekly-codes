
import java.sql.*;
import java.util.Scanner;

public class ProductManagementGUI {

    static Scanner sc = new Scanner(System.in);

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/store",
            "root", "qwerty"
        );
    }

    static void addProduct() throws SQLException {
        Connection con = getConnection();

        String sql = "INSERT INTO Product VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, price);
        ps.setInt(4, quantity);

        ps.executeUpdate();

        System.out.println("Product added successfully!");

        ps.close();
        con.close();
    }

    static void searchProduct() throws SQLException {
        Connection con = getConnection();

        String sql = "SELECT * FROM Product WHERE ProductID = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Product ID: " + rs.getInt("ProductID"));
            System.out.println("Name: " + rs.getString("ProductName"));
            System.out.println("Price: " + rs.getDouble("Price"));
            System.out.println("Quantity: " + rs.getInt("Quantity"));
        } else {
            System.out.println("Product not found.");
        }

        rs.close();
        ps.close();
        con.close();
    }

    static void updateQuantity() throws SQLException {
        Connection con = getConnection();

        String sql = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Quantity: ");
        int quantity = sc.nextInt();

        ps.setInt(1, quantity);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Quantity updated successfully!");
        } else {
            System.out.println("Product not found.");
        }

        ps.close();
        con.close();
    }

    static void lowStock() throws SQLException {
        Connection con = getConnection();

        String sql = "SELECT * FROM Product WHERE Quantity < 10";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        boolean found = false;

        while (rs.next()) {
            found = true;

            System.out.println(
                rs.getInt("ProductID") + " | " +
                rs.getString("ProductName") + " | " +
                rs.getDouble("Price") + " | " +
                rs.getInt("Quantity")
            );
        }

        if (!found) {
            System.out.println("No low-stock products.");
        }

        rs.close();
        ps.close();
        con.close();
    }

    static void showAll() throws SQLException {
        Connection con = getConnection();

        String sql = "SELECT * FROM Product";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                rs.getInt("ProductID") + " | " +
                rs.getString("ProductName") + " | " +
                rs.getDouble("Price") + " | " +
                rs.getInt("Quantity")
            );
        }

        rs.close();
        ps.close();
        con.close();
    }

    public static void main(String[] args) throws SQLException {
        int choice;

        do {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Update Quantity");
            System.out.println("4. Low Stock (<10)");
            System.out.println("5. Show All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    searchProduct();
                    break;

                case 3:
                    updateQuantity();
                    break;

                case 4:
                    lowStock();
                    break;

                case 5:
                    showAll();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
