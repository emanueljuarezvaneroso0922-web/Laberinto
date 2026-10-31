public class Main {
    public static void main(String[] args) {
        // Apuntamos al archivo entrada.lab que está dentro de la carpeta src
        String rutaArchivo = "src/entrada.lab";

        System.out.println("=== CARGANDO LABERINTO ===");
        SolucionLaberinto laberinto = new SolucionLaberinto(rutaArchivo);
        laberinto.imprimirTablero();

        System.out.println("\n=== EJECUTANDO BACKTRACKING ===");
        laberinto.resolver();
    }
}