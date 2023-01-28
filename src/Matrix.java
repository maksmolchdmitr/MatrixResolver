import java.util.Arrays;

public class Matrix {
    private Complex[][] table;
    private final int row;
    private final int col;
    public Matrix(int row, int col){
        this.row = row;
        this.col = col;
        table = new Complex[row][col];
    }

    public void fillTable(Complex[][] table){
        this.table = table;
    }
    public void fillTable(double[][] table){
        Complex[][] newTable = new Complex[table.length][table[0].length];
        for (int i=0; i< table.length; i++){
            for(int j=0; j< table[j].length; j++){
                newTable[i][j] = new Complex(table[i][j]);
            }
        }
        fillTable(newTable);
    }
    public static Matrix sum(Matrix a, Matrix b){
        if(a.row!=b.row || a.col!=b.col){
            throw new RuntimeException("Illegal sizes of matrix");
        }
        Matrix res = new Matrix(a.row, a.col);
        for(int i=0; i<a.row; i++){
            for(int j=0; j<a.col; j++){
                res.table[i][j] = a.table[i][j].add(b.table[i][j]);
            }
        }
        return res;
    }

    public static Matrix mul(Matrix a, Matrix b){
        if(a.col!=b.row){
            throw new RuntimeException("Illegal sizes of matrix");
        }
        Matrix res = new Matrix(a.row, b.col);
        for(int i=0; i<a.col; i++){
            for(int j=0; j<a.col; j++){
                res.table[i][j] = Complex.ZERO;
                for(int k=0; k<a.col; k++){
                    res.table[i][j].add(a.table[i][j].add(b.table[i][j]));
                }
            }
        }
        return res;
    }

    public Matrix T(){
        Matrix res = new Matrix(this.col, this.row);
        for(int i=0; i<this.row; i++){
            for(int j=0; j<this.col; j++){
                res.table[j][i] = this.table[i][j];
            }
        }
        return res;
    }

    public Complex det(){
        return det(this);
    }

    public static Complex det(Matrix matrix){
        if(matrix.row!=matrix.col){
            throw new RuntimeException("Illegal sizes of matrix");
        }
        if(matrix.row==2){
            return Complex.sub(Complex.mul(matrix.table[0][0], matrix.table[1][1]), Complex.mul(matrix.table[0][1], matrix.table[1][0]));
        }else {
            Complex sum = Complex.ZERO;
            for(int j=0; j<matrix.col; j++){
                sum = sum.add(algebraicComplement(matrix, 0, j));
            }
            return sum;
        }
    }

    public static Complex algebraicComplement(Matrix matrix, int iRow, int jCol){
        Complex[][] resTable = new Complex[matrix.row-1][matrix.col-1];
        for(int i=0; i<matrix.row-1; i++){
            for(int j=0; j<matrix.col-1; j++){
                resTable[i][j] = matrix.table[i+((i>=iRow)?(1):(0))][j+((j>=jCol)?(1):(0))];
            }
        }
        Matrix minor = new Matrix(matrix.row-1, matrix.col-1);
        minor.table = resTable;
        if((iRow+jCol)%2==0){
            return Complex.mul(minor.det(), matrix.table[iRow][jCol]);
        }else {
            return Complex.mul(Complex.mul(minor.det(), Complex.MINUS_ONE), matrix.table[iRow][jCol]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                stringBuilder.append(String.format("%15s", table[i][j]));
            }
            stringBuilder.append("\n");
        }
        stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
        return stringBuilder.toString();
    }
}
