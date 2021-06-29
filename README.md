# MatrixLibrary
This Java package implements the matrix mathematical structure.  

## Matrix Class
Below are the following methods that have been implemented in the Matrix.java file.

Method | Description
------ | -----------
`toString` | This method returns a string representation of the matrix. | String
`clone` | This method returns a clone of the original matrix. | Matrix
`transpose` | This method returns the transpose of the matrix.
`multiply` | This method right multiplies the matrix with the parameter.  Supports scalar and matrix multiplication.
`add` | This method adds the parameter to the matrix. Supports scalar and matrix addition.
`power` | This method the matrix to the parameter power.
`gaussianElimination` | This method reduces the matrix to Reduced Row Echelon Form through the use of Gaussian Elimination.
`join` | This method appends the parameter matrix to the end of the matrix.
`submatrix` | This method returns a submatrix of the matrix determined by the parameter.
`inverse` | This method returns the inverse of the matrix.
`solve` | This method solves a system of linear equations in the form Ax = b, where A is the matrix, b is the parameter vector and x is the vector to solve. The return value is the vector x. 
`determinant` | This method returns the determinant of the matrix, if it exists.


