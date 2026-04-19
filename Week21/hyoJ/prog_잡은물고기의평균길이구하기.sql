SELECT 
    ROUND(SUM(IFNULL(length, 10)) / COUNT(ID), 2) AS average_length
FROM fish_info
