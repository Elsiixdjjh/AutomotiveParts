-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2023 at 08:36 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `automotiveparts`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `idBarang` int(11) NOT NULL,
  `namaBarang` varchar(255) NOT NULL,
  `kategori` varchar(255) NOT NULL,
  `hargaBarang` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`idBarang`, `namaBarang`, `kategori`, `hargaBarang`) VALUES
(1, 'Alternator Toyota', 'Sparepart', 850000),
(2, 'Dinamo Alternator Hyundai', 'Suku Cadang', 1700000),
(4, 'Yoke Stater Kijang 7K', 'Sparepart', 165000),
(5, 'Stator Alternator Panther 2.5', 'Sparepart', 240500),
(6, 'Alternator Rubahan Taft GT', 'Suku Cadang', 1500000),
(7, 'Alternator Isuzu NKR71', 'Suku Cadang', 2000000),
(8, 'Rectifier Elf NKR66', 'Sparepart', 210500),
(9, 'Oil Seal PS100', 'Sparepart', 7000),
(10, 'Stater Fuso Ganzo', 'Suku Cadang', 1650000),
(11, 'Stater Jeep Cherokee', 'Suku Cadang', 700000),
(12, 'Alternator Kia Carnival Bensin', 'Suku Cadang', 1100000),
(13, 'Armature / Angker stater Katana', 'Sparepart', 150000),
(14, 'Peso PS100', 'Sparepart', 35000),
(15, 'Carbon Brush FS125', 'Sparepart', 11000),
(16, 'Yoke Stater Dinosaurus', 'Sparepart', 310000),
(17, 'Rotor Blower ALT Panther 2.3', 'Sparepart', 50000),
(18, 'Socket Kijang 7K', 'Sparepart', 45000),
(19, 'Bushing Stater Carry / 5K', 'Sparepart', 9000),
(20, 'Tembaga Panther Komplit', 'Sparepart', 40000),
(21, 'Alternator Daihatsu Avanza Xenia', 'Suku Cadang', 900000),
(22, 'Alternator Rubahan Solar 120A 12Volt', 'Suku Cadang', 1500000),
(23, 'Alternator Mercy Tiger', 'Suku Cadang', 1300000),
(24, 'Stater Honda CRV Stream', 'Suku Cadang', 600000),
(25, 'Alternator Isuzu Traga 2.5CC', 'Suku Cadang', 1900000),
(26, 'Stater Futura APV Injeksi', 'Suku Cadang', 550000),
(27, 'Stater Nissan Livina Juke 1.5CC', 'Suku Cadang', 650000),
(28, 'Stater Nissan Livina Juke 1.8CC', 'Sparepart', 600000),
(29, 'Stater Peugeot 206, 205, 307', 'Suku Cadang', 800000),
(30, 'Rectifier Panther 2.5', 'Sparepart', 141000),
(31, 'Rectifier PS100 / L300 Diesel', 'Sparepart', 210700),
(32, 'Rectifier FE81 Fuso FR', 'Sparepart', 135000);

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `idTransaksi` int(11) NOT NULL,
  `idBarang` int(11) NOT NULL,
  `namaBarang` varchar(255) NOT NULL,
  `hargaBarang` int(11) NOT NULL,
  `jumlahBarang` int(11) NOT NULL,
  `subTotal` int(11) NOT NULL,
  `idCustomer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `idCust` int(11) NOT NULL,
  `namaCust` varchar(255) NOT NULL,
  `noTelpCust` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`idCust`, `namaCust`, `noTelpCust`) VALUES
(1, 'Shana  Ivana', '085755245874'),
(2, 'Jevan', '085423615445'),
(4, 'Syahira', '087657897654'),
(5, 'Bryan ', '081245786254'),
(7, 'Johnny Gemilang', '085142356984');

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `idKasir` int(11) NOT NULL,
  `namaKasir` varchar(255) NOT NULL,
  `passwordKasir` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kasir`
--

INSERT INTO `kasir` (`idKasir`, `namaKasir`, `passwordKasir`) VALUES
(1, 'Elsi', 12345),
(3, 'Winda', 34679);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` int(11) NOT NULL,
  `idCustomer` int(11) NOT NULL,
  `idBarang` int(11) NOT NULL,
  `namaBarang` varchar(255) NOT NULL,
  `jumlahBarang` int(11) NOT NULL,
  `totalHarga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `idCustomer`, `idBarang`, `namaBarang`, `jumlahBarang`, `totalHarga`) VALUES
(1, 1, 1, 'Alternator Toyota', 20, 20000000),
(4, 4, 1, 'Alternator Toyota', 1, 850000),
(6, 7, 29, 'Stater Peugeot 206, 205, 307', 18, 14400000),
(7, 7, 15, 'Carbon Brush FS125', 200, 2200000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`idBarang`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`idTransaksi`),
  ADD KEY `idBarang` (`idBarang`),
  ADD KEY `idTransaksi` (`idTransaksi`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idCust`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`idKasir`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`),
  ADD KEY `idBarang` (`idBarang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `idBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `idCust` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `kasir`
--
ALTER TABLE `kasir`
  MODIFY `idKasir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`idBarang`) REFERENCES `barang` (`idBarang`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
