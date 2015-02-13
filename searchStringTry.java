import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.ArrayList;


public class searchStringTry{


    public static final String TO_STOP = "-1";
    public static final int NOT_FOUND = -1;

    public static int count1;
    public static int count2;
    public static int count3;


    public int sequentialSearch(String[] array, String value){
        for (int j = 0; j <= array.size()-1; j++){
            if (al.get(j).equals(value)){
                return j;
            }
        }

        return NOT_FOUND; 
    }

    public int binarySearch(String[] array, String value){
        int low = 0;
        int high = array.size() - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            count2++;
            if (array[mid] > value){
                high = mid - 1;
            } else if (array[mid] < value){
                low = mid + 1;
            } else
                return mid;
        }
        return NOT_FOUND;
    }

    public static void main(String[] args) throws IOException
    {

        searchStringTry si = new searchStringTry();
        Scanner user_input = new Scanner(System.in());

        boolean wantToContinue = true;

        do {
            System.out.print("Type a positive int to search ("+ TO_STOP + " to stop): ");
            String word2Search = user_input.nextLine();
            if (word2Search.equals(TO_STOP)){
                wantToContinue = false;
            } else {
                count1 = count2 = count3 = 0;
                int index;

                index = si.sequentialSearch(array, word2Search);
                if (index == NOT_FOUND)
                    System.out.println("sequentialSearch()      : " + word2Search + " is not found (comparison=" + count1 + ").");
                else
                    System.out.println("sequentialSearch()      : " + word2Search + " is found in [" + index + "] (comparison=" + count1 + ").");

                index = si.binarySearch(array, word2Search);
                if (index == NOT_FOUND)
                    System.out.println("iterative binarySearch(): " + word2Search + " is not found (comparison=" + count2 + ").");
                else
                    System.out.println("iterative binarySearch(): " + word2Search + " is found in [" + index + "] (comparison=" + count2 + ").");
            }}
        while (wantToContinue);


        File strings = new File("sortedStrings.txt");
        Scanner freader = new Scanner(strings);

        ArrayList<String> al = new ArrayList<String>();

        while(freader.hasNext())
        {
            al.add(freader.next());
        }

        for (int j = 0; j <= al.size()-1; j++){
            System.out.println(al.get(j));
        }
    }

}