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
    
    // This method returns a string representation of the vector
    public String toString() {
        String str = "[  ";
        for (int i = 0; i < size; i++) {
            Double val = getElement(i);    
            if (val % 1 == 0) {                                            // if val can be represented as an integer
                str += Integer.toString((int)(Math.round(val))) + "  ";    // convert val to integerr for display
            } else {                                                       // otherwise display as a double value
                str += Double.toString(getElement(i)) + "  ";
            }
        }
        return str + "]";
    }

    // This method adds two vectors together
    public void add(Vector v) {
        for (int i = 0; i < size; i++) {
            setElement(i, getElement(i) + v.getElement(i));
        }
    }

    // Scalar Add
    public void add(Double val) {
        for (int element = 0; element < size; element++) {
            setElement(element, getElement(element) + val);    // add the parameter value to each element.
        }
    }

    // This method multiplies the vector by a scalar value
    public void mult(Double val) {
        for (int i = 0; i < size; i++) {
            setElement(i, getElement(i) * val);
        }
    }

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

    // This method returns the length of the vector.
    public Double length() {
        Double length = 0.0;
        for (int i = 0; i < size; i++) {       // for each element
            length += Math.pow(getElement(i), 2.0);    // add the square of the element to length
        }
        length = Math.sqrt(length);                 // squareroot the length
        return length;
    }
    
    // This method normalizes the vector.
    public void normalize() {
        Double length = length();
        Double val;
        for (int i = 0; i < size; i++) {         // for each element
            val = getElement(i);                 // get the element at i
            setElement(i, val / length);         // new value is element / length
        }
    }
}
