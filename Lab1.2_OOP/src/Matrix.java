import java.util.Random;

public class Matrix {

    int n;
    int m;
    double[][] thisMatrix;

    public Matrix(int n, int m) {
        this.thisMatrix = new double[n][m];
        this.n = n;
        this.m = m;
        this.initiliser();

    }

    public Matrix(double[][] thisMatrix) {
        this.thisMatrix = thisMatrix;
        this.n = thisMatrix.length;
        this.m = thisMatrix[0].length;
    }

    private void initiliser() {

        Random random = new Random();
        for (int i = 0; i < thisMatrix.length; i++) {
            for (int j = 0; j < thisMatrix[i].length; j++) {
                thisMatrix[i][j] = random.nextInt(100);
            }
        }
    }


    public void getvalue() {
        for (int i = 0; i < thisMatrix.length; i++) {
            for (int j = 0; j < thisMatrix[i].length; j++) {
                System.out.printf("%.2f  ", thisMatrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    public Matrix numberMultiplication(double inputNumber){
        double[][] resultMatrix = new double[this.n][this.m];

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                double result = this.thisMatrix[i][j] * inputNumber;
                resultMatrix[i][j] = result;
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix transpose() {

        double[][] resultMatrix = new double[this.m][this.n];
        for (int i = 0; i < this.n; i++)
            for (int j = 0; j < this.m; j++)
                resultMatrix[j][i] = thisMatrix[i][j];
        return new Matrix(resultMatrix);
    }

    public Matrix exponentiation(int N) {

        if (this.n != this.m) {
            System.out.println("Необходима квадратная матрица для ее возведения в степень!");
            return null;
        }

        Matrix newMatrix = this;
        Matrix currentMatrix = this;

        int currentN = 1;
        while (currentN < N) {
            CalculatorMatrix obj = new CalculatorMatrix(newMatrix, currentMatrix);
            newMatrix = obj.composition();
            currentN++;
        }
        return newMatrix;
    }
}

