Here is an MCQ test based on the "Lecture 7 - Broken Authorization Access Control.pdf" resource:

1.  According to the lecture, what is another term that means the same thing as "access control"?
    a.  Authentication
    b.  Encryption
    c.  Authorization
    d.  Auditing

2.  The lecture states that access control is about mediating access to what based on a user-specific policy?
    a.  Networks only
    b.  Physical locations only
    c.  Resources such as users, processes, files, and data
    d.  Communication channels only

3.  Which of the following is listed in the lecture as a "meta-operation" that is often overlooked in access control?
    a.  Encryption
    b.  Authentication
    c.  File Ownership
    d.  Network segmentation

4.  According to the lecture, "network access" in the context of access control refers to:
    a.  The ability to physically touch a system.
    b.  The speed of internet connection.
    c.  The ability to connect to a system or service
    d.  The type of operating system used.

5.  Restricting transactions and configuration changes are examples of controlling:
    a.  Physical access.
    b.  Network access.
    c.  Restricted functions
    d.  Data storage.

6.  Which of the following is mentioned in the lecture as an example of access controls?
    a.  Frequent password changes
    b.  Complex password requirements
    c.  Session lock after a period of inactivity
    d.  Two-factor authentication

7.  The lecture lists several "Vulnerabilities" related to access control. Which of the following is included in that list?
    a.  Strong Encryption
    b.  Regular Security Audits
    c.  Insecure IDs
    d.  Principle of Least Privilege

8.  What is the potential impact of "Insecure IDs" as described in the lecture?
    a.  Data loss due to encryption errors.
    b.  Denial of service attacks.
    c.  Attackers gaining access to areas and functions they should not
    d.  Malware infection.

9.  The lecture provides an example where an attacker might change a 'uid' parameter in a URL. What type of vulnerability does this illustrate?
    a.  Path Traversal
    b.  File Permission issues
    c.  Insecure IDs
    d.  Client-side Caching

10. What does the vulnerability "Failure to restrict URL access" allow an attacker to do, according to the lecture?
    a.  Bypass authentication mechanisms.
    b.  Gain access to the application's database.
    c.  Access resources not associated with their account, including administrative functionalities
    d.  Modify files on the web server's file system.

11. The lecture uses the example of accessing `/admin_panel` without proper authorization to illustrate which vulnerability?
    a.  Insecure IDs
    b.  Path Traversal
    c.  Failure to restrict URL access
    d.  File Permission issues

12. What type of vulnerability does the lecture describe as allowing an attacker to access files and directories stored outside the web root folder by manipulating file references?
    a.  Insecure IDs
    b.  Failure to restrict URL access
    c.  File Permission issues
    d.  Path Traversal

13. The lecture provides an example URL `http://somesite.com/getMyPic.jsp?myPic=../../../../etc/passwd` to demonstrate:
    a.  Insecure handling of user sessions.
    b.  The impact of weak password policies.
    c.  Path Traversal vulnerability
    d.  A cross-site scripting attack.

14. According to the lecture, what is the risk associated with improper "File permissions" on a web server?
    a.  Users may not be able to access necessary files.
    b.  The application might not function correctly.
    c.  Attackers can access sensitive files stored locally on the server that should not be publicly accessible
    d.  Web pages might load slowly.

15. The lecture mentions that only specifically intended files for web users should be marked as readable by the application. How should other files and directories ideally be configured?
    a.  Readable by everyone.
    b.  Readable by the application and publicly.
    c.  Most files and directories should not be readable
    d.  All files should be executable.

16. What security issue arises when browsers cache web pages, especially on shared terminals, as described in the lecture?
    a.  Users may see outdated information.
    b.  The server's resources may be exhausted.
    c.  Attackers can gain access to previously visited, inaccessible site locations and data
    d.  The application's performance may degrade.

17. The lecture suggests using certain mechanisms to mitigate client-side caching issues. Which of the following is mentioned?
    a.  Encrypting all web traffic with HTTPS.
    b.  Using strong authentication protocols.
    c.  HTTP Headers like `Cache-Control: no-store, no-cache, must-revalidate`
    d.  Implementing server-side session management.

