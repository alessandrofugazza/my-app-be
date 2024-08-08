CREATE TABLE IF NOT EXISTS source_notes (
    source_id UUID NOT NULL,
    note VARCHAR(255),
    PRIMARY KEY (source_id, note),
    FOREIGN KEY (source_id) REFERENCES sources(id)
);