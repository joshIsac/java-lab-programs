import java.util.Scanner;

public class Performance {
    private int marks[]; 

    public Performance() {
        marks = new int[10];
    }

    //to read marks into the array
    public void readMarks() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the marks of 10 students:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = s.nextInt();

            //condition to check marks that should be between 0 and 100
            while (marks[i]< 0 || marks[i] >  100) {
                System.out.println("Marks should be between 0 and 100. Please enter valid marks.");
                System.out.print("Student " + (i + 1) + ": ");
                marks[i] = s.nextInt();
            }
        }
    }

    // return the highest mark scored in the class
    public int highestMark() {
        int maxMark = marks[0];

        for (int i = 1; i < 10; i++) {
            if (marks[i] > maxMark) {
                maxMark = marks[i];
            }
        }

        return maxMark;
    }

    // return the least mark scored in the class
    public int leastMark() {
        int minMark = marks[0];

        for (int i = 1; i < 10; i++) {
            if (marks[i] < minMark) {
                minMark = marks[i];
            }
        }

        return minMark;
    }

    // to get the mode
    public int getMode() {
        int mode = marks[0];
        int maxFrequency = 1;

        for (int i = 0; i < 10; i++) {
            int currentMark = marks[i];
            int currentFrequency = 1;

            for (int j = i + 1; j < 10; j++) {
                if (marks[j] == currentMark) {
                    currentFrequency++;
                }
            }

            if (currentFrequency > maxFrequency || (currentFrequency == maxFrequency && currentMark > mode)) {
                mode = currentMark;
                maxFrequency = currentFrequency;
            }
        }

        return mode;
    }

    //  to get the frequency at mode
    public int getFreqAtMode() {
        int mode = getMode();
        int modeFrequency = 0;

        for (int i = 0; i < 10; i++) {
            if (marks[i] == mode) {
                modeFrequency++;
            }
        }

        return modeFrequency;
    }

    //  displaying the result
    public void display() {
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + getMode());
        System.out.println("Frequency at Mode: " + getFreqAtMode());
    }
    public static void main(String[] args) {
        Performance performance = new Performance();
        performance.readMarks();
        performance.display();
    }
}