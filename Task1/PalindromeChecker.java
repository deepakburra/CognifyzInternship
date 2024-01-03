import java.util.Scanner;

public class PalindromeChecker {
    
    public static boolean isPalindrome(String word) {

    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();  //Here we remove spaces and puncutations.

        return word.equals(new StringBuilder(word).reverse().toString());
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word or phrase: ");

        String word = sc.nextLine();
        sc.close();

        if(isPalindrome(word)) {
            System.out.println("\nIt is a Palindrome");
        } else {
            System.out.println("It is not a Palindrome");
        }

    }
}
