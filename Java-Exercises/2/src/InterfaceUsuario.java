import java.util.Scanner;

/*
 * Classe que trata a interface com o usuário (menu de opções)
 */
public class InterfaceUsuario {

    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;
    private Zoologico zoo;

    /* 
     * Construtor da classe
     */
    public InterfaceUsuario() {
        entrada = new Scanner(System.in);
        zoo = new Zoologico();
    }

    /*
     * Método que trata o loop de exibição e tratamento do menu
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            
            System.out.println("\nDigite sua opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);

        } while (opcao != 5);

        // fecha o objeto Scanner para liberar os seus recursos
        entrada.close();
    }

    /*
     * Método que exibe as opções de menu
     */
    public void exibirMenu() {
        System.out.println("1 - Cadastrar animal");
        System.out.println("2 - Descrever animal");
        System.out.println("3 - Listar animais");        
        System.out.println("4 - Listar animais completo");
        System.out.println("5 - Sair");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarAnimal();
                break;
            case 2:
                descreverAnimal();
                break;
            case 3:
                listarAnimais();
                break;
            case 4:
                listarAnimaisCompleto();
                break;
            case 5:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        // se o usuário não estiver saindo do programa, pede para ele digitar ENTER antes de exibir o menu novamente
        if (opcao != 5) {
            System.out.println("\nDigite ENTER para continuar!");
            entrada.nextLine();
        }
    }

    /*
     * Método auxiliar que obtém uma String do usuário
     */
    private String pedirString(String instrucao) {
        System.out.print(instrucao + ": ");
        String informacao = entrada.nextLine();
        return informacao;
    }

    /*
     * Trata a opção de menu: Cadastrar Animal
     */
    



    private void cadastrarAnimal() {
        // implemente seu código aqui.
        String nome = pedirString("Digite o nome do animal que deseja criar");
        exibirEspecies();
        int tipo = Integer.parseInt(pedirString(""));
        
        
        if(tipo == 1){
            String pelo = pedirString("Digite a cor do Pelo");
            zoo.adicionarTigre(nome,pelo);
        }
        else if(tipo == 2){
            String pelo = pedirString("Digite a cor do Pelo");
            zoo.adicionarChimpanze(nome, pelo);
        }
        else if(tipo == 3){
            zoo.adicionarTucano(nome);
        }
        else if(tipo == 4){
            zoo.adiconarAvestruz(nome);
        }
        else{
            System.out.println("Essa opçao não existe");
        }

    }

    private void exibirEspecies(){
        System.out.println("Digite a especíe do animal que voce deseja criar \n"+
        "1- Tigre \n"+
        "2- Chimpanze\n"+
        "3- Tucano\n"+
        "4- Avestruz"
        );
    }
    

    /*
     * Trata a opção de menu: Descrever Animal
     */
    private void descreverAnimal() {
        // implemente seu código aqui.
        String nome = pedirString("Digite o nome do animal que deseja saber a descrição");
        
        System.out.println(zoo.descricaoCompleta(nome));
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimais() {
        // implemente seu código aqui.
        System.out.println(zoo.descricaoResumidaDoZoo());
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimaisCompleto() {
        // implemente seu código aqui.
        System.out.println(zoo.descricaoCompletaDoZoo());

    }
}