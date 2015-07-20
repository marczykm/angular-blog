drop table if exists post;

create table post (
        id bigint not null auto_increment,
        active bit not null,
        author varchar(255) not null,
        content varchar(255) not null,
        creation_date datetime not null,
        photo varchar(255),
        title varchar(255) not null,
        primary key (id)
    );
