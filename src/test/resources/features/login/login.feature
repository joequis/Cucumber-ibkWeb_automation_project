Feature: Feature Login de test


  @login
  Scenario Outline: Se prueba el ingreso válido al sistema

    Given Me encuentro en la Pagina de Login
    When Ingreso las Credenciales "<userName>" y "<password>"
    Then Validar el ingreso exitoso


    Examples:
      |userName        |password    |
      |standard_user   |secret_sauce|


