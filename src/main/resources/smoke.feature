Feature: Smoke
  As a user
  I want to test at least main site functionality
  So I would be sure that it works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks cart icon visibility
    And User checks register button visibility
    And User checks sign in button visibility
    And User checks search field visibility
    And User checks categories button visibility
    When User clicks 'Register' button
    And User checks captcha popup visibility
    And User clicks store button
    And User checks that store button opens Home page
    And User opens shopping cart
    And User checks that shopping cart title visible
    Then User checks that cart is empty

    Examples:
      | homePage               |
      | https://www.ebay.com   |

  Scenario Outline: Check add one product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on <first> product in goods list
    And  User clicks 'Add to Cart' button on product
    Then User checks that amount of products in cart is '<amountOfProducts>'

    Examples:
      | homePage              | keyword              | amountOfProducts | first |
      | https://www.ebay.com  | i7 laptop hp         | 1                | 1     |

  Scenario Outline: Check that items per page appears according to the quantity selected by
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that quantity of found items equals items per page

    Examples:
      | homePage              | keyword  |
      | https://www.ebay.com  | milk     |
      | https://www.ebay.com  | ball     |


  Scenario Outline: Check add two products to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks Category list
    And User checks '<category>' from list
    And User clicks search button
    And User clicks on <prodNum1> product in goods list
    And User checks 'Buy It Now' button visibility
    And User clicks 'Add to Cart' button on product
    And User switches to product list tab
    And User clicks on <prodNum2> product in goods list
    And User clicks 'Add to Cart' button on product
    And User checks that add to cart popup visible
    Then User checks that add to cart popup header contains '<itemsCount>'
    And User checks 'Checkout' button visibility

    Examples:
      | homePage                | keyword  | category          | itemsCount | prodNum1 | prodNum2 |
      | https://www.ebay.com    | king     | Books & Magazines | 2 items    | 1        | 5        |

  Scenario Outline: Check remove from cart operation
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks Category list
    And User checks '<category>' from list
    And User clicks search button
    And User clicks on <prodNum1> product in goods list
    And User checks 'Buy It Now' button visibility
    And User clicks 'Add to Cart' button on product
    And User switches to product list tab
    And User clicks on <prodNum2> product in goods list
    And User clicks 'Add to Cart' button on product
    And User checks that add to cart popup visible
    And User checks that add to cart popup header contains '<itemsCount>'
    And User removes item from cart
    And User checks that add to cart popup visible
    Then User checks that add to cart popup header contains '<nextItemsCount>'

    Examples:
      | homePage                | keyword  | category          | itemsCount | prodNum1 | prodNum2 | nextItemsCount |
      | https://www.ebay.com    | king     | Books & Magazines | 2 items    | 1        | 5        | 1 item         |