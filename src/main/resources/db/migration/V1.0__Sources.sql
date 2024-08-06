CREATE TABLE IF NOT EXISTS sources (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255),
    author VARCHAR(255),
    type VARCHAR(255),
    topic VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
