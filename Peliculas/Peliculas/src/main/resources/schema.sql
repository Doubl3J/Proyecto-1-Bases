-- Cliente
CREATE OR REPLACE FUNCTION respaldo_cliente() RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'UPDATE' THEN
        INSERT INTO Respaldo(nombre_tabla,id_tabla,operacion,fecha_hora,usuario,datos_anteriores,datos_nuevos)
        VALUES (
            'Cliente', NEW.cedula, 'UPDATE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD Nombre: ' || OLD.nombre || ' P_Apellido: ' || OLD.primer_apellido || ' S_Apellido: ' || OLD.segundo_apellido ||
            ' Email: ' || OLD.email || ' Telefono: ' || OLD.numero_telefono,
            'NEW Nombre: ' || NEW.nombre || ' P_Apellido: ' || NEW.primer_apellido || ' S_Apellido: ' || NEW.segundo_apellido ||
            ' Email: ' || NEW.email || ' Telefono: ' || NEW.numero_telefono
        );
        RETURN NEW;

    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO Respaldo(nombre_tabla,id_tabla,operacion,fecha_hora,usuario,datos_anteriores)
        VALUES(
            'Cliente', OLD.cedula, 'DELETE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD Nombre: ' || OLD.nombre || ' P_Apellido: ' || OLD.primer_apellido || ' S_Apellido: ' || OLD.segundo_apellido ||
            ' Email: ' || OLD.email || ' Telefono: ' || OLD.numero_telefono
        );
        RETURN OLD;

    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Respaldo(nombre_tabla,id_tabla,operacion,fecha_hora,usuario,datos_nuevos)
        VALUES(
            'Cliente', NEW.cedula, 'INSERT', CURRENT_TIMESTAMP, CURRENT_USER,
            'NEW Nombre: ' || NEW.nombre || ' P_Apellido: ' || NEW.primer_apellido || ' S_Apellido: ' || NEW.segundo_apellido ||
            ' Email: ' || NEW.email || ' Telefono: ' || NEW.numero_telefono
        );
        RETURN NEW;
    END IF;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER respaldo_cliente
BEFORE UPDATE OR DELETE OR INSERT
ON Cliente
FOR EACH ROW
EXECUTE PROCEDURE respaldo_cliente();

--Pelicula
CREATE OR REPLACE FUNCTION respaldo_pelicula() RETURNS TRIGGER AS $$
BEGIN
    
    IF TG_OP = 'UPDATE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores, datos_nuevos
        )
        VALUES (
            'Pelicula', NEW.id_pelicula, 'UPDATE', CURRENT_TIMESTAMP, CURRENT_USER,

            'OLD: Nombre_Pelicula: ' || OLD.nombre_pelicula || ' Idioma: ' || OLD.idioma || ' Precio_Venta: ' || OLD.precio_venta || ' Id_genero: ' || old.id_genero,
           
            'NEW: Nombre_Pelicula: ' || NEW.nombre_pelicula || ' Idioma: ' || NEW.idioma || ' Precio_Venta: ' || NEW.precio_venta || ' Id_genero: ' || new.id_genero
        );
        RETURN NEW;

    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores
        )
        VALUES(
            'Pelicula', OLD.id_pelicula, 'DELETE', CURRENT_TIMESTAMP, CURRENT_USER,

            'OLD: Nombre_Pelicula: ' || OLD.nombre_pelicula || ' Idioma: ' || OLD.idioma || ' Precio_Venta: ' || OLD.precio_venta || ' Id_genero: ' || old.id_genero
        );
        RETURN OLD;

    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_nuevos
        )
        VALUES(
            'Pelicula', NEW.id_pelicula, 'INSERT', CURRENT_TIMESTAMP, CURRENT_USER,

            'NEW: Nombre_Pelicula: ' || NEW.nombre_pelicula || ' Idioma: ' || NEW.idioma || ' Precio_Venta: ' || NEW.precio_venta || ' Id_genero: ' || new.id_genero
        );
        RETURN NEW;

    END IF;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER respaldo_pelicula
BEFORE UPDATE OR DELETE OR INSERT ON pelicula
FOR EACH ROW
EXECUTE PROCEDURE respaldo_pelicula();

