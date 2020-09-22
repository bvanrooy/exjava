package exjava.exa02;


import java.util.ArrayList;

public class ExA02 {
    public static void main(String[] args){
        Course course = new Course();

        course.title="Java Fundamentals";
        course.numberOfDays=2;
        course.pricePerDay=250;
        course.priorKnowledgeNeeded=true;
        course.instructors = new ArrayList<>();

        Instructor instructor = new Instructor();
        instructor.name="Schillebeeckx Sandy";
        course.instructors.add(instructor);

        Instructor instructor2 = new Instructor();
        instructor2.name="Luigi Instructore";
        course.instructors.add(instructor2);

        System.out.println("Course");
        System.out.println("Title " + course.title);
        System.out.println("Number of days : " + course.numberOfDays);
        System.out.println("Price / day : " + course.pricePerDay);
        System.out.println("Prior knowledge needed : " + course.priorKnowledgeNeeded);
        System.out.println("Number of instructors : " + course.instructors.size());
        for(Instructor instructorForCourse : course.instructors){
            System.out.println("\nInstructor : " + instructorForCourse.name);
        }

    }
}
