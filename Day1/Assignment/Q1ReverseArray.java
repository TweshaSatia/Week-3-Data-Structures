package Day1.Assignment;
import java.util.*;
public class Q1ReverseArray
{
	public static void reverseArray(int p[]) //method to reverse array
	{
		int i,j,temp,size=p.length;
		
		 for(i=0,j=size-1;i<size/2;i++,j--)
	        {
	            temp=p[i];
	            p[i]=p[j];
	            p[j]=temp;
	        }
		 for(i=0;i<size;i++)
	        {
	            System.out.print((p[i])+ " ");
	        }
	}
    public static void main(String[] args) {
        int q,i;
        Scanner sc = new Scanner(System.in);
        q=sc.nextInt();
        
        //Constraint Handling
        if(q<1 || q>Math.pow(10, 3)) {
			System.out.println("You need to enter the array size between 1 and 1000");
			System.exit(1);
		}
        int p[]=new int[q];
        for(i=0;i<q;i++){
            p[i]=sc.nextInt();
          //Constraint Handling
			if(p[i]<1 || p[i]>Math.pow(10, 4)) {
				System.out.println("The element needs to be between 1 and 10000");
				System.exit(1);
			}
        }
        sc.close();
        reverseArray(p);
      
   }
}
