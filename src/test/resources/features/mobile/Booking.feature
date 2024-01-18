Feature: Frontend - Make a reservation of my vacations in the application

  Scenario: Search hotel to booking
    Given that "diego" is looking for a hotel in "CUSCO" to reserve with the following information
      | check In   | check out  | rooms | adults | children | children age |
      | 14/02/2024 | 28/02/2024 | 1     | 2      | 1        | 5 years old  |
    When select the room from item "2" from the hotel search results
    And add personal information in the application
    Then should then be able to see the reservation summary
    And the payment information process