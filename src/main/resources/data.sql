insert into CategoryJPA (CategoryId, CategoryName, Description) values (
	category_id_seq.nextVal,
	'Allopathy',
	'Allopathy Description'
);

insert into categoryjpa (categoryid, categoryname, description) values (
	categoryjpa_categoryid_seq.nextVal,
	'Homeopathy',
	'Homeopathy Description'
);

insert into ProductJPA (ProductId, ProductName, category, Manufacturer, Price) values (
	ProductJPA_productId_seq.nextVal,
	'Epilive',
	1,
	'Lupin',
	100
);

insert into ProductJPA (ProductId, ProductName, category, Manufacturer, Price) values (
	ProductJPA_productId_seq.nextVal,
	'Bioderma',
	1,
	'Akums',
	200
);

insert into ProductJPA (ProductId, ProductName, category, Manufacturer, Price) values (
	ProductJPA_productId_seq.nextVal,
	'Zupar',
	1,
	'Cipla',
	50
);

insert into ProductJPA (ProductId, ProductName, category, Manufacturer, Price) values (
	ProductJPA_productId_seq.nextVal,
	'Glucovita',
	1,
	'Cipla',
	150
);

/*INSERT INTO "APPUSERS" VALUES (1, 'ADMIN', 'admin123');
INSERT INTO "APPUSERS" VALUES (2, 'GUEST', 'guest123');*/