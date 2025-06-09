-- Create user
CREATE USER uniform_user WITH PASSWORD 'secretpassword';

-- Create database
CREATE DATABASE "UniformManagement" OWNER uniform_user;

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE "UniformManagement" TO uniform_user;

-- Connect to the new database
\connect "UniformManagement"

-- Create the Inventory table
CREATE TABLE Inventory (
    InventoryID VARCHAR(50) PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Scan_Code VARCHAR(100),
    Size VARCHAR(2),
    Quantity_In_Stock INTEGER NOT NULL DEFAULT 0,
    Cost DECIMAL(10, 2) NOT NULL
);

-- Create the User Table
CREATE TABLE Users (
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	role VARCHAR(20) NOT NULL
);

