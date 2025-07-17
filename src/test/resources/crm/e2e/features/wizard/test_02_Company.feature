# language: en
@integration
Feature: Company

  Scenario: User Can see and create a Company

    Given i am in the company page
    When i enter "BYD" and "BYD@gmail.com" and press create company button
    Then i am able see newly added Company Name "BYD" in the table