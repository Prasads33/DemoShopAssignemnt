Feature: Home Page
  As a user add four different products to my wishList
  So that i can filter the lowestPrice produc
  add item to myCart 

  Background:
    Given when user launch the shopping application
  
      
    @UserStory1
  Scenario:   Validate User should able to select product categories
    When Application is launched then user should select product from Clothing categories per his wish quantity in the wishlist
                |clothing|3|
                |watches|1|
    Then Select click on wishList
    Then Selected orders product quantities should match with wishlist table or page
    Then User should search for lower price product
    Then User Should able to add the lowest price item to myCart
    Then User should able to verify the same product in myCart
   	
  
