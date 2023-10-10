-- 코드를 입력하세요

SELECT RI.rest_id, RI.rest_name, RI.food_type, RI.favorites, RI.address, round(avg(RR.review_score), 2) AS score
FROM REST_INFO RI
LEFT JOIN REST_REVIEW RR
ON RI.rest_id = RR.rest_id
GROUP BY RI.rest_id
HAVING RI.address LIKE '서울%' AND score IS NOT NULL
ORDER BY score DESC, RI.favorites DESC;