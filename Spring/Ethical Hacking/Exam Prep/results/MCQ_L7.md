1.  According to the lecture, what is another term that means the same thing as "access control"?
	a.  Authorization
	b.  Auditing
	c.  Encryption
	d.  Authentication

2.  The lecture states that access control is about mediating access to what based on a user-specific policy?
	a.  Physical locations only
	b.  Communication channels only
	c.  Resources such as users, processes, files, and data
	d.  Networks only

3.  Which of the following is listed in the lecture as a "meta-operation" that is often overlooked in access control?
	a.  Authentication
	b.  Network segmentation
	c.  Encryption
	d.  File Ownership

4.  According to the lecture, "network access" in the context of access control refers to:
	a.  The ability to connect to a system or service
	b.  The type of operating system used.
	c.  The ability to physically touch a system.
	d.  The speed of internet connection.

5.  Restricting transactions and configuration changes are examples of controlling:
	a.  Network access.
	b.  Restricted functions
	c.  Physical access.
	d.  Data storage.

6.  Which of the following is mentioned in the lecture as an example of access controls?
	a.  Frequent password changes
	b.  Two-factor authentication
	c.  Complex password requirements
	d.  Session lock after a period of inactivity

7.  The lecture lists several "Vulnerabilities" related to access control. Which of the following is included in that list?
	a.  Strong Encryption
	b.  Regular Security Audits
	c.  Insecure IDs
	d.  Principle of Least Privilege

8.  What is the potential impact of "Insecure IDs" as described in the lecture?
	a.  Attackers gaining access to areas and functions they should not
	b.  Malware infection.
	c.  Denial of service attacks.
	d.  Data loss due to encryption errors.

9.  The lecture provides an example where an attacker might change a 'uid' parameter in a URL. What type of vulnerability does this illustrate?
	a.  Client-side Caching
	b.  Path Traversal
	c.  Insecure IDs
	d.  File Permission issues

10. What does the vulnerability "Failure to restrict URL access" allow an attacker to do, according to the lecture?
	a.  Bypass authentication mechanisms.
	b.  Gain access to the application's database.
	c.  Modify files on the web server's file system.
	d.  Access resources not associated with their account, including administrative functionalities

11. The lecture uses the example of accessing `/admin_panel` without proper authorization to illustrate which vulnerability?
	a.  File Permission issues
	b.  Insecure IDs
	c.  Path Traversal
	d.  Failure to restrict URL access

12. What type of vulnerability does the lecture describe as allowing an attacker to access files and directories stored outside the web root folder by manipulating file references?
	a.  Insecure IDs
	b.  File Permission issues
	c.  Failure to restrict URL access
	d.  Path Traversal

13. The lecture provides an example URL `http://somesite.com/getMyPic.jsp?myPic=../../../../etc/passwd` to demonstrate:
	a.  Insecure handling of user sessions.
	b.  The impact of weak password policies.
	c.  A cross-site scripting attack.
	d.  Path Traversal vulnerability

14. According to the lecture, what is the risk associated with improper "File permissions" on a web server?
	a.  Users may not be able to access necessary files.
	b.  Web pages might load slowly.
	c.  The application might not function correctly.
	d.  Attackers can access sensitive files stored locally on the server that should not be publicly accessible

15. The lecture mentions that only specifically intended files for web users should be marked as readable by the application. How should other files and directories ideally be configured?
	a.  Readable by everyone.
	b.  All files should be executable.
	c.  Most files and directories should not be readable
	d.  Readable by the application and publicly.

16. What security issue arises when browsers cache web pages, especially on shared terminals, as described in the lecture?
	a.  The server's resources may be exhausted.
	b.  Users may see outdated information.
	c.  Attackers can gain access to previously visited, inaccessible site locations and data
	d.  The application's performance may degrade.

17. The lecture suggests using certain mechanisms to mitigate client-side caching issues. Which of the following is mentioned?
	a.  Encrypting all web traffic with HTTPS.
	b.  Implementing server-side session management.
	c.  HTTP Headers like `Cache-Control: no-store, no-cache, must-revalidate`
	d.  Using strong authentication protocols.

