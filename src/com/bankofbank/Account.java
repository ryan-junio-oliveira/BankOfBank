package com.bankofbank;

public class Account {

    private int numberAccount;
    private double balance;

    public Account(int numberAccount, double balance) {
        this.numberAccount = numberAccount;
        this.balance = balance;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public double getBalance() {
        return balance;
    }

    public boolean sacar(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido.");
        }
        if (value > this.balance) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        this.balance -= value;
        return true;
    }

    public boolean depositar(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido.");
        }
        this.balance += value;
        return true;
    }
}