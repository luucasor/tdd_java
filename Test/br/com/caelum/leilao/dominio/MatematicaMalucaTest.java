package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;
import org.junit.Test;

public class MatematicaMalucaTest {

    @Test
    public void multiplicaQuadroDeNumerosMaioresQue30(){
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        assertEquals(50*4, matematicaMaluca.contaMaluca(50));
    }

    @Test
    public void multiplicaTresDeNumerosEntre10E30(){
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        assertEquals(15*3, matematicaMaluca.contaMaluca(15));
    }

    @Test
    public void multiplicaDoisDeNumerosMenoresQue10(){
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        assertEquals(5*2, matematicaMaluca.contaMaluca(5));
    }
}

