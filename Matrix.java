/* Title: Basic Matrix implementation
 * Author: Damon Greenhalgh
 * Description: This is a basic implementation of the matrix structure in mathematics.
*/
import java.util.ArrayList;

public class Matrix{
    protected ArrayList<Vector> matrix = new ArrayList<Vector>();    // the matrix is made up of an arraylist of arraylists
    protected int rows, columns;

    /* CONSTRUCTORS */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < rows; i++) {
            matrix.add(new Vector(columns));
        }
    }
    
    /* This method returns a String representation of the Matrix object */
    public String toString() {
        String str = "";
        for (int i = 0; i < this.rows; i++) {
            str += matrix.get(i).toString() + "\n";
        }
        return str;
    }
    
    /* ACCESSORS/MUTATORS */
    public Vector getRow(int index) {
        return matrix.get(index);
    }
    public Double getElement(int row, int column) {
        return matrix.get(row).getElement(column);
    } 
    public void setElement(int row, int column, Double value) {
        matrix.get(row).setElement(column, value);
    }

    /* METHODS */
    /* This method multipies a row by a scalar value */
    public void multRow(int index, Double mult) {
        for (int i = 0; i < rows; i++) {
            matrix.get(index).setElement(i, (matrix.get(index).getElement(i) * mult));    // multiply the element by value
        }
    }
    /* This method adds two rows together */
    public void addRow(int idx1, int idx2, double mult) {
        Double val1, val2;
        for (int i = 0; i < rows; i++) {
            val1 = matrix.get(idx1).getElement(i) * mult;           // operand 1
            val2 = matrix.get(idx2).getElement(i);    // operand 2

            matrix.get(idx2).setElement(i, val1 + val2);
        }
    }
    

}