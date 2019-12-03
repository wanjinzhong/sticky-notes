create schema STICKY_NOTES;

create table STICKY_NOTES.notes
(
	id int not null auto_increment,
	notes text not null,
	entry_datetime datetime default now() not null,
	update_datetime datetime not null default current_timestamp ON UPDATE CURRENT_TIMESTAMP,
	primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;