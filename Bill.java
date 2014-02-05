import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
public class Bill {

    private static final int ONE_HOUR_IN_SECONDS = 3600;
    private static final int ONE_MIN_IN_SECONDS = 60;

    private static int getTotalSeconds (List<String> items) {
        int seconds = 0;
        for (String i : items) {
            System.out.printf("[main] item\t\t%s\n", i);
            String[] strParts = i.split("\\.");

            int[] parts = new int[strParts.length];
            for(int j = 0; j < parts.length; j++) {
                parts[j]= Integer.parseInt(strParts[j]);
            }

            switch (parts.length) {
                case 1:
                    seconds += parts[0];
                    break;
                case 2: 
                    seconds += parts[0] * ONE_MIN_IN_SECONDS;
                    seconds += parts[1];
                    break;
                case 3:
                    seconds += parts[0] * ONE_HOUR_IN_SECONDS;
                    seconds += parts[1] * ONE_MIN_IN_SECONDS;
                    seconds += parts[2];
                    break;
                default:
                    System.out.printf("[main] something went wrong");
            }
        }
        return seconds;
    }

    /**
     * Arg 1 is the input file to read from
     * Arg 2 is the cost per minute as a double
     */
    public static void main (String[] args) {
        String inputFile = args[0];
        double costPerMin = Double.parseDouble(args[1]);

        //Read input file into string list
        List<String> items = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            while (br.ready())
                items.add(br.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        //Calculate seconds used
        int seconds = getTotalSeconds(items);
        System.out.printf("[main] total seconds = %d\n", seconds);
        
        //Calculte the number of minutes used and the cost
        int mins = seconds/60;
        double cost = mins * costPerMin;
        System.out.printf("\n[main] cost=%s\n\n", cost);
    }

}
