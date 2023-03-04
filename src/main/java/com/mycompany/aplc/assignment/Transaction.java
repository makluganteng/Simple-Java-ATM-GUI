/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplc.assignment;

import java.util.ArrayList;

/**
 *
 * @author valentinofish
 */

public class Transaction {
    
    public static ArrayList<Transaction>transactionData = new ArrayList<>();
    
    public Account account;
    public int value;
    public Account receiver;
    public Type type;
    
    public Transaction(Account account, int value, Account receiver,Type type) {
        this.account = account;
        this.value = value;
        this.receiver = receiver;
        this.type = type;
    }
    
    public static ArrayList<Transaction> getTransactionHistory(Account account){
        ArrayList<Transaction> history = new ArrayList<>();
        for (Transaction transaction : transactionData) {
            if (transaction.account.equals(account)) {
                history.add(transaction);
            }
        }
        return history;
    }
    
}
