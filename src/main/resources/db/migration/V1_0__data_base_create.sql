CREATE TABLE IF NOT EXISTS USERS (
  LOGIN VARCHAR(255) PRIMARY KEY,
  HASH_PASSWORD VARCHAR(255),
  SALT VARCHAR(255));

CREATE TABLE IF NOT EXISTS RESOURCES (
  LOGIN VARCHAR(255),
  RESOURCE VARCHAR(255) PRIMARY KEY,
  ROLE VARCHAR(255),
  FOREIGN KEY (LOGIN) REFERENCES USERS(LOGIN)
  ON DELETE CASCADE
  ON UPDATE CASCADE);

CREATE INDEX INDEX_LOGIN_ROLE ON RESOURCES(LOGIN, ROLE);

CREATE TABLE IF NOT EXISTS ACCOUNTS (
  LOGIN VARCHAR(255) PRIMARY KEY,
  DATE_IN DATE,
  DATE_OUT DATE,
  VOLUME INT,
  FOREIGN KEY (LOGIN) REFERENCES RESOURCES(RESOURCE)
  ON DELETE CASCADE
  ON UPDATE CASCADE);