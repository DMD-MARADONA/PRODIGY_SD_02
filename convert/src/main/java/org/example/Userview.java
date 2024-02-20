package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class Userview extends JFrame{
    public JPanel headPanel;
    public JPanel MainPanel;
    public JTextField tflInput;
    public JTextField tflResult1;
    public JTextField tflResult2;
    public JTextArea txaReport;
    public JButton btnConvert;
    private JLabel lblInput;
    private JLabel lblResult1;
    private JLabel lblResult2;
    private JLabel lblHeading;
    private JButton btnGuess;
    private JTextArea txaPrompt;
    private JTextArea txaGuess;
    private JTextArea txaOutcome;

    public Userview(){
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text  = tflInput.getText();
                convertTemp(text);
            }
        });
        final int[] intTryCount = {0};
        Random random = new Random(Calendar.SECOND);
        int intRandom = random.nextInt(0,1000);
        btnGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intTryCount[0]++;
                String strOutcome = "I really cant Say!!! Sadly";
                int intGuess = Integer.parseInt(txaGuess.getText());
                if(intGuess==intRandom){
                    strOutcome = "You must be really lucky!!!\n Got just in " + intTryCount[0] + " shots";
                }else{
                    strOutcome = "We are keeping count of how many tries before you get today's number right!! ";
                    if(intGuess > intRandom){
                        strOutcome = strOutcome.concat("Your number is greater than today's number. #BumpDownTheNumber");
                    } else {
                        strOutcome = strOutcome.concat("Your number is less than today's number. #BumpUpTheNumber");
                    }
                }
                txaOutcome.setText(strOutcome);
            }
        });
    }

    public void convertTemp(String temp){
        temp = temp.toLowerCase(Locale.ROOT);
        temp = temp.replace(',','.');
        double dblInput, dblResult1, dblResult2;
        dblInput = Double.parseDouble(temp.substring(0,temp.length()-1));
        String strResult1 = "NA", strResult2 = "NA", strReport = "Please follow conversion:\n23.23C or 23.23F or 23.23K";
        if(temp.endsWith("c")){
            dblResult1 = ((double) 9 /5)*(dblInput)+32;
            strResult1 = String.valueOf(dblResult1) + "F";
            dblResult2 = (dblInput)+273.15;
            strResult2 = String.valueOf(dblResult2) + "K";
            strReport = "SUCCESS: Thank you for trying me!";
        } else if (temp.endsWith("f")) {
            dblResult1 = ((double) 5/9)*(dblInput-32);
            strResult1 = String.valueOf(dblResult1) + "C";
            dblResult2 = ((double) 5/9)*(dblInput-32)+273.15;
            strResult2 = String.valueOf(dblResult2) + "K";
            strReport = "SUCCESS: Thank you for trying me!";
        } else if (temp.endsWith("k")) {
            dblResult1 = dblInput -273.15;
            strResult1 = String.valueOf(dblResult1) + "C";
            dblResult2 = ((double) 9/5)*(dblInput)-459.67;
            strResult2 = String.valueOf(dblResult2) + "F";
            strReport = "SUCCESS: Thank you for trying me!";
        }
        tflResult1.setText(strResult1);
        tflResult2.setText(strResult2);
        txaReport.setText(strReport);
    }
}
