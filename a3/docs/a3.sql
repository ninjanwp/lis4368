CREATE DATABASE IF NOT EXISTS np22i;
USE np22i;

-- Store Table
CREATE TABLE store (
    store_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state CHAR(2) NOT NULL,
    zip CHAR(9) NOT NULL,
    phone BIGINT UNSIGNED NOT NULL,
    url VARCHAR(255),
    ytd_sales DECIMAL(10,2) NOT NULL,
    notes TEXT
);

-- Customer Table
CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state CHAR(2) NOT NULL,
    zip CHAR(9) NOT NULL,
    phone BIGINT UNSIGNED NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    balance DECIMAL(10,2) DEFAULT 0,
    total_sales DECIMAL(10,2) DEFAULT 0,
    notes TEXT
);

-- Pet Table
CREATE TABLE pet (
    pet_id INT AUTO_INCREMENT PRIMARY KEY,
    store_id INT NOT NULL,
    customer_id INT DEFAULT NULL,
    type VARCHAR(50) NOT NULL,
    sex ENUM('Male', 'Female') NOT NULL,
    cost DECIMAL(10,2) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    age INT NOT NULL,
    color VARCHAR(50) NOT NULL,
    sale_date DATE DEFAULT NULL,
    vaccine BOOLEAN DEFAULT FALSE,
    neuter BOOLEAN DEFAULT FALSE,
    notes TEXT,
    FOREIGN KEY (store_id) REFERENCES store(store_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
        ON UPDATE CASCADE ON DELETE SET NULL
);

-- Insert records into store table
INSERT INTO store (name, street, city, state, zip, phone, url, ytd_sales, notes) VALUES
('Pet Paradise', '123 Main St', 'Miami', 'FL', '33101', 3055551234, 'http://petparadise.com', 50000.00, 'Popular pet store'),
('Furry Friends', '456 Elm St', 'Orlando', 'FL', '32801', 4075552345, 'http://furryfriends.com', 75000.00, 'Known for exotic pets'),
('Happy Paws', '789 Oak St', 'Tampa', 'FL', '33601', 8135553456, 'http://happypaws.com', 62000.00, 'Specializes in dog breeds'),
('Whiskers & Wings', '101 Maple Ave', 'Jacksonville', 'FL', '32201', 9045554567, NULL, 41000.00, 'Carries birds and rodents'),
('Critter Haven', '202 Pine St', 'Fort Lauderdale', 'FL', '33301', 9545555678, 'http://critterhaven.com', 83000.00, 'Wide variety of pets'),
('Tropical Pets', '303 Birch Rd', 'Key West', 'FL', '33040', 7865556789, NULL, 72000.00, 'Known for tropical pets'),
('Exotic Creatures', '404 Cedar Blvd', 'Gainesville', 'FL', '32601', 3525557890, 'http://exoticcreatures.com', 65000.00, 'Carries rare species'),
('Paw Palace', '505 Spruce Dr', 'Naples', 'FL', '34101', 2395558901, NULL, 71000.00, 'High-end pet store'),
('Wild World', '606 Redwood Ln', 'Pensacola', 'FL', '32501', 8505559012, 'http://wildworld.com', 53000.00, 'Carries reptiles and amphibians'),
('Little Critters', '707 Sycamore Ct', 'Tallahassee', 'FL', '32301', 8505551122, 'http://littlecritters.com', 67000.00, 'Known for rodents and fish');

-- Insert records into customer table
INSERT INTO customer (first_name, last_name, street, city, state, zip, phone, email, balance, total_sales, notes) VALUES
('John', 'Doe', '1234 River Rd', 'Miami', 'FL', '33102', 3057771234, 'johndoe@example.com', 0.00, 1200.00, 'Frequent buyer'),
('Jane', 'Smith', '5678 Palm St', 'Orlando', 'FL', '32802', 4078882345, 'janesmith@example.com', 25.00, 800.00, NULL),
('Robert', 'Brown', '9101 Beach Ave', 'Tampa', 'FL', '33602', 8139993456, 'robertbrown@example.com', 0.00, 500.00, 'Owns multiple pets'),
('Emily', 'Davis', '1123 Ocean Dr', 'Jacksonville', 'FL', '32202', 9046664567, 'emilydavis@example.com', 15.00, 620.00, 'Prefers exotic pets'),
('Michael', 'Wilson', '2234 Sunset Blvd', 'Fort Lauderdale', 'FL', '33302', 9542225678, 'michaelwilson@example.com', 0.00, 1400.00, 'Has a large dog'),
('Sarah', 'Miller', '3345 Mountain Rd', 'Key West', 'FL', '33041', 7863336789, 'sarahmiller@example.com', 30.00, 720.00, NULL),
('David', 'Anderson', '4456 Forest Ln', 'Gainesville', 'FL', '32602', 3524447890, 'davidanderson@example.com', 10.00, 530.00, 'Looking for a bird'),
('Olivia', 'Thomas', '5567 Valley Dr', 'Naples', 'FL', '34102', 2395558901, 'oliviathomas@example.com', 0.00, 690.00, 'Prefers cats'),
('James', 'Martinez', '6678 Greenway Rd', 'Pensacola', 'FL', '32502', 8506669012, 'jamesmartinez@example.com', 5.00, 580.00, NULL),
('Emma', 'Taylor', '7789 Riverbend Ct', 'Tallahassee', 'FL', '32302', 8507771122, 'emmataylor@example.com', 0.00, 810.00, 'Loves reptiles');

-- Insert records into pet table
INSERT INTO pet (store_id, customer_id, type, sex, cost, price, age, color, sale_date, vaccine, neuter, notes) VALUES
(1, 1, 'Dog', 'Male', 500.00, 1200.00, 2, 'Brown', '2024-02-10', TRUE, FALSE, 'Golden Retriever'),
(2, 2, 'Cat', 'Female', 200.00, 800.00, 1, 'Black', '2024-01-20', TRUE, TRUE, 'Persian Cat'),
(3, 3, 'Parrot', 'Male', 150.00, 500.00, 3, 'Green', '2024-03-05', FALSE, FALSE, 'Amazon Parrot'),
(4, 4, 'Iguana', 'Male', 100.00, 620.00, 4, 'Green', '2024-04-01', FALSE, FALSE, 'Loves climbing'),
(5, 5, 'Dog', 'Female', 600.00, 1400.00, 2, 'White', '2024-02-28', TRUE, TRUE, 'Samoyed'),
(6, 6, 'Fish', 'Male', 10.00, 720.00, 1, 'Blue', '2024-05-15', FALSE, FALSE, 'Betta Fish'),
(7, 7, 'Bird', 'Female', 80.00, 530.00, 2, 'Yellow', '2024-06-10', FALSE, FALSE, 'Canary'),
(8, 8, 'Hamster', 'Male', 20.00, 690.00, 1, 'Brown', '2024-07-08', FALSE, FALSE, 'Syrian Hamster'),
(9, 9, 'Snake', 'Female', 300.00, 580.00, 3, 'Red', '2024-08-12', FALSE, FALSE, 'Corn Snake'),
(10, 10, 'Turtle', 'Male', 50.00, 810.00, 5, 'Green', '2024-09-05', FALSE, FALSE, 'Red-Eared Slider');
