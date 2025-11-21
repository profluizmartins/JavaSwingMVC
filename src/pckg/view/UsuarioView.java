package pckg.view;
import pckg.model.Usuario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Classe de Visualização das coisas
 * @author Rafael S.Lemes
 * @version 1.0
 */
public class UsuarioView extends JFrame{

    /** Tabela de lista*/
    private JTable listagem;
    /** Modelo da tabela de cima ^*/
    private DefaultTableModel listagemM;
    /** Label de ID*/
    private JLabel txtId;
    /** Input pro nome*/
    private JTextField txtNome;
    /** Input pro Email*/
    private JTextField txtEmail;
    private JButton btSalvar;
    private JButton btExcluir;
    private JButton btLimpar;

    /** Cores*/
    Color CE1=new Color(35,30,40);
    Color CE2=new Color(70,60,80);
    Color CEB=new Color(80,70,90);

    /** Construtor da View*/
    public UsuarioView(){
        setTitle("Cadastro de Usuários top d+ :D");
        setSize(600,400);
        getContentPane().setBackground(new Color(55,50,60));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    /** Fontes */
    Font FL=new Font("Tahoma",Font.BOLD,12);
    Font FHL=new Font("Tahoma",Font.BOLD,14);

    /** Inicializador */
    private void initComponents(){
        String[]Colunas={"ID","Nome","Email"};
        listagemM=new DefaultTableModel(Colunas,0){
            @Override
            public boolean isCellEditable(int l,int c){return false;}};
        listagem=new JTable(listagemM);
        listagem.getColumnModel().getColumn(0).setPreferredWidth(1);
        listagem.getColumnModel().getColumn(1).setPreferredWidth(250);
        listagem.getColumnModel().getColumn(2).setPreferredWidth(250);
        listagem.setBackground(CE1);
        listagem.setForeground(new Color(200,200,210));
        listagem.setBorder(BorderFactory.createLineBorder(CEB));
        listagem.setGridColor(CE2);
        listagem.getTableHeader().setForeground(new Color(200,200,210));
        listagem.getTableHeader().setBackground(CE1);
        listagem.getTableHeader().setBorder(BorderFactory.createLineBorder(CEB));
        listagem.getTableHeader().setFont(FHL);
        listagem.setFont(FL);

        JPanel painel=new JPanel(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        painel.setBackground(CE1);
        gbc.insets=new Insets(5,5,5,5);
        gbc.fill=GridBagConstraints.HORIZONTAL;

        gbc.gridx=0;gbc.gridy=0;
        JLabel labelID=new JLabel("ID");labelID.setForeground(new Color(100,100,110));
        painel.add(labelID,gbc);
        gbc.gridx=1;
        txtId=new JLabel();txtId.setFont(FL);
        txtId.setEnabled(false);
        painel.add(txtId,gbc);

        gbc.gridx=0;gbc.gridy=1;
        JLabel labelNO=new JLabel("NOME");labelNO.setForeground(new Color(200,200,210));
        painel.add(labelNO,gbc);
        gbc.gridx=1;
        txtNome=new JTextField(20);txtNome.setFont(FL);
        painel.add(txtNome,gbc);

        gbc.gridx=0;gbc.gridy=2;
        JLabel labelEM=new JLabel("EMAIL");labelEM.setForeground(new Color(200,200,210));
        painel.add(labelEM,gbc);
        gbc.gridx=1;
        txtEmail=new JTextField(20);txtEmail.setFont(FL);
        painel.add(txtEmail,gbc);

        JPanel painelBT=new JPanel();
        painelBT.setBackground(CE1);
        btSalvar=new JButton("Salvar");
        btExcluir=new JButton("Excluir");
        btLimpar=new JButton("Limpar");
        painelBT.add(btSalvar);
        painelBT.add(btExcluir);
        painelBT.add(btLimpar);

        JScrollPane painelSL=new JScrollPane(listagem);
        painelSL.getViewport().setBackground(new Color(50,45,55)); 
        painelSL.setBorder(BorderFactory.createLineBorder(CEB));
        add(painelSL,BorderLayout.CENTER);
        
        JPanel painelA=new JPanel(new BorderLayout());
        painelA.setBackground(CE1);
        painelA.add(painel,BorderLayout.CENTER);
        painelA.add(painelBT,BorderLayout.SOUTH);
        
        add(painelA,BorderLayout.SOUTH);

        listagem.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int linha=listagem.getSelectedRow();
                if(linha>=0){
                    txtId.setText(listagemM.getValueAt(linha,0).toString());
                    txtNome.setText(listagemM.getValueAt(linha,1).toString());
                    txtEmail.setText(listagemM.getValueAt(linha,2).toString());
                }
            }
        });
    }

    /**
     * Atualiza a tabela
     * @param usuarios
     */
    public void atualizarTabela(List<Usuario>usuarios) {
        listagemM.setRowCount(0);
        for(Usuario u:usuarios){
            listagemM.addRow(new Object[]{u.getId(),u.getNome(),u.getEmail()});
        }
    }
    
    /**
     * Coleta e valida os dados do formulário.
     * @return Um objeto Usuário se válido, ou null se houver erro
     */
    public Usuario getUsuarioDoFormulario() {
        int id=0;
        try{
            if(!txtId.getText().isEmpty()){id=Integer.parseInt(txtId.getText());}
        }catch(NumberFormatException e){
            mostrarMensagem("Erro: ID inválido ou corrompido.","Erro Interno",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String nome=txtNome.getText();
        String email=txtEmail.getText();
        
        if(nome.trim().isEmpty()||email.trim().isEmpty()){
            mostrarMensagem("Nome e E-mail são obrigatórios.","Erro de Validação",JOptionPane.ERROR_MESSAGE);
            return null;}
        if(!email.contains("@")){
            mostrarMensagem("O e-mail informado é inválido(deve conter '@').","Erro de Validaçao",JOptionPane.ERROR_MESSAGE);
            return null;}
        return new Usuario(id, nome, email);
    }
    
    /**
     * Lê o texto de ID
     * @return String contendo o ID
     */
    public String getUsuarioIdSelecionado() {
        return txtId.getText();
    }

    /** Limpa os campos do formulário*/
    public void limparFormulario() {
        txtId.setText("");txtNome.setText("");txtEmail.setText("");listagem.clearSelection();
    }

    /**
     * Mostra uma Mensagem
     * @param mensagem O texto da mensagem
     * @param titulo O título da janela
     * @param tipo O tipo de ícone (erro, informação, aviso)
     */
    public void mostrarMensagem(String mensagem,String titulo,int tipo){
        JOptionPane.showMessageDialog(this,mensagem,titulo,tipo);}

    /** Adiciona um ouvinte de eventos pro botão Salvar *@param listener A ação padrão */
    public void addSalvarListener(ActionListener listener){btSalvar.addActionListener(listener);}
    /** Adiciona um ouvinte de eventos pro botão Excluir *@param listener A ação padrão */
    public void addExcluirListener(ActionListener listener){btExcluir.addActionListener(listener);}
    /** Adiciona um ouvinte de eventos pro botão Limpar *@param listener A ação padrão */
    public void addLimparListener(ActionListener listener){btLimpar.addActionListener(listener);}
}