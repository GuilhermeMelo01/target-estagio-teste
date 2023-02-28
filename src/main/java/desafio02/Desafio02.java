package desafio02;

import java.util.Scanner;

public class Desafio02 {
    public static void main(String[] args) {
        /**
        * 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2
        * valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que
        * desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando
        * se o número informado pertence ou não a sequência.

        IMPORTANTE:
	    * Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser
	    * previamente definido no código;
        */

        Scanner in = new Scanner(System.in);

        System.out.print("Escolha um valor entre 1 e 10000: ");
        int valor = in.nextInt();
        
        int primeiroValor = 0, segundoValor = 1;
        boolean pertence = false;

        for (int i = 0; i < 25; i++) {
            int aux = primeiroValor;
            primeiroValor += segundoValor;
            segundoValor = aux;
            if (valor == primeiroValor){
                pertence = true;
            }
        }

        if (valor > 10000 || valor < 0){
            System.out.println("O valor digitado não é permitido");
        } else if (pertence || valor == 0){
            System.out.println("O valor pertence a sequencia de Fibonnaci");
        }else{
            System.out.println("O valor não pertence a sequencia de Fibonnaci");
        }
    }
}
