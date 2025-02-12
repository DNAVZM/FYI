Feature: Hamburger Menu Functionality

  Scenario: Verify hamburger menu contains correct user selection options
    Given the user is on the homepage
    When the user clicks on the hamburger menu icon
    Then the menu should contain the following options:
      | Home             |
      | Help             |
      | About Us         |
      | The Team         |
      | Press            |
      | Terms of Service |
      | Privacy Policy   |
