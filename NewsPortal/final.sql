-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 09, 2017 at 12:19 পূর্বাহ্ণ
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project1`
--

-- --------------------------------------------------------

--
-- Table structure for table `applications`
--

CREATE TABLE `applications` (
  `id` int(10) UNSIGNED NOT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `contact` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nationality` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `applications`
--

INSERT INTO `applications` (`id`, `fullname`, `email`, `address`, `contact`, `nationality`, `remember_token`, `created_at`, `updated_at`) VALUES
(3, 'Mahmud Mishu', 'mahmud.mishu4@gmail.com', '14/9 Pllabi', '01685800983', 'Bangladeshi', NULL, '2017-05-08 12:37:48', '2017-05-08 12:37:48');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `migration` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`migration`, `batch`) VALUES
('2014_10_12_000000_create_users_table', 1),
('2014_10_12_100000_create_password_resets_table', 1),
('2017_04_25_121011_create_applications_table', 1),
('2017_05_07_170624_create_news_table', 2);

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(10) UNSIGNED NOT NULL,
  `newsCategory` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `newsPriority` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `newsTitle` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `newsBody` longtext COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `newsCategory`, `newsPriority`, `newsTitle`, `newsBody`, `created_at`, `updated_at`, `user_id`) VALUES
(7, 'International', 'Top', 'Macron makes French history', 'Pro-European centrist Emmanuel Macron promised yesterday to heal France\'s divisions after crushing far-right leader Marine Le Pen in a pivotal presidential election that has given him a large but fragile mandate for change.\r\nAt 39, the pro-EU former inves', '2017-05-07 17:40:35', '2017-05-07 17:40:35', 1),
(8, 'National', 'General', 'Ershad pulls off \'largest\' polls alliance', 'Jatiya Party chief HM Ershad yesterday came up with the country\'s biggest-ever electoral alliance, comprised of 58 political parties, counting mainly on name-only Islamist parties.\r\n\r\nTitled United National Alliance, the coalition has only two parties reg', '2017-05-07 17:45:32', '2017-05-07 17:45:32', 1),
(11, 'Sports', 'General', 'Abahani to clash with Mohammedan today', 'The eighth round of the Dhaka Premier League will begin with a clash between rivals Mohammedan and Abahani at the BKSP. Although the rivalry is not as celebrated today as in the past, there still remains plenty of excitement among the players when these t', '2017-05-07 17:49:28', '2017-05-07 17:49:28', 1),
(13, 'National', 'Top', 'The government today fixed office timings for this Ramadan from 9:00am to 3:30pm.', 'A decision in this regard was made at a cabinet meeting presided over by Prime Minister Sheikh Hasina, Cabinet Secretary Shafiul Alam told reporters after the meeting at the Secretariat in Dhaka.\r\n\r\nThere would be a 15-minute prayer break from 1:15pm. The new timing would be effective for all the government, semi-government, autonomous and semi-autonomous institutions, he said.\r\n\r\nThe Ramadan is likely to begin in the last week of this month.\r\n\r\nThe Supreme Court, hospitals, banks, insurance agencies, emergency services providing organisations will fix their own time, he added.', '2017-05-08 03:08:36', '2017-05-08 03:08:36', 1),
(14, 'International', 'General', 'PPP a way forward for Asia\'s growth: ADB', 'Asia\'s future development funding has to come from the private sector through public-private partnerships, said Takehiko Nakao, president of the Asian Development Bank, yesterday.\r\n\r\nADB member states insisted that the lender should invite larger private sector financing to support the region\'s development, especially for infrastructure, he said.\r\n\r\nThe ADB would increase its private-sector operations to 25 percent of its regular ordinary capital resources (OCR) operations by 2020, Nakao said, adding that expansion of such private sector involvements in resource mobilisation would be more visible in poorer countries.\r\n\r\nAs the ADB\'s four-day annual meeting came to an end in Yokohama yesterday, Nakao stressed the need to bridge the gap between available resources and required funding to meet Asia\'s development needs through 2030.\r\n\r\nInvestment equivalent of 5 percent of Asia\'s GDP (excluding China) is required to carry forward the development projects in Asia and the Pacific, he said at the closing press conference.\r\n\r\nAbout 3 percent of that would have to come through PPP while the remaining 2 percent from the governments of the Asian countries, he added.\r\n\r\nAsia will need $1.7 trillion a year in investments in power, transport, telecommunications, and water through 2030.\r\n\r\n“We will scale up efforts to help meet this large infrastructure deficit, increasingly use high-level technology in infrastructure, vigorously pursue our commitment to climate finance, and actively promote public-private partnerships.”\r\n\r\nThe ADB was created to mobilise private sector resources by leveraging equity to tap capital markets. The merger of the Asian Development Fund lending operations and OCR balance sheet allows the lender to further leverage these resources, according to Nakao.\r\n\r\n“Our experience in the past 50 years demonstrates that both public and private sector investments by the ADB through preparing necessary infrastructure and setting conducive policy environment help crowd in private sector resources and activities,” Nakao said.\r\n\r\nIn response to a query, he said though the new US administration has recalled its representative from the ADB, it would soon depute one as alternate executive director. He hoped the US would continue to engage in Asia and the Pacific\'s development.\r\n\r\nOn the notion that Japanese companies get the most out of ADB work orders, Nakao said, “Our system is open. We go by the rules of international tenders.”\r\n\r\nIn his closing remarks at the ADB board of governors meeting yesterday, Nakao said, “While progress in Asia has been impressive, many of you reminded us that the battle against poverty is not over yet.\r\n\r\nReducing poverty will remain our major focus. The ADB will continue to prioritise the needs of the poorest and the most fragile countries, including small island countries in the Pacific.”\r\n\r\nGrowing inequalities are a major concern for many countries, he said. “We will enhance our support for addressing inequality across groups and regions. Strengthening financial inclusion and supporting inclusive business will be integral components of our approach to deepen inclusiveness,” Nakao said.\r\n\r\nThrough an inclusive and meaningful consultative process, the ADB would develop and finalise its \'Strategy 2030\' by 2018 when the bank\'s headquarters in Manila would host the 51st annual meeting of the board of governors.', '2017-05-08 03:09:25', '2017-05-08 03:09:25', 1),
(15, 'National', 'General', 'Japan still remembers his heroics', 'The day started like any other day for AG Mahmud on September 28, 1977. He was in a regular cabinet meeting that day. As the air chief and deputy Chief Marshal Law Administrator who was also holding portfolios of some ministries, this was business as usual.\r\n\r\nAt around 10:00am, his Aide-De-Camp (ADC), personal assistant to the air chief, handed him a small piece of paper. That small note would take Mahmud through a whirlwind of events for the next five days and change his life.\r\n\r\nThe note said a hijacked Japan Airlines aircraft with 156 passengers including 14 crew members had been circling over the Tejgaon Airport seeking permission to land.\r\n\r\nMahmud was sitting next to the president and CMLA General Ziaur Rahman. He handed over the note to Zia who instructed him to go to the airport and handle the situation.\r\n\r\nMahmud got in touch with the hijackers from the airport control tower after he reached the airport.\r\n\r\nFive armed members of the Japanese Red Army (JRA) led by Osamu Maruoka had hijacked the Paris to Tokyo DC-8 aircraft soon after it took off from Bombay after a short stopover.\r\n\r\nHe tried to convince the hijackers that they should land somewhere else as the country was new and might not be able to provide the services they might ask for. But the hijackers ignored his suggestion and landed anyway, Air Vice-Marshal (retd) AG Mahmud said in a recent interview with The Daily Star at his Gulshan residence.\r\n\r\n“It was just the beginning of a 105-hour-long hostage drama,” the 83-year-old Mahmud said recalling the incident 40 years later.\r\n\r\nIt was Mahmud\'s untiring efforts and negotiating skills with both the Japanese government and the hijackers, 130 passengers were released before the hijackers left Tejgaon Airport with 26 passengers on November 1.\r\n\r\nThey later landed in Algiers, the capital of Algeria. A couple of days later, rest of the passengers were released, AG Mahmud said.\r\n\r\nThe Japanese government has nominated Mahmud to be awarded their highest civilian award “The Order of the Rising Sun, Gold and Silver Star” for his dedicated efforts. The award would be handed over to him on May 9 in Japan.', '2017-05-08 03:45:35', '2017-05-08 03:45:35', 10),
(16, 'Sports', 'General', 'Rabi Bolse', 'Ki bolse jana Jaynai', '2017-05-08 03:50:35', '2017-05-08 03:50:35', 10),
(17, 'Entertainment', 'General', 'THE FLIGHT OF DOYEL', 'When have you started in the media?\r\n\r\nIt all began with a photoshoot for Prothom Alo\'s \'Noksha\' supplement. I decided to give it a shot without a second thought. It was back at 14 August, 2014, and I remember the date because it was quite special to me. Afterwards, I started getting offers for other magazines and eventually started work on the ramp. Since I have come to this business without any prior preparation, I would say I am learning bit by bit as I go.\r\n\r\nPeople have always criticized the lifestyle of ramp models. What is your take on that?\r\n\r\nFortunately I have yet to come across any serious criticism regarding that. I personally think one\'s lifestyle is entirely one\'s own. People shouldn\'t really judge you because of that. It all depends on how you conduct yourself and how you do your work. \r\n\r\nA lot of stars who were successful in the ramp haven\'t had as much success in acting. Why do you think that happens?\r\n\r\nThat\'s quite natural, in my opinion. Some people might not have interest in acting. Besides, the magnitudes of the two stages are quite different. The ramp is all about glamour and exhibiting fabulous outfits. But when it comes to the set, you have to be prepared in an entirely different way. The work that you do when acting demands a different kind of requirement. Honestly, I cannot judge my own success in acting until the movie comes out and everyone enjoys it.', '2017-05-08 04:14:48', '2017-05-08 04:14:48', 10),
(18, 'National', 'Top', 'ব্যাংক পরিচালনায় একই পরিবারের চারজন থাকতে পারবেন', 'ব্যাংক কোম্পানি আইন দ্বারা পরিচালিত ব্যাংকে একই পরিবারের চারজনকে পরিচালক নিয়োগের বিধান যুক্ত করে আইনটি সংশোধনের অনুমোদন দিয়েছে মন্ত্রিসভা।\r\n\r\nআজ সোমবার সচিবালয়ে প্রধানমন্ত্রী শেখ হাসিনার সভাপতিত্বে মন্ত্রিসভার নিয়মিত বৈঠকে এই ব্যাংক কোম্পানি (সংশোধন) আইন ২০১৭-এর খসড়া নীতিগত অনুমোদন পেয়েছে। বৈঠক শেষে মন্ত্রিপরিষদ সচিব মোহাম্মদ শফিউল আলম ব্রিফিংয়ে এ-সংক্রান্ত তথ্য জানান। \r\n\r\nবর্তমানে এ ধরনের ব্যাংকে একই পরিবারের সর্বোচ্চ দুজন পরিচালক হতে পারেন। প্রস্তাবিত আইনটি পাস হলে চারজন পরিচালক হতে পারবেন।\r\n\r\nপ্রস্তাবিত আইনে পরিচালকদের মেয়াদও বাড়ানো হয়েছে। আইন অনুযায়ী, পরিচালকেরা একনাগাড়ে নয় বছর পর্যন্ত দায়িত্বে থাকতে পারবেন। তিন বছর বিরতি দিয়ে তাঁরা ফের পরিচালক হতে পারবেন। \r\n\r\nবর্তমান আইনে তিন বছর করে পরপর দুই মেয়াদে মোট ছয় বছর একই ব্যক্তি পরিচালক হতে পারেন। এরপর তিন বছর বিরতি দিয়ে ফের পরিচালক হতে পারেন। \r\n\r\nপ্রস্তাবিত আইন অনুযায়ী, মনোনীত বা নির্বাচিত পরিচালক নিয়োগের জন্য বাংলাদেশ ব্যাংকের অনুমোদনের বিধান যুক্ত করা হয়েছে। \r\n\r\nআজকের মন্ত্রিসভায় বিনিয়োগকারী বা উদ্যোক্তাদের সুবিধার্থে ওয়ানস্টপ সার্ভিসের ব্যবস্থা রেখে আরেকটি আইনের খসড়া নীতিগতভাবে অনুমোদন দেওয়া হয়েছে।\r\n\r\nওয়ানস্টপ সার্ভিস আইন ২০১৭-এর খসড়া অনুযায়ী, বিনিয়োগকারীরা একই জায়গা থেকে বিভিন্ন ধরনের সেবা পাবেন। এই সেবার নাম হবে ‘কেন্দ্রীয় ওয়ানস্টপ সার্ভিস’। এই ব্যবস্থায় বিদ্যুৎ-গ্যাসের সংযোগ, ভূমি অধিগ্রহণ, ট্রেড লাইসেন্স, ভিসা, নাম ছাড়পত্রসহ মোটাদাগে ১৬টি সেবা মিলবে।\r\n\r\n', '2017-05-08 05:10:39', '2017-05-08 05:10:39', 1),
(19, 'Entertainment', 'General', 'Justin Bieber to appear on \'Koffee With Karan\'', ' Grammy Award winning singer Justin Bieber will be in conversation with celebrated filmmaker Karan Johar on his show \"Koffee With Karan”.\r\n\r\nBieber is set to visit India for the first time for his Jio Justin Bieber Purpose Tour. The show will take place on Wednesday in New Delhi, reports The Times of India.\r\n\r\nIf everything goes as planned, Karan, who has conducted interactive chat show dialogues with international celebrities like Richard Gere, Maria Sharapova, Hugh Jackman and Christian Louboutin apart from working closely with Meryl Streep, Robert De Niro, George Clooney at world forum panels.\r\n\r\nThis will be the first time an international celebrity of Bieber’s calibre will be featuring in an Indian chat show format.', '2017-05-08 12:11:16', '2017-05-08 15:03:17', 1);

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `type`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'ahsanintiser04@yahoo.com', 'Admin', '$2y$10$NKCUT4dSfOiIDwqHxZvEFer9QtJ8XY9dQhV5uBQILAM5wryiP7SD2', 'im6HtLaGhFrtAsGUf3OxgKr7ioQC8inqw8ZnyRn3BgKsd6BxMJ4NnFUhbsqm', '2017-04-26 16:09:02', '2017-05-08 12:37:14'),
(2, 'ahsanintiser04@gmail.com', 'Admin', '$2y$10$x1347OVlzn11UXztbPF0ruYjIgiPq62e71iFvEKaoll9iXlWyG9x6', NULL, '2017-04-26 16:18:08', '2017-04-26 16:18:08'),
(10, 'droid@gmail.com', 'Moderator', '$2y$10$mQnlsTWzdHupynjY18XPT.5MLE14jEO293u2JP.FCgDQj69ue3BDK', '0xAXY23YX45AB4RdX5ge4VNXEfnQLaN2aDup5JxJvAk5qqtsKFjRwsWDIMQn', '2017-05-08 03:29:09', '2017-05-08 06:23:34'),
(11, 'shaheen840@gmail.com', 'Admin', '$2y$10$Hq7zdd6snLmC7fO7.sag7OigJa0xrG93XGYrKe4l.OpQVsh0T4bre', NULL, '2017-05-08 12:16:37', '2017-05-08 12:16:37'),
(12, 'droid_nightwing@yahoo.com', 'Admin', '$2y$10$cmDN0jlaVpijHJJ4YxV/3.H.CubM.VKjcwYrPbv2M/3XwXWIiUMv.', NULL, '2017-05-08 12:16:55', '2017-05-08 12:16:55'),
(13, 'msjahid@outlook.com', 'Admin', '$2y$10$kDTsdHhCprZDkVoKbOSqH.4rlAgclCMaTXykgqcwK3Or6TKzrgalS', NULL, '2017-05-08 12:17:11', '2017-05-08 12:17:11'),
(14, 'rabitakarimdisha@gmail.com', 'Admin', '$2y$10$qhYRQ2DF8OBTDQBFH1SGD.ib5kjZc67.6s2fkxcuj9ayInK.RkwTy', NULL, '2017-05-08 12:17:24', '2017-05-08 12:17:24'),
(15, 'mahmud.mishu4@gmail.com', 'Admin', '$2y$10$KAER2XyTAZSzycFvx7DeLOSeP1FGFX46vc7SSFFa62aQgySmHQcPW', NULL, '2017-05-08 12:17:39', '2017-05-08 12:17:39'),
(16, 'tahniatswarna25@gmail.com', 'Admin', '$2y$10$knsphrupNlt71/bmfduttOfTYAaszKuFp1sR.U.XzoH1xQE61jWn6', NULL, '2017-05-08 12:17:54', '2017-05-08 12:17:54'),
(17, 'nazmalana304@gmail.com', 'Admin', '$2y$10$yEzeI0zCO/lwdqMqVTrwdu5jUmrt0gH4CU1WpL770g3OJkoZ6xb1m', NULL, '2017-05-08 12:18:08', '2017-05-08 12:18:08'),
(18, 'prokritiahmed29@gmail.com', 'Admin', '$2y$10$dAnHVdHmGZTGSoDnEzdFt.2BRadBNO0BhQ6id5UuUIYAdiy7dIr1S', NULL, '2017-05-08 12:18:21', '2017-05-08 12:18:21');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applications`
--
ALTER TABLE `applications`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `applications_email_unique` (`email`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`),
  ADD KEY `password_resets_token_index` (`token`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applications`
--
ALTER TABLE `applications`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
