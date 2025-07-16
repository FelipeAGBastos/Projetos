package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Usuario;

public class UsuarioDAO {

    public void cadastrarUsuario(Usuario usuario) {

        String sql = "INSERT INTO USUARIO_CAD (NOME, CPF ,TEL ) VALUES (?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCPF());
            ps.setString(3, usuario.getTel());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerUsuario(int idUsuario) {
        String sql = "DELETE FROM USUARIO_CAD WHERE id = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idUsuario);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário removido com sucesso!");
            } else {
                System.out.println("Nenhum usuário foi removido. Verifique o ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover usuário:");
            e.printStackTrace();
        }
    }
}
