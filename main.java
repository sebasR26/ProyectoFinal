import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    
        Metodos M = new Metodos();
        Validaciones V = new Validaciones();
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            System.out.println("1: Estudiantes de Ingeniería");
            System.out.println("2: Estudiantes de Diseño");
            System.out.println("3: Imprimir inventario total");
            System.out.println("4: Exportar inventario");
            System.out.println("5: Salir del programa");

            int opt = V.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    M.SubMenuEstuInge(sc, M);

                    break;
                case 2:
                    M.SubMenuEstuDiseño(sc, M);
                    break;
                case 3:
                    M.ImprimirInventarioTotal();

                    break;
                case 4:
                    M.ExportarInventario();
                    break;
                case 5:
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
