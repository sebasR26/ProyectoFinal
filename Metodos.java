 
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
        int opt = V.PedirEnteroRango(sc, "Sistema Operativo", 1, 3);
        return opt;
    }

    public int SubMenuProcesador(Scanner sc) {
        System.out.println("Seleccione su tipo de procesador");
        System.out.println("1: AMD Ryzen");
        System.out.println("2: Intel core i5");
        int opt = V.PedirEnteroRango(sc, "Procesador", 1, 2);
        return opt;
    }

    public boolean SubMenuEstuInge(Scanner sc, Metodos M) {
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
                    M.BuscarEquipo(sc);
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

    public boolean SubMenuEstuDiseño(Scanner sc, Metodos M) {
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
                    M.BuscarEquipo(sc);

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

    private boolean MostrarEquipo(String serial) {
    for (ComputadorPortatil p : G.getPortatil()) {
        if (p.getSerial().equalsIgnoreCase(serial)) {
            System.out.println("Equipo encontrado en la lista de portátiles:");
            System.out.println("Serial: " + p.getSerial());
            System.out.println("Marca: " + p.getMarca());
            System.out.println("Precio: " + p.getPrecio());
            System.out.println("Tamaño: " + p.getTamañopulgadas());
            System.out.println("Sistema operativo: " + NombreSO(p.getSistemaOperativo()));
            System.out.println("Procesador: " + NombreProcesador(p.getProcesador()));
            System.out.println("================================");
            return true;
        }
    }
    for (TabletaGrafica t : G.getTableta()) {
        if (t.getSerial().equalsIgnoreCase(serial)) {
            System.out.println("Equipo encontrado en la lista de tabletas gráficas:");
            System.out.println("Serial: " + t.getSerial());
            System.out.println("Marca: " + t.getMarca());
            System.out.println("Precio: " + t.getPrecio());
            System.out.println("Tamaño: " + t.getTamañoPulgadas());
            System.out.println("Peso: " + t.getPesoKg());
            System.out.println("Almacenamiento: " + t.getAlmacenamiento());
            System.out.println("================================");
            return true;
        }
    }
    return false;
}

private String NombreProcesador(int procesador) {
    switch (procesador) {
        case 1:
            return "AMD Ryzen";
        case 2:
            return "Intel core i5";
        default:
            return "Desconocido";
    }
}

private String NombreSO(int sistemaOperativo) {
    switch (sistemaOperativo) {
        case 1:
            return "Windows 7";
        case 2:
            return "Windows 10";
        case 3:
            return "Windows 11";
        default:
            return "Desconocido";
    }
}

public boolean BuscarEquipo(Scanner sc) {
    String serial = V.PedirSerial(sc, "Ingrese el serial del equipo");

    for (EstudianteIngenieria e : G.getIngenieros()) {
        if (e.getSerialEquipo().equalsIgnoreCase(serial)) {
            System.out.println("Equipo encontrado en la lista de estudiantes de Ingeniería:");
            System.out.println("Cedula: " + e.getCedula() + " - " + e.getNombre() + " " + e.getApellido());
            MostrarEquipo(serial);
            return true;
        }
    }
    for (studianteDiseno e : G.getDisenadores()) {
        if (String.valueOf(e.getSerialEquipo()).equals(serial)) {
            System.out.println("Equipo encontrado en la lista de estudiantes de Diseño:");
            System.out.println("Cedula: " + e.getCedula() + " - " + e.getNombre() + " " + e.getApellido());
            MostrarEquipo(serial);
            return true;
        }
    }
    System.out.println("No se encontró el equipo con serial: " + serial);
    return false;
}

    public boolean ExportarInventario() {
        ExportarArchivo x = new ExportarArchivo();
        return x.ExportarInventarioTotal(G.getIngenieros(), G.getDisenadores(), G.getPortatil(), G.getTableta());
    }
}
