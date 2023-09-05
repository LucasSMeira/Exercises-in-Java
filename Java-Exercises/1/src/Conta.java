public class Conta {
    //Atributos
    private double saldo;
    private static double limiteNegativo;
    private Cliente clientela;
    private int numeroDaConta;
    private static int numUltimaConta = 100;

    

    //Contrutor da Classe
    public Conta(Cliente nome){
        this(nome, 0);
        
    }

    public Conta(Cliente nome, double valorInicial){
        saldo = valorInicial;
        limiteNegativo = -5000;
        clientela = nome;
        numeroDaConta = ++numUltimaConta;
    }

    //Metodos
    public double getSaldo(){
        return saldo;
    }

    public void Deposito(double valor){
        saldo+= valor;
    }

    public String NomePessoa(){
        return clientela.getNome();
    }

    public boolean Saque(double valor){
        double operacao = saldo - valor;
        if(limiteNegativo  > operacao ){
            return false;
        }
        else{
            saldo -= valor;
            return true;
        }
    }
    
    public int getNumeroDaConta(){
        return numeroDaConta;
    }

    public boolean Trasferencia(Conta transfer, double valorTransfer){
        if(Saque(valorTransfer)){
            transfer.Deposito(valorTransfer);
            return true;
        }
        else{
            return false;
        }
    }
}
