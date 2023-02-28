package desafio04.model;

import java.text.DecimalFormat;
import java.util.List;

public class Estado {
    private String sigla;
    private Double faturamento;

    public Estado() {
    }

    public Estado(String sigla, double faturamento) {
        this.sigla = sigla;
        this.faturamento = faturamento;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }

    public String calcularPorcetagemFaturamento(String sigla, List<Estado> estados) {
        Estado tempEstado = new Estado();
        Double faturamentoTotal = 0D, porcetagemEstado;
        DecimalFormat df = new DecimalFormat("#.00");

        for (Estado estado : estados) {
            faturamentoTotal += estado.getFaturamento();
            if (estado.getSigla().equalsIgnoreCase(sigla)) {
                tempEstado = estado;
            }
        }

        String valorFormatado = df.format((tempEstado.getFaturamento() / faturamentoTotal) * 100);
        return "A porcetagem de faturamento do estado de "+ sigla +" é igual a "+ valorFormatado +"%\n";
    }
}