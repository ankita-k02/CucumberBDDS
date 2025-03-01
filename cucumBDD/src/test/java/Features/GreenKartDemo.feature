#Author: your.email@your.domain.com
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
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Greeen Kart Application
  I want to use this template for my feature file

  @GreenKart
  Scenario Outline: Place an Order on GreenKart
    Given Launching the website
    And Verify the Home Page
    When Adding some vegetables in the cart
    Then I check out and select country as "<country>"
    And I verify order placed successfully
    
    Examples:
      | country |
      | Andorra |

  #@Flightbooking
  #Scenario Outline: Login and Searching the Flight
    #Given Launching browser and navigate to the website
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
