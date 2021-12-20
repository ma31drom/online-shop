CREATE TABLE person (
    id serial,
    last_name varchar(255),
    first_name varchar(255),
	locked boolean,
	login  varchar(255) NOT NULL,
	password varchar(255),
	email varchar(255),
    role int4 NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE delivery_address (
    id serial,
    city varchar(255),
    street varchar(255),
    house_num varchar(255),
	flat_num varchar(255),
    person_id int8,
	PRIMARY KEY (id),
    FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE product (
    id serial,
    name varchar(255),
    description varchar(255),
    category int4,
	price real,
	PRIMARY KEY (id)
);

CREATE TABLE product_picture (
    id serial,
	name varchar(255),
	picture_path varchar(255),
    product_id int8,
	PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE product_attribute (
    id serial,
	name varchar(255),
	value varchar(255),
    product_id int8,
	PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE cart (
    id serial,
    person_id int8 UNIQUE,
	PRIMARY KEY (id),
    FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE cart_product (
    id serial,
	quantity int8,
	cart_id int8,
    product_id int8,
	PRIMARY KEY (id),
	FOREIGN KEY (cart_id) REFERENCES cart(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE shop_order (
    id serial,
	date timestamp,
	total_amount real,
	delivery_address_id int8,
	status int4,
    person_id int8,
	PRIMARY KEY (id),
	FOREIGN KEY (delivery_address_id) REFERENCES delivery_address(id),
    FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE order_product (
    id serial,
	quantity int8,
	itemAmount real,
	order_id int8,
    product_id int8,
	PRIMARY KEY (id),
	FOREIGN KEY (order_id) REFERENCES shop_order(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE payment (
    id serial,
	status int4,
	order_id int8,
	PRIMARY KEY (id),
	FOREIGN KEY (order_id) REFERENCES shop_order(id)
);