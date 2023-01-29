import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    private static Scanner scanner = new Scanner(System.in);

    public static void setScanner(Scanner scanner) {
        Reader.scanner = scanner;
    }

    public static Complex readComplex(){
        return new Complex(scanner.nextDouble(), scanner.nextDouble());
    }
    public static Complex readDouble(){
        return new Complex(scanner.nextDouble());
    }
    public static Matrix readMatrix(ComplexReadable complexReadable){
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        Matrix res = new Matrix(r, c);
        Complex[][] table = new Complex[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                table[i][j] = complexReadable.read();
            }
        }
        res.fillTable(table);
        return res;
    }
    public static int readInt(){
        return scanner.nextInt();
    }
    public static String readString(){
        return scanner.next();
    }
    public static Matrix readMatrixWithUserInterface(Scanner userScanner) throws FileNotFoundException {
        Reader.setScanner(userScanner);
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
                    scanner = userScanner;
                    System.out.println("Print matrix (as the row and column sizes and its elements)");
                }
                default -> System.out.println("Wrong answer!");
            }
        } while (scanner == null);
        Reader.setScanner(scanner);
        return Reader.readMatrix(numberReadable);
    }
}
