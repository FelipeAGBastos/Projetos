package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Pedido;

public class PedidoDAO {

    public void cadastrarUsuario(Pedido usuario){
        
        String sql = "INSERT INTO PEDIDOS (ID_CLIENTE, DATA_VENDA, VALOR_TOTAL, STATUS) VALUES (?, ?, ?, ?)"; 

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql); 
            ps.setInt(1, usuario.getId_Clientes()); 
            ps.setString(2, usuario.getData_Venda()); 
            ps.setDouble(3, usuario.getValot_Total()); 
            ps.setString(4, usuario.getStatus()); 

            ps.execute(); 
            System.out.println("Pedido cadastrado com sucesso!");
            ps.close(); 
            
        
        } catch (SQLException e) { 
            System.out.println("");
            System.out.println("Erro ao adicionar o pedido:");
            e.printStackTrace(); 
        }
    }

    public void removerPedido(int id_Pedidos){
        String sql = "DELETE FROM PEDIDOS WHERE ID_PEDIDO = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id_Pedidos);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("");
                System.out.println("Pedido removido com sucesso!");
            } else {
                System.out.println("");
                System.out.println("Nenhum pedido foi removido. Verifique o ID.");
            }

        } catch (SQLException e) {
            System.out.println("");
            System.out.println("Erro ao remover pedido:");
            e.printStackTrace();
        }
        


    }














}


