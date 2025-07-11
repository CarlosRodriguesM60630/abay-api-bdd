Feature: User registration

    Scenario: Admin creates a new user
        Given I am an administrator
        When I create a new user with the name 'Carlos', username 'carlos123', email 'carlos123@gmail.com' and password 'test1234'
        Then the user 'carlos123' should be created successfully
    
    Scenario: Admin updates a user's email
        Given the user 'carlos123' exists
        When I update the email of user 'carlos123' to 'carlos123@test.com'
        Then the user 'carlos123' should have the email updated

    Scenario: Admin deletes a user
        Given the user "carlos123" exists
        When I delete the user "carlos123"
        Then the user "carlos123" should no longer exist

    Scenario: User cannot create another user
        Given I am a regular user
        When I try to create a new user
        Then the action should be forbidden