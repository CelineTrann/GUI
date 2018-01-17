package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 84674tra on 17/01/2018.
 */
public class LinearVolume extends JFrame {

    //initiates restrictions for calculations
    private double m;
    private double b;
    private double d1;
    private double d2;
    private double gx;
    private double slice;

    //initiate volume variable
    private double volume;

    int Width = 300;
    int Length = 150;

    public LinearVolume (){
        super("Linear Volume");

        setSize(Width, Length);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Set up heading for jframe
        JLabel heading = new JLabel("Calculating Volume Under a Liner Function");
        heading.setFont( new Font("Arial", Font.BOLD, 12));

        // Create prompt for user
        JLabel choose = new JLabel("For the function: f(x) = mx + b");

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
        slope = new JTextField();
        vShift = new JTextField();
        D1 = new JTextField();
        D2 = new JTextField();
        Gx = new JTextField();
        iter = new JTextField();

        JButton enter = new JButton("Enter");
        JTextField VolumeDisplay = new JTextField();

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


        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m = Double.parseDouble(mlabel.getText());
                b = Double.parseDouble(blabel.getText());
                d1 = Double.parseDouble(D1.getText());
                d2 = Double.parseDouble(D2.getText());
                gx = Double.parseDouble(Gx.getText());
                slice = Double.parseDouble(iter.getText());

                Volume(m, b, d1, d2, gx, slice);

                VolumeDisplay.setText("Your volume is:" + String.valueOf(volume));

            }
        });
    }

    private double Volume (double m, double b, double d1, double d2, double gx, double slice){

        //initiates variables used to calculated volume
        double x;
        double thickness;
        double height;
        double width;

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
