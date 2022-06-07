create table video (
	id serial not null,
	title varchar(60) not null,
	description varchar(300) not null,
	url varchar(300) not null,

	primary key (id)
);