import java.sql.SQLOutput;

public class App 
{
    Tablero tablero;

    public App(){
        tablero = new Tablero();
    }
    public static void main( String[] args )
    {
        App app = new App();
        app.Inicio();
        app.Turnos();
        app.tablero.mostrarGanador();
    }

    public void Inicio(){
        System.out.println("Bienvenido al juego '4 EN LINEA'");
        System.out.println("El juego sera por turnos, el objetivo es poner 4 fichas consecutivas");
        System.out.println("ya sea de manera horizontal, vertical o diagonal.");
    }

    public void Turnos(){
        tablero.mostrarTablero();
        boolean var = true;
        while(var) {
            tablero.cargarFicha(1);
            if (tablero.VerificarRaya()) {
                var = false;
                break; // Salir del bucle si hay un ganador
            }

            tablero.cargarFicha(2);
            if (tablero.VerificarRaya()) {
                var = false;
                break; // Salir del bucle si hay un ganador
            }
        }
    }

}
