CREATE DATABASE IF NOT EXISTS spring_framework_core;
USE spring_framework_core;

-- =======================
-- Customers Table
-- =======================
CREATE TABLE IF NOT EXISTS customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =======================
-- Products Table
-- =======================
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =======================
-- Orders Table
-- =======================
CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
        ON DELETE CASCADE
);

-- =======================
-- Order Items Table
-- =======================
CREATE TABLE IF NOT EXISTS order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id)
        ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id)
        ON DELETE CASCADE
);

-- =======================
-- Seed Data (optional)
-- =======================
INSERT INTO customers (name, email) VALUES 
    ('Alice Johnson', 'alice@example.com'),
    ('Bob Smith', 'bob@example.com')
ON DUPLICATE KEY UPDATE name=VALUES(name);

INSERT INTO products (name, description, price, stock) VALUES
    ('Laptop', 'Gaming Laptop', 1200.00, 10),
    ('Phone', 'Smartphone 5G', 700.00, 20),
    ('Headphones', 'Noise Cancelling', 150.00, 50)
ON DUPLICATE KEY UPDATE name=VALUES(name);

