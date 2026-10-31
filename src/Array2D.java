public class Array2D<T> {
    private int ren;
    private int col;
    private T[][] datos;

    @SuppressWarnings("unchecked")
    public Array2D(int ren, int col) {
        this.ren = ren;
        this.col = col;
        this.datos = (T[][]) new Object[ren][col];
    }

    public void setItem(int ren, int col, T dato) {
        if (ren >= 0 && ren < this.ren && col >= 0 && col < this.col) {
            this.datos[ren][col] = dato;
        }
    }

    public T getItem(int ren, int col) {
        if (ren >= 0 && ren < this.ren && col >= 0 && col < this.col) {
            return this.datos[ren][col];
        }
        return null;
    }

    public int getRen() {
        return ren;
    }

    public int getCol() {
        return col;
    }

    public void limpiar(T dato) {
        for (int i = 0; i < ren; i++) {
            for (int j = 0; j < col; j++) {
                this.datos[i][j] = dato;
            }
        }
    }
}