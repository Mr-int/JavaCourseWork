import java.util.Objects;

public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int salary;
    private byte department;
    private static int idCounter = 0;
    private int employeeId;

    public Employee(String firstName, String middleName, String lastName, int salary, byte department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел превышает значение 5 или меньше значения 1");
        }

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.employeeId = ++idCounter;
    }

//    Геттеры
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public byte getDepartment() {
        return department;
    }

//    Сеттеры
    public void setDepartment(byte department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть в диапазоне от 1 до 5");
        } else {
            this.department = department;
        }
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && employeeId == employee.employeeId && Objects.equals(firstName, employee.firstName) && Objects.equals(middleName, employee.middleName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, salary, department, employeeId);
    }
}
