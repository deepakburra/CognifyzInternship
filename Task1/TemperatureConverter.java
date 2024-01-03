import java.util.Scanner;

public class TemperatureConverter {
    
    public void converter() {
       
        try (Scanner sc = new Scanner(System.in)) {
            while(true) {

                System.out.println("Choose one of the following \n1.Celsius to Fahrenheit     2.Fahrenheit to Celsius    3.Exit");
                int choice = sc.nextInt();
               
                if(choice>=1 && choice<=2) {

                System.out.print("Enter temperature to convert : ");
                    double val = sc.nextDouble();
                    double finalVal = 0;
               
                switch (choice) {
                    
                    case 1:
                        finalVal = ((val * 9/5) + 32);
                        System.out.println(String.format("%.2f", finalVal)+"F"+"\n");
                        break;
                    case 2:
                        finalVal = ((val - 32) * 5/9);
                        System.out.println(String.format("%.2f", finalVal)+"°C"+"\n");
                        break;
                }
               } else if(choice == 3) {
                System.exit(0);
                System.out.println("Exited");
               } else{
                System.out.println("Invalid Input \n");
               }  
            }
        }
}

    public static void main(String[] args) {
        new TemperatureConverter().converter();
    }
}