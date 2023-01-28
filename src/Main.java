import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner mainScanner = new Scanner(System.in);
        boolean isEnd = false;
        do{
            Reader.setScanner(mainScanner);
            System.out.print("""
                    Print
                    0 - to exit from program
                    1 - to read Matrix
                    2 - to read Complex
                    Make your choice >\040""");
            switch (Reader.readInt()) {
                case 0 -> isEnd = true;
                case 1 -> {
                    System.out.print("""
                            Print
                            0 - to read with Complex numbers
                            1 - to read with Real numbers
                            Make your choice >\040""");
                    ComplexReadable numberReadable = null;
                    do {
                        switch (Reader.readInt()) {
                            case 0 -> numberReadable = Reader::readComplex;
                            case 1 ->{
                                numberReadable = Reader::readDouble;
                                System.out.println("Print matrix row and col and her elements:");
                            }
                            default -> System.out.println("Wrong answer!");
                        }
                    } while (numberReadable == null);
                    System.out.print("""
                            Print
                            0 - to read from file
                            1 - to read from console
                            Make your choice >\040""");
                    Scanner scanner = null;
                    do {
                        switch (Reader.readInt()) {
                            case 0 -> {
                                System.out.println("Print file name > ");
                                String fileName = Reader.readString();
                                scanner = new Scanner(new FileInputStream(fileName));
                            }
                            case 1 ->{
                                scanner = mainScanner;
                                System.out.println("Print matrix (as the row and column sizes and its elements)");
                            }
                            default -> System.out.println("Wrong answer!");
                        }
                    } while (scanner == null);
                    Reader.setScanner(scanner);
                    Matrix matrix = Reader.readMatrix(numberReadable);
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
                default -> System.out.println("Wrong answer!");
            }
        }while (!isEnd);
    }
}
