# MeetingCamp

![ic_launcher](https://github.com/user-attachments/assets/92131253-3f02-42eb-ad01-e21d6d62550c)


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Screenshots](#screenshots)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Permissions](#permissions)
- [Contributing](#contributing)
- [License](#license)

## Introduction

**MeetingCamp** is a robust Android application designed to facilitate seamless video conferencing and virtual meetings. Leveraging the power of **ZegoUIKit**, MeetingCamp offers users an intuitive interface to host and join conferences with ease. Whether you're organizing a team meeting, conducting webinars, or simply catching up with friends, MeetingCamp ensures a smooth and reliable communication experience.

## Features

- **Easy Conference Setup:** Quickly create and manage video conferences.
- **Real-Time Communication:** High-quality audio and video streaming powered by ZegoUIKit.
- **User-Friendly Interface:** Intuitive design for effortless navigation and usage.
- **Secure Connections:** Ensures privacy and security of all communications.
- **Permission Handling:** Manages necessary permissions seamlessly to enhance user experience.

## Screenshots

<!-- Replace the placeholder paths with actual screenshots of your app -->

<img src="https://github.com/user-attachments/assets/6529ecdc-3223-49a9-9e62-271a7e797173" alt="Screenshot_20241206_191333" width="300"/>

*Écran d'accueil avec l'option de démarrer une nouvelle conférence.*


<img src="https://github.com/user-attachments/assets/367b0138-8d00-4c7b-bdbb-5c828bb4a115" alt="Screenshot_20241206_191259" width="300"/>

*Active video conference interface.*


## Technologies Used

- **Language:** Kotlin
- **IDE:** Android Studio
- **Architecture:** MVVM (if applicable)
- **Libraries & SDKs:**
  - [ZegoUIKit](https://www.zegocloud.com/) - For video conferencing functionalities.
  - [AndroidX](https://developer.android.com/jetpack/androidx) - Core Android libraries.
  - [ConstraintLayout](https://developer.android.com/training/constraint-layout) - For responsive UI design.
- **Others:**
  - View Binding for efficient view management.
  - Runtime Permissions handling for enhanced security.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Android Studio:** Installed on your development machine. [Download Here](https://developer.android.com/studio)
- **Android Device or Emulator:** To run and test the application.
- **ZegoUIKit Credentials:** You need an `App ID` and `App Sign` from [ZegoCloud](https://www.zegocloud.com/) to enable video conferencing features.

## Installation

Follow these steps to set up **MeetingCamp** on your local machine:

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/MeetingCamp.git
   ```

2. **Open in Android Studio:**

   - Launch Android Studio.
   - Click on `Open an existing Android Studio project`.
   - Navigate to the cloned `MeetingCamp` directory and select it.

3. **Sync Gradle:**

   - Android Studio will prompt you to sync Gradle. Click on `Sync Now` to download all necessary dependencies.

## Configuration

To enable video conferencing functionalities, you need to configure **ZegoUIKit** with your credentials.

1. **Obtain ZegoUIKit Credentials:**

   - Sign up or log in to your [ZegoCloud](https://www.zegocloud.com/) account.
   - Navigate to the dashboard to retrieve your `App ID` and `App Sign`.

2. **Configure Credentials:**

   - Open `ConferenceActivity.kt`.
   - Locate the following lines:

     ```kotlin
     val appID: Long = 12345 // Replace with your actual App ID
     val appSign: String = "12345" // Replace with your actual App Sign
     ```

   - Replace the placeholders with your actual `App ID` and `App Sign`:

     ```kotlin
     val appID: Long = YOUR_ACTUAL_APP_ID
     val appSign: String = "YOUR_ACTUAL_APP_SIGN"
     ```

3. **Update Permissions (If Needed):**

   - Ensure that all necessary permissions are declared in the `AndroidManifest.xml`. This includes camera, microphone, and internet access.

## Usage

Once installed and configured, follow these steps to use **MeetingCamp**:

1. **Launch the App:**
   - Open **MeetingCamp** on your Android device or emulator.

2. **Grant Permissions:**
   - Upon first launch, the app will request access to your camera and microphone. Grant these permissions to enable video conferencing.

3. **Start a New Conference:**
   - On the home screen, tap the "Start Conference" button.
   - Enter the conference ID or let the app generate one automatically.
   - Invite participants by sharing the conference ID.

4. **Join an Existing Conference:**
   - If you've received a conference ID, enter it on the home screen to join the meeting.

5. **During the Conference:**
   - Utilize in-app controls to mute/unmute, enable/disable video, and end the conference.

## Permissions

**MeetingCamp** requires the following permissions to function correctly:

- **Internet Access:**
  - Allows the app to connect to the internet for real-time communication.

- **Camera:**
  - Enables video capture for video conferencing.

- **Record Audio:**
  - Facilitates audio capture during meetings.

These permissions are handled at runtime to ensure user privacy and security.

## Contributing

Contributions are welcome! If you'd like to contribute to **MeetingCamp**, please follow these guidelines:

1. **Fork the Repository:**
   - Click on the `Fork` button at the top right of the repository page.

2. **Create a Branch:**
   - Create a new branch for your feature or bugfix:

     ```bash
     git checkout -b feature/YourFeatureName
     ```

3. **Make Changes:**
   - Implement your feature or fix the bug.

4. **Commit Changes:**
   - Commit your changes with a descriptive message:

     ```bash
     git commit -m "Add feature X" 
     ```

5. **Push to Branch:**
   - Push your changes to your forked repository:

     ```bash
     git push origin feature/YourFeatureName
     ```

6. **Create a Pull Request:**
   - Navigate to the original repository and create a pull request detailing your changes.

## License

Distributed under the [MIT License](LICENSE). See `LICENSE` for more information.

---

*Thank you for using **MeetingCamp**! We hope it enhances your virtual meeting experiences.*

