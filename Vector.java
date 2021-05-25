/* Class: Vector
 * Description: Basic implementation of a vector mathematical structure, 
 * the vector is real-valued, and transpose.
 * Author: Damon Greenhalgh
 */

import java.util.ArrayList;

public class Vector {
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
    public String toString() {
            String str = "[  ";
            for (int i = 0; i < this.size; i++) {
                Double val = vec.get(i);    
                if (val % 1 == 0) {                                            // if val can be represented as an Integer
                    str += Integer.toString((int)(Math.round(val))) + "  ";    // convert val to Integer for display
                } else {                                                       // otherwise display as a Double value
                    str += Double.toString(vec.get(i)) + "  ";
                }
                
            }
            return str + "]";
        }
    public int getSize() { return size; }
    public void setElement(int index, Double val) { vec.set(index, val); }
    public Double getElement(int index) {return vec.get(index); }

    /* METHODS */
    
}
