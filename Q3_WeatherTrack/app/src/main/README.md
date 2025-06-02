# 🌦️ WeatherTrack

**WeatherTrack** is a simple Android application built using **Java** and **MVVM architecture**. It helps users track and visualize weather data in their city, with automatic background syncing every 6 hours.

---

## 🚀 Features

- 🔄 **Fetch weather data** from a mock API or static JSON
- 💾 Save data locally using **Room Database**
- 🔁 **Auto background sync** using WorkManager (every 6 hours)
- 📊 View **7-day temperature trends** in a scrollable list
- 🔎 Click a day to see detailed weather info
- 🌐 Manual refresh for live updates
- 🛠️ Robust **error handling** for no internet, API errors, and database issues

---

## 🏗️ Architecture

The app follows a clean MVVM (Model-View-ViewModel) architecture:

---

## 💾 Technologies Used

- Java
- Android Room
- Retrofit (or mock static JSON)
- WorkManager
- LiveData, ViewModel
- RecyclerView
- MVVM Architecture

---

## ⚙️ Setup Instructions

### Prerequisites

- Java JDK 8+
- Android SDK
- ADB (Android Debug Bridge)
- Android Emulator or USB-connected device

🔄 Background Sync Logic
Uses WorkManager to fetch and store weather data every 6 hours

Scheduled via ScheduleSync.java

Sync logic handled in SyncWorker.java

📁 API Sample
If you're using a static JSON file as a fake API:
{
"date": "2025-06-02",
"temperature": 30,
"humidity": 60,
"condition": "Cloudy"
}
