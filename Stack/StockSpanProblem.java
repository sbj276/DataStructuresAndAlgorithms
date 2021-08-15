/*
inp : {100, 80, 60, 70, 60, 75, 85}
oup :  {1, 1, 1, 2, 1, 4, 6} 
*/
import java.util.*;
class StockSpanProblem{
	public static void main(String[] args){
		int[] inp = {100, 80, 60, 70, 60, 75, 85};
		for(int i:getSpanValues(inp)){
			System.out.print(i+" ");
		}
	}
	public static int[] getSpanValues(int[] inp){
		int[] res = new int[inp.length];
		Stack<Integer> values = new Stack<>();
		values.push(0);
		res[0] = 1;
		for(int i=1;i<inp.length;i++){
			while(!values.empty() && inp[values.peek()]<=inp[i]){
				values.pop();
			}
			res[i] = values.empty()?i+1:(i-values.peek());
			values.push(i);
		}
		return res;
	}
}