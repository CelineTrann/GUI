package com.company;

/**
 * Created by crona on 1/18/2018.
 */
public class AreaCalc {

    //initiates variable needed for calculation
    private double area;
    private double height;
    private double width;
    private double rect;

    //-----------------------------------------------------------------------------------------------
    //reset variable to zero
    public void resetData (){
        area = 0;
        height= 0;
        width = 0;
        rect = 0;
    }

    //-----------------------------------------------------------------------------------------------
    //Calculate area under a LINEAR curve
    public double calcAreaLinear (double m, double b, double d1, double d2, double gx, double slice){

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

    //-----------------------------------------------------------------------------------------------
    //calculate area under a QUADRATIC curve
    public double calcAreaQuadratic (double a, double b, double c, double d1, double d2, double gx, double slice) {
        //reset area
        area = 0;

        //Find y-value at the beginning of the domain
        //i.e. its length
        height = a * ((d1 - b) * (d1 - b)) + c - gx;

        //find how wide each slice is
        width = (d2 - d1) / slice;

        //will do loop as long as number of area left is less than number of sections
        for (int x = 0; x < slice; x++) {

            //calculate the area of the rectangle
            //width is how big each slice is
            rect = Math.abs(width * height);

            //move point to next slice
            d1 += width;

            //find new y value
            //add area of rectangle to overall area
            height = a * ((d1 - b) * (d1 - b)) + c - gx;
            area += rect;

        }//end for loop

        return area;
    }//close calcArea Quadratic class

    //-----------------------------------------------------------------------------------------------
    //calculate area under a SINE curve
    public double calcAreaSine (double a, double c, double d, double k, double d1, double d2, double gx, double slice){

        //reset area
        area = 0;

        //Find y-value at the beginning of the domain
        //i.e. its length
        height = a *(Math.sin(k * (d1 - d))) + c - gx;

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
            height = a * (Math.sin(k*(d1 - d))) + c - gx;
            area += rect;

        }//end for loop
        return area;
    }//close calAreaSine function

    //-----------------------------------------------------------------------------------------------
    //calculate area under a COSINE curve
    public double calcAreaCosine (double a, double c, double d, double k, double d1, double d2, double gx, double slice){

        //reset area
        area = 0;

        //Find y-value at the beginning of the domain
        //i.e. its length
        height = a *(Math.cos(k*(d1 - d))) + c - gx;

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
            height = a *(Math.cos(k *(d1 - d))) + c - gx;
            area += rect;

        }//end for loop

        return area;

    }//close calAreaCosine function


}
