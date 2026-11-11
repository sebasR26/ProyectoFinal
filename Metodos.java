import java.util.Scanner;

public class Metodos {
    Metodos M = new Metodos();
    Validaciones V = new Validaciones();

    /*
     * Método con submenú para almacenamiento:
     * 256 GB
     * 512 GB
     * 1 TB
     */
    public int SubMenuAlmacenamiento(Scanner sc) {
        System.out.println("Seleccione su Almacenamiento");
        System.out.println("1: 256 GB");
        System.out.println("2: 512 GB");
        System.out.println("3: 1 TB");
        int opt = V.ValidarEntero(sc);
        return opt;
    }

    /*
     * Submenú para Sistema Operativo:
     * Windows 7
     * Windows 10
     * Windows 11
     */
    public int SubMenuSistemOperativo(Scanner sc) {
        System.out.println("Seleccione su Sistema Operativo");
        System.out.println("1: Windows 7");
        System.out.println("2: Windows 10");
        System.out.println("3: Windows 11");
        int opt = V.ValidarEntero(sc);
        return opt;
    }

    /*
     * 
     * Submenú para Procesador:
     * AMD Ryzen
     * Intel Core i5
     */
    public int SubMenuProcesador(Scanner sc) {
        System.out.println("Seleccione su tipo de procesador");
        System.out.println("1: AMD Ryzen");
        System.out.println("2: Intel core i5");
        int opt = V.ValidarEntero(sc);
        return opt;
    }

    /*
     * Los datos se validan correctamente según su tipo.
     * No se permiten caracteres especiales ni números en campos de texto (marca,
     * serial, etc.).
     */
    public int SubMenuEstuInge(Scanner sc) {
        System.out.println("Que deseas Realizar");
        System.out.println("1: Registrar préstamo");
        System.out.println("2: Modificar préstamo (por serial o cédula)");
        System.out.println("3: Devolución de equipo");
        System.out.println("4: Buscar equipo");
        System.out.println("5: Volver al menú principal");
        int opt = V.ValidarEntero(sc);
        return opt;
    }

    public int SubMenuEstuDiseño(Scanner sc) {
        System.out.println("Que deseas Realizar");
        System.out.println("1: Registrar préstamo");
        System.out.println("2: Modificar préstamo (por serial o cédula)");
        System.out.println("3: Devolución de equipo");
        System.out.println("4: Buscar equipo");
        System.out.println("5: Volver al menú principal");
        int opt = V.ValidarEntero(sc);
        return opt;
    }

    /*
     * Cada submenú permite:
     * Registrar préstamo
     * Modificar préstamo (por serial o cédula)
     * Devolución de equipo
     * Buscar equipo
     * Volver al menú principal
     * El main solo muestra el menú y llama los métodos correspondientes.
     * El menú permite volver al principal sin cerrar el programa.
     */
}
