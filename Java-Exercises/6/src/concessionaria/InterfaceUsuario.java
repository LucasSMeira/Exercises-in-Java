/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaria;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;
        
    public void exibir() {
        
        ppooVeiculos = new Concessionaria("PPOO Veículos", Marca.FIAT);
        entrada = new Scanner(System.in);
        
        int opcao;        
        do {
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    System.out.println("Escolha a marca que deseja mudar ? \n 1-VW 2-FIAT 3-Renault");          
                    ppooVeiculos.trocaMarca(Integer.parseInt(entrada.nextLine()));
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");                   
            }
            
        } while (opcao != 3);        
    }            
    
    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2- Trocar Marca");
        System.out.println("3 - Sair");
        
        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {        
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());        
        
        System.out.print("Escolha a categoria (1: Entrada, 2: Caminhonete ou 3: Superior): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));
        
        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();
        
        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");            
        }
        else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }
        
        esperarTecla();
    }
    
    private void esperarTecla() {
        entrada.nextLine();
    }
}

