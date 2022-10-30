public class CalculatorMatrix {

    Matrix matrix1;
    Matrix matrix2;

    public CalculatorMatrix(Matrix mat1, Matrix mat2) {
        this.matrix1 = mat1;
        this.matrix2 = mat2;
    }

    public Matrix composition() {

        if (matrix1.m != matrix2.n) {
            System.out.println("Количество столбцов матрицы должно быть равно количеству строк");
            return null;
        }
        double[][] resultMatrix = new double[matrix1.n][matrix2.m];

        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix2.m; j++) {
                for (int k = 0; k < matrix1.m; k++) {
                    resultMatrix[i][j] += matrix1.thisMatrix[i][k] * matrix2.thisMatrix[k][j];
                }
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix summ() {
        if ((matrix1.n != matrix2.n) || (matrix1.m != matrix2.m)) {
            System.out.println("Неправильная размерность матрицы");
            return null;
        } else {

            double[][] resultMatrix = new double[matrix1.n][matrix1.m];

            for (int i = 0; i < matrix1.n; i++) {
                for (int j = 0; j < matrix1.m; j++) {
                    double result = matrix1.thisMatrix[i][j] + matrix2.thisMatrix[i][j];
                    resultMatrix[i][j] = result;
                }
            }
            return new Matrix(resultMatrix);
        }
    }

    public Matrix difference() {
        if ((matrix1.n != matrix2.n) || (matrix1.m != matrix2.m)) {
            System.out.println("Неправильная размерность матрицы");
            return null;
        } else {

            double[][] resultMatrix = new double[matrix1.n][matrix1.m];

            for (int i = 0; i < matrix1.n; i++) {
                for (int j = 0; j < matrix1.m; j++) {
                    double result = matrix1.thisMatrix[i][j] - matrix2.thisMatrix[i][j];
                    resultMatrix[i][j] = result;
                }
            }

            return new Matrix(resultMatrix);
        }
    }
}
