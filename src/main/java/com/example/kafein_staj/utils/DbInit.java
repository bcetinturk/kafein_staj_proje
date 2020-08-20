package com.example.kafein_staj.utils;

import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Role;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.repository.CategoryRepository;
import com.example.kafein_staj.repository.ProductRepository;
import com.example.kafein_staj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public DbInit(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category(0L, 1L, "Telefon"));
            categoryRepository.save(new Category(1L, 2L, "Cep Telefonu"));
            categoryRepository.save(new Category(1L, 3L, "Ev Telefonu"));
            categoryRepository.save(new Category(1L, 4L, "Tablet"));
            categoryRepository.save(new Category(1L, 5L, "Aksesuarlar"));
            categoryRepository.save(new Category(5L, 6L, "Akıllı Saat"));
            categoryRepository.save(new Category(5L, 7L, "Şarj Aleti"));
            categoryRepository.save(new Category(5L, 8L, "Selfie Çubuğu"));
            categoryRepository.save(new Category(5L, 9L, "Kulaklık"));
            categoryRepository.save(new Category(9L, 10L, "Kablolu Kulaklık"));
            categoryRepository.save(new Category(9L, 11L, "Kablosuz Kulaklık"));

            categoryRepository.save(new Category(0L, 12L, "Bilgisayar"));
            categoryRepository.save(new Category(12L, 13L, "Masaüstü Bilgisayar"));
            categoryRepository.save(new Category(12L, 14L, "Dizüstü Bilgisayar"));
            categoryRepository.save(new Category(12L, 15L, "Bileşenler"));

            categoryRepository.save(new Category(13L, 16L, "All-In-One"));
            categoryRepository.save(new Category(13L, 17L, "Oyun"));
            categoryRepository.save(new Category(13L, 18L, "Ofis"));
            categoryRepository.save(new Category(13L, 19L, "Masaüstü"));

            categoryRepository.save(new Category(14L, 20L, "Oyun"));
            categoryRepository.save(new Category(14L, 21L, "İkisi bir arada"));
            categoryRepository.save(new Category(14L, 22L, "Dizüstü"));

            categoryRepository.save(new Category(15L, 23L,  "Anakart"));
            categoryRepository.save(new Category(15L, 24L,  "Bellek (RAM)"));
            categoryRepository.save(new Category(15L, 25L,  "İşlemci"));
            categoryRepository.save(new Category(15L, 26L,  "Disk"));
            categoryRepository.save(new Category(15L, 27L,  "Klavye"));
            categoryRepository.save(new Category(15L, 28L,  "Mouse"));
            categoryRepository.save(new Category(15L, 29L,  "Monitör"));
            categoryRepository.save(new Category(15L, 30L,  "Hoparlör"));

            categoryRepository.save(new Category(26L, 31L, "HDD"));
            categoryRepository.save(new Category(26L, 32L, "SSD"));

            categoryRepository.save(new Category(0L, 33L, "Kamera"));
            categoryRepository.save(new Category(33L, 34L, "Video Kamera"));
            categoryRepository.save(new Category(33L, 35L, "Fotoğraf Makinesi"));
            categoryRepository.save(new Category(33L, 36L, "Araç İçi Kamera"));
            categoryRepository.save(new Category(33L, 37L, "Aksiyon Kamerası"));
            categoryRepository.save(new Category(33L, 38L, "Aksesuarlar"));

            categoryRepository.save(new Category(38L, 39L, "Tripod"));
            categoryRepository.save(new Category(38L, 40L, "Hafıza Kartı"));
            categoryRepository.save(new Category(38L, 41L, "Lens"));
            categoryRepository.save(new Category(38L, 42L, "Batarya"));

            categoryRepository.save(new Category(0L, 43L, "Televizyon"));
            categoryRepository.save(new Category(43L, 44L, "LED TV"));
            categoryRepository.save(new Category(43L, 45L, "OLED TV"));
            categoryRepository.save(new Category(43L, 46L, "4K & 8K"));
            categoryRepository.save(new Category(43L, 47L, "Aksesuar"));

            categoryRepository.save(new Category(47L, 48L, "Uydu Alıcısı"));
            categoryRepository.save(new Category(47L, 49L, "Sinema Sistemi"));

            categoryRepository.save(new Category(0L, 50L, "Oyun Konsolu"));
            categoryRepository.save(new Category(50L, 51L, "Playstation"));
            categoryRepository.save(new Category(50L, 52L, "Xbox"));
            categoryRepository.save(new Category(50L, 53L, "Nintendo"));
            categoryRepository.save(new Category(50L, 54L, "Oyun Kolları"));

            categoryRepository.save(new Category(0L, 55L, "Ev aletleri"));
            categoryRepository.save(new Category(55L, 56L, "Elektrikli Süpürge"));
            categoryRepository.save(new Category(55L, 57L, "Ütü"));
            categoryRepository.save(new Category(55L, 58L, "Buzdolabı"));
            categoryRepository.save(new Category(55L, 59L, "Çamaşır Makinesi"));
            categoryRepository.save(new Category(55L, 60L, "Derin dondurucu"));
            categoryRepository.save(new Category(55L, 61L, "Fırın"));
            categoryRepository.save(new Category(55L, 62L, "Tost Makinesi"));

            categoryRepository.save(new Category(0L, 63L, "Aksesuar"));
            categoryRepository.save(new Category(63L, 64L, "USB Bellek"));
            categoryRepository.save(new Category(63L, 65L, "Pil ve Şarj Cihazları"));
            categoryRepository.save(new Category(63L, 66L, "3D Gözlük"));
            categoryRepository.save(new Category(63L, 67L, "Sanal Gerçeklik Gözlüğü"));
            categoryRepository.save(new Category(63L, 68L, "Powerbank"));
            categoryRepository.save(new Category(63L, 69L, "Drone"));
            categoryRepository.save(new Category(63L, 70L, "Yazıcı"));
            categoryRepository.save(new Category(63L, 71L, "Tarayıcı"));
        }

        if (userRepository.countByRole(Role.ADMIN) < 1) {   // system must have at least one admin
            userRepository.save(new User("", "", "admin@admin.com", "", "", Role.ADMIN, "admin"));
        }

    }
}
