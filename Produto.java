import java.util.HashSet;

public class Produto {
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

  //Fornecedor
  public void addFornecedor(Fornecedor fornecedor) {
    this.fornecedores.add(fornecedor);
  }

  public void removeFornecedor(Fornecedor fornecedor) {
    this.fornecedores.remove(fornecedor);
  }
}