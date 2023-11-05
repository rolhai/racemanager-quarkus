insert into countries (code, name) values ('AUT', 'Österreich');
select @austriaId:=id from countries where code = 'AUT';

insert into countries (code, name) values ('NED', 'Niederlande');
select @netherlandsId:=id from countries where code = 'NED';

insert into countries (code, name) values ('GER', 'Deutschland');
select @germanyId:=id from countries where code = 'GER';

insert into countries (code, name) values ('ESP', 'Spanien');
select @spainId:=id from countries where code = 'ESP';

insert into countries (code, name) values ('GBR', 'Großbritannien');
select @britainId:=id from countries where code = 'GBR';

insert into drivers (firstname, lastname, countryId) values ('Max', 'Verstappen', @netherlandsId);
insert into drivers (firstname, lastname, countryId) values ('Lewis', 'Hamilton', @britainId);
insert into drivers (firstname, lastname, countryId) values ('Niko', 'Hülkenberg', @germanyId);
insert into drivers (firstname, lastname, countryId) values ('Fernando', 'Alonso', @spainId);
insert into drivers (firstname, lastname, countryId) values ('Carlos', 'Sainz', @spainId);