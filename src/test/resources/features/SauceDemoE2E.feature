Feature: SauceDemo E2E test

  Scenario: E2E test
    Given open browser
    And open login page
    And user with username "standard_user" with password "secret_sauce" logged in
    And add item to the cart
    And open cart page
    And go to checkout and input data - name: "Andrew" , lastname: "Moroz", zipcode: "30-605"
    When checkout successful
    Then finish page opened
