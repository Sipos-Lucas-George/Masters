1.  Cross-Site Request Forgery (CSRF) attacks leverage which aspect of web applications?
	a.  Vulnerabilities in server-side database management systems.
	b.  The user's existing browser session and the browser's automatic handling of session-related information like cookies.
	c.  The lack of encryption in HTTP communication.
	d.  The need for attackers to figure out a user's session ID.

2.  What is the fundamental goal of a CSRF attack?
	a.  To flood the web server with a large number of requests, causing a denial of service.
	b.  To trick a logged-in user into unintentionally submitting a malicious request.
	c.  To directly steal a user's login credentials.
	d.  To gain unauthorized access to the web server's file system.

3.  According to the lecture, which of the following actions can an attacker potentially induce a victim to perform through a CSRF attack?
	a.  Executing arbitrary code on the victim's computer.
	b.  Intercepting and modifying the victim's network traffic in real-time.
	c.  Creating, deleting, updating, or changing data or settings within the web application.
	d.  Gaining access to the victim's browsing history.

4.  Both On-Site Request Forgery (OSRF) and Cross-Site Request Forgery (CSRF) rely on which of the following?
	a.  The server requiring explicit user confirmation for all state-changing actions.
	b.  The attacker having direct access to the victim's computer.
	c.  The web browser blocking requests from different origins.
	d.  The web browser automatically sending session-related information (like cookies) with requests and knowledge of valid web application URLs.

5.  The lecture mentions that CSRF attacks often exploit HTML elements that can trigger server requests. Which of the following is given as an example?
	a.  `<style>` tags.
	b.  `<form>` tags with JavaScript-based submission.
	c.  `<img src=“http://example.com”/>` tags.
	d.  `<script>` tags.

6.  In black box testing for CSRF vulnerabilities, what is a crucial step?
	a.  Creating an HTML page containing a crafted HTTP request to a target URL and attempting to have a logged-in victim access it.
	b.  Analyzing the server-side code for session management flaws.
	c.  Using automated scanners to identify potential vulnerabilities.
	d.  Examining the browser's local storage for sensitive information.

7.  What is a key aspect to observe when testing for CSRF using the black box method?
	a.  The result of the action triggered by the crafted request when performed by a logged-in user.
	b.  Whether the server returns detailed error messages.
	c.  The complexity of the application's JavaScript code.
	d.  The time it takes for the server to process the request.

8.  In grey box testing for CSRF, what is the primary focus of the review?
	a.  The database schema and query structures.
	b.  The visual design and user interface of the web application.
	c.  The network infrastructure and firewall configurations.
	d.  The web application's session management to determine if it solely relies on client-side values like cookies or HTTP authentication credentials.

9.  Which of the following is a recommended "Do" for CSRF mitigation according to the lecture?
	a.  Only accepting POST requests for state-changing operations.
	b.  Generating a unique nonce (a "number used once") for each form submission.
	c.  Using a secret cookie that is not exposed to JavaScript.
	d.  Relying solely on HTTPS to protect against request forgery.

10. What is the purpose of generating a unique nonce for each form in CSRF mitigation?
	a.  To encrypt the form data before submission.
	b.  To uniquely identify the user submitting the form.
	c.  To improve the performance of form submissions.
	d.  To make it difficult for an attacker to predict or reuse a valid form submission.

11. The lecture explicitly states certain methods are *not* effective CSRF mitigation strategies. Which of the following is listed as a "Do Not"?
	a.  Implementing the Same-Origin Policy.
	b.  Generating per-session nonces.
	c.  Only Accepting POST Requests.
	d.  Invalidating session IDs on logout.

12. Why is "only accepting POST requests" insufficient as a sole CSRF mitigation strategy?
	a.  Because legitimate web applications often use GET requests for state-changing operations.
	b.  Because POST requests are not automatically sent with session cookies.
	c.  Because attackers can often trick users into submitting POST requests through forms or JavaScript.
	d.  Because attackers can also forge POST requests.

13. According to the lecture, what is the purpose of the Same Origin Policy HTTP header in the context of CSRF?
	a.  To ensure that all resources on a web page originate from the same domain.
	b.  To encrypt the communication between the client and the server.
	c.  To prevent the browser from executing scripts from different origins.
	d.  To help protect against CSRF by allowing a resource to declare which origins are allowed to access it.

14. What is a client-side measure a user can take to help protect themselves from CSRF attacks, as suggested in the lecture?
	a.  Avoiding the use of HTTPS connections.
	b.  Remembering to log out of web applications.
	c.  Disabling cookies in their web browser.
	d.  Always using the same browser for all web applications.

15. Why is using a "Secret Cookie" alone not an effective CSRF mitigation?
	a.  Because secret cookies are typically stored in plain text.
	b.  Because the browser will automatically send the secret cookie with any request originating from the victim's browser to the vulnerable site, even those initiated by an attacker.
	c.  Because JavaScript can easily access and manipulate cookie values.
	d.  Because cookies are always transmitted over unencrypted connections.

