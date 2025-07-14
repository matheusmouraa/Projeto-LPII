package exceptions;

public class DadosInvalidosException extends SistemaException {
  public DadosInvalidosException(String campo) {
    super(String.format("Dados inválidos no campo", campo));
  }
}