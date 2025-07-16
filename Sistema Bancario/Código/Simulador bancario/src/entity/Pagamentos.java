package entity;

public class Pagamentos {


    private int id_Pagamento;
    private int id_conta;
    private String descricao;
    private Double valor;
    private String data_pagamento;

    public int getId_Pagamento() {
        return id_Pagamento;
    }

    public void setId_Pagamento(int id_Pagamento) {
        this.id_Pagamento = id_Pagamento;
    }

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
