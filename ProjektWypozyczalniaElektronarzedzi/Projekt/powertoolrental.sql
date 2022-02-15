-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Lut 2022, 20:36
-- Wersja serwera: 10.4.22-MariaDB
-- Wersja PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `powertoolrental`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `torder`
--

CREATE TABLE `torder` (
  `id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `price` double NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `torderposition`
--

CREATE TABLE `torderposition` (
  `id` int(11) NOT NULL,
  `days` int(11) NOT NULL,
  `dateOfReturn` datetime DEFAULT NULL,
  `cartId` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `torder_torderposition`
--

CREATE TABLE `torder_torderposition` (
  `torder_id` int(11) NOT NULL,
  `orderPositions_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tproduct`
--

CREATE TABLE `tproduct` (
  `id` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `tproduct`
--

INSERT INTO `tproduct` (`id`, `description`, `name`, `price`, `quantity`) VALUES
(1, 'BOSCH GKS 190', 'Pila tarczowa', 39.99, 10),
(2, 'BOSCH GSA 18 V-Li', 'Pila szablasta', 44.99, 6),
(3, 'BOSCH GWS 18V - 10', 'Szlifierka katowa akumulatorowa', 29.99, 21),
(4, 'BOSCH GSB 18V-110 C', 'Wkretarka akumulatorowa', 20.49, 18),
(5, 'BOSCH GST 18V-Li S', 'Wyrzynarka akumulatorowa', 27.99, 12),
(6, 'MAKITA DFR550', 'Wkretarka tasmowa z magazynkiem', 41.49, 5),
(7, 'MAKITA GA9020R', 'Szlifierka katowa', 27.49, 9),
(8, 'BOSCH GHOI 40-82 C', 'Strug elektryczny', 20.99, 11),
(9, 'MAKITA JN1601', 'Nozyce skokowe do blachy', 42.99, 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tuser`
--

CREATE TABLE `tuser` (
  `id` int(11) NOT NULL,
  `login` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `surname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `tuser`
--

INSERT INTO `tuser` (`id`, `login`, `name`, `password`, `surname`) VALUES
(1, 'admin', 'Dominik', '21232f297a57a5a743894a0e4a801fc3', 'Wator'),
(2, 'user', 'Jan', 'ee11cbb19052e40b07aac0ca060c23ee', 'Kowalski');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `torder`
--
ALTER TABLE `torder`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi0sl4qov8ir81scpposomkot4` (`user_id`);

--
-- Indeksy dla tabeli `torderposition`
--
ALTER TABLE `torderposition`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg2u8n87sdutwbdc1hvdcdd6qy` (`product_id`);

--
-- Indeksy dla tabeli `torder_torderposition`
--
ALTER TABLE `torder_torderposition`
  ADD PRIMARY KEY (`torder_id`,`orderPositions_id`),
  ADD UNIQUE KEY `UK_47gq05j11tnca23usbrg1h2p7` (`orderPositions_id`);

--
-- Indeksy dla tabeli `tproduct`
--
ALTER TABLE `tproduct`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `tuser`
--
ALTER TABLE `tuser`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `torder`
--
ALTER TABLE `torder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `torderposition`
--
ALTER TABLE `torderposition`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `tproduct`
--
ALTER TABLE `tproduct`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT dla tabeli `tuser`
--
ALTER TABLE `tuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
