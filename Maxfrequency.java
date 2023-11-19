import java.util.Scanner;
public class Maxfrequency 
{
 private static int num[];

    // Static method to identify top K numbers with highest occurrences
    private static void findMaxfrequency(int K) {
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
        Scanner in  = new Scanner(System.in);

        // Get the size of the array
        System.out.print("Enter the size of the array: ");
        int size = in.nextInt();
        num = new int[size];

        // Get the elements of the array
        System.out.println("Enter the elements of the array separated by spaces: ");
        for (int i = 0; i < size; i++) {
            num[i] = in.nextInt();
        }
        if (in.hasNext())
        {
        System.out.println("Invalid input: Too many elements provided.");
           
        in.close ();
        return ;} 
        
        // Get the value of K
        System.out.println("Enter the value of K: ");
        int k = in.nextInt();

        if (k>size || k<=0){
        System.out.println("k should be between 1 and "+size );}
         else
        {
            findMaxfrequency(k);
        }
    

        // Find and print the top K numbers with highest occurrences
        findMaxfrequency(k);
        in.close();   
    }
}
