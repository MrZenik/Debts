create table if not exists "partner"
(
    id         serial       not null,
    user_id    serial       not null,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    debt       decimal      not null,
    updated_at  timestamp    not null,
    active     boolean      not null,

    primary key (id),
    foreign key(user_id) references "user"(id)
);