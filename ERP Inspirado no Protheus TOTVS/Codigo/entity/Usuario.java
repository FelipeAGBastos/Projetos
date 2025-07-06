package entity;

public class Usuario {

    private int codigo;
    private String Nome;
    private String CPF;
    private String Tel;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }
    
    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getTel() {
        return Tel;
    } 

    public void setTel(String tel) {
        Tel = tel;
    }
    
}
