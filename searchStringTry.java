import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.ArrayList;


public class searchStringTry{

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