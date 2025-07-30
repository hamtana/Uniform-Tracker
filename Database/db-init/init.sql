-- Create user
CREATE USER uniform_user WITH PASSWORD 'secretpassword';

-- Create database
CREATE DATABASE "UniformManagement" OWNER uniform_user;

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE "UniformManagement" TO uniform_user;

-- Connect to the new database
\connect "UniformManagement"

-- Inventory table
CREATE TABLE Inventory (
    InventoryID VARCHAR(50) PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Scan_Code VARCHAR(100),
    Size VARCHAR(2),
    Quantity_In_Stock INTEGER NOT NULL DEFAULT 0,
    Cost DECIMAL(10, 2) NOT NULL
);

-- Users table
CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Manager table
CREATE TABLE Manager (
    managerId SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL
);

-- Staff table (each staff belongs to a manager)
CREATE TABLE Staff (
	staffId SERIAL PRIMARY KEY,
    email VARCHAR(100),
    name VARCHAR(100) NOT NULL,
    managerEmail VARCHAR(100) NOT NULL,
    CONSTRAINT FK_Staff_Manager FOREIGN KEY (managerEmail) REFERENCES Manager(email)
);

-- Order table (created before Inventory_Item so FK can reference it)
CREATE TABLE Orders (
    orderId SERIAL PRIMARY KEY,
	staffEmail VARCHAR(100),
	status VARCHAR(20) DEFAULT 'PENDING'; -- values: PENDING, PARTIAL, FULFILLED
	orderDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FK_Staff FOREIGN KEY (staffEmail) REFERENCES Staff(email)
);

-- Inventory_Item table, now linking Inventory to Orders
CREATE TABLE Inventory_Item (
	id SERIAL PRIMARY KEY,
    orderId INTEGER NOT NULL,
    InventoryID VARCHAR(50) NOT NULL,
    quantity_ordered INTEGER NOT NULL DEFAULT 0,
	quantity_fulfilled INTEGER,
    CONSTRAINT FK_InventoryItem_Inventory FOREIGN KEY (InventoryID) REFERENCES Inventory(InventoryID),
    CONSTRAINT FK_InventoryItem_Order FOREIGN KEY (OrderId) REFERENCES Orders(OrderId)
);
