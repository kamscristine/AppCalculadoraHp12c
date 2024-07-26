package com.example.calculadorahp12c;


import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void somarABC(){
        Calculadora calc = new Calculadora();
        calc.setNumero(1);
        calc.enter();
        calc.setNumero(2);
        calc.enter();
        calc.setNumero(3);
        calc.soma();
        assertEquals(Calculadora.MODO_EXIBINDO, calc.getModo());
        assertEquals(5.0, calc.getNumero());
        calc.soma();
        assertEquals(6.0, calc.getNumero());
    }

}
