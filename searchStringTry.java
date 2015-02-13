import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.ArrayList;


public class searchStringTry{


    public static final String TO_STOP = "-1";
    public static final int NOT_FOUND = -1;


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

        /*
        *
        * This entire method just puts the txt file into an arraylist and prints it out.
         */
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