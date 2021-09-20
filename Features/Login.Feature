@tag
Feature: Login

  
  Scenario: Successful Login with Valid Credentials
  
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard/nopCommerce administration"
    When User click on Log out link
    Then page Title should be "Your store. Login"
    And close browser

  #@tag2
  #Scenario Outline: Login Data Driven
    #Given User Launch Chrome browser
    #When User opens URL "http://admin-demo.nopcommerce.com/login"
    #And User enters Email as "<email>" and Password as "<password>"
    #And Click on Login
    #Then Page Title should be "Dashboard / nopCommerce administration"
    #When User click on Log out link
    #Then page Title should be "Your store. Login"
    #And close browser
    #
    #Examples: 
      #| email  | password |
      #| admin@yourstore.com |  admi/in123  | 
