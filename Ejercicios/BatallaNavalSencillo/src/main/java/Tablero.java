import java.util.Scanner;

public class Tablero {
    private char[][] celdas;
    private char[][] disparosRecibidos;
    private Barco barco;
    private Scanner scanner;

    private boolean BarcoVivo;
    
    public Tablero(){
        celdas = new char[5][5];
        disparosRecibidos = new char[5][5];
        BarcoVivo = true;
        inicializarTablero();
        this.scanner = new Scanner(System.in);
    }

    private void inicializarTablero() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                celdas[i][j] = '-';
                disparosRecibidos[i][j] = '-';
            }
        }
    }

    public void cargarBarco() {
        System.out.println("Elija las coordenadas de su barco:");
        mostrarTableroAliado();

        System.out.print("Ingrese fila: ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese columna: ");
        int columna = scanner.nextInt();
        int[][] coor = {{fila, columna}};

        barco = new Barco(coor);

        for (int[] coord : coor) {
            celdas[coord[0]][coord[1]] = 'B';
        }

        mostrarTableroAliado();


    }

    public void Disparo(Tablero tEnemigo){
        mostrarTableroEnemigo();
        System.out.println("Elija las coordenadas de su disparo");
        System.out.print("Ingrese fila: ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese columna: ");
        int columna = scanner.nextInt();

        int[][] coor = {{fila, columna}};

        for (int[] coord : coor) {
            tEnemigo.disparosRecibidos[coord[0]][coord[1]] = 'X';
        }

        if (tEnemigo.VerificarBala(coor)) {
            System.out.println("¡Has dado en el barco enemigo!");
        } else {
            System.out.println("¡Has dado en el agua!");
        }
        tEnemigo.VerificarBala(coor);

    }

    public boolean VerificarBala(int[][] bala) {
        int[][] coordenadasBarco = barco.getCoordenadas();
        boolean iguales = true;
        for (int i = 0; i < bala.length; i++) {
            for (int j = 0; j < bala[0].length; j++) {
                if (bala[i][j] != coordenadasBarco[i][j]) {
                    iguales = false; // Los elementos en la misma posición no son iguales
                    return false;
                }
            }
        }
        if (iguales) {
            BarcoVivo = false; // Las matrices son iguales, el barco está golpeado
        }
        return true;
    }


    public boolean VerificarTablero(){
        if(BarcoVivo){
            return true;
        }
        else{
            return false;
        }
    }

    public void mostrarTableroAliado() {
        // Mostrar el tablero en la consola
        System.out.println("---TABLERO---");
        System.out.println("B: Tu Barco");
        System.out.println("X: Balas enemigas");
        System.out.println("-: Celdas varias");
        System.out.println("  0 1 2 3 4");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print(celdas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void mostrarTableroEnemigo(){
        System.out.println("---TABLERO ENEMIGO---");
        System.out.println("X: Tus balas");
        System.out.println("-: Celdas varias");
        System.out.println("  0 1 2 3 4");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print(disparosRecibidos[i][j] + " ");
            }
            System.out.println();
        }
    }
}
