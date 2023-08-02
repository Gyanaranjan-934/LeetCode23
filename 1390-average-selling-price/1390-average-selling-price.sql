SELECT p.product_id,ROUND(SUM(u.units*p.price)/SUM(u.units),2) as average_price FROM 
prices as p 
INNER JOIN 
unitssold as u ON p.product_id=u.product_id and u.purchase_date>=p.start_date and u.purchase_date<=p.end_date GROUP BY p.product_id 