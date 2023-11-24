import java.util.InputMismatchException;
import java.util.Scanner;

public class Maxfrequency {
    private static int num[];

    // Static method to identify top K numbers with highest occurrences
    private static void findMaxFrequency(int K) {
        int freq[] = new int[num.length];

        // Calculate frequencies of each number in the array
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] == num[j]) {
                    freq[i]++;
                }
            }
        }

        // Identify top K numbers with the highest occurrences
        for (int k = 0; k < K; k++) {
            int maxFrequency = -1;
            int maxIndex = -1;

            // Find the number with the highest frequency
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > maxFrequency) {
                    maxFrequency = freq[i];
                    maxIndex = i;
                }
            }

            // Print the number with the highest frequency
            System.out.print(num[maxIndex] + " ");

            // Set the frequency of the chosen number to -1 to avoid re-selection
            freq[maxIndex] = -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get the size of the array
        int size = 0;
        while (size <= 0) {
            try {
                System.out.print("Enter the size of the array: ");
                size = in.nextInt();

                if (size <= 0) {
                    System.out.println("Invalid array size. Please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.nextLine(); // Consume the invalid input
            }
        }

        num = new int[size];

        // Get the elements of the array
        System.out.println("Enter " + size + " elements of the array separated by spaces: ");
        for (int i = 0; i < size; i++) {
            try {
                num[i] = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.nextLine(); // Consume the invalid input
                i--; // Repeat the current iteration to re-enter the element
            }
        }

        // Get the value of K
        int k = 0;
        while (k <= 0 || k > size) {
            try {
                System.out.print("Enter the value of K (1 to " + size + "): ");
                k = in.nextInt();

                if (k <= 0 || k > size) {
                    System.out.println("Invalid value of K. K should be between 1 and " + size);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.nextLine(); // Consume the invalid input
            }
        }

        // Find and print the top K numbers with highest occurrences
        findMaxFrequency(k);

        in.close();
    }
}
