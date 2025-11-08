1.  What is the fundamental principle behind an SQL Injection (SQLi) attack?
	a.  Exploiting vulnerabilities in the web server's operating system.
	b.  Manipulating input fields to inject malicious SQL code into backend database queries.
	c.  Overloading the database server with excessive connection requests.
	d.  Bypassing client-side JavaScript validation to submit invalid data.

2.  According to the lecture, what can be a consequence of a successful SQL Injection attack?
	a.  Circumventing access controls, reading sensitive data, modifying data, and executing administrative operations on the database.
	b.  Gaining unauthorized access to the user's local file system.
	c.  Launching denial-of-service attacks against the web server.
	d.  Deploying ransomware on the web server.

3.  The lecture references the OWASP Top 10. Where does SQL Injection consistently rank?
	a.  It has been removed from the list in recent years.
	b.  Consistently in the middle of the list.
	c.  Its ranking fluctuates significantly year to year.
	d.  Consistently towards the top of the list.

4.  Which of the following is an example of sensitive data that an attacker might be able to read via an SQL Injection vulnerability, as mentioned in the lecture?
	a.  The network topology of the organization.
	b.  Usernames, passwords, credit card numbers, and other personal information stored in the database.
	c.  The web server's CPU utilization statistics.
	d.  The server's current date and time.

5.  The lecture mentions a famous hack involving TalkTalk where a 17-year-old exploited an SQLi vulnerability. What was the attacker reportedly "just showing off"?
	a.  His IT skills to friends.
	b.  His knowledge of network security protocols.
	c.  His ability to crash the TalkTalk website.
	d.  His ability to bypass firewalls.

6.  When trying to detect potential SQL Injection points in an application, where should security professionals typically focus their attention, according to the lecture?
	a.  Client-side JavaScript code.
	b.  Application functionality that interacts directly with the backend database, such as authentication forms, search functions, and e-commerce features.
	c.  Static HTML pages.
	d.  The web server's error logs.

7.  What are the initial characters commonly used to test for basic SQL Injection vulnerabilities?
	a.  `<` and `>`.
	b.  `'` (single quote) and `;` (semicolon).
	c.  `"` (double quote) and `%`.
	d.  `\` and `/`.

8.  Why is a single quote (`'`) a useful character to test for SQL Injection?
	a.  It is used to perform arithmetic operations in SQL.
	b.  It is commonly used as a string terminator in SQL, and injecting it can cause errors if input is not properly handled.
	c.  It is used to denote comments in most SQL dialects.
	d.  It is used to execute stored procedures.

9.  According to the lecture, what is the first method mentioned for fingerprinting the backend Database Management System (DBMS) during SQL Injection testing?
	a.  Examining the HTTP headers for server identification.
	b.  Trying different SQL syntax specific to known DBMS.
	c.  Analyzing the time it takes for the server to respond to different queries.
	d.  Observing the specific error messages returned by the database.

10. In the context of SQL Injection, what is meant by a "Boolean True" exploit, as demonstrated in the Security Shepherd example?
	a.  An exploit that always returns a 'true' value regardless of the database contents.
	b.  An exploit that uses Boolean operators to directly extract data.
	c.  An exploit where the attacker injects a condition that always evaluates to true (`'1'='1'`), bypassing the original query's intended logic.
	d.  An exploit that manipulates Boolean data types within the database.

11. The lecture describes different classes of SQL Injection. Which class involves extracting data using the same channel that is used to inject the SQL code?
	a.  Time delay.
	b.  Out-of-band.
	c.  Inband.
	d.  Blind.

12. What is a characteristic of "Blind" SQL Injection?
	a.  Data is retrieved through a different channel, like an email.
	b.  The attacker can directly see the results of their injected queries in the application's output.
	c.  The attacker can execute operating system commands directly.
	d.  There is no actual transfer of data in the response, but the attacker infers information by observing the application's behavior.

13. Which SQL Injection technique involves using the `UNION` operator to combine a malicious query with the original application query?
	a.  Union Technique.
	b.  Time delay technique.
	c.  Boolean Technique.
	d.  Error based technique.

