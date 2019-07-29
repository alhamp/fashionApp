CREATE TABLE fashion_item_reviews (
id SERIAL PRIMARY KEY,
user_id INTEGER REFERENCES users(id),
body_Type VARCHAR(255),
style VARCHAR(255),
item_size INTEGER ,
quality INTEGER,
comment VARCHAR(255),
photo VARCHAR(255)
);