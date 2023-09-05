public class Ave extends Animal {
    private boolean voaBem;

    public Ave(String nome, String especie, int qtdPatas, String som,boolean voaBem){
        super(nome,especie,qtdPatas,som);
        this.voaBem = voaBem;
    }

    public boolean getVoaBem(){
        return voaBem;
    }

    private String voaBemOuMalString(){
        if(getVoaBem() == true){
            return "bem";
        }
        else{
            return "mal";
        }
    }


    @Override
    public String descricaoCompleta(){
        String descricaoCompleta = super.descricaoCompleta();
        return descricaoCompleta += " e voa " + voaBemOuMalString();
    }

}
