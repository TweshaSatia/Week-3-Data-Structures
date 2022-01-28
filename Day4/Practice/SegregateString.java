package Day4.Practice;
// segregate the characters in such a way that all ‘R’ comes in left of string, all ‘B’ in middle and all ‘G’ in right.

import java.util.Scanner;
import java.util.*;

public class SegregateString
{
    public static void segregate(String str)
    {
        int n=str.length();
       int low=0 , mid=0 , high=n-1;
       
       char[] s = str.toCharArray();
       
         char temp;
       
       while(mid<=high)
       {
           switch(s[mid])
           {
               case 'R' :
                           temp = s[low];
                           s[low] = s[mid];
                            s[mid] = temp;
                                low++; mid++;
                               break;
                            
                case 'B' :
                           mid++;
                            break;
                            
                case 'G' :
                             temp = s[mid];
                             s[mid] = s[high];
                              s[high] = temp;
                                high--; 
                                break;
           }
       }
        System.out.print(s);
    }
    
       public static void main(String[] args)
        {
            System.out.println("Enter string to segregate");
            Scanner scan = new Scanner(System.in);
            
            String str = scan.nextLine();
            
            segregate(str);
            scan.close();    
        }
    
}