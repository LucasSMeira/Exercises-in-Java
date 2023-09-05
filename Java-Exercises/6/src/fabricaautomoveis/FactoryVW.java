package fabricaautomoveis;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.Polo;
import fabricaautomoveis.carros.Saveiro;

public class FactoryVW implements Factory {
    Marca brand = Marca.VW;
    @Override
    public Carro factorycar(Categoria t, String cor){
        Carro tipo = null;
        if(t == Categoria.ENTRADA){
            tipo = new Polo(cor);
        }
        else if(t == Categoria.CAMINHONETE){
            tipo = new Saveiro(cor);
        }
        else if(t == Categoria.SUPERIOR){
            tipo = null;
        }
        return tipo;
    }
}
