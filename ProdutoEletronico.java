public class ProdutoEletronico extends Produto {
  private int garantiaMeses;
  private String tensao;

  public ProdutoEletronico(String nome, String ID, double preco, int garantiaMeses, String tensao) {
    super(nome, ID, preco);
    this.garantiaMeses = garantiaMeses;
    this.tensao = tensao;
  }

  public int getGarantiaMeses() {
    return garantiaMeses;
  }

  public String getTensao() {
    return tensao;
  }

  public void setGarantiaMeses(int meses) {
    this.garantiaMeses = meses;
  }

  public void setTensao(String tensao) {
    this.tensao = tensao;
  }
}