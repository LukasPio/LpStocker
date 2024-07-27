# Stock Manager API

The **LpStocker** is a robust solution developed in Java with Spring Boot for managing inventory in small/medium commerces. Utilizing MySQL as the database, the API allows for the creation, retrieval, update, and deletion of information related to products, inventory, and associations between products and inventories.

---

## Readme Sumary

- [Key Features](#key-features)
  - [Product Management](#product-management)
  - [Inventory Management](#inventory-management)
  - [Product-Inventories Association](#product-inventories-association)
- [Data Structure](#data-structure)
  - [Table: Product](#table-product)
  - [Table: Stock](#table-stock)
  - [Table: ProductStock](#table-productstock)
- [API Endpoints](#api-endpoints)
  - [Products](#products)
  - [Inventories](#inventories)
  - [Product-Inventory Association](#product-inventory-association)
- [Technologies Used](#technologies-used)

---

## Key Features

### Product Management

- **Add, view, update, and remove products.**
- Each product has a unique ID, name, price, description, and category.

---

### Inventory Management

- **Add, view, update, and remove inventories.**
- Each inventory has a unique ID, name, total capacity, and current occupation.

---

### Product-Inventories Association

- **Link products to specific inventories, including the available quantity.**
- Keep inventory control updated and accurate.

---

## Data Structure

### Table: `Product`

- **`product_id`**: Primary key, type BIGINT.
- **`product_name`**: Product name, type VARCHAR.
- **`product_price`**: Product price, type DECIMAL.
- **`product_description`**: Product description, type VARCHAR.
- **`product_category`**: Product category, type ENUM.

---

### Table: `Stock`

- **`stock_id`**: Primary key, type BIGINT.
- **`stock_name`**: Inventory name, type VARCHAR.
- **`stock_totalcapacity`**: Total capacity of the inventory, type BIGINT.
- **`stock_currentOccupation`**: Current occupation of the inventory, type BIGINT.

---

### Table: `ProductStock`

- **`product_id`**: Foreign key referencing `Product`, type BIGINT.
- **`stock_id`**: Foreign key referencing `Stock`, type BIGINT.
- **`quantity`**: Quantity of the product in the inventory, type INTEGER.
- **PK (product_id, stock_id)**: Composite primary key of `product_id` and `stock_id`.

---

## API Endpoints

### Products

<details>
<summary><strong>GET /products</strong></summary>

- **Response:**
    ```json
    [
      {
        "product_id": 1,
        "product_name": "Example Product",
        "product_price": 19.99,
        "product_description": "Description of the product.",
        "product_category": "Electronics"
      }
    ]
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **500 Internal Server Error**
    - **Response:**
      ```json
      {
        "code": 500,
        "message": "Internal server error."
      }
      ```
</details>

<details>
<summary><strong>GET /products/{id}</strong></summary>

- **Response:**
    ```json
    {
      "product_id": 1,
      "product_name": "Example Product",
      "product_price": 19.99,
      "product_description": "Description of the product.",
      "product_category": "Electronics"
    }
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **404 Not Found**
    - **Response:**
      ```json
      {
        "code": 404,
        "message": "Product not found."
      }
      ```
</details>

<details>
<summary><strong>POST /products</strong></summary>

- **Request Body:**
    ```json
    {
      "product_name": "New Product",
      "product_price": 29.99,
      "product_description": "Description of the new product.",
      "product_category": "Books"
    }
    ```

- **Possible Responses:**
  - **201 Created**
    - **Response:**
      ```json
      {
        "code": 201,
        "message": "Product created successfully."
      }
      ```
  - **400 Bad Request**
    - **Response:**
      ```json
      {
        "code": 400,
        "message": "Invalid request data."
      }
      ```
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
</details>

<details>
<summary><strong>PUT /products/{id}</strong></summary>

- **Request Body:**
    ```json
    {
      "product_name": "Updated Product",
      "product_price": 24.99,
      "product_description": "Updated description of the product.",
      "product_category": "Home Appliances"
    }
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **404 Not Found**
    - **Response:**
      ```json
      {
        "code": 404,
        "message": "Product not found."
      }
      ```
  - **400 Bad Request**
    - **Response:**
      ```json
      {
        "code": 400,
        "message": "Invalid request data."
      }
      ```
</details>

<details>
<summary><strong>DELETE /products/{id}</strong></summary>

- **Response:**
    ```json
    {
      "message": "Product deleted successfully."
    }
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **404 Not Found**
    - **Response:**
      ```json
      {
        "code": 404,
        "message": "Product not found."
      }
      ```
</details>

---

### Inventories

<details>
<summary><strong>GET /stocks</strong></summary>

- **Response:**
    ```json
    [
      {
        "stock_id": 1,
        "stock_name": "Main Warehouse",
        "stock_totalcapacity": 1000,
        "stock_currentOccupation": 250
      }
    ]
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
</details>

<details>
<summary><strong>GET /stocks/{id}</strong></summary>

- **Response:**
    ```json
    {
      "stock_id": 1,
      "stock_name": "Main Warehouse",
      "stock_totalcapacity": 1000,
      "stock_currentOccupation": 250
    }
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **404 Not Found**
    - **Response:**
      ```json
      {
        "code": 404,
        "message": "Inventory not found."
      }
      ```
</details>

<details>
<summary><strong>POST /stocks</strong></summary>

- **Request Body:**
    ```json
    {
      "stock_name": "New Warehouse",
      "stock_totalcapacity": 1500,
      "stock_currentOccupation": 0
    }
    ```

- **Possible Responses:**
  - **201 Created**
    - **Response:**
      ```json
      {
        "code": 201,
        "message": "Inventory created successfully."
      }
      ```
  - **400 Bad Request**
    - **Response:**
      ```json
      {
        "code": 400,
        "message": "Invalid request data."
      }
      ```
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
</details>

<details>
<summary><strong>PUT /stocks/{id}</strong></summary>

- **Request Body:**
    ```json
    {
      "stock_name": "Updated Warehouse",
      "stock_totalcapacity": 1200,
      "stock_currentOccupation": 300
    }
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **404 Not Found**
    - **Response:**
      ```json
      {
        "code": 404,
        "message": "Inventory not found."
      }
      ```
  - **400 Bad Request**
    - **Response:**
      ```json
      {
        "code": 400,
        "message": "Invalid request data."
      }
      ```
</details>

<details>
<summary><strong>DELETE /stocks/{id}</strong></summary>

- **Response:**
    ```json
    {
      "message": "Inventory deleted successfully."
    }
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **404 Not Found**
    - **Response:**
      ```json
      {
        "code": 404,
        "message": "Inventory not found."
      }
      ```
</details>

---

### Product-Inventory Association

<details>
<summary><strong>POST /products/{productId}/stocks/{stockId}</strong></summary>

- **Request Body:**
    ```json
    {
      "quantity": 50
    }
    ```

- **Possible Responses:**
  - **201 Created**
    - **Response:**
      ```json
      {
        "code": 201,
        "message": "Product-stock association created successfully."
      }
      ```
  - **400 Bad Request**
    - **Response:**
      ```json
      {
        "code": 400,
        "message": "Invalid request data."
      }
      ```
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **404 Not Found**
    - **Response:**
      ```json
      {
        "code": 404,
        "message": "Product or inventory not found."
      }
      ```
</details>

<details>
<summary><strong>PUT /products/{productId}/stocks/{stockId}</strong></summary>

- **Request Body:**
    ```json
    {
      "quantity": 75
    }
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **404 Not Found**
    - **Response:**
      ```json
      {
        "code": 404,
        "message": "Product or inventory not found."
      }
      ```
  - **400 Bad Request**
    - **Response:**
      ```json
      {
        "code": 400,
        "message": "Invalid request data."
      }
      ```
</details>

<details>
<summary><strong>DELETE /products/{productId}/stocks/{stockId}</strong></summary>

- **Response:**
    ```json
    {
      "message": "Product-stock association deleted successfully."
    }
    ```

- **Possible Errors:**
  - **401 Unauthorized**
    - **Response:**
      ```json
      {
        "code": 401,
        "message": "Unauthorized access."
      }
      ```
  - **404 Not Found**
    - **Response:**
      ```json
      {
        "code": 404,
        "message": "Product or inventory not found."
      }
      ```
</details>

---

## Technologies Used

- **Java 17**: Programming language for the backend.
- **Spring Boot 3.3.2**: Framework for building the REST API.
- **MySQL 8.4.1**: Database for storing product and inventory data.
- **Docker 27.0.3**: Technologie for containerizing and managing the database.
