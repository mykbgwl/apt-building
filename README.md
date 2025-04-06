# Apartment Building System

## 📌 Project Overview
This project is a **Apartment Building System** that allows users to:
- View buildings and their details (temperature, total rooms, etc.).
- Edit the requested temperature for a specific building.
- Navigate to apartments within a building.

The system is built using **React (Next.js) for the frontend** and interacts with a backend API for data retrieval and updates.

---

## 🚀 Setup Instructions

### 🔧 Prerequisites
Ensure you have the following installed:
- **Node.js** (v16 or later)
- **npm** or **yarn**

### 📥 Installation
```sh
# Clone the repository
git clone https://github.com/mykbgwl/apt-building.git
cd apt-building

# Install dependencies
npm install  # or yarn install
```

### ▶ Running the Application
```sh
npm run dev  # or yarn dev
```
The application will be available at `http://localhost:3000`.

---

## 📡 API Endpoints
This project interacts with the following backend endpoints:

### 🏢 Buildings API
- **GET** `/building/` - Fetch all buildings.
- **POST** `/building/:id/temperature` - Update the temperature of a building.

---

## 📂 Code Structure
```
📂 components
   ├── 📄 BuildingCard.js      # Renders individual building cards
   ├── 📄 BuildingDialog.js    # Popup to edit building temperature
   ├── 📄 ApartmentCard.js     # Renders individual apartment cards
   ├── 📄 RoomDialog.js        # Popup to edit room temperature
📂 apartments
   ├── 📄 page.js             # Main entry point
📂 building
   ├── 📄 page.js             # Main entry point
📂 styles
   ├── 📄 globals.css          # Global styles
```

---

## 🔍 Assumptions & Design Decisions
- **Building Temperature Editing**:
  - The `BuildingDialog` component is used to edit temperature.
  - The parent component (`BuildingCard`) is responsible for passing the correct `building.id`.
- **Data Flow**:
  - The `onSubmit` function in `BuildingDialog` is used to update the temperature.
  - The `onEdit` function in `BuildingCard` is expected to handle the update logic.
- **API Calls**:
  - `axios` is used to fetch building data.
  - The temperature update API is **not yet implemented** but assumed to exist at `/building/:id/update-temperature`.

---

## 📝 License
This project is licensed under the **MIT License**.
