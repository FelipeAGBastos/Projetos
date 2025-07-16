import DAO.UsuarioDAO;
import entity.Pagamentos;
import entity.Usuario;
import DAO.PagamentosDAO;
import entity.Contas;
import DAO.ContasDAO;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int resp = 0;
        String login, senha, possuiConta, nomeUsuario, loginUsuario, senhaUsuario;
        boolean autenticaLogin = false;

        UsuarioDAO x = new UsuarioDAO();

        System.out.println("--------------------------------------------------------------------");
        System.out.println("                       SISTEMA BANCÁRIO                             ");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Você já possui uma conta conosco? (SIM/NÃO)");
        possuiConta = entrada.next();

        if (possuiConta.equalsIgnoreCase("NÃO")) {
            System.out.println("");
            System.out.println("");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("                          CRIAR CONTA                               ");
            System.out.println("--------------------------------------------------------------------");

            Usuario h = new Usuario();
            System.out.print("Digite seu nome: ");
            nomeUsuario = entrada.next();
            h.setNome(nomeUsuario);

            System.out.print("Digite qual será seu login: ");
            loginUsuario = entrada.next();
            h.setLogin(loginUsuario);

            System.out.print("Digite sua senha: ");
            senhaUsuario = entrada.next();
            h.setSenha(senhaUsuario);

            x.cadastrarUsuario(h);

            System.out.println("Conta criada com sucesso! Agora faça login.");
        }

        // Tela de Login
        while (!autenticaLogin) {
            System.out.println("");
            System.out.println("");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("                       TELA DE LOGIN                                ");
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Login: ");
            login = entrada.next();
            System.out.print("Senha: ");
            senha = entrada.next();

            if (x.verificarAcesso(login, senha)) {
                autenticaLogin = true;
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Login ou senha incorretos. Tente novamente.");
            }
        }

        while (true) {
            System.out.println("");
            System.out.println("");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("                BEM-VINDO AO NOSSO SISTEMA BANCÁRIO                 ");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("1 - Conta");
            System.out.println("2 - Pagamento");
            System.out.println("3 - Sobre");
            System.out.println("4 - Simulador de Investimentos");
            System.out.println("5 - Sair");
            System.out.println("------------------------------------------------------------------");
            System.out.print("Escolha: ");

            resp = entrada.nextInt();

            switch (resp) {
                case 1:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("                            MÓDULO CONTA                          ");
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("1 - Criar conta");
                    System.out.println("2 - Remover conta");
                    System.out.println("3 - Sacar");
                    System.out.println("4 - Depositar");
                    System.out.println("5 - Mostrar saldo");
                    System.out.println("6 - Voltar");
                    System.out.println("------------------------------------------------------------------");
                    System.out.print("Escolha: ");
                    int respCon = entrada.nextInt();

                    if (respCon == 1) {
                        Contas c = new Contas();
                        System.out.print("Digite o ID do usuário: ");
                        c.setId_usuario(entrada.nextInt());

                        entrada.nextLine();
                        System.out.print("Digite o número da conta: ");
                        c.setNumero(entrada.nextLine());

                        System.out.print("Digite a agência: ");
                        c.setAgencia(entrada.nextLine());

                        System.out.print("Digite o saldo inicial: ");
                        c.setSaldo(entrada.nextDouble());

                        System.out.println("Tipo de conta:");
                        System.out.println("1 - Conta Corrente");
                        System.out.println("2 - Poupança");
                        int tipoConta = entrada.nextInt();

                        if (tipoConta == 1) {
                            c.setTipo("Conta Corrente");
                        } else if (tipoConta == 2) {
                            c.setTipo("Poupança");
                        } else {
                            System.out.println("Tipo inválido.");
                            break;
                        }

                        new ContasDAO().cadastrarConta(c);
                        System.out.println("Conta cadastrada com sucesso!");

                    } else if (respCon == 2) {
                        System.out.print("Digite o ID da conta para remover: ");
                        int idRemover = entrada.nextInt();
                        new ContasDAO().removerConta(idRemover);
                        System.out.println("Conta removida com sucesso!");

                    } else if (respCon == 3) {
                        System.out.print("ID da conta para saque: ");
                        int id = entrada.nextInt();
                        System.out.print("Valor: ");
                        double valor = entrada.nextDouble();
                        new ContasDAO().sacar(id, valor);

                    } else if (respCon == 4) {
                        System.out.print("ID da conta para depósito: ");
                        int id = entrada.nextInt();
                        System.out.print("Valor: ");
                        double valor = entrada.nextDouble();
                        new ContasDAO().depositar(id, valor);

                    } else if (respCon == 5) {
                        System.out.print("ID da conta: ");
                        int id = entrada.nextInt();
                        new ContasDAO().mostrarSaldo(id);

                    } else if (respCon == 6) {
                        break;

                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("\n------------------------------------------------------------------");
                    System.out.println("                            MÓDULO PAGAMENTO                      ");
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("1 - Pagar conta");
                    System.out.println("2 - Ver histórico (Em breve)");
                    System.out.println("3 - Voltar");
                    System.out.print("Escolha: ");
                    int resPag = entrada.nextInt();

                    if (resPag == 1) {
                        Pagamentos g = new Pagamentos();

                        System.out.print("Digite o ID da conta: ");
                        g.setId_conta(entrada.nextInt());

                        entrada.nextLine();
                        System.out.print("Descrição: ");
                        g.setDescricao(entrada.nextLine());

                        System.out.print("Valor: ");
                        g.setValor(entrada.nextDouble());

                        new PagamentosDAO().cadastrarPagamento(g);
                        System.out.println("Pagamento registrado com sucesso!");

                    } else if (resPag == 2) {
                        System.out.println("\nFunção ainda não disponível... Aguarde atualizações\n");
                        System.out.println("Pressione Enter para voltar.");
                        entrada.nextLine();
                        entrada.nextLine();

                    } else if (resPag == 3) {
                        break;

                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("\n------------------------------------------------------------------");
                    System.out.println("                            SOBRE O SISTEMA                       ");
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Projeto desenvolvido em Java + MySQL como parte de um portfólio voltado ao setor bancário.");
                    System.out.println("Simula funcionalidades reais de bancos como movimentações, pagamentos e consultas.");
                    System.out.println("Idealizado para demonstração de lógica, JDBC, POO e organização de código.");
                    System.out.println("Feito por Felipe Bastos, voltado a oportunidades de estágio em tecnologia financeira.");
                    break;

                case 4:
                    System.out.println("\n------------------------------------------------------------------");
                    System.out.println("                    SIMULADOR DE INVESTIMENTOS                    ");
                    System.out.println("------------------------------------------------------------------");
                    System.out.print("Digite o valor a ser investido: R$ ");
                    double valorInvestido = entrada.nextDouble();

                    System.out.print("Digite a taxa de juros mensal (%): ");
                    double taxa = entrada.nextDouble() / 100;

                    System.out.print("Digite o tempo em meses: ");
                    int meses = entrada.nextInt();

                    double montante = valorInvestido * Math.pow((1 + taxa), meses);

                    System.out.printf("\nAo final de %d meses, seu investimento será de: R$ %.2f\n\n", meses, montante);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

                case 5:
                    System.out.println("Encerrando o sistema...");
                    entrada.close();
                    return;    
            }
        }
    }
}
