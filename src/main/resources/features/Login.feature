Feature: Login functionality

  Background: Land to Home page
    Given Go to login page

    @test
    Scenario: Positive: Login with valid credentials as User

      Given user should click on email button
      And Enter "test_2022test" in UserName input field
      Then  user click enter button
      And Enter "zadacha11" in password input field
      When  user click button enter
      Then user should successfully logged in
      And user presses the mail button
      And user should click the write a letter button
      Then Enter "talgat1103@gmail.com" fill in the to field
      Then Enter "TEST TEST" fill subject field
      Then Enter "Hello!!" fill in the text of the letter
      When  user click button sent
      Then user should go to the sent folder


