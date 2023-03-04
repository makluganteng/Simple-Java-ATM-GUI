/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplc.assignment;

/**
 *
 * @author valentinofish
 */
public class Atm {
   
   public static void addFunds(Account account, int value) throws Exception{
       //add funds function
       int currentBalance = account.getValue();
       int newBalance = currentBalance + value;
       account.setValue(newBalance);
       Transaction transaction = new Transaction(account,value, null,Type.DEPOSIT);
       Transaction.transactionData.add(transaction);
       DataIO.write();
   }
   
   private static int deductFunds(Account account, int value) throws Exception {
       //deduct funds function 
       int currentBalance = account.getValue();
       int newBalance = currentBalance - value;
       account.setValue(newBalance);
       return newBalance;
   }
   
   public static void transferFunds(Account account, Account receiver, int value) throws Exception {
       int accountReciever = receiver.getValue();
       int payerBalance = deductFunds(account,value);
       int recieverBalance = accountReciever + value;
       account.setValue(payerBalance);
       receiver.setValue(recieverBalance);
       Transaction transaction = new Transaction(account, value, receiver,Type.TRANSFER);
       Transaction.transactionData.add(transaction);
       DataIO.write();
   }
   
   public static int checkBalance(Account account) throws Exception {
       return account.getValue();
   }
}


//}
//
