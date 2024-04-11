INSERT INTO client (name) VALUES
('Client 1'),
('Client 2'),
('Client 3'),
('Client 4'),
('Client 5'),
('Client 6'),
('Client 7'),
('Client 8'),
('Client 9'),
('Client 10');

INSERT INTO planet (id, name) VALUES
('P1', 'Planet 1'),
('P2', 'Planet 2'),
('P3', 'Planet 3'),
('P4', 'Planet 4'),
('P5', 'Planet 5');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'P1', 'P2'),
(2, 'P2', 'P3'),
(3, 'P3', 'P4'),
(4, 'P4', 'P5'),
(5, 'P5', 'P1'),
(6, 'P2', 'P4'),
(7, 'P3', 'P1'),
(8, 'P5', 'P2'),
(9, 'P1', 'P3'),
(10, 'P4', 'P1');
