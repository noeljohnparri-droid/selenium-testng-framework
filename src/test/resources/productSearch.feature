Feature: Laptop search on Amazon
Scenario:Customer searches Laptop and filters price 

Given user launches Amazon website 
When user finds searchbar, gives input as laptop and enters 
And user takes screenshot of the page and clicks on price filter
And user takes screenshot of the page after clicking price filter
Then prices on the laptop should show difference 


