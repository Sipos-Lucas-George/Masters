1. Authorization
2. Resources such as users, processes, files, and data
3. File Ownership
4. The ability to connect to a system or service
5. Restricted functions
6. Session lock after a period of inactivity
7. Insecure IDs
8. Attackers gaining access to areas and functions they should not
9. Insecure IDs
10. Access resources not associated with their account, including administrative functionalities
11. Failure to restrict URL access
12. Path Traversal
13. Path Traversal vulnerability
14. Attackers can access sensitive files stored locally on the server that should not be publicly accessible
15. Most files and directories should not be readable
16. Attackers can gain access to previously visited, inaccessible site locations and data
17. HTTP Headers like `Cache-Control: no-store, no-cache, must-revalidate`
18. Rule-based access controls (RBAC)
19. The identity of users and their group memberships
20. Sensitivity labels assigned to information and the user's operating sensitivity level
21. Role-Based Access Control (RBAC)
22. Contextual attributes such as time of day and location
23. Check authorization on every page of the application
24. Remove all demo/debug code
25. Change or verify defaults
26. A low-privilege account with only necessary permissions
27. To prevent unauthorized access to sensitive files
28. Force a “sufficiently random” session id
29. They are easily guessable and may not be unique
30. Verify the session and do not solely trust IP addresses due to potential changes
31. In application code
32. Insecure IDs that are predictable and not adequately validated against the current user's authorized scope.
33. Failure to restrict URL access based on user roles and permissions, allowing unauthorized access to sensitive functionalities.
34. Path Traversal, allowing the attacker to access arbitrary files and directories outside the web root, potentially including sensitive system files.
35. File Permission misconfiguration, where sensitive files are unnecessarily readable by the application's process, potentially leading to their exposure.
36. Client-side Caching of web pages containing sensitive information, allowing unauthorized access by subsequent users of the same browser instance.
37. Including HTTP Headers like `Cache-Control: no-store, no-cache, must-revalidate`.
38. An incorrect or overly permissive mapping of the "editor" role to system functions, violating the principle of least privilege.
39. Failure to restrict URL access based on the authenticated user's identity, allowing access to resources belonging to other users.
40. Mandatory Access Control (MAC), where access is determined by system-wide security policies based on the sensitivity of information and the user's clearance level.
41. Insecure handling of resource identifiers (cart IDs) in URLs, allowing unauthorized access to other users' resources.
42. Change or verify default configurations in third-party code or applications, as default settings might have insecure access controls.
43. By permitting attackers to manipulate the application to make requests to internal systems that the attacker would not normally have access to.
44. ABAC makes access decisions based on contextual attributes associated with the user, the resource, and the environment, offering finer-grained control compared to RBAC's reliance on predefined roles.
45. If the code is compromised or reverse-engineered, attackers could gain direct knowledge of internal identifiers, potentially aiding in the exploitation of other vulnerabilities or bypassing access controls.
46. To limit the potential damage if the application is compromised through vulnerabilities like SQL injection; the attacker's access to the database will be restricted to the privileges granted to the application's database user.