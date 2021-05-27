/* Title: Basic Matrix implementation
 * Author: Damon Greenhalgh
 * Description: This is a basic implementation of the matrix structure in mathematics.
*/
import java.util.ArrayList;

public class Matrix{
    /* FIELDS */
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

    /* ACCESSORS/MUTATORS */
    public Vector getRow(int index) { return matrix.get(index); }                                               // returns a row vector
    public Vector getColumn(int index) {                                                                        // returns a column vector
        Vector column = new Vector(rows);
        for (int i = 0; i < rows; i++) {
            column.setElement(i, getElement(i, index));
        }
        return column;
    }
    public Double getElement(int row, int column) { return matrix.get(row).getElement(column); }                // returns an element at mat[row, col]
    public void setElement(int row, int column, Double value) { matrix.get(row).setElement(column, value); }    // sets the value at mat[row, col] to a new value
    public int getNumRows() { return rows; }                                                                    // returns the number of rows
    public int getNumColumns() { return columns; }                                                              // returns the number of columns

    /* METHODS */

    // This method returns a String representation of the Matrix object
    public String toString() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            str += getRow(i).toString() + "\n";
        }
        return str;
    }

    // This method multipies a row by a scalar value.
    public void multRow(int index, Double mult) {
        Double val;
        for (int i = 0; i < rows; i++) {
            val = getRow(i).getElement(i) * mult;    // multiply the element by value
            getRow(index).setElement(i, val);        // set new value
        }
    }

    // This method adds two rows together, the result replaces the second parameter row.
    public void addRow(int idx1, int idx2, double mult) {
        Double val1, val2;
        if (mult != 0) {                                     // must be multiplied by a non-zero value
            for (int i = 0; i < rows; i++) {
                val1 = getRow(idx1).getElement(i) * mult;    // operand 1
                val2 = getRow(idx2).getElement(i);           // operand 2
                getRow(idx2).setElement(i, val1 + val2);
            }
        }
    }

    // This method generates the transpose of the matrix.
    public Matrix transpose() {
        Matrix transpose = new Matrix(columns, rows);            // create new matrix
        for (int i = 0; i < columns; i++) {                      
            for (int j = 0; j < rows; j++) {                     // iterate through each value 
                transpose.setElement(j, i, getElement(i, j));    // set the value of trans[i, j] = mat[j, i]
            }
        }
        return transpose;
    }

    // This method multiplies two matricies together.
    public Matrix multMat(Matrix m) {
        if (columns == m.getNumRows()) {                           // must be n x m * m x l
            Matrix mat = new Matrix(rows, m.getNumColumns());
            for (int i = 0; i < mat.getNumRows(); i++) {
                for (int j = 0; j < mat.getNumColumns(); j++) {    // for each element in the new mat matrix 
                    Vector column = m.getColumn(j);                // get column matrix of parameter
                    Vector row = getRow(i);                        // get row matrix of object
                    mat.setElement(i, j, row.dot(column));         // dot the rows and columns to get the new element
                }
            }
            return mat;
        } else {
            return null;
        }
    }

    // This method returns the matrix object to a certain power.
    public Matrix pow(int power) {
        Matrix tmp = this;
        for (int i = 0; i < power - 1; i++) {
            tmp = multMat(tmp);
        }
        return tmp;
    }
}