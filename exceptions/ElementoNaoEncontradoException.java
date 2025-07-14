package exceptions;

public class ElementoNaoEncontradoException extends SistemaException {
    public ElementoNaoEncontradoException(String elemento) {
        super(elemento + " não encontrado!");
    }
}
