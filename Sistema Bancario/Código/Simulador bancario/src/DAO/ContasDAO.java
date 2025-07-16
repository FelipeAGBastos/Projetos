package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Contas;

public class ContasDAO {

    public void cadastrarConta(Contas contas) {
        String sql = "INSERT INTO contas (ID_USUARIO, NUMERO, AGENCIA, SALDO, TIPO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, contas.getId_usuario());
            ps.setString(2, contas.getNumero());
            ps.setString(3, contas.getAgencia());
            ps.setDouble(4, contas.getSaldo());
            ps.setString(5, contas.getTipo());

            ps.executeUpdate();
            System.out.println("Conta cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar conta:");
            e.printStackTrace();
        }
    }

    public void removerConta(int id_conta) {
        String sql = "DELETE FROM contas WHERE id_conta = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id_conta);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Conta removida com sucesso!");
            } else {
                System.out.println("Nenhuma conta foi removida. Verifique o ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover conta:");
            e.printStackTrace();
        }
    }

    public void sacar(int id_conta, double valor) {
        String sql = "UPDATE contas SET saldo = saldo - ? WHERE id_conta = ? AND saldo >= ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setDouble(1, valor);
            ps.setInt(2, id_conta);
            ps.setDouble(3, valor);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente ou conta não encontrada.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao realizar saque:");
            e.printStackTrace();
        }
    }

    public void depositar(int id_conta, double valor) {
        String sql = "UPDATE contas SET saldo = saldo + ? WHERE id_conta = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setDouble(1, valor);
            ps.setInt(2, id_conta);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Depósito realizado com sucesso!");
            } else {
                System.out.println("Conta não encontrada.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao realizar depósito:");
            e.printStackTrace();
        }
    }

    public void mostrarSaldo(int id_conta) {
        String sql = "SELECT saldo FROM contas WHERE id_conta = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id_conta);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    double saldo = rs.getDouble("saldo");
                    System.out.println("Saldo atual: R$ " + saldo);
                } else {
                    System.out.println("Conta não encontrada.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar saldo:");
            e.printStackTrace();
        }
    }
}
