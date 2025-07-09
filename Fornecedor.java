import java.util.HashSet;

public class Fornecedor {
  private String nome;
  private HashSet<Produto> produtos;
  private Endereco endereco;

  public Fornecedor(String nome, Endereco endereco) {
    this.nome = nome;
    this.endereco = endereco;
    this.produtos = new HashSet<>();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public HashSet<Produto> getProdutos() {
    return produtos;
  }

  public void addProduto(Produto produto) {
    this.produtos.add(produto);
  }

  public void removeProduto(Produto produto) {
    this.produtos.remove(produto);
  }
}