CREATE TABLE user_agents (
  id uuid PRIMARY KEY,

  name VARCHAR UNIQUE
);

CREATE TABLE endpoints (
  id uuid PRIMARY KEY,

  method VARCHAR,
  url VARCHAR,

  UNIQUE (method, url)
);

CREATE TABLE events(
  id uuid PRIMARY KEY,

  user_id uuid,
  user_agent_id uuid REFERENCES user_agents (id),
  endpoint_id uuid REFERENCES endpoints (id),
  http_status INT,
  committed_at TIMESTAMPTZ
);
