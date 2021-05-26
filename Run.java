// For Testing
public class Run {
    public static void main(String[] args) {
        Matrix myMatrix = new Matrix(3, 3);
        
        myMatrix.setElement(0, 0, -1.2);
        myMatrix.setElement(0, 1, 2.5);
        myMatrix.setElement(0, 2,  3.0);
        myMatrix.setElement(1, 0, 3.5);
        myMatrix.setElement(1, 1, -3.0);
        myMatrix.setElement(1, 2, 12.0);
        myMatrix.setElement(2, 0, -4.0);
        myMatrix.setElement(2, 1, 2.0);
        myMatrix.setElement(2, 2, 1.0);

        Vector row1 = myMatrix.getRow(0);
        Vector row2 = myMatrix.getRow(1);
        Vector row3 = myMatrix.getRow(2);

        System.out.println(myMatrix);
        System.out.println(row2.dot(row3));
        System.out.println(row3.length() + "\n");

        // row1.normalize();
        // row2.normalize();
        // row3.normalize();

        //System.out.println(myMatrix);
        //System.out.printf("%s, %s, %s", row1.length(), row2.length(), row3.length());

        Matrix myTranspose = myMatrix.transpose();
        System.out.println(myTranspose);
    }
    
}
