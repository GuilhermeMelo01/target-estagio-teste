package desafio03.main;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.text.DecimalFormat;

public class Desafio03 {
   public static void main(String[] args) {

      /**
       3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa,
       na linguagem que desejar, que calcule e retorne:
	  • O menor valor de faturamento ocorrido em um dia do mês;
	  • O maior valor de faturamento ocorrido em um dia do mês;
	  • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

      IMPORTANTE:
	  a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
	  b) Podem existir dias sem faturamento, como nos finais de semana e feriados.
	     Estes dias devem ser ignorados no cálculo da média;
      */

      try {
         File arquivoXML = new File("src/main/java/desafio03/data/data.xml");

         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

         Document doc = dBuilder.parse(arquivoXML);
         doc.getDocumentElement().normalize();

         NodeList nodeList = doc.getElementsByTagName("produto");
         double menorFaturamentoDoMes = Double.parseDouble(nodeList.item(0).getTextContent());
         double maiorFaturamentoDoMes = 0, faturamentoTotal = 0, mediaFaturamentoMensal;
         int diasMaiorQueMedia = 0;

         DecimalFormat df = new DecimalFormat("#.00");

         for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
               Element elemento = (Element) node;

               double valorAtual = Double.parseDouble(elemento.getTextContent());
               if (valorAtual < menorFaturamentoDoMes){
                  menorFaturamentoDoMes = valorAtual;
               }

               if (valorAtual > maiorFaturamentoDoMes){
                  maiorFaturamentoDoMes = valorAtual;
               }

               faturamentoTotal += Double.parseDouble(elemento.getTextContent());
            }
         }

         mediaFaturamentoMensal = faturamentoTotal / nodeList.getLength();

         for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
               Element elemento = (Element) node;
               if (Double.parseDouble(elemento.getTextContent()) > mediaFaturamentoMensal){
                  diasMaiorQueMedia++;
               }
            }
         }

         System.out.println("Menor faturamento em um dia do mês: "+ menorFaturamentoDoMes);
         System.out.println("Maior faturamento em um dia do mês: "+ maiorFaturamentoDoMes);
         System.out.println("Quantidade de dias que o faturamento foi maior que a média mensal: "+ diasMaiorQueMedia);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
