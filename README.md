# MediaApp

This project is created by [Saleh Hassan](https://github.com/ISaleh-Hassan) and [Johnny Hoang](https://github.com/flaakan).

Link to [Heroku](https://ancient-castle-33563.herokuapp.com/).

## Information
This program is seperated into two different services. Our program fetches information from a SQLite database.  
The information can be shown on our web page and also through our API.

### Web page
Our web page has two endpoints:
* `/` : This is the home page. It shows 5 diffrent genres, artists and tracks. It is also possible to search for a specific track.
* `/search` : This is the search result page. It will show tracks with the name you searched for.



### API
Our API is reached on /api. 
All of our endpoints starts with /api.
These are the usable endpoints:

* `/customer/all` : gets all customers
* `/customer/add` : Adds a customer, the customer object is sent in the requestbody.
* `/customer/update` : Updates a customer, the customer object is sent in the requestbody.
* `/customer/country/total` : Lists the count of users in all countries in descending order. 
* `/customer/top/spender` : Lists all customers and the total amount spent in descending order.
* `/customer/favorite/genre/{customerId}` : Shows the customers favorite genre based on what the customer has paid for.

#### Usage

![media app](https://user-images.githubusercontent.com/43730807/96605279-4becd880-12f6-11eb-9268-c290e4ffc4da.gif)
