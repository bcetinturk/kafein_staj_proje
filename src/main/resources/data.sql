-- Categories
INSERT INTO category(category_id, category_parent_id, title) VALUES(1, 0, "Telefon");
INSERT INTO category(category_id, category_parent_id, title) VALUES(2, 1, "Cep Telefonu");
INSERT INTO category(category_id, category_parent_id, title) VALUES(3, 1, "Ev Telefonu");
INSERT INTO category(category_id, category_parent_id, title) VALUES(4, 1, "Tablet");
INSERT INTO category(category_id, category_parent_id, title) VALUES(5, 1, "Aksesuarlar");
INSERT INTO category(category_id, category_parent_id, title) VALUES(6, 5, "Akıllı Saat");
INSERT INTO category(category_id, category_parent_id, title) VALUES(7, 5, "Şarj Aleti");
INSERT INTO category(category_id, category_parent_id, title) VALUES(8, 5, "Selfie Çubuğu");
INSERT INTO category(category_id, category_parent_id, title) VALUES(9, 5, "Kulaklık");
INSERT INTO category(category_id, category_parent_id, title) VALUES(10, 9, "Kablolu Kulaklık");
INSERT INTO category(category_id, category_parent_id, title) VALUES(11, 9, "Kablosuz Kulaklık");

INSERT INTO category(category_id, category_parent_id, title) VALUES(12, 0, "Bilgisayar");
INSERT INTO category(category_id, category_parent_id, title) VALUES(13, 12, "Masaüstü Bilgisayar");
INSERT INTO category(category_id, category_parent_id, title) VALUES(14, 12, "Dizüstü Bilgisayar");
INSERT INTO category(category_id, category_parent_id, title) VALUES(15, 12, "Bileşenler");

INSERT INTO category(category_id, category_parent_id, title) VALUES(16, 13, "All-In-One");
INSERT INTO category(category_id, category_parent_id, title) VALUES(17, 13, "Oyun");
INSERT INTO category(category_id, category_parent_id, title) VALUES(18, 13, "Ofis");
INSERT INTO category(category_id, category_parent_id, title) VALUES(19, 13, "Masaüstü");

INSERT INTO category(category_id, category_parent_id, title) VALUES(20, 14, "Oyun");
INSERT INTO category(category_id, category_parent_id, title) VALUES(21, 14, "İkisi Bir Arada");
INSERT INTO category(category_id, category_parent_id, title) VALUES(22, 14, "Dizüstü");

INSERT INTO category(category_id, category_parent_id, title) VALUES(23, 15, "Anakart");
INSERT INTO category(category_id, category_parent_id, title) VALUES(24, 15, "Bellek (RAM)");
INSERT INTO category(category_id, category_parent_id, title) VALUES(25, 15, "İşlemci");
INSERT INTO category(category_id, category_parent_id, title) VALUES(26, 15, "Disk");
INSERT INTO category(category_id, category_parent_id, title) VALUES(27, 15, "Klavye");
INSERT INTO category(category_id, category_parent_id, title) VALUES(28, 15, "Mouse");
INSERT INTO category(category_id, category_parent_id, title) VALUES(29, 15, "Monitör");
INSERT INTO category(category_id, category_parent_id, title) VALUES(30, 15, "Hoparlör");

INSERT INTO category(category_id, category_parent_id, title) VALUES(31, 26, "HDD");
INSERT INTO category(category_id, category_parent_id, title) VALUES(32, 26, "SSD");

INSERT INTO category(category_id, category_parent_id, title) VALUES(33, 0, "Kamera");
INSERT INTO category(category_id, category_parent_id, title) VALUES(34, 33, "Video Kamera");
INSERT INTO category(category_id, category_parent_id, title) VALUES(35, 33, "Fotoğraf Makinesi");
INSERT INTO category(category_id, category_parent_id, title) VALUES(36, 33, "Araç İçi Kamera");
INSERT INTO category(category_id, category_parent_id, title) VALUES(37, 33, "Aksiyon Kamerası");
INSERT INTO category(category_id, category_parent_id, title) VALUES(38, 33, "Aksesuarlar");

INSERT INTO category(category_id, category_parent_id, title) VALUES(39, 38, "Tripod");
INSERT INTO category(category_id, category_parent_id, title) VALUES(40, 38, "Hafıza Kartı");
INSERT INTO category(category_id, category_parent_id, title) VALUES(41, 38, "Lens");
INSERT INTO category(category_id, category_parent_id, title) VALUES(42, 38, "Batarya");

