/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplc.assignment;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author valentinofish
 */
public class DataIO {
    public static ArrayList<User>userData = new ArrayList<User>();
    public static ArrayList<Account>accountData = new ArrayList<Account>();
    public static ArrayList<Account>currentAccount = new ArrayList<Account>();
    
   public static void addCurrent(Account account){
       currentAccount.add(account);
   }
   
   
   public static void deleteCurrent(){
       currentAccount.clear();
   }

   public static void read(){
       try{
           System.out.println("User is loaded");
           Scanner userScan = new Scanner(new File("user.txt"));
           while(userScan.hasNext()){
               String[] user;
               String data = userScan.nextLine();
               user = data.split(" ");
               String username = user[0];
               String password = user[1];
               String name = user[2];
               String birthDate = user[3];
               String phoneNumber = user[4];
               User userD = new User(username,password,name,birthDate,phoneNumber);
               userData.add(userD);
               System.out.println(username + " " + password);
           }
           System.out.println("User finish loaded");
           System.out.println("Account is loaded");
           Scanner accountScan = new Scanner(new File("account.txt"));
           while(accountScan.hasNext()){
               String[] account;
               String data = accountScan.nextLine();
               account = data.split(" ");
               User username = DataIO.checkUser(account[0]);
               int value = Integer.parseInt(account[1]);
               Account accountD = new Account(username, value);
               accountData.add(accountD);
               System.out.println(username.getUsername() + " " + value);
           }
           System.out.println("Account finish loaded");
           Scanner transactionScan = new Scanner(new File("transaction.txt"));
           while(transactionScan.hasNext()){
               String[] transaction;
               String data = transactionScan.nextLine();
               transaction = data.split(" ");
               Account account = checkAccount(transaction[0]);
               int value = Integer.parseInt(transaction[1]);
               Account receiver = checkAccount(transaction[2]);
               Type type = null;
               if(transaction[3].equals("DEPOSIT")){
                   type = Type.DEPOSIT;
               }else{
                   type = Type.TRANSFER;
               }
               Transaction transactionD = new Transaction(account,value,receiver,type);
               Transaction.transactionData.add(transactionD);
           }
           
       }catch(Exception e){
           System.out.println(e);
       }
   }
    
   public static User checkUser(String username){
       for(User user: userData){
           if(user.getUsername().equals(username)){
               return user;
           }
       }
       return null;
   }
    
   public static Account checkAccount(String username){
       for(Account account: accountData){
           if(account.getUser().getUsername().equals(username)){
               return account;
           }
       }
       return null;
   }
    
    
   public static void write(){
       try{
           PrintWriter user = new PrintWriter("user.txt");
           for(int i = 0; i<userData.size(); i++){
               user.println(userData.get(i).getUsername() + " " + userData.get(i).getPassword() + " " + userData.get(i).getName() + " " + userData.get(i).getBirthDate() + " " + userData.get(i).getPhoneNumber());
           }
           user.close();
           PrintWriter account = new PrintWriter("account.txt");
           for(int i = 0; i<accountData.size(); i++){
               account.println(accountData.get(i).getUser().getUsername() + " " + accountData.get(i).getValue());
           }
           account.close();
           PrintWriter transaction = new PrintWriter("transaction.txt");
           for(int i = 0;i<Transaction.transactionData.size();i++){
               transaction.println(Transaction.transactionData.get(i).account.getUser().getUsername() + " " + Transaction.transactionData.get(i).receiver.getUser().getUsername() + " " + Transaction.transactionData.get(i).type.toString() + " " + Transaction.transactionData.get(i).value);
           }
           transaction.close();
       }catch(Exception e){
           System.out.println(e);
           e.printStackTrace();
       }
   }


}
