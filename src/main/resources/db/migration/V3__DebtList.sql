create table if not exists "debt"
(
    id                   serial       not null,
    partner_id           serial       not null,
    comment              varchar(255) not null,
    transaction_amount   decimal      not null,
    transaction_date     timestamp    not null,

    primary key (id),
    foreign key(partner_id) references "partner"(id)
);