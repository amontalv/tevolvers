Feature: Add product for category in application

  Scenario Outline: <nameScenario>
    Given the user open application
    When add product in the cart
      | products   |
      | <products> |
    Then view number of product in the cart <totalproduct>

    Examples:
      | products                                                                                            | totalproduct | nameScenario                               |
      | Samsung galaxy s6,Sony vaio i5,ASUS Full HD,Sony xperia z5,MacBook Pro,Apple monitor 24             | 6            | add product in application with 6 products |
      | Samsung galaxy s22,MacBook Pro 20212,Samsung monitor 24,Sony xperia z5,MacBook Pro,Apple monitor 24 | 3            | add product in application with 3 products |
      | Samsung galaxy s22,MacBook Pro 20212,Samsung monitor 24                                             | 0            | add product in application with 0 products |