-- CREATE TABLE IF NOT EXISTS transcripts(
--   id SERIAL PRIMARY KEY,
--   title varchar(100) NOT NULL,
--   content text,
--   audioUrl varchar(255) NOT NULL,
--   type varchar(50) NOT NULL,
--   taughtAt TIMESTAMP NOT NULL,
--   createdAt TIMESTAMP NOT NULL,
--   updatedAt TIMESTAMP NOT NULL
-- );

-- DROP TABLE transcripts;

CREATE TABLE IF NOT EXISTS test_table(
  id SERIAL PRIMARY KEY,
  datas text
);