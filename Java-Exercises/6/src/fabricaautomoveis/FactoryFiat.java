package fabricaautomoveis;

import fabricaautomoveis.carros.Argo;
import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.Strada;
import fabricaautomoveis.carros.Toro;

public class FactoryFiat implements Factory{
    Marca brand = Marca.FIAT;
        @Override
        public Carro factorycar(Categoria t, String cor){
            Carro tipo = null;
            if(t == Categoria.ENTRADA){
                tipo = new Argo(cor);
            }
            else if(t == Categoria.CAMINHONETE){
                tipo = new Strada(cor);
            }
            else if(t == Categoria.SUPERIOR){
                tipo = new Toro(cor);
            }
            return tipo;
        } 
}
