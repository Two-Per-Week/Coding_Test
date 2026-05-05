SELECT YEAR(ed.differentiation_date) AS YEAR,
    e.max_size - ed.size_of_colony AS YEAR_DEV,
    ed.id AS ID
FROM ecoli_data ed
JOIN (
    SELECT YEAR(differentiation_date) AS year, MAX(size_of_colony) AS max_size 
    FROM ecoli_data 
    GROUP BY year
) e ON e.year = YEAR(ed.differentiation_date)
ORDER BY YEAR, YEAR_DEV ASC
