# language: en
@integration
Feature: Login

  Scenario: User must be able to log in and log out

    Given I am logged in to the CRM
    When I click on the menu item "Log out"
    Then I am redirected to the landing page

  Scenario: User must be able to access the dashboard after logging in

    Given I am logged in to the CRM
    When I click on the menu item "Dashboard"
    Then I am redirected to a page with an overview of my dashboard