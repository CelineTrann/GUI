package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 84674tra on 18/01/2018.
 */
public class AreaFunction extends JFrame {

    //create object for AreaCalc class
    AreaCalc areaCalc = new AreaCalc();

    //initiate variable for area
    private String angleType;
    private double area;

    //initate variable for handling restriction
    private boolean cont;

    //initiate variable for JFrame
    int Width = 250;
    int Length = 450;

    //Create AreaFunction JFrame
    public AreaFunction (){
        super("Area Function");

        //set size and close operation of frame
        setSize(Width, Length);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

    }//close AreaFunction method

    //-----------------------------------------------------------------------------------------------
    //set whether user wants to use radians or not
    public void setAngle (String angle){
        angleType = angle;
    }

    //-----------------------------------------------------------------------------------------------
    //Area JFrame
    public void Area (String type){

        //create variable for what the header text and function will be
        String header = null;
        String function = null;

        //Set up heading and function label for jframe
        //depends on what option user chose
        switch (type){
            case "Linear":
                header = "Area Under a Linear Function";
                function = "For the function: y = mx + b         ";
                break;

            case "Quadratic":
                header = "Area Under a Quadratic Function";
                function = "For the function: y = a (x - b)^2 + c";
                break;

            case "Sine":
                header = "Area Under a Sine Function";
                function = "For the function: y = a(sin[k (x - d)]) + c";
                break;

            case "Cosine":
                header = "Area Under a Cosine Function";
                function = "For the function: y = a(cos[k (x - d)]) + c";
                break;
        }//close switch statement

        //set heading
        JLabel heading = new JLabel(header);
        heading.setFont( new Font("Arial", Font.BOLD, 12));

        // Create prompt for user
        JLabel choose = new JLabel(function);

        //-------------------------------------------------------------------
        //initiate instructions and variables
        JLabel mlabel, alabel, blabel, clabel, dlabel, klabel, lowerD, upperD, vRestrict, iterations;
        mlabel = new JLabel("m value:");
        alabel = new JLabel("a value:");
        blabel = new JLabel("b value:   ");
        clabel = new JLabel("c value:");
        dlabel = new JLabel("d value:");
        klabel = new JLabel("k value:");

        lowerD = new JLabel("lower domain:");
        upperD = new JLabel("upper domain:");
        vRestrict = new JLabel("vertical restriction:");
        iterations = new JLabel("Number of iterations:");

        //initiate text field to allow user input
        JTextField slope, aValue, bValue, cValue, dValue, kValue, D1, D2, Gx, iter;
        slope = new JTextField(14);
        aValue = new JTextField(14);
        bValue = new JTextField(14);
        cValue = new JTextField(14);
        dValue = new JTextField(14);
        kValue = new JTextField(14);

        D1 = new JTextField(14);
        D2 = new JTextField(14);
        Gx = new JTextField(14);
        iter = new JTextField(14);

        //create button and label that will show volume calculated
        JButton enter = new JButton("Enter");
        JLabel AreaDisplay = new JLabel();

        //-------------------------------------------------------------------
        //set JFrame layout as Flow layout
        setLayout(new FlowLayout());

        // Add components to the JFrame
        add(heading);
        add(choose);

        //add label and textfield based on user choice
        switch (type){
            case "Linear":
                add(mlabel);        add(slope);
                add(blabel);        add(bValue);
                break;

            case "Quadratic":
                add(alabel);        add(aValue);
                add(blabel);        add(bValue);
                add(clabel);        add(cValue);
                break;

            case "Sine":
                add(alabel);        add(aValue);
                add(klabel);        add(kValue);
                add(dlabel);        add(dValue);
                add(clabel);        add(cValue);
                break;

            case "Cosine":
                add(alabel);        add(aValue);
                add(klabel);        add(kValue);
                add(dlabel);        add(dValue);
                add(clabel);        add(cValue);
                break;

        }//close switch statement

        //add prompt for restriction and number of iteratiom
        add(lowerD);        add(D1);
        add(upperD);        add(D2);
        add(vRestrict);     add(Gx);
        add(iterations);    add(iter);

        //set up enter button and label to display calculation
        add(enter);
        add(AreaDisplay);

        //-------------------------------------------------------------------
        //create action listener for when enter box is clicked
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //initiate variables
                double m, a, b, c, d, k, d1, d2, gx, slice;

                //change user input to double
                d1 = Double.parseDouble(D1.getText());
                d2 = Double.parseDouble(D2.getText());
                gx = Double.parseDouble(Gx.getText());
                slice = Double.parseDouble(iter.getText());

                if (d2 < d1){
                    JOptionPane.showMessageDialog(null,"Upper domain must be greater than lower domain",
                            "Alert",JOptionPane.WARNING_MESSAGE);

                    cont = false;

                }else{
                    cont = true;
                }

                //------------------------------------------------------------
                //call method from AreaCalc to reset data
                areaCalc.resetData();

                //------------------------------------------------------------
                //changes user input into doubles
                //will call calculation functions for AreaCalc class
                //based on what function user chose (Linear, quadratic, etc.)
                switch (type){
                    case "Linear":
                        m = Double.parseDouble(slope.getText());
                        b = Double.parseDouble(bValue.getText());
                        area = areaCalc.calcAreaLinear(m, b, d1, d2, gx, slice);
                    break;

                    case "Quadratic":
                        a = Double.parseDouble(aValue.getText());
                        b = Double.parseDouble(bValue.getText());
                        c = Double.parseDouble(cValue.getText());
                        area = areaCalc.calcAreaQuadratic(a, b, c, d1, d2,gx, slice);
                    break;

                    case "Sine":
                        a = Double.parseDouble(aValue.getText());
                        c = Double.parseDouble(cValue.getText());
                        d = Double.parseDouble(dValue.getText());
                        k = Double.parseDouble(kValue.getText());

                        //if user wants to use radians convert to radians
                        if (angleType == "Degrees"){

                            d1 = Math.toRadians(d1);
                            d2 = Math.toRadians(d2);

                        }//close if statement

                        area = areaCalc.calcAreaSine(a, c, d, k, d1, d2, gx, slice);
                    break;

                    case "Cosine":
                        a = Double.parseDouble(aValue.getText());
                        c = Double.parseDouble(cValue.getText());
                        d = Double.parseDouble(dValue.getText());
                        k = Double.parseDouble(kValue.getText());

                        //if user wants to use radians convert to radians
                        if (angleType == "Degrees"){

                            d1 = Math.toRadians(d1);
                            d2 = Math.toRadians(d2);

                        }//close if statement

                        area = areaCalc.calcAreaCosine(a, c, d, k, d1, d2, gx, slice);
                    break;

                }//close switch statement
                if (!cont){
                    AreaDisplay.setText("Area Under Curve: Error");

                }else{
                    //displays calculated value in JFrame
                    AreaDisplay.setText("Area Under Curve: " + String.valueOf(area));

                }//close if statement


            }//close method

        });//close actionListener

    }//close area JFrame

}//close class
