CREATE TABLE items_styles(
  id SERIAL PRIMARY KEY,
  fashion_item_id INTEGER REFERENCES fashion_items(id),
  style_id INTEGER REFERENCES style(id)
);