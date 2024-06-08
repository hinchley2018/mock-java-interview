import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

public class EmployeeIteratorExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        // Insert test data if necessary
        em.getTransaction().begin();
        Department hr = new Department();
        hr.setName("HR");
        em.persist(hr);

        Department engineering = new Department();
        engineering.setName("Engineering");
        em.persist(engineering);

        Department marketing = new Department();
        marketing.setName("Marketing");
        em.persist(marketing);

        Employee john = new Employee();
        john.setName("John Doe");
        john.setSalary(60000.0);
        john.setDepartment(hr);
        em.persist(john);

        Employee jane = new Employee();
        jane.setName("Jane Smith");
        jane.setSalary(75000.0);
        jane.setDepartment(engineering);
        em.persist(jane);

        Employee emily = new Employee();
        emily.setName("Emily Johnson");
        emily.setSalary(50000.0);
        emily.setDepartment(hr);
        em.persist(emily);

        Employee michael = new Employee();
        michael.setName("Michael Brown");
        michael.setSalary(80000.0);
        michael.setDepartment(marketing);
        em.persist(michael);

        Employee jessica = new Employee();
        jessica.setName("Jessica Davis");
        jessica.setSalary(90000.0);
        jessica.setDepartment(engineering);
        em.persist(jessica);

        em.getTransaction().commit();

        // Fetch all employees
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root);
        List<Employee> employees = em.createQuery(query).getResultList();

        // Call the method to print employees with salary greater than 50000
        printHighSalaryEmployees(employees, 50000.0);

        em.close();
        emf.close();
    }

    public static void printHighSalaryEmployees(List<Employee> employees, double salaryThreshold) {
        // Implement the method here using Iterator
    }
}
