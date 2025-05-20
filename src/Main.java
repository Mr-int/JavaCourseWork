public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Иван", "Кориншончиков", "Петров", 50000, (byte) 1);
        employees[1] = new Employee("Дмитрий", "Джава", "Разработчиков", 60000, (byte) 2);
        employees[2] = new Employee("Кейс", "Деопвич", "Батлович", 45000, (byte) 3);
        employees[3] = new Employee("Мария", "Сергеевна", "Антонова", 70000, (byte) 4);

        System.out.println("Список всех сотрудников:");
        printAllEmployees();

        System.out.println("\nСумма затрат на зарплаты: " + salarySum() + " руб.");

        Employee minSalaryEmployee = findEmployeeWithMinSalary();
        System.out.println("\nСотрудник с минимальной зарплатой: " +
                (minSalaryEmployee != null ? minSalaryEmployee : "Нет сотрудников"));

        Employee maxSalaryEmployee = findEmployeeWithMaxSalary();
        System.out.println("\nСотрудник с максимальной зарплатой: " +
                (maxSalaryEmployee != null ? maxSalaryEmployee : "Нет сотрудников"));

        System.out.println("\nСредняя зарплата: " + calculateAverageSalary() + " руб.");

        System.out.println("\nФИО всех сотрудников:");
        printAllFullNames();
    }

    public static void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public static int salarySum() {
        int sallaryCounter = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sallaryCounter += employee.getSalary();
            }
        }
        return sallaryCounter;
    }

    public static Employee findEmployeeWithMinSalary() {
        Employee minSalaryEmployee = null;
        int minSalary = Integer.MAX_VALUE;

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }

        return minSalaryEmployee;
    }

    public static Employee findEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = null;
        int maxSalary = Integer.MIN_VALUE;

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }

        return maxSalaryEmployee;
    }

    public static double calculateAverageSalary() {
        int totalSalary = salarySum();
        int employeeCount = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                employeeCount++;
            }
        }

        return employeeCount > 0 ? (double) totalSalary / employeeCount : 0.0;
    }

    public static void printAllFullNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
            }
        }
    }
}