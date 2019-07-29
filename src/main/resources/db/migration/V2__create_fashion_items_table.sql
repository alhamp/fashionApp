CREATE TABLE fashion_items(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  photo VARCHAR(255),
  style_id INTEGER,
  measurements TEXT,
  quality INTEGER,
  fabric_weight INTEGER,
  clothing_type_id INTEGER,
  body_type VARCHAR(255),
  budget_id INTEGER,
  brand_id INTEGER,
  user_id INTEGER,
  item_size INTEGER
);
