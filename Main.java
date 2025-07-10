import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    int opcao = 0;
    Scanner entrada = new Scanner(System.in);

    do{

      System.out.println("Opções: ");
      System.out.println("1 - Criar Supermercado");
      System.out.println("0 - Sair");

      opcao = entrada.nextInt();

      switch (opcao){

        case 1:
          Sistema.criarSuperMercado();
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
