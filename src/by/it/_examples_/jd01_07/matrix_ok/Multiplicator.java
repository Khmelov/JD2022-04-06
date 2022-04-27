package by.it._examples_.jd01_07.matrix_ok;

@SuppressWarnings("all")
public class Multiplicator {
    public Matrix multiply(Matrix p, Matrix q) throws MatrixException {
        final int HEIGHT = p.getVerticalSize();
        final int WIDTH = q.getHorizontalSize();
        int temp = p.getHorizontalSize();
        // проверка возможности умножения
        if (temp != q.getVerticalSize()) {
            throw new MatrixException(); // Incompatible matrices
        }
        // создание матрицы результата
        Matrix result = new Matrix(HEIGHT, WIDTH);
        try {
            // умножение
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    int value = 0;
                    for (int k = 0; k < temp; k++) {
                        value += p.getElement(i, k) * q.getElement(k, j);
                    }
                    result.setElement(i, j, value);
                }
            }
        } catch (MatrixException e) {
            // exception невозможен по логике кода,
            // поэтому обработка опущена
            System.out.print(e.toString());
        }
        return result;
    }
}
