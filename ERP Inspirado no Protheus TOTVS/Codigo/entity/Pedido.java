package entity;

public class Pedido {

    private int id_Pedidos;
    private  int id_Clientes ;
    private String data_Venda;
    private double valot_Total;
    private String status;

    public int getId_Pedidos() {
        return id_Pedidos;
    }

    public void setId_Pedidos(int id_Pedidos) {
        this.id_Pedidos = id_Pedidos;
    }

    public int getId_Clientes() {
        return id_Clientes;
    }

    public void setId_Clientes(int id_Clientes) {
        this.id_Clientes = id_Clientes;
    }

    public String getData_Venda() {
        return data_Venda;
    }

    public void setData_Venda(String data_Venda) {
        this.data_Venda = data_Venda;
    }

    public double getValot_Total() {
        return valot_Total;
    }
    public void setValot_Total(double valot_Total) {
        this.valot_Total = valot_Total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
