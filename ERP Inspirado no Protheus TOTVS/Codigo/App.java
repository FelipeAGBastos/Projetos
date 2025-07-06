import java.util.Scanner;

import DAO.UsuarioDAO;
import DAO.ProdutoDAO;
import DAO.PedidoDAO;

import entity.Usuario;
import entity.Produto;
import entity.Pedido;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                      BEM-VINDO AO SISTEMA ERP (Estoque, Pedidos, Usuários)");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        do {
            System.out.println("\nSelecione o módulo:");
            System.out.println("1 - Cadastro/Remoção de Usuários");
            System.out.println("2 - Cadastro/Remoção de Produtos");
            System.out.println("3 - Cadastro/Remoção de Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- MÓDULO USUÁRIOS ---");
                    System.out.println("1 - Cadastrar");
                    System.out.println("2 - Remover");
                    System.out.println("");
                     System.out.println("Lembre-se que você deve alterar os parâmetros no codigo antes de efetuar tais processos!!!");
                    int userOp = entrada.nextInt();
                    entrada.nextLine();

                    if (userOp == 1) {
                        Usuario u = new Usuario();
                        u.setNome("Felipe Bastos");//altere aqui tais informações para ser inseridas no banco de dados 
                        u.setCPF("123.456.789-00");//altere aqui tais informações para ser inseridas no banco de dados 
                        u.setTel("1199999-9999");//altere aqui tais informações para ser inseridas no banco de dados 

                        new UsuarioDAO().cadastrarUsuario(u);
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else if (userOp == 2) {
                        System.out.print("Digite o ID do usuário a ser removido: ");
                        int id = entrada.nextInt();
                        new UsuarioDAO().removerUsuario(id);
                    }
                    break;

                case 2:
                    System.out.println("\n--- MÓDULO PRODUTOS ---");
                    System.out.println("1 - Cadastrar");
                    System.out.println("2 - Remover");
                    System.out.println("");
                     System.out.println("Lembre-se que você deve alterar os parâmetros no codigo antes de efetuar tais processos!!!");
                    int prodOp = entrada.nextInt();
                    entrada.nextLine();

                    if (prodOp == 1) {
                        Produto p = new Produto();
                        p.setTipo_produto("Pulseira"); //altere aqui tais informações para ser inseridas no banco de dados 
                        p.setUnidade_produto(100); //altere aqui tais informações para ser inseridas no banco de dados 
                        p.setPreço_unidade(10.5); //altere aqui tais informações para ser inseridas no banco de dados 
                        p.setData_cadastro("26/06/2025");//altere aqui tais informações para ser inseridas no banco de dados 

                        new ProdutoDAO().cadastrarUsuario(p);
                        System.out.println("Produto cadastrado com sucesso!");
                    } else if (prodOp == 2) {
                        System.out.print("Digite o ID do produto a ser removido: ");
                        int id = entrada.nextInt();
                        new ProdutoDAO().removerProduto(id);
                    }
                    break;

                case 3:
                    System.out.println("\n--- MÓDULO PEDIDOS ---");
                    System.out.println("1 - Cadastrar");
                    System.out.println("2 - Remover");
                    System.out.println("");
                     System.out.println("Lembre-se que você deve alterar os parâmetros no codigo antes de efetuar tais processos!!!");
                    int pedOp = entrada.nextInt();
                    entrada.nextLine();

                    if (pedOp == 1) {
                        Pedido ped = new Pedido();
                        ped.setId_Clientes(1);//altere aqui tais informações para ser inseridas no banco de dados 
                        ped.setData_Venda("26/06/2025");//altere aqui tais informações para ser inseridas no banco de dados 
                        ped.setValot_Total(5000.0);//altere aqui tais informações para ser inseridas no banco de dados 
                        ped.setStatus("Fechado");//altere aqui tais informações para ser inseridas no banco de dados 

                        new PedidoDAO().cadastrarUsuario(ped);
                        System.out.println("Pedido cadastrado com sucesso!");
                    } else if (pedOp == 2) {
                        System.out.print("Digite o ID do pedido a ser removido: ");
                        int id = entrada.nextInt();
                        new PedidoDAO().removerPedido(id);
                    }
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
}
