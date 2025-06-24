import java.util.Scanner;

import DAO.ProdutoDAO;
import entity.Produto;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);

        int resp=0;
        String altCad;

        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                            Bem-vindo ao nosso sistema  de gestão                                    ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.err.println("Você deseja realizar um cadastramento ou uma remoção?.");
        System.out.println("Digite 1 para cadastramento e 2 para remover algum produto do nosso estoque.");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        resp = entrada.nextInt();
        entrada.nextLine(); 

        if (resp == 1 ) {
            System.out.println("");
            System.out.println("");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.println("Antes de iniciarmos o cadastramento é bom salientar que o usuario deve alterar as informações do produto em app.java.");
            System.out.println("Voçê ja fez essa alteração?(Sim/Não).");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            altCad = entrada.nextLine().toUpperCase();
            if (altCad.equalsIgnoreCase("SIM")) {
                
                Produto u = new Produto();
                u.setTipo_produto("Pulsaaaeira");
                u.setUnidade_produto(200);
                u.setPreço_unidade(4.70);
                u.setData_cadastro("21/06/2025");
                new ProdutoDAO().cadastrarUsuario(u);
                System.out.println("");
                System.out.println("");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("Iniciando cadastramento...");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
                System.out.println("");
            } else{
                System.out.println("");
                System.out.println("");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("Porfavor, faça as alterações e reinicie o codigo");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
            }

        } else { 
            if (resp == 2) {
                System.out.println("");
                System.out.println("");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                 System.out.println("Antes de iniciarmos a remoção é bom salientar que o usuario deve alterar as informações do produto em app.java.");
                 System.out.println("Voçê ja fez essa alteração?(Sim/Não).");
                 System.out.println("---------------------------------------------------------------------------------------------------------------------");
                altCad = entrada.nextLine().toUpperCase();

                if (altCad.equalsIgnoreCase("SIM")) {
                    
                  System.out.println("");
                  System.out.println("");
                  System.out.println("---------------------------------------------------------------------------------------------------------------------");  
                  System.out.println("Iniciando remoção do produto...");
                  System.out.println("---------------------------------------------------------------------------------------------------------------------");
                  System.out.println("");
                  System.out.println("");
                  ProdutoDAO dao = new ProdutoDAO();
                  dao.removerProduto(7); // Troque "0" pelo ID que você quer remover no banco de dados
                    
                } else{
                    System.out.println("Porfavor, faça as alterações e reinicie o codigo.");
            
                }
            }
        }

        entrada.close();
    }
}
