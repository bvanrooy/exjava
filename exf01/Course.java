import javax.management.openmbean.OpenType;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Course{

    static final double VATPERCENTAGE = 21;

    private String title;
    private int numberOfDays;
    private double pricePerDay;
    private boolean priorKnowledgeNeeded;
    private ArrayList<String> instructors;

    public Course(String title, int numberOfDays, double pricePerDay, boolean priorKnowledgeNeeded, ArrayList<String> instructors) {
        this.title = title;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
        this.priorKnowledgeNeeded = priorKnowledgeNeeded;
        this.instructors = instructors;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isPriorKnowledgeNeeded() {
        return priorKnowledgeNeeded;
    }

    public void setPriorKnowledgeNeeded(boolean priorKnowledgeNeeded) {
        this.priorKnowledgeNeeded = priorKnowledgeNeeded;
    }

    public ArrayList<String> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<String> instructors) {
        this.instructors = instructors;
    }

    public void addInstructor(String instructor){
        this.instructors.add(instructor);
    }

    public void removeInstructor(String instructor){
        this.instructors.remove(instructor);
    }


    private String getPriceCategory(double price){
        if(price< 500){
            return "CHEAP";
        }
        else if(price > 499 && price < 1500){
            return "OK";
        }else{
            return "EXPENSIVE";
        }
    }

    private double calculateTotalPriceVATIncl(Course course){
        double total = 0;
        total = course.getPricePerDay() * course.getNumberOfDays();
        if(!(course.getNumberOfDays() > 3 && course.isPriorKnowledgeNeeded()) ){
            total += ( total * VATPERCENTAGE / 100);
        }
        return total;
    }


    private ArrayList<String>getCourseInfo(Course course){
        ArrayList<String> lines = new ArrayList<>();
        double total = calculateTotalPriceVATIncl(course);

        lines.add("Course\n-----------------------------------------------------");
        lines.add("Title                   :  " + course.getTitle());
        lines.add("Number of days          : " + course.getNumberOfDays());
        lines.add("Price / day             : " + course.getPricePerDay());
        lines.add("Total Price VAT Incl    : " +  total + " (" + getPriceCategory(total) + ")");
        lines.add("Prior knowledge needed  : " +  course.isPriorKnowledgeNeeded());
        lines.add("Number of instructors   : " + instructors.size());
        for (String instructorForCourse : instructors) {
            lines.add("\t\tInstructor : " + instructorForCourse);
        }
        lines.add("\n-----------------------------------------------------------");

        return lines;
    }


    public void printInfo(){
        for (String line :  getCourseInfo(this)) {
            System.out.println(line);
        }
    }

    public void  writeInfoToFile() throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("courseinfo.txt"), StandardOpenOption.APPEND)){
            for(String line:getCourseInfo(this)){
                bw.write(line + "\n");
            }
        }
    }

}