SELECT product_id, product_name, product_cd, category, price
FROM food_product
where price = (
    SELECT max(price) FROM food_product
)
