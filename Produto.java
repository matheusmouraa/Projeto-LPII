import java.util.HashSet;
import java.util.Objects;

public abstract class Produto {
  private String nome;
  private String ID;
  private double preco;
  private HashSet<Fornecedor> fornecedores;

  public Produto(String _nome, String _ID, double _preco) {
    this.nome = _nome;
    this.ID = _ID;
    this.preco = _preco;
    this.fornecedores = new HashSet<>();
  }

  //Métodos
  //Gets e Sets
  public String getNome() {
    return this.nome;
  }

  public void setNome(String _nome) {
    this.nome = _nome;
  }

  public String getID() {
    return this.ID;
  }

  public void setID(String _ID) {
    this.ID = _ID;
  }

  public double getPreco() {
    return this.preco;
  }

  public void setPreco(double _preco) {
    this.preco = _preco;
  }

  //Exibir Informações do Produto
  public void ExibirProduto(){
    System.out.println("Nome: " + this.nome);
    System.out.println("ID: " + this.ID);
    System.out.println("Preço: " + this.preco);
    System.out.print("Fornecedores: ");
    for (Fornecedor fornecedor : fornecedores) {
      System.out.print(fornecedor.getNome() + " ");
    }
    System.out.println();
  }

  //Fornecedor
  public void addFornecedor(Fornecedor fornecedor) {
    this.fornecedores.add(fornecedor);
  }

  public void removeFornecedor(Fornecedor fornecedor) {
    this.fornecedores.remove(fornecedor);
  }

  public HashSet<Fornecedor> getFornecedores(){
    return this.fornecedores;
  }

  //HashSet
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Produto)) {
      return true;
    }

    Produto outro = (Produto) obj;

    return Objects.equals(this.ID, outro.ID);
  }

  public int hashCode() {
    return Objects.hash(this.ID);
  }
}