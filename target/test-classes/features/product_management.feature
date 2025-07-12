Feature: Product management

  Scenario: Seller creates a new product
    Given I am a logged-in seller
    When I create a product titled 'Wireless Mouse' with 10 units, category 'Electronics' and price 25.99
    Then the product "Wireless Mouse" should be listed

  Scenario: Seller updates a product's description
    Given the product 'Wireless Mouse' exists
    When I update the description of 'Wireless Mouse' to 'Ergonomic wireless mouse with USB-C'
    Then the product description should be updated

  Scenario: Seller deletes a product
    Given the product 'Old Laptop' exists
    When I delete the product 'Old Laptop'
    Then the product 'Old Laptop' should no longer be listed