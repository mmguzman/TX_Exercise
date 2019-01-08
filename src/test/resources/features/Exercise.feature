@Test
  Feature: Exercise

    Scenario: Automation Exercise
      Given I navigate to MyStore page
      When I select "Women" tab
        And I select "Summer Dresses" in "Dresses" category
        And I select "L" size
        And I select "Yellow" color filter
        And I select "Price: Lowest first" in Sort By option
      Then Verify that "Printed Chiffon Dress" is displayed with a price of "$16.40" at "1" position
        And Verify that "Printed Summer Dress" is displayed with a price of "$28.98" at "2" position
        And Verify that the listed items have ascendant ordering by the price