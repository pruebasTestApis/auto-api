@ConsultaAlumnos

  #QA: David Lopez

Feature: Consultar datos de alumnos

  @E01 @happypath
  Scenario Outline: Validar la consulta de datos de alumnos
    Given que alumnos es una API publica
    When Se inserta parametros al api consultar datos de alumnos <id>
    Then valida la respuesta sea 200
    Examples:
      | id |
      | 1  |
      | 3  |
      | 10 |
      | 16 |