--Tienda
CREATE OR REPLACE FUNCTION respaldo_tienda() RETURNS TRIGGER AS $$
BEGIN
    
    IF TG_OP = 'UPDATE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores, datos_nuevos
        )
        VALUES (
            'Tienda', NEW.id_tienda, 'UPDATE', CURRENT_TIMESTAMP, CURRENT_USER,

            'OLD: Nombre_Tienda: ' || OLD.nombre_tienda || ' Direccion: ' || OLD.direccion_exacta ||
            ' Telefono: ' || OLD.telefono_tienda || ' Email: ' || OLD.email_tienda || ' Provincia: ' || old.id_provincia,
            
            'NEW: Nombre_Tienda: ' || NEW.nombre_tienda || ' Direccion: ' || NEW.direccion_exacta || 
            ' Telefono: ' || NEW.telefono_tienda || ' Email: ' || NEW.email_tienda || ' Provincia: ' || new.id_provincia
        );
        
        RETURN NEW;

    
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores
        )
        VALUES(
            'Tienda', OLD.id_tienda, 'DELETE', CURRENT_TIMESTAMP, CURRENT_USER,
            
            'OLD: Nombre_Tienda: ' || OLD.nombre_tienda || ' Direccion: ' || OLD.direccion_exacta ||
            ' Telefono: ' || OLD.telefono_tienda || ' Email: ' || OLD.email_tienda || ' Provincia: ' || OLD.id_provincia
        );
        
        RETURN OLD;

    
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_nuevos
        )
        VALUES(
            'Tienda', NEW.id_tienda, 'INSERT', CURRENT_TIMESTAMP, CURRENT_USER,
            
            'NEW: Nombre_Tienda: ' || NEW.nombre_tienda || ' Direccion: ' || NEW.direccion_exacta ||
            ' Telefono: ' || NEW.telefono_tienda || ' Email: ' || NEW.email_tienda || ' Provincia: ' || new.id_provincia
        );
        
        RETURN NEW;

    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER respaldo_tienda
BEFORE UPDATE OR DELETE OR INSERT ON Tienda
FOR EACH ROW
EXECUTE PROCEDURE respaldo_tienda();

--Factura
CREATE OR REPLACE FUNCTION respaldo_factura() RETURNS TRIGGER AS $$
BEGIN
    
    IF TG_OP = 'UPDATE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores, datos_nuevos
        )
        VALUES (
            'Factura', NEW.id_factura, 'UPDATE', CURRENT_TIMESTAMP, CURRENT_USER,

            'OLD: Fecha_Factura: ' || OLD.fecha_factura || ' Total_Factura: ' || OLD.total_factura || ' Id_Cliente: ' || old.id_cliente || ' Id_Tienda: ' || old.id_tienda,
            
            'NEW: Fecha_Factura: ' || NEW.fecha_factura || ' Total_Factura: ' || NEW.total_factura || ' Id_Cliente: ' || new.id_cliente || ' Id_Tienda: ' || new.id_tienda
        );
        RETURN NEW;

    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores
        )
        VALUES(
            'Factura', OLD.id_factura, 'DELETE', CURRENT_TIMESTAMP, CURRENT_USER,
            
            'OLD: Fecha_Factura: ' || OLD.fecha_factura || ' Total_Factura: ' || OLD.total_factura || ' Id_Cliente: ' || old.id_cliente || ' Id_Tienda: ' || old.id_tienda
        );
        RETURN OLD;

    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_nuevos
        )
        VALUES(
            'Factura', NEW.id_factura, 'INSERT', CURRENT_TIMESTAMP, CURRENT_USER,

            'NEW: Fecha_Factura: ' || NEW.fecha_factura || ' Total_Factura: ' || NEW.total_factura || ' Id_Cliente: ' || new.id_cliente || ' Id_Tienda: ' || new.id_tienda
        );
        RETURN NEW;

    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER respaldo_factura
BEFORE UPDATE OR DELETE OR INSERT ON Factura
FOR EACH ROW
EXECUTE PROCEDURE respaldo_factura();

--Genero
CREATE OR REPLACE FUNCTION respaldo_genero() RETURNS TRIGGER AS $$
BEGIN

    -- == UPDATE OPERATION ==
    IF TG_OP = 'UPDATE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores, datos_nuevos
        )
        VALUES (
            'Genero', NEW.id_genero, 'UPDATE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD: Nombre_Genero: ' || OLD.nombre_genero,
            'NEW: Nombre_Genero: ' || NEW.nombre_genero
        );
        RETURN NEW;

    -- == DELETE OPERATION ==
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores
        )
        VALUES (
            'Genero', OLD.id_genero, 'DELETE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD: Nombre_Genero: ' || OLD.nombre_genero
        );
        RETURN OLD;

    -- == INSERT OPERATION ==
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_nuevos
        )
        VALUES (
            'Genero', NEW.id_genero, 'INSERT', CURRENT_TIMESTAMP, CURRENT_USER,
            'NEW: Nombre_Genero: ' || NEW.nombre_genero
        );
        RETURN NEW;

    END IF;

    RETURN NULL;

END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER respaldo_genero
BEFORE INSERT OR UPDATE OR DELETE ON genero
FOR EACH ROW
EXECUTE PROCEDURE respaldo_genero();

--Provincia

