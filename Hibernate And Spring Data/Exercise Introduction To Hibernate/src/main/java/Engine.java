import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.*;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private Scanner scanner = new Scanner(System.in);

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void run() {

        //TODO   Greetings!!!
        //TODO   Clear the database.
        //TODO   Dont'd forget to add name and password in persistence.xml file.

        //Problem 2
        //removeObjectsEx();

        //Problem 3
        //containsEmployee();

        //Problem 4
        //employeesWithSalaryOver50000();

        //Problem 5
        //employeesFromDepartment();

        //Problem 6
        //addNewAddressAndAddToEmployee();

        //Problem 7
        //addressesWithEmployeeCount();

        //Problem 8
        //getEmployeeWithProject();

        //Problem 9
        //findLatest10Projects();

        //Problem 10
        //increaseSalaries();

        //Problem 11
        //removeTowns();

        //Problem 12
        //findEmployeesByFirstName();

        //Problem 13
        //employeesMaximumSalaries();

        this.entityManager.close();
    }

    private void employeesMaximumSalaries() {
        // Can't understand how exactly the results should be sorted... so I sort them in that way.
        this.entityManager
                .createQuery("SELECT e FROM  Employee AS e " +
                        "WHERE e.salary NOT BETWEEN 30000 AND 70000 " +
                        "GROUP BY e.department " +
                        "ORDER BY e.salary DESC", Employee.class)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(e -> e.getDepartment().getId()))
                .forEach(dept -> {
                    System.out.println(String.format("%s - %.2f", dept.getDepartment().getName(), dept.getSalary()));
                });
    }

    private void findEmployeesByFirstName() {
        try {
            System.out.println("Please enter a pattern:");
            String pattern = scanner.nextLine();

            List<Employee> employeeList = this.entityManager
                    .createQuery("SELECT e FROM Employee AS e WHERE e.firstName LIKE :pattern")
                    .setParameter("pattern", pattern + "%")
                    .getResultList();

            for (Employee employee : employeeList) {
                System.out.println(String.format("%s %s - %s - ($%.2f)"
                        , employee.getFirstName()
                        , employee.getLastName()
                        , employee.getJobTitle()
                        , employee.getSalary()
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeTowns() {
        System.out.println("Please enter a town name:");
        try {
            String input = scanner.nextLine();

            List<Town> townList = this.entityManager
                    .createQuery("SELECT t FROM Town AS t", Town.class)
                    .getResultList();
            List<String> townsNames = new ArrayList<>();
            for (Town town : townList) {
                townsNames.add(town.getName());
            }
            if (!townsNames.contains(input)) {
                System.out.println("There is no town with that name.");
                return;
            }

            //Find town_id
            Town town = this.entityManager
                    .createQuery("SELECT t FROM Town AS t WHERE t.name = :name", Town.class)
                    .setParameter("name", input)
                    .getSingleResult();

            //Find address_id in Address
            List<Address> addresses = this.entityManager
                    .createQuery("SELECT a FROM Address AS a WHERE a.town.id = :idTown", Address.class)
                    .setParameter("idTown", town.getId())
                    .getResultList();


            this.entityManager.getTransaction().begin();
            addresses.forEach(adrs -> {
                for (Employee employee : adrs.getEmployees()) {
                    employee.setAddress(null);
                }
                adrs.setTown(null);
            });
            this.entityManager.remove(town);
            this.entityManager.getTransaction().commit();

            if (addresses.size() == 1) {
                System.out.println(String.format("%d address in %s deleted", addresses.size(), input));
            } else {
                System.out.println(String.format("%d addresses in %s deleted", addresses.size(), input));
            }
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    private void increaseSalaries() {
        // First I tried the shorter variant but something went wrong...
//        this.entityManager
//                .createQuery("UPDATE Employee SET Employee.salary = Employee.salary * 1.12 WHERE Employee.department.id = 1 OR 2 OR 4 OR 11").executeUpdate();

        List<Employee> employeeList =
                this.entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                        .getResultList();

        this.entityManager.getTransaction().begin();

        employeeList.forEach(empl -> {
            this.entityManager.detach(empl);
        });
        employeeList.forEach(empl -> {
            empl.setSalary(empl.getSalary().multiply(BigDecimal.valueOf(1.12)));
        });
        employeeList.forEach(empl -> {
            this.entityManager.merge(empl);
        });
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();


        employeeList.forEach(empl -> {
            System.out.println(String.format("%s %s ($%.2f)"
                    , empl.getFirstName()
                    , empl.getLastName()
                    , empl.getSalary()));
        });


    }

    private void findLatest10Projects() {
        this.entityManager
                .createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(project -> {
                    System.out.println(String.format("Project name: %s%n\t\tProject Description: %s%n\t\tProject Start Date: %s%n\t\tProject End Date: %s"
                            , project.getName()
                            , project.getDescription()
                            , project.getStartDate()
                            , project.getEndDate()));
                });
    }

    private void getEmployeeWithProject() {
        System.out.println("Please enter employee ID:");
        try {
            int emplId = Integer.parseInt(scanner.nextLine());
            this.entityManager
                    .createQuery("SELECT e FROM Employee AS e WHERE e.id = :id", Employee.class)
                    .setParameter("id", emplId)
                    .getResultList()
                    .forEach(empl -> {
                        System.out.println(String.format("%s %s - %s", empl.getFirstName(), empl.getLastName(), empl.getJobTitle()));
                        //Sort the projects alphabetically and print their names.
                        empl.getProjects().stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                                .forEach(project -> {
                                    System.out.println(String.format("      %s", project.getName()));
                                });
                    });

        } catch (NumberFormatException ex) {
            System.out.println("That was not a number, please enter a number and try again.");
        }

    }

    private void addressesWithEmployeeCount() {
        this.entityManager
                .createQuery("SELECT a FROM  Address AS a ORDER BY a.employees.size DESC, a.town.id", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(adr -> {
                    System.out.println(String.format("%s %s, - %d"
                            , adr.getText()
                            , adr.getTown()
                            , adr.getEmployees().size()));
                });
    }

    private void addNewAddressAndAddToEmployee() {
        System.out.println("Enter employee last name:");
        String lastName = scanner.nextLine();

        if (lastName.trim().isEmpty()) {
            System.out.println("There is no entity, please enter entity.");
            return;
        }

        /*
        They want from us to find a person only by last name, but there is more than one person with that name.
        That's why I take only the first find one, from all of them.
        I think that problem will be more logical if they give us the both names or the ID but anyway...
         */

        try {
            Employee employee = this.entityManager
                    .createQuery("SELECT e FROM Employee AS e WHERE e.lastName = :name", Employee.class)
                    .setParameter("name", lastName)
                    .setMaxResults(1)
                    .getSingleResult();

            Address address = createNewAddress("Vitoshka 15");
            this.entityManager.getTransaction().begin();
            this.entityManager.detach(employee);
            employee.setAddress(address);

            this.entityManager.merge(employee);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
            System.out.println(String.format("New address was successful added to %s.", employee.getLastName()));
        } catch (Exception NoResultException) {
            System.out.println("There is no entity with that name.");
        }
    }

    private Address createNewAddress(String addressContent) {
        Address adr = new Address();
        // Setting the address - Vitoshka 15
        adr.setText(addressContent);

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(adr);
        this.entityManager.getTransaction().commit();
        return adr;
    }

    private void employeesFromDepartment() {
        List<Employee> employees = this.entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.department.name = 'Research and Development' ORDER BY e.salary, e.id", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s from %s - $%.2f"
                    , employee.getFirstName()
                    , employee.getLastName()
                    , employee.getDepartment().getName()
                    , employee.getSalary()));
        }
    }

    private void employeesWithSalaryOver50000() {
        this.entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .forEach(e -> {
                    System.out.println(String.format("%s", e.getFirstName()));
                });

//        for (Employee employee : empl) {
//            System.out.println(employee.getFirstName());
//        }
    }

    private void containsEmployee() {
        System.out.println("Enter employee names:");
        String fullName = scanner.nextLine();


        try {
            Employee employee = this.entityManager
                    .createQuery("SELECT e FROM Employee AS e WHERE CONCAT(e.firstName, ' ', e.lastName) = :name", Employee.class)
                    .setParameter("name", fullName)
                    .getSingleResult();
            System.out.println("Yes");
        } catch (NoResultException noRes) {
            System.out.println("No");
        }

    }

    private void removeObjectsEx() {


        // Each town with name smaller than 5 symbols is going to lower case.
        List<Town> towns = this.entityManager
                .createQuery("SELECT t FROM Town AS t WHERE length(t.name) < 5 ", Town.class)
                .getResultList();

        this.entityManager.getTransaction().begin();
        towns.forEach(t -> {
            this.entityManager.detach(t);
        });
        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }
        towns.forEach(t -> {
            this.entityManager.merge(t);
        });
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }


}
