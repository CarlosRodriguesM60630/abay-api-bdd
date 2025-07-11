Feature: Product search

  Scenario: Search products by category
    Given there are products in the category 'Electronics'
    When I search for products in 'Electronics'
    Then I should see all products listed under 'Electronics'

  Scenario: Filter products by price range
    Given there are products priced between 10 and 50
    When I search for products with a price between 20 and 30
    Then I should see only products within the 20–30 price range

  Scenario: Combine filters for refined search
    Given there are active Electronics products under 50
    When I search for active products in 'Electronics' with price < 50
    Then I should see only matching results
