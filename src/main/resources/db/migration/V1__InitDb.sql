CREATE TABLE userAgents(
  id uuid PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE urls(
  id uuid PRIMARY KEY,
  value VARCHAR
);

CREATE TABLE events(
  id uuid PRIMARY KEY,
  userId uuid,
  userAgent uuid REFERENCES userAgents(id),
  url uuid REFERENCES urls(id),
  method VARCHAR,
  httpStatus INT,
  committedAt TIMESTAMPTZ
);
