// For Testing
public class Run {
    public static void main(String[] args) {
        Matrix myMatrix = new Matrix(3, 3);
        Matrix myMatrix2 = new Matrix(4, 3);
        Matrix myMatrix3 = new Matrix(3, 5);
        
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

        System.out.println(myMatrix);
        System.out.println(myMatrix2);
        System.out.println(myMatrix3);

        Matrix product = myMatrix2.multMat(myMatrix3);    // product matrix
        System.out.print(product);

        /*
        Vector row1 = myMatrix.getRow(0);
        Vector row2 = myMatrix.getRow(1);
        Vector row3 = myMatrix.getRow(2);

        System.out.println(myMatrix);
        System.out.println(row2.dot(row3));
        System.out.println(row3.length() + "\n");

        row1.normalize();
        row2.normalize();
        row3.normalize();

        System.out.println(myMatrix);
        System.out.printf("%s, %s, %s", row1.length(), row2.length(), row3.length());

        Matrix myTranspose = myMatrix.transpose();
        System.out.println(myTranspose);
        */
    }
    
}
