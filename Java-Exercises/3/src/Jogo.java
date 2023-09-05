/**
 * Essa é a classe principal da aplicacao "World of Zull".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser 
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os ambientes, 
 * cria o analisador e começa o jogo. Ela também avalia e  executa os comandos que 
 * o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */

public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;

    private Personagem personagem;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo()  {
        criarAmbientes();
        analisador = new Analisador();
        personagem= new Personagem("Guts");
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente casteloFalconia,casaDoGodot,ilhaDosElfos,esconderijoDosBakirakas,portoDeVitrannis;
        Item dragonSlayer = new Item("DragonSlayer", "Era grande demais para ser chamada de espada. Enorme, grosso, pesado e muito áspero. Na verdade, era um monte de ferro bruto");
        Item berserkerArmor = new Item("BerserkerArmor", "A Berserker Armor é uma armadura corporal altamente durável. Os usuários da armadura são apropriadamente chamados de berserkers, devido à força sobre-humana e ferocidade desumana que recebem.");
        Item behelit = new Item("Behelit","são objetos de pedra altamente espirituais que atuam como chaves que ligam uma camada profunda do Mundo Astral ao Mundo Físico. Diz-se que eles governam o destino da humanidade. Eles são usado principalmente para invocar a Mão de Deus. O Beherit Carmesim é único entre os beherits, aparecendo apenas para indivíduos qualificados para renascer como parente da Mão de Deus.");
      
        // cria os ambientes
        casteloFalconia = new Ambiente("A capital de Midland, situada perto da base da World Spiral Tree, no topo da terra onde Wyndham ficava. A cidade surge como se do ar após o Grande Rugido do Mundo Astral, e diz-se que serve como o único refúgio seguro para a humanidade em Fantasia. ",behelit);
        casaDoGodot = new Ambiente("A antiga casa que Guts frequentava o dono era Godot o melhor ferreiro de toda a MidLand e criador da Dragon Slayer ",dragonSlayer);
        ilhaDosElfos = new Ambiente("O lar dos elfos, um reino paradisíaco localizado na ilha de Skellig no Mar Ocidental. Como a mansão da árvore espiritual de Flora, ela ficava em um interstício antes do Grande Rugido do Mundo Astral.Muitos feiticeiros e bruxas residem em uma aldeia dentro da fronteira do domínio, vivendo ao lado dos elfos e seu governante, o Flower Storm Monarch, com uma variedade de outras criaturas místicas ",berserkerArmor);
        esconderijoDosBakirakas = new Ambiente("A aldeia escondida em terras inexpugnáveis, os aldeões são todos guerreiros treinados em golpes letais, e nem mesmo os espíritos podem se aproximar ");
        portoDeVitrannis = new Ambiente("O porto da cidade portuária de Vritanis, tornou-se uma guarnição para a Ordem Religiosa de Santa Fé e seus exércitos aliados. Consequentemente, também é um reduto de vários nobres proeminentes do continente, e na casa da prestigiosa Família Vandimion. ");
        
        // inicializa as saidas dos ambientes
        ilhaDosElfos.ajustarSaida("oeste",portoDeVitrannis);
        portoDeVitrannis.ajustarSaida("norte",esconderijoDosBakirakas);
        portoDeVitrannis.ajustarSaida("leste",ilhaDosElfos);
        portoDeVitrannis.ajustarSaida("oeste",casteloFalconia);
        esconderijoDosBakirakas.ajustarSaida("sul",portoDeVitrannis);
        esconderijoDosBakirakas.ajustarSaida("oeste",casaDoGodot);
        casaDoGodot.ajustarSaida("leste",esconderijoDosBakirakas);
        casaDoGodot.ajustarSaida("sul",casteloFalconia);
        casteloFalconia.ajustarSaida("norte",casaDoGodot);
        casteloFalconia.ajustarSaida("leste",portoDeVitrannis);

        ambienteAtual = ilhaDosElfos;  // o jogo comeca na ilha dos elfos
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar()  {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e 
        // os executamos até o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo a Berserker!");
        System.out.println("Berserker eh um novo jogo de aventura,que é baseado no Manga Berserker,voce terá a oportunidade de salvar a Caska do terrível Griffith(Femto).");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        exibirLocalizacaoAtual();    
    }

    public void exibirLocalizacaoAtual(){
        System.out.println("Voce esta  " + ambienteAtual.getDescricao());
    
        exibirSaidas();
    }

    public void exibirSaidas(){
        System.out.println("As possíveis saídas são para: ");
        System.out.println(ambienteAtual.direcoesDeSaida());
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando)  {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if(palavraDeComando.equals("observar")){
            observar();
        }
        else if(palavraDeComando.equals("pegar")){
            pegarUmItem(comando);
        }
        else if(palavraDeComando.equals("inventario")){
            exibirInventario();
        }

        return querSair;
    }

    public void pegarUmItem(Comando comando){
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Pegar o que ?");
            return;
        }

        String itemVerifica = comando.getSegundaPalavra();
        Item item = ambienteAtual.retornaItem(itemVerifica);
        
        if(item != null){    
            personagem.adicionarArma(item); 
            ambienteAtual.pegarItem();
            System.out.println("Parabens voce pegou o item");
        }
        else{
            System.out.println("Não existe esse item no ambiente");
        }
    }

    
    public void observar(){
        System.out.println(ambienteAtual.getDescricaoLonga());
        exibirSaidas();
    }

    public void exibirInventario(){
        System.out.println(personagem.exibiItens());
    }


    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de  palavras de comando
     */
    private void imprimirAjuda()  { 
        System.out.println("Voce esta perdido,sozinho e machucado");
        System.out.println("por MidLand");
        System.out.println("Suas palavras de comando sao:"); 
        System.out.println( analisador.exibirPalavrasDeComando());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente, 
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando)  {
        
        // se não há segunda palavra, não sabemos pra onde ir...
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        proximoAmbiente = ambienteAtual.getSaida(direcao);
        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        }
        else {
            ambienteAtual = proximoAmbiente;
            
            exibirLocalizacaoAtual();
        }
    }

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos 
     * realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando)  {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nós realmente queremos sair
        }
    }
}
