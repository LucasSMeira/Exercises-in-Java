package fabricaautomoveis;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public interface Factory {
    public Carro factorycar(Categoria Categoria, String cor);
}
