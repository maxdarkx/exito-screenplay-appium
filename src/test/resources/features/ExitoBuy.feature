Feature: I as an Exito app user
        want to navigate inside the application
        to buy some items.

  Scenario: Buy a pen and sent it to juan's home
    Given Juan enters into the shopping section
    When he looks for a classic pen
    And he added it to the shopping cart
    And he finishes the checkout process sending the item to his house
    Then Juan must see the pen added on che checkout page

