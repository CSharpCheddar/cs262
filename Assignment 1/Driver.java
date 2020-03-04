
/**
 * Makes use of all other classes in this package.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class Driver {
    /**
     * The main method is simply used here to call each individual method that 
     * corresponds to the instructions listed in number 9 (organized by letter).
     */
    public static void main(String args[]) {
        //do number 9 part a of the instructions
        Person array[] = partA();
        //do number 9 part b of the instructions
        partB(array);
        //do number 9 part c of the instructions
        partC(array);
        //do number 9 part d of the instructions
        partD(array);
    }
    /**
     * Creates an array of type Person and populates this array with various objects, providing appropriate 
     * values for any parameters not specified by the instructions but required by my implementation.
     * 
     * @return  an array of type Person populated with various people
     */
    public static Person[] partA() {
        //create a person array
        Person array[] = new Person[7];
        //create an address to use for everyone
        Address address = new Address("625 Algoma Blvd.", "Oshkosh", "WI", 54901);
        //populate the array as per the instructions
        array[0] = new Student("Joseph", "Elijah", "Smith","04/09/1997", "Male", address, "spring", 45, 12, false);
        array[1] = new Student("Jane", "Elizabeth", "Miller","02/20/1995", "Female", address, "spring", 120, 9, false);
        array[2] = new StudentEmployee("Hannah", "Taylor", "Sparacino","08/30/1995", "Female", address, "spring", 120, 12, false, 700);
        array[3] = new GraduateStudentInstructor("Michael", "Martin", "Lenske","11/30/1992", "Male", address, "spring", 64, 6, false, true, 9, 700);
        array[4] = new Staff("Adam", "Donald", "Roeke", "05/07/1973", "Male", address, 40000);
        array[5] = new FacultyAdministrator("Barbara", "Margaret", "Sanders", "01/31/1980", "Female", address, 300, "Secretary", 80000);
        array[6] = new Faculty("John", "Reily", "Knox", "03/22/1967", "Male", address, 660, 40000);
        //return the person array
        return array;
    }
    /**
     * Calls the toString() method in all of the objects in the Person array.
     * 
     * @param  array  a Person array
     */
    public static void partB(Person array[]) {
        //call the toString method in each class as per the instructions in part b
        System.out.println("toString Method Call:\n");
        for(Person person : array) {
            System.out.println(person+"\n");
        }
    }
    /**
     * Prints all relevant information for each student. 
     * It then calls the graduate method on each student, 
     * then prints out all the information again.
     * Finally, it prints the salary of all student employees.
     * 
     * @param  array  a person array
     */
    public static void partC(Person array[]) {
        //print out all relevant student information as per the instructions in part c
        System.out.println("\nStudent Information:\n");
        //print out all student information asked for...
        for(int i=0; i<4; i++) {
            Student student = (Student)array[i];
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Full Time: " + student.isFullTime());
            System.out.println("Status: " + student.status() + "\n");
            student.graduate();
        }
        //...then print out all student information after calling the graduate method on all of them
        System.out.println("\nPost Graduation...\n");
        for(int i=0; i<4; i++) {
            Student student = (Student)array[i];
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName());;
            System.out.println("Status: " + student.status() + "\n");
        }
        //print all requested student employee information
        System.out.println("\nStudent Employees:\n");
        StudentEmployee studentEmployee = (StudentEmployee)array[2];
        System.out.println("First Name: " + studentEmployee.getFirstName());
        System.out.println("Last Name: " + studentEmployee.getLastName());;
        System.out.println("Salary: " + studentEmployee.salary() + "\n");
        GraduateStudentInstructor gradStudentInstructor = (GraduateStudentInstructor)array[3];
        System.out.println("First Name: " + gradStudentInstructor.getFirstName());
        System.out.println("Last Name: " + gradStudentInstructor.getLastName());;
        System.out.println("Salary: " + gradStudentInstructor.salary());
    }
    /**
     * Prints out, 
     * 1. The salary of each employee 
     * 2. The credits they have taught (if applicable) 
     * 3. Their administrative postition (if applicable) 
     * 
     * @param  array  a Person array
     */
    public static void partD(Person array[]) {
        //print out all relevant employee information as per the instructions
        System.out.println("\nEmployee Information:\n");
        //print everyone's pay, then (if applicable), 
        //the credits they've taught and administrative position
        for(int i=2; i<7; i++) {
            System.out.println("First Name: " + array[i].getFirstName());
            System.out.println("Last Name: " + array[i].getLastName());
            Employee employee = (Employee)array[i];
            System.out.println("Salary: " + employee.salary());
            //prints credits taught
            if(i ==  3 || i== 5 || i == 6) {
                Instructor instructor = (Instructor)array[i];
                System.out.println("Credits Taught: " + instructor.creditsTaught());
            }
            //prints administrative position
            if(i == 5) {
                Administrator administrator = (Administrator)array[i];
                System.out.println("Position: " + administrator.position());
            }
            //separates everything with a new line
            System.out.println();
        }
    }
}
