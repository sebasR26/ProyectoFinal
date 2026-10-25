import java.util.Scanner;

public class Validaciones {
    

    public int validarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor Ingrese un digito nuerico valido");
            sc.next();
        }
        return sc.nextInt();
    }
    
}
