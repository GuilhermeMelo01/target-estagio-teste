package desafio05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Desafio05 {
    public static void main(String[] args) {
        /**
        5) Escreva um programa que inverta os caracteres de um string.

        IMPORTANTE:
	    a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
	    b) Evite usar funções prontas, como, por exemplo, reverse;
	    */

        Scanner in = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String texto = in.nextLine();

        StringBuilder sb = new StringBuilder();
        String[] split = texto.split("");
        Deque<String> deque = new ArrayDeque<>();
        // Utilizei Pilha para faze a reversão. last in - first out

        for (int i = 0; i < split.length; i++) {
            deque.push(split[i]);
        }

        int size = deque.size();
        for (int i = 0; i < size; i++) {
            sb.append(deque.pop());
        }

        System.out.println(sb);

    }
}
