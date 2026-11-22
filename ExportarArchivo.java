import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Clase para exportar datos a archivos de texto.
 */
public class ExportarArchivo {
    private static final String SEPARADOR = "----------------------------------------\n";

    public boolean ExportarIngenieros(LinkedList<EstudianteIngenieria> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes de Ingenieria para exportar.");
            return false;
        }
        try (FileWriter escriba = new FileWriter("Ingenieros.txt")) {
            for (EstudianteIngenieria e : lista) {
                escriba.write("Cedula: " + e.getCedula() + "\n");
                escriba.write("Nombre: " + e.getNombre() + "\n");
                escriba.write("Apellido: " + e.getApellido() + "\n");
                escriba.write("Telefono: " + e.getTelefono() + "\n");
                escriba.write("Semestre: " + e.getNumeroSemestre() + "\n");
                escriba.write("Promedio: " + e.getPromedioAcumulado() + "\n");
                escriba.write("Serial Equipo: " + e.getSerialEquipo() + "\n");
                escriba.write(SEPARADOR);
            }
            System.out.println("Ingenieros exportados correctamente a Ingenieros.txt");
            return true;
        } catch (IOException ex) {
            System.out.println("Error al exportar Ingenieros: " + ex.getMessage());
            return false;
        }
    }

    public boolean ExportarDisenadores(LinkedList<studianteDiseno> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes de Diseno para exportar.");
            return false;
        }
        try (FileWriter escriba = new FileWriter("Disenadores.txt")) {
            for (studianteDiseno e : lista) {
                escriba.write("Cedula: " + e.getCedula() + "\n");
                escriba.write("Nombre: " + e.getNombre() + "\n");
                escriba.write("Apellido: " + e.getApellido() + "\n");
                escriba.write("Telefono: " + e.getTelefono() + "\n");
                escriba.write("Modalidad: " + e.getModalidadEstudio() + "\n");
                escriba.write("Asignaturas: " + e.getCantidadAsignaturas() + "\n");
                escriba.write("Serial Equipo: " + e.getSerialEquipo() + "\n");
                escriba.write(SEPARADOR);
            }
            System.out.println("Disenadores exportados correctamente a Disenadores.txt");
            return true;
        } catch (IOException ex) {
            System.out.println("Error al exportar Disenadores: " + ex.getMessage());
            return false;
        }
    }

    public boolean ExportarPortatiles(LinkedList<ComputadorPortatil> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay computadores portatiles para exportar.");
            return false;
        }
        try (FileWriter escriba = new FileWriter("Portatiles.txt")) {
            for (ComputadorPortatil c : lista) {
                escriba.write("Serial: " + c.getSerial() + "\n");
                escriba.write("Marca: " + c.getMarca() + "\n");
                escriba.write("Tamano: " + c.getTamañopulgadas() + "\n");
                escriba.write("Precio: " + c.getPrecio() + "\n");
                escriba.write("Sistema Operativo: " + NombreSO(c.getSistemaOperativo()) + "\n");
                escriba.write("Procesador: " + NombreProcesador(c.getProcesador()) + "\n");
                escriba.write(SEPARADOR);
            }
            System.out.println("Portatiles exportados correctamente a Portatiles.txt");
            return true;
        } catch (IOException ex) {
            System.out.println("Error al exportar Portatiles: " + ex.getMessage());
            return false;
        }
    }

    public boolean ExportarTabletas(LinkedList<TabletaGrafica> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay tabletas graficas para exportar.");
            return false;
        }
        try (FileWriter escriba = new FileWriter("Tabletas.txt")) {
            for (TabletaGrafica t : lista) {
                escriba.write("Serial: " + t.getSerial() + "\n");
                escriba.write("Marca: " + t.getMarca() + "\n");
                escriba.write("Tamano: " + t.getTamañoPulgadas() + "\n");
                escriba.write("Precio: " + t.getPrecio() + "\n");
                escriba.write("Peso: " + t.getPesoKg() + "\n");
                escriba.write("Almacenamiento: " + t.getAlmacenamiento() + "\n");
                escriba.write(SEPARADOR);
            }
            System.out.println("Tabletas exportadas correctamente a Tabletas.txt");
            return true;
        } catch (IOException ex) {
            System.out.println("Error al exportar Tabletas: " + ex.getMessage());
            return false;
        }
    }

    /** Exporta las cuatro listas de una vez. */
    public boolean ExportarInventarioTotal(LinkedList<EstudianteIngenieria> ingenieros,
            LinkedList<studianteDiseno> disenadores,
            LinkedList<ComputadorPortatil> portatiles,
            LinkedList<TabletaGrafica> tabletas) {
        boolean a = ExportarIngenieros(ingenieros);
        boolean b = ExportarDisenadores(disenadores);
        boolean c = ExportarPortatiles(portatiles);
        boolean d = ExportarTabletas(tabletas);
        return a || b || c || d;
    }

    // En el modelo SO y procesador son int; aqui se escribe el nombre legible
    // (mismos valores que los submenus de Metodos).
    private String NombreSO(int opt) {
        switch (opt) {
            case 1:
                return "Windows 7";
            case 2:
                return "Windows 10";
            default:
                return "Windows 11";
        }
    }

    private String NombreProcesador(int opt) {
        return opt == 1 ? "AMD Ryzen" : "Intel core i5";
    }
/* 
    public void exportarArchivo(LinkedList<EstudianteIngenieria> ingenieros) {
        if (ingenieros.isEmpty()) {
            GestionPrestamos G = new GestionPrestamos();
           
            ingenieros = G.RegistrarPrestamoIngenieria(ingenieros);
        } else {
            try (FileWriter escriba = new FileWriter("EstudiantesIngenieria.txt")) {
                for (EstudianteIngenieria i : ingenieros) {
                    escriba.write("Nombre: " + i.getNombre() + "\n");
                    escriba.write("Apellido: " + i.getApellido() + "\n");
                    escriba.write("Cedula: " + i.getCedula() + "\n");
                    escriba.write("Telefono: " + i.getTelefono() + "\n");
                    escriba.write("Numero Semestre: " + i.getNumeroSemestre() + "\n");
                    escriba.write("Promedio Acumulado: " + i.getPromedioAcumulado() + "\n");
                    escriba.write("Serial Equipo: " + i.getSerialEquipo() + "\n");
                    if (i instanceof tabletagr) {
                        equipo c = (equipo) i;
                        escriba.write("Cantidad Puertas: " + c.getNumeroPuertas() + "\n");
                    } else {
                        Moto m = (Moto) i;
                        escriba.write("Tipo Motor: " + m.getTipoMotor() + "\n");
                    }
                    escriba.write("---------------------------------------\n");
                }

                System.out.println("Archivo exportado correctamente");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }*/
}