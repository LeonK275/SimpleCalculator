package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigCalc {

    Boolean booAdd = false;
    Boolean booSubstract = false;
    Boolean booMultiply = false;
    Boolean booDevide = false;

    int i = 0;

    String[] textArray = {"0","0"};


    int yeah = 0;


    BigDecimal newText = new BigDecimal(String.valueOf("0"));
    BigDecimal oldText = new BigDecimal(String.valueOf("0"));

    BigDecimal berechnung = new BigDecimal(String.valueOf("0"));

    JTextField field = new JTextField("0");
    ActionListener listener;

    public BigCalc(){
        initComponents();

    }

    public void initComponents() {
        int y = 5;
        int x = 4;



        JFrame frame = new JFrame("Dumb Fucking Calculator");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel elementPanel = new JPanel(new GridLayout(y,x));


        mainPanel.add(field,BorderLayout.PAGE_START);
        mainPanel.add(elementPanel, BorderLayout.CENTER);


        JPanel[][] buttons = new JPanel[y][x];

        for(int m = 0; m < y;m++) {
            for(int n = 0; n < x;n++) {
                buttons[m][n] = new JPanel();
                elementPanel.add(buttons[m][n]);

            }
        }



        JButton b1 = new JButton("1");
        buttons[1-1][0].add(b1);

        JButton b2 = new JButton("2");
        buttons[1-1][1].add(b2);

        JButton b3 = new JButton("3");
        buttons[1-1][2].add(b3);

        JButton b4 = new JButton("4");
        buttons[2-1][0].add(b4);

        JButton b5 = new JButton("5");
        buttons[2-1][1].add(b5);

        JButton b6 = new JButton("6");
        buttons[2-1][2].add(b6);

        JButton b7 = new JButton("7");
        buttons[3-1][0].add(b7);

        JButton b8 = new JButton("8");
        buttons[3-1][1].add(b8);

        JButton b9 = new JButton("9");
        buttons[3-1][2].add(b9);

        JButton b0 = new JButton("0");
        buttons[4-1][0].add(b0);

        JButton bDot = new JButton(".");
        buttons[4-1][1].add(bDot);

        JButton bDevide = new JButton("/");
        buttons[4-1][2].add(bDevide);

        JButton bAdd = new JButton("+");
        buttons[1-1][3].add(bAdd);

        JButton bSubstract = new JButton("-");
        buttons[2-1][3].add(bSubstract);

        JButton bMultiply = new JButton("*");
        buttons[3-1][3].add(bMultiply);

        JButton bEquals = new JButton("=");
        buttons[4-1][3].add(bEquals);

        JButton bClear = new JButton("C");
        buttons[4][3].add(bClear);

        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                i++;

                if(yeah == 1) {
                    yeah = 0;
                }
                else {
                    yeah = 1;
                }

                textArray[yeah] = field.getText();

                if(b1.getModel().isArmed()) { setText("1"); berechnung = new BigDecimal(String.valueOf(field.getText() + "1")); }
                if(b2.getModel().isArmed()) { setText("2"); berechnung = new BigDecimal(String.valueOf(field.getText() + "2"));}
                if(b3.getModel().isArmed()) { setText("3"); berechnung = new BigDecimal(String.valueOf(field.getText() + "3"));}
                if(b4.getModel().isArmed()) { setText("4"); berechnung = new BigDecimal(String.valueOf(field.getText() + "4"));}
                if(b5.getModel().isArmed()) { setText("5"); berechnung = new BigDecimal(String.valueOf(field.getText() + "5"));}
                if(b6.getModel().isArmed()) { setText("6"); berechnung = new BigDecimal(String.valueOf(field.getText() + "6"));}
                if(b7.getModel().isArmed()) { setText("7"); berechnung = new BigDecimal(String.valueOf(field.getText() + "7"));}
                if(b8.getModel().isArmed()) { setText("8"); berechnung = new BigDecimal(String.valueOf(field.getText() + "8"));}
                if(b9.getModel().isArmed()) { setText("9"); berechnung = new BigDecimal(String.valueOf(field.getText() + "9"));}
                if(b0.getModel().isArmed()) { setText("0"); berechnung = new BigDecimal(String.valueOf(field.getText() + "0"));}
                if(bDot.getModel().isArmed()) { setText("."); berechnung = new BigDecimal(String.valueOf(field.getText() + "."));}

                if(bAdd.getModel().isArmed()) {

                    berechnung = berechnung.add(new BigDecimal(String.valueOf(field.getText())));

                    booAdd = true;
                    booSubstract = false;
                    booDevide = false;
                    booMultiply = false;

                    field.setText("0");

                }

                if(bSubstract.getModel().isArmed()) {
                    if(yeah == 1) {
                        berechnung = berechnung.subtract(new BigDecimal(String.valueOf(textArray[0])));
                    }
                    else {
                        berechnung = berechnung.subtract(new BigDecimal(String.valueOf(textArray[1])));
                    }
                    booAdd = false;
                    booSubstract = true;
                    booDevide = false;
                    booMultiply = false;
                    field.setText("0");

                }

                if(bMultiply.getModel().isArmed()) {
                    berechnung = berechnung.multiply(new BigDecimal(String.valueOf(field.getText())));
                    booAdd = false;
                    booSubstract = false;
                    booDevide = false;
                    booMultiply = true;
                    field.setText("0");
                }

                if(bDevide.getModel().isArmed()) {
                    if(yeah == 1) {
                        berechnung = berechnung.divide(new BigDecimal(String.valueOf(textArray[0])));
                    }
                    else {
                        berechnung = berechnung.divide(new BigDecimal(String.valueOf(textArray[1])));
                    }
                    booAdd = false;
                    booSubstract = false;
                    booDevide = true;
                    booMultiply = false;
                    field.setText("0");
                }

                if(bEquals.getModel().isArmed()) {



                    if(booAdd) { berechnung = berechnung.add(new BigDecimal(String.valueOf(field.getText()))); }
                    if(booSubstract) {
                        if(yeah == 0) {
                            berechnung = berechnung.subtract(new BigDecimal(String.valueOf(textArray[0])));
                        }
                        else {
                            berechnung = berechnung.subtract(new BigDecimal(String.valueOf(textArray[1])));
                        }
                    }
                    if(booMultiply)  { berechnung = berechnung.multiply(new BigDecimal(String.valueOf(field.getText()))); }
                    if(booDevide) {
                        if(yeah == 1) {
                            berechnung = berechnung.divide(new BigDecimal(String.valueOf(textArray[0])));
                        }
                        else {
                            berechnung = berechnung.divide(new BigDecimal(String.valueOf(textArray[1])));
                        }
                    }

                    booAdd = false;
                    booSubstract = false;
                    booDevide = false;
                    booMultiply = false;

                    field.setText(berechnung.toString());

                    berechnung = BigDecimal.valueOf(0);

                }

                if(bClear.getModel().isArmed()) {
                    field.setText("0");
                    berechnung = new BigDecimal(BigInteger.ZERO);

                }

            }
        };

        JButton[] buttonos = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bAdd,bSubstract,bMultiply,bDevide, bEquals,bClear,bDot};
        aac(buttonos);


        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        frame.pack();



    }

    public void setText(String text2) {
        String text1 = field.getText();

        field.setText(text1 + text2);

    }

    public void aac(JButton[] button) {

        for(JButton element : button) {
            element.addActionListener(listener);
        }
    }
}
