public class ProdutoBebida extends Produto {
  private double litros;
  private boolean alcoolica;

  public ProdutoBebida(String nome, String ID, double preco, double litros, boolean alcoolica) {
    super(nome, ID, preco);
    this.litros = litros;
    this.alcoolica = alcoolica;
  }

  public double getLitros() {
    return litros;
  }

  public boolean isAlcoolica() {
    return alcoolica;
  }

  public void setLitros(double litros) {
    this.litros = litros;
  }

  public void setAlcoolica(boolean alcoolica) {
    this.alcoolica = alcoolica;
  }
}