18. Which of the following is NOT listed in the lecture as an "Access Control Model"?
	a.  Rule-based access controls (RBAC)
	b.  Role-based access controls (RBAC)
	c.  Discretionary access controls (DAC)
	d.  Mandatory access controls (MAC)

19. What is the primary basis for restricting access in Discretionary Access Control (DAC), according to the lecture?
	a.  The sensitivity level of the information.
	b.  Contextual attributes like time of day and location.
	c.  The roles played by users in the organization.
	d.  The identity of users and their group memberships

20. Mandatory Access Control (MAC) primarily relies on what to control access to information?
	a.  Sensitivity labels assigned to information and the user's operating sensitivity level
	b.  The user's need-to-know basis determined by the object owner.
	c.  Attributes associated with the user and the resource.
	d.  User roles and permissions.

21. Which access control model is described in the lecture as being based on the roles played by users and groups within an organization?
	a.  Mandatory Access Control (MAC)
	b.  Discretionary Access Control (DAC)
	c.  Attribute-Based Access Control (ABAC)
	d.  Role-Based Access Control (RBAC)

22. According to the lecture, Attribute-Based Access Control (ABAC) makes access decisions based on:
	a.  Predefined roles assigned to users.
	b.  Sensitivity labels of the data.
	c.  The identity and group membership of the user.
	d.  Contextual attributes such as time of day and location

23. The lecture provides "Reminder tips" for access control. Which of the following is one of those tips?
	a.  Actively proxy requests to services behind a firewall.
	b.  Trust user-supplied URLs if they are properly encoded.
	c.  Embed database passwords directly in the application code for easy access.
	d.  Check authorization on every page of the application

24. What does the lecture advise regarding demo or debug code before going live with an application?
	a.  Remove all demo/debug code
	b.  Secure it with strong passwords.
	c.  Keep it enabled for easy troubleshooting.
	d.  Document it thoroughly for future reference.

25. According to the lecture's reminder tips, what should be done with default settings in third-party code or applications?
	a.  Document the default settings without reviewing them.
	b.  Assume they are secure and require no changes.
	c.  Only change them if a vulnerability is publicly known.
	d.  Change or verify defaults

26. What level of privileges should web servers and web applications ideally run with, according to the lecture's recommendations?
	a.  The same privileges as the database server.
	b.  A low-privilege account with only necessary permissions
	c.  Administrator or root privileges for ease of management.
	d.  Highest privileges to ensure all functions work.

27. The lecture advises limiting file permissions on web files. What is the primary reason for this recommendation?
	a.  To improve the performance of the web server.
	b.  To prevent unauthorized access to sensitive files
	c.  To prevent unauthorized modification of web content.
	d.  To simplify file management.

28. According to the lecture, how should session IDs be generated to prevent guessing?
	a.  Using timestamps as the primary component.
	b.  Based solely on user input.
	c.  Force a “sufficiently random” session id
	d.  Using a predictable sequential formula.

29. The lecture advises against using timestamps alone as a token. Why?
	a.  They cannot be used for expiring tokens.
	b.  They are too long and cumbersome.
	c.  They are easily guessable and may not be unique
	d.  They are difficult to generate and verify.

30. What does the lecture recommend regarding verifying user sessions and trusting IP addresses?
	a.  Only trust IP addresses for users with static IP addresses.
	b.  Verify the session and do not solely trust IP addresses due to potential changes
	c.  Embed IP addresses directly into the session token for security.
	d.  IP addresses are a reliable way to verify sessions for all users.

31. The lecture strongly advises against embedding sensitive information like database IDs or passwords where?
	a.  In configuration files.
	b.  In database tables.
	c.  In application code
	d.  In log files.

