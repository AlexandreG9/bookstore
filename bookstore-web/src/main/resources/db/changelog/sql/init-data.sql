-- Insert book
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782070584628', 'Harry Potter à l''école des sorciers', 5.6);
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782070360284', 'Voyage au bout de la nuit', 10.3);
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782070754922', 'A la recherche du temps perdu', 35);
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782020238113', 'Cent ans de solitude', 8.5);
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782075134040', 'Le seigneur des anneaux la fraternité de l''anneau', 8.9);
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782070368228', '1984', 9.2);
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782070360024', 'L''étranger', 6.3);
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782070363735', 'La promesse de l''aube', 8.6);
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782221064573', 'Le comte de Monte-Cristo', 33);
INSERT INTO t_book (isbn_book, title_book, price_book) VALUE ('9782370490001', 'La horde du Contrevent', 25);

-- Insert Stock
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782070584628', 0);
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782070360284', 200);
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782070754922', 40);
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782020238113', 10);
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782075134040', 20);
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782070368228', 1984);
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782070360024', 14);
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782070363735', 0);
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782221064573', 0);
INSERT INTO t_stock (isbn_book, quantity_stock) VALUE ('9782370490001', 1);

-- Insert order
INSERT INTO t_order (id_order, price_order, date_order) VALUE (1, 5, '2021-04-17 08:05:41');
INSERT INTO t_order (id_order, price_order, date_order) VALUE (2, 55.6, '2021-04-17 08:05:41');

-- Insert Order Detail
INSERT INTO t_order_detail (isbn_book, id_order, quantity_book_order_detail) VALUE ('9782070584628', 1, 1);
INSERT INTO t_order_detail (isbn_book, id_order, quantity_book_order_detail) VALUE ('9782070360284', 2, 2);
INSERT INTO t_order_detail (isbn_book, id_order, quantity_book_order_detail) VALUE ('9782070754922', 2, 1);

