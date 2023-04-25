package dedalus.designpattern;


import java.util.HashMap;
import java.util.Map;

// Employee class
class Employee1 implements Cloneable {
    private int id;
    private String name;
    private String department;

    public Employee1(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Clone method
    @Override
    public Employee1 clone() throws CloneNotSupportedException {
        return (Employee1) super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

// Prototype factory
class PrototypeFactory {
    private static Map<String, Employee1> employeeRegistry = new HashMap<>();

    public static void addEmployee(String key, Employee1 fullTimeEmployee) {
        employeeRegistry.put(key, fullTimeEmployee);
    }

    public static Employee1 getEmployee(String key) throws CloneNotSupportedException {
        return employeeRegistry.get(key).clone();
    }
}

// Example usage
public class Prototypedp {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create and register employee prototypes
        Employee1 fullTimeEmployee = new Employee1(1, "Ram", "Engineering");
        PrototypeFactory.addEmployee("FullTimeEmployee", fullTimeEmployee);

        Employee1 partTimeEmployee = new Employee1(2, "Shiva", "Marketing");
        PrototypeFactory.addEmployee("PartTimeEmployee", partTimeEmployee);

        // Clone and modify employee prototypes
        Employee1 clonedFullTimeEmployee = PrototypeFactory.getEmployee("FullTimeEmployee");
        clonedFullTimeEmployee.setName("Ramu");

        Employee1 clonedPartTimeEmployee = PrototypeFactory.getEmployee("PartTimeEmployee");
        clonedPartTimeEmployee.setDepartment("Sales");

        // Print original and cloned employees
        System.out.println(fullTimeEmployee);
        System.out.println(fullTimeEmployee.hashCode());
        System.out.println(clonedFullTimeEmployee);
        System.out.println(clonedFullTimeEmployee.hashCode());

        System.out.println(partTimeEmployee);
        System.out.println(partTimeEmployee.hashCode());
        System.out.println(clonedPartTimeEmployee);    
        System.out.println(clonedPartTimeEmployee.hashCode());
    }
}



/*
 More about Cloning:
 https://howtodoinjava.com/java/cloning/a-guide-to-object-cloning-in-java/#:~:text=Here%2C%20changing%20the%20state%20of,not%20affect%20the%20original%20object.&text=No%20need%20to%20separately%20copy,in%20context%20should%20call%20super. 
 */
