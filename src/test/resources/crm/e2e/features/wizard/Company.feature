# language: en
@integration
Feature: Company

  Scenario: User Can see and create a Company

    Given i am in the company page
    When i enter "company name" and "company email" and press create company button
    Then i am able see newly added Company in the table