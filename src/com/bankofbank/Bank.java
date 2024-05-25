package com.bankofbank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void insertAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean deleteAccount(int numberAccount) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getNumberAccount() == numberAccount) {
                accounts.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean depositar(int numberAccount, double value) {
        Account account = getAccountByNumber(numberAccount);
        if (account != null) {
            return account.depositar(value);
        }
        return false;
    }

    public boolean sacar(int numberAccount, double value) {
        Account account = getAccountByNumber(numberAccount);
        if (account != null) {
            try {
                account.sacar(value);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }

    private Account getAccountByNumber(int numberAccount) {
        for (Account account : accounts) {
            if (account.getNumberAccount() == numberAccount) {
                return account;
            }
        }
        return null;
    }

    public void selectAccounts() {
        int iterator = 0;
        for (Account account : accounts) {
            System.out.println("Conta: " + iterator);
            System.out.println("Número da conta: " + account.getNumberAccount());
            System.out.println("Saldo: " + account.getBalance());
        }
    }
}