import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Sistema {
  //Supermercado e Sacanner estático que todos os métodos irão usar
  private static SuperMercado superMercado;
  private static Scanner scanner = new Scanner(System.in);

  //instanciar o Supermercado
  public static void criarSuperMercado() {
    System.out.println("\n== CRIAR SUPER MERCADO ==");
    //Lendo nome
    System.out.print("Nome : ");
    String nome = scanner.nextLine();

    //Lendo CNPJ
    System.out.print("CNPJ: ");
    String CNPJ = scanner.nextLine();

    //Instânciando o Super Mercado
    superMercado = new SuperMercado(nome, CNPJ);
    System.out.println("\nSuper Mercado criado");
  }

  //Adicionar Produto
  public static void addProduto() {
    //Verificando se o Supermercado foi instanciado
    if (superMercado == null) {
      System.out.println("\nErro: Crie um Super Mercado primeiro!");
      return;
    }

    //Verificando se o Supermercado tem o fornecedor (Adicionar dentro do if)

    //Lendo entradas do Produto
    System.out.println("\n=== ADICIONAR PRODUTO ===");
    System.out.println("Tipo de produto:");
    System.out.println("1 - Perecível");
    System.out.println("2 - Eletrônico");
    System.out.println("3 - Bebida");
    System.out.print("Escolha o tipo: ");
    int tipo = Integer.parseInt(scanner.nextLine());

    System.out.print("\nNome do produto: ");
    String nome = scanner.nextLine();

    System.out.print("ID do produto: ");
    String id = scanner.nextLine();

    System.out.print("Preço: ");
    double preco = Double.parseDouble(scanner.nextLine());

    try {
      Produto produto;
      switch (tipo) {
        //Produto Perecível
        case 1:
          System.out.print("Data de validade (AAAA-MM-DD): ");
          LocalDate dataValidade = LocalDate.parse(scanner.nextLine());

          System.out.print("Precisa de refrigeração? (true/false): ");
          boolean refrigeracao = Boolean.parseBoolean(scanner.nextLine());

          produto = new ProdutoPerecivel(nome, id, preco, dataValidade, refrigeracao);
          break;
        //Produto Eletrônico
        case 2:
          System.out.print("Meses de garantia: ");
          int garantia = Integer.parseInt(scanner.nextLine());

          System.out.print("Tensão: ");
          String tensao = scanner.nextLine();

          produto = new ProdutoEletronico(nome, id, preco, garantia, tensao);
          break;
        //Bebida
        case 3:
          System.out.print("Volume em litros: ");
          double litros = Double.parseDouble(scanner.nextLine());

          System.out.print("É alcoólica? (true/false): ");
          boolean alcoolica = Boolean.parseBoolean(scanner.nextLine());

          produto = new ProdutoBebida(nome, id, preco, litros, alcoolica);
          break;
        //Nenhum tipo encontrado
        default:
          throw new IllegalArgumentException("Tipo inválido");
      }

      //Adicionando o produto ao Supermercado
      superMercado.addProduto(produto);
      //Adicionando produto ao fornecedor (Implementar)

      System.out.println("\nProduto adicionado com sucesso!");
    } catch (Exception e) {
      System.out.println("\nErro ao adicionar produto: " + e.getMessage());
    }
  }

  public static void addFornecedor() {
    if (superMercado == null) {
      System.out.println("\nErro: Crie um Super Mercado primeiro!");
      return;
    }

    System.out.println("\n=== ADICIONAR FORNECEDOR ===");
    System.out.print("Nome do fornecedor: ");
    String nome = scanner.nextLine();

    System.out.print("CNPJ: ");
    String cnpj = scanner.nextLine();

    System.out.println("\nEndereço do fornecedor:");
    System.out.print("CEP: ");
    String cep = scanner.nextLine();

    System.out.print("Rua: ");
    String rua = scanner.nextLine();

    System.out.print("Cidade: ");
    String cidade = scanner.nextLine();

    try {
      Endereco endereco = new Endereco(cep, rua, cidade);
      Fornecedor fornecedor = new Fornecedor(nome, endereco);

      superMercado.addFornecedor(fornecedor);
      System.out.println("\nFornecedor adicionado com sucesso!");
    } catch (Exception e) {
      System.out.println("\nErro ao adicionar fornecedor: " + e.getMessage());
    }
  }

  public static void addFuncionario() {
    if (superMercado == null) {
      System.out.println("\nErro: Crie um Super Mercado primeiro!");
      return;
    }

    System.out.println("\n=== ADICIONAR FUNCIONÁRIO ===");
    System.out.print("Nome do funcionário: ");
    String nome = scanner.nextLine();

    System.out.print("Função/Cargo: ");
    String funcao = scanner.nextLine();

    try {
      Funcionario funcionario = new Funcionario(nome, funcao);
      superMercado.addFuncionario(funcionario);
      System.out.println("\nFuncionário adicionado com sucesso!");
    } catch (Exception e) {
      System.out.println("\nErro ao adicionar funcionário: " + e.getMessage());
    }
  }

  public static void addPromocao() {
    if (superMercado == null) {
      System.out.println("\nErro: Crie um Super Mercado primeiro!");
      return;
    }

    System.out.println("\n=== ADICIONAR PROMOÇÃO ===");
    System.out.print("Está ativa? (true/false): ");
    boolean ativa = Boolean.parseBoolean(scanner.nextLine());

    System.out.print("Tipo de promoção: ");
    String tipo = scanner.nextLine();

    System.out.print("Porcentagem de desconto: ");
    int porcentagem = Integer.parseInt(scanner.nextLine());

    try {
      Promocao promocao = new Promocao(ativa, tipo, porcentagem);
      superMercado.addPromocao(promocao);
      System.out.println("\nPromoção adicionada com sucesso!");
    } catch (Exception e) {
      System.out.println("\nErro ao adicionar promoção: " + e.getMessage());
    }
  }

  public static void removerProduto() {
    System.out.println("\n=== REMOVER PRODUTO ===");
    System.out.print("Digite o ID do produto a ser removido: ");
    String id = scanner.nextLine();

    Produto produto = superMercado.procurarProduto(id);
    if (produto != null) {
      superMercado.removeProduto(produto);
      System.out.println("\nProduto removido com sucesso!");
    } else {
      System.out.println("\nProduto não encontrado!");
    }
  }

  public static void removerFornecedor() {
    System.out.println("\n=== REMOVER FORNECEDOR ===");
    System.out.print("Digite o nome do fornecedor a ser removido: ");
    String nome = scanner.nextLine();

    for (Fornecedor f : superMercado.getFornecedores()) {
      if (f.getNome().equalsIgnoreCase(nome)) {
        superMercado.removeFornecedor(f);
        System.out.println("\nFornecedor removido com sucesso!");
        return;
      }
    }
    System.out.println("\nFornecedor não encontrado!");
  }

  public static void removerFuncionario() {
    System.out.println("\n=== REMOVER FUNCIONÁRIO ===");
    System.out.print("Digite o nome do funcionário a ser removido: ");
    String nome = scanner.nextLine();

    for (Funcionario f : superMercado.getFuncionarios()) {
      if (f.getNome().equalsIgnoreCase(nome)) {
        superMercado.removeFuncionario(f);
        System.out.println("\nFuncionário removido com sucesso!");
        return;
      }
    }
    System.out.println("\nFuncionário não encontrado!");
  }

  public static void removerPromocao() {
    System.out.println("\n=== REMOVER PROMOÇÃO ===");
    System.out.print("Digite o tipo da promoção a ser removida: ");
    String tipo = scanner.nextLine();

    for (Promocao p : superMercado.getPromocoes()) {
      if (p.getTipo().equalsIgnoreCase(tipo)) {
        superMercado.removePromocao(p);
        System.out.println("\nPromoção removida com sucesso!");
        return;
      }
    }
    System.out.println("\nPromoção não encontrada!");
  }

  public static void exibirEstoque() {
    System.out.println("\n=== ESTOQUE ===");
    if (superMercado.getProdutos().isEmpty()) {
      System.out.println("Nenhum produto cadastrado.");
    } else {
      for (Produto p : superMercado.getProdutos()) {
        System.out.println(p.getNome() + " - ID: " + p.getID() + " - Preço: R$" + p.getPreco());
      }
    }
  }

  public static void exibirFornecedores() {
    System.out.println("\n=== FORNECEDORES ===");
    if (superMercado.getFornecedores().isEmpty()) {
      System.out.println("Nenhum fornecedor cadastrado.");
    } else {
      for (Fornecedor f : superMercado.getFornecedores()) {
        System.out.println(f.getNome());
      }
    }
  }

  public static void exibirFuncionarios() {
    System.out.println("\n=== FUNCIONÁRIOS ===");
    if (superMercado.getFuncionarios().isEmpty()) {
      System.out.println("Nenhum funcionário cadastrado.");
    } else {
      for (Funcionario f : superMercado.getFuncionarios()) {
        System.out.println(f.getNome() + " - " + f.getFuncao());
      }
    }
  }

  public static void exibirPromocoes() {
    System.out.println("\n=== PROMOÇÕES ===");
    if (superMercado.getPromocoes().isEmpty()) {
      System.out.println("Nenhuma promoção cadastrada.");
    } else {
      for (Promocao p : superMercado.getPromocoes()) {
        System.out.println(p.getTipo() + " - " + p.getPorcentagem() + "% - " +
            (p.getAtivo() ? "Ativa" : "Inativa"));
      }
    }
  }

  public static void procurarProduto() {
    System.out.println("\n=== PROCURAR PRODUTO ===");
    System.out.print("Digite o ID ou nome do produto: ");
    String termo = scanner.nextLine();

    System.out.println("\n=== RESULTADOS DA BUSCA ===");
    boolean encontrado = false;

    for (Produto p : superMercado.getProdutos()) {
      if (p.getID().equalsIgnoreCase(termo) || p.getNome().toLowerCase().contains(termo.toLowerCase())) {
        System.out.println(p.getNome() + " - ID: " + p.getID() + " - Preço: R$" + p.getPreco());
        encontrado = true;
      }
    }

    if (!encontrado) {
      System.out.println("Nenhum produto encontrado com esse critério.");
    }
  }
}