32.  An application uses sequentially generated integer IDs to reference user accounts in URLs (e.g., `http://somesite.com/userprofile?id=123`). While some basic authorization checks are in place, an attacker discovers they can increment the `id` parameter to access other users' profiles. According to the lecture, what is the fundamental access control vulnerability being exploited here?
	a) Insecure IDs that are predictable and not adequately validated against the current user's authorized scope.
	b) Vulnerability to Path Traversal attacks due to predictable parameters.
	c) Insufficient protection against Client-side Caching, leading to the exposure of cached profiles.
	d) Failure to implement Role-Based Access Control (RBAC).

33.  A web application has an administrative panel located at `http://somesite.com/admin/dashboard`. The developers have implemented a check on the server-side to verify if a user has the "administrator" role before displaying the dashboard. However, a standard authenticated user discovers they can directly access this URL and view the administrative interface. What primary access control failure, as described in the lecture, has occurred?
	a) Insufficient implementation of Discretionary Access Control (DAC).
	b) Lack of proper session termination after inactivity, leading to persistent admin sessions.
	c) Inadequate file permission settings on the server preventing the intended access checks from being executed.
	d) Failure to restrict URL access based on user roles and permissions, allowing unauthorized access to sensitive functionalities.

34.  Consider a scenario where a web application allows users to view image files based on a filename passed in a URL parameter (e.g., `http://somesite.com/viewimage?file=image1.jpg`). An attacker manipulates this parameter with the value `../../../../etc/shadow`. If the application processes this request without proper validation, what type of access control vulnerability is being exploited, and what is the potential impact?
	a) Insecure IDs, potentially leading to the exposure of sensitive user identifiers.
	b) File Permission misconfiguration, where the `/etc/shadow` file is incorrectly marked as publicly readable.
	c) Failure to restrict URL access, granting access to unintended image resources.
	d) Path Traversal, allowing the attacker to access arbitrary files and directories outside the web root, potentially including sensitive system files.

35.  A web server is configured such that all files within its web root are readable by the application's process. However, some configuration files containing sensitive database credentials are also located within this directory, although not directly linked or intended for public access. According to the lecture, what is the access control vulnerability present here?
	a) Inadequate implementation of Mandatory Access Control (MAC).
	b) Failure to restrict URL access to prevent direct linking to configuration files.
	c) File Permission misconfiguration, where sensitive files are unnecessarily readable by the application's process, potentially leading to their exposure.
	d) Insufficient input validation, allowing attackers to guess the filenames of the configuration files.

36.  Users of a web application frequently access it from shared computers in public libraries. Despite the application implementing secure session management with timeouts and logout functionality, subsequent users of the same terminal can sometimes still access the previous user's data by simply navigating back in the browser's history. According to the lecture, what access control vulnerability is being manifested here?
	a) Lack of multi-factor authentication, making it easier for unauthorized users to regain access.
	b) Insecure session ID generation based on client-side information.
	c) Failure to implement server-side checks on every request.
	d) Client-side Caching of web pages containing sensitive information, allowing unauthorized access by subsequent users of the same browser instance.

37.  To mitigate the vulnerability described in the previous question regarding shared terminals, the lecture suggests several mechanisms. Which of the following is a server-side directive that developers should implement to prevent client-side caching of sensitive web pages?
	a) Including HTTP Headers like `Cache-Control: no-store, no-cache, must-revalidate`.
	b) Setting short expiration times for session cookies.
	c) Utilizing HTTP Strict Transport Security (HSTS) headers.
	d) Implementing strong Content Security Policy (CSP) headers.

38.  An application implements Role-Based Access Control (RBAC). A user is assigned the "editor" role, which should only allow them to modify blog posts. However, due to a flaw in the authorization logic, this user can also delete other users' accounts. What is the most likely underlying issue in the RBAC implementation?
	a) There is insufficient documentation of roles and their associated permissions.
	b) An incorrect or overly permissive mapping of the "editor" role to system functions, violating the principle of least privilege.
	c) The session tokens used to maintain user roles are not being properly validated.
	d) The application is using Discretionary Access Control (DAC) instead of RBAC.

