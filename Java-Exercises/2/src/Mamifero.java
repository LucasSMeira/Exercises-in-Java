public class Mamifero extends Animal {
    private String corDoPelo;

    public Mamifero(String nome, String especie, int qtdPatas, String som,String corDoPelo){
        super(nome,especie,qtdPatas,som);
        this.corDoPelo = corDoPelo;
    }

    public String getCorDoPelo(){
        return corDoPelo;
    }



@Override
    public String descricaoCompleta(){
        String descricaoCompleta = super.descricaoCompleta();
        descricaoCompleta +=  " e tem pelo " + getCorDoPelo();
        return descricaoCompleta;
    }

}





