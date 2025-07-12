public class ProdutoEletronico extends Produto {
  private int garantiaMeses;
  private String tensao;

  public ProdutoEletronico(String nome, String ID, double preco, int garantiaMeses, String tensao) {
    super(nome, ID, preco);
    this.garantiaMeses = garantiaMeses;
    this.tensao = tensao;
  }

  //Gets e Sets
  public int getGarantiaMeses() {
    return this.garantiaMeses;
  }

  public void setGarantiaMeses(int _meses) {
    this.garantiaMeses = _meses;
  }

  public String getTensao() {
    return this.tensao;
  }

  public void setTensao(String _tensao) {
    this.tensao = _tensao;
  }

  //Exibi as informações da classe produtos e Bebidas
  public void ExibirProduto(){
    super.ExibirProduto();
    System.out.println("Garantia: " + garantiaMeses + " meses");
    System.out.println("Tensão: " + tensao + "V");
  }
}