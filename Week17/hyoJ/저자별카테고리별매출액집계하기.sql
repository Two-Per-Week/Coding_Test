select a.author_id as AUTHOR_ID, 
    a.author_name as AUTHOR_NAME,
    b.category as CATEGORY,
    sum(b.price * bs.sales) as TOTAL_SALES
from book b
inner join book_sales bs on bs.book_id = b.book_id
inner join author a on a.author_id = b.author_id
where bs.sales_date between '2022-01-01' and '2022-01-31'
group by a.author_id, b.category
order by a.author_id ASC, b.category DESC
