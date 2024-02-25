@CrearUsers

  #QA: David Lopez

Feature: Consultar una api

  @E01 @happypath
  Scenario Outline: Validar el metodo POST de la api users crea nuevo usuario
    Given que users es una API
    When Se inserta parametros para crear al api users <name> <job>
    Then valida la respuesta sea 201
    Examples:
      | name     | job    |
      | morpheus | leader |