/**
 * @class Matrix
 * @description This class creates a Matrix object.
 * @author Damon Greenhalgh
 */

package com.damongreenhalgh.matrixpackage;

import java.util.Random;

public class Matrix {

    /** FIELDS */

    static private int DEFAULT_SIZE = 3;
    private double[][] matrix;
    private int rows, columns;
    private int rank;

    /** CONSTRUCTORS */

    /**
     * This is the default no-arg constructor.
     * Creates a 3x3 0 matrix.
     */
    public Matrix() { create(DEFAULT_SIZE, DEFAULT_SIZE); }

    /**
     * Creates a rows x columns zero matrix
     * 
     * @param rows       the number of rows
     * @param columns    the number of columns
     */
    public Matrix(int rows, int columns) { create(rows, columns); }

    /**
     * Creates a matrix object based on a 2-dimensional array.
     * 
     * @param array    the 2-dimensional array to build the matrix around
     */
    public Matrix(double[][] array) {
        create(array.length, array[0].length);
        this.matrix = array;
    }

    /**
     * This constructor creates a rows x columns preset matrix based on the
     * parameter type.
     * 
     * @param rows       the number of rows
     * @param columns    the number of columns
     * @param type       the type of matrix to create
     */
    public Matrix(int rows, int columns, MatrixType type) { 
        create(rows, columns); 
        switch (type) {
            case IDENTITY: {
                if (rows == columns) {    // must be a square matrix
                    for (int i = 0; i < rows; i++) {
                        setElement(i, i, 1);
                    }
                }
                break;

            } case RANDOM: {
                // random integer for each element in the matrix
                Random r = new Random();
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < columns; j++) {
                        matrix[i][j] = r.nextInt(100) - 50;
                    }
                }
                break;

            } case ONE: {
                add(1);
                break;

            } case DEFAULT: {
                break;
            }
        }
    }
    
    /**
     * Helper method to instantiate the array that represents the matrix.
     * 
     * @param rows       the number of rows
     * @param columns    the number of columns
     */
    private void create(int rows, int columns) {
        this.rows= rows;
        this.columns = columns;
        matrix = new double[rows][columns];
    }

    // Accesors/Mutators
    public int getNumRows() { return rows; }
    public int getNumColumns() { return columns; }
    public Matrix getRow(int index) {
        Matrix vector = new Matrix(1, columns, MatrixType.DEFAULT);
        for (int column = 0; column < columns; column++) {
            vector.setElement(0, column, getElement(index, column));
        }
        return vector;
    }
    public Matrix getColumn(int index) {
        Matrix vector = new Matrix(rows, 1, MatrixType.DEFAULT);
        for (int row = 0; row < rows; row++) {
            vector.setElement(row, 0, getElement(row, index));
        }
        return vector;
    }
    public double getElement(int row, int column) { return matrix[row][column]; }
    public void setElement(int row, int column, double value) { matrix[row][column] = value; }
    public int getRank() { return rank; }
    // Methods

    /** 
     * ToString
     * --------
     * This method returns a string representation of the matrix object.
     * 
     * @return str    the string to return
     */
    public String toString() {
        String str = "";
        for(int row = 0; row < rows; row++) {
            str += "[ ";
            for(int column = 0; column < columns; column++) {
                str += String.format("%.3f ", matrix[row][column]);
            }
            str += "]\n"; 

        }
        return str;
    }

    /**
     * Clone
     * -----
     * This method clones the matrix.
     * Time complexity of O(n^2)
     * 
     * @return clone    the cloned matrix
     */
    public Matrix clone() {
        Matrix clone = new Matrix(rows, columns);
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                clone.matrix[row][column] = matrix[row][column];
            }
        }
        return clone;
    }

    /**
     * Transpose
     * ---------
     * This method returns the tranpose of the matrix.
     * Time complexity of O(n^2)
     * 
     * @return transpose    the transpose matrix
     */
    public Matrix transpose() {
        Matrix transpose = new Matrix(columns, rows);
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                transpose.matrix[row][column] = matrix[column][row];
            }
        }
        return transpose;
    }

    /**
     * Matrix Multiplication
     * ---------------------
     * This method returns a new matrix, which is the product of the matrix and the
     * parameter. The matrix is right multiplied by the parameter matrix m.
     * Time complexity of O(n^3)
     * 
     * @param m            the second operand
     * @return product     the product matrix
     */
    public Matrix multiply(Matrix m) {

        Matrix product = new Matrix(rows, m.columns, MatrixType.DEFAULT);
        double sum = 0;

        // validate the operation
        if (columns != m.getNumRows()) {    
            return null;
        }

        for (int row = 0; row < product.rows; row++) {
            for (int column = 0; column < product.columns; column++) {

                // reset sum
                sum = 0;

                // compute sum
                for (int i = 0; i < columns; i++) {
                    sum += matrix[row][i] * m.matrix[i][column];
                }
                product.matrix[row][column] = sum;
            }
        }
        return product;
    }

    /**
     * Scalar Multiplication
     * ---------------------
     * This method multiplies the matrix with the scalar parameter value.
     * Time complexity of O(n^2)
     * 
     * @param value    the scalar value
     */
    public void multiply(double value) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = matrix[row][column] * value;
            }
        }
    }

    /** 
     * Matrix Addition
     * ---------------
     * This method adds the parameter matrix to the matrix.
     * Time complexity of O(n^2)
     * 
     * @param m    the matrix to add
     */
    public void add(Matrix m) {
        
        // validate the operation
        if (rows == m.rows && columns == m.columns) {

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    matrix[row][column] += m.matrix[row][column];
                }
            }
        }
    }

    /**
     * Scalar Addition
     * ---------------
     * This method adds the parameter scalar value to every element of the matrix.
     * Time complexity of O(n^2)
     * 
     * @param value    the scalar value
     */
    public void add(double value) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] += value;
            }
        }
    }
    
    /** 
     * Power
     * -----
     * This method returns a new matrix, which is the result of the matrix 
     * to the power of the parameter value.
     * Time Complexity of O(n^3)
     * 
     * Helper Method/s:
     * @method multiply(Matrix m) 
     * 
     * @param value      the power to raise
     * @return result    the result
     */
    public Matrix power(int value) {
        Matrix power = this;
        while (value - 1 > 0) {
            power = multiply(power);
            value--;
        }
        return power;
    }

    /**
     * Swap
     * ----
     * This method swaps two rows in the matrix, determined by the parameter indexes.
     * Time Complexity is O(n)
     * 
     * @param row1    the index of the first row
     * @param row2    the index of the second row
     */
    private void swap(int row1, int row2) {
        double temp;
        for(int i = 0; i < columns; i++) {
            temp = matrix[row1][i];
            matrix[row1][i] = matrix[row2][i];
            matrix[row2][i] = temp;
        }
    }

    /**
     * Row Multiply
     * ------------
     * This method multiplies a row by the parameter value.
     * Time Complexity of O(n)
     * 
     * @param row      the index of the row to multiply
     * @param value    the value to multiply the row by
     */
    private void multiply(int row, double value) {
        for(int i = 0; i < columns; i++) {
            matrix[row][i] = matrix[row][i] * value;
        }
    }

    /**
     * Eliminate
     * ---------
     * This method subtracts a row multiple of another row in the matrix such that
     * the resulting sum will be 0. Given by formula: row1 = row1 - a * row2 = 0, 
     * where a is a scalar value.
     * 
     * @param row1      the index of the first row
     * @param row2      the index of the second row
     * @param column    the index of the pivot
     */
    private void eliminate(int row1, int row2, int column) {
        double factor = matrix[row1][column];
        for(int i = 0; i < columns; i++){
            matrix[row1][i] -= factor * matrix[row2][i];
        }
    }

    /**
     * EchelonForm (rref)
     * ------------------
     * This method reduces the matrix to Reduced Row Echelon Form through the use
     * of Gaussian Elimination.
     * Time Complexity of O(n^3)
     * 
     * Helper Method/s:
     * @method swap(int row1, int row2)         
     * @method multiply(int row, double value)     
     * @method eliminate(int row1, int row2, int column)    
     * 
     * @param end     the column to stop row reducing
     */
    public void echelonForm(int end) {
        /**
         * Algorithm
         * ---------
         * - Iterate through each column of the matrix
         * - Find the pivot element of the column if it exists
         * - Swap the pivot row to the correct position
         * - Eliminate all elements above and below the pivot element
         */
        int pivot = 0;

         for(int column = 0; column < end; column++) {

             // find pivot
             for(int row = 0; row < rows; row++) {
                if(!(Math.abs(matrix[row][column])< 0.001) && row >= pivot) {

                    // swap to correct position
                    swap(row, pivot);
                    
                    // normalize the pivot row
                    multiply(pivot, 1/matrix[pivot][column]);

                    // eliminate below and above the pivot
                    for(int j = 0; j < rows; j++) {
                        if(j != pivot) {
                            eliminate(j, pivot, column);
                        }
                    }
                    pivot++;
                } 
            } 
        }
        rank = pivot;
    }

    /**
     * Join
     * ----
     * This method appends two matrices together.
     * Time Complexity of O(n^2)
     * 
     * @param m    the matrix to append
     * @return     true if successful, false otherwise
     */
    public boolean join(Matrix m) {

        // check for the same number of rows
        if(rows != m.rows) {
            System.out.println("The two matricies have different dimensions.");
            return false;
        }

        // define the result matrix
        double[][] temp = new double[rows][columns + m.columns];

        // clone elements from both matricies into the new matrix
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns + m.columns; j++) {
                if(j < columns) {
                    temp[i][j] = matrix[i][j];
                } else {
                    temp[i][j] = m.matrix[i][j - columns];
                }
            }
        }

        // overwrite original matrix
        columns += m.columns;
        matrix = temp;

        return true;
    }

    /**
     * Submatrix
     * ---------
     * This method returns a submatrix of the matrix based on the parameter values.
     * Time Complexity of O(n^2)
     * 
     * @param indices    the indices of the submatrix {rowStart, rowEnd, columnStart, columnEnd}
     * @return           the submatrix to return.
     */
    public Matrix submatrix(int[] indices) {

        // define new submatrix
        double[][] temp = new double[indices[1] - indices[0]][indices[3] - indices[2]];

        // set each element into new matrix
        for(int i = indices[0]; i < indices[1]; i++) {
            for(int j = indices[2]; j < indices[3]; j++) {
                temp[i - indices[0]][j - indices[2]] = matrix[i][j];
            }
        }
        return new Matrix(temp);
    } 

    /**
     * Inverse
     * -------
     * This method returns the inverse of the matrix if it exists.
     * Time Complexity of O(n^3)
     * 
     * Helper Method/s:
     * @method echlonForm(int end)
     * @method join(Matrix m)
     * @method submatrix(int[] indices)
     * 
     * @return    the inverse matrix
     */
    public Matrix inverse() {
        /**
         * Algorithim
         * ----------
         * - Check matrix is sqaure
         * - Define new matrix which has size nx2n
         * - Row reduce up to n columns
         * - Return the right half of the matrix as the inverse
         */

        // check matrix is square
        if(rows != columns) {
            System.out.println("Matrix is not sqaure.");
            return null;
        }
        // define new matrix
        Matrix temp = clone();
        temp.join(new Matrix(rows, columns, MatrixType.IDENTITY));

        // row reduce by n columns.
        temp.echelonForm(columns);

        // check if matrix is singular
        if(temp.rank != columns) {
            System.out.println("Matrix is singular");
            return null;
        }

        // return the right submatrix
        int[] indices = {0, rows, columns, temp.columns};
        Matrix inverse = temp.submatrix(indices);
        return inverse;
    }

    /**
     * Solve
     * -----
     * This method solves a system of linear equations given by the parameter.
     * The formula is Ax = b, where A is the matrix, b is the product vector, and 
     * x is the vector to solve for.
     * Time Complexity of O(n^3)
     * 
     * Helper Method/s:
     * @method inverse()
     * @method multiply(Matrix m)
     * 
     * @param b     the product vector
     * @return x    the vector to solve for
     */
    public Matrix solve(Matrix b) {
        /**
         * Algorithim
         * ----------
         * - Get the inverse of A
         * - Left multiply b by A^-1
         * - Return the product
         */

        // get inverse
        Matrix inverse = inverse();

        // left multiply b by A^-1
        Matrix x = inverse.multiply(b);

        return x;
    }

    /**
     * Determinant
     * -----------
     * This method returns the determinant of the matrix, if it exists. 
     * Time Complexity of O(n!)
     * 
     * Helper Method/s:
     * @method submatrix(int[] indices)
     * @method join(Matrix m)
     * @method determinant()
     * 
     * 
     */
    public Double determinant() {
        /**
         * Algorithim
         * ----------
         * - Check that it is a sqaure matrix
         * - Apply cofactor expansion along the first row
         * - Create right and left submatrices and join them together
         * - Recursively call the determinant method for submatrices
         */
        double det = 0;
        Matrix sub;

        // check the matrix is square
        if(rows != columns) {
            System.out.println("The matrix is not square.");
            return null;
        }

        // base cases
        // if matrix is 1x1;
        if(rows == 1) {
            return matrix[0][0];
        }

        // if the matrix is 2x2
        if(rows == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        // otherwise recursively call itself over the submatrices
        for(int i = 0; i < columns; i++) {

            // create left and right submatrices and append them together
            int[] coord1 = {1, rows, 0, i};
            int[] coord2 = {1, rows, i + 1, columns};
            Matrix left = submatrix(coord1);
            Matrix right = submatrix(coord2);
            sub = left;
            sub.join(right);

            // recursively call itself on the submatrix
            det += matrix[0][i] * Math.pow(-1, i) * sub.determinant();
        }
        return det;
    }
}