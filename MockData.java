Department hr = new Department(1L, "HR");
Department engineering = new Department(2L, "Engineering");
Department marketing = new Department(3L, "Marketing");

// Create employees
List<Employee> employees = new ArrayList<>();
employees.add(new Employee(1L, "John Doe", 60000.0, hr));
employees.add(new Employee(2L, "Jane Smith", 75000.0, engineering));
employees.add(new Employee(3L, "Emily Johnson", 50000.0, hr));
employees.add(new Employee(4L, "Michael Brown", 80000.0, marketing));
employees.add(new Employee(5L, "Jessica Davis", 90000.0, engineering));
