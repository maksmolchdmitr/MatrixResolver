import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner userScanner = new Scanner(System.in);
        boolean isEnd = false;
        do{
            Reader.setScanner(userScanner);
            System.out.print("""
                    Print
                    0 - to exit from program
                    1 - to read Matrix
                    2 - to read Complex
                    3 - to read two Matrix
                    Make your choice >\040""");
            switch (Reader.readInt()) {
                case 0 -> isEnd = true;
                case 1 -> {
                    Matrix matrix = Reader.readMatrixWithUserInterface(userScanner);
                    System.out.println("Matrix:\n" + matrix);
                    System.out.println("Transpose:\n" + matrix.T());
                    System.out.println("Determinant = " + matrix.det());
                }
                case 2 -> {
                    System.out.print("Print a and b (z=a+bi) > ");
                    Reader.setScanner(new Scanner(System.in));
                    Complex complex = Reader.readComplex();
                    System.out.println("Complex = " + complex);
                    System.out.println("Trigonometric form: " + complex.trigonometricForm());
                }
                case 3 -> {
                    Matrix matrix1 = Reader.readMatrixWithUserInterface(userScanner);
                    Matrix matrix2 = Reader.readMatrixWithUserInterface(userScanner);
                    System.out.println("Matrix_1:\n" + matrix1);
                    System.out.println("Matrix_2:\n" + matrix2);
                    try{
                        System.out.println("Matrix_1*Matrix_2:\n"+Matrix.mul(matrix1, matrix2));
                    }catch (Exception e){
                        System.out.println("There is not mul for such matrix!");
                    }
                    try{
                        System.out.println("Matrix_1+Matrix_2:\n"+Matrix.sum(matrix1, matrix2));
                    }catch (Exception e){
                        System.out.println("There is not sum for such matrix!");
                    }
                }
                default -> System.out.println("Wrong answer!");
            }
        }while (!isEnd);
    }
}
