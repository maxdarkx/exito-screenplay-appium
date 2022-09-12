Feature: I as an Exito app user
  want to navigate inside the application
  to buy some items.

  Scenario Outline: Buy a pen and sent it to juan's home
    Given Juan enters into the shopping section using his city "<city>" and address "<address>"
    When he looks for an "<item>"
    And he added it to the shopping cart
    And he finishes the checkout process sending the item to his house with this data:
      | firstName   | lastName   | eMail   | cellPhone   | id   |
      | <firstname> | <lastname> | <email> | <cellphone> | <id> |
    Then Juan must see the pen added on checkout page

    Examples:
      | firstname | lastname | address          | city       | email                        | cellphone  | id         | item          |
      #| Juan | Jodase   | calle 50 40 30   | FLORIDABLANCA | juan.jodase@noleimporta.com  | 3112224455 | 1037111233 | lapicero parker |
      | Juan      | Pendejo  | calle 4 # 6 - 95 | FUSAGASUGA | juan.pendejo@noleimporta.com | 3112224453 | 1037111243 | tv samsung 50 |