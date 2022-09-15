package com.design.multithreading;

public class RaceCondition {
    public static void main(String[] args) {
        BankAccount task = new BankAccount();
        task.setBalance(100);
        Thread jhon = new Thread(task);
        Thread anita = new Thread(task);
        jhon.start();
        anita.start();
    }
}
class BankAccount implements Runnable {
    volatile private int balance;
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void run() {
        makeWithdrawal(75);
        if (balance < 0) {
            System.out.println("Money overdrawn!!!");
        }
    }

     private void  makeWithdrawal(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw ...");
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + " bucks");
        } else {
            System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }
    }

}
