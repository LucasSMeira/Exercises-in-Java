package iu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

import feed.FeedNoticias;
import feed.Publicacao;

import com.formdev.flatlaf.FlatDarkLaf;

/**
 * Classe criada para implementar a interface gráfica da Rede Social.
 * O objetivo dessa implementação é didático! 
 * - Exercitar e apresentar conceitos de GUIs (Interfaces Gráficas de Usuário) 
 *   e Tratamento de Exceções
 * 
 * @author Julio Cesar Alves
 */
public class TelaRedeSocial {
    // Janela da nossa tela
    private JFrame janela;
    // Caixa de texto para exibir o feed de noticiai    
    private JTextArea areaTextoFeed;    
    // Botão para postar uma mensagem no feed
    private JButton botaoPostarMensagem;
    // Botão para curtir uma mensagem do feed
    private JButton botaoCurtir;
    // Botão para comentar uma mensagem do feed
    private JButton botaoComentar;

    private JButton botaoAtualizar;

    private JScrollPane barraRolagem;

    private JComboBox<String> caixaAutor;

    private boolean carregando;
    
    // Objeto que representa a Regra de Negócios (a lógica da Rede Social em si)
    private FeedNoticias feed;
    
    /**
     * Construtor da classe: cria o feed, os componentes e monta a tela.
    */
    public TelaRedeSocial() {
        feed = new FeedNoticias();
        
        construirJanela();
    }

    /**
     * Constroi os componentes e monta a janela
    */
    private void construirJanela() throws HeadlessException {
        janela = new JFrame("GUI - Rede Social");
        FlatDarkLaf.setup();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        criarComponentes();
        
        montarJanela();
        
    }

    /**
     * Cria os componentes da tela e faz a inscrição nos eventos necessários
     */
    private void criarComponentes() {
        // criando os componentes
        areaTextoFeed = new JTextArea();
        botaoPostarMensagem = new JButton("Postar Mensagem");
        botaoCurtir = new JButton("Curtir");
        botaoComentar = new JButton("Comentar");
        botaoAtualizar = new JButton("Refresh");
        caixaAutor = new JComboBox<>();
        atualizaCaixaAutor();


        barraRolagem = new JScrollPane(areaTextoFeed);
        Font fonte = new Font("Serif", Font.ITALIC, 16);
        areaTextoFeed.setFont(fonte);
        
        // impede que o usuário edite a área de texto do feed
        areaTextoFeed.setEditable(false);
        
        // adiciona o método que tratará o evento de clique no botão Postar Mensagem
        botaoPostarMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postarMensagem();
            }            
        });
        
        // adiciona o método que tratará o evento de clique no botão Curtir
        botaoCurtir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curtirMensagem();
            }
        });

        botaoComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                comentarMensagem();
            }
        });

        botaoAtualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atualizarAreaTextoFeed();
            }
        });

    
      caixaAutor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atualizarAreaTextoFeed();
                if(carregando == false){
                    atualizaCaixaAutor();
                }
            }
        });
     
        
    }

    /**
     * Monta a janela
     */
    private void montarJanela() {
        janela.setSize(500, 600);
        
        janela.setLayout(new BorderLayout());
        

        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout());
        painelSuperior.add(new JLabel("Feed de Notícias"));
        painelSuperior.add(caixaAutor);
        janela.add(painelSuperior, BorderLayout.NORTH);
        
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.add(barraRolagem);
        janela.add(painelCentral, BorderLayout.CENTER);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoPostarMensagem);
        painelBotoes.add(botaoCurtir);
        painelBotoes.add(botaoComentar);
        painelBotoes.add(botaoAtualizar);
        janela.add(painelBotoes, BorderLayout.SOUTH);
    }
    
    /*
     * Exibe a tela da Rede Social
    */
    public void exibir() {
        janela.setVisible(true);
    }
    
    /**
     * Posta uma mensagem no feed. Solicita o autor e a mensagem ao usuário,
     * posta no Feed e atualiza a área de texto de exibição do feed.
     */
    private void postarMensagem() {
        String autor = JOptionPane.showInputDialog("Autor da mensagem");
        // Se o usuário digitou algum autor e confirmou
        if(autor != null) {
            String mensagem = JOptionPane.showInputDialog("Texto da mensagem");
            // Se o usuário digitou alguma mensagem e confirmou
            if (mensagem != null) {
                feed.postarMensagemTexto(autor, mensagem);
                atualizarAreaTextoFeed();        
                atualizaCaixaAutor();
            }
        }
    }
    
    /**
     * Curte uma mensagem. Solicita o identificador da mensagem ao usuário,
     * curte a mensagem e atualiza a área de texto de exibição do feed.
     */
    private void curtirMensagem() {

        int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
        boolean verifica = feed.curtir(idMensagem);
        if(verifica == true){
            feed.curtir(idMensagem);
            atualizarAreaTextoFeed();
        }
        else{
            JOptionPane.showMessageDialog(janela, "id inexistente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }  

    /**
     * Atualiza a área de texto de exibição do Feed.
     */
    private void atualizarAreaTextoFeed() {  
        // Limpa a lista de publicações
        areaTextoFeed.setText("");
        List<Publicacao> publicacoes = null;

        String autorEscolhido = caixaAutor.getItemAt(caixaAutor.getSelectedIndex());

        // Obtém as publicações do feed de notícias
        if(autorEscolhido == "Todos"){
            publicacoes = feed.getPublicacoes();
        }
        else{
            publicacoes = feed.getPublicacaos(autorEscolhido);
        }

        // Percorre a lista de publicações adicionando na área de texto o texto da publicação
        for (Publicacao publicacao : publicacoes) {
            areaTextoFeed.append(publicacao.getTextoExibicao());
        }
    } 
    
    private void comentarMensagem(){
        if(feed.nroMensagens() == 0){
           JOptionPane.showMessageDialog(janela, "Nao existe mensagens", "Erro mensagem ", JOptionPane.ERROR_MESSAGE);
           atualizarAreaTextoFeed();
        }
        else{
            try{
                int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
                String mensagem = JOptionPane.showInputDialog("Texto do Comentário");
                if(mensagem != null){
                    feed.comentar(idMensagem, mensagem);
                    atualizarAreaTextoFeed(); 
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(janela, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                comentarMensagem();
            } 
        }
            

    }


    private void atualizaCaixaAutor(){
        carregando = true;
        caixaAutor.removeAllItems();
        caixaAutor.addItem("Todos");
        List<String> list = feed.listaDeAutores();
        for (String autor : list) {
            caixaAutor.addItem(autor);
        }
        carregando = false;
    }

}
