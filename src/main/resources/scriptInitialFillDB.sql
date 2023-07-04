/*
	Script for the fill the initial register of cinepacho_dbmultiplexs
*/
USE cinepacho_dbmultiplexs;

/*Inserción de los multiplex*/
INSERT INTO multiplexs (id, name, num_sala) VALUES (1, 'TITAN', 6);
INSERT INTO multiplexs (id, name, num_sala) VALUES (2, 'UNICENTRO', 5);
INSERT INTO multiplexs (id, name, num_sala) VALUES (3, 'PLAZA CENTRAL',7);
INSERT INTO multiplexs (id, name, num_sala) VALUES (4, 'GRAN ESTACION',8);
INSERT INTO multiplexs (id, name, num_sala) VALUES (5, 'EMBAJADOR',10);
INSERT INTO multiplexs (id, name, num_sala) VALUES (6, 'LAS AMERICAS',5);

/*Inserción de las salas del multiplex de Titan*/
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (1, 1, 1);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (2, 1, 2);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (3, 1, 3);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (4, 1, 4);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (5, 1, 5);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (6, 1, 6);

/*Inserción de las salas del multiplex de Unicentro*/
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (7, 2, 1);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (8, 2, 2);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (9, 2, 3);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (10, 2, 4);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (11, 2, 5);

/*Inserción de las salas del multiplex de Plaza Central*/
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (12, 3, 1);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (13, 3, 2);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (14, 3, 3);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (15, 3, 4);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (16, 3, 5);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (17, 3, 6);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (18, 3, 7);

/*Inserción de las salas del multiplex de Gran estación*/
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (19, 4, 1);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (20, 4, 2);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (21, 4, 3);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (22, 4, 4);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (23, 4, 5);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (24, 4, 6);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (25, 4, 7);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (26, 4, 8);

/*Inserción de las salas del multiplex de Embajador*/
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (27, 4, 1);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (28, 4, 2);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (29, 4, 3);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (30, 4, 4);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (31, 4, 5);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (32, 4, 6);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (33, 4, 7);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (34, 4, 8);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (35, 4, 9);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (36, 4, 10);

/*Inserción de las salas del multiplex de las americas*/
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (37, 5, 1);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (38, 5, 2);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (39, 5, 3);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (40, 5, 4);
INSERT INTO theaters (id, id_multiplex, id_sala) VALUES (41, 5, 5);

/*Inserción de las peliculas en el sistema*/
INSERT INTO movies (id,title,duration,year_allowed,synopsis,url) 
VALUES (1,'Morbius','01:44:00',13,'Un vampiro','https://es.web.img2.acsta.net/c_310_420/pictures/22/02/10/13/16/1386612.jpg');
INSERT INTO movies (id,title,duration,year_allowed,synopsis,url) 
VALUES (2,'Avatar 2','03:12:00',13,'Los azules','https://es.web.img3.acsta.net/c_310_420/pictures/22/11/02/15/37/0544148.jpg');
INSERT INTO movies (id,title,duration,year_allowed,synopsis,url) 
VALUES (3,'Rapidos y furiosos 10','02:21:00',13,'La de la familia','https://mx.web.img3.acsta.net/c_310_420/pictures/23/04/20/02/29/5514328.jpg');

/*Inserción de funciones*/
INSERT INTO movie_theater (id,id_theater,id_movie,day,schedule) 
VALUES (1,1,1,'2023-07-14','14:00:00');
INSERT INTO movie_theater (id,id_theater,id_movie,day,schedule) 
VALUES (2,2,2,'2023-07-14','14:00:00');
INSERT INTO movie_theater (id,id_theater,id_movie,day,schedule) 
VALUES (3,6,3,'2023-07-14','18:00:00');

/*Insercón de snacks*/
INSERT INTO snacks (id,name,price,url)
VALUES (1,'Hot dog',5000,'https://www.wikihow.com/images/0/09/Boil-a-Hot-Dog-Step-13-Version-3.jpg');
INSERT INTO snacks (id,name,price,url)
VALUES (2,'Sandwich',8000,'https://picsum.photos/200');
INSERT INTO snacks (id,name,price,url)
VALUES (3,'Nachos',9000,'https://picsum.photos/800');
INSERT INTO snacks (id,name,price,url)
VALUES (4,'Pop corn de Sal',10000,'https://elcomercio.pe/resizer/fn6WLFZcDuL7QUy_AXwkwPbBLkk=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/MXUE22HMSJGJJOM7Y7A6UGETN4.jpg');
INSERT INTO snacks (id,name,price,url)
VALUES (5,'Pop corn de Dulce',10000,'https://picsum.photos/900');
INSERT INTO snacks (id,name,price,url)
VALUES (6,'Pop corn Mixto',11000,'https://picsum.photos/1200');
INSERT INTO snacks (id,name,price,url)
VALUES (7,'Chocolatina',3000,'https://picsum.photos/600');
INSERT INTO snacks (id,name,price,url)
VALUES (8,'Gaseosa',5000,'https://picsum.photos/300');

/*Inserción de una factura*/
INSERT INTO invoices (id,id_client,rating_movie,date,net_value,state)
VALUES (1,'444',null,'2023-07-03',null,'EN PROCESO');

INSERT INTO invoices (id,id_client,rating_movie,date,net_value,state)
VALUES (2,'1234',4,'2023-07-04',33000,'PAGADO');

INSERT INTO invoices (id,id_client,rating_movie,date,net_value,state)
VALUES (3,'1234',null,'2023-07-05',null,'EN PROCESO');

/*Inserción de los snacks en la factura*/
INSERT INTO snake_invoice (id,id_snack,id_invoice,quantity,value,state)
VALUES (1,1,1,1,5000,'EN PROCESO');
INSERT INTO snake_invoice (id,id_snack,id_invoice,quantity,value,state)
VALUES (2,5,1,2,20000,'EN PROCESO');
INSERT INTO snake_invoice (id,id_snack,id_invoice,quantity,value,state)
VALUES (3,8,1,1,5000,'EN PROCESO');

INSERT INTO snake_invoice (id,id_snack,id_invoice,quantity,value,state)
VALUES (4,7,2,1,3000,'PAGADO');

/*Inserción de los tickets en la factura*/
INSERT INTO show_invoice (id,id_show,id_invoice,quantity_chair_general,quantity_chair_preferential,value,state)
VALUES (1,1,1,'1,2','0',22000,'EN PROCESO');
UPDATE movie_theater
SET chair_general = '1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0'
WHERE id = 1;

INSERT INTO show_invoice (id,id_show,id_invoice,quantity_chair_general,quantity_chair_preferential,value,state)
VALUES (2,1,2,'0','1,2',30000,'PAGADO');
UPDATE movie_theater
SET chair_preferential = '1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0'
WHERE id = 1;

INSERT INTO show_invoice (id,id_show,id_invoice,quantity_chair_general,quantity_chair_preferential,value,state)
VALUES (3,3,3,'5,15','0',22000,'EN PROCESO');
UPDATE movie_theater
SET chair_general = '0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0'
WHERE id = 3;



