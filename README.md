# HRMS (Human Resource Management System)
### Main Directory <a href="https://github.com/slayerprogrammer/HRMS.Java/tree/master/src/main/java/com/hrms/applicationhrms"> click </a>

### Java - Spring Based Software.
### Dependencies : 
- Spring Boot DevTools
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Lombok

-İş kuralları(Business Rules) yazıldı. 
-Mesajlar için Sabitler yazıldı.

### İş arayanlar

- Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istendi.
- Tüm alanlar zorunludur. Kullanıcı bilgilendirildi.
- Şifreler Kontrol edildi.
- Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirildi.
- Doğrulama geçerli değilse kullanıcı bilgilendirildi.
- Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirildi.
- Kayıdın gerçekleşmesi için e-posta doğrulaması (sahte servis) yazıldı.

### İş verenler

- Kayıt sırasında kullanıcıdan gerekli bilgiler istendi.
- Web sitesi ile aynı domaine sahip değil ise işlem gerçekleşmez.
- Tüm alanlar zorunludur. Kullanıcı bilgilendirildi.
- E posta doğrulaması (sahte servis) yazıldı.
- HRMS Personeli onayı için servis yazıldı. Onay bekleyen iş verenler adında bir tablo oluşturdum.
- E-posta doğrulaması yapılmış ise iş veren bu tabloya kaydolur. Sistem personelleri , onaylanmamış iş verenleri listeler , Onaylayabilir veya reddedebilir. Her iki işlemde de onay bekleyen iş verenler adındaki tablodan ilgili kayıt silinir. Onaylamış ise iş veren sisteme kayıt olur.(Front end tarafında sistem personeli onay bekleyenleri listeleyip butonlar ile onay veya red işlemi gerçekleştirir diye düşünerek hareket ettim.)
- Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirildi.
- Sisteme genel iş pozisyonu isimleri eklenebilmektedir. Pozisyonlar tekrar edemez kullanıcı bilgilendirildi.
- Tüm kullanıcılar listelenir. (Users tablosu tüm kullanıcılar)
- İş verenler listelendi.
- İş arayanlar listelendi.
- İş pozisyonları listelendi.


### Job seekers

- During registration, the user was asked for name, surname, tcno, year of birth, e-mail, password, password repeat information.
- All fields are required. The user has been informed.
- Passwords Checked.
- Mernis verification was done and the system was registered.
- If the verification is not valid, the user was notified.
- If there is a previously registered e-mail or tcno, the registration will not take place. The user has been informed.
- E-mail verification (fake service) has been written for registration.

### Employers

- Necessary information was requested from the user during registration.
- If it does not have the same domain as the website, the transaction will not take place.
- All fields are required. The user has been informed.
- Email verification (fake service) has been written.
- Service written for HRMS Personnel approval. I created a table called employers waiting for approval.
- If e-mail has been verified, the employer is registered in this table. System personnel list unapproved employers, Approve or reject them. In both transactions, the relevant record is deleted from the table called employers waiting for approval. If approved, the employer registers to the system.
- If there is a registered e-mail before, registration will not take place. The user has been informed.
- General job position names can be added to the system. The user has been informed that the positions cannot be repeated.
- All users are listed. (Users table all users)
- Employers listed.
- Job seekers listed.
- Job positions are listed.
