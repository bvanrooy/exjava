import java.io.IOException;
import java.util.ArrayList;

public class ExF02{

    public static void main(String[] args){

        ArrayList<Instructor> instructors = new ArrayList<>();
        instructors.add(new Instructor("Sandy Schillebeeckx"));
        instructors.add(new Instructor("Luigi Instructore"));


        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Java fundamentals",5,333,false,instructors));
        courses.add(new Course("Java advanced",5,253,true,instructors));
        courses.add(new Course("Spring fundamentals",3,211,true,instructors));

        for(Course course:courses) {
            course.printInfo();

            try {
                course.writeInfoToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}