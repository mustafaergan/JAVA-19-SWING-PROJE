# Telefon Görüşme Kayıt Uygulaması (Java Swing)

Telefonla ya da yüz yüze yapılan görüşmeleri kaydedip sonradan tarihe, kişiye ve görüşme tipine göre
sorgulamayı sağlayan küçük bir masaüstü uygulaması. Java-19 eğitim grubunda Swing ve Hibernate
konularını işlemek için yazıldı.

> **Not:** Bu depo 2017 yılında eğitim/örnek amaçlı yazıldı ve artık güncellenmiyor. Bağımlılıkları eskidir
> ve bilinen güvenlik açıkları içerir; üretimde kullanmayın.

## İçerik

Proje `TelefonUygulamasi/` klasöründedir.

| Paket / dosya | Ne yapar |
|---|---|
| `ui/Main.java` | Giriş penceresi: "Kayıt Gir" ve "Arama" düğmeleri |
| `ui/GenelGorusme.java` | Ad soyad, telefon, görüşme tipi ve mesajla yeni görüşme kaydı |
| `ui/Sorgula.java` | Başlangıç/bitiş tarihi, ad soyad ve görüşme tipine göre arama; sonuçlar tabloda listelenir |
| `entity/Person.java` | Görüşme kaydı (Hibernate entity) |
| `entity/SorgulaEntity.java` | Arama ölçütleri |
| `enums/GorusmeTipi.java` | Görüşme tipi: telefon / yüz yüze |
| `dao/DAO.java` | Hibernate ile kaydetme ve sorgulama |
| `hibernate.cfg.xml` | Veritabanı bağlantı ayarları |

## Teknolojiler

- Java 8 (Swing)
- Hibernate 5.1.0
- MySQL (mysql-connector-java 5.1.49)
- Maven (kaynak klasörü standart dışı: `src/`)

## Çalıştırma

1. Yerel MySQL'de `telefon` adlı bir veritabanı oluşturun. Tablolar Hibernate tarafından
   (`hbm2ddl.auto=update`) otomatik açılır.
2. `TelefonUygulamasi/src/hibernate.cfg.xml` içindeki kullanıcı adını ve `SIFRE_KALDIRILDI` yazan
   parolayı kendi veritabanı bilgilerinizle değiştirin. Yapılandırma `requireSSL=true` içerir; yerel
   MySQL'iniz SSL kullanmıyorsa bu satırı kaldırmanız gerekebilir.
3. Projeyi Eclipse'e *Existing Maven Project* olarak içe aktarın (ya da `mvn compile` ile derleyin) ve
   `com.vektorel.telefonuygulamasi.ui.Main` sınıfını çalıştırın.