INSERT INTO category(category_id, category_parent_id, title) VALUES(43, 0, "Televizyon");
INSERT INTO category(category_id, category_parent_id, title) VALUES(44, 43, "LED TV");
INSERT INTO category(category_id, category_parent_id, title) VALUES(45, 43, "OLED TV");
INSERT INTO category(category_id, category_parent_id, title) VALUES(46, 43, "4K & 8K");
INSERT INTO category(category_id, category_parent_id, title) VALUES(47, 43, "Aksesuar");

INSERT INTO category(category_id, category_parent_id, title) VALUES(48, 47, "Uydu Alıcısı");
INSERT INTO category(category_id, category_parent_id, title) VALUES(49, 47, "Sinema Sistemi");

INSERT INTO category(category_id, category_parent_id, title) VALUES(50, 0, "Oyun Konsolu");
INSERT INTO category(category_id, category_parent_id, title) VALUES(51, 50, "Playstation");
INSERT INTO category(category_id, category_parent_id, title) VALUES(52, 50, "Xbox");
INSERT INTO category(category_id, category_parent_id, title) VALUES(53, 50, "Nintendo");
INSERT INTO category(category_id, category_parent_id, title) VALUES(54, 50, "Oyun Kolları");

INSERT INTO category(category_id, category_parent_id, title) VALUES(55, 0, "Ev Aletleri");
INSERT INTO category(category_id, category_parent_id, title) VALUES(56, 55, "Elektrikli Süpürge");
INSERT INTO category(category_id, category_parent_id, title) VALUES(57, 55, "Ütü");
INSERT INTO category(category_id, category_parent_id, title) VALUES(58, 55, "Buzdolabı");
INSERT INTO category(category_id, category_parent_id, title) VALUES(59, 55, "Çamaşır Makinesi");
INSERT INTO category(category_id, category_parent_id, title) VALUES(60, 55, "Derin dondurucu");
INSERT INTO category(category_id, category_parent_id, title) VALUES(61, 55, "Fırın");
INSERT INTO category(category_id, category_parent_id, title) VALUES(62, 55, "Tost Makinesi");

INSERT INTO category(category_id, category_parent_id, title) VALUES(63, 0, "Aksesuar");
INSERT INTO category(category_id, category_parent_id, title) VALUES(64, 63, "USB Bellek");
INSERT INTO category(category_id, category_parent_id, title) VALUES(65, 63, "Pil ve Şarj Cihazları");
INSERT INTO category(category_id, category_parent_id, title) VALUES(66, 63, "3D Gözlük");
INSERT INTO category(category_id, category_parent_id, title) VALUES(67, 63, "Sanal Gerçeklik Gözlüğü");
INSERT INTO category(category_id, category_parent_id, title) VALUES(68, 63, "Powerbank");
INSERT INTO category(category_id, category_parent_id, title) VALUES(69, 63, "Drone");
INSERT INTO category(category_id, category_parent_id, title) VALUES(70, 63, "Yazıcı");
INSERT INTO category(category_id, category_parent_id, title) VALUES(71, 63, "Tarayıcı");

-- Products
INSERT INTO product(id, description, price, product_name, quantity, category_id) VALUES(72, 'HP Pavilion 15-DK0002NT Intel Core i5 9300H 8GB 256GB SSD GTX1050 Windows 10 Home 15.6" FHD Taşınabilir Bilgisayar', 6600, 'HP Pavilion 15-DK0002NT', 10, 20);
INSERT INTO product(id, description, price, product_name, quantity, category_id) VALUES(73, 'AMD Ryzen5 4600 8GB 512GB SSD GTX1650Ti Linux 15.6" FHD Taşınabilir Bilgisayar', 7000, 'Acer Nitro AN515-44-R6ZW', 5, 20);
INSERT INTO product(id, description, price, product_name, quantity, category_id) VALUES(74, '40" 101 Ekran Uydu Alıcılı Full HD Smart LED TV ', 2500, 'Samsung 40T5300', 13, 44);
INSERT INTO product(id, description, price, product_name, quantity, category_id) VALUES(75, 'Huawei P40 Lite 128 GB (Huawei Türkiye Garantili)', 3200, 'Huawei P40 Lite', 5, 2);