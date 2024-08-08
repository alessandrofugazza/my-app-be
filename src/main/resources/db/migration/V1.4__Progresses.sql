CREATE TABLE IF NOT EXISTS progresses (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    source VARCHAR(255),
    progress VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
