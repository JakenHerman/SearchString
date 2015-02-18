import java.util.*;
import java.io.*;

public class TestSearchString {

    public static final String TO_STOP = "-1";
    public static final int NOT_FOUND = -1;

    public static int count1;
    public static int count2;
    public static int count3;



	public static void main(String[] args) throws IOException
	{

		   searchString si = new searchString();
		   Scanner user_input = new Scanner(System.in);

		   boolean wantToContinue = true;

		   File strings = new File("sortedStrings.txt");
		   Scanner freader = new Scanner(strings);

		   ArrayList<String> al = new ArrayList<>();

		   while(freader.hasNext())
		   {
		       al.add(freader.next());
	    } //end while

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
		           } //end sequential ifelse

					int it;
		            it = si.binarySearch(al, word2Search);

		           if (it == NOT_FOUND)
		           {
		               System.out.println("iterative binarySearch(): " + word2Search + " is not found (comparison=" + count2 + ").");
					}
		           else
		           {
		               System.out.println("iterative binarySearch(): " + word2Search + " is found in [" + it + "] (comparison=" + count2 + ").");
					}// end interative ifelse

					int recur = si.binarySearch(al, 0, al.size()-1, word2Search);

					if (recur == NOT_FOUND)
					{
						System.out.println("recursive binarySearch(): " + word2Search + " is not found (comparison=" + count3 + ").");
					}
		            else
		            {
						System.out.println("recursive binarySearch(): " + word2Search + " is found in [" + recur + "] (comparison=" + count3 + ").");
					} // end recursive ifelse


		           } //end else
		        }// end do

		   while (wantToContinue);


	}

}