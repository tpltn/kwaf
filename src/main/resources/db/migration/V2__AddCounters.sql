CREATE TABLE counters (
  user_id      uuid,
  endpoint_id  uuid REFERENCES endpoints (id),
  total_events INT,

  UNIQUE (user_id, endpoint_id)
);
