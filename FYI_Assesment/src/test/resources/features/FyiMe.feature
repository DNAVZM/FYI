@FYI
Feature: FYI Terms of Service - Copyright Verification, Contact Support and search
  Background: Navigate to FYI page
    Given I navigate to the FYI Terms of Service page

  @test1
  Scenario: Verify the copyright text on the Terms of Service page
#    Then the copyright text should be "©2024 FYI.FYI, Inc." at the bottom of the page
    Then the copyright text should be at the bottom of the page

  @test2
  Scenario: Verify hamburger menu contains correct user selection options
    Given the user is on the homepage
    When the user clicks on the hamburger menu icon
    Then the menu should contain the following options:
      | Home             |
      | Help             |
      | About us         |
      | The Team         |
      | Press            |
      | Terms of Service |
      | Privacy Policy   |

  @test3
  Scenario: Verify that the "Contact Support" button redirects the user to the "Submit Request" page
    When the user clicks on the hamburger menu icon
    And I navigate to help
    And I click on contact support
    Then we verify page is redirected to the Submit Request page



  @test4
  Scenario: Verify Search Results for "AI" on the Submit a Request Page
    When the user clicks on the hamburger menu icon
    And I navigate to help
    And I enter "AI" into search field
    Then I verify 15 results for "AI" search

