Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  Scenario Outline: Validate the URLs for Fruits
    When he calls endpoint "<URL>"
    Then he sees the results displayed for "<FRUIT>"
    Examples:
      | URL | FRUIT |
      | https://waarkoop-server.herokuapp.com/api/v1/search/test/apple | Apple |
      | https://waarkoop-server.herokuapp.com/api/v1/search/test/mango | Mango |

    Scenario: Verify no results are returned for values other than fruits
      When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/test/car"
      Then Verify no results are displayed