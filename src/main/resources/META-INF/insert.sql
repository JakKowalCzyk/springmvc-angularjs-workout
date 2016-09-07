delete table if not EXISTS saw.user;

create table saw.user(
  id INTEGER ,
  login VARCHAR(255),
  firstName VARCHAR(255),
  lastName VARCHAR(255),
  age VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255),
)