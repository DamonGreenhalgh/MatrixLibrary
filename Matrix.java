/* Title: Basic Matrix implementation
 * Author: Damon Greenhalgh
 * Description: This is a basic implementation of the matrix structure in mathematics.
*/

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class Matrix{
    /* FIELDS */
    protected ArrayList<Vector> matrix = new ArrayList<Vector>();    // the matrix is made up of an arraylist of arraylists
    protected int rows, columns;
    protected ArrayList<Integer> pivots = new ArrayList<Integer>();

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

    // String Representation
    // This method returns a String representation of the Matrix object
    public String toString() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            str += getRow(i).toString() + "\n";
        }
        return str;
    }

    // Scalar Addition
    // This overloaded method adds a scalar value to each element of the matrix
    public void add(Double val) {
        for (int row = 0; row < rows; row++) {
            getRow(row).add(val);
        }
    }

    // Matrix Addition
    // This overloaded method adds the matrix with the parameter matrix.
    public void add(Matrix m) {
        for (int row = 0; row < rows; row++) {
            getRow(row).add(m.getRow(row));
        }
    }

    // Scalar Multiplication
    // This overloaded method multiplies the matrix by a scalar value.
    public void mult(Double val) {
        for (int row = 0; row < rows; row++) {
            getRow(row).mult(val);
        }
    }

    // Matrix Multiplication
    // This overloaded method multiplies the matrix with the parameter matrix.
    public Matrix mult(Matrix m) {
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

    // Transpose
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

    // Power
    // This method returns the matrix object to the parameter power.
    public Matrix pow(int power) {
        Matrix pow = this;
        for (int i = 0; i < power - 1; i++) {
            pow = mult(pow);
        }
        return pow;
    }

    // Eliminate
    // This method adds two rows together, the result overwrites the second parameter row.
    public void eliminate(int idx1, int idx2, double mult) {
        Double val1, val2;
        if (mult != 0) {                                     // must be multiplied by a non-zero value
            for (int i = 0; i < columns; i++) {
                val1 = getRow(idx1).getElement(i) * mult;    // operand 1
                val2 = getRow(idx2).getElement(i);           // operand 2
                getRow(idx2).setElement(i, val1 + val2);
            }
        }
    }

    // Gasssian Elimination
    // This method reduces the matrix to reduced row echelon form.
    public void rref() {
        /** Algorithm
         *  ---------
         *  - Iterate through each column of the matrix.
         *  - Find the pivot of the column vector if it exists.
         *  - If the pivot exists. 
         *  - Eliminate every non-pivot entry of the column.
         */

        // Iterate through each column
        for (int columnIndex = 0; columnIndex < columns; columnIndex++) {

            // Find the pivot
            Vector column = getColumn(columnIndex);
            int pivotIndex = column.getPivot(pivots); 
            
            // Check there exists a pivot for the column
            if (pivotIndex != -1) {

                // Add pivotIndex to pivots
                pivots.add(pivotIndex);

                // Set the pivot element to 1 through row operation
                Vector pivotRow = getRow(pivotIndex);
                Double pivotElement = pivotRow.getElement(columnIndex);
                pivotRow.mult(1/pivotElement);
                
                // Eliminate each non-pivot element in the column
                for (int rowIndex = 0; rowIndex < rows; rowIndex++) {

                    // Do not eliminate pivot
                    if (rowIndex != pivotIndex) {    
                        Double mult = column.getElement(rowIndex);
                        eliminate(pivotIndex, rowIndex, -mult);
                        
                    }
                    
                }
            }
        }
    }

    // Rank
    // This method returns the rank of the matrix.
    public int rank() {
        return pivots.size();
    }

    // Random
    // This method randomises each element of the matrix.
    public void random() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                setElement(row, column, Double.valueOf(ThreadLocalRandom.current().nextInt()));
            }
        }
    }

}