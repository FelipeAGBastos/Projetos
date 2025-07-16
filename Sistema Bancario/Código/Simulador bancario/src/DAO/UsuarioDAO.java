package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Usuario;

public class UsuarioDAO {


    public void cadastrarUsuario(Usuario usuario){

        String sql = "INSERT INTO usuarios (NOME, LOGIN, SENHA ) VALUES (?, ?, ?)";


        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());


            ps.execute();
            ps.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void removerUsuario(int id_usuario){
        String sql = " DELET FROM usuarios WHERE id_usuario = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id_usuario);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Usuario removido com sucesso!");
            } else {
                System.out.println("Nenhum Usuario foi removido. Verifique o ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover Usuario:");
            e.printStackTrace();
        }


    }
    

    public boolean verificarAcesso(String login, String senha) {
    String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setString(1, login);
        ps.setString(2, senha);

        ResultSet rs = ps.executeQuery();
        return rs.next(); 

    } catch (SQLException e) {
        System.out.println("Erro ao verificar acesso:");
        e.printStackTrace();
        return false;
    }
    }



    


    

}


