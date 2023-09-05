package fabricaautomoveis;
import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.Quadra;

public class FactoryRenault implements Factory {
    Marca brand = Marca.Renault;
    @Override
    public Carro factorycar(Categoria t, String cor){
        Carro tipo = null;
        if(t == Categoria.ENTRADA){
            tipo = null;
        }
        else if(t == Categoria.CAMINHONETE){
            tipo = null;
        }
        else if(t == Categoria.SUPERIOR){
            tipo = new Quadra(cor);
        }
        return tipo;
    }   
}
