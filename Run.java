
// For Testing
import matrixlibrary.*;

public class Run {
    public static void main(String[] args) {
        Matrix myMatrix = new Matrix(3, 3);
        Matrix myMatrix2 = new Matrix(4, 3);
        Matrix myMatrix3 = new Matrix(3, 5);
        Matrix myMatrix4 = new Matrix(3, 3);
        
        // test matrix 1 (identity)
        myMatrix.setElement(0, 0, 1.0);
        myMatrix.setElement(0, 1, 0.0);
        myMatrix.setElement(0, 2, 0.0);
        myMatrix.setElement(1, 0, 0.0);
        myMatrix.setElement(1, 1, 1.0);
        myMatrix.setElement(1, 2, 0.0);
        myMatrix.setElement(2, 0, 0.0);
        myMatrix.setElement(2, 1, 0.0);
        myMatrix.setElement(2, 2, 1.0);

        // test matrix 2
        myMatrix2.setElement(0, 0, 1.0);
        myMatrix2.setElement(0, 1, -4.0);
        myMatrix2.setElement(0, 2,  3.0);
        myMatrix2.setElement(1, 0, 1.0);
        myMatrix2.setElement(1, 1, 1.0);
        myMatrix2.setElement(1, 2, 0.0);
        myMatrix2.setElement(2, 0, 2.0);
        myMatrix2.setElement(2, 1, 0.0);
        myMatrix2.setElement(2, 2, 3.0);
        myMatrix2.setElement(3, 0, -8.0);
        myMatrix2.setElement(3, 1, 0.0);
        myMatrix2.setElement(3, 2, 1.0);

        // test matrix 3
        myMatrix3.setElement(0, 0, 1.0);
        myMatrix3.setElement(0, 1, 2.0);
        myMatrix3.setElement(0, 2, -3.0);
        myMatrix3.setElement(0, 3, 5.0);
        myMatrix3.setElement(0, 4, -2.0);
        myMatrix3.setElement(1, 0, -3.0);
        myMatrix3.setElement(1, 1, 4.0);
        myMatrix3.setElement(1, 2, 2.0);
        myMatrix3.setElement(1, 3, 9.0);
        myMatrix3.setElement(1, 4, 10.0);
        myMatrix3.setElement(2, 0, -4.0);
        myMatrix3.setElement(2, 1, 12.0);
        myMatrix3.setElement(2, 2, 2.0);
        myMatrix3.setElement(2, 3, -3.0);
        myMatrix3.setElement(2, 4, 1.0);

        // test matrix 4, standard 3x3
        myMatrix4.setElement(0, 0, 3.0);
        myMatrix4.setElement(0, 1, 2.0);
        myMatrix4.setElement(0, 2, -1.0);
        myMatrix4.setElement(1, 0, 2.0);
        myMatrix4.setElement(1, 1, 3.0);
        myMatrix4.setElement(1, 2, -5.0);
        myMatrix4.setElement(2, 0, 1.0);
        myMatrix4.setElement(2, 1, 2.0);
        myMatrix4.setElement(2, 2, 1.0);

        System.out.println(myMatrix);
        System.out.println(myMatrix2);
        System.out.println(myMatrix3);
        System.out.println(myMatrix4);

        /*
        System.out.println(myMatrix4.pow(10));    // power

        Matrix product = myMatrix2.multMat(myMatrix3);    // product 
        System.out.print(product);

        Vector row1 = myMatrix.getRow(0);    // get row vectors
        Vector row2 = myMatrix.getRow(1);
        Vector row3 = myMatrix.getRow(2);

        System.out.println(myMatrix);
        System.out.println(row2.dot(row3));          // dot product
        System.out.println(row3.length() + "\n");    // length

        row1.normalize();    // normalized vectors
        row2.normalize();
        row3.normalize();

        Matrix myTranspose = myMatrix.transpose();    // transpose
        System.out.println(myTranspose);
        */
    }
    
}
