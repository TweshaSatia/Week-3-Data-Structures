package Day2.Assignment;
import java.util.*;

public class MaxElement {
    public static void main(String[] args){
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> maxs = new Stack<Integer>();
        
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        int x = 0;  
        
   
        for(int i=0;i<n;i++){
        {
            String operations[] = sc.nextLine().split(" ");
            switch(operations[0])
            {
                case "1":
                x = Integer.parseInt(operations[1]);
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
                System.out.println(maxs.peek());
            }
            
        }
        }
        
      
    }
}

