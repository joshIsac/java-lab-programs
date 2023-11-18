import java.util.Scanner;

public class TopKNumbers {

    // Static variable to store the input array
    private static int[] numbers;

    // Static method to identify top K numbers with highest occurrences
    private static void findTopKNumbers(int K) {
        int[] frequencies = new int[numbers.length];

        // Calculate frequencies of each number in the array
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    frequencies[i]++;
                }
            }
        }

        // Identify top K numbers with the highest occurrences
        for (int k = 0; k < K; k++) {
            int maxFrequency = -1;
            int maxIndex = -1;

            // Find the number with the highest frequency
            for (int i = 0; i < frequencies.length; i++) {
                if (frequencies[i] > maxFrequency) {
                    maxFrequency = frequencies[i];
                    maxIndex = i;
                }
            }

            // Print the number with the highest frequency
            System.out.print(numbers[maxIndex] + " ");

            // Set the frequency of the chosen number to -1 to avoid re-selection
            frequencies[maxIndex] = -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        numbers = new int[size];

        // Get the elements of the array
        System.out.print("Enter the elements of the array separated by spaces: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Get the value of K
        System.out.print("Enter the value of K: ");
        int K = scanner.nextInt();

        // Find and print the top K numbers with highest occurrences
        findTopKNumbers(K);

        scanner.close();
    }
}
