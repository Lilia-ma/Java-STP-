import java.util.Random;

public class Vector {
    int x;
    int y;
    int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void value() {
        System.out.format("(%d, %d, %d)%n", x, y, z);
    }

    // Длина вектора
    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    //Скалярное произведение
    public double scalarProduct(Vector vector) {

        return x * vector.x + y * vector.y + z * vector.z;
    }

    //Векторное произведение
    public Vector CrossProduct(Vector vector) {
        int newX = y * vector.z - z * vector.y;
        int newY = z * vector.x - x * vector.z;
        int newZ = x * vector.y - y * vector.x;
        return new Vector(newX, newY, newZ);
    }

    // Угол между векторами
    public double VectorCor(Vector vector) {
        double numerator = scalarProduct(vector);
        double denominator = Math.abs(length()) * Math.abs(vector.length());
        return numerator / denominator;

    }

    //Сумма
    public Vector summ(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    //Разность
    public Vector difference(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    // Метод, который принимающий целое число, и возвращающий массив случайных векторов
    public static Vector[] generator(int N) {
        Vector vectorsArr[];
        vectorsArr = new Vector[N];
        for (int i = 0; i < N; i++) {
            Random rand = new Random();
            int randomx = rand.nextInt(100);
            int randomy = rand.nextInt(100);
            int randomz = rand.nextInt(100);
            vectorsArr[i] = new Vector(randomx, randomy, randomz);
        }

        return vectorsArr;
    }

}
