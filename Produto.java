import java.util.HashSet;

public class Produto {
  private String nome;
  private String ID;
  private double preco;
  private HashSet<Fornecedor> fornecedores;

  public Produto(String nome, String ID, double preco) {
    this.nome = nome;
    this.ID = ID;
    this.preco = preco;
    this.fornecedores = new HashSet<>();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public void addFormosador(Fornecedor fornecedor) {
    this.fornecedores.add(fornecedor);
  }

  public void removeFormosador(Fornecedor fornecedor) {
    this.fornecedores.remove(fornecedor);
  }
}