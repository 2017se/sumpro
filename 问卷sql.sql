create database survey;
use survey;

drop table  if exists users;
CREATE TABLE users (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) ,
  `password` varchar(20) ,
  `name` varchar(20),
  `mail` varchar(45),
  `qq` varchar(12),
  `phone` varchar(11),
  `role` int(45) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists questionnaire;
create table questionnaire(
	`id` int(11) Not null auto_increment,
    `u_id` int(11) not null,
    `title` varchar(100) not null,
    `instruction` varchar(1024),
    `set date` datetime not null,
    `end date` datetime not null,
    primary key(`id`),
    foreign key(`u_id`) references users(`id`) on delete no action on update no action
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists one_question;
create table one_question(
	`id` int(11)not null auto_increment,
    `q_id` int(11)not null,
    `title_num` int(3)not null,
    `stem` varchar(1024) not null,
    `type` int(1)default 0, # 0 indicates single answer question, 1 indicates multiple answers question, 2 indicates blank-fill question
	`nessecity` int(1) default 1, # 1 indicates this question must be answered, 0 indicates not
    primary key (`id`),
    foreign key(`q_id`) references questionnaire(`id`) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists q_options;
create table q_options(
	`q_id` int(11) not null,
    `title` varchar(1), # ABCDE...
	`property` varchar(1024), #选项内容
    primary key(`q_id`,`title`),
    foreign key(`q_id`) references one_question(`id`) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists answers;
create table answers(
	`u_id` int(11)not null,
    `o_id` int(11)not null,
    `answer` varchar(1024)not null,
    primary key(`u_id`,`o_id`),
    foreign key(`o_id`) references one_question(`id`) on delete cascade on update cascade,
    foreign key(`u_id`) references users(`id`) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists answer_questionnaire;
create table answer_questionnaire(
	`u_id` int(11) not null,
    `q_id` int(11) not null,
    `submit_time` datetime ,
    `if_complete` int(1) default 0, # 0 indicates not complete
    primary key(`u_id`,`q_id`),
    foreign key(`q_id`) references questionnaire(`id`) on delete no action on update no action,
    foreign key(`u_id`) references users(`id`) on delete no action on update no action
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
