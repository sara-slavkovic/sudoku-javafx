# Sudoku - JavaFX Application

A Sudoku game application using JavaFX, built with a client-server architecture using socket communication and a SOAP web service.

## Technologies

- Java 8 (JDK 1.8.0_181 - Liberica Full JDK with JavaFX)
- JavaFX
- Socket communication (client-server)
- SOAP Web Service (WildFly 11)
- MySQL database
- XAMPP

## Project Structure
javafx_sudoku/

├── SudokuKlijent/    # JavaFX client application

├── SudokuServer/     # Socket server

└── SudokuWebServer/  # SOAP web service (WildFly)

## Running the Application

### Prerequisites
- JDK 1.8.0_181 (Liberica Full JDK)
- NetBeans IDE
- XAMPP (MySQL)
- WildFly 11

### Steps

1. **Database**
   - Start XAMPP and run MySQL
   - Create database named `sudoku`
   - Execute the SQL script to create tables

2. **Web Server**
   - Start WildFly 11 in NetBeans
   - Deploy `SudokuWebServer` project
   - Right-click `GenerickiKontrolerServer` → Generate SOAP over HTTP

3. **Socket Server**
   - Run `SudokuServer` project
   - Server listens on port 9000

4. **Client**
   - Run `SudokuKlijent` project

## Features

- User registration and login
- Start new game with difficulty selection (EASY, MEDIUM, HARD)
- Continue a saved game
- Local move validation
- Quit game with state saving
- Top 10 leaderboard per difficulty level
- User logout

## Architecture

The application uses a three-tier architecture:
- **Client** — JavaFX UI, communicates with server via sockets and web service
- **Socket Server** — handles game requests, communicates with database
- **Web Server** — handles user registration and leaderboard via SOAP web service

## Database

Three main tables:
- `korisnik` — stores user data
- `sudokutabla` — stores Sudoku puzzles with solutions
- `igra` — stores game sessions with progress
