package pckg.controller;
import pckg.model.Usuario;
import pckg.model.UsuarioDao;
import pckg.view.UsuarioView;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Classe controller
 * @author Rafael S.Lemes
 * @version 1.0
 */
public class UsuarioController{
    /** Objeto de acesso aos dados */
    private UsuarioDao dao;
    /** Instância da interface gráfica */
    private UsuarioView view;


    /**
     * Construtor
     * Inicializa as dependências e configura os botões da interface com proteção contra falhas.
     * @param dao
     * @param view
     */
    public UsuarioController(UsuarioDao dao,UsuarioView view){
        this.dao=dao;this.view=view;
        // Envolvemos as chamadas em try-catch para garantir que exceções não tratadas não parem a thread do Swing
        this.view.addSalvarListener(e->{try{svUsuario();}catch(Exception ex){tratarErroGeral(ex);}});
        this.view.addExcluirListener(e->{try{rmUsuario();}catch(Exception ex){tratarErroGeral(ex);}});
        this.view.addLimparListener(e->view.limparFormulario());
    }

    /** Inicia o programa carregando os dados iniciais */
    public void iniciar(){
        try{atualizarListaUsuarios();view.setVisible(true);}
        catch(Exception e){tratarErroGeral(e);}
    }
    
    /** Salva um usuário 
     * Captura erros de validação
     */
    private void svUsuario(){
        Usuario usuario=view.getUsuarioDoFormulario();
        if(usuario==null){return;}
        
        try {
            if(usuario.getId()==0){
                dao.addUsuario(usuario);
                view.mostrarMensagem("Usuário adicionado com sucesso :)","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            }else{
                boolean sucesso = dao.attUsuario(usuario);
                if(sucesso){view.mostrarMensagem("Usuario atualizado com sucesso 'v'","Sucesso",JOptionPane.INFORMATION_MESSAGE);}
                else{view.mostrarMensagem("Usuário não encontrado para atualização :(","Erro",JOptionPane.ERROR_MESSAGE);}
            }
            view.limparFormulario();
            atualizarListaUsuarios();
            
        } catch (IllegalArgumentException e) {
            // Captura as validações que criamos no Usuario e UsuarioDao
            view.mostrarMensagem(e.getMessage(), "Regra de Negócio", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /** * Remove um usuário, se válido 
     * Protegido contra erros de conversão de ID
     */
    private void rmUsuario() {
        String idStr = view.getUsuarioIdSelecionado();
        if (idStr.isEmpty()) {view.mostrarMensagem("Selecione um usuário na tabela para excluir.","Aviso",JOptionPane.WARNING_MESSAGE);return;}
        
        try {
            int id=Integer.parseInt(idStr);
            int confirmacao=JOptionPane.showConfirmDialog(view,"Tem certeza que deseja excluir o usuario?","Confirmaçao",JOptionPane.YES_NO_OPTION);
            
            if(confirmacao==JOptionPane.YES_OPTION){
                boolean sucesso=dao.rmUsuario(id);
                if(!sucesso){view.mostrarMensagem("Usuário não encontrado :(","Erro",JOptionPane.ERROR_MESSAGE);}
                view.limparFormulario();
                atualizarListaUsuarios();
            }
        } catch (NumberFormatException e) {
            view.mostrarMensagem("ID inválido para exclusão.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** Atualiza a Lista de usuários na tela */
    private void atualizarListaUsuarios(){List<Usuario>usuarios=dao.listarUsuarios();view.atualizarTabela(usuarios);}

    /** Método auxiliar para erros inesperados (Crash handler) */
    private void tratarErroGeral(Exception e){
        view.mostrarMensagem("Erro inesperado: "+e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // Útil para o desenvolvedor ver o log no terminal
    }
}