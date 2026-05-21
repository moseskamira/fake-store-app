# 🚀 Android LevelUp Project (MVVM + Jetpack Compose + Room DB)

A modern Android application built using Jetpack Compose, MVVM Architecture, Retrofit, and Room Database, powered by the FakeStore API.

---

# 📱 Overview

Android LevelUp Project is a production-style Android application demonstrating modern Android development practices using Clean Architecture principles and reactive UI patterns.

The project showcases:
- MVVM Architecture
- Jetpack Compose UI
- Room Database Offline Storage
- Retrofit API Integration
- Repository Pattern
- DTO → Domain Mapping
- Local & Remote Data Sources
- Coroutines + Flow
- State Management

The application integrates multiple FakeStore API features including:
- Products
- Users
- Categories
- Authentication
- Cart functionality

---

# ✨ Features

## 🛍 Products
- Fetch products from API
- Display products in LazyColumn / LazyVerticalGrid
- Product detail screen
- Category filtering

## 👤 Users
- Fetch users from API
- Store users locally using Room Database
- Offline-first data handling

## 🔐 Authentication
- User login integration
- Session persistence

## 🛒 Cart
- Fetch cart data
- Display cart items

## 💾 Offline Support
- Room Database caching
- Local-first architecture approach
- Persistent local storage

---

# 🧠 Architecture (MVVM)

## 📦 Layers

### 1. Presentation Layer (UI)
Built using Jetpack Compose:
- Composable Screens
- ViewModels
- UI State Management
- Navigation Compose

---

### 2. Domain Layer
Contains business logic:
- Domain Models
- Repository Interfaces
- Use Cases (optional)

---

### 3. Data Layer
Handles all data operations:
- Retrofit API Services
- Room Database
- DTO Models
- Entity Models
- Repository Implementations
- Mappers (DTO ↔ Domain ↔ Entity)

---

# 🔄 Application Flow

UI (Compose)
↓
ViewModel
↓
Repository
↓
Local Database (Room) / Remote API (Retrofit)

The app intelligently decides whether to use cached local data or fetch fresh remote data.

---

# 🗄 Room Database

The project uses Room Database for:
- Offline caching
- Persistent local storage
- Faster app performance
- Reduced unnecessary network requests

Implemented using:
- Entities
- DAO Interfaces
- Room Database
- TypeConverters
- LiveData / Flow support

---

# 🌐 Networking

API communication handled using:
- Retrofit
- OkHttp
- Gson Converter

Features include:
- REST API Calls
- JSON Serialization
- Logging Interceptors
- Error Handling

---

# 🧩 Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Room Database
- Retrofit
- OkHttp
- Coroutines
- Flow
- LiveData
- Material 3
- Navigation Compose
- Coil Image Loading
- KSP (Room Compiler)

---

# 📡 API Used

FakeStore API:

https://fakestoreapi.com/

Endpoints used include:
- Products
- Users
- Categories
- Carts
- Authentication

---

# 📂 Project Highlights

- Clean Architecture structure
- DTO → Domain → Entity mapping
- Repository Pattern
- Offline-first architecture
- Reactive UI updates
- Scalable codebase structure
- Production-ready Android practices

---

# 🚀 Future Improvements

- Pagination
- Search functionality
- Dependency Injection (Hilt)
- Unit Testing
- Dark Mode
- Favorites/Wishlist
- Enhanced caching strategy

---

# 🔐 Login Credentials

- Username: mor_2314
- Password: 83r5^_

---

# 📌 Summary

This project demonstrates modern Android development using Jetpack Compose, MVVM Architecture, Retrofit, and Room Database while applying clean architecture principles, scalable project structure, reactive state management, and offline-first data handling strategies.