import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class SolucionLaberinto {
    private Array2D<String> tablero;
    private int renglones;
    private int columnas;
    private Coordenada inicio;
    private Coordenada fin;

    public SolucionLaberinto(String rutaArchivo) {
        cargarLaberinto(rutaArchivo);
    }

    private void cargarLaberinto(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            if (linea != null) renglones = Integer.parseInt(linea.trim());
            linea = br.readLine();
            if (linea != null) columnas = Integer.parseInt(linea.trim());

            tablero = new Array2D<>(renglones, columnas);

            int r = 0;
            while ((linea = br.readLine()) != null && r < renglones) {
                String[] valores = linea.split(",");
                for (int c = 0; c < columnas && c < valores.length; c++) {
                    String valor = valores[c].trim();
                    tablero.setItem(r, c, valor);
                    if (valor.equals("S")) {
                        inicio = new Coordenada(r, c);
                    } else if (valor.equals("E")) {
                        fin = new Coordenada(r, c);
                    }
                }
                r++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo del laberinto: " + e.getMessage());
        }
    }

    public boolean resolver() {
        Stack<Coordenada> pila = new Stack<>();
        boolean[][] visitados = new boolean[renglones][columnas];

        pila.push(inicio);
        visitados[inicio.getRenglon()][inicio.getColumna()] = true;

        int[] dRenglon = {-1, 0, 1, 0};
        int[] dColumna = {0, 1, 0, -1};

        while (!pila.isEmpty()) {
            Coordenada actual = pila.peek();

            if (actual.equals(fin)) {
                System.out.println("¡Camino encontrado con éxito!");
                imprimirCamino(pila);
                return true;
            }

            boolean movido = false;

            for (int i = 0; i < 4; i++) {
                int nuevoR = actual.getRenglon() + dRenglon[i];
                int nuevoC = actual.getColumna() + dColumna[i];

                if (nuevoR >= 0 && nuevoR < renglones && nuevoC >= 0 && nuevoC < columnas) {
                    String celda = tablero.getItem(nuevoR, nuevoC);
                    if ((celda.equals("0") || celda.equals("E")) && !visitados[nuevoR][nuevoC]) {
                        visitados[nuevoR][nuevoC] = true;
                        pila.push(new Coordenada(nuevoR, nuevoC));
                        movido = true;
                        break;
                    }
                }
            }

            if (!movido) {
                pila.pop();
            }
        }

        System.out.println("El laberinto no tiene solución.");
        return false;
    }

    private void imprimirCamino(Stack<Coordenada> camino) {
        System.out.println("Secuencia de coordenadas del recorrido:");
        for (Coordenada c : camino) {
            System.out.println("-> [" + c.getRenglon() + ", " + c.getColumna() + "]");
        }
    }

    public void imprimirTablero() {
        for (int r = 0; r < renglones; r++) {
            for (int c = 0; c < columnas; c++) {
                System.out.print(tablero.getItem(r, c) + " ");
            }
            System.out.println();
        }
    }
}