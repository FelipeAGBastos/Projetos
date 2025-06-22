package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Usuario;

public class UsuarioDAO {

    public void cadastrarUsuario(Usuario usuario){
        
        String sql = "INSERT INTO ESTOQUEL (TIPO_PRODUTO, UNIDADE_PRODUTO, PREÇO_UNIDADE, DATA_CADASTRO) VALUES (?, ?, ?, ?)"; 

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql); 
            ps.setString(1, usuario.getTipo_produto()); 
            ps.setInt(2, usuario.getUnidade_produto()); 
            ps.setDouble(3, usuario.getPreço_unidade()); 
            ps.setString(4, usuario.getData_cadastro()); 

            ps.execute(); 
            ps.close(); 

        
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }
}
