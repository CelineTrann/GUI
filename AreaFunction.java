package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 84674tra on 18/01/2018.
 */
public class AreaFunction extends JFrame {

    private double area;
    private double height;
    private double width;
    private double rect;

    int Width = 300;
    int Length = 300;

    public AreaFunction (){
        super("Area Function");

        setSize(Width, Length);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }//close AreaFunction method

    //-----------------------------------------------------------------------------------------------
    public void Area (String type){

        String header = null;
        String function = null;

        // Set up heading for jframe
        switch (type){
            case "Linear":
                header = "Calculating Area Under a Liner Function";
                function = "For the function: y = mx + b";
                break;

            case "Quadratic":
                header = "Calculating Area Under a Quadratic Function";
                function = "For the function: y = a (x - b)^2 + c";
                break;

            case "Sine":
                header = "Calculating Area Under a Sine Function";
                function = "For the function: y = a(sin[k (x - d)]) + c";
                break;

            case "Cosine":
                header = "Calculating Area Under a Cosine Function";
                function = "For the function: y = a(cos[k (x - d)]) + c";
                break;
        }
        JLabel heading = new JLabel(header);
        heading.setFont( new Font("Arial", Font.BOLD, 12));
        
        // Create prompt for user
        JLabel choose = new JLabel("For the function: " + function);

        //initiate instructions
        JLabel mlabel, alabel, blabel, clabel, dlabel, klabel, lowerD, upperD, vRestrict, iterations;
        mlabel = new JLabel("m value:");
        alabel = new JLabel("a value:");
        blabel = new JLabel("b value:");
        clabel = new JLabel("c value:");
        dlabel = new JLabel("d value:");
        klabel = new JLabel("k value:");
        
        lowerD = new JLabel("lower domain:");
        upperD = new JLabel("upper domain:");
        vRestrict = new JLabel("vertical restriction:");
        iterations = new JLabel("Number of iterations:");

        //initiate text field
        JTextField slope, aValue, bValue, cValue, dValue, kValue, D1, D2, Gx, iter;
        slope = new JTextField(12);
        aValue = new JTextField(12);
        bValue = new JTextField(12);
        cValue = new JTextField(12);
        dValue = new JTextField(12);
        kValue = new JTextField(12);

        D1 = new JTextField(12);
        D2 = new JTextField(12);
        Gx = new JTextField(12);
        iter = new JTextField(12);

        //create button and label that will show volume calculated
        JButton enter = new JButton("Enter");
        JLabel AreaDisplay = new JLabel();
        
        setLayout(new FlowLayout());

        // Add components to the JFrame
        add(heading);
        add(choose);
        
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
                add(clabel);        add(cValue);
                add(dlabel);        add(dValue);
                break;

            case "Cosine":
                add(alabel);        add(aValue);
                add(klabel);        add(kValue);
                add(clabel);        add(cValue);
                add(dlabel);        add(dValue);
                break;
            
        }//close switch statement
        
        add(lowerD);        add(D1);
        add(upperD);        add(D2);
        add(vRestrict);     add(Gx);
        add(iterations);    add(iter);

        add(enter);
        add(AreaDisplay);

        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //initiate variables
                double m, a, b, c, d, k, d1, d2, gx, slice;

                //change user input to
                m = Double.parseDouble(slope.getText());
                b = Double.parseDouble(bValue.getText());
                d1 = Double.parseDouble(D1.getText());
                d2 = Double.parseDouble(D2.getText());
                gx = Double.parseDouble(Gx.getText());
                slice = Double.parseDouble(iter.getText());

                calcAreaLinear(m, b, d1, d2, gx, slice);

                AreaDisplay.setText("The area under the curve is:" + String.valueOf(area));
            }
        });
    }

    private double calcAreaLinear (double m, double b, double d1, double d2, double gx, double slice){

        //reset area
        area = 0;

        //Find y-value at the beginning of the domain
        //i.e. its length
        height = m*d1 + b - gx;

        //find how wide each slice is
        width = (d2 - d1) / slice;

        //will do loop as long as number of area left is less than number of sections
        for (int x = 0; x < slice; x ++ ){

            //calculate the area of the rectangle
            //width is how big each slice is
            rect = Math.abs(width*height);

            //move point to next slice
            d1 += width;

            //find new y value
            //add area of rectangle to overall area
            height = m*d1 + b - gx;
            area += rect;

        }//end for loop

        return area;

    }//close calLinearArea Method


}//close class
