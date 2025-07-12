import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel extends Produto {
  private LocalDate dataValidade;
  private boolean precisaRefrigeracao;

  public ProdutoPerecivel(String nome, String ID, double preco, LocalDate dataValidade, boolean precisaRefrigeracao) {
    super(nome, ID, preco);
    this.dataValidade = dataValidade;
    this.precisaRefrigeracao = precisaRefrigeracao;
  }

  //Gets e Sets
  public String getDataValidade() {
    return dataValidade.toString();
  }

  public void setDataValidade(LocalDate dataValidade) {
    this.dataValidade = dataValidade;
  }

  public boolean getPrecisaRefrigeracao() {
    return precisaRefrigeracao;
  }

  public void setPrecisaRefrigeracao(boolean precisaRefrigeracao) {
    this.precisaRefrigeracao = precisaRefrigeracao;
  }

  //Exibi as informações da classe produtos e Bebidas
  public void ExibirProduto(){
    super.ExibirProduto();
    //Formata a data para o formato brasileiro
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    String validade = dataValidade.format(formato);
    //Exibi as variáveis restantes
    System.out.println("Data de validade: " + validade);
    System.out.println("Refrigeração: " + precisaRefrigeracao);
  }
}