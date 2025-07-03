package EmployeeApp;

import java.sql.*;

public class EmployeeDAO {
    private Connection conn = DatabaseConnection.getConnection();

    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employee (name, email, salary) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getEmail());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();
            System.out.println("Employee added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEmployees() {
        String sql = "SELECT * FROM employee";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Email: " + rs.getString("email")
                        + ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee emp) {
        String sql = "UPDATE employee SET name=?, email=?, salary=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getEmail());
            stmt.setDouble(3, emp.getSalary());
            stmt.setInt(4, emp.getId());
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Employee updated." : "Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Employee deleted." : "Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
