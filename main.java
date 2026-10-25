import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Metodos M = new Metodos();
        Validaciones V = new Validaciones();

        int op;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            op = V.validarEntero(sc);

            switch (op) {
                case 1:
                    
                    break;

                case 2:

                    break;

                case 0:
                    System.out.println("Hasta Luego");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (op != 0);

    }

}
