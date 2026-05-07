

select year(differentiation_date) as year,
        abs(size_of_colony- (select max(size_of_colony)
                        from ecoli_data b
                         where year(a.DIFFERENTIATION_DATE) = year(b.DIFFERENTIATION_DATE) 
                        group by year(differentiation_date))) as year_dev,
        id
from ecoli_data a
order by year, year_dev