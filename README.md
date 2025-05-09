# **Uniform Tracker**  
## **For Wellington Regional Hospital – CCDHB**

## **Introduction**  
The Wellington Regional Hospital Nursing Bureau required a new **Uniform Tracker** to manage and procure uniforms for staff across various wards.  
The application will consist of the following services, which will be developed in stages:

- **Inventory Service** *(In development)*  
- **Order Service**  
- **Issuing Service**

These services are designed to operate independently from one another, with **low coupling** and **high cohesion**.  
Initially, the **Inventory Service** will be developed and put into use by the Admin staff to ensure the functionality meets the business requirements.

---

## **Inventory Service**

### **Design**  
The back-end API is built using **Java Spring Boot**, with a **PostgreSQL** database running in a Docker container.  
The front-end is developed using **React.js**.

### **Progress**  
Currently, the Inventory Service supports basic functionality where uniform quantities listed in the database can be edited through the React-based front-end application.

Testing has been completed using **Insomnia** to ensure the back-end Inventory API functions correctly. The following endpoints are supported:

- `GET` – Retrieve all inventory items  
- `GET` – Retrieve a single inventory item  
- `POST` – Add a new inventory item  
- `PUT` – Update an inventory item (e.g., change quantity in stock)  
- `DELETE` – Delete an inventory item  

> **Note**: Only the `PUT` functionality is currently supported in the front-end application.  
> In this business case, it may not be necessary for the application to support adding new uniform items to the inventory. However, this functionality may be added later during development.

---

### **Running the Inventory Service**

1. **Clone the repository:**  
   [https://github.com/hamtana/Uniform-Tracker](https://github.com/hamtana/Uniform-Tracker)

2. **Front-end setup:**  
   - Install Node.js and npm.  
   - Navigate to the front-end directory and run:  
     ```bash
     npm install
     ```

3. **Database setup:**  
   - Navigate to the `Database` directory.  
   - Run:  
     ```bash
     docker compose up
     ```  
   - This will automatically initialize the PostgreSQL database using the `init.sql` file.

4. **Back-end setup:**  
   - Open the project in **VS Code** or an equivalent IDE.  
   - Run:  
     ```bash
     gradle build
     gradle run
     ```

5. **Access the application:**  
   - Open your browser and go to:  
     ```
     http://localhost:3000
     ```

---

## **Order Service**  
*To be developed*

## **Issuing Service**  
*To be developed*

