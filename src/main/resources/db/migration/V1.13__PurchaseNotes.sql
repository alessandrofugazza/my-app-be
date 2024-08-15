CREATE TABLE IF NOT EXISTS purchase_notes (
    purchase_id UUID NOT NULL,
    note VARCHAR(255),
    PRIMARY KEY (purchase_id, note),
    FOREIGN KEY (purchase_id) REFERENCES purchases(id)
);