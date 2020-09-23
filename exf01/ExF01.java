import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExF01{

    public static void main(String[] args){
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Java fundamentals",5,333,false,new ArrayList<String>(Arrays.asList(new String[]{"Sandy Schillebeeckx", "Luigi Instructore"}))));
        courses.add(new Course("Java advanced",5,253,true,new ArrayList<String>(Arrays.asList(new String[]{"Sandy Schillebeeckx", "Luigi Instructore"}))));
        courses.add(new Course("Spring fundamentals",3,211,true,new ArrayList<String>(Arrays.asList(new String[]{"The spring guru"}))));

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