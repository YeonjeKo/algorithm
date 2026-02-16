-- 코드를 작성해주세요
with tmp as (select year(differentiation_date) y, max(size_of_colony) as m
            from ecoli_data
            group by year(differentiation_date))
select year(ecoli.differentiation_date) as year, tmp.m - ecoli.size_of_colony as year_dev, ecoli.id
from ecoli_data ecoli, tmp
where year(ecoli.differentiation_date) = tmp.y
order by year, year_dev;