39.  Consider an API endpoint that allows users to retrieve their own profile information using a Bearer token for authentication. The request URL is `https://api.somesite.com/users/me`. However, the backend code inadvertently also processes requests to `https://api.somesite.com/users/{userId}` without properly verifying if the requested `userId` matches the user associated with the provided Bearer token. What type of access control vulnerability does this represent?
	a) Improper handling of HTTP verbs, potentially allowing unauthorized modification of user data through GET requests.
	b) Exploitation of Insecure IDs through direct manipulation of the `userId` path parameter.
	c) Failure to restrict URL access based on the authenticated user's identity, allowing access to resources belonging to other users.
	d) A vulnerability related to Client-side Caching of API responses containing sensitive user data.

40.  The lecture briefly mentions different Access Control Models. In the context of a highly secure military application where access to information is strictly controlled based on predefined security clearances (e.g., "Top Secret," "Secret," "Confidential") assigned to both users and data, which access control model would be the most appropriate?
	a) Discretionary Access Control (DAC), where data owners decide who has access.
	b) Role-Based Access Control (RBAC), where access is based on organizational roles.
	c) Attribute-Based Access Control (ABAC), where access is granted based on dynamic contextual attributes.
	d) Mandatory Access Control (MAC), where access is determined by system-wide security policies based on the sensitivity of information and the user's clearance level.

41. An e-commerce application allows users to add items to their shopping cart and proceed to checkout. During the checkout process, the application uses a cart ID in the URL (e.g., `http://somesite.com/checkout?cartId=XYZ`). An attacker discovers they can modify this `cartId` to view the contents and potentially complete the checkout of other users' carts. What is the underlying access control vulnerability?
	a) Insecure handling of resource identifiers (cart IDs) in URLs, allowing unauthorized access to other users' resources.
	b) Insecure session management, where session IDs are being confused.
	c) Lack of server-side validation of the items and quantities in the cart before processing the order.
	d) Failure to use HTTPS for the checkout process, exposing the `cartId`.

42. According to the lecture's reminder tips, what is a critical security practice regarding the use of third-party code or applications within your web environment from an access control perspective?
	a) Implement strong input validation on all data exchanged with third-party components.
	b) Ensure that all third-party libraries are regularly updated to their latest versions.
	c) Change or verify default configurations in third-party code or applications, as default settings might have insecure access controls.
	d) Isolate third-party applications within sandboxed environments.

43. The lecture advises against inadvertently becoming a proxy for services behind a firewall. How might a broken authorization vulnerability lead to an application acting as such a proxy?
	a) By allowing unauthorized users to directly access internal network resources through the compromised application.
	b) By permitting attackers to manipulate the application to make requests to internal systems that the attacker would not normally have access to.
	c) By enabling cross-site scripting (XSS) attacks that can then target internal systems.
	d) Through the exposure of firewall configuration details due to path traversal vulnerabilities.

44. In the context of Attribute-Based Access Control (ABAC), as described in the lecture, what is a key differentiator from Role-Based Access Control (RBAC)?
	a) Both ABAC and RBAC are primarily client-side access control mechanisms.
	b) ABAC makes access decisions based on contextual attributes associated with the user, the resource, and the environment, offering finer-grained control compared to RBAC's reliance on predefined roles.
	c) ABAC focuses solely on the identity of the user making the request.
	d) RBAC considers contextual attributes like time of day or location when making access decisions.

45. What is a significant risk associated with embedding database or other internal IDs directly within the application code, as cautioned in the lecture's reminder tips, from an access control standpoint?
	a) If the code is compromised or reverse-engineered, attackers could gain direct knowledge of internal identifiers, potentially aiding in the exploitation of other vulnerabilities or bypassing access controls.
	b) It makes the application harder to maintain and update.
	c) It can interfere with the application's ability to properly manage user sessions.
	d) It can lead to performance bottlenecks due to increased database lookups.

46. According to the lecture, why should web applications access database resources using an account with minimal privileges?
	a) To improve the overall performance of database queries.
	b) To simplify database administration tasks.
	c) To ensure compatibility with different database management systems.
	d) To limit the potential damage if the application is compromised through vulnerabilities like SQL injection; the attacker's access to the database will be restricted to the privileges granted to the application's database user.

