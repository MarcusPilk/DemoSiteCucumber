Feature: Creating a user
    As a user
    I want to register
    So that I can login

Scenario: Registering with correct details
    Given correctly formatted details
    When I navigate to thedemosite.co.uk
    And I click Add a User
    And I fill in the details
    And I click register
    And I try to login
    Then I am successfully logged in