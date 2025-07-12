Feature: Product category management

  Scenario: Admin creates a category
    Given I am an administrator
    When I create a new category named 'Books'
    Then the category 'Books' should be available in the platform

  Scenario: Admin creates a subcategory
    Given the category 'Books' exists
    When I create a subcategory named 'Science Fiction' under 'Books'
    Then 'Science Fiction' should be listed as a subcategory of 'Books'

  Scenario: Admin deletes a category
    Given the category 'Furniture' exists
    When I delete the category 'Furniture'
    Then the category 'Furniture' should no longer exist