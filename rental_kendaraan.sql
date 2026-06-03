-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Jun 2026 pada 13.23
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_kendaraan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL,
  `nama_customer` varchar(100) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id_customer`, `nama_customer`, `alamat`, `no_hp`) VALUES
(1, 'Dimas R', 'Yogyakarta', '08123456789'),
(2, 'Ramadhan', 'Yogyakarta', '081234567899'),
(4, 'Lily', 'Batam', '082123224561'),
(5, 'Ehsan', 'Malaysia', '081234121897'),
(6, 'Amara', 'Batam', '082177776561'),
(7, 'Ian', 'Batam', '082177863376');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kendaraan`
--

CREATE TABLE `kendaraan` (
  `id_kendaraan` int(11) NOT NULL,
  `nama_kendaraan` varchar(100) DEFAULT NULL,
  `jenis` varchar(50) DEFAULT NULL,
  `plat_nomor` varchar(20) DEFAULT NULL,
  `harga_sewa` double DEFAULT NULL,
  `status_kendaraan` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kendaraan`
--

INSERT INTO `kendaraan` (`id_kendaraan`, `nama_kendaraan`, `jenis`, `plat_nomor`, `harga_sewa`, `status_kendaraan`) VALUES
(2, 'Lamborghini Diablo', 'Mobil', 'BP 2006 DR', 3050000, 'Disewa'),
(3, 'Porsche 911 Carrera', 'Mobil', 'BP 2005 DR', 2000000, 'Tersedia'),
(4, 'Ferrari Testarossa', 'Mobil', 'BP 2007 DR', 4000000, 'Tersedia'),
(5, 'Ultima RS', 'Mobil', 'BP 2008', 2500000, 'Tersedia'),
(6, 'Nissan Skyline', 'Mobil', 'AB 2005 DR', 1050000, 'Tersedia'),
(7, 'Supra Bapak', 'Motor', 'AB 2009 JP', 220000, 'Tersedia'),
(8, 'Honda Beat Street', 'Motor', 'AB 2010 AJ', 300001, 'Disewa');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_pengembalian` int(11) NOT NULL,
  `id_rental` int(11) DEFAULT NULL,
  `tanggal_kembali_asli` date DEFAULT NULL,
  `tanggal_pengembalian` date DEFAULT NULL,
  `denda` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengembalian`
--

INSERT INTO `pengembalian` (`id_pengembalian`, `id_rental`, `tanggal_kembali_asli`, `tanggal_pengembalian`, `denda`) VALUES
(1, 1, '2026-05-30', '2026-05-30', 0),
(2, 2, '2026-05-29', '2026-05-31', 100000),
(3, 4, '2026-05-31', '2026-05-31', 0),
(4, 3, '2026-06-01', '2026-06-02', 50000),
(5, 5, '2026-05-03', '2026-05-03', 0),
(6, 6, '2026-06-03', '2026-06-03', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `rental`
--

CREATE TABLE `rental` (
  `id_rental` int(11) NOT NULL,
  `nama_customer` varchar(100) DEFAULT NULL,
  `nama_kendaraan` varchar(100) DEFAULT NULL,
  `tanggal_rental` date DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `lama_hari` int(11) DEFAULT NULL,
  `total_biaya` double DEFAULT NULL,
  `status` varchar(20) DEFAULT 'Aktif'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `rental`
--

INSERT INTO `rental` (`id_rental`, `nama_customer`, `nama_kendaraan`, `tanggal_rental`, `tanggal_kembali`, `lama_hari`, `total_biaya`, `status`) VALUES
(1, 'Dimas', 'Porsche 911 Carrera', '2026-05-28', '2026-05-30', 2, 4000000, 'Selesai'),
(2, 'Ramadhan', 'Ferrari Testarossa', '2026-05-28', '2026-05-29', 1, 4000000, 'Selesai'),
(3, 'Ehsan', 'Nissan Skyline', '2026-05-31', '2026-06-01', 1, 1050000, 'Selesai'),
(4, 'Dimas R', 'Lamborghini Diablo', '2026-05-27', '2026-05-31', 4, 12200000, 'Selesai'),
(5, 'Amara', 'Nissan Skyline', '2026-05-01', '2026-05-03', 2, 2100000, 'Selesai'),
(6, 'Dimas R', 'Supra Bapak', '2026-06-02', '2026-06-03', 1, 230000, 'Selesai'),
(7, 'Ian', 'Honda Beat Street', '2026-06-01', '2026-06-03', 2, 610002, 'Aktif'),
(8, 'Amara', 'Lamborghini Diablo', '2026-06-01', '2026-06-02', 1, 3100000, 'Aktif');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indeks untuk tabel `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`id_kendaraan`);

--
-- Indeks untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`);

--
-- Indeks untuk tabel `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`id_rental`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `id_kendaraan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  MODIFY `id_pengembalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `rental`
--
ALTER TABLE `rental`
  MODIFY `id_rental` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
