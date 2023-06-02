-- STORE

INSERT INTO store (name, email) VALUES ('Store Play', 'storeplay@example.com');

INSERT INTO item (name, price, image, store_id) VALUES ('Ursinho de Pelhuche', 20.50, 'https://media.discordapp.net/attachments/770721017726500886/1113871219884838963/brown-teddy-bear-isolated-in-front-of-a-white-background.png', 1);
INSERT INTO item (name, price, image, store_id) VALUES ('Cars Toys', 10.00, 'https://media.discordapp.net/attachments/770721017726500886/1113872876513280010/71a-TQVKMWL.png', 1);
INSERT INTO item (name, price, image, store_id) VALUES ('Friendly Eletronic Bear', 99.99, 'https://media.discordapp.net/attachments/770721017726500886/1113873238439759923/1200.png', 1);

INSERT INTO package (client_name, client_email, pickup_point_id, status, store_id, deliveryid) VALUES ('Anthony Conho', 'anthonytheconho@gmail.com', 1, 'DISPATCHED', 1, 1);
INSERT INTO package (client_name, client_email, pickup_point_id, status, store_id, deliveryid) VALUES ('John Doe', 'johndoe@example.com', 1, 'DISPATCHED', 1, 2);
INSERT INTO package (client_name, client_email, pickup_point_id, status, store_id, deliveryid) VALUES ('Jane Smith', 'janesmith@example.com', 1, 'RECIEVED', 1, 3 );
