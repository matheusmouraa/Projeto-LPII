import java.util.ArrayList;
import java.util.HashSet;

public class SuperMercado {
  private String nome;
  private String CNPJ;
  private ArrayList<Produto> produtos;
  private HashSet<Fornecedor> fornecedores;
  private HashSet<Funcionario> funcionarios;
  private HashSet<Promocao> promocoes;

  public SuperMercado(String nome, String CNPJ) {
    this.nome = nome;
    this.CNPJ = CNPJ;
    this.produtos = new ArrayList<>();
    this.fornecedores = new HashSet<>();
    this.funcionarios = new HashSet<>();
    this.promocoes = new HashSet<>();
  }

  public String getNome() {
    return nome;
  }

  public String getCNPJ() {
    return CNPJ;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCNPJ(String CNPJ) {
    this.CNPJ = CNPJ;
  }

  public void addProduto(Produto produto) {
    this.produtos.add(produto);
  }

  public void removeProduto(Produto produto) {
    this.produtos.remove(produto);
  }

  public ArrayList<Produto> getProdutos() {
    return this.produtos;
  }

  public HashSet<Fornecedor> getFornecedores() {
    return this.fornecedores;
  }

  public HashSet<Funcionario> getFuncionarios() {
    return this.funcionarios;
  }

  public HashSet<Promocao> getPromocoes() {
    return this.promocoes;
  }

  public void addFornecedor(Fornecedor fornecedor) {
    this.fornecedores.add(fornecedor);
  }

  public void removeFornecedor(Fornecedor fornecedor) {
    this.fornecedores.remove(fornecedor);
  }

  public void addFuncionario(Funcionario funcionario) {
    this.funcionarios.add(funcionario);
  }

  public void removeFuncionario(Funcionario funcionario) {
    this.funcionarios.remove(funcionario);
  }

  public void addPromocao(Promocao promocao) {
    this.promocoes.add(promocao);
  }

  public void removePromocao(Promocao promocao) {
    this.promocoes.remove(promocao);
  }

  public Produto procurarProduto(String ID) {
    for (Produto produto : produtos) {
      if (produto.getID().equals(ID)) {
        return produto;
      }
    }
    return null;
  }

}