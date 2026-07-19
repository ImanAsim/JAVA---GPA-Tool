import java.util.ArrayList;
import java.util.Scanner;

public class Combine {

    private static ArrayList<Course> semester = new ArrayList<>();
    
    public static double gpa(ArrayList<Course> courseList){
            double gpa=0;
            double totalQualityPoints=0;
            int totalCreds= 0;
            for(int i=0; i< courseList.size(); i++){
                totalQualityPoints += courseList.get(i).getQualityPoint();
                totalCreds += courseList.get(i).getclassCreds(); 
            }

            gpa= totalQualityPoints/totalCreds;
            return gpa;
        }

    public static double newSemester(){
        double termGPA=0;
        System.out.println("How many courses did you take this term?");
        Scanner newInput = new Scanner(System.in);
            String numClass = newInput.nextLine();
            int count =0;
            while(count< Integer.parseInt(numClass)){
                System.out.println("Enter course name, credits and the achieved grade:");
                String info = newInput.nextLine();

                String name = info.split(",")[0];
                int credits = Integer.parseInt(info.split(", ")[1]);
                String grade = info.split(", ")[2];

                Course course = new Course(name, credits, grade);
                 
                semester.add(course);
                
                count++;
                
            }

            newInput.close();

        termGPA = gpa(semester);
         return termGPA;
    }


    public static double nextTerm(double pastgpa, int pastCreds){
        double pastQualityPoints = pastgpa * pastCreds;
        
    
    double newQualityPoints=0;
    int newCreds=0;
    for(int i=0; i<semester.size(); i++){
        newQualityPoints += semester.get(i).getQualityPoint();
        newCreds += semester.get(i).getclassCreds();
    }
    
    double totalCumulativePoints= pastQualityPoints + newQualityPoints;
    int totalCreds= pastCreds + newCreds;
    
    return totalCumulativePoints/totalCreds;
    }

    public static void main(String args[]) {
        System.out.println("Is this your first semester?");
        Scanner input = new Scanner(System.in)
;
            String readInput = input.nextLine();

            if (readInput.equalsIgnoreCase("Yes")) {
                System.out.println("Your GPA is: " + newSemester());
            
            } else if (readInput.equalsIgnoreCase("No")) {
                System.out.println("What semester is this?");
                readInput = input.nextLine();
                System.out.println("What was your Cumulative GPA last term?");
                readInput = input.nextLine();

                System.out.println("How many credits did you take previously?");
                String newInput = input.nextLine();

                System.out.println("Your GPA is: " + nextTerm(Double.parseDouble(readInput), Integer.parseInt(newInput)));

                input.close();
    
        }

    }

}

class Course {
    private String className;
    private int classCreds;

    private String classGrade;
    private double qualityPoint;


    Course(String name, int creds, String classGrade) {
        this.className = name;
        this.classCreds = creds;
        this.classGrade = classGrade;
        this.qualityPoint = qualityPoint(classGrade, creds);
    }

    public int getclassCreds(){
        return classCreds;
    }

    public double getQualityPoint(){
        return qualityPoint;
    }


        public double qualityPoint(String grade, int credits) {
            double qualityPoint = 0;

            if (grade.equals("A+")) {
                qualityPoint = 4.5 * credits;
            } else if (grade.equals("A")) {
                qualityPoint = 4 * credits;
            } else if (grade.equals("B+")) {
                qualityPoint = 3.5 * credits;
            } else if (grade.equals("B")) {
                qualityPoint = 3 * credits;
            } else if (grade.equals("C+")) {
                qualityPoint = 2.5 * credits;
            } else if (grade.equals("C")) {
                qualityPoint = 2 * credits;
            } else if (grade.equals("D")) {
                qualityPoint = 1.5 * credits;
            } else if (grade.equals("F")) {
                qualityPoint = 0 * credits;
            }

            return qualityPoint;
        }

}

     

