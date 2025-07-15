import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Sistema {
  // Supermercado e Sacanner estático que todos os métodos irão usar
  private static SuperMercado superMercado;
  private static Scanner scanner = new Scanner(System.in);

  // instanciar o Supermercado
  public static void criarSuperMercado() {
    // Verifica se o Supermercado já foi cadastrado
    if (superMercado != null) {
      throw new MercadoExceptionChecked("Erro: Supermercado já cadastrado");
    }

    // Lê entradas
    System.out.println("\n== CRIAR SUPER MERCADO ==");

    // Lendo nome
    System.out.print("Nome : ");
    String nome = scanner.nextLine();

    // Lendo CNPJ
    System.out.print("CNPJ: ");
    String CNPJ = scanner.nextLine();

    // Instânciando o Super Mercado
    superMercado = new SuperMercado(nome, CNPJ);
    System.out.println("\nSuper Mercado criado");
  }

  // Adicionar Produto
  public static void addProduto() throws MercadoExceptionChecked {
    // Verificando se o Supermercado foi instanciado
    if (superMercado == null) {
      throw new MercadoExceptionChecked("Crie um Super Mercado primeiro");
    }
    // Verificando se o Supermercado tem um fornecedor
    else if (superMercado.getFornecedores().isEmpty()) {
      throw new MercadoExceptionChecked("Adicione um fornecedor primeiro");
    }

    // Lendo entradas do Produto
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

    System.out.print("Fornecedor: ");
    String fornecedor_nome = scanner.nextLine();


    Produto produto;
    switch (tipo) {
      // Produto Perecível
      case 1:
        System.out.print("Data de validade (AAAA-MM-DD): ");
        LocalDate dataValidade = LocalDate.parse(scanner.nextLine());

        System.out.print("Precisa de refrigeração? (true/false): ");
        boolean refrigeracao = Boolean.parseBoolean(scanner.nextLine());

        produto = new ProdutoPerecivel(nome, id, preco, dataValidade, refrigeracao);
        break;
      // Produto Eletrônico
      case 2:
        System.out.print("Meses de garantia: ");
        int garantia = Integer.parseInt(scanner.nextLine());

        System.out.print("Tensão: ");
        String tensao = scanner.nextLine();

        produto = new ProdutoEletronico(nome, id, preco, garantia, tensao);
        break;
      // Bebida
      case 3:
        System.out.print("Volume em litros: ");
        double litros = Double.parseDouble(scanner.nextLine());

        System.out.print("É alcoólica? (true/false): ");
        boolean alcoolica = Boolean.parseBoolean(scanner.nextLine());

        produto = new ProdutoBebida(nome, id, preco, litros, alcoolica);
        break;
      // Nenhum tipo encontrado
      default:
        throw new IllegalArgumentException("Tipo inválido");
    }

    // Adicionando fornecedor ao produto
    // Verifica se o fornecedor foi adicionado
    boolean fornecedorAdicionado = false;
    // Percorre o HashSet fornecedores de Supermercado
    for (Fornecedor fornecedor : superMercado.getFornecedores()) {
      // Compara pelo nome
      if (fornecedor.getNome().equals(fornecedor_nome)) {
        // Adiciona o fornecedor ao produto
        produto.addFornecedor(fornecedor);
        fornecedorAdicionado = true;
      }
    }

    // Verifica se o fornecedor foi adicionado
    if (!fornecedorAdicionado) {
      throw new MercadoExceptionChecked("Fornecedor não encontrado");
    }

    // Verifica se o fornecedor foi adicionado
    for (Fornecedor fornecedor : superMercado.getFornecedores()) {
      // Compara pelo nome
      if (fornecedor.getNome().equals(fornecedor_nome)) {
        // Adiciona o fornecedor ao produto
        fornecedor.addProduto(produto);
      }
    }

    // Adicionando o produto ao Supermercado
    superMercado.addProduto(produto);

    System.out.println("\nProduto adicionado com sucesso!");
  }

  public static void addFornecedor() throws MercadoExceptionChecked {
    if (superMercado == null) {
      throw new MercadoExceptionChecked("Super Mercado não criado");
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

    Endereco endereco = new Endereco(cep, rua, cidade);
    Fornecedor fornecedor = new Fornecedor(nome, endereco);

    superMercado.addFornecedor(fornecedor);
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
      throw new MercadoExceptionChecked("\nErro ao adicionar funcionário: " + e.getMessage());
    }
  }

  public static void addPromocao() {
    if (superMercado == null) {
      throw new MercadoExceptionChecked("Super Mercado não criado");
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
      throw new MercadoExceptionChecked("\nErro ao adicionar promoção: " + e.getMessage());
    }
  }

  public static void removerProduto() {
    // Verifica se o Supermercado foi instanciado
    if (superMercado == null) {
      throw new MercadoExceptionChecked("Super Mercado não criado");
    }

    // Verifica se tem produtos no estoque
    else if (superMercado.getProdutos().isEmpty()) {
      throw new MercadoExceptionChecked("Nenhum produto cadastrado.");
    }

    // Removendo o produto
    System.out.println("\n=== REMOVER PRODUTO ===");

    // Lendo id
    System.out.print("Digite o ID do produto a ser removido: ");
    String id = scanner.nextLine();

    // Percorre o ArrayList de produtos procurando pelo produto
    for (Produto produto : superMercado.getProdutos()) {
      // Compara o produto pelo ID
      if (produto.getID().equals(id)) {
        // Remove o produto
        superMercado.removeProduto(produto);
        System.out.println("\nProduto removido com sucesso");
        return;
      }
    }
    throw new MercadoExceptionChecked("Produto não encontrado.");
  }

  public static void editarProdutosFornecedor() {
    System.out.println("\n=== EDITAR FORNECEDOR ===");
    System.out.print("Digite o nome do fornecedor a ser editado: ");
    String nome = scanner.nextLine();

    for (Fornecedor f : superMercado.getFornecedores()) {
      if (f.getNome().equalsIgnoreCase(nome)) {
        int lista = 1;
        Produto produtoParaRemover = null;
        for (Produto produto : f.getProdutos()) {
          System.out.println(lista + " - " + produto.getNome());
          lista++;
        }
        System.out.print("Digite o número do produto que deseja deletar do fornecedor: ");
        int id = Integer.parseInt(scanner.nextLine());
        lista = 1;
        for (Produto produto : f.getProdutos()) {
          if (lista == id) {
            produtoParaRemover = produto;
            break;
          }
          lista++;
        }
        if (produtoParaRemover != null) {
          f.getProdutos().remove(produtoParaRemover);
          System.out.println("\nProduto removido com sucesso!");
        } else {
          throw new MercadoExceptionChecked("\nProduto não encontrado!");
        }
        return;
      }
    }
    throw new MercadoExceptionChecked("\nFornecedor nao encontrado!");
  }

  public static void removerFornecedor() {
    //Verifica se o Supermercado foi instanciado
    if (superMercado == null) {
      throw new MercadoExceptionChecked("Crie um Super Mercado primeiro");
    }
    // Verificando se o Supermercado tem algum fornecedor
    else if (superMercado.getFornecedores().isEmpty()) {
      throw new MercadoExceptionChecked("Supermercado não tem fornecedores");
    }

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
    throw new MercadoExceptionChecked("\nFornecedor não encontrado!");
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
    throw new MercadoExceptionChecked("\nFuncionário não encontrado!");
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
    throw new MercadoExceptionChecked("\nPromoção não encontrada!");
  }

  public static void exibirEstoque() {
    // Verifica se o Supermercado foi instanciado
    if (superMercado == null) {
      System.out.println("\nErro: Crie um Super Mercado primeiro!");
    }
    // Verifica se tem produtos no estoque
    else if (superMercado.getProdutos().isEmpty()) {
      throw new MercadoExceptionChecked("Nenhum produto cadastrado.");
    } else {
      System.out.println("\n=== ESTOQUE ===");
      // Percorre o ArrayList de produtos exibindo suas informações
      for (Produto produto : superMercado.getProdutos()) {
        produto.ExibirProduto();
        System.out.println("---------------");
      }
    }
  }

  public static void exibirFornecedores() {
    System.out.println("\n=== FORNECEDORES ===");
    if (superMercado.getFornecedores().isEmpty()) {
      throw new MercadoExceptionChecked("Nenhum fornecedor cadastrado.");
    } else {
      for (Fornecedor f : superMercado.getFornecedores()) {
        System.out.println(f.getNome());
      }
    }
  }

  public static void exibirFuncionarios() {
    System.out.println("\n=== FUNCIONÁRIOS ===");
    if (superMercado.getFuncionarios().isEmpty()) {
      throw new MercadoExceptionChecked("Nenhum funcionário cadastrado.");
    } else {
      for (Funcionario f : superMercado.getFuncionarios()) {
        System.out.println(f.getNome() + " - " + f.getFuncao());
      }
    }
  }

  public static void exibirPromocoes() {
    System.out.println("\n=== PROMOÇÕES ===");
    if (superMercado.getPromocoes().isEmpty()) {
      throw new MercadoExceptionChecked("Nenhuma promoção cadastrada.");
    } else {
      for (Promocao p : superMercado.getPromocoes()) {
        p.exibirInformacoes();
      }
    }
  }

  public static void ativarOuDesativarPromocao() {
    System.out.println("\n=== ATIVAR OU DESATIVAR PROMOÇÃO ===");
    System.out.print("Digite o tipo da promoção a ser ativada ou desativada: ");
    int i = 0;
    for (Promocao promocao : superMercado.getPromocoes()) {
      System.out.println((i++) + " - " + promocao.getTipo());
    }
    String tipo = scanner.nextLine();

    for (Promocao p : superMercado.getPromocoes()) {
      if (p.getTipo().equalsIgnoreCase(tipo)) {
        p.setAtivo(!p.getAtivo());
        System.out.println("\nPromoção " + (p.getAtivo() ? "ativada" : "desativada") + " com sucesso!");
        return;
      }
    }
    throw new MercadoExceptionChecked("Promoção não encontrada!");
  }

  public static void procurarProduto() {
    System.out.println("\n=== PROCURAR PRODUTO ===");
    System.out.print("Digite o ID: ");
    String id = scanner.nextLine();

    for (Produto p : superMercado.getProdutos()) {
      if (p.getID().contains(id)) {
        p.ExibirProduto();
        System.out.println("---------------");
      }
    }
  }
}