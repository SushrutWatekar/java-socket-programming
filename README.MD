# Java Socket Programming

A hands-on project to learn low-level networking concepts in Java using TCP sockets.

This repository documents my journey of building socket-based client-server communication systems from scratch while understanding how networking works internally.

---

## Concepts Covered

- TCP Socket Communication
- ServerSocket vs Socket
- BufferedReader and PrintWriter
- Blocking I/O
- Persistent Connections
- Continuous Client-Server Communication

---

## Project Structure

```text
java-socket-programming/
│
├── src/
│   ├── level1_single_client_server/
│   └── level2_continuous_chat/
│
└── README.md
```
---

## Level 1 - Single Message Communication

### Features

- Basic TCP connection
- Single client and server
- One-time message transfer

---

## Level 2 - Continuous Chat

### Features

- Persistent TCP connection
- Continuous communication using loops
- Client and server exchange messages continuously

### Concepts Learned

- BufferedReader
- PrintWriter
- Stream buffering
- Blocking I/O

### Sample Output

#### Client

![Client Output](src/level2_continuous_chat/client-chat.jpg)

#### Server

![Server Output](src/level2_continuous_chat/server-chat.jpg)

---

## Tech Stack

- Java
- TCP Sockets
- Java I/O Streams
- IntelliJ IDEA
- Git & GitHub