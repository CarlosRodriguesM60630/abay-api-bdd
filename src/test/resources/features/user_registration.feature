Feature: User registration

    Scenario: Admin creates a new user
        When I make the call "/api/users"
        Then I create a new user with the name 'Carlos', username 'carlos123', email 'carlos123@gmail.com' and password 'test1234'
        And the user 'carlos123' should be created successfully