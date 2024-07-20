# EDDemo

## Overview

The **EDDemo** is a web application built with Angular for the frontend and Spring Boot for the backend. This application allows users to view, edit, and manage user details, including personal information and addresses.

## Technologies Used

- **Frontend**: Angular, TypeScript, HTML, CSS
- **Backend**: Spring Boot, Java, JPA, Hibernate
- **Database**: MYSQL
- **Libraries**: Angular Forms, Angular Router, etc.

## Prerequisites

Before you start, ensure you have the following installed on your machine:

- **Node.js** and **npm** (Node Package Manager)
- **Angular CLI**: Install via npm with `npm install -g @angular/cli`
- **Java** Development Kit (JDK)
- **Maven** (if using Maven for backend build)
- **Spring Boot** dependencies (if setting up the backend)

## Installation

### Frontend

1. Clone the repository:
    ```bash
    git clone https://github.com/HakuTheGod/EDDemo.git
    ```
2. Navigate to the project directory:
    ```bash
    cd EDDemo/angular-frontend
    ```
3. Install dependencies:
    ```bash
    npm install
    ```

### Backend

1. Navigate to the backend directory:
    ```bash
    cd EDDemo/EDDemo_code
    ```
2. Build and run the Spring Boot application. If using Maven:
    ```bash
    mvn spring-boot:run
    ```

## Running the Application

### Frontend

1. Start the Angular development server:
    ```bash
    ng serve
    ```
2. Open your browser and navigate to `http://localhost:4200`.

### Backend

1. Ensure the Spring Boot application is running. By default, it will run on `http://localhost:8080`.

## API Endpoints

- **GET /api/users**: Retrieve all users
- **GET /api/user/{id}**: Retrieve a specific user by ID
- **PUT /api/user/{id}**: Update user details by ID
- **POST /api/user**: Create a new user
- **DELETE /api/user/{id}**: Delete a user by ID

## Usage

1. **View User Details**: Click on a user to see their details.
2. **Edit User Information**: Click the edit icon next to the field you want to modify.
3. **Save Changes**: Click the Save button to apply your edits.

## Development

To contribute to the project:

1. Fork the repository and clone it to your local machine.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with descriptive messages.
4. Push your changes to your fork and create a pull request.

