SELECT i.ingredient_type AS INGREDIENT_TYPE, sum(f.total_order) AS TOTAL_ORDER
FROM first_half f
LEFT JOIN icecream_info i on i.flavor = f.flavor
GROUP BY i.ingredient_type
ORDER BY TOTAL_ORDER ASC
