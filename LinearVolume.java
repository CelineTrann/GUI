package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 84674tra on 17/01/2018.
 */
public class LinearVolume extends JFrame {

    //initiates restrictions and variables for calculations
    private double m;
    private double b;
    private double d1;
    private double d2;
    private double gx;
    private double slice;

    //initate variable for restrictions
    private double zero;
    private boolean cont;

    //initiate volume variable
    private double volume;

    //initiate variable for JFrame
    final int Width = 220;
    final int Length = 400;

    //-----------------------------------------------------------------------------------------------
    //initiates LinearVolume JFrame
    public LinearVolume (){
        super("Linear Volume");

        //set size and close operation of frame
        setSize(Width, Length);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

        //-------------------------------------------------------------------
        // Set up heading for jframe
        JLabel heading = new JLabel("Volume Under a Liner Function");
        heading.setFont( new Font("Arial", Font.BOLD, 12));

        // Create prompt for user
        JLabel choose = new JLabel("For the function: f(x) = mx + b");

        //-------------------------------------------------------------------
        //initiate instructions
        JLabel mlabel, blabel, lowerD, upperD, vRestrict, iterations;
        mlabel = new JLabel("m value:");
        blabel = new JLabel("b value:");
        lowerD = new JLabel("lower domain:");
        upperD = new JLabel("upper domain:");
        vRestrict = new JLabel("vertical restriction:");
        iterations = new JLabel("Number of iterations:");

        //initiate text field
        JTextField slope, vShift, D1, D2, Gx, iter;
        slope = new JTextField(12);
        vShift = new JTextField(12);
        D1 = new JTextField(12);
        D2 = new JTextField(12);
        Gx = new JTextField(12);
        iter = new JTextField(12);

        //create enter button and label to display calculated volume
        JButton enter = new JButton("Enter");
        JLabel VolumeDisplay = new JLabel();

        //-------------------------------------------------------------------
        //set JFrame layout to FlowLayout
        setLayout(new FlowLayout());

        // Add components to the JFrame
        add(heading);
        add(choose);

        add(mlabel);        add(slope);
        add(blabel);        add(vShift);
        add(lowerD);        add(D1);
        add(upperD);        add(D2);
        add(vRestrict);     add(Gx);
        add(iterations);    add(iter);

        add(enter);
        add(VolumeDisplay);

        //-------------------------------------------------------------------
        //initiate action listener when enter button in clicked
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //change user input values to doubles
                m = Double.parseDouble(slope.getText());
                b = Double.parseDouble(vShift.getText());
                d1 = Double.parseDouble(D1.getText());
                d2 = Double.parseDouble(D2.getText());
                gx = Double.parseDouble(Gx.getText());
                slice = Double.parseDouble(iter.getText());

                //------------------------------------------------------------
                //calculate zero intercept for restriction
                zero = (-b) / m;

                //------------------------------------------------------------
                //set restriction on what use can enter
                if (d2 < d1){
                    JOptionPane.showMessageDialog(null,"Upper domain must be greater than lower domain",
                            "Alert",JOptionPane.WARNING_MESSAGE);

                    cont = false;
                }else if (d1 < 0) {
                    JOptionPane.showMessageDialog(null, "Lower domain must be greater than zero",
                            "Alert", JOptionPane.WARNING_MESSAGE);

                    cont = false;

                }else if (b < 0 && m < 0){
                    JOptionPane.showMessageDialog(null,"you m value or b value has to be larger than zero",
                            "Alert",JOptionPane.WARNING_MESSAGE);

                    cont = false;

                }else if (m < 0 && zero < d2 ){
                    JOptionPane.showMessageDialog(null,"Your higher domain needs to be less than or equal to " + zero,
                            "Alert",JOptionPane.WARNING_MESSAGE);

                    cont = false;

                }else if (b < 0 && d1 < zero) {
                    JOptionPane.showMessageDialog(null,"You lower domain needs to be greater than or equal to " + zero,
                            "Alert",JOptionPane.WARNING_MESSAGE);

                    cont = false;

                }else if (gx < 0) {
                    gx = 0;

                }else{
                    cont = true;

                }//close if statement

                //------------------------------------------------------------
                //set volume to zero
                volume = 0;

                //call volume class to calculate volume under a linear curve
                Volume(m, b, d1, d2, gx, slice);

                //------------------------------------------------------------
                //if restrictions are not met will produce an error
                if (!cont){
                    VolumeDisplay.setText("Volume is: Error");

                }else{
                    //display calculate volume as text
                    VolumeDisplay.setText("Volume is: " + String.valueOf(volume));

                }//close if statement
            }//close actionPerformed method
        });//close actionListener

    }//close LinearVolume JFrame

    //-----------------------------------------------------------------------------------------------
    //method that calculates the volume under a linear curve
    private double Volume (double m, double b, double d1, double d2, double gx, double slice){

        //initiates variables used to calculated volume
        double x;
        double thickness;
        double height;
        double width;

        //-------------------------------------------------------------------
        //initiate for loop to allow for an iterative method of finding the volume
        //int i is to restrict the iterative calculation to the domain range
        for (int i = 0; i < slice; i++ ){

            //calculate the width of each iterative slice
            //calculated by dividing the horizontal range by the number of iterations
            thickness = (d2 - d1)/slice;

            //allow the current iteration to be accounted for in the volume calculation
            //calculates what the x-value is at that point in the iteration
            x = d2 - thickness*i;

            //what the height of said iteration is at the x -value
            //height of the "cylinder" and will become height of rectangular prism
            //uses linear eqn and subtract the g(x) value
            height = m * x + b - gx;

            //calculates the circumference of the cylinder
            //this will be used as the width of the rectangular prism
            width = 2*Math.PI*x;

            //calculate the volume of each iteration and adds it to the overall volume
            //does so by calculating the volume of a rectangular prism
            //which is created by "peeling" the outer of the "cylinder" off
            //which is created when the linear function is rotated around the y-axis
            volume += Math.abs(width*height*thickness);
        }//closes for loop

        //return volume value
        return volume;
    }
    //close Volume function

}//close class
