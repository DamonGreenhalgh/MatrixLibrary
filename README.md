# MatrixLibrary
Here you will find an overview of the library
Author: Damon Greenhalgh

Matrix Class
------------
    Methods 
        multRow(int row1, double mult) - Multipies a row by a scaler.
        addRow(int row1, int row2, double mult) - Adds two rows together, can scale seconder operand.


Vector Class 
------------
    Fields
        int size - the size/length of the Vector.
        ArrayList<Double> vec - the ArrayList ADT that represents the Vector structure.

    Methods
        createVector() - creates a Vector object based on the size field.
        toString() - returns a String representation of the Vector object.
        getSize() - returns the length of the vector as an integer primitive.
        setElement(int index, Double val) - edits an element of the Vector object.