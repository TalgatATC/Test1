Feature: Login functionality

  Background: Land to Home page
    Given Go to login page

    @test
    Scenario: Positive: Login with valid credentials as User
      Given user should enter button and click
      And Enter "test_2022test" in UserName input field
      Then  user click enter button
      And Enter "zadacha11" in password input field
      When  user click button enter
      Then user should successfully logged in
