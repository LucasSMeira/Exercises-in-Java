
import java.util.HashMap;


public class Zoologico {
    /*
    private HashMap<String,Tigre> tigres;
    private HashMap<String,Chimpanze> chimpanzes;
    private HashMap<String,Tucano> tucanos;
    private HashMap<String,Avestruz> avestruzes; 


    public Zoologico(){
        tigres = new HashMap<>();
        chimpanzes = new HashMap<>();
        tucanos = new HashMap<>();
        avestruzes = new HashMap<>();
    }

    public void adicionarTigre(String nome, String corDoPelo){
        Tigre tigre = new Tigre(nome,corDoPelo); 
        tigres.put(nome, tigre);

    }

    public void adicionarChimpanze(String nome, String corDoPelo){
        Chimpanze chimpanze = new Chimpanze(nome, corDoPelo);
        chimpanzes.put(nome,chimpanze);
    }

    public void adicionarTucano(String nome){
        Tucano tucano = new Tucano(nome);
        tucanos.put(nome, tucano);
    }

    public void adiconarAvestruz(String nome){
        Avestruz avestruz = new Avestruz(nome);
        avestruzes.put(nome, avestruz);
    }
     * 
     *    public String descricaoCompleta(String nome){
        String descricao = "";
        if(tigres.get(nome) != null){
            descricao += tigres.get(nome).descricaoCompleta();
        }
        else if(chimpanzes.get(nome) != null){
            descricao += chimpanzes.get(nome).descricaoCompleta();
        }
        else if(tucanos.get(nome) != null){
            descricao +=  tucanos.get(nome).descricaoCompleta();
        }
        else if(avestruzes.get(nome) != null){
            descricao +=  avestruzes.get(nome).descricaoCompleta();
        }
        else{
            descricao = "Animal não existe no Zoo";
        }
        return descricao;
    }

    public String descricaoResumidaDoZoo(){
        String descricaoResumida = "";
       Dúvida  nesse for entramos com a chave e valor do hashmap e pelos testes
       o valor deu o mesmo , usar esse for é "matar uma barata com um canhão " ?
        
        for (HashMap.Entry<String, Tigre> tigre: tigres.entrySet()) {
            descricaoResumida += tigre.getValue().descricao();
        }
        
        

        for (String tigre: tigres.keySet()) {
            descricaoResumida += tigres.get(tigre).descricao();
        }
        for (String chimpanze: chimpanzes.keySet()) {
            descricaoResumida += chimpanzes.get(chimpanze).descricao();
        }
        for (String tucano: tucanos.keySet()) {
            descricaoResumida += tucanos.get(tucano).descricao();
        }
        for (String avestruz: avestruzes.keySet()) {
            descricaoResumida += avestruzes.get(avestruz).descricao();
        }
    
        return descricaoResumida;
    }


    public String descricaoCompletaDoZoo(){
       String descricaoCompleta = "";     
        for (String tigre: tigres.keySet()) {
            descricaoCompleta += tigres.get(tigre).descricaoCompleta();
        }
        for (String chimpanze: chimpanzes.keySet()) {
            descricaoCompleta += chimpanzes.get(chimpanze).descricaoCompleta();
        }
        for (String tucano: tucanos.keySet()) {
            descricaoCompleta += tucanos.get(tucano).descricaoCompleta();
        }
        for (String avestruz: avestruzes.keySet()) {
            descricaoCompleta += avestruzes.get(avestruz).descricaoCompleta();
        }

        return descricaoCompleta;
    }
     * 
     * 
     * 
     */



    private HashMap<String,Animal> animais;

    public Zoologico(){
        animais = new HashMap<>();
    }

    public void adicionarTigre(String nome, String corDoPelo){
        Tigre tigre = new Tigre(nome,corDoPelo); 
        animais.put(nome, tigre);
    }

    public void adicionarChimpanze(String nome, String corDoPelo){
        Chimpanze chimpanze = new Chimpanze(nome, corDoPelo);
        animais.put(nome,chimpanze);
    }

    public void adicionarTucano(String nome){
        Tucano tucano = new Tucano(nome);
        animais.put(nome, tucano);
    }

    public void adiconarAvestruz(String nome){
        Avestruz avestruz = new Avestruz(nome);
        animais.put(nome, avestruz);
    }

    public String descricaoCompleta(String nome){
        String descricao = "";
        if(animais.get(nome) != null){
            descricao += animais.get(nome).descricaoCompleta();
        }
        else{
            descricao = "Animal não existe no Zoo";
        }
        return descricao;
    }

    public String descricaoResumidaDoZoo(){
        String descricaoResumida = "";    

        for (String animal: animais.keySet()) {
            descricaoResumida += animais.get(animal).descricao() + "\n";
        }
    
        return descricaoResumida;
    }


    public String descricaoCompletaDoZoo(){
       String descricaoCompleta = "";     
        for (String animal: animais.keySet()) {
            descricaoCompleta += animais.get(animal).descricaoCompleta()+"\n";
        }

        return descricaoCompleta;
    }


}