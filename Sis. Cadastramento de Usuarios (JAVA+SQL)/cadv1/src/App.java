import DAO.UsuarioDAO;
import entity.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Realizando Cadastramento...");


        Usuario u = new Usuario();
        u.setNome("Maria");
        u.setCPF("333.333.333-33");
        u.setTel("(33)3333-3333");


        new UsuarioDAO().cadastrarUsuario(u);
        
    }
}
