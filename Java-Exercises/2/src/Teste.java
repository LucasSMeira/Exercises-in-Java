public class Teste {
    public static void main(String[] args) throws Exception {
        /*    
        Animal animal = new Tigre("samba", "vermelho");
        System.out.println(animal.getNome());
        animal = new Tucano("jazz");
        System.out.println(animal.getNome());
         * 
         * 
         * 
        */
        Tigre tiger = new Tigre("samba", "vermelho");
        exibirDescricaoCompleta(tiger);

        Avestruz avestruz = new Avestruz("cuzcuz");
        exibirDescricaoCompleta(avestruz);

    }

    public static void exibirDescricaoCompleta(Animal animal){
        System.out.println(animal.descricaoCompleta());
    }

}
