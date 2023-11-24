Feature: I as an Exito app user
  want to navigate inside the application
  to buy some items.

  Scenario Outline: Buy an item and sent it to juan's home
    Given juan enters into the shopping section using his location department as "<department>" and his city as "<city>" and address "<address>"
    When he looks for an "<item>"
    And he added it to the shopping cart
    And he finishes the checkout process sending the item to his house with this data:
      | firstName   | lastName   | eMail   | cellPhone   | id   |
      | <firstname> | <lastname> | <email> | <cellphone> | <id> |
    Then Juan must see the item added on checkout page

    Examples:
      | firstname | lastname | address             | department   | city       | email                    | cellphone  | id         | item     |
      | Juan      | Jodase   | calle 4 # 6 - 95    | CUNDINAMARCA | FUSAGASUGA | juan.jodase@gmail.com    | 3112224455 | 1037111233 | parker   |
      | Juan      | Pendejo  | calle 4 # 6 - 95    | CUNDINAMARCA | FUSAGASUGA | juan.pendejo@gmail.com   | 3112224453 | 1037111243 | tv 50    |
      | Juan      | Pendejo  | calle 111 # 63 B 38 | ANTIOQUIA    | MEDELLIN   | juan.pendejo@hotmail.com | 3112224453 | 1037111243 | borrador |