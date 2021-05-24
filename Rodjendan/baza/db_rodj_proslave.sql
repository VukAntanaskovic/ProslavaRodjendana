-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2021 at 11:03 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rodj_proslave`
--

-- --------------------------------------------------------

--
-- Table structure for table `agencija`
--

CREATE TABLE `agencija` (
  `agn_sifra` int(11) NOT NULL,
  `agn_naziv` varchar(100) NOT NULL,
  `agn_adresa` varchar(100) NOT NULL,
  `agn_telefon` varchar(20) NOT NULL,
  `agn_slika` varchar(150) NOT NULL,
  `agn_opis` varchar(500) NOT NULL,
  `kor_menadzer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `agencija`
--

INSERT INTO `agencija` (`agn_sifra`, `agn_naziv`, `agn_adresa`, `agn_telefon`, `agn_slika`, `agn_opis`, `kor_menadzer`) VALUES
(1, 'Agencija Rodj', 'Vojvode Stepe 255', '0632256489', 'assets/img/beograd.jpg', 'Ukoliko nemate ideju za neki lep stih ili čestitku koju ćete uputiti Vama bliskoj osobi kako biste joj izrazili svoja osećanja, možete pogledati u nastavku razne čestitke grupisane po kategorijama. Naravno, najlepše rođendanske čestitke su uvek vrlo aktuelne.', 2),
(6, 'Proslava rodjendana Pepa', 'Milica Rakica 55A', '0667899943', 'assets/img/srecan-rodjendan-pepo-korica-srecan-rodjendan-pepo_59c0ea1ea8747.jpg', 'U godini je samo jedan dan važniji od drugih, a to je dan kada si ti došao na svet, toga dana svet je dobio jednu sjajnu osobu, a ja svog najboljeg druga. Srećan rođendan i sve najbolje!', 4),
(7, 'Rodjendanske proslave Beograd', 'Strumicka 20', '065998789', 'assets/img/najlepse_cestitke_za_rodjendan_rodjendanske_poruke_za_prijatelje_foto_aps_600723560.jpg', 'Ukoliko nemate ideju za neki lep stih ili čestitku koju ćete uputiti Vama bliskoj osobi kako biste joj izrazili svoja osećanja, možete pogledati u nastavku razne čestitke grupisane po kategorijama. Naravno, najlepše rođendanske čestitke su uvek vrlo aktuelne.', 5),
(10, 'Proslava rodjendana za decu', 'Bulevar Milutina Milankovica 92A', '0657786524', 'assets/img/04251891d63ae3d872c71c97b72a733a.png', 'Slatkoteka pokloni za ro&#273;endan su siguran put do najiskrenijeg slavljeni&#269;kog osmeha. So&#269;ni, elegantno upakovani zalogaji na najlep�i na&#269;in komuniciraju tople ro&#273;endanske �elje, a na�a misija je da ih slavljeniku prenesemo u kreativnim slatkim oblicima i premium pakovanjima. \r\nPogledajte Slatkoteka ideje za ro&#273;endanski poklon i po�elite nekome sre&#263;an ro&#273;endan u svim &#269;okoladnim ukusima!', 10);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `kor_sifra` int(11) NOT NULL,
  `kor_ime` varchar(50) NOT NULL,
  `kor_prezime` varchar(50) NOT NULL,
  `kor_email` varchar(50) NOT NULL,
  `kor_password` varchar(50) NOT NULL,
  `kor_uloga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`kor_sifra`, `kor_ime`, `kor_prezime`, `kor_email`, `kor_password`, `kor_uloga`) VALUES
(1, 'Vuk', 'Antanaskovic', 'vukantanaskovic99@gmail.com', 'vuk123', 3),
(2, 'Reka', 'Rekic', 'reka@live.com', 'reka', 2),
(4, 'Rama', 'Ramic', 'rama128@aol.net', 'rama', 2),
(5, 'Mitar', 'Miric', 'mat@gmail.com', 'mat', 2),
(6, 'Mara', 'Markovic', 'mara@gmail.com', 'mara', 1),
(7, 'Rata', 'Ratic', 'rata@gmail.com', 'rata', 1),
(8, 'Zika', 'Zivkovic', 'zika@gmail.com', 'zika', 2),
(10, 'Mile', 'Milic', 'mile@gmail.com', 'mile', 2),
(11, 'Milan', 'Milosavljevic', 'milan@gmail.com', 'milan', 1);

-- --------------------------------------------------------

--
-- Table structure for table `proslava`
--

CREATE TABLE `proslava` (
  `agn_sifra` int(11) NOT NULL,
  `kor_sifra` int(11) NOT NULL,
  `pro_cena` decimal(50,0) DEFAULT NULL,
  `pro_datum` varchar(50) NOT NULL,
  `pro_broj_zvanica` int(50) NOT NULL,
  `pro_pocetak` varchar(20) NOT NULL,
  `pro_kraj` varchar(20) NOT NULL,
  `pro_status` tinyint(1) DEFAULT NULL,
  `pro_sifra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proslava`
--

INSERT INTO `proslava` (`agn_sifra`, `kor_sifra`, `pro_cena`, `pro_datum`, `pro_broj_zvanica`, `pro_pocetak`, `pro_kraj`, `pro_status`, `pro_sifra`) VALUES
(1, 1, '2399', '21.05.2021', 25, '14:00', '18:00', 1, 2),
(6, 6, '5000', '21.05.2021', 25, '14:00', '18:00', 1, 3),
(1, 6, '8500', '2021-05-29', 100, '21:00', '00:00', 1, 9),
(1, 10, '69990', '2021-05-29', 56, '12:00', '14:40', 1, 10),
(1, 1, '5000', '2021-05-28', 30, '18:00', '22:00', 1, 13);

-- --------------------------------------------------------

--
-- Table structure for table `uloga`
--

CREATE TABLE `uloga` (
  `ulg_sifra` int(11) NOT NULL,
  `ulg_naziv` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `uloga`
--

INSERT INTO `uloga` (`ulg_sifra`, `ulg_naziv`) VALUES
(1, 'Klijent'),
(2, 'Menadzer'),
(3, 'Administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agencija`
--
ALTER TABLE `agencija`
  ADD PRIMARY KEY (`agn_sifra`),
  ADD KEY `kor_menadzer` (`kor_menadzer`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`kor_sifra`),
  ADD KEY `kor_uloga` (`kor_uloga`);

