import java.util.Scanner;

public class Validaciones {

    public boolean ValidarLetras(String texto) {
        // ^[a-zA-Z0-9 ]*$ permite solo letras y números
        return texto != null && texto.matches("^[a-zA-Z ]*$");
    }

    // Letras y números sin espacios
    public boolean ValidarSerial(String texto) {
        return texto != null && texto.matches("^[a-zA-Z0-9]+$");
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
            System.out.println("Por favor Ingrese un digito nuerico: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    public boolean ValidarSoloNumeros(String texto) {
        return texto != null && texto.matches("^[0-9]+$");
    }

    public String PedirLetras(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        String texto = (sc.next() + sc.nextLine()).trim();
        if (ValidarLetras(texto)) {
            return texto;
        }
        System.out.println("Error: solo se permiten letras (sin numeros ni caracteres especiales).");
        return PedirLetras(sc, mensaje);
    }

    public String PedirNumerico(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        String texto = sc.next();
        if (ValidarSoloNumeros(texto)) {
            return texto;
        }
        System.out.println("Error: solo se permiten digitos.");
        return PedirNumerico(sc, mensaje);
    }

    public String PedirSerial(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        sc.nextLine().trim();
        String texto = sc.nextLine().trim();
        if (ValidarSerial(texto)) {
            return texto;
        }
        System.out.println("Error: el serial solo puede tener letras y numeros, sin espacios.");
        return PedirSerial(sc, mensaje);
    }

    public int PedirEnteroRango(Scanner sc, String mensaje, int min, int max) {
        System.out.println(mensaje);
        String texto = sc.next();
        try {
            int valor = Integer.parseInt(texto);
            if (valor >= min && valor <= max) {
                return valor;
            }
        } catch (NumberFormatException e) {
            // cae al mensaje de error
        }
        System.out.println("Error: ingrese un numero entero entre " + min + " y " + max + ".");
        return PedirEnteroRango(sc, mensaje, min, max);
    }

    public float PedirDecimalRango(Scanner sc, String mensaje, float min, float max) {
        System.out.println(mensaje);
        String texto = sc.next().replace(',', '.');
        try {
            float valor = Float.parseFloat(texto);
            if (valor >= min && valor <= max) {
                return valor;
            }
        } catch (NumberFormatException e) {
            // cae al mensaje de error
        }
        System.out.println("Error: ingrese un numero decimal entre " + min + " y " + max + ".");
        return PedirDecimalRango(sc, mensaje, min, max);
    }
}
