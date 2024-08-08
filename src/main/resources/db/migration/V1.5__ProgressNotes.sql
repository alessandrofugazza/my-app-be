CREATE TABLE IF NOT EXISTS progress_notes (
    progress_id UUID NOT NULL,
    note VARCHAR(255),
    PRIMARY KEY (progress_id, note),
    FOREIGN KEY (progress_id) REFERENCES progresses(id)
);