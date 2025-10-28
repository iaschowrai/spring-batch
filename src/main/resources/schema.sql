CREATE TABLE organizations (
    id SERIAL PRIMARY KEY,
    organization_id VARCHAR(255),
    name VARCHAR(255),
    website VARCHAR(255),
    country VARCHAR(255),
    description TEXT,
    founded INTEGER,
    industry VARCHAR(255),
    number_of_employees INTEGER
);
