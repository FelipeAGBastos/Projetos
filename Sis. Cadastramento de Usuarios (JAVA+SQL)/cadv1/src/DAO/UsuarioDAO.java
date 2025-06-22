package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Usuario;

public class UsuarioDAO{

    public void cadastrarUsuario(Usuario usuario){

        
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        


    }
}