16. The lecture suggests changing default passwords as a way to protect yourself from CSRF. How is this indirectly related to CSRF prevention?
	a.  Strong passwords make it harder for attackers to guess login credentials and directly access the account.
	b.  By reducing the likelihood of account takeover through other means, it minimizes the potential impact if a CSRF vulnerability is exploited while the user is logged in.
	c.  Applications with strong password policies are less likely to have other security vulnerabilities, including CSRF.
	d.  Changing default passwords often invalidates existing session IDs, preventing reuse.

17. What is the role of "URL Rewriting" in the context of CSRF mitigation, according to the lecture?
	a.  It is listed as a "Do Not" for CSRF mitigation, implying it's an ineffective or easily bypassed method.
	b.  It encrypts the URLs to prevent attackers from understanding the application's structure.
	c.  It ensures that all URLs are relative, making it harder for external sites to link to sensitive pages.
	d.  It adds random tokens to URLs to make them unpredictable.

18. Why is relying solely on HTTPS not sufficient to prevent CSRF attacks?
	a.  Because HTTPS only encrypts the data in transit, not the content or origin of the request.
	b.  Because attackers can still intercept and decrypt HTTPS traffic with the right tools.
	c.  Because HTTPS does not protect against client-side script execution.
	d.  Because even over an encrypted connection, the browser will still automatically send session cookies with forged requests.

19. What does the lecture suggest about using different browsers for sensitive browsing as a protective measure against CSRF?
	a.  It forces web applications to issue new session IDs more frequently.
	b.  It is a primary technical control that prevents CSRF vulnerabilities in web applications.
	c.  It isolates cookies and session information, potentially limiting the scope of a CSRF attack if one browser is compromised [not explicitly stated in Lecture 4, but a reasonable inference for enhanced security].
	d.  It is mentioned as a way for users to protect themselves, suggesting that keeping sensitive sessions separate can reduce the risk of unintentional actions.

20. In the context of CSRF, what is the significance of knowing valid web application URLs for an attacker?
	a.  It enables the attacker to directly access the server's database.
	b.  It helps the attacker identify potential victims.
	c.  It is necessary for crafting the malicious requests that the victim's browser will unknowingly submit.
	d.  It allows the attacker to bypass authentication controls.

21.  Cross-Site Request Forgery (CSRF) fundamentally relies on the fact that web browsers:
	a) Do not allow attackers to construct HTTP requests on behalf of an authenticated user.
	b) Automatically include session-related information such as cookies and HTTP authentication credentials with requests originating from a user's browser, regardless of the request's origin.
	c) Automatically encrypt all requests sent to web servers, making it difficult to detect malicious requests.
	d) Restrict cross-origin requests by default, requiring specific headers to allow them.

22.  According to the lecture, both On-Site Request Forgery (OSRF) and Cross-Site Request Forgery (CSRF) share which of the following prerequisites?
	a) The victim must be using an outdated web browser with known vulnerabilities.
	b) The attacker needs to know the victim's session ID.
	c) The targeted web application must exclusively use POST requests for state-changing operations.
	d) The web browser automatically handles session-related information, and the attacker has knowledge of valid web application URLs.

23.  In the context of testing for CSRF using a black box approach, which of the following steps is crucial for confirming a potential vulnerability?
	a) Observing network traffic between the client and server to identify any anomalies.
	b) Ensuring a victim user is logged into the target application while attempting to trigger a state change using a crafted HTML page hosted on a different domain.
	c) Examining the HTTP headers of the application's responses for the presence of security-related headers.
	d) Analyzing the server-side code to identify how session management is implemented.

24.  During grey box testing for CSRF, a security tester reviews the web application's session management. A key indicator of potential CSRF vulnerability would be if the application:
	a) Solely relies on client-side values such as cookies or HTTP authentication credentials to verify the authenticity of requests without server-side verification tied to the request's origin.
	b) Generates a unique session ID for each user upon successful authentication.
	c) Implements multi-factor authentication for sensitive operations.
	d) Utilizes HTTPS for all communication and sets the `Secure` flag on session cookies.

25.  The lecture explicitly advises against several practices as effective CSRF mitigation strategies. Which of the following is highlighted as an ineffective standalone protection against CSRF?
	a) Implementing the Same-Origin Policy using HTTP headers.
	b) Only accepting POST requests for state-changing operations.
	c) Generating a unique nonce for each form submission.
	d) Utilizing per-session nonces tied to the user's session.

26.  Why is relying solely on HTTPS not considered a sufficient countermeasure against CSRF attacks, according to the lecture?
	a) Because HTTPS does not protect against the disclosure of session IDs in URL parameters.
	b) Because many web applications incorrectly implement HTTPS, leaving them vulnerable to downgrade attacks.
	c) Because HTTPS only encrypts the communication channel but does not prevent the browser from sending session cookies with requests originating from malicious sites.
	d) Because attackers can intercept HTTPS traffic using man-in-the-middle techniques if the client does not validate the server's certificate.

