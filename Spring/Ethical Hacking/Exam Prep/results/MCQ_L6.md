1.  According to the lecture, where does the "Broken Authentication and Session Management" vulnerability category currently rank on the OWASP 2021 Top 10 list?
	a.  #3
	b.  #1
	c.  #10
	d.  #7

2.  What is the primary risk associated with Broken Authentication and Session Management vulnerabilities, as outlined in the lecture?
	a.  The application's database can be corrupted or deleted.
	b.  The web server's operating system can be compromised.
	c.  An attacker can capture credentials or bypass authentication methods to gain unauthorized access.
	d.  Users' browsers can be redirected to malicious websites.

3.  The lecture mentions that approximately what percentage of all Web Apps are vulnerable to Broken Authentication and Session Management issues?
	a.  10%
	b.  23%
	c.  15%
	d.  5%

4.  According to the lecture, what is a failure in protecting username, password, and session ID that can lead to Broken Authentication and Session Management?
	a.  Using complex password policies.
	b.  Regularly updating server software.
	c.  Unencrypted connections to the application (HTTP).
	d.  Implementing multi-factor authentication.

5.  What security measure does the lecture recommend to protect against eavesdropping on login credentials and session IDs transmitted between the client and server?
	a.  Using secure cookies with HTTPOnly flags.
	b.  Enabling transport-level encryption (SSL/TLS)/HTTPS on the server.
	c.  Implementing strong encryption algorithms for password storage.
	d.  Validating user input to prevent script injection.

6.  What is a characteristic of "Predictable Login Credentials" that makes them a security risk, according to the lecture?
	a.  They require frequent changes, leading to user frustration.
	b.  They are stored in encrypted formats in the application's database.
	c.  They are often long and difficult for users to remember.
	d.  They are easily guessable, such as default passwords on admin panels.

7.  The lecture states that users should be forced to take certain actions to mitigate the risk of predictable passwords. What are these actions?
	a.  Disable password recovery options.
	b.  Share passwords with trusted colleagues for redundancy.
	c.  Use strong password policies and change default passwords on systems and applications.
	d.  Store passwords in plain text so they are easier to remember.

8.  What security issue arises when an application does not discard or invalidate session IDs after a user logs out or after a certain period of inactivity, as described in the lecture?
	a.  SQL injection
	b.  Session hijacking
	c.  Session replay or unauthorized access using the old session ID
	d.  Denial-of-service

9.  How can applications mitigate the risk associated with session IDs not being invalidated on logout, according to the lecture?
	a.  By storing session IDs only on the client-side.
	b.  By setting a timeout on the session ID and invalidating it upon logout (e.g., setting the session ID cookie to expire).
	c.  By using URL parameters to manage session state.
	d.  By increasing the length and complexity of session IDs.

10. According to the lecture, what is a critical vulnerability related to how user authentication credentials are sometimes stored?
	a.  Using strong, but common, hashing algorithms.
	b.  Encrypting credentials without using a salt.
	c.  Limiting the number of failed login attempts.
	d.  Storing credentials using weak encryption or even as plain text.

11. What security best practice does the lecture recommend for storing user credentials to protect against full compromise if an attacker gains access to the stored data?
	a.  Salting and hashing the stored user credentials in addition to encryption.
	b.  Using reversible encryption algorithms.
	c.  Storing passwords in a separate, less secure database.
	d.  Only encrypting the passwords.

12. The lecture provides an example in Java where a password read from a properties file is base64 encoded. Why is this considered a weak form of protection?
	a.  The Java code snippet includes proper salting and hashing techniques.
	b.  Properties files are inherently secure storage locations.
	c.  Base64 encoding uses a strong encryption algorithm that is difficult to reverse.
	d.  Base64 is an encoding scheme, not encryption, and can be easily decoded.

13. What is the core mechanism of a "Session Fixation" attack, as described in the lecture?
	a.  The attacker guesses a valid session ID.
	b.  The attacker tricks the victim into using a session ID that the attacker already knows.
	c.  The attacker forces the server to create a predictable session ID.
	d.  The attacker intercepts a legitimate session ID during transmission.

14. According to the lecture, how can web application developers defend against session fixation attacks?
	a.  By implementing strict IP address-based session validation.
	b.  By only using cookies to manage session state.
	c.  By making session IDs longer and more random.
	d.  By assigning a different session cookie immediately after a user authenticates and avoiding including the cookie value in the URL.

