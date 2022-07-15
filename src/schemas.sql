CREATE TABLE `user` (
    `id` int NOT NULL AUTO_INCREMENT,
    `firstName` varchar(30) NOT NULL,
    `lastName` varchar(30) DEFAULT NULL,
    `email` varchar(50) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

CREATE TABLE `user_credential` (
    `password` varchar(50) NOT NULL,
    `email` varchar(50) DEFAULT NULL,
    FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE
);

CREATE TABLE `profile_picture` (
    `image_path` varchar(1024) NOT NULL,
    `email` varchar(50) NOT NULL,
    FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE
);

CREATE TABLE `post` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `title` VARCHAR(1024) NOT NULL,
    `description` VARCHAR(2048) NOT NULL,
    `createdOn` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `email` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`email`) REFERENCES `user` (`email`) ON DELETE CASCADE
);

CREATE TABLE `like` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `createdOn` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `post_id` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE
);
