1. An application stores user passwords using the MD5 hashing algorithm without any salting. If an attacker gains access to this password database, which of the following attack methods would be MOST effective in quickly compromising a significant number of passwords?
	a. Performing a man-in-the-middle attack to intercept new password submissions and reverse the MD5 hash in real-time.
	b. Utilizing a rainbow table pre-computed for MD5 hashes to directly look up the plaintext passwords.
	c. Exploiting a known implementation flaw in the specific database encryption used to automatically decrypt the MD5 hashes.
	d. Employing a brute-force attack targeting individual password hashes, leveraging high network speeds.

2. Which of the following scenarios BEST exemplifies the concept of "sensitive data exposure" as defined in the provided materials?
	a. A system administrator uses a complex, randomly generated password for the root account but stores it in a plain text file on their desktop.
	b. An e-commerce website transmits customer credit card details over HTTPS, but the private key for the SSL certificate is stored on the same server without strong access controls.
	c. A company's internal network traffic containing employee health records is transmitted without any encryption.
	d. A developer uses Base64 encoding to store API keys in a mobile application's configuration file.

3. An organization decides to implement asymmetric key encryption for securing email communications. What is the PRIMARY advantage of this approach compared to symmetric key encryption in this context, according to the sources?
	a. Asymmetric encryption inherently provides stronger protection against brute-force attacks compared to symmetric encryption.
	b. Asymmetric encryption eliminates the need for a secure channel to exchange encryption keys between communicating parties.
	c. Asymmetric encryption is significantly faster and better suited for encrypting large volumes of email data.
	d. Asymmetric encryption uses shorter key lengths, making it less computationally intensive for email clients.

4. A security assessment reveals that a web application uses the RC4 algorithm for encrypting session cookies. According to the provided lecture, what is the MOST significant concern regarding this practice?
	a. RC4 is listed as a potentially weak or risky cryptographic algorithm, indicating known vulnerabilities.
	b. RC4 is a block cipher with a relatively short 64-bit block size, making it susceptible to birthday attacks.
	c. RC4 is a symmetric key algorithm, and the secure management and distribution of the session key is likely to be complex.
	d. RC4 primarily functions as a hashing algorithm and is not suitable for encrypting sensitive data like session cookies.

5. Which of the following statements accurately distinguishes between encoding and encryption based on the information provided?
	a. Encoding uses publicly available schemes for data transformation and is easily reversible, whereas encryption uses algorithms to make data unreadable without a secret key.
	b. Encoding aims to transform data for security purposes using a secret key, while encryption focuses on making data publicly readable through a reversible process.
	c. Encoding is primarily used for indexing and retrieving data in databases, while encryption is used to protect data confidentiality during transmission.
	d. Encoding involves generating a fixed-length value representing the original data, while encryption transforms the data into a different format based on a key.

6. An attacker successfully conducts an SQL injection attack against an application that automatically encrypts and decrypts credit card numbers in its database. According to the "Example Attack Scenarios," what is the underlying vulnerability that allows the attacker to retrieve the credit card numbers in clear text in this situation?
	a. The application lacked proper key management, allowing the attacker to obtain the decryption key through the SQL injection vulnerability.
	b. The automatic decryption of data upon retrieval exposed the sensitive information, highlighting a flaw in the encryption's application.
	c. The system used a weak encryption algorithm like DES or Blowfish, which was easily broken by the attacker.
	d. The application failed to use HTTPS for all authenticated pages, allowing the attacker to intercept the decrypted data.

7. According to the "Mitigations" section, which of the following practices is MOST critical for protecting stored passwords against common password cracking techniques?
	a. Regularly rotating the hashing algorithm used for storing passwords to hinder the effectiveness of pre-computed rainbow tables.
	b. Encrypting the password database using a strong asymmetric encryption algorithm with a securely managed private key.
	c. Implementing two-factor authentication to prevent unauthorized access to the password database [None of the sources mention this].
	d. Storing passwords using hashing algorithms specifically designed for password protection, such as bcrypt or PBKDF2, and incorporating salts.

8. A penetration tester discovers that an application transmits sensitive user data over an open wireless network without any encryption. According to the provided materials, which type of attack is this scenario MOST susceptible to?
	a. A brute-force attack aimed at guessing user credentials during transmission.
	b. A man-in-the-middle attack to intercept and potentially modify the unencrypted data.
	c. An SQL injection attack to gain direct access to the application's database.
	d. A rainbow table attack to recover any hashed data being transmitted.

9. Which of the following key management practices is highlighted as crucial for robust cryptographic security in the provided lecture notes?
	a. Frequently updating cryptographic keys with short, easily memorable passphrases to ensure accessibility.
	b. Implementing secure key storage mechanisms and ensuring appropriate key lengths for the level of data protection required.
	c. Primarily relying on the secrecy of the encryption algorithm rather than the key itself.
	d. Storing cryptographic keys directly within client-side code to simplify implementation.

10. Considering the lifecycle of sensitive data, which of the following practices is strongly recommended as a mitigation against sensitive data exposure, even if robust encryption is in place?
	a. Regularly backing up all encrypted data to ensure recoverability in case of data loss.
	b. Obfuscating sensitive data using techniques like XOR or Base64 encoding before long-term storage.
	c. Implementing strong access control lists to limit who can view encrypted data [None of the sources mention this in detail].
	d. Avoiding the unnecessary storage of sensitive data and discarding it as soon as it is no longer needed.

