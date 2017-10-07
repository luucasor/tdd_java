package br.com.caelum.leilao.dominio;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double media = 0d;



    public void avalia(Leilao leilao){
        double total = 0;

        for (Lance lance : leilao.getLances()){
            if (lance.getValor() > maiorDeTodos){
                maiorDeTodos = lance.getValor();
            }
            if (lance.getValor() < menorDeTodos){
                menorDeTodos = lance.getValor();
            }
            total += lance.getValor();
        }
        media = total / leilao.getLances().size();
    }

    public double getMediaLances(){
        return media;
    }

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }
}
