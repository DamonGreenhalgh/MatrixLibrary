/**
 * Matrix Package for Java
 * @author Damon Greenhalgh
 */

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Matrix{

    /**
     * FIELDS
     * ------
     */

    /**
     * The matrix structure is an ArrayList with Vectors as its 
     * elements.
     */
    protected ArrayList<Vector> matrix = new ArrayList<Vector>();   

    /**
     * Holds the indices of pivots of the matrix.
     */
    protected ArrayList<Integer> pivots = new ArrayList<Integer>();

    /** 
     * The number of rows and columns in the matrix
     */
    protected int rows, columns;


    /**
     * CONSTRUCTORS
     * ------------
     */

    /**
     * This overloaded constructor initializes a 
     * n x m zero matrix based on the parameters.
     * 
     * @param rows the number of rows (n)
     * @param columns the number of columns (m)
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < rows; i++) {
            matrix.add(new Vector(columns));
        }
    }

    /**
     * Clone
     * This overloaded constructor clones the parameter 
     * matrix.
     * 
     * @param m the matrix to clone
     */
    public Matrix(Matrix m) {
        this.rows = m.getNumRows();
        this.columns = m.getNumColumns();
        
        // Build the 0 matrix
        for(int row = 0; row < rows; row++) {
            matrix.add(new Vector(columns));
        }

        // Set each element
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                setElement(row, column, m.getElement(row, column));
            }
        }
    }


    /**
     * ACCESSORS / MUTATORS
     * --------------------
     */
    
    /**
     * Get Row
     * This method returns the row of the matrix based
     * on the parameter index. Note: the first row has 
     * index 0.
     * 
     * @param index the row to return
     * @return the row vector
     */
    public Vector getRow(int index) { return matrix.get(index); }   

    /**
     * Get Column
     * This method returns the column of the matrix
     * based on the parameter index. Note: the first 
     * column has index 0.
     * 
     * @param index the column to return
     * @return the column vector
     */                                           
    public Vector getColumn(int index) {                                                                        
        Vector column = new Vector(rows);
        for (int i = 0; i < rows; i++) {
            column.setElement(i, getElement(i, index));
        }
        return column;
    }

    /**
     * Get Element
     * This method returns the element at mat[row][column].
     * 
     * @param row the index of the row
     * @param column the index of the column
     * @return the element at row, column
     */
    public Double getElement(int row, int column) { return matrix.get(row).getElement(column); }

    /**
     * Set Element
     * This method sets a new value at mat[row][column].
     *  
     * @param row the index of the row
     * @param column the index of the column
     * @param value the new value 
     */
    public void setElement(int row, int column, Double value) { matrix.get(row).setElement(column, value); }

    /**
     * Number of Rows
     * This method returns the number of rows of the
     * matrix.
     * 
     * @return the number of rows
     */
    public int getNumRows() { return rows; }
    
    /**
     * Number of Columns
     * This method returns the number of columns 
     * of the matrix.
     * 
     * @return the number of columns
     */
    public int getNumColumns() { return columns; }


    /**
     * METHODS
     * -------
     */

    /**
     * String Representation
     * This method returns a string representation of 
     * the matrix.
     * 
     * @return str the string representation
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            str += getRow(i).toString() + "\n";
        }
        return str;
    }

    /**
     * Scalar Addition
     * This overloaded method adds a scalar value to each 
     * element of the matrix.
     * 
     * @param val the scalar value
     */
    public void add(Double val) {
        for (int row = 0; row < rows; row++) {
            getRow(row).add(val);
        }
    }

    /**
     * Matrix Addition
     * This overloaded method applies matrix addition to 
     * the object.
     * 
     * @param m the matrix to add
     */
    public void add(Matrix m) {
        for (int row = 0; row < rows; row++) {
            getRow(row).add(m.getRow(row));
        }
    }

    /**
     * Scalar Multiplication
     * This overloaded method applies scalar multiplication to this
     * object.
     * 
     * @param val the scalar value
     */
    public void mult(Double val) {
        for (int row = 0; row < rows; row++) {
            getRow(row).mult(val);
        }
    }

    /**
     * Matrix Multiplication
     * This overloaded method applies matrix multiplication to
     * this object.
     * 
     * @param m the matrix to multiply
     * @return mat the product of the two matricies
     */
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

    /**
     * Transpose
     * This method returns a new matrix, which is the transpose 
     * of the object.
     * 
     * @return the transpose
     */
    public Matrix transpose() {
        Matrix transpose = new Matrix(columns, rows);            // create new matrix
        for (int i = 0; i < columns; i++) {                      
            for (int j = 0; j < rows; j++) {                     // iterate through each value 
                transpose.setElement(j, i, getElement(i, j));    // set the value of trans[i, j] = mat[j, i]
            }
        }
        return transpose;
    }

    /**
     * Power
     * This method returns a new matrix, which is the result 
     * of the matrix to the parameter power.
     * 
     * @param power the power of the matrix
     * @return the result
     */
    public Matrix pow(int power) {
        Matrix pow = this;
        for (int i = 0; i < power - 1; i++) {
            pow = mult(pow);
        }
        return pow;
    }

    /**
     * Eliminate
     * This method emulates row operations for Gaussian Elimination.
     * The second parameter row is overwritten.
     * 
     * @param idx1 the first row index
     * @param idx2 the second row index
     * @param mult the factor
     */
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

    /**
     * Reduced Row Echelon Form (RREF)
     * This method reduces the matrix to rref, through the use
     * of Gaussian Elimination
     */
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

    /** Join
     *  This method appends the parameter object to the matrix.
     *  @param Object obj
     */
    public void join(Object obj) {
        /** The object could be of type Vector
         *  or of type Matrix, reguardless this method will
         *  append it to the end of the matrix.
         */


    }

    /** Solve 
     *  This method returns a vector which is a solution of the matrix
     *  @param Vector v
     */
    public Vector solve(Vector v) {
        /** Algorithim
         *  ----------
         *  - Check parameter vector is the same length as the number columns.
         *  - Join the vector with the matrix.
         *  - RREF the matrix, not including the final column.
         *  - Return the final column as the solution of the matrix
         */
        
        
        return null;
    }

    /**
     * Rank
     * This method returns the rank of the matrix.
     * @return
     */
    public int rank() {
        // Clone matrix
        Matrix clone = new Matrix(this);

        // Row reduce clone
        clone.rref();

        // Return the number of pivots
        return clone.pivots.size();
    }

    /**
     * Random
     * This method randomises each element in the matrix.
     */
    public void random() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                setElement(row, column, Double.valueOf(ThreadLocalRandom.current().nextInt()));
            }
        }
    }

}