import java.time.LocalDate;

public class ExF02b{


    public static void main(String[] args) {

        int startAge=20;
        double startSalary=2000;
        Instructor instructor = new Instructor("Sandy","Schillebeeckx", LocalDate.of(1978,03,01));
        instructor.printSalaryHistory(startAge,startSalary);
    }

}