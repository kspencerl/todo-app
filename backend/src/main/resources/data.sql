CREATE TABLE task (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    priority VARCHAR(50),  
    label_name VARCHAR(255),
    category_name VARCHAR(255),
    due_date TIMESTAMP,
    status VARCHAR(50), 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO task (id, name, priority, label_name, category_name, due_date, status)
VALUES 
    ('Prática de Escalonamento', 'ALTA', 'Teoria', 'Faculdade', '2024-04-01 10:00:00', 'PREVISTO'),
    ('Slides de Cultura Religiosa', 'MEDIA', 'Slides', 'Faculdade', '2024-04-02 12:00:00', 'PREVISTO'),
    ('Jantar no Coco Bambu', 'BAIXA', 'Passeio', 'Lazer', '2024-04-03 15:00:00', 'CONCLUIDO');
