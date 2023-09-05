import java.util.ArrayList;


public class Personagem {
    private String nome;
    private ArrayList<Item> armas;

    public Personagem(String nome){
        this.nome = nome;
        armas = new ArrayList<>();
    }

    public String getNomePersonagem(){
        return nome;
    }

    public void adicionarArma(Item item){
        armas.add(item);
    }

    public Item removerArma(Item item){
        String nomeItem = item.getNome();
        for(Item itemBlock : armas) {
           if(itemBlock.getNome().equals(nomeItem)){
                armas.remove(item);
            }    
        }
        return item;
    }

    public String exibiItens(){
        String retornaItens = " ";
        for (Item item : armas) {
            retornaItens += item.getNome()+ " ";    
        }
        return retornaItens;
    }

}
