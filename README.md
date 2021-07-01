# Matrix Package for Java
This package implements the matrix mathematical structure for Java.  

## Matrix Class
Below are the following methods that have been implemented in the Matrix.java file.

Method | Return | Description
------ | ------ | -----------
`toString()` | String | This method returns a string representation of the matrix.
`clone()` | Matrix | This method returns a new matrix, which is a clone of the original matrix.
`transpose()` | Matrix | This method a new matrix, which is the transpose of the matrix.
`multiply(double value)` | void | This method multiplies the matrix with the scalar parameter value.
`multiply(Matrix m)` | Matrix | This method returns a new matrix, which is the product of the matrix and the parameter. The matrix is right multiplied by the parameter matrix m.
`add(double value)` | void | This method adds the scalar parameter value to every element of the matrix.
`add(Matrix m)` | void | This method adds the parameter matrix to the matrix.
`power(int value)` | Matrix | This method returns a new matrix, which is the result of the matrix to the power of the parameter value.
`echelonForm(int end)` | void | This method reduces the matrix to Reduced Row Echelon Form through the use of Gaussian Elimination.
`join(Matrix m)` | boolean | This method appends the parameter matrix to the end of the matrix.
`submatrix(int[] indices)` | Matrix | This method returns a submatrix of the matrix determined by the parameter.
`inverse()` | Matrix | This method returns the inverse of the matrix, if it exists.
`solve(Matrix b)` | Matrix | This method solves a system of linear equations in the form Ax = b, where A is the matrix, b is the parameter vector and x is the vector to solve. The return value is the vector x. 
`determinant()` | Double | This method returns the determinant of the matrix, if it exists.

## MatrixType Enum
Below are the following enums for the MatrixType.enum file.

Enum | Description
---- | -----------
`DEFAULT` | nxm zero matrix.
`IDENTITY` | nxn identity matrix.
`RANDOM` | nxm matrix with random integers as elements.
`ONE` | nxm matrix with integer 1 for all elements.

