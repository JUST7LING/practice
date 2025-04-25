-- 코드를 입력하세요
SELECT RES.REST_ID, RES.REST_NAME, RES.FOOD_TYPE, RES.FAVORITES, RES.ADDRESS, ROUND(AVG(REV.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO RES, REST_REVIEW REV 
WHERE RES.REST_ID = REV.REST_ID
GROUP BY REST_ID
HAVING ADDRESS LIKE '서울%'
ORDER BY SCORE DESC, RES.FAVORITES DESC;

# select rest_id, rest_name, food_type, favorites, address, avg(select review_score from rest_review where rest_id = )