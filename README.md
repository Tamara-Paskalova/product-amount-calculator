# product-amount-calculator

This is a wab application that read data from different sources
in JSON format and calculate the total amount for each referenced 
product. Spring Boot convert result list in JSON, so you can see the 
response as JSON as well.

#### Technologies used:

- Spring Boot
- Hibernate
- in-memory H2 database
- Java 11
- Maven

Thanks used strategy you can add another implementations and read data from 
different sources. 

Controllers:

`POST: /products` - reads data from passed source and save it in DB

`GET: /products` - provides response with "joined" data from DB

If you use Postman for testing, it will look like this:

`http://localhost:8080/products?source=src/main/resources/data.json`

![2021-09-23 (3)](https://user-images.githubusercontent.com/83809337/134577972-885cee4a-1e6d-4cba-9d48-2d5a78c50937.png)

`http://localhost:8080/products?source=https://sciforce.solutions/downloads/sciforce-java-test1.json`

![2021-09-23 (4)](https://user-images.githubusercontent.com/83809337/134578043-5993f98e-45b9-47bd-8771-8535d459ea88.png)

`http://localhost:8080/products`

![2021-09-23 (5)](https://user-images.githubusercontent.com/83809337/134578149-ca5b7e50-c96b-431a-9fdc-778bc94517ce.png)





