package pckg;
import pckg.controller.UsuarioController;
import pckg.model.UsuarioDao;
import pckg.view.UsuarioView;
import javax.swing.SwingUtilities;


/**
 * Classe Main 
 * @author Rafael S.Lemes
 * @version 1.0
 */
public class Main {
    /**
     * Começa o programa
     * @param args
     */
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                UsuarioDao dao=new UsuarioDao();
                UsuarioView view=new UsuarioView();
                UsuarioController controller=new UsuarioController(dao,view);
                controller.iniciar();
            }
        });
    }
}