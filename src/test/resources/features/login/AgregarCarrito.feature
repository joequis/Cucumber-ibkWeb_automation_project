Feature: Este Feature prueba Agregar Productos al Carrito


  @AddToCart
  Scenario Outline: Se probará agregar un producto al carrito

    Given Me encuentro en la Pagina de Login
    When Ingreso las Credenciales "<userName>" y "<password>"
    Then Validar el ingreso exitoso
    When Agregar al carrito el producto con "<product_name>"
    And Ingresar al Carrito
    Then Verificar que el "<product_name>" se encuentra en el carrito


    Examples:
      |userName        |password    |product_name         |
      |standard_user   |secret_sauce|Sauce Labs Backpack  |


