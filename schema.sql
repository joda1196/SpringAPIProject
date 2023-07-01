Table: Product
Columns:
- product_id (Primary Key)
- name
- description
- price
- reviews

Table: Review
Columns:
- review_id (Primary Key)
- product_id (Foreign Key referencing Product.product_id)
- rating
- comment

Table: Category
Columns:
- category_id (Primary Key)
- name

Table: Review_Product (Many-to-many relationship between Product and Category)
Columns:
- product_id (Foreign Key referencing Product.product_id)
- category_id (Foreign Key referencing Category.category_id)
