Feature:  End to end test for tools QA Books API
  Description: This is a sample featuere file to test the end to end

  Background: user generates token code
      Given user enters credentials to generate token code

    Scenario: authorised user is able to add and remove book
      Given a list of books are available
      When  i add a book
      Then  a book is added
      When  i remove a book
      Then  the book is removed


