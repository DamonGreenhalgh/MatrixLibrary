# MatrixLibrary
Here you will find an overview of the library.  

## Matrix Class

### Fields  
`int rows` - the number of rows.  
`int columns` - the number of columns.  
`ArrayList<Vector> matrix` - an arraylist of vector objects that represent the matrix structure.

### Constructors
`Matrix(int rows, int columns)` - creates a matrix with respect to the parameter rows and columns

### Accessors/Mutators
`getRow(int index)` - returns a row vector at the parameter index.  
`getColumn(int index)` - returns a column vector at the parameter index.  
`getElement(int row, int column)` - returns the element with respect to the parameters.  
`setElement(int row, int column, Double value)` - sets an element of the matrix with respect to the parameter values.  
`getNumRows()` - returns the rows field.  
`getNumColumns()` - returns the columns field.

### Methods 
`eliminate(int row1, int row2, double mult)` - adds two rows together, can scale seconder operand.  
`transpose()` - returns a new matrix which is the transpose of the orignal matrix.  
`mult(Matrix m)` - returns a new matrix which is the product of the orginal matrix and the parameter matrix.  
`pow(int power)` - returns a new matrix, which is the original matrix to the power of the parameter.  
`rref()` - reduces the matrix into Reduced Row Echelon Form applying Gaussian Elimination.


## Vector Class

### Fields
`int size` - the size/length of the vector.  
`ArrayList<Double> vec` - the ArrayList ADT that represents the Vector structure.

### Constructors
`Vector(int size)` - creates a new vector object with respect to parameter size.

### Accessors/Mutators
`getSize()` - returns the size of the vector.  
`setElement(int index, Double val)` - sets a new value of a element in the vector.  
`getElement(int index)` - returns the element at the parameter index.

### Methods
`toString()` - returns a string representation of the vector.  
`getSize()` - returns the length of the vector as an integer.  
`setElement(int index, Double val)` - edits an element of the vector.  
`dot(Vector v)` - returns the dot product of the vector and the parameter vector.  
`length()` - returns the length of the vector.  
`normalize()` - normalizes the vector to have length 1.

## Todo
+ Determinant
+ Gram Schmidt Orthogonalization
+ Eigenvalues
+ Eigenvectors
+ Submatrix
+ Inverse
