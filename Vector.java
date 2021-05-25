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
    public Vector() {createVector();}
    public Vector(int size) {
        this.size = size;
        createVector();
    }

    private void createVector() {
        for (int i = 0; i < size; i++) {
            vec.add(0.0);
        }
    }

    /* ACCESSORS/MUTATORS */
    public String toString() {return vec.toString(); }
    public int getSize() { return size; }
    public void setElement(int index, Double val) { vec.set(index, val); }

    /* METHODS */
    
}
