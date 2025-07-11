Feature: Order management

  Scenario: User adds items to cart and places order
    Given I have added 2 units of Wireless Mouse to the cart
    When I proceed to checkout and make the payment
    Then the order should be created with state processing

  Scenario: User lists previous orders
    Given I have placed multiple orders
    When I request my order history
    Then I should see all my previous orders

  Scenario: User cancels a processing order
    Given I have a processing order with ID 123
    When I cancel order 123
    Then the order should be marked as 'canceled'

  Scenario: User cannot cancel a shipped order
    Given I have a shipped order with ID 456
    When I try to cancel order 456
    Then the action should be forbidden
