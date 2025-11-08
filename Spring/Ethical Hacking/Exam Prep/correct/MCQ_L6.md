1.	#7
2.	An attacker can capture credentials or bypass authentication methods to gain unauthorized access.
3.	23%
4.	Unencrypted connections to the application (HTTP).
5.	Enabling transport-level encryption (SSL/TLS)/HTTPS on the server.
6.	They are easily guessable, such as default passwords on admin panels.
7.	Use strong password policies and change default passwords on systems and applications.
8.	Session replay or unauthorized access using the old session ID.
9.	By setting a timeout on the session ID and invalidating it upon logout (e.g., setting the session ID cookie to expire).
10.	Storing credentials using weak encryption or even as plain text.
11.	Salting and hashing the stored user credentials in addition to encryption.
12.	Base64 is an encoding scheme, not encryption, and can be easily decoded.
13.	The attacker tricks the victim into using a session ID that the attacker already knows.
14.	By assigning a different session cookie immediately after a user authenticates and avoiding including the cookie value in the URL.
15.	It uses descriptive names for session ID cookies (e.g., PHPSESSID, JSESSIONID) that can reveal the underlying technologies and programming languages used by the application.
16.	128 bits (16 bytes).
17.	It must be meaningless to prevent attackers from decoding its contents and extracting user details.
18.	Cookies
19.	It prevents active eavesdropping and passive disclosure of session IDs in network traffic by encrypting the communication.
20.	To only send the cookie via an HTTPS connection.
21.	To not allow client-side scripts (e.g., JavaScript) to access the cookie via the Document Object Model (DOM).
22.	To instruct the web browser to only send the cookie to the specified domain and all subdomains (Domain) and within a specific directory path on the server (Path).
23.	Persistent cookies are stored on the user’s disk until their expiration time, while non-persistent cookies are deleted when the browser session is closed.
24.	The vulnerability to Man-in-the-Middle (MITM) attacks, allowing interception of usernames, passwords, and session IDs in transit.
25.	Exploitation of predictable login credentials leading to unauthorized access.
26.	An attacker who previously intercepted the session ID could potentially reuse it to gain unauthorized access even after the legitimate user has logged out.
27.	Base64 encoding passwords.
28.	To induce a victim to authenticate using a session ID that the attacker already controls.
29.	Assign a different session cookie immediately after a user successfully authenticates.
30.	128 bits (16 bytes).
31.	To prevent information disclosure attacks where an attacker might be able to decode the contents and extract user details.
32.	Cookies (standard HTTP header) with the Secure and HttpOnly attributes set.
33.	To prevent active eavesdropping and passive disclosure of the session ID in network traffic throughout the user’s interaction with the application.
34.	It instructs the web browser to only send the cookie over HTTPS connections.
35.	It instructs the web browser not to allow client-side scripts (e.g., JavaScript) to access the cookie via the Document Object Model (DOM), thus mitigating the risk of session hijacking through Cross-Site Scripting (XSS) attacks.
36.	The increased likelihood of session ID predictability, making guessing attacks more feasible.
37.	It could potentially reveal information about the underlying technologies used by the application, aiding attackers in reconnaissance.
38.	Session IDs in URLs can be easily captured from browser history, server logs, and can be inadvertently shared, increasing the risk of session hijacking.