CREATE TABLE IF NOT EXISTS notes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255),
    content TEXT,
    link VARCHAR(511),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
