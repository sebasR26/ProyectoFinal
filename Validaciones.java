
public class Validaciones {
    
   public boolean ValidarTexto(String texto) {
        // ^[a-zA-Z0-9 ]*$ permite solo letras y números
        return texto != null && texto.matches("^[a-zA-Z0-9 ]*$");
    }
    
}
