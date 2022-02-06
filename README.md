# Customers' purchases Manager
- Author: Sze Ming Chan (jack_chan_@hotmail.com)
- Source: <https://github.com/jacksmchan/DFESW7_Final-Project>

## What is it?
Customers' purchases Manager (CPM) is used to help manager in tracing the storage of products, customers as well as their purchase history.

## Knowledge/tools Required
- JDK v11
- Maven v3.8.4
- SpringBoot v2.1.3.RELEASE
- H2 v1.4.197
- Hibernate v5.3.7.Final
- Git v2.34.1.windows.1

## Development Guide
1. Install JDK v1.8+
1. Install Maven v3.8+
1. Install Git v2.34.1.windows.1+
1. Clone the source code ```git clone https://github.com/jacksmchan/DFESW7_Final-Project.git```
1. Run ```mvn spring-boot:run``` under the root of this project

## Why are we doing this?
This is the final project of my QA Academy Software DEvelopment Bootcamp course. This project would cover what I have learnt of this 9 weeks coures including Java coding, Spring Boot API (CRUD functionality), database and project management.

## How I expected the challenge to go
We need to complete a workable app within a limited time. Time management is a key factor to finish the work in a week which is part of the real situation in real life. Although this is an individual project, we can have some support from the trainers. How to solve the issues during the development that something I need to manage. 

## What went well?
Due the limited timeframe. The project needs to be realistric and achievable to deploy on time. Breaking down the project into different stages that helps a bit on project planning and execution.

## What didn't go as planned?
Some issues happended after upgraded from Windows 10 to Windows 11. I need to re-install Eclipse, Java and Maven. I only have limited experience on GitHub. It took me some additional time to sort things out.

## Possible improvements for future revision of the project.
A proper UI is required to meet industry standard.

## Postman screenshot
1. Import ```supporting\jacksmchan.postman_collection.json``` with Postman  
   ![This is an image](supporting/Postman.png)
1. Request ```List all products``` is used to list all products
1. Request ```List all customers``` is used to list all customers
1. Request ```List all invoices``` is used to list all invoices
2. ![GET](https://user-images.githubusercontent.com/94961207/152681936-0e10ebe9-9369-4c54-b290-86a7b8cdc2e6.png)
3. Request ```Add a product``` is used to add a product
4. Request ```Add a customer``` is used to add a customer
5. Request ```Add an invoice``` is used to add an invoice
6. ![POST](https://user-images.githubusercontent.com/94961207/152682085-37125e2d-9d62-4ad7-bb87-16fe8ad8edeb.png)
7. Request ```Update a product``` is used to update a product
8. Request ```Update a customer``` is used to update a customer
9. Request ```Update an invoice``` is used to update an invoice
10. ![PUT](https://user-images.githubusercontent.com/94961207/152682171-d0d8ed9e-10b6-457f-9a30-2ec0510691ba.png)
11. Request ```Find products by name``` is used to find all products whose name contains the given string
12. Request ```Find customers by name``` is used to find all customers whose name contains the given string
13. Request ```Find invoice by id``` is used to find the invoice by its id
14. ![GET](https://user-images.githubusercontent.com/94961207/152682236-eeba6994-7522-43a7-8b86-230d0f934b71.png)
15. Request ```Delete products by name``` is used to delete all products whose name contains the given string
16. Request ```Delete customers by name``` is used to delete all customers whose name contains the given string
17. Request ```Delete product by id``` is used to delete the product by its id
18. Request ```Delete customer by id``` is used to delete the customer by its id
19. Request ```Delete invoice by id``` is used to delete the invoice by its id
20. ![DEL](https://user-images.githubusercontent.com/94961207/152682258-2c8cdd83-c03c-4e84-b83a-e8e5a17d4333.png)

## Screenshots of database to prove that data is being persisted.

## Screenshots of test results
![Test Result](https://user-images.githubusercontent.com/94961207/152682322-638c102d-093c-416d-a801-073a40b94785.jpeg)

## Link to Jira board
https://jackchan.atlassian.net/jira/software/projects/FIN/boards/2
