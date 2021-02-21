create table category(
	id IDENTITY,
	name varchar(50),
	description varchar(225),
	image_url varchar(50),
	is_active boolean,
	
	constraint pk_category_id primary key (id)
);

insert into category (name, description, image_url, is_active)
	values('Laptop', 'this is description for laptop category','cat_3.png',true);
insert into category (name, description, image_url, is_active)
	values('Television', 'this is description for television category','cat_3.png',true);
insert into category (name, description, image_url, is_active)
	values('Mobile', 'this is description for mobile category','cat_3.png',true);
	
	
create table user_detail(
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role varchar(50),
	enabled boolean,
	password varchar(50),
	email varchar(100),
	contact_number varchar(15),
	
	constraint pk_user_id primary key(id)
);

insert into user_detail
	(first_name, last_name, role, enabled, password, email, contact_number)
	values('virat', 'kohli', 'ADMIN ', 'true', 'admin','vk@gmail.com','888888888' );
	
insert into user_detail
	(first_name, last_name, role, enabled, password, email, contact_number)
	values('ravindrs', 'jadeja', 'SUPPLIER ', 'true', '12345','rj@gmail.com','9999999' );
	
insert into user_detail
	(first_name, last_name, role, enabled, password, email, contact_number)
	values('ravichandra', 'ashvin', 'SUPPLIER ', 'true', '12345','ea@gmail.com','7777777' );
	
	
CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)	
);	

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', '18000', '5', 'true', '3', '2', '0', '0' );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', '32000', '2', 'true', '3', '3', '0', '0' );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', '57000', '5', 'true', '3', '2', '0', '0' );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', '54000', '3', 'true', '1', '2', '0', '0' );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', '48000', '5', 'true', '1', '3', '0', '0' );
