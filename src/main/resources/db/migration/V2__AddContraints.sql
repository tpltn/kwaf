ALTER TABLE userAgents ADD CONSTRAINT name_unique UNIQUE (name);
ALTER TABLE urls ADD CONSTRAINT value_unique UNIQUE (value);