--
-- Indexes for table `proslava`
--
ALTER TABLE `proslava`
  ADD PRIMARY KEY (`pro_sifra`),
  ADD KEY `agn_sifra` (`agn_sifra`),
  ADD KEY `kor_sifra` (`kor_sifra`);

--
-- Indexes for table `uloga`
--
ALTER TABLE `uloga`
  ADD PRIMARY KEY (`ulg_sifra`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agencija`
--
ALTER TABLE `agencija`
  MODIFY `agn_sifra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `kor_sifra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `proslava`
--
ALTER TABLE `proslava`
  MODIFY `pro_sifra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `uloga`
--
ALTER TABLE `uloga`
  MODIFY `ulg_sifra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `agencija`
--
ALTER TABLE `agencija`
  ADD CONSTRAINT `agencija_ibfk_1` FOREIGN KEY (`kor_menadzer`) REFERENCES `korisnik` (`kor_sifra`);

--
-- Constraints for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD CONSTRAINT `korisnik_ibfk_1` FOREIGN KEY (`kor_uloga`) REFERENCES `uloga` (`ulg_sifra`);

--
-- Constraints for table `proslava`
--
ALTER TABLE `proslava`
  ADD CONSTRAINT `proslava_ibfk_1` FOREIGN KEY (`agn_sifra`) REFERENCES `agencija` (`agn_sifra`),
  ADD CONSTRAINT `proslava_ibfk_2` FOREIGN KEY (`kor_sifra`) REFERENCES `korisnik` (`kor_sifra`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
