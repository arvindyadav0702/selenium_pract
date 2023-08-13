Feature: To check the goibibo flight booking
  Description: Just a description

  Background: User is on home page
    Given  User is on home page

  Scenario Outline: To book a oneway flight
    Given user selects oneway button
    When  user enters from "<from_city>" destination
    And   user enters to "<to_city>" destination
    And   user enters "<date>" date
    Then  flight should get searched

    Examples:
      | from_city | to_city  | date |
      | Pune      | Guwahati | 29   |