14. When using the `UNION` technique in SQL Injection, what is often necessary to avoid syntax errors when the number of columns in the original query is unknown?
	a.  Injecting comments (`--`) to ignore extra columns.
	b.  Using wildcard characters (`*`) to match any number of columns.
	c.  Adding an equal number of parameters/columns with compatible data types in the injected `SELECT` statement.
	d.  Using the `JOIN` operator instead of `UNION`.

15. In Blind SQL Injection scenarios where no direct output or errors are returned, which technique relies on observing the time taken for the server to respond to conditional queries?
	a.  Error based technique.
	b.  Union Technique.
	c.  Time delay technique.
	d.  Boolean Technique.

16. What is the primary goal of the "Boolean Technique" in Blind SQL Injection?
	a.  To induce database errors that reveal information.
	b.  To directly extract data character by character.
	c.  To verify whether certain conditions are true or false based on the server's response.
	d.  To delay the server's response to analyze performance.

17. Which SQL Injection technique forces the database to perform an "out-of-band" connection to a server controlled by the attacker to deliver the results?
	a.  Union Technique.
	b.  Out of band technique.
	c.  Error based technique.
	d.  Time delay technique.

18. According to the lecture, which of the following is considered the "de facto tool of choice" for detecting and exploiting SQL injection vulnerabilities?
	a.  OWASP ZAP.
	b.  Burp Suite Pro.
	c.  IBM Security AppScan Standard.
	d.  sqlmap.

19. Which of the following is a recommended SQL Injection mitigation strategy highlighted in the lecture?
	a.  Using Parameterized Queries (Prepared Statements).
	b.  Relying solely on input validation and sanitization.
	c.  Hiding detailed database error messages from users.
	d.  Escaping user-supplied input as the primary defense.

20. Why are Parameterized Queries (Prepared Statements) an effective defense against SQL Injection?
	a.  They are database-specific and thus harder for attackers to understand.
	b.  They treat user input as data rather than executable SQL code, by clearly separating the SQL structure from the parameters.
	c.  They prevent the execution of any SQL code injected by the user.
	d.  They automatically encrypt all data sent to the database.

21. The lecture mentions that Stored Procedures are not always safe from SQL injection. What makes them potentially vulnerable?
	a.  If they are executed with insufficient user privileges.
	b.  If the application does not handle the returned result sets correctly.
	c.  If they include dynamic SQL generation within their code.
	d.  If they are not properly indexed in the database.

22. When is "Escaping User Supplied Input" presented as an SQL Injection defense in the lecture?
	a.  As a last resort defense, often used on legacy applications where other methods are not feasible, but difficult to implement correctly.
	b.  As the preferred method when dealing with complex SQL queries.
	c.  As the primary and most recommended approach for all new applications.
	d.  As a simple and universally effective technique.

23. What is the purpose of whitelisting input validation as an SQLi defense?
	a.  To encrypt user input before it is used in database queries.
	b.  To automatically remove any potentially malicious characters from user input.
	c.  To limit the length of user input to prevent buffer overflows.
	d.  To ensure that user input conforms to a predefined set of allowed values, such as legal table and column names.

24. According to the lecture, what should developers avoid in error handling to mitigate potential information leakage during SQL Injection attempts?
	a.  Logging all database errors for debugging purposes.
	b.  Displaying generic error messages to the user.
	c.  Providing detailed error messages that reveal information about the database structure or query execution.
	d.  Suppressing all error messages to prevent user frustration.

25. What principle regarding database user accounts is recommended to minimize the impact of a successful SQL Injection attack?
	a.  Embedding database credentials directly in the application code for simplicity.
	b.  Enforcing the principle of least privilege by using database accounts with only the minimal necessary permissions.
	c.  Granting all application components full administrative privileges.
	d.  Using a single, shared database account for all application interactions.

