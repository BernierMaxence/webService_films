-- ALTER TABLE film_actor
-- DROP FOREIGN KEY film_actor_ibfk_1,
-- MODIFY id_film SMALLINT UNSIGNED;


ALTER TABLE film_actor
DROP FOREIGN KEY film_actor_ibfk_2,
MODIFY id_film SMALLINT UNSIGNED;


-- Auto increment
ALTER TABLE actor MODIFY COLUMN id INT auto_increment;


ALTER TABLE film_actor
ADD CONSTRAINT film_actor_ibfk_1 FOREIGN KEY (id_film)
      REFERENCES film (id);


ALTER TABLE actor
ADD CONSTRAINT fk_id_film FOREIGN KEY (id_film)
      REFERENCES film (id);


-- see all fk 
SELECT 
  TABLE_NAME,COLUMN_NAME,CONSTRAINT_NAME, REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME
FROM
  INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE
  REFERENCED_TABLE_SCHEMA = 'cinema'



ALTER TABLE film_actor
ADD FOREIGN KEY (id_film) REFERENCES film(id);

ALTER TABLE film_actor
ADD FOREIGN KEY (id_actor) REFERENCES actor(id);




