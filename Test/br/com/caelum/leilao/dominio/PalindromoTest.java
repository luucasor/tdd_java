package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;
import org.junit.Test;

public class PalindromoTest {

    @Test
    public void validaSeAFraseOnibusMarrocosEhPalindromo(){
        final String onibusMarrocos = "Socorram-me subi no onibus em Marrocos";
        assertEquals(true, new Palindromo().ehPalindromo(onibusMarrocos));
    }

    @Test
    public void validaSeAFraseAnotaramDataMaratonaEhPalindromo(){
        final String anotaramDataMaratona = "Anotaram a data da maratona";
        assertEquals(true, new Palindromo().ehPalindromo(anotaramDataMaratona));
    }

    @Test
    public void validaSeAFraseAleatoriaEhPalindromo() {
        final String fraseAleatoria = "Escrita de frase aleatória";
        assertFalse(new Palindromo().ehPalindromo(fraseAleatoria));
    }
}
