import java.util.Scanner;


public class CaixaEletronico{
    private Conta Cliente;
    private Cliente Pessoa;
    private static Scanner entrada = new Scanner(System.in);
    private Conta Clientes;

    public boolean verificarValidade(int numeroDaConta){
        if((numeroDaConta == Cliente.getNumeroDaConta()) || (numeroDaConta == Clientes.getNumeroDaConta())){
            return true;
        }
        else{
            return false;
        }

    }

    public void Menu(){
        boolean verificador;
        verificador = false;
        int numeroDeConta;

        
        while(!verificador){
            System.out.println("1. Criar Conta\n" +
                               "2. Consultar Saldo\n"+
                               "3. Depositar\n" +
                               "4. Sacar\n"+
                               "5. transferir\n"+
                               "5. Sair\n");

            System.out.println("Qual a sua escolha ?");
            
            switch (Integer.parseInt(entrada.nextLine())) {
                case 1:
                    System.out.println("Digite o nome do usuário!");
                    String NomeDoCliente = entrada.nextLine();
                    System.out.println("Digite o CPF do usuário!");
                    String CPFDoCliente = entrada.nextLine();
                    System.out.println("Escolha o tipo de conta que deseje criar!\n"+
                                       "1. Conta sem deposito inicial!\n"+
                                       "2. Conta com deposito inicial!");
                    
                    switch (Integer.parseInt(entrada.nextLine())){
                        case 1: 
                            Pessoa = new Cliente(NomeDoCliente,CPFDoCliente);
                            Cliente = new Conta(Pessoa);
                            break;
                        case 2:
                            System.out.println("Digite o Valor inicial a ser depositado!");
                            Pessoa = new Cliente(NomeDoCliente,CPFDoCliente);
                            Cliente = new Conta(Pessoa,Double.parseDouble(entrada.nextLine())); 
                            break;
                    }
                    System.out.println(Cliente.getNumeroDaConta());
                    
                    System.out.println("Digite o nome do usuário da segunda Conta!");
                    NomeDoCliente = entrada.nextLine();
                    System.out.println("Digite o CPF do usuário da segunda Conta!");
                    CPFDoCliente = entrada.nextLine();
                    System.out.println("Escolha o tipo de conta que deseje criar!\n"+
                                       "1. Conta sem deposito inicial!\n"+
                                       "2. Conta com deposito inicial!");
                    
                    switch (Integer.parseInt(entrada.nextLine())){
                        case 1: 
                            Pessoa = new Cliente(NomeDoCliente,CPFDoCliente);
                            Clientes = new Conta(Pessoa);
                            break;
                        case 2:
                            System.out.println("Digite o Valor inicial a ser depositado!");
                            Pessoa = new Cliente(NomeDoCliente,CPFDoCliente);
                            Clientes = new Conta(Pessoa,Double.parseDouble(entrada.nextLine())); 
                            break;
                    }
                    System.out.println(Clientes.getNumeroDaConta());
                    break;
                case 2:
                    System.out.println("Escreva o numero da Conta!");
                    numeroDeConta = Integer.parseInt(entrada.nextLine());
                    if(Cliente!=null && Clientes!=null){
                        if(numeroDeConta == Cliente.getNumeroDaConta()){
                            System.out.println(Cliente.NomePessoa());
                            System.out.println(Cliente.getSaldo());
                        }
                        else if(numeroDeConta == Clientes.getNumeroDaConta()){
                            System.out.println(Clientes.NomePessoa());
                            System.out.println(Clientes.getSaldo());
                        }
                        else{
                            System.out.println("Conta não encontrada!");
                        }
                    }
                    else{
                        System.out.println("Conta inexistente!");
                    }
                    break;
                    
                case 3:
                    System.out.println("Escreva o numero da Conta!");
                    numeroDeConta = Integer.parseInt(entrada.nextLine());
                    if(Cliente!=null && Clientes!=null){
                        if(numeroDeConta == Cliente.getNumeroDaConta()){
                            System.out.println("Valor a ser Depositado");
                            Cliente.Deposito(Double.parseDouble(entrada.nextLine()));
                            System.out.println("Deposito realizado!");
                        }
                        else if(numeroDeConta == Clientes.getNumeroDaConta()){
                            System.out.println("Valor a ser Depositado");
                            Clientes.Deposito(Double.parseDouble(entrada.nextLine()));
                            System.out.println("Deposito realizado!");
                        }
                        else{
                            System.out.println("Conta não encontrada!");
                        }
                    }
                    else{
                        System.out.println("Conta inexistente!");
                    }
                    break;
                case 4:
                    System.out.println("Escreva o numero da Conta!");
                    numeroDeConta = Integer.parseInt(entrada.nextLine());
                    if(Cliente!=null && Clientes!=null){
                        if(numeroDeConta == Cliente.getNumeroDaConta()){
                            System.out.println("Valor a ser Sacado"); 
                            if(Cliente.Saque(Double.parseDouble(entrada.nextLine()))){
                                System.out.println("Saque realizado!");
                            }
                            else{
                                System.out.println("Saque NÃO realizado!");
                            }
                        }
                        else if(numeroDeConta == Clientes.getNumeroDaConta()){
                            System.out.println("Valor a ser Sacado"); 
                            if(Clientes.Saque(Double.parseDouble(entrada.nextLine()))){
                                System.out.println("Saque realizado!");
                            }
                            else{
                                System.out.println("Saque NÃO realizado!");
                            }
                        }
                    }
                    else{
                        System.out.println("Conta inexistente!");
                    }
                    break;
                case 5:
                System.out.println("Escreva o numero da Conta de origem da Transferencia!");
                numeroDeConta = Integer.parseInt(entrada.nextLine());
                if(Cliente!=null && Clientes!=null){
                    if(numeroDeConta == Cliente.getNumeroDaConta()){
                        System.out.println("Valor a ser Transferido"); 
                        if(Cliente.Trasferencia(Clientes , Double.parseDouble(entrada.nextLine()))){
                            System.out.println("Trasnferencia realizada!");
                        }
                        else{
                            System.out.println("Trasnferencia NÃO realizado!");
                        }
                    }
                    else if(numeroDeConta == Clientes.getNumeroDaConta()){
                        System.out.println("Valor a ser Trasnferido"); 
                        if(Clientes.Trasferencia(Cliente,Double.parseDouble(entrada.nextLine()))){
                            System.out.println("Trasnferencia realizada!");
                        }
                        else{
                            System.out.println("Trasnferencia NÃO realizado!");
                        }
                    }
                }
                else{
                    System.out.println("Conta inexistente!");
                }
                break;
                case 6:
                    verificador = true;
                    break;
                default:
                    System.out.println("Opção não valida!");
                    break;
            }
        }



    }
}