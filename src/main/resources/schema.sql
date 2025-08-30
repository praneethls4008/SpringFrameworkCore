CREATE DATABASE IF NOT EXISTS spring_framework_core;
USE spring_framework_core;

CREATE TABLE IF NOT EXISTS studentjdbc (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL
);