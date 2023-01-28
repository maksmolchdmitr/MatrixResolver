package numbers;

public class Complex {
    private final double a;
    private final double b;

    public final static Complex ZERO = new Complex(0, 0);
    public final static Complex MINUS_ONE = new Complex(-1, 0);
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public Complex(double a){
        this.a = a;
        this.b = 0;
    }

    public Complex add(Complex anotherComplexNumber){
        return sum(this, anotherComplexNumber);
    }
    public static Complex sum(Complex x, Complex y){
        return new Complex(x.a+y.a, x.b+y.b);
    }

    public static Complex sub(Complex x, Complex y){
        return new Complex(x.a-y.a, x.b-y.b);
    }

    public static Complex mul(Complex x, Complex y){
        return new Complex(x.a*y.a-x.b*y.b, x.a*y.b+x.b*y.a);
    }

    public String trigonometricForm(){
        double r = Math.sqrt(a*a+b*b);
        double argument;
        if(a>0){
            argument = Math.atan(b/a);
        }else if(a<0){
            if(b>=0){
                argument = Math.PI+Math.atan(b/a);
            }else {
                argument = -Math.PI+Math.atan(b/a);
            }
        }else {
            if(b>0){
                argument = Math.PI/2;
            }else if(b<0){
                argument = -Math.PI/2;
            }else {
                return "Not trigonometric form";
            }
        }
        return String.format("|%f|(cos%f-i*sin%f)", r, argument, argument);
    }

    @Override
    public String toString() {
        return a+((b==0)?(""):("+"+b+"i"));
    }
}
