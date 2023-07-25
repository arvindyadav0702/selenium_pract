Feature: Login with Valid Credentials

  @sanity
  Scenario Outline: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL "http://localhost/opencart/upload/"
    When User navigate to MyAccount menu
    And click on Login
    And User enters Email as "<username>" and Password as "<password>"
    And Click on Login button
      | userN | Pass |
    Then User navigates to MyAccount Page

    Examples:
      | username   | password |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |
      | arvind0702 | Passw123 |





 