public class ProdutoBebida extends Produto {
  private double litros;
  private boolean alcoolica;

  public ProdutoBebida(String nome, String ID, double preco, double litros, boolean alcoolica) {
    super(nome, ID, preco);
    this.litros = litros;
    this.alcoolica = alcoolica;
  }

  //Gets e Sets
  public double getLitros() {
    return this.litros;
  }

  public void setLitros(double _litros) {
    this.litros = _litros;
  }

  public boolean getAlcoolica() {
    return this.alcoolica;
  }

  public void setAlcoolica(boolean _alcoolica) {
    this.alcoolica = _alcoolica;
  }

  //Exibi as informações da classe produtos e Bebidas
  public void ExibirProduto(){
    super.ExibirProduto();
    System.out.println("Litros: " + litros + "L");
    System.out.println("É alcoólica?: " + alcoolica);
  }
}