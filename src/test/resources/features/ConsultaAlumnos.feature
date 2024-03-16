@ConsultaAlumnos

  #QA: David Lopez

Feature: Consultar datos de alumnos

  @E01 @happypath
  Scenario Outline: Validar la consulta de datos de alumnos
    Given que alumnos es una API publica
    When Se inserta parametros al api consultar datos de alumnos <id>
    Then valida la respuesta sea 200
    Then valida que el mensaje de respuesta en Responsemessage sea <Responsemessage>
    Then valida que el codigo de respuesta en Responsecode sea <Responsecode>
    Examples:
      | id | Responsemessage   | Responsecode |
      | 1  | EJECUCIÓN EXITOSA | 0000         |
      | 3  | EJECUCIÓN EXITOSA | 0000         |
      | 10 | EJECUCIÓN EXITOSA | 0000         |
      | 16 | EJECUCIÓN EXITOSA | 0000         |

  @E02 @unhappypath
  Scenario Outline: Validar la consulta de datos de alumnos que no existen
    Given que alumnos es una API publica
    When Se inserta parametros al api consultar datos de alumnos <id>
    Then valida la respuesta sea 404
    Then valida que el mensaje de respuesta en Responsemessage sea <Responsemessage>
    Then valida que el codigo de respuesta en Responsecode sea <Responsecode>
    Examples:
      | id | Responsemessage           | Responsecode |
      | 11 | PROBLEMAS EN LA EJECUCIÓN | 0020         |
      | 12 | PROBLEMAS EN LA EJECUCIÓN | 0020         |

  @E03 @unhappypath
  Scenario Outline: Validar la consulta de datos de alumnos con id invalido
    Given que alumnos es una API publica
    When Se inserta parametros al api consultar datos de alumnos <id>
    Then valida la respuesta sea 404
    Then valida que el mensaje de respuesta en Responsemessage sea <Responsemessage>
    Then valida que el codigo de respuesta en Responsecode sea <Responsecode>
    Examples:
      | id | Responsemessage           | Responsecode |
      | X  | PROBLEMAS EN LA EJECUCIÓN | 0010         |
      | -  | PROBLEMAS EN LA EJECUCIÓN | 0010         |