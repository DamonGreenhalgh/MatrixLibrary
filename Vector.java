/* Class: Vector
 * Description: Basic implementation of a vector mathematical structure, 
 * the vector is real-valued, and transpose.
 * Author: Damon Greenhalgh
 */

import java.util.ArrayList;
import java.lang.Math;

public class Vector {
    /* FIELDS */
    final static int DEFAULT_SIZE = 3;    // default R^3 space (0, 0, 0)
    protected int size = DEFAULT_SIZE;
    protected ArrayList<Double> vec = new ArrayList<Double>();

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
        for (int i = 0; i < this.size; i++) {
            Double val = vec.get(i);    
            if (val % 1 == 0) {                                            // if val can be represented as an integer
                str += Integer.toString((int)(Math.round(val))) + "  ";    // convert val to integerr for display
            } else {                                                       // otherwise display as a double value
                str += Double.toString(vec.get(i)) + "  ";
            }
        }
        return str + "]";
    }

    // This method returns the dot product with respect to the parameter vector.
    public Double dot(Vector v) {
        Double dot = 0.0;
        if (v.getSize() != this.size) {
            return null;
        } else {
            for (int i = 0; i < this.size; i++) {       // for each element
                dot += vec.get(i) * v.getElement(i);    // the dot is the product of the two elements at i
            }
            return dot;
        }
    }

    // This method returns the length of the vector.
    public Double length() {
        Double length = 0.0;
        for (int i = 0; i < this.size; i++) {       // for each element
            length += Math.pow(vec.get(i), 2.0);    // add the square of the element to length
        }
        length = Math.sqrt(length);                 // squareroot the length
        return length;
    }
    
}
