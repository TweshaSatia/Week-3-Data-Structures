package Day3.Assignment;

import java.util.*;
import java.io.*;

public class AvgWaitingTime {

    static void go() {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();   //total number of customers
        Customer[] c = new Customer[n];
        for(int i = 0; i < n; i++) {
            c[i] = new Customer(in.nextInt(), in.nextInt()); //stores customer details, arg1= order time , arg2=cooking time
        }
        Arrays.sort(c);

        PriorityQueue<Customer> q =
                new PriorityQueue<Customer>(n, new Comparator<Customer>(){
                    //Order by the difference between rdertime and CookTime ASC
                    @Override public int compare(Customer c, Customer c1) {
                        return (int) (Math.abs(c.t - c.l) - Math.abs(c1.t - c1.l));
                    }
                });
        long time = c[0].t;
        int idx = 0;
        while(idx < n && c[idx].t <= time) {
            q.add(c[idx]);
            idx++;
        }

        long wait = 0;
        while(q.size() > 0) {
            Customer next = q.poll();
            time += next.l;
            wait += time - next.t;

            if (idx < n && q.size() == 0 && time < c[idx].t) {
                time = c[idx].t;
            }
            while(idx < n && c[idx].t <= time) {
                q.add(c[idx]);
                idx++;
            }
        }
        System.out.println(wait / n);
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
        go();
    }

 
}





