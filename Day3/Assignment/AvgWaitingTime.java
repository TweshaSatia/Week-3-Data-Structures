package Day3.Assignment;

import java.util.*;

public class AvgWaitingTime {

    static int getMinimumAvg(Customer c[]) {
      
        //sorting array of customers according to their vist/order time.
        Arrays.sort(c);
        PriorityQueue<Customer> q = new PriorityQueue<Customer>(c.length, new Comparator<Customer>(){
                    //Order by the difference between ordertime and CookTime ASC
                    @Override public int compare(Customer c, Customer c1) {
                        return (int) (Math.abs(c.t - c.l) - Math.abs(c1.t - c1.l));
                    }
                });

        
        long time = c[0].t;
        //adding customer into priority queue as per the comparison
        int idx = 0;
        while(idx < c.length && c[idx].t <= time) {
            q.add(c[idx]);
            idx++;
        }

        int wait = 0;
        while(q.size() > 0) {
            Customer currCustomer = q.poll();
            time += currCustomer.l;
            wait += time - currCustomer.t;

            if (idx < c.length && q.size() == 0 && time < c[idx].t) {
                time = c[idx].t;
            }
            while(idx < c.length && c[idx].t <= time) {
                q.add(c[idx]);
                idx++;
            }
        }
        return wait / c.length;
    }

    public static class Customer implements Comparable<Customer> {
        public int t, l;
        public Customer(int t1, int l1) {this.t = t1; this.l = l1;}
        @Override
        public int compareTo(Customer c)
        {
            return this.t - c.t;
        }

    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();   //total number of customers
        Customer[] c = new Customer[n];
        for(int i = 0; i < n; i++) {
            c[i] = new Customer(in.nextInt(), in.nextInt()); //stores customer details, arg1= order time , arg2=cooking time
        }
        int minimumAvg=getMinimumAvg(c);
        System.out.println(minimumAvg);
        in.close();
    }

 
}





