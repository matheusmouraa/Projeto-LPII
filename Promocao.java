public class Promocao {
  private boolean ativo;
  private String tipo;
  private int porcentagem;

  public Promocao(boolean ativo, String tipo, int porcentagem) {
    this.ativo = ativo;
    this.tipo = tipo;
    this.porcentagem = porcentagem;
  }

  public boolean getAtivo() {
    return ativo;
  }

  public String getTipo() {
    return tipo;
  }

  public int getPorcentagem() {
    return porcentagem;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setPorcentagem(int porcentagem) {
    this.porcentagem = porcentagem;
  }
}