# select id, genotype
# from ecoli_data a
# where genotype & (select genotype from ecoli_data where id = parent_id) > 0;

select b.id, b.genotype, a.genotype & b.genotype as parent_genotype
from ecoli_data a, ecoli_data b
where a.id = b.parent_id and (a.genotype & b.genotype) = a.genotype
order by b.id asc;