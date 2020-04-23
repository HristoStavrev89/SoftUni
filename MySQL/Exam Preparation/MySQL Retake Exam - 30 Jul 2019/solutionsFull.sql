-- 3.	Section: Data Manipulation Language (DML) – 30 pts

--  2 

INSERT INTO likes (article_id, comment_id, user_id)
SELECT 
IF(u.id % 2 = 0, CHAR_LENGTH(u.username), null),
IF(u.id % 2 = 1, CHAR_LENGTH(u.email), null),
u.id
FROM users AS u
WHERE u.id BETWEEN 16 AND 20;


--  3

UPDATE comments AS c
SET comment = (
CASE
    WHEN c.id % 2 = 0 THEN 'Very good article.'
    WHEN c.id % 3 = 0 THEN 'This is interesting.'
    WHEN c.id % 5 = 0 THEN 'I definitely will read the article again.'
    WHEN c.id % 7 = 0 THEN 'The universe is such an amazing thing.'
    ELSE c.comment
END
)
WHERE c.id BETWEEN 1 AND 15;


--   4


 DELETE FROM articles AS a
 WHERE a.category_id IS NULL;
 
 
 
--  4.	Section: Querying – 50 pts

--	Extract 3 biggest articles


SELECT nt.title, nt.summary FROM (SELECT a.id,  a.title, CONCAT(LEFT(a.content, 20),'...') as `summary`
FROM articles AS a ORDER BY CHAR_LENGTH(a.content) desc LIMIT 3) AS nt ORDER BY nt.id;

-- 6.	Golden Articles

SELECT a.id, a.title FROM articles AS a
JOIN users_articles AS ua ON a.id = ua.article_id
WHERE ua.user_id = ua.article_id
ORDER BY a.id;

--       7 

SELECT c.category, COUNT(DISTINCT a.id) as `articles`, count(l.id) as `likes` FROM categories AS c
LEFT JOIN articles AS a on c.id = a.category_id
LEFT JOIN likes AS l on a.id = l.article_id
GROUP BY c.category
ORDER BY likes DESC, articles DESC, c.id;

--          8


 SELECT a.title, COUNT(c.article_id) AS `comments` FROM articles AS a
    JOIN categories AS cat on a.category_id = cat.id
JOIN comments AS c on a.id = c.article_id
where cat.category = 'Social'
group by c.article_id
ORDER BY comments DESC
LIMIT 1;

--     9

SELECT CONCAT(LEFT(c.comment, 20), '...') AS `summary` FROM comments AS c
LEFT JOIN likes AS l on c.id = l.comment_id
WHERE l.comment_id IS NULL
ORDER BY c.id DESC;

--      10
DELIMITER $$
CREATE FUNCTION udf_users_articles_count(p_username VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
    READS SQL DATA
BEGIN

    DECLARE result INT;

    SET result :=
            (SELECT COUNT(ua.article_id) FROM users_articles AS ua
                RIGHT JOIN users AS u ON ua.user_id = u.id
                WHERE u.username = p_username);
    RETURN result;
end $$



