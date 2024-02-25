@ConsultarUsers

  #QA: David Lopez

Feature: Consultar usuarios por pagina del api Users

  @E01 @happypath
  Scenario Outline: Validar la consulta de usuarios con pagina 4
    Given que users es una API
    When Se inserta parametros al api users <page>
    Then valida la respuesta sea 200
    Examples:
      | page |
      | 4    |
      | 1    |

