# language: en
@integration
Feature: Login

  Scenario: User must be able to log in and log out

    Given i am on login page
    When i enter correct "crm_admin" and "12345" and sign in
    Then i am able to see the home page