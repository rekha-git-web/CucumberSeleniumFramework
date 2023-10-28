#Author: uma.bolisetty@levvel.io
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)/ README: / Sample Test Steps to utilise without creating new locator/methods mostly. to be able to build new test cases by expanding feature files
#Sample Feature Definition Template
Feature: Home page

@Login @smoketest
  Scenario: test feature
    Given A user navigates to HomePage "https://demo-savana.savanainc.com/nGageBanking/Login.aspx"
    Then I login using "Ubolisetty" "Demo@s123"
    And I click on "close" button on "CustomerSearch"
    And I click on icon "Tasks" on "CustomerSearch"
    And I click on link "Add New Account" on "CustomerSearch"
    Then submit the data
      | FormName      | FieldName        | Data              |
      | AccountCreate | Account Nickname | TestNickName_auto |
      | AccountCreate | Account Title    | TestTitle_auto    |
      | AccountCreate | Reference ID     |              1234 |
   
   
   Scenario: API
  # Then I verify finxact using the method "GET" and path1 "model" path2  "trn"
  Given I invoke finxact API using method "POST" path1 "model" path2  "addr" and body from "Address.json"
   Given I invoke finxact API using method "POST" path1 "core" path2  "customer" and body from "Customer.json"