26.  Which of the following scenarios best exemplifies a second-order SQL injection vulnerability (not explicitly mentioned but inferable from the lecture's discussion of stored data and later retrieval)?
	a) An attacker crafts a URL with a malicious SQL payload in a parameter, and the server executes unintended database operations when the user clicks the link.
	b) An attacker injects malicious SQL code into a search bar, and the results page immediately reflects an error or unauthorized data.
	c) An attacker uses a time-based blind SQL injection technique to extract data character by character by observing the server's response time.
	d) An attacker injects malicious SQL code into a user profile's "biography" field. This code is not immediately active but is later executed when an administrator views the user's profile through a different application function that retrieves and displays this stored data without proper sanitization.

27.  According to the lecture, the ability to execute Operating System Commands via SQL injection often depends on:
	a) The complexity and sophistication of the injected SQL query.
	b) The specific version of the web server software being used.
	c) Whether the web application uses parameterized queries or stored procedures for database interactions.
	d) The level of privileges the database management system (DBMS) has on the underlying operating system and the availability of specific DBMS functionalities (not all mentioned, but a crucial implication).

28.  When fingerprinting a backend database management system (DBMS) during SQL injection testing, the lecture mentions observing error messages. In a scenario where the application displays a generic or custom error message, which of the following techniques would be the most effective next step to identify the specific DBMS?
	a) Analyzing the HTTP response headers for clues about the server-side technology.
	b) Attempting various UNION ALL SELECT statements with a different number of columns.
	c) Injecting DBMS-specific syntax or functions known to cause distinct error behaviors or outputs (as hinted at with the string concatenation examples).
	d) Using automated SQL injection tools that rely solely on boolean-based techniques.

29.  The lecture describes various SQL injection techniques. Which of the following best differentiates the Boolean-based blind SQL injection technique from the Time-delay blind SQL injection technique?
	a) Boolean-based injection can only be used with SELECT statements, while Time-delay can be used with any SQL command.
	b) Boolean-based injection infers information by observing different application responses based on true/false conditions in the injected SQL, while Time-delay injection infers information by observing the time it takes for the server to respond to queries with induced delays based on true/false conditions.
	c) Time-delay injection is effective against all DBMS, whereas Boolean-based is DBMS-specific.
	d) Boolean-based relies on observing direct data output, while Time-delay depends on inducing server-side errors.

30.  Consider the SQL query: `SELECT Name FROM Products WHERE Category = 'gifts' AND Price > 50;`. An attacker attempts a SQL injection by manipulating the `Category` parameter. Which of the following injected payloads, if the application is vulnerable and doesn't properly sanitize input, is most likely to successfully use the Union Technique to retrieve data from a different table named `Users` with columns `Username` and `Password`? (Assume the `Name` column in `Products` is of a string type).
	a) `' gifts' UNION ALL SELECT Username, 'dummy' FROM Users --`
	b) `' gifts' UNION ALL SELECT Username, Password FROM Users --`
	c) `' gifts' UNION SELECT Username, Password FROM Users --`
	d) `' gifts' UNION ALL SELECT 'dummy', Username FROM Users --`

31.  The lecture highlights the use of `ORDER BY` clause in SQL injection to determine the number of columns in a `SELECT` statement when using the Union Technique. What is the underlying principle that makes this technique effective?
	a) The `ORDER BY` clause can be used to trigger database-specific error messages revealing the column count.
	b) If the number specified in `ORDER BY` exceeds the actual number of columns, the database will typically return an error, allowing the attacker to iteratively determine the correct count.
	c) The `ORDER BY` clause can be used to execute arbitrary SQL commands if input is not sanitized.
	d) The `ORDER BY` clause forces the database to output the column names, which the attacker can then analyze.

32.  According to the lecture, which of the following is a critical reason why stored procedures are not inherently immune to SQL injection vulnerabilities?
	a) Because the parameters passed to stored procedures are always treated as raw SQL code.
	b) Because if a stored procedure internally uses dynamic SQL generation by concatenating user-supplied input into SQL queries without proper sanitization or parameterization, it can still be vulnerable.
	c) Because attackers can directly modify the code of stored procedures stored in the database.
	d) Because stored procedures always execute with the highest level of database privileges.

