# Uniform Tracker 
## For Wellington Regional Hospital CCDHB

## Introduction
The Wellington Regional Hospital Nursing Bureau - required a new Uniform tracker to manage and procure their uniform for staff across wards. 
The application will consist of the following services which will be developed in stages.

* Inventory Service (In development)
* Order Service
* Issuing Service

The Services will be designed in such a way so they can work indepdently from one another with low coupling and high cohesion.
Initially the inventory service will be developed and put into use with the Admin staff to ensure that functionality is appropriate for the business case.

## Inventory Service

### Design
The back-end API of the application is built using Java Springboot with a PostgreSQL database running on a docker container. 
The front-end will be designed using React.js. 

### Progress
Currently the Inventory service supports basic functionality where you can edit the quantities of the uniform listed in the database using the front-end react application. 
Testing has been completed using Insomnia to ensure the Back-end Inventory API is working. The following requests are supported

* GET - Retrieve all inventory items
* PUT - Update an item in the inventory, eg. update the quantity in stock
* DELETE - Delete an item in the inventory
* POST - Add a new item to the inventory
* GET - Retrieve a single item from the inventory

**Please note only the PUT functionality is currently supported in the front-end application**
In this business case, it may not be neccessary for the application to support adding new Unifrom items to the inventory. However this may need to be added later through the development. 

### Running the Inventory Service
1. Clone the Repo https://github.com/hamtana/Uniform-Tracker
2. For the front-end you will need to install node/npm, then run `npm install` to install the depdendencies required to run the front-end.
3. Run `docker compose up` inside the Database directory. This will generate a database automatically using the file init.sql
4. For the Backend open the project inside VS Code or an equivalent application
5. Run `gradle build`, followed by `gradle run` to run the application.
6. In a browser run `localhost:3000` to access the the front-end. 

## Order Service
To be developed

## Issuing Service
To be developed
