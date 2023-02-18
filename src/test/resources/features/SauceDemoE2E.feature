Feature: SauceDemo E2E test

  Scenario:
    Given login page is open
    * user "standart_user" with password "secret_sauce" logged in
    * add item in the cart
    * open cart page
    * open checkout page
    * input data for checkout name "Andrew", lastname "Moroz", zipcode "30-605"
    When checkout is completed
    Then open finish page