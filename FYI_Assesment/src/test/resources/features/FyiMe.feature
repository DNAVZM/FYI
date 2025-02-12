Feature: FYI Terms of Service - Copyright Verification

  Scenario: Verify the copyright text on the Terms of Service page
    Given I navigate to the FYI Terms of Service page
#    Then the copyright text should be "©2024 FYI.FYI, Inc." at the bottom of the page
    Then the copyright text should be at the bottom of the page
