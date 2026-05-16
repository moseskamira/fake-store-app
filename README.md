
# 🚀 Android LevelUp Project (MVVM + Jetpack Compose)

A modern Android application built with Jetpack Compose and MVVM architecture that displays products from the FakeStore Api.

---

## 📱 Overview

Android LevelUp Project is a native Android app built using modern Android development practices.

It demonstrates:
- MVVM architecture
- Jetpack Compose UI
- Clean separation of concerns
- API integration with Retrofit

The app allows one to:
- Browse products
- View product details

---

## ✨ Features

- Fetch products from API
- Display products using LazyColumn / LazyVerticalGrid
- Product detail screen
- MVVM architecture

---

## 🧠 Architecture (MVVM)

### 📦 Layers

### 1. Presentation Layer (UI)
Built using Jetpack Compose:
- Composable Screens
- ViewModels
- UI State (StateFlow)

---

### 2. Domain Layer
Contains business logic:
- UseCases (optional)
- Repository Interfaces
- Domain Models

---

### 3. Data Layer
Handles data sources:
- Retrofit API Service
- DTO Models
- Repository Implementation
- Mappers (DTO → Domain)

---

## 🔄 MVVM Flow

UI (Composable)
↓
ViewModel (StateFlow)
↓
UseCase (optional)
↓
Repository
↓
Remote Data Source (GitHub API)

---

## 🧩 Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Retrofit + OkHttp
- Coroutines + Flow
- Material 3
- Navigation Compose

---

## 📡 API Used

Products API:

https://fakestoreapi.com/

---

MVVM + Compose:
- Composable Screens
- ViewModel handles state
- LazyColumn / LazyGrid
- Declarative UI
- Reactive StateFlow updates

---

## 🚀 Future Improvements

- Fetch products
- View product details
- Handle navigation in Jetpack Compose

---

## 📌 Summary

This project demonstrates modern Android development using MVVM architecture and Jetpack Compose, focusing on scalability, clean architecture, and reactive UI design.