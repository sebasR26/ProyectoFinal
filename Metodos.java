
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

    public boolean BuscarEquipo(Scanner sc) {
        Validaciones V = new Validaciones();
        System.out.println("aqui:");
        String serial = V.PedirLetras(sc, "Ingrese el serial del equipo");
        if (serial.isEmpty()) {
            System.out.println("Error: no hay registros de serial.");
            return false;
        } else {
            for (EstudianteIngenieria e : G.getIngenieros()) {
                if (e.getSerialEquipo().equals(serial)) {
                    System.out.println("Equipo encontrado en la lista de estudiantes de Ingeniería:");
                    System.out.println(e);
                    for (ComputadorPortatil p : G.getPortatil()) {
                        if (p.getSerial().equals(serial)) {
                            System.out.println("Equipo encontrado en la lista de portátiles:");
                            System.out.println(p.getSerial());
                            System.out.println(p.getMarca());
                            System.out.println(p.getPrecio());
                            System.out.println(p.getProcesador());
                            System.out.println(p.getSistemaOperativo());
                            System.out.println(p.getTamañopulgadas());
                            System.out.println("================================");

                            return true;
                        }
                    }
                    for (TabletaGrafica t : G.getTableta()) {
                        if (t.getSerial().equals(serial)) {
                            System.out.println("Equipo encontrado en la lista de tabletas gráficas:");
                            System.out.println(t.getSerial());
                            System.out.println(t.getMarca());
                            System.out.println(t.getPrecio());
                            System.out.println(t.getTamañoPulgadas());
                            System.out.println(t.getPesoKg());
                            System.out.println(t.getAlmacenamiento());
                            System.out.println("================================");
                            return true;
                        }
                    }
                    return true;
                }
            }
            for (studianteDiseno e : G.getDisenadores()) {
                if (e.getSerialEquipo().equals(serial)) {
                    System.out.println("Equipo encontrado en la lista de estudiantes de Diseño:");
                    System.out.println(e);
                    for (ComputadorPortatil p : G.getPortatil()) {
                        if (p.getSerial().equals(serial)) {
                            System.out.println("Equipo encontrado en la lista de portátiles:");
                            System.out.println(p.getSerial());
                            System.out.println(p.getMarca());
                            System.out.println(p.getPrecio());
                            System.out.println(p.getProcesador());
                            System.out.println("sistema operativo: " + NombreSO(p.getSistemaOperativo()) + "\n");
                            System.out.println(p.getTamañopulgadas());
                            System.out.println("================================");
                            return true;
                        }
                    }
                    for (TabletaGrafica t : G.getTableta()) {
                        if (t.getSerial().equals(serial)) {
                            System.out.println("Equipo encontrado en la lista de tabletas gráficas:");
                            System.out.println(t.getSerial());
                            System.out.println(t.getMarca());
                            System.out.println(t.getPrecio());
                            System.out.println(t.getTamañoPulgadas());
                            System.out.println(t.getPesoKg());
                            System.out.println(t.getAlmacenamiento());
                            System.out.println("================================");
                            return true;
                        }
                    }
                    return true;
                }
            }
            System.out.println("No se encontró el equipo con serial: " + serial);
            return false;
        }

    }

    public boolean ExportarInventario() {
        ExportarArchivo x = new ExportarArchivo();
        return x.ExportarInventarioTotal(G.getIngenieros(), G.getDisenadores(), G.getPortatil(), G.getTableta());
    }
}
