import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeQueryExample {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("org.h2.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");

            // Create and populate tables for testing
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE Department (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))");
            stmt.execute("CREATE TABLE Employee (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), salary DOUBLE, department_id BIGINT, FOREIGN KEY (department_id) REFERENCES Department(id))");
            stmt.execute("INSERT INTO Department (name) VALUES ('HR'), ('Engineering'), ('Marketing')");
            stmt.execute("INSERT INTO Employee (name, salary, department_id) VALUES ('John Doe', 60000, 1), ('Jane Smith', 75000, 2), ('Emily Johnson', 50000, 1), ('Michael Brown', 80000, 3), ('Jessica Davis', 90000, 2)");

            // Build the raw SQL query using StringBuilder
            double salaryThreshold = 60000.0;
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT e.id, e.name, e.salary, d.name AS department_name ");
            queryBuilder.append("FROM Employee e ");
            queryBuilder.append("JOIN Department d ON e.department_id = d.id ");
            queryBuilder.append("WHERE e.salary > ").append(salaryThreshold);

            String query = queryBuilder.toString();
            System.out.println("Generated Query: " + query);

            // Execute the query and print results
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                Double salary = rs.getDouble("salary");
                String departmentName = rs.getString("department_name");
                System.out.println("Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + departmentName + "]");
            }

            // Close resources
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
