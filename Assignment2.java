public class Assignment2 {
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        double sum = 0;
        for (Employee employee:employees){
            if (employee.getSalary() > 5000.0){
                sum += employee.getSalary();
            }
        }
        return sum;
    }


    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {

        if (employee.getId() % 3 == 0 && employee.getId() % 5 == 0){
            System.out.println("FizzBuzz");
        } else if(employee.getId() % 3 == 0){
            System.out.println("Fizz");
        } else if (employee.getId() % 5 == 0){
            System.out.println("Buzz");
        }
        // @TODO
    }


    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        double tax = 0.0;
        if (employee.getSalary() <= 2500.0){
            tax = employee.getSalary() * 0.1;
        } else if (employee.getSalary() > 2500.0 && employee.getSalary() <= 5000.0){
            tax = employee.getSalary() * 0.25;

        } else if (employee.getSalary() > 5000.0){
            tax = employee.getSalary() * 0.35;
        }
        // @TODO
        return tax;
    }


    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        double tmp;
        tmp = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(tmp);
        // @TODO
    }


    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO
        int numOfEmployees = 0;
        for (int i = 0; i< employees.length; i++ ){
            if(employees[i].getAge() > 50){
                numOfEmployees ++;
            }
        }
        return numOfEmployees;
    }


    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        String name = employee.getFirstName();
        StringBuilder sb = new StringBuilder(name);
        employee.setFirstName(sb.reverse().toString());

        // @TODO
    }


    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        for (char c : employee.getFirstName().toCharArray()){
            if(Character.isDigit(c)){
                System.out.println("true");
                break; //This line should be return instead of break;
            }
        } System.out.println("false");

    }


    /*
       Write a method to raise an employee's salary to three times of his/her original salary.
       Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
       DO NOT change the input in this method.
       Try to add a new method in Employee class: public void raiseSalary(double byPercent)
       Call this new method.
    */
    public void tripleSalary(Employee employee) {
        employee.raiseSalary(3.00);

        // @TODO
    }


    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        int i = 0;
        for (String employeeString : employeesStr){
            String[] employeeDetails = employeeString.split(",");
            int id = Integer.parseInt(employeeDetails[0]);
            String fn = employeeDetails[1];
            int age = Integer.parseInt(employeeDetails[2]);
            double s = Double.parseDouble(employeeDetails[3]);

            Employee a = new Employee(id, fn, age, s);
            employees[i] = a;
            i++;

            }
        return employees;

        }
}