18. Which of the following is NOT listed in the lecture as an "Access Control Model"?
    a.  Discretionary access controls (DAC)
    b.  Mandatory access controls (MAC)
    c.  Role-based access controls (RBAC)
    d.  Rule-based access controls (RBAC)

19. What is the primary basis for restricting access in Discretionary Access Control (DAC), according to the lecture?
    a.  The sensitivity level of the information.
    b.  The roles played by users in the organization.
    c.  The identity of users and their group memberships
    d.  Contextual attributes like time of day and location.

20. Mandatory Access Control (MAC) primarily relies on what to control access to information?
    a.  User roles and permissions.
    b.  The user's need-to-know basis determined by the object owner.
    c.  Sensitivity labels assigned to information and the user's operating sensitivity level
    d.  Attributes associated with the user and the resource.

21. Which access control model is described in the lecture as being based on the roles played by users and groups within an organization?
    a.  Discretionary Access Control (DAC)
    b.  Mandatory Access Control (MAC)
    c.  Role-Based Access Control (RBAC)
    d.  Attribute-Based Access Control (ABAC)

22. According to the lecture, Attribute-Based Access Control (ABAC) makes access decisions based on:
    a.  Predefined roles assigned to users.
    b.  Sensitivity labels of the data.
    c.  The identity and group membership of the user.
    d.  Contextual attributes such as time of day and location

23. The lecture provides "Reminder tips" for access control. Which of the following is one of those tips?
    a.  Trust user-supplied URLs if they are properly encoded.
    b.  Actively proxy requests to services behind a firewall.
    c.  Check authorization on every page of the application
    d.  Embed database passwords directly in the application code for easy access.

24. What does the lecture advise regarding demo or debug code before going live with an application?
    a.  Keep it enabled for easy troubleshooting.
    b.  Document it thoroughly for future reference.
    c.  Remove all demo/debug code
    d.  Secure it with strong passwords.

25. According to the lecture's reminder tips, what should be done with default settings in third-party code or applications?
    a.  Assume they are secure and require no changes.
    b.  Only change them if a vulnerability is publicly known.
    c.  Change or verify defaults
    d.  Document the default settings without reviewing them.

26. What level of privileges should web servers and web applications ideally run with, according to the lecture's recommendations?
    a.  Highest privileges to ensure all functions work.
    b.  The same privileges as the database server.
    c.  A low-privilege account with only necessary permissions
    d.  Administrator or root privileges for ease of management.

27. The lecture advises limiting file permissions on web files. What is the primary reason for this recommendation?
    a.  To improve the performance of the web server.
    b.  To prevent unauthorized modification of web content.
    c.  To prevent unauthorized access to sensitive files
    d.  To simplify file management.

28. According to the lecture, how should session IDs be generated to prevent guessing?
    a.  Based solely on user input.
    b.  Using a predictable sequential formula.
    c.  Using timestamps as the primary component.
    d.  Force a “sufficiently random” session id

29. The lecture advises against using timestamps alone as a token. Why?
    a.  They are too long and cumbersome.
    b.  They are difficult to generate and verify.
    c.  They are easily guessable and may not be unique
    d.  They cannot be used for expiring tokens.

30. What does the lecture recommend regarding verifying user sessions and trusting IP addresses?
    a.  IP addresses are a reliable way to verify sessions for all users.
    b.  Only trust IP addresses for users with static IP addresses.
    c.  Verify the session and do not solely trust IP addresses due to potential changes
    d.  Embed IP addresses directly into the session token for security.

31. The lecture strongly advises against embedding sensitive information like database IDs or passwords where?
    a.  In configuration files.
    b.  In log files.
    c.  In application code
    d.  In database tables.

Here is a challenging multiple-choice question (MCQ) test based on the "Lecture 7 - Broken Authorization Access Control.pdf" resource:

