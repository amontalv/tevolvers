Feature: Create Booking

  Scenario Outline:  Get booking succesfully
    Given user automation service in url https://restful-booker.herokuapp.com
    When User want get booking to service
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin>    | <checkout>   | <additionalneeds> |
    Then User validate the status code <status>

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds | status |
      | auxiliar  | pruebas  | 120        | false       | 2021-03-24 | 2022-03-24 | Breakfast       | 200    |