33.  The lecture discusses various SQL injection mitigation techniques. Which of the following statements accurately describes the primary benefit of using Parameterized Queries (Prepared Statements) in preventing SQL injection?
	a) They hide the structure and content of SQL queries from potential attackers.
	b) They automatically encrypt all data exchanged between the web application and the database.
	c) They treat SQL code and user-supplied data as distinct, preventing the database from interpreting user input as executable SQL commands.
	d) They validate user input against a predefined whitelist of allowed characters and patterns.

34.  While the lecture advocates for Parameterized Queries, it also mentions escaping user-supplied input as a "last resort" defense. What is a significant drawback of relying solely on input escaping for SQL injection prevention?
	a) Modern development frameworks do not provide built-in functions for input escaping.
	b) Escaping can negatively impact database performance.
	c) Escaping only protects against certain types of SQL injection, such as Union-based attacks.
	d) It is database-specific, complex to implement correctly, and prone to errors or omissions that attackers can potentially exploit.

35. The lecture advises against providing detailed error messages from the database to the user. What is the primary security reason behind this recommendation in the context of SQL injection?
	a) Detailed error messages can confuse legitimate users.
	b) Detailed error messages can reveal sensitive information about the database structure, version, and syntax, which can aid attackers in crafting more effective SQL injection payloads.
	c) Detailed error messages can consume excessive server resources.
	d) Detailed error messages can slow down the application's response time.

36. In a Blind SQL Injection scenario where the application does not return any data or specific error messages, which of the following techniques would be the most suitable for an attacker to extract information from the database?
	a) Employing Boolean-based or Time-delay-based techniques to infer data based on the application's response or response time to true/false conditions in injected SQL.
	b) Using the Union Technique to append their own queries to the original one.
	c) Directly injecting `SELECT` statements and observing the output.
	d) Triggering database errors that might be logged server-side and then attempting to access those logs.

37. The lecture mentions SQLmap as a de facto automated tool for detecting and exploiting SQL injection vulnerabilities. What is a key advantage of using such tools compared to manual testing?
	a) Automated tools do not require any understanding of SQL or web application functionality.
	b) Automated tools can bypass all web application firewalls (WAFs) and intrusion detection systems (IDSs).
	c) Automated tools guarantee the discovery of all SQL injection vulnerabilities in an application.
	d) Automated tools can systematically test a large number of potential injection points and employ various techniques more efficiently than manual testing, saving time and effort.

38. Consider a web application with a user authentication form. An attacker attempts to bypass authentication using SQL injection in the username field. Which of the following injected payloads is a classic example of a tautology-based SQL injection aimed at always evaluating to true?
	a) `admin' SLEEP(10) --`
	b) `admin' OR 1=1 --`
	c) `admin' UNION SELECT null, Password FROM Users WHERE Username = 'admin' --`
	d) `admin'; DELETE FROM Users; --`

39. The lecture briefly mentions Out-of-band SQL injection. What is the defining characteristic of this type of attack?
	a) The attacker causes the database server to communicate directly with a server controlled by the attacker (e.g., via HTTP or DNS requests) to exfiltrate data.
	b) The attacker retrieves data through the same channel used for injection, but the data is encoded.
	c) The attacker uses error messages generated by the database to extract information.
	d) The attacker manipulates time-based functions within the SQL query to leak information.

40. The lecture emphasizes the importance of input validation as a complementary security measure alongside parameterized queries or stored procedures. Why is input validation still crucial even when using these safer database interaction methods?
	a) Input validation can help prevent unexpected data from being sent to the database, which can sometimes cause application errors or be misused even within the context of a parameterized query (e.g., providing an extremely long string that could cause buffer overflows in other parts of the application).
	b) Input validation is necessary to prevent other types of web application vulnerabilities, such as Cross-Site Scripting (XSS).
	c) Parameterized queries and stored procedures do not protect against all forms of malicious input.
	d) Input validation is required by most security compliance standards.

