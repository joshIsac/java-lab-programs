import java.util.Scanner;
public class Maxfrequency 
{
    private static int num[];
    public Maxfrequency() {
        num=new int[15];
    }
    public void readNum() 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter any numbers:");
        for (int i = 0; i < 15; i++) {
            System.out.print("num" + (i + 1) + ": ");
            num[i] = in.nextInt();
            
        }
    }
        public int getMode() 
        { 
            int mode = num[0];
            int maxFrequency =1;
    
            for (int i = 0; i < 15; i++) {
                int currentMark = num[i];
                int currentFrequency = 1;
    
                for (int j = i + 1; j < 15; j++) {
                    if (num[j] == currentMark) {
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
        public int getFreqAtMode() {
                    int mode = getMode();
                    int modeFrequency = 0;
            
                    for (int i = 0; i < 10; i++) {
                        if (num[i] == mode) {
                            modeFrequency++;
                        }
                        }    return modeFrequency;
                    }
                        public void display() 
                        {
                            System.out.println("The number with the highest frequency is " + getMode());
                            System.out.println("frequency of number" + getFreqAtMode());
                        }                   

            public static void main(String[] args)
            {
                Maxfrequency maxfrequency = new Maxfrequency();
                maxfrequency.readNum();
                maxfrequency.display();              
            }
        }
    





