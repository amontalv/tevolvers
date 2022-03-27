Feature: Update Booking

  Scenario Outline:  Update booking succesfully
    Given user automation service in url https://restful-booker.herokuapp.com
    When User want update booking to service with <id>
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin>    | <checkout>   | <additionalneeds> |
    Then User validate the status code <status>

    Examples:
      | firstname | lastname  | totalprice | depositpaid | checkin    | checkout   | additionalneeds | status | id |
      | auxiliar  | pruebas25 | 120        | false       | 2021-03-24 | 2022-03-24 | Breakfast       | 200    | 18 |