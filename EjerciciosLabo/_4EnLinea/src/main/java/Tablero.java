package src.main.java;

import java.util.Scanner;

public class Tablero {
    private char[][] celdas;
    private Scanner scanner;
    private boolean Raya;
    private char Ganador;

    public Tablero(){
        celdas = new char[7][7];
        Raya = false;
        Ganador = 0;
        inicializarTablero();
        this.scanner = new Scanner(System.in);
    }

    private void inicializarTablero() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                celdas[i][j] = '-';
            }
        }
    }

    public void mostrarTablero() {
        // Mostrar el tablero en la consola
        System.out.println("---TABLERO---");
        System.out.println("X: Fichas Jugador 1");
        System.out.println("Y: Fichas Jugador 2");
        System.out.println("-: Celdas varias");
        System.out.println("1 2 3 4 5 6 7");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(celdas[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void cargarFicha(int jugador) {
        char ficha;
        if(jugador == 1){
            ficha = 88; // VALOR X EN ASCII;
        }else{
            ficha = 89; // VALOR Y EN ASCII
        }

        mostrarTablero();
        System.out.println("Jugador " + ficha +" elija la columna :");
        int columna = scanner.nextInt() - 1;
        int fila = 0;

        // Conseguir la fila, buscando el valor mas abajo de la columna
        for(int i = 6; i >= 0; i--){

            if(celdas[i][columna] == 45) /* 45 = - en codigo ASCII */ {
                fila = i;
                break;
            }
        }


        int[][] coor = {{fila, columna}};

        for (int[] coord : coor) {
            celdas[coord[0]][coord[1]] = ficha;
        }

    }


    public boolean VerificarRaya() {

        boolean v = false;
        if(verificarHorizontal()){
            v = true;
        }else if(verificarVertical()){
            v = true;
        }
        else if(verificarDiagonal()){
            v = true;
        }
        return v;
    }

    private boolean verificarVertical() {
        char ultimo;
        int contador;

        for (int i = 0; i < 7; i++) {
            ultimo = 0;
            contador = 1;
            for (int j = 0; j < 7; j++) {
                if(ultimo == celdas[j][i] && ultimo != 45){
                    contador++;
                    if(contador == 4){
                        Ganador = ultimo;
                        return true;
                    }
                }else{
                    contador = 1;
                }
                ultimo = celdas[j][i];
            }
        }

        return false;
    }

    private boolean verificarHorizontal() {
        char ultimo;
        int contador;

        for (int i = 0; i < 7; i++) {
            ultimo = 0;
            contador = 1;
            for (int j = 0; j < 7; j++) {
                if(ultimo == celdas[i][j] && ultimo != 45){
                    contador++;
                    if(contador == 4){
                        Ganador = ultimo;
                        return true;
                    }
                }else{
                    contador = 1;
                }
                ultimo = celdas[i][j];
            }
        }

        return false;
    }

    private boolean verificarDiagonal() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // hago unicamente hasta el valor 4, xq si es mas grande que ese se iria de la matriz
                char c1 = celdas[i][j];
                char c2 = celdas[i + 1][j + 1];
                char c3 = celdas[i + 2][j + 2];
                char c4 = celdas[i + 3][j + 3];

                if (c1 == c2 && c2 == c3 && c3 == c4 && c1 != '-') {
                    return true;
                }

                char c5 = '-';
                char c6 = '-';
                char c7 = '-';

                if (j >= 3) {
                    c5 = celdas[i + 1][j - 1];
                    c6 = celdas[i + 2][j - 2];
                    c7 = celdas[i + 3][j - 3];
                }

                if (c1 == c5 && c1 == c6 && c1 == c7 && c1 != '-') {
                    return true;
                }
            }
        }
        return false;
    }


    public void mostrarGanador(){
        System.out.println("El ganador es: " + Ganador);
        System.out.println("Este es el tablero:");
        mostrarTablero();
    }

}