1.  An application uses sequentially generated integer IDs to reference user accounts in URLs (e.g., `http://somesite.com/userprofile?id=123`). While some basic authorization checks are in place, an attacker discovers they can increment the `id` parameter to access other users' profiles. According to the lecture, what is the fundamental access control vulnerability being exploited here?
    a) Failure to implement Role-Based Access Control (RBAC).
    b) Vulnerability to Path Traversal attacks due to predictable parameters.
    c) Insecure IDs that are predictable and not adequately validated against the current user's authorized scope.
    d) Insufficient protection against Client-side Caching, leading to the exposure of cached profiles.

2.  A web application has an administrative panel located at `http://somesite.com/admin/dashboard`. The developers have implemented a check on the server-side to verify if a user has the "administrator" role before displaying the dashboard. However, a standard authenticated user discovers they can directly access this URL and view the administrative interface. What primary access control failure, as described in the lecture, has occurred?
    a) Insufficient implementation of Discretionary Access Control (DAC).
    b) Failure to restrict URL access based on user roles and permissions, allowing unauthorized access to sensitive functionalities.
    c) Lack of proper session termination after inactivity, leading to persistent admin sessions.
    d) Inadequate file permission settings on the server preventing the intended access checks from being executed.

3.  Consider a scenario where a web application allows users to view image files based on a filename passed in a URL parameter (e.g., `http://somesite.com/viewimage?file=image1.jpg`). An attacker manipulates this parameter with the value `../../../../etc/shadow`. If the application processes this request without proper validation, what type of access control vulnerability is being exploited, and what is the potential impact?
    a) Insecure IDs, potentially leading to the exposure of sensitive user identifiers.
    b) Failure to restrict URL access, granting access to unintended image resources.
    c) Path Traversal, allowing the attacker to access arbitrary files and directories outside the web root, potentially including sensitive system files.
    d) File Permission misconfiguration, where the `/etc/shadow` file is incorrectly marked as publicly readable.

4.  A web server is configured such that all files within its web root are readable by the application's process. However, some configuration files containing sensitive database credentials are also located within this directory, although not directly linked or intended for public access. According to the lecture, what is the access control vulnerability present here?
    a) Inadequate implementation of Mandatory Access Control (MAC).
    b) Failure to restrict URL access to prevent direct linking to configuration files.
    c) File Permission misconfiguration, where sensitive files are unnecessarily readable by the application's process, potentially leading to their exposure.
    d) Insufficient input validation, allowing attackers to guess the filenames of the configuration files.

5.  Users of a web application frequently access it from shared computers in public libraries. Despite the application implementing secure session management with timeouts and logout functionality, subsequent users of the same terminal can sometimes still access the previous user's data by simply navigating back in the browser's history. According to the lecture, what access control vulnerability is being manifested here?
    a) Insecure session ID generation based on client-side information.
    b) Failure to implement server-side checks on every request.
    c) Client-side Caching of web pages containing sensitive information, allowing unauthorized access by subsequent users of the same browser instance.
    d) Lack of multi-factor authentication, making it easier for unauthorized users to regain access.

6.  To mitigate the vulnerability described in the previous question regarding shared terminals, the lecture suggests several mechanisms. Which of the following is a server-side directive that developers should implement to prevent client-side caching of sensitive web pages?
    a) Implementing strong Content Security Policy (CSP) headers.
    b) Utilizing HTTP Strict Transport Security (HSTS) headers.
    c) Including HTTP Headers like `Cache-Control: no-store, no-cache, must-revalidate`.
    d) Setting short expiration times for session cookies.

7.  An application implements Role-Based Access Control (RBAC). A user is assigned the "editor" role, which should only allow them to modify blog posts. However, due to a flaw in the authorization logic, this user can also delete other users' accounts. What is the most likely underlying issue in the RBAC implementation?
    a) The application is using Discretionary Access Control (DAC) instead of RBAC.
    b) There is insufficient documentation of roles and their associated permissions.
    c) An incorrect or overly permissive mapping of the "editor" role to system functions, violating the principle of least privilege.
    d) The session tokens used to maintain user roles are not being properly validated.

