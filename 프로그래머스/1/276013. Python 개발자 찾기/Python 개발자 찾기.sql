select ID, 	EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPER_INFOS
where skill_1 = 'python' or skill_2 = 'python' or skill_3 = 'python'
order by id