package Day2.Assignment;
import java.util.*;

public class MaxElement {
    public static void main(String[] args){
           
        Scanner sc = new Scanner(System.in);      
        //taking input for total number of operations to be performed
        int n = Integer.parseInt(sc.nextLine());    
        int i;  
        String operations[] = new String[n];       

        //taking operations input
        //Each query is one of these three types:
        //1 x  -Push the element x into the stack.
        //2    -Delete the element present at the top of the stack.
        //3    -Print the maximum element in the stack.

        for(i=0;i<n;i++)
        {
            operations[i]= sc.nextLine();

        }
        Integer array[] = getMax(operations);    

        //printing the maximum element for each query type
        for(i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        sc.close();
            
    }
        
    private static Integer[] getMax(String[] operations) {
        //Normal stack stores all data
        Stack<Integer> stack = new Stack<Integer>();       

        //Maximum stack will store maximum element at each stage of stack operations in sorted order
        Stack<Integer> maxs = new Stack<Integer>();

        //For storing max element for each query
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<operations.length;i++)
        {
            String currentOperation[]= operations[i].split(" "); 
            int x;           

            //currentoperation[0] stores query number and currentoperation[1] stores element if query number is 1
            switch(currentOperation[0])
            {
                case "1":
                x = Integer.parseInt(currentOperation[1]);
                stack.push(x);
                 if(maxs.isEmpty() || maxs.peek() <= x)
                     maxs.push(x);
                break;
                case "2":
                x = stack.pop();
                if(x == maxs.peek())
                    maxs.pop();
                break;
                case "3":
                arr.add(maxs.peek());
            }
        }

        //returning maximum element
        Integer[] array = new Integer[arr.size()];
        array = arr.toArray(array);
        return array;
    }

}


