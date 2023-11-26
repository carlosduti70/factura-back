CREATE TABLE IF NOT EXISTS client (
    id SERIAL,
    nui VARCHAR(13) NOT NULL,
    fullname VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS product (
    id SERIAL,
    description VARCHAR(250) NOT NULL,
    brand VARCHAR(20) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS invoice (
    id SERIAL,
    code VARCHAR(30) NOT NULL,
    create_at DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES client(id)
    );

CREATE TABLE IF NOT EXISTS detail (
    id SERIAL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    invoice_id INT,
    product_id INT,
    FOREIGN KEY (invoice_id) REFERENCES invoice(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
    );