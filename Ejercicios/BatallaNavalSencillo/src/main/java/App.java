import javax.xml.stream.events.EntityReference;

public class App {
    private Tablero t1;
    private Tablero t2;

    public App() {
        t1 = new Tablero();
        t2 = new Tablero();
    }

    public static void main(String[] args) {
        App app = new App();
        app.cargarBarcos();
        app.turnosDisparo();

    }

    public void turnosDisparo(){
        while(t1.VerificarTablero() && t2.VerificarTablero()){
            System.out.println("TURNO JUGADOR 1");
            t1.mostrarTableroAliado();
            t1.Disparo(t2);

            System.out.println("TURNO JUGADOR 2");
            t2.mostrarTableroAliado();
            t2.Disparo(t1);
        }
    }

    private void cargarBarcos() {
        System.out.println("---JUGADOR 1---");
        t1.cargarBarco();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---JUGADOR 2---");
        t2.cargarBarco();
    }
}
