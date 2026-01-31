# Restaurant App (Android / Java)

A native Android restaurant app built with Java and Android Studio–style structure. It includes menu browsing, cart, checkout with **delivery or pickup**, **address** selection, and **feedback/comments**.

## Features

- **Home** – Quick access to Menu, Cart, and Feedback
- **Browse Menu** – List of dishes with prices; add items to cart
- **My Cart** – View items, quantities, total; remove items; go to Checkout
- **Checkout**
  - **Delivery option**: Choose **Delivery** or **Pickup**
  - **Address**: For delivery, select or add an address (street, city, ZIP, phone)
  - Place order (clears cart and returns to home)
- **Feedback & Comments** – Submit a star rating and comment; view recent feedback

## Project Structure

```
RestaurantApp/
├── app/
│   ├── build.gradle
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/restaurant/app/
│       │   ├── MainActivity.java
│       │   ├── MenuActivity.java
│       │   ├── CartActivity.java
│       │   ├── CheckoutActivity.java
│       │   ├── FeedbackActivity.java
│       │   ├── AddressActivity.java
│       │   ├── CartManager.java
│       │   ├── DataStore.java
│       │   ├── adapters/
│       │   │   ├── MenuAdapter.java
│       │   │   ├── CartAdapter.java
│       │   │   └── FeedbackAdapter.java
│       │   └── models/
│       │       ├── MenuItem.java
│       │       ├── CartItem.java
│       │       ├── Address.java
│       │       └── FeedbackItem.java
│       └── res/
│           ├── layout/
│           ├── values/
│           └── drawable/
├── build.gradle
├── settings.gradle
└── gradle.properties
```

## How to Open and Run

1. **Android Studio**
   - File → Open → select the `RestaurantApp` folder.
   - Wait for Gradle sync.
   - Run on an emulator or device (Run ▶ or Shift+F10).

2. **Command line**
   - From project root: `./gradlew assembleDebug` (or `gradlew.bat assembleDebug` on Windows).
   - Install the APK from `app/build/outputs/apk/debug/`.

## Requirements

- **minSdk**: 24  
- **targetSdk**: 34  
- **Java**: 8  
- AndroidX and Material Components are used for UI.

## Data (Demo)

- **Menu**: Fixed list of sample dishes (e.g. pizzas, salads, drinks) from `DataStore.getDefaultMenu()`.
- **Cart**: In-memory via `CartManager` singleton.
- **Addresses & feedback**: In-memory via `DataStore` (addresses and feedback list). No backend or database; data is lost when the app is killed.

You can extend the app by persisting cart/addresses/feedback (e.g. Room, SharedPreferences) or connecting to a backend API.
