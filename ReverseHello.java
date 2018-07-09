/*
    Write a program called ReverseHello.java that creates a thread (let's call it Thread 1). 
    Thread 1 creates another thread (Thread 2); Thread 2 creates Thread 3; and so on, up to Thread 50.
    Each thread should print "Hello from Thread <num>!", 
    but you should structure your program such that the threads print their greetings in reverse order.
*/

package com.multithreading;

public class ReverseHello {
    public static void main(String[] args) throws InterruptedException{
        ReverseThread t = new ReverseThread();  
        t.start();
    }
}

class ReverseThread extends Thread{
    static int noOfThreads=50;
    /*
        This is marked as static to make this a shared variable
        as static variable have only one copy.
    */
    public void run() {
        
        try{
            this.noOfThreads--;
            if(this.noOfThreads<0) return;
            makeThread();
            System.out.println("Hello from <" + this.getName() + ">");
        }catch(InterruptedException e){}
    }
    
    public void makeThread() throws InterruptedException{
        ReverseThread t = new ReverseThread();
        t.start();
        /*
            The thread that calls this method will be pushed behind this 
            newly created thread in the queue.
        */
        t.join();
    }
}