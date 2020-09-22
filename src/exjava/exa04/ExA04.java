package exjava.exa04;

import java.util.ArrayList;

public class ExA04 {
    public static void main(String[] args) {

        Course course;
        double totalPriceVatIncl;
        final double VATPERCENTAGE = 21;


        course = new Course(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        course.priorKnowledgeNeeded = true;
        course.instructors = new ArrayList<>();

        Instructor instructor = new Instructor();
        instructor.name = "Schillebeeckx Sandy";
        course.instructors.add(instructor);

        Instructor instructor2 = new Instructor();
        instructor2.name = "Luigi Instructore";
        course.instructors.add(instructor2);

        totalPriceVatIncl = course.pricePerDay * course.numberOfDays + ((course.pricePerDay * course.numberOfDays) * VATPERCENTAGE / 100);

        System.out.println("Course");
        System.out.println("Title :  " + course.title);
        System.out.println("Number of days : " + course.numberOfDays);
        System.out.println("Price / day : " + course.pricePerDay);
        System.out.println("Total Price VAT Incl : " + totalPriceVatIncl);
        System.out.println("Prior knowledge needed : " + course.priorKnowledgeNeeded);
        System.out.println("Number of instructors : " + course.instructors.size());
        for (Instructor instructorForCourse : course.instructors) {
            System.out.println("\nInstructor : " + instructorForCourse.name);
        }

    }

}
