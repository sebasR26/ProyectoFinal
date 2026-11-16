import java.util.LinkedList;
import java.util.Scanner;

public class GestionPrestamos {

    private LinkedList<EstudianteIngenieria> ingenieros = new LinkedList<>();
    private LinkedList<studianteDiseno> disenadores = new LinkedList<>();
    private LinkedList<ComputadorPortatil> portatil = new LinkedList<>();
    private LinkedList<TabletaGrafica> tableta = new LinkedList<>();
    private Validaciones V = new Validaciones();
    private Metodos M;

    public GestionPrestamos(Metodos m) {
        this.M = m;
    }
    // búsqueda

    public EstudianteIngenieria BuscarIngenieroPorCedula(String cedula) {
        for (EstudianteIngenieria e : ingenieros) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public EstudianteIngenieria BuscarIngenieroPorSerial(String serial) {
        for (EstudianteIngenieria e : ingenieros) {
            if (e.getSerialEquipo().equalsIgnoreCase(serial)) {
                return e;
            }
        }
        return null;
    }

    public studianteDiseno BuscarDisenadorPorCedula(String cedula) {
        for (studianteDiseno e : disenadores) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public studianteDiseno BuscarDisenadorPorSerial(String serial) {
        for (studianteDiseno e : disenadores) {
            if (String.valueOf(e.getSerialEquipo()).equals(serial)) {
                return e;
            }
        }
        return null;
    }

    /** El estudiante ya tiene equipo si su cédula está registrada en cualquiera de las dos listas. */
    public boolean EstudianteTieneEquipo(String cedula) {
        return BuscarIngenieroPorCedula(cedula) != null || BuscarDisenadorPorCedula(cedula) != null;
    }

    private String PedirModalidad(Scanner sc) {
        int opt = V.PedirEnteroRango(sc, "Modalidad de estudio: 1: Virtual, 2: Presencial", 1, 2);
        return opt == 1 ? "Virtual" : "Presencial";
    }

    // registro

    public boolean RegistrarPrestamoIngenieria(Scanner sc) {
        String cedula = V.PedirNumerico(sc, "Ingrese la cedula del estudiante");
        if (EstudianteTieneEquipo(cedula)) {
            System.out.println("Error: el estudiante con cedula " + cedula + " ya tiene un equipo asignado.");
            return false;
        }
        EstudianteIngenieria e = new EstudianteIngenieria();
        e.setCedula(cedula);
        e.setNombre(V.PedirLetras(sc, "Ingrese el nombre"));
        e.setApellido(V.PedirLetras(sc, "Ingrese el apellido"));
        e.setTelefono(V.PedirNumerico(sc, "Ingrese el telefono"));
        e.setNumeroSemestre(V.PedirEnteroRango(sc, "Ingrese el numero de semestre (1-12)", 1, 12));
        e.setPromedioAcumulado(V.PedirDecimalRango(sc, "Ingrese el promedio acumulado (0.0 - 5.0)", 0f, 5f));
        e.setSerialEquipo(V.PedirLetras(sc, "Ingrese el serial del equipo"));
        RegistrarEquipo(sc, e.getSerialEquipo());
        ingenieros.add(e);
        System.out.println("Prestamo registrado correctamente para " + e.getNombre() + " " + e.getApellido() + ".");
        return true;
    }

    public boolean RegistrarPrestamoDiseno(Scanner sc) {
        String cedula = V.PedirNumerico(sc, "Ingrese la cedula del estudiante");
        if (EstudianteTieneEquipo(cedula)) {
            System.out.println("Error: el estudiante con cedula " + cedula + " ya tiene un equipo asignado.");
            return false;
        }
        studianteDiseno e = new studianteDiseno();
        e.setCedula(cedula);
        e.setNombre(V.PedirLetras(sc, "Ingrese el nombre"));
        e.setApellido(V.PedirLetras(sc, "Ingrese el apellido"));
        e.setTelefono(V.PedirNumerico(sc, "Ingrese el telefono"));
        e.setModalidadEstudio(PedirModalidad(sc));
        e.setCantidadAsignaturas(V.PedirEnteroRango(sc, "Ingrese la cantidad de asignaturas (1-12)", 1, 12));
        e.setSerialEquipo(V.PedirEnteroRango(sc, "Ingrese el serial del equipo (numerico)", 1, Integer.MAX_VALUE));
        RegistrarEquipo(sc, String.valueOf(e.getSerialEquipo()));
        disenadores.add(e);
        System.out.println("Prestamo registrado correctamente para " + e.getNombre() + " " + e.getApellido() + ".");
        return true;
    }

    // modificar

   public boolean ModificarPrestamoIngenieria(Scanner sc) {
        int forma = V.PedirEnteroRango(sc, "Buscar por: 1: Cedula, 2: Serial", 1, 2);
        EstudianteIngenieria e;
        if (forma == 1) {
            e = BuscarIngenieroPorCedula(V.PedirNumerico(sc, "Ingrese la cedula"));
        } else {
            e = BuscarIngenieroPorSerial(V.PedirLetras(sc, "Ingrese el serial"));
        }
        if (e == null) {
            System.out.println("Error: no se encontro un prestamo con ese dato.");
            return false;
        }
        System.out.println("Modificando a " + e.getNombre() + " " + e.getApellido()
                + " (la cedula y el serial no se pueden modificar)");
        System.out.println("1: Nombre");
        System.out.println("2: Apellido");
        System.out.println("3: Telefono");
        System.out.println("4: Numero de semestre");
        System.out.println("5: Promedio acumulado");
        System.out.println("6: Cancelar");
        int campo = V.PedirEnteroRango(sc, "Que campo desea modificar", 1, 6);
        switch (campo) {
            case 1:
                e.setNombre(V.PedirLetras(sc, "Ingrese el nuevo nombre"));
                break;
            case 2:
                e.setApellido(V.PedirLetras(sc, "Ingrese el nuevo apellido"));
                break;
            case 3:
                e.setTelefono(V.PedirNumerico(sc, "Ingrese el nuevo telefono"));
                break;
            case 4:
                e.setNumeroSemestre(V.PedirEnteroRango(sc, "Ingrese el nuevo semestre (1-12)", 1, 12));
                break;
            case 5:
                e.setPromedioAcumulado(V.PedirDecimalRango(sc, "Ingrese el nuevo promedio (0.0 - 5.0)", 0f, 5f));
                break;
            default:
                System.out.println("Modificacion cancelada.");
                return false;
        }
        System.out.println("Prestamo modificado correctamente.");
        return true;
    }

    public boolean ModificarPrestamoDiseno(Scanner sc) {
        int forma = V.PedirEnteroRango(sc, "Buscar por: 1: Cedula, 2: Serial", 1, 2);
        studianteDiseno e;
        if (forma == 1) {
            e = BuscarDisenadorPorCedula(V.PedirNumerico(sc, "Ingrese la cedula"));
        } else {
            e = BuscarDisenadorPorSerial(V.PedirNumerico(sc, "Ingrese el serial"));
        }
        if (e == null) {
            System.out.println("Error: no se encontro un prestamo con ese dato.");
            return false;
        }
        System.out.println("Modificando a " + e.getNombre() + " " + e.getApellido()
                + " (la cedula y el serial no se pueden modificar)");
        System.out.println("1: Nombre");
        System.out.println("2: Apellido");
        System.out.println("3: Telefono");
        System.out.println("4: Modalidad de estudio");
        System.out.println("5: Cantidad de asignaturas");
        System.out.println("6: Cancelar");
        int campo = V.PedirEnteroRango(sc, "Que campo desea modificar", 1, 6);
        switch (campo) {
            case 1:
                e.setNombre(V.PedirLetras(sc, "Ingrese el nuevo nombre"));
                break;
            case 2:
                e.setApellido(V.PedirLetras(sc, "Ingrese el nuevo apellido"));
                break;
            case 3:
                e.setTelefono(V.PedirNumerico(sc, "Ingrese el nuevo telefono"));
                break;
            case 4:
                e.setModalidadEstudio(PedirModalidad(sc));
                break;
            case 5:
                e.setCantidadAsignaturas(V.PedirEnteroRango(sc, "Ingrese la nueva cantidad (1-12)", 1, 12));
                break;
            default:
                System.out.println("Modificacion cancelada.");
                return false;
        }
        System.out.println("Prestamo modificado correctamente.");
        return true;
    }
    // devolución

     public boolean DevolverEquipoIngenieria(Scanner sc) {
        int forma = V.PedirEnteroRango(sc, "Devolver por: 1: Cedula, 2: Serial", 1, 2);
        EstudianteIngenieria e;
        if (forma == 1) {
            e = BuscarIngenieroPorCedula(V.PedirNumerico(sc, "Ingrese la cedula"));
        } else {
            e = BuscarIngenieroPorSerial(V.PedirLetras(sc, "Ingrese el serial"));
        }
        if (e == null) {
            System.out.println("Error: no se encontro un prestamo con ese dato.");
            return false;
        }
        EliminarEquipo(e.getSerialEquipo());
        ingenieros.remove(e);
        System.out.println("Devolucion exitosa: se elimino el prestamo de " + e.getNombre() + " " + e.getApellido() + ".");
        return true;
    }

    public boolean DevolverEquipoDiseno(Scanner sc) {
        int forma = V.PedirEnteroRango(sc, "Devolver por: 1: Cedula, 2: Serial", 1, 2);
        studianteDiseno e;
        if (forma == 1) {
            e = BuscarDisenadorPorCedula(V.PedirNumerico(sc, "Ingrese la cedula"));
        } else {
            e = BuscarDisenadorPorSerial(V.PedirNumerico(sc, "Ingrese el serial"));
        }
        if (e == null) {
            System.out.println("Error: no se encontro un prestamo con ese dato.");
            return false;
        }
        EliminarEquipo(String.valueOf(e.getSerialEquipo()));
        disenadores.remove(e);
        System.out.println("Devolucion exitosa: se elimino el prestamo de " + e.getNombre() + " " + e.getApellido() + ".");
        return true;
    }

    /** Agrega al vector portatil o tableta el equipo del estudiante (mismo serial). */
    private boolean RegistrarEquipo(Scanner sc, String serial) {
        int tipo = V.PedirEnteroRango(sc, "Tipo de equipo: 1: Computador portatil, 2: Tableta grafica", 1, 2);
        String marca = V.PedirLetras(sc, "Ingrese la marca");
        float tamano = V.PedirDecimalRango(sc, "Ingrese el tamano en pulgadas", 1f, 100f);
        float precio = V.PedirDecimalRango(sc, "Ingrese el precio", 1f, 100000000f);
        if (tipo == 1) {
            ComputadorPortatil c = new ComputadorPortatil();
            c.setSerial(serial);
            c.setMarca(marca);
            c.setTamañopulgadas(tamano);
            c.setPrecio(precio);
            c.setSistemaOperativo(M.SubMenuSistemOperativo(sc));
            c.setProcesador(M.SubMenuProcesador(sc));
            portatil.add(c);
        } else {
            TabletaGrafica t = new TabletaGrafica();
            t.setSerial(serial);
            t.setMarca(marca);
            t.setTamañoPulgadas(tamano);
            t.setPrecio(precio);
            t.setPesoKg(V.PedirDecimalRango(sc, "Ingrese el peso en kg", 0.01f, 20f));
            t.setAlmacenamiento(NombreAlmacenamiento(M.SubMenuAlmacenamiento(sc)));
            tableta.add(t);
        }
        return true;
    }

    /** Quita del vector correspondiente el equipo con ese serial. */
    private boolean EliminarEquipo(String serial) {
        for (ComputadorPortatil c : portatil) {
            if (c.getSerial().equalsIgnoreCase(serial)) {
                portatil.remove(c);
                return true;
            }
        }
        for (TabletaGrafica t : tableta) {
            if (t.getSerial().equalsIgnoreCase(serial)) {
                tableta.remove(t);
                return true;
            }
        }
        return false;
    }

    private String NombreAlmacenamiento(int opt) {
        switch (opt) {
            case 1:
                return "256 GB";
            case 2:
                return "512 GB";
            default:
                return "1 TB";
        }
    }

    // Devuelven true si el vector tiene elementos y false si está vacío.

    public boolean ImprimirIngenieros() {
        System.out.println("---- Estudiantes de Ingenieria (" + ingenieros.size() + ") ----");
        for (EstudianteIngenieria e : ingenieros) {
            System.out.println("Cedula: " + e.getCedula() + " | " + e.getNombre() + " " + e.getApellido()
                    + " | Tel: " + e.getTelefono() + " | Semestre: " + e.getNumeroSemestre()
                    + " | Promedio: " + e.getPromedioAcumulado() + " | Serial equipo: " + e.getSerialEquipo());
        }
        return !ingenieros.isEmpty();
    }

    public boolean ImprimirDisenadores() {
        System.out.println("Estudiantes de Diseno (" + disenadores.size() + ") ");
        for (studianteDiseno e : disenadores) {
            System.out.println("Cedula: " + e.getCedula() + " | " + e.getNombre() + " " + e.getApellido()
                    + " | Tel: " + e.getTelefono() + " | Modalidad: " + e.getModalidadEstudio()
                    + " | Asignaturas: " + e.getCantidadAsignaturas() + " | Serial equipo: " + e.getSerialEquipo());
        }
        return !disenadores.isEmpty();
    }

    public boolean ImprimirPortatiles() {
        System.out.println("Computadores portatiles (" + portatil.size() + ") ");
        for (ComputadorPortatil c : portatil) {
            System.out.println("Serial: " + c.getSerial() + " | Marca: " + c.getMarca()
                    + " | Tamano: " + c.getTamañopulgadas() + " | Precio: " + c.getPrecio()
                    + " | SO: " + c.getSistemaOperativo() + " | Procesador: " + c.getProcesador());
        }
        return !portatil.isEmpty();
    }

    public boolean ImprimirTabletas() {
        System.out.println("Tabletas graficas (" + tableta.size() + ") ");
        for (TabletaGrafica t : tableta) {
            System.out.println("Serial: " + t.getSerial() + " | Marca: " + t.getMarca()
                    + " | Tamano: " + t.getTamañoPulgadas() + " | Precio: " + t.getPrecio()
                    + " | Peso: " + t.getPesoKg() + " | Almacenamiento: " + t.getAlmacenamiento());
        }
        return !tableta.isEmpty();
    }
}