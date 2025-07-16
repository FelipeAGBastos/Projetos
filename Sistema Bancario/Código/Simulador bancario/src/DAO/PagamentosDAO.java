package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Pagamentos;


public class PagamentosDAO {



    public void cadastrarPagamento(Pagamentos pagamento){

        String sql = "INSERT INTO pagamentos (ID_CONTA, DESCRICAO, VALOR) VALUES (?, ?, ?)";


        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, pagamento.getId_conta());
            ps.setString(2, pagamento.getDescricao());
            ps.setDouble(3, pagamento.getValor());


            ps.execute();
            ps.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

   








    
}