CREATE OR REPLACE FUNCTION respaldo_provincia() RETURNS TRIGGER AS $$
BEGIN

    -- == UPDATE OPERATION ==
    IF TG_OP = 'UPDATE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores, datos_nuevos
        )
        VALUES (
            'Provincia', NEW.id_provincia, 'UPDATE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD: Nombre_Provincia: ' || OLD.nombre_provincia,
            'NEW: Nombre_Provincia: ' || NEW.nombre_provincia
        );
        RETURN NEW;

    -- == DELETE OPERATION ==
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores
        )
        VALUES (
            'Provincia', OLD.id_provincia, 'DELETE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD: Nombre_Provincia: ' || OLD.nombre_provincia
        );
        RETURN OLD;

    -- == INSERT OPERATION ==
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_nuevos
        )
        VALUES (
            'Provincia', NEW.id_provincia, 'INSERT', CURRENT_TIMESTAMP, CURRENT_USER,
            'NEW: Nombre_Provincia: ' || NEW.nombre_provincia
        );
        RETURN NEW;

    END IF;

    RETURN NULL;

END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER respaldo_provincia
BEFORE INSERT OR UPDATE OR DELETE ON provincia
FOR EACH ROW
EXECUTE PROCEDURE respaldo_provincia();

--Detalles_factura
CREATE OR REPLACE FUNCTION respaldo_detalles_factura() RETURNS TRIGGER AS $$
BEGIN

    -- == UPDATE OPERATION ==
    IF TG_OP = 'UPDATE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores, datos_nuevos
        )
        VALUES (
            'Detalles_Factura', NEW.id_detalle, 'UPDATE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD: id_pelicula: ' || OLD.id_pelicula || ' id_factura: ' || OLD.id_factura,
            'NEW: id_pelicula: ' || NEW.id_pelicula || ' id_factura: ' || NEW.id_factura
        );
        RETURN NEW;

    -- == DELETE OPERATION ==
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores
        )
        VALUES (
            'Detalles_Factura', OLD.id_detalle, 'DELETE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD: id_pelicula: ' || OLD.id_pelicula || ' id_factura: ' || OLD.id_factura
        );
        RETURN OLD;

    -- == INSERT OPERATION ==
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_nuevos
        )
        VALUES (
            'Detalles_Factura', NEW.id_detalle, 'INSERT', CURRENT_TIMESTAMP, CURRENT_USER,
            'NEW: id_pelicula: ' || NEW.id_pelicula || ' id_factura: ' || NEW.id_factura
        );
        RETURN NEW;

    END IF;

    RETURN NULL;

END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER respaldo_detalles_factura
BEFORE INSERT OR UPDATE OR DELETE ON detalles_factura
FOR EACH ROW
EXECUTE PROCEDURE respaldo_detalles_factura();


--Inventario
CREATE OR REPLACE FUNCTION respaldo_inventario() RETURNS TRIGGER AS $$
BEGIN

    -- == UPDATE OPERATION ==
    IF TG_OP = 'UPDATE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores, datos_nuevos
        )
        VALUES (
            'Inventario', NEW.id_inventario, 'UPDATE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD: cantidad_disponible: ' || OLD.cantidad_disponible || 
            ' id_pelicula: ' || OLD.id_pelicula || 
            ' id_tienda: ' || OLD.id_tienda,
            'NEW: cantidad_disponible: ' || NEW.cantidad_disponible || 
            ' id_pelicula: ' || NEW.id_pelicula || 
            ' id_tienda: ' || NEW.id_tienda
        );
        RETURN NEW;

    -- == DELETE OPERATION ==
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_anteriores
        )
        VALUES (
            'Inventario', OLD.id_inventario, 'DELETE', CURRENT_TIMESTAMP, CURRENT_USER,
            'OLD: cantidad_disponible: ' || OLD.cantidad_disponible || 
            ' id_pelicula: ' || OLD.id_pelicula || 
            ' id_tienda: ' || OLD.id_tienda
        );
        RETURN OLD;

    -- == INSERT OPERATION ==
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Respaldo(
            nombre_tabla, id_tabla, operacion, fecha_hora, usuario, datos_nuevos
        )
        VALUES (
            'Inventario', NEW.id_inventario, 'INSERT', CURRENT_TIMESTAMP, CURRENT_USER,
            'NEW: cantidad_disponible: ' || NEW.cantidad_disponible || 
            ' id_pelicula: ' || NEW.id_pelicula || 
            ' id_tienda: ' || NEW.id_tienda
        );
        RETURN NEW;

    END IF;

    RETURN NULL;

END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER respaldo_inventario
BEFORE INSERT OR UPDATE OR DELETE ON inventario
FOR EACH ROW
EXECUTE PROCEDURE respaldo_inventario();