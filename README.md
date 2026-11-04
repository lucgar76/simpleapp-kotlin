# SimpleApp - Kotlin Android Test Project

This project is a Kotlin Android application used to practice and demonstrate UI automated testing using **Espresso** and **JUnit4**.

---

## Prerequisites

Before running the tests, make sure you have the following set up:

- **Android Studio** (Ladybug or later recommended)
- **Android SDK** with API level 24 or higher installed
- A connected **physical device** or a running **Android emulator** (API 24+)
- **Java 11** configured in your Android Studio JDK settings

---

## Project Structure

```
app/src/
├── main/                        # App source code
├── test/                        # Unit tests (run on JVM)
│   └── ExampleUnitTest.kt
└── androidTest/                 # Instrumented tests (run on device/emulator)
    ├── LoginTests.kt
    ├── LoginTests2.kt
    ├── HomePageTests.kt
    ├── ScreenThreeTests.kt
    ├── RecyclerViewScreenTest.kt
    ├── DocumentUploadScreenTest.kt
    └── ExampleInstrumentedTest.kt
```

---

## Test Suites

### Instrumented Tests (`androidTest`)

These tests run directly on a connected Android device or emulator using the **AndroidJUnitRunner**.

| Test Class | Activity Under Test | What It Covers |
|---|---|---|
| `LoginTests` | `LoginActivity` | Successful login flow; empty username validation error |
| `LoginTests2` | `LoginActivity` | Placeholder for additional login scenarios |
| `HomePageTests` | `HomeActivity` | Welcome text, image visibility, and button clickability |
| `ScreenThreeTests` | `ScrollableActivity` | Carousel swipe gestures, scroll-to-button, navigation intent |
| `RecyclerViewScreenTest` | `RecyclerActivity` | RecyclerView scroll to last item, item click and detail display |
| `DocumentUploadScreenTest` | `DocumentUploadActivity` | Input field hint, text entry, and Google Maps intent launch |

### Unit Tests (`test`)

| Test Class | What It Covers |
|---|---|
| `ExampleUnitTest` | Basic JVM unit test example |

---

## Running Tests in Android Studio

### Run All Instrumented Tests

1. Connect a physical device via USB (with USB debugging enabled) **or** start an emulator from **Device Manager**.
2. In the **Project** panel, right-click on:
   ```
   app/src/androidTest/java/com/example/testapplication
   ```
3. Select **Run 'Tests in testapplication'**.
4. Results appear in the **Run** tab at the bottom of Android Studio.

### Run a Single Test Class

1. Open the desired test file (e.g., `LoginTests.kt`).
2. Click the green **play button** next to the class declaration, or right-click anywhere in the file and select **Run 'LoginTests'**.

### Run a Single Test Method

1. Open the test file.
2. Click the green **play button** next to the specific `@Test` function you want to run.

### Run Unit Tests

1. Right-click on `app/src/test/java/com/example/testapplication`.
2. Select **Run 'Tests in testapplication'**.  
   These run on the JVM — no device or emulator is needed.

---

## Running Tests via Command Line (Gradle)

Make sure you have a device or emulator connected and running before executing instrumented tests.

### Run all instrumented tests
```bash
./gradlew connectedAndroidTest
```

### Run a specific test class
```bash
./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.example.testapplication.LoginTests
```

### Run a specific test method
```bash
./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.example.testapplication.LoginTests#checkLoginSuccessful
```

### Run all unit tests (no device needed)
```bash
./gradlew test
```

---

## Test Credentials

The login tests use the following hardcoded credentials:

| Field | Value |
|---|---|
| Username | `Admin` |
| Password | `123456` |

---

## Test Results

After running instrumented tests via Gradle, HTML reports are generated at:

```
app/build/reports/androidTests/connected/index.html
```

After running unit tests:

```
app/build/reports/tests/testDebugUnitTest/index.html
```

Open these files in a browser for a detailed pass/fail breakdown.

---

## Dependencies

The following test libraries are used (defined in `app/build.gradle.kts`):

| Library | Purpose |
|---|---|
| `androidx.test.espresso:espresso-core` | UI interaction and view assertions |
| `androidx.test.espresso:espresso-contrib` | RecyclerView actions |
| `androidx.test.espresso:espresso-intents` | Intent verification |
| `androidx.test.ext:junit` | `ActivityScenarioRule`, `AndroidJUnit4` runner |
| `androidx.test:runner` | `AndroidJUnitRunner` test runner |
| `junit:junit` | JUnit4 unit test framework |
