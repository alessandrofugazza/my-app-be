CREATE TABLE IF NOT EXISTS learn_subjects (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    source VARCHAR(255),
    progress VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
