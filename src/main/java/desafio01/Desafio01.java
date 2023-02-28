package desafio01;

public class Desafio01 {
    public static void main(String[] args) {
        /** Qual o valor da variavel soma */

        int ind = 13, k = 0, soma = 0;

        while (k < ind) {
            k = k + 1;
            soma = soma + k;
        }
        System.out.println("Valor final da variavel soma: " + soma);
    }
}
