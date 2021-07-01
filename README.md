# Matrix Package for Java
This package implements the matrix mathematical structure for Java.  

## Matrix Class

### Fields
The following fields are used in the Matrix.java class.

Type | Name | Description
---- | ----- | -----------
`double[][]` | `matrix` | The underlying data structure used to represent the matrix structure.
`int` | `rows` | The number of rows of the matrix.
`int` | `columns` | The number of columns of the matrix.
`int` | `rank` | The rank of the matrix.

### Constructors
The following constructors can be used to instantiate the matrix object. 

Constructor | Description
----------- | -----------
`Matrix()` | This default non-arg constructor, instantiates a 3x3 zero matrix.
`Matrix(int rows, int columns)` | This constructor creates a rows x columns zero matrix.
`Matrix(int rows, int columns, MatrixType type)` | This constructor creates a rows x columns preset matrix determined by the parameter type.
`Matrix(double[][] array)` | This constructor creates an array based on the parameter two-dimensional array.

### Accessors/Mutators
The following methods can be used to access and modify certain fields of the matrix object.
Accessor/Mutator | Return | Description
---------------- | ------ | -----------
`getNumRows()` | int | Returns the rows field.
`getNumColumns()` | int | Returns the columns field.
`getRow(int index)` | Matrix | Returns the row of a matrix at the given index.
`getColumn(int index)` | Matrix | Returns the column of the matrix at the given index.
`getElement(int row, int column)` | double | Returns the element at the given parameter index.
`setElement`(int row, int column, int value) | void | Sets the element at the parameter index to the new parameter value.
`getRank()` | int | Returns the rank field.

### Methods
Below are the following methods that have been implemented in the Matrix.java class.

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

### Enums
Enum | Description
---- | -----------
`DEFAULT` | nxm zero matrix.
`IDENTITY` | nxn identity matrix.
`RANDOM` | nxm matrix with random integers as elements.
`ONE` | nxm matrix with integer 1 for all elements.

