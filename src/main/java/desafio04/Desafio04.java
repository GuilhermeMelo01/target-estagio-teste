package desafio04;

import desafio04.model.Estado;

import java.util.ArrayList;
import java.util.List;

public class Desafio04 {
    public static void main(String[] args) {
        /**
         *
         * 4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
         *
         * 	SP – R$67.836,43
         * 	RJ – R$36.678,66
         * 	MG – R$29.229,88
         * 	ES – R$27.165,48
         * 	Outros – R$19.849,53
         *
         * Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve
         * dentro do valor total mensal da distribuidora.
         * */

        List<Estado> estados = new ArrayList<>(List.of(new Estado("SP", 67.83643),
                new Estado("RJ", 36.67866),
                new Estado("MG", 29.22988),
                new Estado("ES", 27.16548),
                new Estado("Outros", 19.89453)));

        for (Estado es: estados){
            String porcetagem = es.calcularPorcetagemFaturamento(es.getSigla(), estados);
            System.out.print(porcetagem);
        }


    }
}
