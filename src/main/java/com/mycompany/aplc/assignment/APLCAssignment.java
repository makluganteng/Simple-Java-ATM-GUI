/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aplc.assignment;


/**
 *
 * @author valentinofish
 */
public class APLCAssignment {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        DataIO.read();
        LoginPage login = new LoginPage();
        login.setVisible(true);
        //Functional Programming Way 
//        try {
//            DataIO.readUsers();
//            DataIO.readAccounts();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }
}
