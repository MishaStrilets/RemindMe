CREATE TABLE IF NOT EXISTS letter (
   id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   description TEXT NOT NULL,
   date VARCHAR(10) NOT NULL,
   email VARCHAR(100) NOT NULL
);