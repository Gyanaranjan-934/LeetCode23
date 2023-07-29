select e2.name from employee as e1
join 
employee as e2 where e1.managerid = e2.id group by e2.id having count(e2.id) > 4