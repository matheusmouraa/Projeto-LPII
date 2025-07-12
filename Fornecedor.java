import java.util.HashSet;
import java.util.Objects;

public class Fornecedor {
  private String nome;
  private HashSet<Produto> produtos;
  private Endereco endereco;

  public Fornecedor(String nome, Endereco endereco) {
    this.nome = nome;
    this.endereco = endereco;
    this.produtos = new HashSet<>();
    //Inicializar endereço (Implementar)
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

  //HashSet
  public boolean equals(Object obj){

    if(this == obj){
      return true;
    }

    if (!(obj instanceof Fornecedor)){
      return true;
    }

    Fornecedor outro = (Fornecedor) obj;

    return Objects.equals(this.nome, outro.nome);
  }

  public int hashCode(){
    return Objects.hash(this.nome);
  }
}