package exjava.exa04;

import java.util.ArrayList;

public class Course {

    public String title;
    public int numberOfDays;
    public int pricePerDay;
    public boolean priorKnowledgeNeeded;
    public ArrayList<Instructor> instructors;

    public Course(String title, int numberOfDays, int pricePerDay){
        this.title=title;
        this.numberOfDays=numberOfDays;
        this.pricePerDay=pricePerDay;
    }
}
