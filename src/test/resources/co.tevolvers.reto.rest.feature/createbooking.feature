Feature: Create Booking

  Scenario Outline:  Create booking succesfully
    Given user automation service in url https://restful-booker.herokuapp.com
    When User want create booking to service
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin>    | <checkout>   | <additionalneeds> |
    Then User validate the status code 200

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | alejandro | montalvo | 111        | true        | 2021-03-24 | 2022-03-24 | Breakfast |