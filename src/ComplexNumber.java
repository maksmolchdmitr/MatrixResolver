public class ComplexNumber {
    private final double a;
    private final double b;

    public final static ComplexNumber ZERO = new ComplexNumber(0, 0);
    public final static ComplexNumber MINUS_ONE = new ComplexNumber(-1, 0);
    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNumber add(ComplexNumber anotherComplexNumber){
        return new ComplexNumber(this.a + anotherComplexNumber.a, this.b + anotherComplexNumber.b);
    }
    public static ComplexNumber sum(ComplexNumber x, ComplexNumber y){
        return new ComplexNumber(x.a+y.a, x.b+y.b);
    }

    public static ComplexNumber sub(ComplexNumber x, ComplexNumber y){
        return new ComplexNumber(x.a-y.a, x.b-y.b);
    }

    public static ComplexNumber mul(ComplexNumber x, ComplexNumber y){
        return new ComplexNumber(x.a*y.a-x.b*y.b, x.a*y.b+x.b*y.a);
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
        return a+"+"+b+"i";
    }
}
