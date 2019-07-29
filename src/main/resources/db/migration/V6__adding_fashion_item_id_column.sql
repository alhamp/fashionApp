ALTER TABLE fashion_item_reviews
ADD COLUMN fashion_item_id INTEGER REFERENCES fashion_items(id);
