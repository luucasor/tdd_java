package br.com.caelum.leilao.dominio;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class AvaliadorTest {

    @Test
    public void deveEntenderLancesEmOrdemCrescente(){
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("Jose");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 250.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 250;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void retornaMediaDosLances(){
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("Jose");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 250.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double mediaEsperada = 316.666666666667;

        assertEquals(mediaEsperada, leiloeiro.getMediaLances(), 0.001);
    }

    @Test
    public void avaliadorDeveFuncionarComApenasUmLance(){
        Usuario joao = new Usuario("Joaoa");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 200.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double valorEsperado = 200.0;

        assertEquals(valorEsperado, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(valorEsperado, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void validaLeilaoComValoresRandomicos(){
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario jonas = new Usuario("Jonas");


        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 200.0));
        leilao.propoe(new Lance(maria, 450.0));
        leilao.propoe(new Lance(jonas, 120.0));
        leilao.propoe(new Lance(joao, 700.0));
        leilao.propoe(new Lance(maria, 630.0));
        leilao.propoe(new Lance(jonas, 230.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void validaLancesEmOrdemDecrescente(){
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario jonas = new Usuario("Jonas");


        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 400.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jonas, 200.0));
        leilao.propoe(new Lance(joao, 100.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void deveEncontrarTresMaioresLances(){
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario jonas = new Usuario("Jonas");


        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 400.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jonas, 200.0));
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 500.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(3, leiloeiro.getTresMaiores().size());
        assertEquals(500.0, leiloeiro.getTresMaiores().get(0).getValor(), 0.0001);
        assertEquals(400.0, leiloeiro.getTresMaiores().get(1).getValor(), 0.0001);
        assertEquals(300.0, leiloeiro.getTresMaiores().get(2).getValor(), 0.0001);
    }

    @Test
    public void deveEncontrarDoisMaioresLances(){
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario jonas = new Usuario("Jonas");


        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 400.0));
        leilao.propoe(new Lance(joao, 300.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(2, leiloeiro.getTresMaiores().size());
        assertEquals(400.0, leiloeiro.getTresMaiores().get(0).getValor(), 0.0001);
        assertEquals(300.0, leiloeiro.getTresMaiores().get(1).getValor(), 0.0001);
    }

    @Test
    public void deveEncontrarListaVazia(){
        Leilao leilao = new Leilao("Playstation 3 Novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(0, maiores.size());
    }
}
