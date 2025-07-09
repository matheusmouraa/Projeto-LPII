public class Endereco {
  private String CEP;
  private String rua;
  private String cidade;

  public Endereco(String CEP, String rua, String cidade) {
    this.CEP = CEP;
    this.rua = rua;
    this.cidade = cidade;
  }

  public String getCEP() {
    return CEP;
  }

  public String getRua() {
    return rua;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCEP(String CEP) {
    this.CEP = CEP;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
}