15. The lecture discusses various properties of a Session ID. What is "Session ID name fingerprinting" and why should it be avoided?
	a.  It involves encoding sensitive user information within the session ID name.
	b.  It involves using a hash of the user's IP address as part of the session ID name for security.
	c.  It uses descriptive names for session ID cookies (e.g., PHPSESSID, JSESSIONID) that can reveal the underlying technologies and programming languages used by the application.
	d.  It refers to the process of verifying the user's browser type based on the session ID.

16. What is the minimum recommended length for a Session ID to prevent brute force attacks, according to the lecture?
	a.  256 bits (32 bytes)
	b.  96 bits (12 bytes)
	c.  128 bits (16 bytes)
	d.  64 bits (8 bytes)

17. What characteristic should Session ID content possess to prevent information disclosure attacks, as mentioned in the lecture?
	a.  It should include a timestamp of when the session was created.
	b.  It should contain encrypted user details for easy retrieval.
	c.  It must be meaningless to prevent attackers from decoding its contents and extracting user details.
	d.  It should be a sequential number for easy tracking.

18. The lecture outlines different mechanisms available in HTTP to maintain session state in web apps. Which of the following is a standard HTTP header used for this purpose?
	a.  URL parameters
	b.  Cookies
	c.  Body arguments on POST (hidden form fields)
	d.  URL arguments on GET

19. Why is Transport Layer Security (TLS)/HTTPS considered pivotal in protecting session ID exchange securely?
	a.  It ensures that session IDs are only stored on the server-side.
	b.  It makes session IDs shorter and less predictable.
	c.  It prevents the application from using cookies to manage session state.
	d.  It prevents active eavesdropping and passive disclosure of session IDs in network traffic by encrypting the communication.

20. According to the lecture, what does setting the "Secure" attribute on a cookie instruct the web browser to do?
	a.  To store the cookie in a more secure location on the user's computer.
	b.  To prevent client-side scripts from accessing the cookie.
	c.  To only send the cookie via an HTTPS connection.
	d.  To automatically delete the cookie when the browser is closed.

21. What does setting the "HttpOnly" attribute on a cookie instruct the web browser to do, as mentioned in the lecture?
	a.  To not allow client-side scripts (e.g., JavaScript) to access the cookie via the Document Object Model (DOM).
	b.  To encrypt the cookie's value before storing it.
	c.  To only send the cookie to the specified domain and subdomains.
	d.  To limit the lifespan of the cookie to the current session.

22. What is the purpose of the "Domain" and "Path" attributes of a cookie, according to the lecture?
	a.  To prevent the cookie from being modified by client-side scripts.
	b.  To indicate whether the cookie should be accessible over HTTPS only.
	c.  To instruct the web browser to only send the cookie to the specified domain and all subdomains (Domain) and within a specific directory path on the server (Path).
	d.  To specify when the cookie should expire.

23. What is the key difference between persistent and non-persistent cookies, as described in the lecture?
	a.  Non-persistent cookies can only be used over HTTPS.
	b.  Persistent cookies are more secure than non-persistent cookies.
	c.  Persistent cookies are stored on the user's disk until their expiration time, while non-persistent cookies are deleted when the browser session is closed.
	d.  Persistent cookies cannot have the HttpOnly attribute set.

24.  An application transmits login credentials over an unencrypted HTTP connection. According to the lecture, what is the most significant immediate risk associated with this practice concerning authentication and session management?
	a) The vulnerability to Man-in-the-Middle (MITM) attacks, allowing interception of usernames, passwords, and session IDs in transit.
	b) The potential for predictable login credentials to be exposed.
	c) The failure to invalidate session IDs upon user logout.
	d) The server's inability to set secure flags on cookies.

25.  The lecture emphasizes the importance of a strong password policy. If an application does not enforce this policy, allowing users to set easily guessable passwords, which primary authentication failure, as described in the lecture, is the application susceptible to?
	a) Exploitation of predictable login credentials leading to unauthorized access.
	b) Session ID being included in URLs.
	c) Inadequate protection of stored authentication details.
	d) Session fixation attacks.

26.  Consider a scenario where a user logs out of a web application. However, the application fails to invalidate the existing session ID on the server-side. What is the most critical security implication of this omission, as highlighted in the lecture?
	a) An attacker who previously intercepted the session ID could potentially reuse it to gain unauthorized access even after the legitimate user has logged out.
	b) The user might not be completely logged out on the client-side.
	c) It becomes difficult to track user activity for auditing purposes.
	d) The application might issue a new session ID too quickly upon the next login.

27.  The lecture discusses the inadequate protection of stored authentication details. Which of the following practices, if implemented in isolation, would offer the least effective protection for user passwords stored in a database, according to the information provided?
	a) Using a key derivation function (KDF) like Argon2 or bcrypt. (Note: While not explicitly named, this concept aligns with strong salting and hashing).
	b) Salting and hashing passwords using a strong cryptographic algorithm.
	c) Encrypting the password database at rest.
	d) Base64 encoding passwords.

