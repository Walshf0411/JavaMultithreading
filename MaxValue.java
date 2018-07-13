/*
    Problem Definition:
    WAP to find the MaxValue of an array using 4 threads.
*/

package com.multithreading;
/*
    This code calculates the maximum value from an array using 
    four threads. 
*/
public class MaxValue extends Thread{
    private int hi, lo, max=0, arr[];
    
    public MaxValue(int [] arr, int lo, int hi) {
        this.arr = arr;
        this.hi = hi;
        this.lo = lo;
    }
    /*
        void run() does not warn about an Exception in the super class , 
        therefor be careful and dont warn about an Exception
        Thread,sleep()- throws an InterruptedException 
        So it has to be caught if written inside a run method
        we can warn about the Exception
    */
    public void run(){
        max = arr[lo];
        for(int i=lo; i < hi; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
    }
    public int maxValue() {
        return max;
    }
}
class Main{
    public static void main(String[] args) throws InterruptedException{
        int noOfThreads = 4;
        int numberOfValues = 100; 
        int[] values = new int[numberOfValues];
        int maxValue=0;
        
        for(int i=0; i<values.length;i++){
            values[i] = i;
        }
        
        MaxValue threads[] = new MaxValue[noOfThreads];
        
        for(int i=0; i<noOfThreads; i++) {
            threads[i] = new MaxValue(values, i*values.length/noOfThreads, (i+1)*values.length/noOfThreads);
            threads[i].start();
        }
        /*
            This is a very important step as 
        */
        for (int i=0; i<noOfThreads;i++){
            threads[i].join(); //Makes the main method wait for all threads to complete
        }
        for (int i=0; i<noOfThreads; i++){
            maxValue=threads[i].maxValue();
            if(threads[i].maxValue()>maxValue){
                maxValue = threads[i].maxValue();
            }
        }
        
        System.out.println("Max Value : " + maxValue);
    }
}
