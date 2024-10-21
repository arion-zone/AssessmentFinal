# AssessmentFinal - Android Application

## Overview

The Final Assignment is a feature-rich Android application that implements a robust login system, a visually appealing dashboard displaying images and details, and a detailed view for selected items. This application leverages modern Android development practices, utilizing Retrofit for network operations, Hilt for dependency injection, and follows the MVVM architectural pattern. The target SDK is 34.

## Features

- Login Screen: Secure user authentication using username and password credentials.
- Dashboard: A visually appealing horizontal list of images with titles, dynamically fetched from a remote API.
- Detail View: In-depth information about an item displayed when selected from the dashboard.

## Architecture

This application is structured around the following principles:

- MVVM Pattern: Separates the application's logic into three interconnected layers: Model, View, and ViewModel.
- Dependency Injection: Utilizes Hilt for efficient management of dependencies, enhancing modularity and testability.
- Networking: Employs Retrofit for seamless API interactions, ensuring type-safe HTTP requests.

## Dependencies

This project relies on several key libraries:

- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - A dependency injection library designed for Android applications.
- [Gson](https://github.com/google/gson) - A library for JSON serialization and deserialization.

## Setup

### Prerequisites

- Android Studio installed on your machine.
- Basic knowledge of Android development.

### Installation Steps

1. Clone the Repository:
    ```bash
    git clone https://github.com/arion-zone/AssessmentFinal.git
    cd AssessmentFinal
    ```

2. Open the Project:
   - Launch Android Studio and open the cloned project.

3. Install Dependencies:
   - Sync the project with Gradle files to download all necessary dependencies.

4. Configure API:
   - Ensure the API base URL in the `NetworkModule` is set correctly according to your backend service.

## Usage

### Running the Application

1. Start an Android Device:
   - Connect a physical Android device or launch an emulator.

2. Run the Application:
   - Execute the application from Android Studio by clicking the run button.

### Logging In

- Input your username and password on the login screen and proceed to authenticate.

### Navigating the Dashboard

- Upon successful login, you'll be directed to the dashboard where you can view a list of available items.
- Click on an item to access its detailed view, displaying comprehensive information.

## API Endpoints

The application interacts with the following API endpoints:

- Login: 
  - `POST /sydney/auth` - Authenticates a user and returns a keypass.
  
- Dashboard: 
  - `GET /dashboard/art` - Retrieves a list of entities for display on the dashboard.

## Testing

### Unit Tests

Unit tests are implemented to validate the functionality of critical components, including:

- API Service: Validates API calls and ensures expected responses.
- ViewModel: Tests the logic and state management of the ViewModel components.

To run the unit tests, execute the following command in the terminal:

```bash
./gradlew test
