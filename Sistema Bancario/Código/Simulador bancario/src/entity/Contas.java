package entity;

public class Contas {
   
    
    private int id_conta;
    private int id_usuario;
    private String numero;
    private String agencia;
    private Double saldo;
    private String tipo;
    private String data_criacao; 

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getData_criacao() {
        return data_criacao;
    }
    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }



}
