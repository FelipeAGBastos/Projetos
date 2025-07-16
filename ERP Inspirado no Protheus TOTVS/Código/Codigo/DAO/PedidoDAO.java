package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Pedido;

public class PedidoDAO {

    public void cadastrarPedido(Pedido pedido) {
        String sql = "INSERT INTO PEDIDOS (ID_CLIENTE, DATA_VENDA, VALOR_TOTAL, STATUS) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, pedido.getId_Clientes());
            ps.setString(2, pedido.getData_Venda());
            ps.setDouble(3, pedido.getValot_Total());
            ps.setString(4, pedido.getStatus());

            ps.execute();
            System.out.println("Pedido cadastrado com sucesso!");
            ps.close();

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar o pedido:");
            e.printStackTrace();
        }
    }

    public void removerPedido(int id_Pedidos) {
        String sql = "DELETE FROM pedidos WHERE id_Pedidos = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id_Pedidos);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Pedido removido com sucesso!");
            } else {
                System.out.println("Nenhum pedido foi removido. Verifique o ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover pedido:");
            e.printStackTrace();
        }
    }
}
