# BrainRush 🧠

> A production-ready Android puzzle game built with **Kotlin + Jetpack Compose + Material Design 3**.

---

## Quick Start

### Prerequisites

| Tool              | Version      |
|-------------------|-------------|
| Android Studio    | Hedgehog+   |
| JDK               | 17          |
| Kotlin            | 2.0.21      |
| Gradle            | 8.x (wrapper included) |
| Min SDK           | 24          |
| Target SDK        | 35          |

### Setup

1. **Clone / open** the project in Android Studio.
2. **Replace `app/google-services.json`** with your real Firebase project's file from the [Firebase Console](https://console.firebase.google.com).
3. **Replace AdMob IDs** in `core/constants/AppConstants.kt` with your production unit IDs.
4. **Sync Gradle** (`File → Sync Project with Gradle Files`).
5. **Run** on device or emulator (`▶ Run`).

---

## Architecture

```
MVVM + Clean Architecture
 ├── presentation/   Compose screens, ViewModels, navigation
 ├── domain/         Models, repository contracts, use cases
 └── data/           Room (offline-first), DataStore, Firebase
```

### Tech Stack

| Layer        | Technology |
|-------------|------------|
| UI          | Jetpack Compose + Material Design 3 |
| Navigation  | Navigation Compose |
| DI          | Hilt |
| Async       | Kotlin Coroutines + Flow |
| Database    | Room (offline-first) |
| Preferences | DataStore |
| Auth        | Firebase Authentication |
| Cloud DB    | Cloud Firestore |
| Remote Config | Firebase Remote Config |
| Crash       | Firebase Crashlytics |
| Analytics   | Firebase Analytics |
| Push        | Firebase Cloud Messaging |
| Ads         | Google AdMob (Banner, Native, Rewarded, Interstitial) |
| Images      | Coil |
| Animations  | Lottie + Compose Animation APIs |
| Security    | ProGuard/R8, SSL pinning, root detection |

---

## Project Structure

```
app/src/main/java/com/aaryo/brainrush/
 ├── core/
 │   ├── ads/            AdMob controller
 │   ├── analytics/      Firebase Analytics tracker
 │   ├── common/         Result<T>, UiEvent
 │   ├── constants/      AppConstants, FirebaseConstants
 │   ├── di/             Hilt modules
 │   ├── extensions/     Kotlin extensions
 │   ├── network/        NetworkMonitor (Flow)
 │   ├── security/       RootDetector, SecurityPolicy
 │   ├── theme/          Color, Type, Theme
 │   └── utils/          DateUtils, NetworkUtils
 ├── data/
 │   ├── local/
 │   │   ├── room/       Entities, DAO, Database
 │   │   └── preferences/ DataStore wrapper
 │   ├── remote/firebase/ Auth, Firestore, RemoteConfig
 │   ├── mapper/         Entity ↔ Domain mappers
 │   └── repository/     Offline-first implementations
 ├── domain/
 │   ├── model/          Player, Level, Achievement, Mission, …
 │   ├── repository/     Interfaces
 │   └── usecase/        Game, Auth, Preferences use cases
 ├── notification/       FCM messaging service
 ├── presentation/
 │   ├── components/     Reusable Compose components
 │   ├── navigation/     Route sealed class + NavHost
 │   ├── screens/        One folder per screen
 │   └── viewmodel/      One ViewModel per feature
 └── worker/             WorkManager – daily reward reminder
```

---

## Game Features

- **1 000+ level support** – modular puzzle engine
- **8 puzzle types** – Block, TileMatch, ColorConnect, Number, Memory, Sliding, Maze, Pattern
- **Offline-first** – Room is the source of truth; Firestore sync when online
- **Player profile** – XP, level, coins, gems, energy, avatar
- **Daily challenges** & **daily/weekly/monthly missions**
- **Daily reward** system with streak tracking
- **Achievements** – 5 seed achievements, extensible
- **Leaderboard** – cached locally, synced from Firestore
- **Shop** – power-ups, themes, avatars
- **AdMob integration** – banner, interstitial, rewarded, native
- **Firebase Remote Config** – feature flags, maintenance mode, force-update
- **Dark mode** + Material You dynamic colour
- **WorkManager** – scheduled daily reward notification

---

## Adding a New Puzzle Type

1. Add the variant to `PuzzleType` enum in `domain/model/Models.kt`.
2. Create a new Compose composable (e.g. `presentation/screens/game/puzzles/BlockPuzzle.kt`).
3. In `GameScreen`, switch on `level.type` and render the correct composable.
4. No changes needed in the database, repository, or navigation layers.

---

## Firebase Setup

1. Create a project at [console.firebase.google.com](https://console.firebase.google.com).
2. Add an Android app with package `com.aaryo.brainrush`.
3. Download `google-services.json` → place in `app/`.
4. Enable **Email/Password** and **Anonymous** sign-in methods.
5. Create a **Firestore** database (start in test mode, then lock down rules).
6. Set up **Remote Config** keys (see `FirebaseConstants.kt`).

---

## AdMob Setup

Replace the placeholder IDs in `AppConstants.kt`:

```kotlin
const val ADMOB_BANNER_ID       = "ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX"
const val ADMOB_INTERSTITIAL_ID = "ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX"
const val ADMOB_REWARDED_ID     = "ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX"
const val ADMOB_NATIVE_ID       = "ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX"
```

And update the `admobAppId` placeholder in `app/build.gradle.kts`.

---

## Testing

```bash
# Unit tests
./gradlew :app:test

# Instrumentation tests
./gradlew :app:connectedAndroidTest
```

---

## Build

```bash
# Debug APK
./gradlew :app:assembleDebug

# Release APK (requires signing config)
./gradlew :app:assembleRelease
```

---

## License

MIT – see LICENSE file.
