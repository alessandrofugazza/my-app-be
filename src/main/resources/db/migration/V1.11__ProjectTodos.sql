CREATE TABLE IF NOT EXISTS project_todos (
    project_id UUID NOT NULL,
    todo_order INTEGER NOT NULL,
    todo TEXT,

    CONSTRAINT fk_project_todos_project
        FOREIGN KEY (project_id) REFERENCES projects(id)
        ON DELETE CASCADE,

    PRIMARY KEY (project_id, todo_order)
);

CREATE INDEX idx_project_todos_project_id ON project_todos (project_id);
