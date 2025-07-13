import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    int opcao;
    Scanner entrada = new Scanner(System.in);

    do {
      System.out.println("Opções: ");
      System.out.println("1 - Criar Supermercado");
      System.out.println("2 - Adicionar Produto");
      System.out.println("3 - Procurar Produto por ID");
      System.out.println("4 - Remover Produto");
      System.out.println("5 - Exibir Estoque");
      System.out.println("6 - Adicionar Fornecedor");
      System.out.println("7 - Editar Produto de Fornecedor");
      System.out.println("8 - Remover Fornecedor");
      System.out.println("9 - Exibir Fornecedores");
      System.out.println("10 - Adicionar Funcionário");
      System.out.println("11 - Exibir Funcionários");
      System.out.println("12 - Remover Funcionário");
      System.out.println("13 - Adicionar Promoção");
      System.out.println("14 - Exibir Promoções");
      System.out.println("15 - Ativar ou Desativar Promoção");
      System.out.println("16 - Remover Promoção");
      System.out.println("0 - Sair");

      opcao = entrada.nextInt();

      switch (opcao) {
        case 1:
          Sistema.criarSuperMercado();
          break;
        case 2:
          Sistema.addProduto();
          break;
        case 3:
          Sistema.procurarProduto();
          break;
        case 4:
          Sistema.removerProduto();
          break;
        case 5:
          Sistema.exibirEstoque();
          break;
        case 6:
          Sistema.addFornecedor();
          break;
        case 7:
          Sistema.editarProdutosFornecedor();
          break;
        case 8:
          Sistema.removerFornecedor();
          break;
        case 9:
          Sistema.exibirFornecedores();
          break;
        case 10:
          Sistema.addFuncionario();
          break;
        case 11:
          Sistema.exibirFuncionarios();
          break;
        case 12:
          Sistema.removerFuncionario();
          break;
        case 13:
          Sistema.addPromocao();
          break;
        case 14:
          Sistema.exibirPromocoes();
          break;
        case 15:
          Sistema.ativarOuDesativarPromocao();
          break;
        case 16:
          Sistema.removerPromocao();
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
