-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-10-2020 a las 06:41:46
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
-- Base de datos: `grupo02`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `idestudiante` int(11) NOT NULL,
  `carnet` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`idestudiante`, `carnet`, `nombre`) VALUES
(1, 'AP123456', 'Gerson Jonadab Alvarado Portillo'),
(2, '294-19-2194', 'Derby More'),
(3, '105-88-9798', 'Ekaterina Waistall'),
(4, '715-17-2432', 'Sayre Batrim'),
(5, '776-57-3116', 'Corissa Wratten');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `idmateria` int(11) NOT NULL,
  `nombremateria` varchar(30) NOT NULL,
  `ciclo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`idmateria`, `nombremateria`, `ciclo`) VALUES
(1, 'MATEMATICA I', '01-2018'),
(2, 'INGENIERIA Y PRODUCTIVIDAD', '01-2018'),
(3, 'SEMINARIO TALLER DE COMPETENCI', '01-2018'),
(4, 'ORTI', '01-2018'),
(5, 'BASE DE DATOS 1', '02-2018'),
(6, 'DIBUJO TECNICO', '02-2018'),
(7, 'MATEMATICA II', '02-2018'),
(8, 'PROGRAMACION ORIENTADA A OBJET', '02-2018'),
(9, 'REALIDAD NACIONAL', '02-2018'),
(10, 'BASE DE DATOS II', '01-2019'),
(11, 'FILOSOFIA', '01-2019'),
(12, 'FISICA I', '01-2019'),
(13, 'MATEMATICA III', '01-2019'),
(14, 'PROGRAMACION I', '01-2019'),
(15, 'LENGUAJE UNIFICADO DE MODELADO', '02-2019'),
(16, 'MATEMATICA IV', '-2017'),
(17, 'DESARROLLO DE LA PLATAFORMA WE', '02-2019'),
(18, 'FISICA II', '02-2019'),
(19, 'PROGRAMACION II', '02-2019'),
(20, 'ESTADISTICA Y PROBABILIDADES', '01-2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `idnotas` int(11) NOT NULL,
  `nota1` decimal(10,0) NOT NULL,
  `nota2` decimal(10,0) NOT NULL,
  `nota3` decimal(10,0) NOT NULL,
  `materia` int(11) NOT NULL,
  `estudiante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`idnotas`, `nota1`, `nota2`, `nota3`, `materia`, `estudiante`) VALUES
(1, '4', '2', '10', 1, 1),
(2, '8', '8', '7', 2, 1),
(3, '9', '10', '7', 3, 1),
(4, '10', '4', '9', 4, 1),
(5, '2', '1', '1', 5, 2),
(6, '8', '6', '8', 6, 2),
(7, '7', '8', '9', 7, 2),
(8, '9', '10', '8', 8, 2),
(9, '9', '9', '8', 9, 3),
(10, '9', '7', '10', 10, 3),
(11, '8', '8', '8', 11, 3),
(12, '10', '9', '6', 12, 3),
(13, '10', '10', '8', 13, 4),
(14, '8', '7', '9', 14, 4),
(15, '8', '9', '7', 15, 4),
(16, '7', '8', '7', 16, 4),
(17, '7', '10', '8', 17, 5),
(18, '7', '10', '6', 18, 5),
(19, '7', '10', '6', 19, 5),
(20, '3', '1', '2', 20, 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`idestudiante`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`idmateria`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`idnotas`),
  ADD KEY `materia` (`materia`),
  ADD KEY `estudiante` (`estudiante`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  MODIFY `idestudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `materias`
--
ALTER TABLE `materias`
  MODIFY `idmateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `notas`
--
ALTER TABLE `notas`
  MODIFY `idnotas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
