import java.io.*;

public class FIleEncryptDecrypt {

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char shifted = (char) (character + shift);
                if (Character.isLowerCase(character)) {
                    if (shifted > 'z') {
                        shifted = (char) (character - (26 - shift));
                    } else if (shifted < 'a') {
                        shifted = (char) (character + (26 + shift));
                    }
                } else if (Character.isUpperCase(character)) {
                    if (shifted > 'Z') {
                        shifted = (char) (character - (26 - shift));
                    } else if (shifted < 'A') {
                        shifted = (char) (character + (26 + shift));
                    }
                }
                encryptedText.append(shifted);
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Choose an option (encrypt/decrypt): ");
            String choice = reader.readLine().toLowerCase();

            System.out.print("Enter the file name or path: ");
            String fileName = reader.readLine();

            File inputFile = new File(fileName);
            if (!inputFile.exists() || !inputFile.isFile()) {
                System.out.println("File not found or invalid.");
                return;
            }

            StringBuilder text = new StringBuilder();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    text.append(line).append("\n");
                }
            }

            System.out.print("Enter the shift value (an integer): ");
            int shift = Integer.parseInt(reader.readLine());

            String result;
            String outputFileName;
            if (choice.equals("encrypt")) {
                result = encrypt(text.toString(), shift);
                outputFileName = inputFile.getName().split("\\.")[0] + "_encrypted.txt";
            } else if (choice.equals("decrypt")) {
                result = decrypt(text.toString(), shift);
                outputFileName = inputFile.getName().split("\\.")[0] + "_decrypted.txt";
            } else {
                System.out.println("Invalid choice. Please choose either 'encrypt' or 'decrypt'.");
                return;
            }

            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFileName))) {
                fileWriter.write(result);
            }

            System.out.println("File " + choice + "ed successfully. Result saved in " + outputFileName);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
