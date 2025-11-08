1. According to the lecture, what is the MOST significant security risk associated with using open Wi-Fi networks in environments like the hospitality industry?
	a. The inherent difficulty in mapping such networks using tools like Kismet and Netstumbler.
	b. The potential for unauthorized access to business resources and unsegmented systems like point-of-sale terminals and printers.
	c. The increased susceptibility to brute-force attacks targeting user credentials transmitted over the air.
	d. The reliance on captive portals which often employ weak encryption for user authentication.

2. A security consultant discovers a wireless network still utilizing WEP. According to the lecture, what makes WEP particularly vulnerable to modern attacks?
	a. Its use of AES encryption with a fixed initialization vector.
	b. Cryptographic weaknesses in the RC4 cipher used by WEP, allowing for passive or aggressive packet capture and key recovery.
	c. The fact that the shared key is unique to each connecting client, making it difficult to crack globally.
	d. The complex key negotiation process that relies on a four-way handshake, which can be intercepted and analyzed offline.

3. When performing a penetration test against a WPA-PSK secured network, what is the PRIMARY objective when capturing the four-way handshake?
	a. To directly extract the pre-shared key (PSK) from the handshake packets.
	b. To identify the MAC addresses of all connected clients and the access point for further targeted attacks.
	c. To obtain cryptographic values that can be used to verify the hash of a guessed passphrase offline.
	d. To inject malicious packets into the network using the captured handshake as authentication.

4. The lecture mentions that pre-generating hash tables for WPA-PSK cracking can be efficient but has a significant limitation. What is this primary constraint?
	a. Modern WPA implementations incorporate strong salting mechanisms, rendering pre-generated hash tables largely ineffective.
	b. The pre-generated hash table is specific to the Service Set Identifier (SSID) of the target network.
	c. The computational cost of generating very large hash tables that cover a wide range of possible passphrases.
	d. The need for specialized hardware, such as GPUs, to effectively utilize pre-generated hash tables for password cracking.

5. According to the lecture, what is the fundamental flaw that allowed for the rapid compromise of WPS in many routers?
	a. The transmission of the network password in plaintext after successful WPS authentication.
	b. The reliance on a complex, multi-stage authentication protocol that introduced several vulnerabilities.
	c. The use of an eight-digit PIN that could be efficiently guessed due to a design flaw revealing if the first half was correct.
	d. The inability of most routers to effectively lock down WPS after multiple failed PIN attempts.

6. In the context of WPA-Enterprise, what is the purpose of setting up a rogue access point as an attack vector?
	a. To overwhelm the legitimate access point with connection requests, leading to a denial-of-service.
	b. To trick users into connecting to the attacker's network, allowing for the capture of hashed credentials for offline brute-force attacks.
	c. To bypass the need for the four-way handshake and directly inject traffic into the legitimate network.
	d. To exploit vulnerabilities in the RADIUS server used for authentication.

7. The lecture advises users to "Review your saved Wi-Fi networks on your laptop and mobile phone" as a protective measure. Why is this recommended?
	a. To easily share secure network credentials with trusted contacts.
	b. To identify and remove records of previously connected open or untrusted networks that devices might automatically reconnect to.
	c. To free up storage space on the device by deleting outdated network profiles.
	d. To ensure that all saved networks are using the latest and most secure encryption protocols.

8. According to the lecture, what is the implication of missing the renegotiation of the Pairwise Master Key (PMK) in a WPA network when trying to decrypt captured traffic?
	a. The attacker will need to initiate a new four-way handshake capture to decrypt subsequent traffic.
	b. Only the MAC addresses of the communicating devices will be recoverable from the captured packets.
	c. The strength of the WPA encryption for the remaining traffic is significantly reduced.
	d. The captured network traffic after the renegotiation interval cannot be decrypted using the initial four-way handshake.

9. Which of the following tools mentioned in the lecture is specifically designed for displaying access points that support WPS and their locked status?
	a. Aircrack-ng.
	b. Wash.
	c. Reaver.
	d. Airodump-ng.

10. Considering the attack type involving a "Rogue access point", what makes open rogue access points in public places like airports or cafes particularly effective for attackers?
	a. Modern operating systems automatically prioritize connecting to open networks over password-protected ones.
	b. Open networks do not require passwords, simplifying the attacker's setup and reducing suspicion from users.
	c. They typically broadcast a stronger Wi-Fi signal than legitimate access points, automatically attracting client devices.
	d. Users are accustomed to connecting to open networks in these locations and may not suspect the malicious nature of the access point.

