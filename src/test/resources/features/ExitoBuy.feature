Feature: I as an Exito app user
        want to navigate inside the application
        to buy some items.

  Scenario: Buy a pen and sent it to juan's home
    Given Juan makes log in into exito app
    When he looks for a classic pen
    And he added it to the shopping cart
    And He finishes the chechout process sending the item to his house
    Then Juan must see the pen added on che checkout page

