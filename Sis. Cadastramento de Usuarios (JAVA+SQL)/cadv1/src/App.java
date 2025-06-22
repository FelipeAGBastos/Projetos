import DAO.UsuarioDAO;
import entity.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


       

        Usuario u = new Usuario();
        u.setNome("Paulo");
        u.setCPF("222.222.222-22");
        u.setTel("(22)2222-2222");


        new UsuarioDAO().cadastrarUsuario(u);
        


    }
}
