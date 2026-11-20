 
import java.util.Scanner;

public class Metodos {
    Validaciones V = new Validaciones();
    GestionPrestamos G = new GestionPrestamos(this);

    public int SubMenuAlmacenamiento(Scanner sc) {
        System.out.println("Seleccione su Almacenamiento");
        System.out.println("1: 256 GB");
        System.out.println("2: 512 GB");
        System.out.println("3: 1 TB");
        int opt = V.PedirEnteroRango(sc, "Almacenamiento", 1, 3);
        return opt;
    }

    public int SubMenuSistemOperativo(Scanner sc) {
        System.out.println("Seleccione su Sistema Operativo");
        System.out.println("1: Windows 7");
        System.out.println("2: Windows 10");
        System.out.println("3: Windows 11");
        int opt = V.PedirEnteroRango(sc, "", 1, 3);
        return opt;
    }

    public int SubMenuProcesador(Scanner sc) {
        System.out.println("Seleccione su tipo de procesador");
        System.out.println("1: AMD Ryzen");
        System.out.println("2: Intel core i5");
        int opt = V.PedirEnteroRango(sc, "", 1, 2);
        return opt;
    }

    public boolean SubMenuEstuInge(Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("Que deseas Realizar");
            System.out.println("1: Registrar préstamo");
            System.out.println("2: Modificar préstamo (por serial o cédula)");
            System.out.println("3: Devolución de equipo");
            System.out.println("4: Buscar equipo");
            System.out.println("5: Volver al menú principal");
            int opt = V.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    G.RegistrarPrestamoIngenieria(sc);
                    break;
                case 2:
                    G.ModificarPrestamoIngenieria(sc);
                    break;
                case 3:
                    G.DevolverEquipoIngenieria(sc);
                    break;
                case 4:

                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Esta opcion no existe");
                    break;
            }
        }
        return true;
    }

    public boolean SubMenuEstuDiseño(Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("Que deseas Realizar");
            System.out.println("1: Registrar préstamo");
            System.out.println("2: Modificar préstamo (por serial o cédula)");
            System.out.println("3: Devolución de equipo");
            System.out.println("4: Buscar equipo");
            System.out.println("5: Volver al menú principal");
            int opt = V.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    G.RegistrarPrestamoDiseno(sc);
                    break;
                case 2:
                    G.ModificarPrestamoDiseno(sc);
                    break;
                case 3:
                    G.DevolverEquipoDiseno(sc);
                    break;
                case 4:

                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Esta opcion no existe");
                    break;
            }
        }
        return true;
    }

    /** Opción 3 del menú principal: imprime los cuatro vectores. */
    public boolean ImprimirInventarioTotal() {
        G.ImprimirIngenieros();
        System.out.println("=================");
        G.ImprimirDisenadores();
        System.out.println("=================");
        G.ImprimirPortatiles();
        System.out.println("=================");
        G.ImprimirTabletas();

        return true;
    }
}
