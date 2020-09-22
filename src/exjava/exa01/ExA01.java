package exjava.exa01;

public class ExA01 {
    public static void main(String[] args){
        Course course = new Course();

        course.title="Java Fundamentals";
        course.numberOfDays=2;
        course.pricePerDay=250;
        course.priorKnowledgeNeeded=true;

        System.out.println("Course");
        System.out.println("Title " + course.title);
        System.out.println("Number of days : " + course.numberOfDays);
        System.out.println("Price / day : " + course.pricePerDay);
        System.out.println("Prior knowledge needed : " + course.priorKnowledgeNeeded);

    }
}
