import java.io.*;
import java.util.*;
import java.util.*;


public class searchString{


    public static final String TO_STOP = "-1";
    public static final int NOT_FOUND = -1;

    public static int count1;
    public static int count2;
    public static int count3;


    public static int sequentialSearch(ArrayList<String> array, String value){
        for (int j = 0; j <= array.size(); j++)

            if (array.get(j).equalsIgnoreCase(value))
            {
                return j;
            }

            else if (j == (array.size()-1) && !array.get(j).equalsIgnoreCase(value)){
                return NOT_FOUND;
            }
        return 0;
    }

    //iterative binary search


      public static int binarySearch(ArrayList<String> array, String value)
      {
	int low = 0;
	int high = array.size()-1;
	int mid;
	while (low <= high) {
            mid = (low + high)/2;
            count2++;

            if (array.get(mid).compareToIgnoreCase(value) > 0 )
            {
				high = mid - 1;
            }
            else if (array.get(mid).compareToIgnoreCase(value) < 0)
            {
                low = mid + 1;
            }
            else
            {
                return mid;
			}//end ifelse
		}//end while
		return NOT_FOUND;
      } // end of iterative binarySearch()


    //recursive binary search
    public int binarySearch(ArrayList<String> array, int low, int high, String value){

        if (low > high)
            return NOT_FOUND;
        int mid = (low + high)/2;
        count3++;

        for (int j = 0; j <= array.size(); j++)
            if (array.get(mid).compareToIgnoreCase(value) > 0)
            {
                return binarySearch(array, low, mid-1, value);
            }
            else if (array.get(mid).compareToIgnoreCase(value) < 0)
            {
                return binarySearch(array, mid+1, high, value);
            }
            else
                return mid;

			return mid;
   	 } //end recursive binarySearch()

} //end class



/*
Answers to Questions:

Q:		What do you need to change in your static main() if you want to use the
		non-static(=instance) methods?
A:		You would need to speicfy a return type.

Q:		Notice that this non-static main() does not have parameters and thus this
		main() is different from the static main(String[] args) in terms of using
		a different modifier as well as a different signature. By the way, is it fine
		to declare main() like this? If yes, what are you practicing now with this?
		Overloading or overriding?
A:		Yes, it is fine. Overriding.


*/