Feature: Smoke
  As a user
  I want to test at least main site functionality
  So I would be sure that it works correctly

  Scenario Outline: Check add one product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product in goods list
    Then User checks that amount of products in cart is '<amountOfProducts>'

    Examples:
      | homePage              | keyword              | amountOfProducts |
      | https://www.ebay.com  | crystal sphere ball  | 1                |
      | https://www.ebay.com  | i7 laptop hp         | 1                |

  Scenario Outline: Check that items per page appears according to the quantity selected by
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that quantity of found items equals items per page

    Examples:
      | homePage              | keyword  |
      | https://www.ebay.com  | milk     |

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks search field visibility
    And User checks cart icon visibility
    And User checks that language switcher is '<languageSwitcher>'
    And User checks register button visibility
    And User checks sign in button visibility
    When User clicks 'Sign In' button
    And User checks email and password fields visibility on sign in popup
    And User closes sign in popup
    And User opens store popup
    And User checks that store popup visible
    And User opens shopping cart
    And User checks that shopping cart title visible
    And User clicks language button
    Then User checks that current url contains 'fr' language

    Examples:
      | homePage                            | languageSwitcher |
      | https://www.canadiantire.ca/en.html | Français         |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks 'Add to Cart' button on product
    And User checks that add to cart popup visible
    And User checks 'Continue Shopping' button visibility
    And User checks 'Continue to Cart' button visibility
    Then User checks that add to cart popup header is '<header>'
    And User clicks 'Continue to Cart' button
    And User clicks 'Checkout' button
    And User clicks payment cart button
    And User checks payment form visibility
    And User checks billing form visibility
    And User checks 'Complete Order' button visibility

    Examples:
      | homePage                            | keyword  | header                                |
      | https://www.canadiantire.ca/en.html | 0830187p | You have added 1 item(s) to your cart |

