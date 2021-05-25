// For Testing
public class Run {
    public static void main(String[] args) {
        Matrix myMatrix = new Matrix(3, 3);
        
        myMatrix.setElement(0, 0, -1.2);
        myMatrix.setElement(0, 1, 2.5);
        myMatrix.setElement(0, 2,  3.0);
        myMatrix.setElement(1, 0, 0.01);
        myMatrix.setElement(1, 1, 42.9);
        myMatrix.setElement(1, 2, 12.0);
        myMatrix.setElement(2, 0, -4.0);
        System.out.println(myMatrix);

    }
    
}
