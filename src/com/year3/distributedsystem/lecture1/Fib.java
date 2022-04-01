package com.year3.distributedsystem.lecture1;

public class Fib  extends Thread{
    private int x;
    public int answer;
    public Fib(int x) {
        this.x = x;
    }

    public void run() {
        if (x <= 2) {
            answer = 1;
        } else {
            try {
                Fib f1 = new Fib(x-1);
                Fib f2 = new Fib(x-2);
                f1.start();
                f2.start();
                f1.join();
                f2.join();
                answer = f1.answer + f2.answer;
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            Fib f = new Fib(4);
            f.start();
            f.join();
            System.out.println(f.answer);
        }
        catch (Exception e) {
            System.err.println("usage: java Fib NUMBER");
        }
    }
}