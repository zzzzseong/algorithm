-- 코드를 작성해주세요
select count(*) as fish_count
from fish_info fi
where fi.time between '2021/01/01' and '2021/12/31';