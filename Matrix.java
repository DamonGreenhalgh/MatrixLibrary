/* Title: Basic Matrix implementation
 * Author: Damon Greenhalgh
 * Description: This is a basic implementation of the matrix structure in mathematics.
*/
import java.util.ArrayList;

public class Matrix extends Vector{
    private int DEFAULT_SIZE = 3;    // the default size of the matrix

    protected ArrayList<ArrayList<Integer>> matrix = new ArrayList();    // the matrix is made up of an arraylist of arraylists
    protected int size = DEFAULT_SIZE;

    /* CONSTRUCTORS */
    public Matrix() {
        createMatrix(this.size, 1);
    }
    public Matrix(int size, int value) {
        createMatrix(size, value);
    }

    /* This method creates a square size x size zero matrix */
    private void createMatrix(int size, int value) {
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();  
            for (int j = 0; j < size; j++) {
                row.add(value);
            }
            matrix.add(row);
        }
    }
    /* This method returns a String representation of the Matrix object */
    public String toString() {
        String str = "";
        for (int i = 0; i < this.size; i++) {
            str += matrix.get(i).toString() + "\n";
        }
        return str;
    
    }
    /* ACCESSORS/MUTATORS */
    public ArrayList<Integer> getRow(int index) {
        return matrix.get(index);
    }
    public int getElement(int row, int column) {
        return matrix.get(row).get(column);
    } 
    public void setElement(int row, int column, int value) {
        matrix.get(row).set(column, value);
    }

    /* METHODS */
    /* This method multipies a row by a scalar value */
    public void multRow(int index, double mult) {
        for (int i = 0; i < size; i++) {
            matrix.get(index).set(i, (int)(matrix.get(index).get(i) * mult));    // multiply the element by value
        }
    }
    /* This method adds two rows together */
    public void addRow(int row1, int row2, double mult) {
        int val1, val2;
        for (int i = 0; i < size; i++) {
            val1 = matrix.get(row1).get(i);    // operand 1
            val2 = (int)(matrix.get(row2).get(i) * mult); // operand 2

            matrix.get(row1).set(i, val1 + val2);
        }
    }

}