public class Cliente {
    //Atributos
    private String Nome;
    private String CPF;

    //Construtor
    public Cliente(String name , String id){
        Nome = name;
        CPF = id;
    }

    //Metodos
    public String getNome(){
        return Nome;
    }

    public String getCPF(){
        return CPF;
    }
}
