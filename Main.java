import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    int opcao;
    Scanner entrada = new Scanner(System.in);

    do{
      System.out.println("Opções: ");
      System.out.println("1 - Criar Supermercado");
      System.out.println("2 - Adicionar Produto");
      System.out.println("0 - Sair");

      opcao = entrada.nextInt();

      switch (opcao){
        case 1:
          Sistema.criarSuperMercado();
          break;
        case 2:
            Sistema.addProduto();
          break;
        case 0:
          System.out.println("Sair");
          break;
        default:
          System.out.println("Opção invalida");
          break;
      }
    } while (opcao != 0);
  }
}
