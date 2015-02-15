import java.io.*;
import java.util.*;
import java.util.ArrayList;


public class searchStringTry{


    public static final String TO_STOP = "-1";
    public static final int NOT_FOUND = -1;

    public static int count1;
    public static int count2;
    public static int count3;


    public int sequentialSearch(ArrayList<String> array, String value){
        for (int j = 0; j <= array.size(); j++)
            if (array.get(j).equalsIgnoreCase(value))
            {
                return j;
            }
        return NOT_FOUND;
    }

    //iterative binary search
    
    
    public int binarySearch(ArrayList<String> array, String value){
        int low = 0;
        int high = array.size() - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            count2++;
        for (int j = 0; j <= array.size(); j++)
            if (array.get(j).equalsIgnoreCase(value)){
                if (mid > j){
                    high = mid - 1;
                }
            }
             else if (mid < j){
                low = mid + 1;
            } else
                return mid;
        }
        
        return NOT_FOUND;
    }
   
    
    //recursive binary search
    public int binarySearch(ArrayList<String> array, int low, int high, String value){
        
        if (low > high)
            return NOT_FOUND;
        int mid = (low + high)/2;
        count3++;
        
        for (int j = 0; j <= array.size(); j++)
            if (array[mid] > value)
            {
                return binarySearch(array, low, mid-1, value);
            } 
            else if (array[mid] < value)
            {
                return binarySearch(array, mid+1, high, value);
            } 
            else
                return mid;
  
    }
    

    public static void main(String[] args) throws IOException
    {

        searchStringTry si = new searchStringTry();
        Scanner user_input = new Scanner(System.in);

        boolean wantToContinue = true;
        
        

        File strings = new File("sortedStrings.txt");
        Scanner freader = new Scanner(strings);

        ArrayList<String> al = new ArrayList<>();

        while(freader.hasNext())
        {
            al.add(freader.next());
        }

            System.out.println(al.size() + " words populated in the instance of ArrayList");
            
        do {
            
            System.out.print("Type a string to search ("+ TO_STOP + " to stop): ");
            String word2Search = user_input.nextLine();
            if (word2Search.equals(TO_STOP)){
                wantToContinue = false;
            } else {
                count1 = count2 = count3 = 0;
                int j;

                j = si.sequentialSearch(al, word2Search);
                if (j == NOT_FOUND)
                {
                    count1 = al.size();
                    System.out.println("sequentialSearch()      : " + word2Search + " is not found (comparison=" + count1 + ").");
                } 
                else{
                    count1 = j+1;
                    System.out.println("sequentialSearch()      : " + word2Search + " is found in [" + j + "] (comparison=" + count1 + ").");
                }

                j = si.binarySearch(al, word2Search);
                if (j == NOT_FOUND)
                    System.out.println("iterative binarySearch(): " + word2Search + " is not found (comparison=" + count2 + ").");
                else
                    System.out.println("iterative binarySearch(): " + word2Search + " is found in [" + j + "] (comparison=" + count2 + ").");
                }
        } 
       
        while (wantToContinue);
        
    }
}
     


