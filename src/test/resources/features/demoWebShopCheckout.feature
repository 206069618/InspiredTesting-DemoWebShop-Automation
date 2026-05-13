Feature: Demo Web Shop checkout

  Scenario: User buys Build your own cheap computer using Cash On Delivery
    Given user launches Demo Web Shop
    And user logs in with valid credentials
    When user navigates to Desktops
    And user selects Build your own cheap computer
    And user adds the product to cart
    And user accepts terms and proceeds to checkout
    And user completes billing and shipping details
    And user selects Cash On Delivery payment method
    And user confirms the order
    Then order number should be captured

