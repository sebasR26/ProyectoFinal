import java.util.Scanner;

public class Validaciones {

    public boolean ValidarTexto(String texto) {
        // ^[a-zA-Z0-9 ]*$ permite solo letras y números
        return texto != null && texto.matches("^[a-zA-Z0-9 ]*$");
    }

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingrese un digito numerico");
            sc.next();
        }
        return sc.nextInt();
    }

    public Double ValidarDecimal(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Por favor Ingrese un digito nuerico");
            sc.next();
        }
        return sc.nextDouble();
    }

}
