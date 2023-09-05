package concessionaria;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.FactoryFiat;
import fabricaautomoveis.FactoryRenault;
import fabricaautomoveis.FactoryVW;
import java.util.HashMap;
import java.util.Map;
import detran.GeradorDePlaca;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca.
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private Map<String, Carro> carros;
    // Marca da qual a concessionária vende os carros
    private Marca marcaFranquia;

    private FactoryFiat ffiat;
    private FactoryVW fvw;
    private FactoryRenault fre;
    
    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * @param nome O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome, Marca marca) {
        this.nome = nome;
        this.marcaFranquia = marca;
        carros = new HashMap<>();
        ffiat = new FactoryFiat();
        fvw = new FactoryVW();
        fre = new FactoryRenault();
    }
    
    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a Marca da qual a concessionária vende os carros.
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return marcaFranquia;
    }

    private void setMarcaFranquia(Marca marca){
        marcaFranquia = marca;
    }

    public boolean trocaMarca(int n){
        if(n==1){
            setMarcaFranquia(Marca.VW);
            return true;
        }
        else if(n==2){
            setMarcaFranquia(Marca.FIAT);
            return true;
        }
        else if(n==3){
            setMarcaFranquia(Marca.Renault);
            return true;
        }
        return false; 
    }
    
    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * @param categoria Categoria do carro a ser comprado.
     * @param cor Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean comprarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        
        if(Marca.VW == marcaFranquia){
            carro = fvw.factorycar(categoria,cor);
        }
        else if(Marca.FIAT == marcaFranquia){
            carro = ffiat.factorycar(categoria,cor);
        }
        else if(Marca.Renault == marcaFranquia){
            carro = fre.factorycar(categoria,cor);
        }
        
        if (carro != null) {
            carro.emplacar(GeradorDePlaca.gerarPlaca());
            carro.prepararParaEntrega();
            carro.liberarDocumentacao();
            carros.put(carro.obterNome(),  carro);
            return true;
        }
        else {
            System.out.println("Não há modelos disponíveis para essa categoria");
            return false;
        }
    }
}
