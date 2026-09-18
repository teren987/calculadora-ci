package cl.evaluacion.calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    private Calculadora calculadora;

    // Se ejecuta antes de cada test para garantizar atomicidad e independencia
    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void deberiaSumarDosNumerosCorrectamente() {
        // Arrange (Preparar)
        int a = 5;
        int b = 3;

        // Act (Actuar)
        int resultado = calculadora.sumar(a, b);

        // Assert (Afirmar)
        assertEquals(8, resultado, "La suma de 5 y 3 debe ser 8");
    }

    @Test
    public void deberiaRestarDosNumerosCorrectamente() {
        int a = 10;
        int b = 4;
        
        int resultado = calculadora.restar(a, b);
        
        assertEquals(6, resultado, "La resta de 10 menos 4 debe ser 6");
    }
}