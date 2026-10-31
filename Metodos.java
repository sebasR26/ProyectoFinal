import java.util.Scanner;

public class Metodos {
    Metodos M = new Metodos();
    Validaciones V = new Validaciones();
    
    /*
 * Método con submenú para almacenamiento:
 * 256 GB
 * 512 GB
 * 1 TB
 * Peso (float, en kg)
 */
public int SubMenuSistemOperativo(Scanner sc){
        System.out.println("Seleccione su Sistema Operativo");
        System.out.println("1: Windows 7");
        System.out.println("2: Windows 10");
        System.out.println("3: Windows 11");
        int opt = V.ValidarEntero(sc);
        return opt;
    }
        /*
Submenú para Sistema Operativo:
Windows 7
Windows 10
Windows 11
Submenú para Procesador:
AMD Ryzen
Intel Core i5
Los datos se validan correctamente según su tipo.
No se permiten caracteres especiales ni números en campos de texto (marca, serial, etc.).
 */

}
