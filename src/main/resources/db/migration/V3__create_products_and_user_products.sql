CREATE TABLE products (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(200) NOT NULL,
                          price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE user_products (
                               user_id BIGINT NOT NULL,
                               product_id BIGINT NOT NULL,

                               PRIMARY KEY (user_id, product_id),

                               CONSTRAINT fk_user_products_user
                                   FOREIGN KEY (user_id)
                                       REFERENCES users(id),

                               CONSTRAINT fk_user_products_product
                                   FOREIGN KEY (product_id)
                                       REFERENCES products(id)
);