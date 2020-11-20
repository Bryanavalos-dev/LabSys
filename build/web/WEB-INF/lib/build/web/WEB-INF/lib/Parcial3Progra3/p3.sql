create database p3
go
use p3

create table Clientes
(
	idCliente int primary key IDENTITY(1,1),
	Nombre nvarchar(40),
	Direccion nvarchar(200),
	Telefono nvarchar(17),
	Email nvarchar(150),
	idDepto int
)

create table Departamentos
(
	idDepto int primary key,
	Departamento nvarchar(35)
)

alter table Clientes
add foreign key (idDepto) references Departamentos(idDepto)

insert into Departamentos(idDepto,Departamento) Values(1,'Ahuachapán')
insert into Departamentos(idDepto,Departamento) Values(2,'Cabañas')
insert into Departamentos(idDepto,Departamento) Values(3,'Chalatenango')
insert into Departamentos(idDepto,Departamento) Values(4,'Cuscatlán')
insert into Departamentos(idDepto,Departamento) Values(5,'La Libertad')
insert into Departamentos(idDepto,Departamento) Values(6,'La Paz')
insert into Departamentos(idDepto,Departamento) Values(7,'La Unión')
insert into Departamentos(idDepto,Departamento) Values(8,'Morazán')
insert into Departamentos(idDepto,Departamento) Values(9,'San Miguel')
insert into Departamentos(idDepto,Departamento) Values(10,'San Salvador')
insert into Departamentos(idDepto,Departamento) Values(11,'San Vicente')
insert into Departamentos(idDepto,Departamento) Values(12,'Santa Ana')
insert into Departamentos(idDepto,Departamento) Values(13,'Sonsonate')
insert into Departamentos(idDepto,Departamento) Values(14,'Usulután')


CREATE PROCEDURE SP_nuevoCliente
	@nombre nvarchar(50),
	@direccion nvarchar(100),
	@telefono nvarchar (15),
	@email nvarchar (100),
	@depa int,
	@id int output
AS
BEGIN

	insert into Clientes(Nombre,Direccion,Telefono,Email,idDepto) 
	values(@nombre,@direccion,@telefono,@email,@depa)

	set @id = (select @@Identity)
	return @id
END


CREATE PROCEDURE SP_Dept
AS
select * from  Departamentos
GO;