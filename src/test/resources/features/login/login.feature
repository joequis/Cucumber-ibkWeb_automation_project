Feature: Feature Login de test


  @login
  Scenario Outline: Se prueba el ingreso válido al sistema

    Given Me encuentro en la Pagina de Login
    When Ingreso las Credenciales
    Then Validar el ingreso exitoso para "<nombre>"


    Examples:
      |nombre        |
      |Moises-Roberto|


