package entity;

public class Usuario {

    private int id_produto;
    private String Tipo_produto;
    private int Unidade_produto;
    private double Preço_unidade;
    private String Data_cadastro;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getTipo_produto() {
        return Tipo_produto;
    }

    public void setTipo_produto(String tipo_produto) {
        Tipo_produto = tipo_produto;
    }

    public int getUnidade_produto() {
        return Unidade_produto;
    }

    public void setUnidade_produto(int unidade_produto) {
        Unidade_produto = unidade_produto;
    }

    public double getPreço_unidade() {
        return Preço_unidade;
    }

    public void setPreço_unidade(double preço_unidade) {
        Preço_unidade = preço_unidade;
    }

    public String getData_cadastro() {
        return Data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        Data_cadastro = data_cadastro;
    }
    

    
}
