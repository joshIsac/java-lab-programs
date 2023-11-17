import java.util.Scanner;

public class AlphabetWar {

    private int[] leftSideStrength = {4, 3, 2, 1};  // w, p, b, s
    private int[] rightSideStrength = {4, 3, 2, 1}; // m, q, d, z

    // Default constructor
    public AlphabetWar() {
        // Default strengths are already set
    }

    // Parameterized constructor for custom strengths
    public AlphabetWar(int leftSideStrength[], int rightSideStrength[]) {
        this.leftSideStrength = leftSideStrength;
        this.rightSideStrength = rightSideStrength;
    }

    // Method to calculate total strength of a word
    private int calculateTotalStrength(String word, int[] strengths) {
        int totalStrength = 0;
        for (char c : word.toCharArray()) {
            int index = "wpbs".indexOf(c);
            if (index != -1) {
                totalStrength += strengths[index];
            }
        }
        return totalStrength;
    }

    // Method to determine the winner based on a single word
    public void determineWinner(String word) {
        int leftStrength = calculateTotalStrength(word, leftSideStrength);
        int rightStrength = calculateTotalStrength(word, rightSideStrength);

        if (leftStrength > rightStrength) {
            System.out.println("Left side wins!");
        } else if (rightStrength > leftStrength) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    // Method to determine the winner based on separate left and right words
    public void determineWinner(String leftWord, String rightWord) {
        int leftStrength = calculateTotalStrength(leftWord, leftSideStrength);
        int rightStrength = calculateTotalStrength(rightWord, rightSideStrength);

        if (leftStrength > rightStrength) {
            System.out.println("Left side wins!");
        } else if (rightStrength > leftStrength) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example with default strengths
        AlphabetWar defaultGame = new AlphabetWar();
        System.out.print("Enter a word: ");
        String word1 = scanner.nextLine();
        defaultGame.determineWinner(word1);

        // Example with custom strengths
        int[] customLeftStrength = {3, 2, 1, 4}; // custom strengths for left side
        int[] customRightStrength = {1, 2, 3, 4}; // custom strengths for right side
        AlphabetWar customGame = new AlphabetWar(customLeftStrength, customRightStrength);
        System.out.print("Enter a letter for the left side: ");
        String leftWord = scanner.nextLine();
        System.out.print("Enter a letter for the right side: ");
        String rightWord = scanner.nextLine();
        customGame.determineWinner(leftWord, rightWord);

        scanner.close();
    }
}
