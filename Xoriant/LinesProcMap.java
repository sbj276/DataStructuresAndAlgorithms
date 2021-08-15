/* 
 * Save this in a file called Main.java and compile it. To test it 
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */
public class Main {
    public static Map<String,Integer> processData(ArrayList<String> array) {
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return a Map containing
         * the appropriate values
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         Constituency
         */
        Map<String,Integer> constiAndCandi = new HashMap<String,Integer>();
        Map<String,Integer> retVal = new HashMap<String,Integer>();
        String[] temp ={};
        int tempCid = 0;
        for(String inp:array){
            temp = array.split(",");
            if(constiAndCandi.containsKey(temp[2])){
                tempCid = constiAndCandi.get(temp[2]);                
                if(tempCid > retVal.get(temp[2])){
                    retVal.put(temp[2],temp[3]);
                }
            }else{
                constiAndCandi.put(temp[2],temp[0]);
                retVal.put(temp[2],temp[3]);
            }
        }
        
        /*check if that const is present then check if candid is higest or not if yes then update retVal*/
       return retVal;
    }

    public static void main (String[] args) {
        // ArrayList<String> inputData = new ArrayList<String>();
        // String line;
        String[] inp = {
            "22, Ravi Pawar, Aundh, 1603",
            "23, Suvarna Kale, Baner, 803",
            "27, Vinod Chavan, Aundh, 809",
            "29, Vasant Mahajan, Aundh, 617",
            "32, Aarti Patil, Baner, 351",
            "34, Swaran Bijur, Baner, 352"
        };
        System.out.println(processData(inp).toString());
        // try {
        //     Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
        //     while(in.hasNextLine())
        //         inputData.add(in.nextLine());
        //     Map<String,Integer> retVal = processData(inputData);
        //     PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        //     for(Map.Entry<String,Integer> e: retVal.entrySet())
        //         output.println(e.getKey() + ": " + e.getValue());
        //     output.close();
        // } catch (IOException e) {
        //     System.out.println("IO error in input.txt or output.txt");
        // }
    }
}
