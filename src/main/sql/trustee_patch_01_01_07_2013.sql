DROP TABLE IF EXISTS `trustee`;
CREATE TABLE IF NOT EXISTS `trustee` (
  `trustee_id` int(11) NOT NULL AUTO_INCREMENT,
  `investor_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `trustee_role_id` int(11) NOT NULL,
  `date_from` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_to` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`trustee_id`),
  KEY `investor_id_idx` (`investor_id`),
  KEY `person_id_idx` (`person_id`),
  KEY `trustee_role_id_idx` (`trustee_role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;