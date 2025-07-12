import java.util.ArrayList;
import java.util.HashSet;

public class SuperMercado {
  private String nome;
  private String CNPJ;
  private ArrayList<Produto> produtos;
  private HashSet<Fornecedor> fornecedores;
  private HashSet<Funcionario> funcionarios;
  private HashSet<Promocao> promocoes;

  public SuperMercado(String _nome, String _CNPJ) {
    this.nome = _nome;
    this.CNPJ = _CNPJ;
    this.produtos = new ArrayList<>();
    this.fornecedores = new HashSet<>();
    this.funcionarios = new HashSet<>();
    this.promocoes = new HashSet<>();
  }

  //Métodos

  //Gets e Sets de Nome e CNPJ
  public String getNome() {
    return this.nome;
  }

  public String getCNPJ() {
    return this.CNPJ;
  }

  public void setNome(String _nome) {
    this.nome = _nome;
  }

  public void setCNPJ(String _CNPJ) {
    this.CNPJ = _CNPJ;
  }

  //Produtos
  public void addProduto(Produto produto) {
    this.produtos.add(produto);
  }

  public void removeProduto(Produto produto) {
    this.produtos.remove(produto);
  }

  public ArrayList<Produto> getProdutos() {
    return this.produtos;
  }

  //Fornecedores
  public void addFornecedor(Fornecedor fornecedor) {
    this.fornecedores.add(fornecedor);
  }

  public void removeFornecedor(Fornecedor fornecedor) {
    this.fornecedores.remove(fornecedor);
  }

  public HashSet<Fornecedor> getFornecedores() {
    return this.fornecedores;
  }

  //Funcionarios
  public void addFuncionario(Funcionario funcionario) {
    this.funcionarios.add(funcionario);
  }

  public void removeFuncionario(Funcionario funcionario) {
    this.funcionarios.remove(funcionario);
  }

  public HashSet<Funcionario> getFuncionarios() {
    return this.funcionarios;
  }

  //Promoções
  public void addPromocao(Promocao promocao) {
    this.promocoes.add(promocao);
  }

  public void removePromocao(Promocao promocao) {
    this.promocoes.remove(promocao);
  }

  public HashSet<Promocao> getPromocoes() {
    return this.promocoes;
  }

}