
CREATE TABLE task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    priority INT,
    label_name VARCHAR(255),
    category_name VARCHAR(255),
    due_date TIMESTAMP,
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO task (name, priority, label_name, category_name, due_date, status)
VALUES 
    ('Prática de Escalonamento', 1, 'Teoria', 'Faculdade', '2024-04-01 10:00:00', 'NEW'),
    ('Slides de Cultura Religiosa', 2, 'Slides', 'Faculdade', '2024-04-02 12:00:00', 'IN_PROGRESS'),
    ('Jantar no Coco Bambu', 3, 'Passeio', 'Lazer', '2024-04-03 15:00:00', 'DONE');
