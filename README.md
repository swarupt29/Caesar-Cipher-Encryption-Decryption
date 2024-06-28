# Caesar Cipher Encryption and Decryption using Spring Boot

## Overview

This Spring Boot application provides RESTful APIs for encrypting and decrypting messages using the Caesar cipher technique.

---

## Endpoints

### Encryption

- **Endpoint**: `/encrypt`
- **Method**: GET
- **Parameters**:
  - `text`: The plaintext message to be encrypted.
  - `shift`: The integer shift value for encryption.
- **Example**: `http://localhost:8080/encrypt?text=hello&shift=3`
- **Response**: Encrypted message based on the Caesar cipher.

### Decryption

- **Endpoint**: `/decrypt`
- **Method**: GET
- **Parameters**:
  - `text`: The encrypted message to be decrypted.
  - `shift`: The integer shift value for decryption.
- **Example**: `http://localhost:8080/decrypt?text=khoor&shift=3`
- **Response**: Decrypted message based on the Caesar cipher.

---

## Implementation Details

The encryption and decryption functionalities are implemented in the `CaesarCipherController` class using Spring Boot's `@RestController` and `@GetMapping` annotations.

### Caesar Cipher Logic

The `caesarCipher` method performs the encryption and decryption based on the provided shift value. It handles:
- Shifting letters (`a-z` and `A-Z`) based on their ASCII values.
- Shifting digits (`0-9`) within their range.

---

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) installed.
- Maven for building the project.

### Clone and Build

1. Clone the repository:
   ```bash
   git clone https://github.com/your/repository.git

2. Build the Application:
   ```bash
   cd caesar-cipher-app
   mvn clean install
   Run the Application:

3. Run the Application:

   Use any ide to run the application.
   Open any browser and visit 
   ```bash
   https://localhost:8080 

### Usage

https://github.com/swarupt29/Caesar-Cipher-Encryption-Decryption/assets/118194258/082c5d29-412e-4b41-8828-4463d63ff351

### Notes
Ensure proper input validation and error handling for production use.
This application uses Spring Boot's default embedded Tomcat server for deployment.

