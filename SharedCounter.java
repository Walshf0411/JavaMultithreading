/*
    Write a program called SharedCounter.java in which 10 threads each increment a shared int counter 
    10 times. When all the threads have finished, print the final value of the counter.
    If the initial value is zero, do you always get 100?
    Arrange for your code to sometimes print the wrong answer. 
*/
package com.multithreading;

public class SharedCounter {
    public static void main(String[] args) throws InterruptedException{
        int noOfthreads = 10;
        CounterThread[] threads = new CounterThread[noOfthreads];
        for(CounterThread c:threads){
            c = new CounterThread();
            c.start();
            c.join();
        }
        System.out.println(CounterThread.counter);
    }
}

class CounterThread extends Thread {
    static int counter = 0; //The counter

    public void run() {
        for (int i=0; i < 10; i++)
            this.counter++;
    }
}