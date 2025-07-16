import java.util.Scanner;
import DAO.UsuarioDAO;
import DAO.ProdutoDAO;
import DAO.PedidoDAO;
import entity.Usuario;
import entity.Produto;
import entity.Pedido;

public class App {

    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    private static final PedidoDAO pedidoDAO = new PedidoDAO();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao, autenticador=0;
        String usuario,senha;

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                            BEM-VINDO AO LOGIN DO SISTEMA ERP                                        ");
        System.out.println(" usuário = 'Admin' | senha = vazia                           (Login e senha inspirada no Protheus)   ");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        while (autenticador == 0) {
            System.out.print("Informe seu usuário: ");
            usuario = entrada.next();
            entrada.nextLine(); 

            System.out.print("Informe sua senha: ");
            senha = entrada.nextLine();

            if (!usuario.equalsIgnoreCase("admin") || !senha.equals("")) {
                System.out.println("\nInformações de login incorretas.");
                System.out.println("Tente: usuário = 'Admin' | senha = vazia");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("OBS: Este sistema é educativo e tem como finalidade mostrar habilidades práticas para fins de estágio.");
                System.out.println("As credenciais estão abertas para facilitar o uso sem alterar o código fonte.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("");
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("                            BEM-VINDO AO LOGIN DO SISTEMA ERP                                        ");
                System.out.println("-----------------------------------------------------------------------------------------------------");

            } else {
                System.out.println("Login autorizado!");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("           BEM-VINDO AO SISTEMA ERP (Estoque, Pedidos, Usuários)                                     ");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                autenticador++;
            }
        }

        do {
            System.out.println("Selecione o módulo:");
            System.out.println("1 - Gerenciar Usuários");
            System.out.println("2 - Gerenciar Produtos");
            System.out.println("3 - Gerenciar Pedidos");
            System.out.println("4- Sobre");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            
            if (entrada.hasNextInt()) {
                opcao = entrada.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.next();
                opcao = -1;
            }
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarUsuarios(entrada);
                    break;
                case 2:
                    gerenciarProdutos(entrada);
                    break;
                case 3:
                    gerenciarPedidos(entrada);
                    break;
                case 4:
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("                                   SOBRE O SISTEMA ERP TOTVS                                         ");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("Este projeto simula um sistema ERP (Enterprise Resource Planning), inspirado no TOTVS Protheus 12,");
                    System.out.println("desenvolvido com fins educacionais e para compor um portfólio profissional na área de tecnologia.");
                    System.out.println();
                    System.out.println("A aplicação foi criada em Java com uso de java e conexão ao banco de dados MySQL,");
                    System.out.println("e menus interativos via terminal.");
                    System.out.println();
                    System.out.println("Objetivo: Demonstrar conhecimentos práticos em lógica, Java, SQL, estrutura de ERPs reais e organização");
                    System.out.println("de sistemas empresariais, com base nos aprendizados adquiridos em cursos e formações.");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }

    public static void gerenciarUsuarios(Scanner entrada) {
        System.out.println("--- MÓDULO USUÁRIOS ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Remover");
        System.out.print("Opção: ");
        int userOp = entrada.nextInt();
        entrada.nextLine();

        if (userOp == 1) {
            System.out.print("Digite o nome do usuário: ");
            String nome = entrada.nextLine();

            System.out.print("Digite o CPF do usuário: ");
            String cpf = entrada.nextLine();

            System.out.print("Digite o telefone do usuário: ");
            String tel = entrada.nextLine();

            Usuario u = new Usuario();
            u.setNome(nome);
            u.setCPF(cpf);
            u.setTel(tel);

            usuarioDAO.cadastrarUsuario(u);
            System.out.println("Usuário cadastrado com sucesso!");

        } else if (userOp == 2) {
            System.out.print("Digite o CÓDIGO do usuário a ser removido: ");
            int codigo = entrada.nextInt();
            usuarioDAO.removerUsuario(codigo);
            System.out.println("Operação de remoção enviada!");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void gerenciarProdutos(Scanner entrada) {
        System.out.println("--- MÓDULO PRODUTOS ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Remover");
        System.out.print("Opção: ");
        int prodOp = entrada.nextInt();
        entrada.nextLine();

        if (prodOp == 1) {
            Produto p = new Produto();

            System.out.print("Digite o tipo do produto: ");
            String tipo = entrada.nextLine();
            p.setTipo_produto(tipo);

            System.out.print("Digite a quantidade em unidade: ");
            int unidade = entrada.nextInt();
            p.setUnidade_produto(unidade);

            System.out.print("Digite o preço por unidade (ex: 10,50): ");
            double preco = entrada.nextDouble();
            p.setPreço_unidade(preco);
            entrada.nextLine();

            System.out.print("Digite a data de cadastro (dd/mm/aaaa): ");
            String data = entrada.nextLine();
            p.setData_cadastro(data);

            produtoDAO.cadastrarProduto(p);
            System.out.println("Produto cadastrado com sucesso!");

        } else if (prodOp == 2) {
            System.out.print("Digite o ID do produto a ser removido: ");
            int idProduto = entrada.nextInt();
            produtoDAO.removerProduto(idProduto);
            System.out.println("Operação de remoção enviada!");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void gerenciarPedidos(Scanner entrada) {
        System.out.println("--- MÓDULO PEDIDOS ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Remover");
        System.out.print("Opção: ");
        int pedOp = entrada.nextInt();
        entrada.nextLine();

        if (pedOp == 1) {
            Pedido ped = new Pedido();

            System.out.print("Digite o ID do Cliente para o pedido: ");
            int idCliente = entrada.nextInt();
            ped.setId_Clientes(idCliente);

            System.out.print("Digite o valor total do pedido (ex: 5000,00): ");
            double valor = entrada.nextDouble();
            ped.setValot_Total(valor);
            entrada.nextLine();

            System.out.print("Digite a data da venda (dd/mm/aaaa): ");
            String dataVenda = entrada.nextLine();
            ped.setData_Venda(dataVenda);

            System.out.print("Digite o status do pedido (Ex: Aberto, Fechado, Cancelado): ");
            String status = entrada.nextLine();
            ped.setStatus(status);

            pedidoDAO.cadastrarPedido(ped);
            System.out.println("Pedido cadastrado com sucesso!");

        } else if (pedOp == 2) {
            System.out.print("Digite o ID do pedido a ser removido: ");
            int idPedido = entrada.nextInt();
            pedidoDAO.removerPedido(idPedido);
            System.out.println("Operação de remoção enviada!");
        } else {
            System.out.println("Opção inválida.");
        }
    }
}