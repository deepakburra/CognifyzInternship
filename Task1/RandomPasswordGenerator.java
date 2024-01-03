import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    
    public static String generatePassword(int length, boolean useDigits, boolean useLowercase, boolean useUppercase, boolean useSpecialChars) {
      String characters = "";

      if(useDigits) {
          characters += "0123456789";
      }
      if(useLowercase) {
        characters += "abcdefghijklmnopqrstuvwxyz";
      }
      if(useUppercase) {
        characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      }
      if(useSpecialChars) {
        characters += "!@#$%^&*()-/*+;:[]{}<>?";
      }

      if(characters.isEmpty()) {
        return "Please choose atlease one type of character!";
      }
     
      Random random = new Random();
      StringBuilder password = new StringBuilder();
       
       for(int i=0;i<length;i++) {
         int randomIndex = random.nextInt(characters.length());
         password.append(characters.charAt(randomIndex));
       }
        return password.toString();
    }
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the desired length of Password: ");
        int length = sc.nextInt();

        System.out.print("\nInclude numbers?y/n) : ");
        boolean useDigits = sc.next().equalsIgnoreCase("y");

        System.out.print("\nInclude lowercase letters?(y/n) : ");
        boolean useLowercase = sc.next().equals("y");

        System.out.print("\nInclude Uppercase letters?(y/n) : ");
        boolean useUppercase = sc.next().equals("y");
        
        System.out.print("\nInclude Special Characters?(y/n) : ");
        boolean useSpecialChars = sc.next().equals("y");

        String password = generatePassword(length, useDigits, useLowercase, useUppercase, useSpecialChars); 
        sc.close();

        System.out.println("\nGenerated password is =>    "+ password);
    }
}
