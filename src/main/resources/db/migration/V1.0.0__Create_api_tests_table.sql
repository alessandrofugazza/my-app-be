CREATE TABLE IF NOT EXISTS api_tests (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255),
    subtitle VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);