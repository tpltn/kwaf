CREATE TABLE events (
                      id           uuid PRIMARY KEY,

                      user_id      uuid,
                      user_agent   VARCHAR,
                      host         VARCHAR,
                      committed_at TIMESTAMPTZ
);
