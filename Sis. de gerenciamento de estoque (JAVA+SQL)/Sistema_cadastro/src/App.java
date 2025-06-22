import DAO.UsuarioDAO;
import entity.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando cadastramento...");

        Usuario u = new Usuario();
        u.setTipo_produto("Pulseira");
        u.setUnidade_produto(200);
        u.setPreço_unidade(4.70);
        u.setData_cadastro("21/06/2025");

        
        new UsuarioDAO().cadastrarUsuario(u);
    
    }
}
