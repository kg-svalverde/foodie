# Konrad Internship 2026 - KMP Project

This is a **Kotlin Multiplatform (KMP)** project targeting **Android** and **iOS**, utilizing
Compose Multiplatform for the UI.

## Project Structure

Before contributing, familiarize yourself with the core package structure in `commonMain`:

```text
├── composeApp
│   └── src/commonMain/kotlin/com/konrad/intership12026
│       ├── db            # Local database & storage
│       ├── di            # Dependency Injection modules
│       ├── feature       # UI logic (View, Layout, ViewModel)
│       └── navigation    # Navigation graphs
├── network
│   └── src/commonMain/kotlin/com/konrad/network
│       ├── di            # Dependency Injection modules
│       ├── model         # Data models
│       ├── service       # API definitions
│       └── repository    # Data fetching logic

```

---

## First Time Configuration

Before running the project for the first time, ensure the network layer is configured correctly:

1. **Android Network Security:**
   Update the `network_security_config.xml` to allow traffic to your base
   URL. [androidApp/.../network_security_config.xml](/androidApp/src/main/res/xml/network_security_config.xml)

2. **Ktor Client Setup:**
   Configure the base URL inside the Ktor client
   module. [network/.../NetworkModule.kt](/network/src/commonMain/kotlin/com/konrad/network/di/module/NetworkModule.kt)

---

## How to Add New Features

Follow this workflow to implement a new feature (e.g., "Profile").

### 1. UI Layer (Compose App)

* **Create Package:** Add a new package in `feature`.
  * Path: [composeApp/.../feature](/composeApp/src/commonMain/kotlin/com/konrad/intership12026/feature)

  * *Reference:* See
    the [homePage](/composeApp/src/commonMain/kotlin/com/konrad/intership12026/feature/homepage)
    package for structure.


* **Implement Components:** Create the `View`, `Layout`, and `ViewModel` within your new package.

### 2. Navigation

* **Register Destination:** Add your feature to the navigation graph.
  * Path: [composeApp/.../navigation/graph](/composeApp/src/commonMain/kotlin/com/konrad/intership12026/navigation/graph)


* **New Graph:** If your feature requires a nested graph, create a new one following the pattern in:
  * [HomePageGraph.kt](/composeApp/src/commonMain/kotlin/com/konrad/intership12026/navigation/graph/HomePageGraph.kt)

### 3. Data Layer (Network Module)

* **Abstraction**: Always separate Interfaces and Implementations.
    * Define the contract in an `interface`.
    * Write the logic in a concrete implementation class.

*  **Model**: Add new data model

* **Service:** Create a new network service definition.
    * Path: [network/.../service](/network/src/commonMain/kotlin/com/konrad/network/service)
      *Reference:* [SampleService.kt](/network/src/commonMain/kotlin/com/konrad/network/service/SampleService.kt)

* **Repository:** Create a repository to consume the service.
  * Path: [network/.../repository](/network/src/commonMain/kotlin/com/konrad/network/repository)

### 4. Dependency Injection

* **Inject Repository:** Add the new repository as a constructor parameter in your ViewModel.
* **Koin Annotations:** **Crucial:** Ensure you add the correct Koin annotations (e.g.,
  `@Single`, `@Factory`, `@KoinViewModel`) to your classes so the DI graph can resolve them.

### 5. Local Storage (Database)

* **Create Entity & DAO:** Define your data entity and its Data Access Object (DAO) inside their
  corresponding packages inside the `db`
  package.
  * Path: [composeApp/.../db](/composeApp/src/commonMain/kotlin/com/konrad/intership12026/db)

* **Register in Database:** Add your new entity and DAO to the `AppDatabase` configuration.
  * Path: [AppDatabase.kt](/composeApp/src/commonMain/kotlin/com/konrad/intership12026/db/AppDatabase.kt)

* **Usage:** Inject and use the DAO in your Repositories as needed to persist or retrieve local
  data.

---

## Best Practices & Guidelines

* **Dependency Injection:** Double-check that all new components are annotated for Koin.
* **Clean Code:**
  * Remove all unused imports before pushing.
* **Auto-format your code:**
  * `Option` + `Command` + `L`

---