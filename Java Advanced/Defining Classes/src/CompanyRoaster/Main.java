package CompanyRoaster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String departmentName = data[3];

            Employee employee = new Employee(
                    data[0],
                    Double.parseDouble(data[1]),
                    data[2]
            );


            if (data.length == 5) {
                if (Character.isDigit(data[4].charAt(0))) {
                    employee.setAge(Integer.parseInt(data[4]));
                } else {
                    employee.setEmail(data[4]);
                }
            } else if (data.length == 6) {
                employee.setEmail(data[4]);
                employee.setAge(Integer.parseInt(data[5]));
            }

            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department());
            }
            departments.get(departmentName).addEmployee(employee);

        }


        Map.Entry<String, Department> higherAvarageSalary = departments.entrySet().stream()
                .sorted((f, s) -> {
                    int result = 0;
                    if (s.getValue().getAverageSalary() < f.getValue().getAverageSalary()) {
                        result = -1;
                    } else if (s.getValue().getAverageSalary() > f.getValue().getAverageSalary()) {
                        result = 1;
                    }
                    return result;

                }).findFirst()
                .get();

        System.out.println(String.format("Highest Average Salary: %s",higherAvarageSalary.getKey()));
        higherAvarageSalary.getValue().getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> {
                    System.out.println(String.format("%s %.2f %s %d",
                            employee.getName(),
                            employee.getSalary(),
                            employee.getEmail(),
                            employee.getAge()
                    ));
                });
        }

    }