27.  Consider a scenario where a web application implements "multi-step transactions" as a security measure. Why does the lecture state that this alone is not an effective CSRF mitigation?
	a) Because while it might make crafting a single malicious request more complex, an attacker can still potentially trick a user into completing each step of the transaction sequentially through multiple forged requests.
	b) Because attackers can often complete all the steps of a transaction programmatically.
	c) Because multi-step transactions increase the server's processing load and can lead to denial-of-service vulnerabilities.
	d) Because multi-step transactions can confuse legitimate users, leading to usability issues.

28.  The lecture recommends generating a unique "nonce" as a primary CSRF mitigation. What is the purpose of this nonce?
	a) To limit the number of requests a user can make within a specific timeframe.
	b) To uniquely identify the user's browser and prevent session hijacking.
	c) To encrypt the session cookie transmitted between the client and the server.
	d) To act as an unpredictable, server-side generated token that is embedded in forms and must be included in the subsequent request to verify that the request originated from a legitimate form submission within the current session.

29.  The "Same Origin Policy" (SOP) is mentioned in the context of CSRF mitigation via HTTP headers. How does leveraging the SOP help defend against CSRF?
	a) It ensures that all data transmitted between the client and server is encrypted, preventing attackers from intercepting sensitive information.
	b) It restricts the browser from storing cookies set by different origins, thus preventing attackers from setting malicious session cookies.
	c) It prevents the browser from executing scripts loaded from different origins, thus blocking malicious JavaScript from making unauthorized requests.
	d) When enforced through headers like `Origin` or `Referer` (though the latter can be unreliable), the server can check if the request originated from an expected domain, mitigating cross-site requests initiated by attackers.

30. When advising users on how to protect themselves from CSRF attacks, the lecture suggests "Use different browsers for sensitive browsing." What is the rationale behind this recommendation?
	a) Different browsers have different levels of security vulnerabilities, and using a more secure browser can prevent CSRF.
	b) This makes it harder for attackers to track a user's online activity across multiple websites.
	c) This practice can help isolate session cookies for different web applications. If one browser is tricked into making a malicious request, the session in another browser used for sensitive tasks might remain unaffected.
	d) Different browsers handle JavaScript execution differently, and some might block malicious CSRF-triggering scripts.

31. According to the lecture, why is simply using a "secret cookie" not an effective CSRF mitigation strategy?
	a) Because secret cookies are typically stored client-side and can be accessed by JavaScript.
	b) Because secret cookies expire after a short period, making them unreliable for long-term session management.
	c) Because attackers can easily guess the value of secret cookies through brute-force attacks.
	d) Because the browser will automatically include all cookies associated with a domain in every request to that domain, regardless of where the request originated. Therefore, a secret cookie will be sent along with a forged request.

32. In the context of CSRF, what is the potential risk associated with web page functions that heavily rely on Cookies and HTTP authentication information known by the web browser?
	a) It can expose sensitive information if the cookie or authentication data is transmitted over an unencrypted connection.
	b) It creates an opportunity for an attacker to craft malicious HTML that, when visited by an authenticated user, will trigger unintended actions on the web application because the browser will automatically include the necessary authentication information in the forged request.
	c) It can make the web application more vulnerable to SQL injection attacks.
	d) It can lead to session hijacking if an attacker can steal the cookie or authentication credentials.

33. The lecture provides examples of how HTML elements like `<img>` tags can be leveraged in CSRF attacks. What makes these elements particularly useful for such attacks?
	a) They can execute arbitrary JavaScript code within the context of the target website.
	b) They can be used to embed malicious iframes that can capture user input.
	c) They can bypass the Same-Origin Policy, allowing cross-domain requests without CORS headers.
	d) They can trigger GET requests to the server simply by being included in an HTML page, even if the user doesn't explicitly interact with them, and the browser will still attach relevant session cookies.

34. What is the primary difference highlighted in the lecture between CSRF (Cross-Site Request Forgery) and OSRF (On-Site Request Forgery)?
	a) CSRF involves an attack originating from a different website or context than the target application, whereas OSRF involves an attacker tricking a user into performing actions within the same website they are currently visiting (though OSRF is less commonly discussed and mitigated as a distinct category).
	b) CSRF targets vulnerabilities within a single website, while OSRF exploits weaknesses across multiple domains.
	c) CSRF requires the attacker to know the victim's session ID, while OSRF does not.
	d) CSRF primarily targets GET requests, while OSRF focuses on POST requests.

35. While the lecture focuses on technical aspects, consider the human element in CSRF. Why might "social engineering" be involved in successfully exploiting a CSRF vulnerability during black box testing?
	a) To convince the user to disable their browser's security features.
	b) To gain physical access to the victim's computer to steal session cookies.
	c) To induce the victim user to click on a malicious link or visit a crafted HTML page that triggers the forged request to the target application while they are authenticated.
	d) To trick the user into revealing their login credentials.

