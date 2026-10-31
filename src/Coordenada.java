public class Coordenada {
    private int renglon;
    private int columna;

    public Coordenada(int renglon, int columna) {
        this.renglon = renglon;
        this.columna = columna;
    }

    public int getRenglon() {
        return renglon;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordenada that = (Coordenada) obj;
        return renglon == that.renglon && columna == that.columna;
    }
}