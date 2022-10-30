import Task3.*;

public class Main {

    public static void Matrix() {

        Matrix mat1 = new Matrix(3, 5);
        Matrix mat2 = new Matrix(3, 5);

        System.out.println("Матрица А:");
        mat1.getvalue();

        System.out.println("\nМатрица B:");
        mat2.getvalue();

        //Умножение матрицы на число
        double multiNumber = 4.2;
        System.out.println(multiNumber);
        Matrix result = mat1.numberMultiplication(multiNumber);
        if (result != null)
            result.getvalue();

        //Сумма
        CalculatorMatrix executerObj = new CalculatorMatrix(mat1, mat2);
        result = executerObj.summ();
        if (result != null)
            result.getvalue();

        //Разность
        result = executerObj.difference();
        if (result != null)
            result.getvalue();

        //Транспонированная матрца A
        Matrix transposed_mat1 = mat1.transpose();
        transposed_mat1.getvalue();

        //Транспонированная матрца B
        Matrix transposed_mat2 = mat2.transpose();
        transposed_mat2.getvalue();


        Matrix mat3 = new Matrix(2, 3);
        Matrix mat4 = new Matrix(3, 2);

        System.out.println("\nМатрица C:");
        mat3.getvalue();

        System.out.println("\nМатрица D:");
        mat4.getvalue();

        //Произведение матриц
        executerObj = new CalculatorMatrix(mat3, mat4);
        result = executerObj.composition();
        if (result != null)
            result.getvalue();

        //Возведение в степень
        int i = 2;
        Matrix mat5 = new Matrix(2, 2);
        System.out.println("\nМатрица E:");
        mat5.getvalue();
        System.out.println("\nМатрица E в степень " + i);
        result = mat5.exponentiation(i);
        if (result != null)
            result.getvalue();
    }

    public static void Vector() {
        Vector[] vectors = Vector.generator(10);
        for (int i = 0; i < vectors.length; i++) {
            vectors[i].value();
        }

        Vector vector1 = new Vector(2, 5, 5);
        Vector vector2 = new Vector(10, 25, 2);
        System.out.println("\nВектор 1");
        vector1.value();
        System.out.println("\nВектор 2");
        vector2.value();

        System.out.println("\nДлина вектора 1: " + vector1.length());
        System.out.println("Длина вектора 2: " + vector2.length());
        System.out.println("Скалярное произведение вектора: " + vector1.scalarProduct(vector2));
        System.out.println("Векторное произведение вектора:");
        vector1.CrossProduct(vector2).value();

        System.out.println("Угол между векторами: " + vector1.VectorCor(vector2));
        System.out.println("Сумма векторов:");
        vector1.summ(vector2).value();
        System.out.println("Разность векторов:");
        vector1.difference(vector2).value();
    }

    public static void Task3() {
        Box box = new Box();
        box.setVolume(100.5);

        Ball ball1 = new Ball();
        ball1.setVolume(33.5);


        System.out.println("\nОбъём коробки: " + box.getVolume());
        boolean result = box.add(ball1);
        System.out.println("Флаг добавления объекта: " + result);
        System.out.println("Объём коробки: " + box.getVolume());

        SolidOfRevolution obj = new SolidOfRevolution();
        obj.setVolume(435);
        System.out.println("\nОбъём коробки: " + box.getVolume());
        result = box.add(obj);
        System.out.println("Флаг добавления объекта: " + result);
        System.out.println("Объём коробки: " + box.getVolume());
    }

    public static void Construction() {
        int[] values = {1, 2, 3};
        int[] scales = {1, 2, 10};

        Construction returner = new Construction(values, scales);
        int returnValue = returner.getNumber();
        System.out.println("Возвращенное значение: " + returnValue);
    }

    public static void main(String[] args) {
        Matrix();
        Vector();
        Task3();
        Construction();


    }
}
