package cl.evaluacion.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultaStockSteps {

    private String productoActual;
    private int stockReportado;
    private String estadoResultado;

    @Given("que el producto {string} existe en el catálogo")
    public void que_el_producto_existe_en_el_catalogo(String producto) {
        this.productoActual = producto;
    }

    @Given("la bodega reporta un stock de {int} unidades")
    public void la_bodega_reporta_un_stock_de_unidades(Integer cantidad) {
        this.stockReportado = cantidad;
    }

    @When("el cliente consulta la disponibilidad de {string}")
    public void el_cliente_consulta_la_disponibilidad_de(String producto) {
        // Simulación de la lógica del Facade
        if (this.stockReportado > 0) {
            this.estadoResultado = "Disponible";
        } else {
            this.estadoResultado = "Agotado";
        }
    }

    @Then("el sistema debe mostrar el estado {string}")
    public void el_sistema_debe_mostrar_el_estado(String estadoEsperado) {
        assertEquals(estadoEsperado, this.estadoResultado);
    }
}