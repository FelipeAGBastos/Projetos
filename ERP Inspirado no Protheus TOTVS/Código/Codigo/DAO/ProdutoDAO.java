package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Produto;

public class ProdutoDAO {

    public void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO ESTOQUEL (TIPO_PRODUTO, UNIDADE_PRODUTO, PREÇO_UNIDADE, DATA_CADASTRO) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, produto.getTipo_produto());
            ps.setInt(2, produto.getUnidade_produto());
            ps.setDouble(3, produto.getPreço_unidade());
            ps.setString(4, produto.getData_cadastro());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar o produto:");
            e.printStackTrace();
        }
    }

    public void removerProduto(int idProduto) {
        String sql = "DELETE FROM ESTOQUEL WHERE id_produto = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idProduto);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Nenhum produto foi removido.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover produto:");
            e.printStackTrace();
        }
    }
}