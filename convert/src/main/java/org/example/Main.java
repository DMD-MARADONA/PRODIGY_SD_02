package org.example;
import javax.swing.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args) {
        Userview user =  new Userview();
        user.setContentPane(user.headPanel);
        user.setTitle("Chitengu-Danai_Prodigy_Task-02");
        user.setSize(600,450);
        user.setVisible(true);
        user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}