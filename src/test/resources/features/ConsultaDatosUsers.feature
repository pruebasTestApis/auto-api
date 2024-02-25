@ConsultarDatosUsers

  #QA: David Lopez

Feature: Consultar datos de un usuario del api Users

  @E01 @happypath
  Scenario Outline: Validar la consulta de datos de un usuario
    Given que users es una API
    When Se inserta parametros al api consultar datos de un usuario <id>
    Then valida la respuesta sea 200
    Examples:
      | id |
      | 2  |
      | 3  |
      | 4  |

  @E02 @happypath
  Scenario Outline: Validar la consulta de datos de un usuario inexsistente
    Given que users es una API
    When Se inserta parametros al api consultar datos de un usuario <id>
    Then valida la respuesta sea 404
    Examples:
      | id |
      | 23 |

