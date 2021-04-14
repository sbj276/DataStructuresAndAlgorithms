/* IMPORTANT: Multiple classes and nested static classes are supported */
import java.util.*;
/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class InfixToPostFix {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for(int i=0;i<n;i++){
            convertToPostfix(s.nextLine());
        }        
    }
    public static void convertToPostfix(String inp){
    Stack<Character> opr = new Stack<>();
    String op = "";
    String oprators = "()*^+-";
    for(char c:inp.toCharArray()){
        if(!oprators.contains(""+c)){
            op+=""+c;
        }else{
            if(opr.isEmpty() || c == '('){
                opr.push(c);
            }else{
                //if RP
                if(c == ')'){
                    while(opr.peek() != '('){
                     op+=""+opr.pop();   
                    }
                    opr.pop();
                }else if(!opr.isEmpty() && opr.peek() != '('){
                    while(!opr.isEmpty() && opr.peek() !='(' && (getPrec(opr.peek()) >= getPrec(c))){
                        op+=""+opr.pop();   
                    }
                    opr.push(c);
                }else{
                    opr.push(c);
                }
                

                }
            }
        }
           while(!opr.isEmpty()){
            op+=""+opr.pop();
        }
        System.out.println(op);
    }
    

    public static int getPrec(char ch){
        switch(ch){
            case '+':
            case '-':
            return 1;
            case '*':
            case '/':
            return 2;            
            case '^':
            return 3;
        }
        return -1;
    }
}