/* Class: Vector
 * Description: Basic implementation of a vector mathematical structure, 
 * the vector is real-valued, and transpose.
 * Author: Damon Greenhalgh
 */

import java.util.ArrayList;
import java.lang.Math;

public class Vector {
    /* FIELDS */
    private final static int DEFAULT_SIZE = 3;    // default R^3 space (0, 0, 0)
    private int size = DEFAULT_SIZE;
    private ArrayList<Double> vec = new ArrayList<Double>();

    /* CONSTRUCTORS */
    public Vector(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            vec.add(0.0);
        }
    }

    /* ACCESSORS/MUTATORS */
    public int getSize() { return size; }
    public void setElement(int index, Double val) { vec.set(index, val); }
    public Double getElement(int index) {return vec.get(index); }

    /* METHODS */
    
    // String Representation
    // This method returns a string representation of the vector        
    public String toString() {
        String str = "[  ";
        for (int i = 0; i < size; i++) {
            Double val = getElement(i);    
            String tmp = String.format("%.5f", val);

            // Remove the redundant 0 digits.
            while (true) {
                // Get the last digit.
                String lastDigit = tmp.substring(tmp.length() - 1, tmp.length()); 
                // Check if the last digit is a 0.
                if (lastDigit.equals("0")) {
                    tmp = tmp.substring(0, tmp.length() - 1);
                } else {
                    // Check if the val is an integer.
                    if (lastDigit.equals(".")) {
                        tmp = tmp.substring(0, tmp.length() - 1);
                    }
                    break;
                }
            }
            str += tmp + "  "; 
        }
        return str + "]";
    }

    // Vector Addition
    // This method adds two vectors together.
    public void add(Vector v) {
        for (int i = 0; i < size; i++) {
            setElement(i, getElement(i) + v.getElement(i));
        }
    }

    // Scalar Addition
    // This method adds the scalar parameter value to each element of this vector.
    // Note: This is equivalent to vector addition where the parameter is the same size as this vector.
    public void add(Double val) {
        for (int element = 0; element < size; element++) {
            setElement(element, getElement(element) + val);    // add the parameter value to each element.
        }
    }

    // Scalar Multiplication
    // This method multiplies the vector by a scalar value
    public void mult(Double val) {
        for (int i = 0; i < size; i++) {
            setElement(i, getElement(i) * val);
        }
    }

    // Dot Product
    // This method returns the dot product with respect to the parameter vector.
    public Double dot(Vector v) {
        Double dot = 0.0;
        if (v.getSize() != size) {
            return null;
        } else {
            for (int i = 0; i < size; i++) {               // for each element
                dot += getElement(i) * v.getElement(i);    // the dot is the product of the two elements at i
            }
            return dot;
        }
    }

    // Length
    // This method returns the length of the vector.
    public Double length() {
        Double length = 0.0;
        for (int i = 0; i < size; i++) {       // for each element
            length += Math.pow(getElement(i), 2.0);    // add the square of the element to length
        }
        length = Math.sqrt(length);                 // squareroot the length
        return length;
    }
    
    // Normalize
    // This method normalizes the vector.
    public void normalize() {
        Double length = length();
        mult(1/length);
    }

    // Pivot
    // This method returns the pivot index of the vector.
    public int getPivot(ArrayList<Integer> pivots) {

        // Iterate through each element in the vector
        for (int index = 0; index < size; index++) { 

            // Check for an element that is non-zero and has not been a pivot before.
            if (getElement(index) != 0.0 && !pivots.contains(index)) {          
                pivots.add(index);
                return index;
            }
        }
        return -1;    // pivot does not exit, vector is zero vector
    }
}
