import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");
        
        int strength = calculateStrength(length, hasUppercase, hasLowercase, hasDigit, hasSpecialChar);
        
        System.out.println("Password strength analysis:");
        System.out.println("Length: " + length);
        System.out.println("Contains uppercase letter: " + hasUppercase);
        System.out.println("Contains lowercase letter: " + hasLowercase);
        System.out.println("Contains digit: " + hasDigit);
        System.out.println("Contains special character: " + hasSpecialChar);
        
        System.out.println("Overall Strength: " + getStrengthDescription(strength));
    }
    
    public static int calculateStrength(int length, boolean hasUppercase, boolean hasLowercase, boolean hasDigit, boolean hasSpecialChar) {
        int strength = 0;
        
        if (length >= 8) {
            strength++;
        }
        if (hasUppercase) {
            strength++;
        }
        if (hasLowercase) {
            strength++;
        }
        if (hasDigit) {
            strength++;
        }
        if (hasSpecialChar) {
            strength++;
        }
        
        return strength;
    }
    
    public static String getStrengthDescription(int strength) {
        if (strength <= 1) {
            return "Weak";
        } else if (strength <= 3) {
            return "Moderate";
        } else if (strength <= 4) {
            return "Strong";
        } else {
            return "Very Strong";
        }
    }
}
