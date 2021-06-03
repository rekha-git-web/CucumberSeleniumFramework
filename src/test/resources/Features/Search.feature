Feature: 

  Background: Create a customer
    Given I invoke finxact API using method "POST" and body from "CreateCustomer"

  Scenario: Search a customer
    Given A user navigates to HomePage "https://demo-savana.savanainc.com/nGageBanking/Login.aspx"
    Then I enter into placeholder field "Username" data "Ubolisetty"
    Then I enter into placeholder field "Password" data "Demo@s123"
    And I click on "Login" button on "Login"
    Then submit the data
      | FormName       | FieldName | Data   |
      | CustomerSearch | Last Name | QA |
   And I click on "Search" button on "CustomerSearch"
