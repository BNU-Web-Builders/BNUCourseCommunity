create table user
(
    id       bigint auto_increment
        primary key,
    account  varchar(30)  not null,
    avatar   varchar(200) null,
    orgId    bigint       null,
    password varchar(100) null,
    username varchar(16)  not null,
    constraint UK_oidlpt3w74aa9f4bxdiamid0w
        unique (account),
    constraint user_ibfk_1
        foreign key (orgId) references organization (id)
            on update cascade on delete cascade,
    constraint user_ibfk_2
        foreign key (orgId) references organization (id)
            on update cascade on delete cascade
);

create index orgId
    on user (orgId);

INSERT INTO coursecommunity.user (id, account, avatar, orgId, password, username, code, state) VALUES (1, '201711260105', '', 1, '123456', 'ahhhhhh', '1222222', true);