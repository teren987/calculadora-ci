Feature: Consulta de disponibilidad de stock
  Como cliente de la tienda
  Quiero consultar el stock de un producto del catálogo
  Para saber si puedo comprarlo

  Scenario: Producto con stock disponible en bodega
    Given que el producto "Laptop X" existe en el catálogo
    And la bodega reporta un stock de 5 unidades
    When el cliente consulta la disponibilidad de "Laptop X"
    Then el sistema debe mostrar el estado "Disponible"

  Scenario Outline: Consulta de múltiples productos con diferentes niveles de stock
    Given que el producto "<producto>" existe en el catálogo
    And la bodega reporta un stock de <cantidad> unidades
    When el cliente consulta la disponibilidad de "<producto>"
    Then el sistema debe mostrar el estado "<estado_esperado>"

    Examples:
      | producto   | cantidad | estado_esperado |
      | Teclado    | 10       | Disponible      |
      | Monitor Ultra | 0     | Agotado         |