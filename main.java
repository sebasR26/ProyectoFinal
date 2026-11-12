import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Metodos M = new Metodos();
        Validaciones V = new Validaciones();
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            System.out.println("1: Estudiantes de Ingeniería");
            System.out.println("2: Estudiantes de Diseño");
            System.out.println("3: Imprimir inventario total");
            System.out.println("4: Salir del programa");

            int opt = V.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    M.SubMenuEstuInge(sc);

                    break;
                case 2:
                    M.SubMenuEstuDiseño(sc);

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Hasta luego");
                    cont = false;
                    break;

                default:
                    System.out.println("esta opcion no existe");
                    break;
            }
        }
    }
}
