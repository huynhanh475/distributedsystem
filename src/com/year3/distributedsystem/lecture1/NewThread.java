package com.year3.distributedsystem.lecture1;

public class NewThread extends Thread {
    int n = 0;
    public NewThread(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("New Thread " + n + " executing");
        for(int i = 0; i < 10; i++) {
            System.out.println("Thread " + n + " : " + i);
        }
    }
    public static void main(String[] args) {
        Thread t1 = new NewThread(1);
        Thread t2 = new NewThread(2);
        t1.start();
        t2.start();
    }
}