8.  Consider an API endpoint that allows users to retrieve their own profile information using a Bearer token for authentication. The request URL is `https://api.somesite.com/users/me`. However, the backend code inadvertently also processes requests to `https://api.somesite.com/users/{userId}` without properly verifying if the requested `userId` matches the user associated with the provided Bearer token. What type of access control vulnerability does this represent?
    a) Exploitation of Insecure IDs through direct manipulation of the `userId` path parameter.
    b) Failure to restrict URL access based on the authenticated user's identity, allowing access to resources belonging to other users.
    c) A vulnerability related to Client-side Caching of API responses containing sensitive user data.
    d) Improper handling of HTTP verbs, potentially allowing unauthorized modification of user data through GET requests.

9.  The lecture briefly mentions different Access Control Models. In the context of a highly secure military application where access to information is strictly controlled based on predefined security clearances (e.g., "Top Secret," "Secret," "Confidential") assigned to both users and data, which access control model would be the most appropriate?
    a) Discretionary Access Control (DAC), where data owners decide who has access.
    b) Role-Based Access Control (RBAC), where access is based on organizational roles.
    c) Mandatory Access Control (MAC), where access is determined by system-wide security policies based on the sensitivity of information and the user's clearance level.
    d) Attribute-Based Access Control (ABAC), where access is granted based on dynamic contextual attributes.

10. An e-commerce application allows users to add items to their shopping cart and proceed to checkout. During the checkout process, the application uses a cart ID in the URL (e.g., `http://somesite.com/checkout?cartId=XYZ`). An attacker discovers they can modify this `cartId` to view the contents and potentially complete the checkout of other users' carts. What is the underlying access control vulnerability?
    a) Insecure session management, where session IDs are being confused.
    b) Insecure handling of resource identifiers (cart IDs) in URLs, allowing unauthorized access to other users' resources.
    c) Failure to use HTTPS for the checkout process, exposing the `cartId`.
    d) Lack of server-side validation of the items and quantities in the cart before processing the order.

11. According to the lecture's reminder tips, what is a critical security practice regarding the use of third-party code or applications within your web environment from an access control perspective?
    a) Ensure that all third-party libraries are regularly updated to their latest versions.
    b) Implement strong input validation on all data exchanged with third-party components.
    c) Change or verify default configurations in third-party code or applications, as default settings might have insecure access controls.
    d) Isolate third-party applications within sandboxed environments.

12. The lecture advises against inadvertently becoming a proxy for services behind a firewall. How might a broken authorization vulnerability lead to an application acting as such a proxy?
    a) By allowing unauthorized users to directly access internal network resources through the compromised application.
    b) By permitting attackers to manipulate the application to make requests to internal systems that the attacker would not normally have access to.
    c) Through the exposure of firewall configuration details due to path traversal vulnerabilities.
    d) By enabling cross-site scripting (XSS) attacks that can then target internal systems.

13. In the context of Attribute-Based Access Control (ABAC), as described in the lecture, what is a key differentiator from Role-Based Access Control (RBAC)?
    a) ABAC focuses solely on the identity of the user making the request.
    b) RBAC considers contextual attributes like time of day or location when making access decisions.
    c) ABAC makes access decisions based on contextual attributes associated with the user, the resource, and the environment, offering finer-grained control compared to RBAC's reliance on predefined roles.
    d) Both ABAC and RBAC are primarily client-side access control mechanisms.

14. What is a significant risk associated with embedding database or other internal IDs directly within the application code, as cautioned in the lecture's reminder tips, from an access control standpoint?
    a) It can lead to performance bottlenecks due to increased database lookups.
    b) It makes the application harder to maintain and update.
    c) If the code is compromised or reverse-engineered, attackers could gain direct knowledge of internal identifiers, potentially aiding in the exploitation of other vulnerabilities or bypassing access controls.
    d) It can interfere with the application's ability to properly manage user sessions.

15. According to the lecture, why should web applications access database resources using an account with minimal privileges?
    a) To improve the overall performance of database queries.
    b) To simplify database administration tasks.
    c) To limit the potential damage if the application is compromised through vulnerabilities like SQL injection; the attacker's access to the database will be restricted to the privileges granted to the application's database user.
    d) To ensure compatibility with different database management systems.