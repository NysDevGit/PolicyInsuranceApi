SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tinubu_db`
--
CREATE DATABASE IF NOT EXISTS `tinubu_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
-- --------------------------------------------------------

--
-- Structure de la table `policy_insurance`
--

CREATE TABLE IF NOT EXISTS `policy_insurance` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `status` text NOT NULL,
  `coverage_starting_sdate` datetime NOT NULL,
  `coverage_ending_date` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `updated_on` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
