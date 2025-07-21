import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int resp = 0, idade=0 , dependentes=0, objetivo=0, score = 0;
        String nome,perguntaChatbot;
        double renda;
        boolean conversando = true; 

        while (resp != 4) {
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("                            Bem-vindo ao analisador de perfil bancário                                ");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("Selecione o que deseja realizar hoje:");
            System.out.println("1- Analisar seu perfil");
            System.out.println("2- Conversar com o nosso Chatbot personalizado");
            System.out.println("3- Sobre o projeto");
            System.out.println("4- Sair do sistema");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            resp = entrada.nextInt();
    

            switch (resp) {
                case 1:
                    System.out.println("");
                    System.out.println("Digite seu nome:");
                    nome = entrada.next();
                    System.out.println("");
                    System.out.println("Digite sua idade:");
                    idade = entrada.nextInt();
                    System.out.println("");
                    System.out.println("Digite sua renda mensal Bruta:");
                    renda = entrada.nextDouble();
                    System.out.println("");
                    System.out.println("Digite o número de dependentes:");
                    dependentes = entrada.nextInt();
                    System.out.println("");
                    System.out.println("Qual seu objetivo principal?");
                    System.out.println("(1) Segurança");
                    System.out.println("(2) Rendimento equilibrado");
                    System.out.println("(3) Alto risco e alto retorno");
                    objetivo = entrada.nextInt();
                    System.out.println("");

                    if (renda > 5000) score += 40;
                    else if (renda > 3000) score += 30;
                    else if (renda > 1500) score += 20;

                    if (dependentes == 0) score += 20;
                    else if (dependentes == 1) score += 10;

                    if (idade < 30) score += 20;
                    else if (idade < 45) score += 10;

                    if (objetivo == 3) score += 20;
                    else if (objetivo == 2) score += 10;

                    System.out.println("Analisando perfil...");
                    Thread.sleep(1000);
                    System.out.println("");
                    System.out.println("Fazendo as melhores escolhas...");
                    Thread.sleep(1000);
                    System.out.println("");
                    System.out.println("Finalizado!!!");
                    Thread.sleep(1000);
                    System.out.println("");
                    System.out.println("--- Análise do Perfil para " + nome + " ---");
                    System.out.println("Score de perfil: " + score + "/100");
                    System.out.println("");


                    if (objetivo == 3 && renda > 5000 && dependentes < 2) {
                        System.out.println("");
                        System.out.println("Perfil recomendado: Arrojado");
                        System.out.println("Recomendações: Ações, Fundos de Ações (FIA), Fundos Imobiliários (FIIs), BDRs.");
                        System.out.println("Explicação: Foco em alto retorno, combinado com uma boa renda e poucos dependentes \n permite assumir mais riscos em busca de maior retorno a longo ou curto prazo.");
                        System.out.println("");
                    } else if (objetivo == 2 && renda > 3000) {
                        System.out.println("");
                        System.out.println("Perfil recomendado: Moderado");
                        System.out.println("Recomendações: CDBs prefixados ou atrelados ao IPCA, Tesouro IPCA+, Fundos Multimercado.");
                        System.out.println("Explicação: Busca um equilíbrio entre segurança e rentabilidade. \n Devido a sua renda ela permite diversificar para além dos investimentos mais básicos, buscando retornos melhores e mais rentaveis no médio e longo prazo.");
                        System.out.println("");
                    } else { 
                        System.out.println("Perfil recomendado: Conservador");
                        System.out.println("Recomendações: Tesouro Selic, CDB com liquidez diária (100% do CDI), Poupança (para liquidez imediata).");
                        System.out.println("Explicação: A prioridade é a segurança do seu capital, pois é seu objetivo direto e porque sua situação atual de renda ou dependentes exige máxima prudência.");
                        System.out.println("");
                    }
                    System.out.println("Pressione Enter para voltar a tela inicial");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;

                case 2:
                    System.out.println("\n----------------------------------------------------------------------------------------------------------");
                    System.out.println("                                Bem-vindo ao nosso chatbot personalizado                                ");
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    System.out.println("Olá! Eu sou seu assistente virtual. Digite 'sair' a qualquer momento para voltar ao menu principal.");
                    System.out.println("Tente reformular ou pergunte sobre 'taxa', 'abrir conta', 'CDB', 'ações', 'Tesouro Selic'.");
                    
                    entrada.nextLine();
                    while (conversando) {
                        System.out.print("\nVocê: ");
                        perguntaChatbot = entrada.nextLine();
                        String perguntaNormalizada = perguntaChatbot.toLowerCase();

                        if (perguntaNormalizada.equals("sair")) {
                            System.out.println("Chatbot: Ok, voltando ao menu principal...");
                            conversando = false;
                        } else if (perguntaNormalizada.contains("taxa") || perguntaNormalizada.contains("juros") || perguntaNormalizada.contains("emprestimo")) {
                            System.out.println("Chatbot: A taxa de juros para o nosso empréstimo pessoal é de 1.75% ao mês. Para outros produtos, as taxas podem variar.");
                        } else if (perguntaNormalizada.contains("abrir conta") || perguntaNormalizada.contains("criar conta") || perguntaNormalizada.contains("nova conta")) {
                            System.out.println("Chatbot: Para abrir uma conta, acesse o nosso projeto 'Simulador Bancário Completo' e siga as instruções, ou visite uma de nossas agências.");
                        } else if (perguntaNormalizada.contains("rendimento cdb") || perguntaNormalizada.contains("o que é cdb") || perguntaNormalizada.contains("cdb")) {
                            System.out.println("Chatbot: CDB (Certificado de Depósito Bancário) é um investimento de renda fixa onde você empresta dinheiro para o banco e ele devolve após um tempo com juros proporcionais.");
                        } else if (perguntaNormalizada.contains("rendimento acoes") || perguntaNormalizada.contains("o que é acoes") || perguntaNormalizada.contains("acoes")) {
                            System.out.println("Chatbot: Ações representam uma pequena parte do capital social de uma empresa. Você compra essa parte e seu retorno varia com o desempenho da empresa e do mercado.");
                        } else if (perguntaNormalizada.contains("fundos de acoes") || perguntaNormalizada.contains("o que é fia") || perguntaNormalizada.contains("fia")) { 
                            System.out.println("Chatbot: Fundos de Ações (FIA) são fundos de investimento que aplicam a maior parte de seus recursos em ações negociadas em bolsa de valores. O rendimento varia de acordo com o desempenho do fundo.");
                        } else if (perguntaNormalizada.contains("fundos imobiliarios") || perguntaNormalizada.contains("o que é fii") || perguntaNormalizada.contains("fii")) {
                            System.out.println("Chatbot: Fundos Imobiliários (FIIs) são veículos de investimento focados no mercado imobiliário, onde você adquire cotas de um fundo que investe em imóveis ou títulos relacionados. O rendimento varia com o mercado e os aluguéis/vendas.");
                        } else if (perguntaNormalizada.contains("bdr") || perguntaNormalizada.contains("o que é bdr")) {
                            System.out.println("Chatbot: BDRs (Brazilian Depositary Receipts) são títulos emitidos e negociados no Brasil que representam ações de empresas estrangeiras. Permitem investir em empresas de fora sem precisar abrir conta no exterior.");
                        } else if (perguntaNormalizada.contains("ipca") || perguntaNormalizada.contains("inflacao")) {
                            System.out.println("Chatbot: IPCA (Índice de Preços ao Consumidor Amplo) é o índice oficial do governo brasileiro que mede a inflação.");
                        } else if (perguntaNormalizada.contains("tesouro ipca+") || perguntaNormalizada.contains("o que é tesouro ipca+")) {
                            System.out.println("Chatbot: Tesouro IPCA+ é um título público do Tesouro Direto que oferece rentabilidade composta pela variação do IPCA mais uma taxa de juros prefixada. É bom para proteger seu dinheiro da inflação.");
                        } else if (perguntaNormalizada.contains("fundos multimercado") || perguntaNormalizada.contains("o que é fundos multimercado")) {
                            System.out.println("Chatbot: Fundos Multimercado são fundos de investimento que alocam recursos em diferentes mercados (renda fixa, ações, câmbio, etc.), buscando diversificação e potencial de ganhos acima da média.");
                        } else if (perguntaNormalizada.contains("tesouro selic") || perguntaNormalizada.contains("o que é tesouro selic")) {
                            System.out.println("Chatbot: O Tesouro Selic é um título público federal do Tesouro Direto com rentabilidade atrelada à taxa Selic. É considerado um investimento de renda fixa com alta liquidez, ideal para reserva de emergência.");
                        } else if (perguntaNormalizada.contains("liquidez diaria") || perguntaNormalizada.contains("o que é liquidez diaria")) {
                            System.out.println("Chatbot: Liquidez diária refere-se à facilidade e rapidez com que um ativo pode ser convertido em dinheiro, permitindo que o investidor resgate seus recursos a qualquer momento, geralmente com o valor disponível em sua conta no mesmo dia ou no próximo dia útil. ");
                        } else if (perguntaNormalizada.contains("poupanca") || perguntaNormalizada.contains("o que é poupanca")) {
                            System.out.println("Chatbot: Poupança é uma forma de guardar dinheiro no banco de forma segura e com um rendimento pequeno, mas garantido. É um dos investimentos mais populares no Brasil.");
                        } else if (perguntaNormalizada.contains("contato") || perguntaNormalizada.contains("atendente") || perguntaNormalizada.contains("falar com")) {
                            System.out.println("Chatbot: Para falar com um atendente, você pode ligar para (XX) XXXX-XXXX ou enviar um e-mail para atendimento@banco.com.");
                        } else {
                            System.out.println("Não entendi sua pergunta...PorFavor tente reformular ou pergunte sobre 'taxa', 'abrir conta', 'CDB', 'ações', 'Tesouro Selic'.");
                        }
                    }
                    System.out.println("");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.println("");
                    break;
                    
                case 3:
                    System.out.println("");
                    System.out.println("Este é um projeto desenvolvido por mim, Felipe Bastos, como forma de aplicar na prática conhecimentos sobre Java, lógica de programação, e produtos bancários.");
                    System.out.println("O objetivo é simular uma análise de perfil de investimento baseada em dados do usuário, de forma simples e interativa.");
                    System.out.println("Além disso, o sistema conta com um chatbot temático, que responde dúvidas frequentes sobre investimentos e produtos bancários.");
                    System.out.println("Essa aplicação foi criada como parte do meu portfólio acadêmico e está alinhada ao meu interesse em atuar no setor financeiro com foco em tecnologia.");
                    System.out.println("");
                    System.out.println("Pressione Enter para voltar a tela inicial");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;

                case 4:
                    System.out.println("");
                    System.out.println("Encerrando sistema...");
                    entrada.close();
                    break;
                
                default:
                    System.out.println("");
                    System.out.println("Opção inválida! Por favor, escolha uma das opções do menu.");
                    System.out.println("Pressione Enter para voltar a tela inicial");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;
            }
        }
        entrada.close();
    }
}