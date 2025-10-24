Create table pelicula_tienda (
	nombre_pelicula varchar (255),
	idioma varchar (255),
	precio_venta bigint,
	nombre_genero varchar (255),
	nombre_tienda varchar (255),
	direccion_exacta varchar (255),
	email_tienda varchar (255),
	telefono_tienda int,
	nombre_provincia varchar (255),
	cantidad_disponible int
);

insert into pelicula_tienda 
(nombre_pelicula,idioma,precio_venta,nombre_genero,
nombre_tienda,direccion_exacta,email_tienda,telefono_tienda,nombre_provincia, cantidad_disponible)
values('Supergirl','Ingles',20000,'Accion','Blockbuster','El Barrio','bb@gmail.com',88809213,'Alajuela',20),
('Peacemaker','Ingles',30000,'Comedia','Blockbuster','El Barrio','bb@gmail.com',88809218,'Heredia',40),
('Interstellar','Español',15000,'Suspenso','Peliculas Mario','Por el supermercado','pm@gmail.com',84809211,'Cartago',5),
('Barbie','Ingles',10000,'Comedia','Netflix','Paris','netflix@gmail.com',90123212,'Puntarenas',15);

Create or replace procedure normalizar_datos()
language plpgsql
as $$
declare
	t_id_genero int;
	t_id_provincia int;
	t_id_pelicula int;
	t_id_tienda int;
	rec record;

begin
	for rec in select * from pelicula_tienda
	loop
		select id_genero into t_id_genero from genero
		where nombre_genero = rec.nombre_genero;

		if t_id_genero is null then 
			insert into genero(nombre_genero)
			values (rec.nombre_genero)
			returning id_genero into t_id_genero;
		end if;

		select id_provincia into t_id_provincia from provincia
		where nombre_provincia = rec.nombre_provincia;

		if t_id_provincia is null then
			insert into provincia (nombre_provincia)
			values (rec.nombre_provincia)
			returning id_provincia into t_id_provincia;
		end if;

		select id_pelicula into t_id_pelicula from pelicula
		where nombre_pelicula = rec.nombre_pelicula
		and idioma = rec.idioma;

		if t_id_pelicula is null then
			insert into pelicula (nombre_pelicula,idioma,precio_venta,id_genero)
			values (rec.nombre_pelicula,rec.idioma,rec.precio_venta,t_id_genero)
			returning id_pelicula into t_id_pelicula;
		end if;

		select id_tienda into t_id_tienda from tienda
		where nombre_tienda = rec.nombre_tienda
		and direccion_exacta = rec.direccion_exacta;

		if t_id_tienda is null then
			insert into tienda (nombre_tienda,telefono_tienda,email_tienda,direccion_exacta,id_provincia)
			values (rec.nombre_tienda,rec.telefono_tienda,rec.email_tienda,rec.direccion_exacta,t_id_provincia)
			returning id_tienda into t_id_tienda;
		end if;

		insert into inventario (id_pelicula,id_tienda,cantidad_disponible)
		values (t_id_pelicula,t_id_tienda,rec.cantidad_disponible)
		on conflict (id_pelicula, id_tienda) do update
		set cantidad_disponible = rec.cantidad_disponible;
	end loop;
end;
$$

call normalizar_datos();

select * from pelicula_tienda;
select * from genero;
select * from provincia;
select * from pelicula;
select * from tienda;
select * from inventario;	