# Event Board App

Welcome to the **Event Board App** repository!

## Overview
The Event Board App is a client-server application that facilitates distributed event sharing. The application is built in Java and consists of a server module for managing connections and a client module for sending and retrieving events.

## Features
- Client-server communication over sockets.
- Fetching event data from external sources.
- Multi-threaded server handling multiple clients.

## Getting Started
### Server Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/JordanQwerty/EventBoardApp.git
    ```
2. Navigate to the server folder:
    ```bash
    cd EventBoardApp/22113100_JordanCarthy_server
    ```
3. Run the server:
    ```bash
    java -cp . com.mycompany._jordancarthy_server.ServerApp
    ```

### Client Setup
1. Navigate to the client folder:
    ```bash
    cd EventBoardApp/22113100_JordanCarthy_client
    ```
2. Run the client:
    ```bash
    java -cp . com.mycompany._jordancarthy_client.ClientApp
    ```

## Future Improvements
- Add logging for better debugging.
- Handle large event files asynchronously.
- Improve code modularity and introduce REST communication.

Feel free to explore the repository and contribute!

**Maintainer:** [JordanQwerty](https://github.com/JordanQwerty)