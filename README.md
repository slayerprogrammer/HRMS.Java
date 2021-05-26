# HRMS (Human Resource Management System)
### Main Directory <a href="https://github.com/slayerprogrammer/HRMS.Java/tree/master/src/main/java/com/hrms/tolga"> click </a>

### Java - Spring Based Software.
### Dependencies : 
- Spring Boot DevTools
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Lombok

İş kuralları(Business Rules) yazıldı. 
Mesajlar için Sabitler yazıldı.

İş arayanlar

-> Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istendi.
-> Tüm alanlar zorunludur. Kullanıcı bilgilendirildi.
-> Şifreler Kontrol edildi.
-> Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirildi.
-> Doğrulama geçerli değilse kullanıcı bilgilendirildi.
-> Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirildi.
-> Kayıdın gerçekleşmesi için e-posta doğrulaması (sahte servis) yazıldı.

İş verenler

-> Kayıt sırasında kullanıcıdan gerekli bilgiler istendi.
-> Web sitesi ile aynı domaine sahip değil ise işlem gerçekleşmez.
-> Tüm alanlar zorunludur. Kullanıcı bilgilendirildi.
-> E posta doğrulaması (sahte servis) yazıldı.
-> HRMS Personeli onayı için servis yazıldı. Onay bekleyen iş verenler adında bir tablo oluşturdum.
   E-posta doğrulaması yapılmış ise iş veren bu tabloya kaydolur. Sistem personelleri , onaylanmamış 
   iş verenleri listeler , Onaylayabilir veya reddedebilir. Her iki işlemde de onay bekleyen iş verenler adındaki 
   tablodan ilgili kayıt silinir. Onaylamış ise iş veren sisteme kayıt olur.
   (Front end tarafında sistem personeli onay bekleyenleri listeleyip butonlar ile onay veya red işlemi gerçekleştirir
   diye düşünerek hareket ettim.)
-> Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirildi.


-> Sisteme genel iş pozisyonu isimleri eklenebilmektedir. Pozisyonlar tekrar edemez kullanıcı bilgilendirildi.

-> Tüm kullanıcılar listelenir. (Users tablosu tüm kullanıcılar)
-> İş verenler listelendi.
-> İş arayanlar listelendi.
-> İş pozisyonları listelendi.
