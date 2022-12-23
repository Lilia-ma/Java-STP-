public class Task3 {
    public static void main() {
        System.out.println(Task3(0,10,f(0.0),f(10.0),0.00000001));
    }
    public static double f(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double Task3(double a, double b, double fa, double fb, double eps) {
        double c = 0.5 * (a + b);
        if (Math.abs(a - b) < eps) return c;
        double fc = f(c);
        if (Math.abs(fc) < eps) return c;
        if (fc * fa < 0)
            return Task3(a, c, fa, fc, eps);
        else
            return Task3(c, b, fc, fb, eps);
    }

}
