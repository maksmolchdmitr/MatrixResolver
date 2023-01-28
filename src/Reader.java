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
}
