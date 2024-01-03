import java.util.Scanner;
public class StudentGradeCalculator {
    
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Grades : ");
        int noOfGrades = sc.nextInt();

        double grades[] = new double[noOfGrades];       //Creating array to store all grades in it

        for(int i=0;i<noOfGrades;i++) {
         System.out.print("Enter grade "+(i+1)+" : ");
         grades[i] = sc.nextInt();                      //Inserting data into array         
        }
        
        double sum = 0;
        for(double grade : grades) {
            sum += grade;
        }
         
        double avg = sum/noOfGrades;
       
        System.out.println("The Average grade is "+avg);
  sc.close();
     }
}