28.  In a session fixation attack, as described in the lecture, what is the attacker's primary goal concerning the session ID?
	a) To induce a victim to authenticate using a session ID that the attacker already controls.
	b) To guess a valid session ID of a logged-in user.
	c) To flood the server with numerous invalid session IDs, leading to a denial-of-service.
	d) To extract the session ID of an administrator with elevated privileges.

29.  To defend against session fixation attacks, the lecture recommends that web application developers ensure their applications:
	a) Use very short session timeouts to limit the window of opportunity for attackers.
	b) Assign a different session cookie immediately after a user successfully authenticates.
	c) Store session IDs only on the client-side in browser local storage.
	d) Include the session ID in the URL to make it easily accessible for users.

30.  The lecture mentions that a Session ID should be long enough to prevent brute-force attacks. What is the minimum recommended length (in bits) for a session ID to be considered sufficiently resistant to such attacks, according to the lecture?
	a) 256 bits (32 bytes).
	b) 128 bits (16 bytes).
	c) 64 bits (8 bytes).
	d) 512 bits (64 bytes).

31.  Why should the content of a Session ID be meaningless, as emphasized in the lecture?
	a) To ensure compatibility across different web browsers.
	b) To prevent information disclosure attacks where an attacker might be able to decode the contents and extract user details.
	c) To improve the performance of session management.
	d) To make it harder for attackers to predict future session IDs.

32.  The lecture outlines various mechanisms available in HTTP to maintain session state. Which of the following methods of session ID transmission is generally considered the most secure when implemented correctly with other security measures?
	a) URL parameters.
	b) Body arguments on POST requests (hidden form fields).
	c) Cookies (standard HTTP header) with the `Secure` and `HttpOnly` attributes set.
	d) URL arguments on GET requests.

33. According to the lecture, what is the primary purpose of enabling Transport Layer Security (TLS)/HTTPS for the entire web session, not just the authentication process, in the context of session management?
	a) To prevent active eavesdropping and passive disclosure of the session ID in network traffic throughout the user's interaction with the application.
	b) To protect against Cross-Site Request Forgery (CSRF) attacks.
	c) To verify the identity of the web server to the client.
	d) To encrypt the user's login credentials on submission.

34. The lecture discusses the `Secure` attribute of a cookie used for session management. What specific security benefit does setting this attribute provide?
	a) It sets an expiration date for the cookie, limiting its lifespan.
	b) It prevents client-side JavaScript from accessing the cookie.
	c) It instructs the web browser to only send the cookie over HTTPS connections.
	d) It restricts the domains to which the cookie can be sent.

35. What is the main security advantage of setting the `HttpOnly` attribute on a session cookie, as mentioned in the lecture?
	a) It limits the size of the session cookie.
	b) It encrypts the cookie's value on the client-side.
	c) It prevents the cookie from being sent over unencrypted connections.
	d) It instructs the web browser not to allow client-side scripts (e.g., JavaScript) to access the cookie via the Document Object Model (DOM), thus mitigating the risk of session hijacking through Cross-Site Scripting (XSS) attacks.

36. An application uses session IDs that are generated based solely on the timestamp of the user's login. According to the lecture, what is the primary vulnerability associated with this practice?
	a) Difficulty in implementing proper session fixation defenses.
	b) Increased server load due to the high frequency of unique session IDs.
	c) Potential issues with session timeouts and invalidation.
	d) The increased likelihood of session ID predictability, making guessing attacks more feasible. (While this exact example isn't in Lecture 6, it aligns with the principle of unpredictable session IDs).

37. In the context of session management, what is the potential risk if an application uses different session ID names (e.g., `PHPSESSID` and `JSESSIONID`) for different parts of the application or for different user roles without proper synchronization and security considerations?
	a) It could complicate server-side session management logic.
	b) It might lead to browser compatibility issues.
	c) It could interfere with the application's ability to track user activity.
	d) It could potentially reveal information about the underlying technologies used by the application, aiding attackers in reconnaissance.

38. An application stores session IDs in URL parameters. While this maintains session state across requests, what is a significant security concern associated with this method, especially when considering the information presented in the lecture?
	a) Session IDs in URLs can be easily captured from browser history, server logs, and can be inadvertently shared, increasing the risk of session hijacking. (While not explicitly stated in Lecture 6, this is a well-known security risk associated with URL-based session management and aligns with the principles of secure session ID handling discussed).
	b) Cookies cannot be used in conjunction with URL-based session management.
	c) It requires more complex server-side logic for session tracking.

