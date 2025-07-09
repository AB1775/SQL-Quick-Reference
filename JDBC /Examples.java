package com.database;

import java.sql.*;
import java.util.Scanner;

public class Examples { //
    /////////////////////////////
    public static void getCustCity(Connection con) throws Exception {
        PreparedStatement getCity = con.prepareStatement(
                "SELECT city, COUNT(city) FROM customers GROUP BY city ORDER BY COUNT(country) DESC;");

        try (Statement st = con.createStatement()) {
            ResultSet rs = getCity.executeQuery();

            System.out.println("----------------------------");
            System.out.println("    Customer By City        ");
            System.out.println("----------------------------");
            while (rs.next()) {
                String city = rs.getString("city");
                int cityCount = rs.getInt("COUNT(city)");
                System.out.println(city + ": " + cityCount);
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e);
        }
    }

    public static void getCountryCount(Connection con) throws Exception {
        PreparedStatement getCount = con.prepareStatement(
                "SELECT country, COUNT(country) FROM customers GROUP BY country ORDER BY COUNT(country) DESC;");

        try (Statement st = con.createStatement()) {
            ResultSet rs = getCount.executeQuery();

            System.out.println("----------------------------");
            System.out.println("    Customer By Country     ");
            System.out.println("----------------------------");
            while (rs.next()) {
                String country = rs.getString("country");
                int countryCount = rs.getInt("COUNT(country)");
                System.out.println(country + ": " + countryCount);
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e);
        }
    }

    public static void getCustInformation(Connection con) throws Exception {
        PreparedStatement getCustInfo = con.prepareStatement("SELECT * FROM customers WHERE customerName = ?;");

        try (Statement st = con.createStatement()) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the Customer Name > ");
            String customerName = input.nextLine();
            input.close();

            getCustInfo.setString(1, customerName);

            ResultSet rs = getCustInfo.executeQuery();

            System.out.println("------------------------");
            System.out.println("  Customer Information  ");
            System.out.println("------------------------");

            while (rs.next()) {
                String custName = rs.getString("customerName");
                int custNumber = rs.getInt("customerNumber");
                String contactLName = rs.getString("contactLastName");
                String contactFName = rs.getString("contactFirstName");
                String custPhone = rs.getString("phone");

                System.out.println("Name: " + custName);
                System.out.println("Number: " + custNumber);
                System.out.println("Contact Name: " + contactFName + "" + contactLName);
                System.out.println("Customer Phone: " + custPhone);
            }
        }
    }

    public static void getCustomerOrders(Connection con, int customerNumber) throws Exception {
        PreparedStatement leftJoin = con.prepareStatement(
                "SELECT * FROM orders INNER JOIN customers ON orders.customerNumber = customers.customerNumber WHERE customers.customerNumber = ?;");
        leftJoin.setInt(1, customerNumber);
        ResultSet rs = leftJoin.executeQuery();

        System.out.println("---------------------------");
        System.out.println("    Orders for " + customerNumber);
        System.out.println("---------------------------");

        while (rs.next()) {
            int orderNumber = rs.getInt("orderNumber");
            String orderStatus = rs.getString("status");

            System.out.println("Order Number " + orderNumber + ": " + orderStatus);
            System.out.println("---------------------------");
        }
    }

    public static void filterOrdersByStatus(Connection con, String status) throws Exception {
        PreparedStatement filter = con.prepareStatement("SELECT * FROM orders WHERE status = ?;");
        filter.setString(1, status);
        ResultSet rs = filter.executeQuery();

        System.out.println("-----------------------");
        System.out.println("  Order Results: " + status);
        System.out.println("-----------------------");

        while (rs.next()) {
            int orderNumber = rs.getInt("orderNumber");
            int customerNumber = rs.getInt("customerNumber");

            System.out.println("Order Number: " + orderNumber + " for Customer Number: " + customerNumber);
        }
    }

    public static void listTables(Connection con) throws Exception {
        PreparedStatement listTables = con.prepareStatement("SHOW TABLES;");
        ResultSet rs = listTables.executeQuery();

        System.out.println("--------------------------");
        System.out.println("|   Tables in Database   |");
        System.out.println("--------------------------");

        while (rs.next()) {
            String tableName = rs.getString("Tables_in_classicmodels");
            System.out.println("- " + tableName);
        }
    }

    public static void createEmptyTable(Connection con, String tableName) throws Exception {
        PreparedStatement createTable = con.prepareStatement("CREATE TABLE classicmodels.? ();");
        createTable.setString(1, tableName);
        createTable.execute();
    }

    public static void main(String[] args) throws Exception {
        String url = ""; // Database URL
        Connection con = null;

        // [!] Instead of hardcoding secrets, use AWS Secrets Manager, Azure Key Vault,
        // Spring, or a Config File [!]
        String username = "";
        String password = "";

        // Load and Register the Driver
        // [!] Not explicitly required in newer JDBC versions [!]
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establishing a Connection
        // [!] DataSource is preferred over DriverManager for scalability and
        // maintenance [!]
        try {
            con = DriverManager.getConnection(url, username, password);
            con.setReadOnly(true);

            if (con.isReadOnly()) {
                System.out.println("[+] Read-Only Connection Established...");
            } else {
                System.out.println("[!] Connection IS NOT Read-Only");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
    }
}
