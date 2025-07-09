import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {
  private LocalDate dataValidade;
  private boolean precisaRefrigeracao;

  public ProdutoPerecivel(String nome, String ID, double preco, LocalDate dataValidade, boolean precisaRefrigeracao) {
    super(nome, ID, preco);
    this.dataValidade = dataValidade;
    this.precisaRefrigeracao = precisaRefrigeracao;
  }

  public String getDataValidade() {
    return dataValidade.toString();
  }

  public boolean getPrecisaRefrigeracao() {
    return precisaRefrigeracao;
  }

  public void setDataValidade(LocalDate dataValidade) {
    this.dataValidade = dataValidade;
  }

  public void setPrecisaRefrigeracao(boolean precisaRefrigeracao) {
    this.precisaRefrigeracao = precisaRefrigeracao;
  }
}