-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2020 a las 16:01:25
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `controldelimpiezav2`
--
CREATE DATABASE IF NOT EXISTS `controldelimpiezav2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `controldelimpiezav2`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaciones`
--

CREATE TABLE `asignaciones` (
  `asignacionid` int(11) NOT NULL,
  `laboratorioid` int(11) DEFAULT 0,
  `usuarioid` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asignaciones`
--

INSERT INTO `asignaciones` (`asignacionid`, `laboratorioid`, `usuarioid`) VALUES
(1, 10, 9),
(4, 2, 9),
(6, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `edificios`
--

CREATE TABLE `edificios` (
  `idedificios` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `edificios`
--

INSERT INTO `edificios` (`idedificios`, `nombre`) VALUES
(1, 'Edificio 1'),
(2, 'Edificio 2'),
(6, 'Francisco Morazan');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `estadoid` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`estadoid`, `nombre`) VALUES
(1, 'Iniciado'),
(2, 'Pausado'),
(3, 'Finalizado'),
(4, 'Reprogramados');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `idhorario` int(11) NOT NULL,
  `idlaboratorio` int(11) DEFAULT NULL,
  `lunes` int(11) DEFAULT 0,
  `martes` int(11) DEFAULT 0,
  `miercoles` int(11) DEFAULT 0,
  `jueves` int(11) DEFAULT 0,
  `viernes` int(11) DEFAULT 0,
  `sabado` int(11) DEFAULT 0,
  `domingo` int(11) DEFAULT 0,
  `hora_inicio` time DEFAULT NULL,
  `hora_fin` time DEFAULT NULL,
  `periodo` int(11) DEFAULT 1,
  `creado` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`idhorario`, `idlaboratorio`, `lunes`, `martes`, `miercoles`, `jueves`, `viernes`, `sabado`, `domingo`, `hora_inicio`, `hora_fin`, `periodo`, `creado`) VALUES
(1, 10, 1, 0, 1, 1, 0, 0, 1, '15:00:00', '16:00:00', 1, '2020-11-11'),
(2, 1, 1, 0, 1, 0, 0, 0, 1, '16:50:00', '17:54:00', 2, '2020-08-15'),
(3, 10, 1, 1, 1, 1, 1, 0, 0, '19:17:00', '22:16:00', 1, '2020-11-24'),
(5, 10, 1, 0, 0, 0, 0, 0, 1, '09:00:00', '10:00:00', 3, '2020-11-24'),
(6, 2, 1, 0, 0, 1, 0, 0, 0, '16:50:00', '17:54:00', 2, '2020-11-23'),
(7, 1, 1, 0, 0, 1, 0, 1, 0, '16:55:00', '18:45:00', 3, '2020-11-24'),
(8, 1, 1, 1, 1, 1, 0, 0, 0, '05:00:00', '06:53:00', 1, '2020-11-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorios`
--

CREATE TABLE `laboratorios` (
  `idlaboratorios` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `edificioid` int(11) DEFAULT NULL,
  `nivel` varchar(10) COLLATE latin1_spanish_ci DEFAULT NULL,
  `aula` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `direccion` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `laboratorios`
--

INSERT INTO `laboratorios` (`idlaboratorios`, `nombre`, `edificioid`, `nivel`, `aula`, `direccion`, `telefono`) VALUES
(1, 'LAB COMPU 1', 2, '3', 'sd', 'asda', '12321'),
(2, 'LAB COMPU 2', 2, '2', 'jghgjgh', 'asda', '12321'),
(10, 'gnius', 6, '5', '4545', 'calle paranguaracutirimicuaro', '11234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `limpieza`
--

CREATE TABLE `limpieza` (
  `limpiezaid` int(11) NOT NULL,
  `horarioid` int(11) DEFAULT 0,
  `usuarioid` int(11) DEFAULT 0,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `limpieza`
--

INSERT INTO `limpieza` (`limpiezaid`, `horarioid`, `usuarioid`, `fecha_inicio`, `fecha_final`, `estado`) VALUES
(1, 1, 3, '2020-11-11', '2020-11-11', 3),
(3, 1, 3, '2020-11-20', '2020-11-22', 4),
(4, 5, 10, '2020-11-27', '2020-11-28', 2),
(5, 3, 5, '2020-11-27', '2020-11-27', 3),
(8, 6, 11, '2020-11-24', '2020-11-26', 2),
(9, 7, 11, '2020-11-17', '2020-11-26', 2),
(10, 1, 5, '2020-11-03', '2020-11-05', 3),
(11, 8, 11, '2020-11-21', '2020-11-23', 3),
(12, 8, 5, '2020-11-20', '2020-11-23', 2),
(13, 8, 5, '2020-11-26', '2020-11-23', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

CREATE TABLE `periodo` (
  `periodoid` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `periodo`
--

INSERT INTO `periodo` (`periodoid`, `nombre`) VALUES
(1, 'Una vez'),
(2, 'Al mes'),
(3, 'Durante el Ciclo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idroles` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idroles`, `nombre`) VALUES
(1, 'Administrador'),
(2, 'Encargado'),
(3, 'Ordenanza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuarioId` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono` varchar(12) COLLATE latin1_spanish_ci DEFAULT NULL,
  `correo` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `password` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nacimiento` date DEFAULT NULL,
  `idRol` int(11) DEFAULT NULL,
  `activo` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuarioId`, `nombre`, `telefono`, `correo`, `password`, `nacimiento`, `idRol`, `activo`) VALUES
(1, 'Gerson Alvarado', '2586632148', 'a@a.a', '1234', '1988-11-07', 1, 1),
(2, 'Encargado 1', '787', 'b@b.b', '1234', '2020-10-25', 2, 1),
(3, 'Ordenanza 1', '78536951', 'c@c.c', '1234', '2020-11-11', 2, 1),
(4, 'Menganito Petronilo', '36985475', 'd@d.d', '1234', '2020-11-02', 1, 1),
(5, 'Ordenanza 2', '78536951', 'e@e.e', '1234', '2020-11-11', 3, 1),
(6, 'Bryan Avalos', '124526', 'bryan@avalos.com', '12345', '1999-05-12', 1, 1),
(9, 'Jorge Parada', '745855', 'jorge@parada.com', '12345', '1995-11-10', 2, 1),
(10, 'pixxa', '45454', 'sadas@a.com', '1234', '2019-10-19', 3, 1),
(11, 'Agripino', '788554', 'agripino@o.com', '1234', '1983-10-19', 3, 1),
(12, 'Jorge Acevedo', '785969633', 'jorge@acevedo.com', '12345', '1980-06-26', 2, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  ADD PRIMARY KEY (`asignacionid`),
  ADD KEY `FK_asignacion_laboratorio` (`laboratorioid`),
  ADD KEY `FK_asignacion_usuario` (`usuarioid`);

--
-- Indices de la tabla `edificios`
--
ALTER TABLE `edificios`
  ADD PRIMARY KEY (`idedificios`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`estadoid`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`idhorario`),
  ADD KEY `FK_horario_laboratorio` (`idlaboratorio`),
  ADD KEY `FK_horario_periodo` (`periodo`);

--
-- Indices de la tabla `laboratorios`
--
ALTER TABLE `laboratorios`
  ADD PRIMARY KEY (`idlaboratorios`),
  ADD KEY `FK_edificio` (`edificioid`);

--
-- Indices de la tabla `limpieza`
--
ALTER TABLE `limpieza`
  ADD PRIMARY KEY (`limpiezaid`),
  ADD KEY `FK_limpieza_horario` (`horarioid`),
  ADD KEY `FK_limpieza_usuario` (`usuarioid`),
  ADD KEY `FK_limpieza_estado` (`estado`);

--
-- Indices de la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD PRIMARY KEY (`periodoid`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idroles`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuarioId`),
  ADD KEY `fk_rol` (`idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  MODIFY `asignacionid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `edificios`
--
ALTER TABLE `edificios`
  MODIFY `idedificios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `estadoid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `idhorario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `laboratorios`
--
ALTER TABLE `laboratorios`
  MODIFY `idlaboratorios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `limpieza`
--
ALTER TABLE `limpieza`
  MODIFY `limpiezaid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `periodo`
--
ALTER TABLE `periodo`
  MODIFY `periodoid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idroles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usuarioId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  ADD CONSTRAINT `FK_asignacion_laboratorio` FOREIGN KEY (`laboratorioid`) REFERENCES `laboratorios` (`idlaboratorios`),
  ADD CONSTRAINT `FK_asignacion_usuario` FOREIGN KEY (`usuarioid`) REFERENCES `usuarios` (`usuarioId`);

--
-- Filtros para la tabla `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `FK_horario_laboratorio` FOREIGN KEY (`idlaboratorio`) REFERENCES `laboratorios` (`idlaboratorios`),
  ADD CONSTRAINT `FK_horario_periodo` FOREIGN KEY (`periodo`) REFERENCES `periodo` (`periodoid`);

--
-- Filtros para la tabla `laboratorios`
--
ALTER TABLE `laboratorios`
  ADD CONSTRAINT `FK_edificio` FOREIGN KEY (`edificioid`) REFERENCES `edificios` (`idedificios`);

--
-- Filtros para la tabla `limpieza`
--
ALTER TABLE `limpieza`
  ADD CONSTRAINT `FK_limpieza_estado` FOREIGN KEY (`estado`) REFERENCES `estado` (`estadoid`),
  ADD CONSTRAINT `FK_limpieza_horario` FOREIGN KEY (`horarioid`) REFERENCES `horario` (`idhorario`),
  ADD CONSTRAINT `FK_limpieza_usuario` FOREIGN KEY (`usuarioid`) REFERENCES `usuarios` (`usuarioId`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_rol` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idroles`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
