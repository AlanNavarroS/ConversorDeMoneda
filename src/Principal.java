import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaMoneda consulta = new ConsultaMoneda();

        Scanner leerTeclado = new Scanner(System.in);

        System.out.println("Ingrese Cuanto desea cambiar de Pesos a Dolares");

        var cantidadCambiada = Double.valueOf(leerTeclado.nextLine());
        try {
            Moneda moneda = consulta.cantidadMoneda(cantidadCambiada);
            System.out.println("Cantidad ingresada "+cantidadCambiada+" Pesos");
            GeneradorArchivo generador = new GeneradorArchivo();
            generador.guardarJsonMoneda(moneda);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}