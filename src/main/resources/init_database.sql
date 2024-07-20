USE LpStocker;

-- Create table Product
CREATE TABLE IF NOT EXISTS Product (
                                       product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       product_name VARCHAR(255) NOT NULL UNIQUE,
                                       product_price DECIMAL(10, 2) NOT NULL,
                                       product_description VARCHAR(255) NOT NULL,
                                       product_category ENUM('Electronics', 'Books', 'Clothing', 'Toys', 'other') NOT NULL
);

-- Create table Stock
CREATE TABLE IF NOT EXISTS Stock (
                                     stock_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     stock_name VARCHAR(255) NOT NULL UNIQUE,
                                     stock_totalcapacity BIGINT NOT NULL,
                                     stock_currentOccupation BIGINT NOT NULL
);

-- Create table ProductStock
CREATE TABLE IF NOT EXISTS ProductStock (
                                            product_id BIGINT NOT NULL,
                                            stock_id BIGINT NOT NULL,
                                            quantity INTEGER NOT NULL,
                                            PRIMARY KEY (product_id, stock_id),
                                            FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE,
                                            FOREIGN KEY (stock_id) REFERENCES Stock(stock_id) ON DELETE CASCADE
);