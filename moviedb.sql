-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema moviedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `moviedb` ;

-- -----------------------------------------------------
-- Schema moviedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviedb` DEFAULT CHARACTER SET utf8 ;
USE `moviedb` ;

-- -----------------------------------------------------
-- Table `movie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movie` ;

CREATE TABLE IF NOT EXISTS `movie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `year` CHAR(4) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `pic` VARCHAR(500) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `actor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `actor` ;

CREATE TABLE IF NOT EXISTS `actor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_has_actor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movie_has_actor` ;

CREATE TABLE IF NOT EXISTS `movie_has_actor` (
  `movie_id` INT NOT NULL,
  `actor_id` INT NOT NULL,
  PRIMARY KEY (`movie_id`, `actor_id`),
  INDEX `fk_movie_has_actor_actor1_idx` (`actor_id` ASC),
  INDEX `fk_movie_has_actor_movie_idx` (`movie_id` ASC),
  CONSTRAINT `fk_movie_has_actor_movie`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movie_has_actor_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genre` ;

CREATE TABLE IF NOT EXISTS `genre` (
  `idgenre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idgenre`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO moviewatcher@localhost;
 DROP USER moviewatcher@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'moviewatcher'@'localhost' IDENTIFIED BY 'moviewatcher';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'moviewatcher'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `movie`
-- -----------------------------------------------------
START TRANSACTION;
USE `moviedb`;
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (1, 'The Shawshank Redemption', '1994', 'Drama', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1_UY67_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (2, 'The Godfather', '1972', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZTRmNjQ1ZDYtNDgzMy00OGE0LWE4N2YtNTkzNWQ5ZDhlNGJmL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UY67_CR1,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (3, 'The Godfather: Part II', '1974', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjZiNzIxNTQtNDc5Zi00YWY1LThkMTctMDgzYjY4YjI1YmQyL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UY67_CR1,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (4, 'The Dark Knight', '2008', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UY67_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (5, '12 Angry Men', '1957', 'Drama', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODQwOTc5MDM2N15BMl5BanBnXkFtZTcwODQxNTEzNA@@._V1_UX45_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (6, 'Schindler\'s List', '1993', 'Drama', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX45_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (7, 'Pulp Fiction', '1994', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTkxMTA5OTAzMl5BMl5BanBnXkFtZTgwNjA5MDc3NjE@._V1_UY67_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (8, 'The Lord of the Rings: The Return of the King', '2003', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYWY1ZWQ5YjMtMDE0MS00NWIzLWE1M2YtODYzYTk2OTNlYWZmXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_UX45_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (9, 'The Good, the Bad and the Ugly', '1966', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1_UX45_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (10, 'Fight Club', '1999', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BZGY5Y2RjMmItNDg5Yy00NjUwLThjMTEtNDc2OGUzNTBiYmM1XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UY67_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (11, 'The Lord of the Rings: The Fellowship of the Ring', '2001', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_UY67_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (12, 'Star Wars: Episode V - The Empire Strikes Back', '1980', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYmViY2M2MTYtY2MzOS00YjQ1LWIzYmEtOTBiNjhlMGM0NjZjXkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_UX45_CR0,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (13, 'Forrest Gump', '1994', 'Drama', 'https://images-na.ssl-images-amazon.com/images/M/MV5BYThjM2MwZGMtMzg3Ny00NGRkLWE4M2EtYTBiNWMzOTY0YTI4XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_UY67_CR3,0,45,67_AL_.jpg');
INSERT INTO `movie` (`id`, `name`, `year`, `genre`, `pic`) VALUES (14, 'Inception', '2010', 'Action', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_UY67_CR0,0,45,67_AL_.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `actor`
-- -----------------------------------------------------
START TRANSACTION;
USE `moviedb`;
INSERT INTO `actor` (`id`, `name`) VALUES (1, 'Tim Robbins');
INSERT INTO `actor` (`id`, `name`) VALUES (2, 'Morgan Freeman');
INSERT INTO `actor` (`id`, `name`) VALUES (3, 'Bob Gunton');
INSERT INTO `actor` (`id`, `name`) VALUES (4, 'Marion Brando');
INSERT INTO `actor` (`id`, `name`) VALUES (5, 'Al Pacino');
INSERT INTO `actor` (`id`, `name`) VALUES (6, 'James Caan');
INSERT INTO `actor` (`id`, `name`) VALUES (7, 'Ryan Gosling');
INSERT INTO `actor` (`id`, `name`) VALUES (8, 'Robert De Niro');
INSERT INTO `actor` (`id`, `name`) VALUES (9, 'Robert Duvall');
INSERT INTO `actor` (`id`, `name`) VALUES (10, 'Christian Bale');
INSERT INTO `actor` (`id`, `name`) VALUES (11, 'Heath Ledger');
INSERT INTO `actor` (`id`, `name`) VALUES (12, 'Aaron Eckhart');
INSERT INTO `actor` (`id`, `name`) VALUES (13, 'Henry Fonda');
INSERT INTO `actor` (`id`, `name`) VALUES (14, 'Lee J. Cobb');
INSERT INTO `actor` (`id`, `name`) VALUES (15, 'Martin Balsam');
INSERT INTO `actor` (`id`, `name`) VALUES (16, 'Liam Neeson');
INSERT INTO `actor` (`id`, `name`) VALUES (17, 'Ralph Fiennes');
INSERT INTO `actor` (`id`, `name`) VALUES (18, 'Ben Kingsley');
INSERT INTO `actor` (`id`, `name`) VALUES (19, 'John Travolta');
INSERT INTO `actor` (`id`, `name`) VALUES (20, 'Uma Thurman');
INSERT INTO `actor` (`id`, `name`) VALUES (21, 'Samuel L. Jackson');
INSERT INTO `actor` (`id`, `name`) VALUES (22, 'Elijah Wood');
INSERT INTO `actor` (`id`, `name`) VALUES (23, 'Viggo Mortensen');
INSERT INTO `actor` (`id`, `name`) VALUES (24, 'Ian McKellen');
INSERT INTO `actor` (`id`, `name`) VALUES (25, 'Bradd Pitt');
INSERT INTO `actor` (`id`, `name`) VALUES (26, 'Edward Norton');
INSERT INTO `actor` (`id`, `name`) VALUES (27, 'Meat Loaf');
INSERT INTO `actor` (`id`, `name`) VALUES (28, 'Clint Eastwood');
INSERT INTO `actor` (`id`, `name`) VALUES (29, 'Eli Wallach');
INSERT INTO `actor` (`id`, `name`) VALUES (30, 'Lee Van Cleef');
INSERT INTO `actor` (`id`, `name`) VALUES (31, 'Elijah Wood');
INSERT INTO `actor` (`id`, `name`) VALUES (32, 'Ian McKellen');
INSERT INTO `actor` (`id`, `name`) VALUES (33, 'Orlando Bloom');
INSERT INTO `actor` (`id`, `name`) VALUES (34, 'Mark Hamill');
INSERT INTO `actor` (`id`, `name`) VALUES (35, 'Harrison Ford');
INSERT INTO `actor` (`id`, `name`) VALUES (36, 'Carrie Fisher');
INSERT INTO `actor` (`id`, `name`) VALUES (37, 'Tom Hanks');
INSERT INTO `actor` (`id`, `name`) VALUES (38, 'Robin Wright');
INSERT INTO `actor` (`id`, `name`) VALUES (39, 'Gary Sinise');
INSERT INTO `actor` (`id`, `name`) VALUES (40, 'Leonardo DiCaprio');
INSERT INTO `actor` (`id`, `name`) VALUES (41, 'Joseph Gordon-Levitt');
INSERT INTO `actor` (`id`, `name`) VALUES (42, 'Ellen Page');

COMMIT;


-- -----------------------------------------------------
-- Data for table `movie_has_actor`
-- -----------------------------------------------------
START TRANSACTION;
USE `moviedb`;
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (1, 1);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (1, 2);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (1, 3);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (2, 4);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (2, 5);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (2, 6);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (3, 5);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (3, 8);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (3, 9);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (4, 10);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (4, 11);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (4, 12);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (5, 13);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (5, 14);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (5, 15);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (6, 16);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (6, 17);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (6, 18);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (7, 19);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (7, 20);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (7, 21);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (8, 22);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (8, 23);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (8, 24);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (9, 25);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (9, 26);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (9, 27);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (10, 28);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (10, 29);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (10, 30);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (11, 31);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (11, 32);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (11, 33);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (12, 34);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (12, 35);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (12, 36);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (13, 37);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (13, 38);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (13, 39);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (14, 40);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (14, 41);
INSERT INTO `movie_has_actor` (`movie_id`, `actor_id`) VALUES (14, 42);

COMMIT;

