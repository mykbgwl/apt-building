import React from "react";

const ApartmentCard = ({ apartment }) => {
  return (
    <div className="bg-white p-4 rounded-lg shadow-lg hover:shadow-xl transition">
      <h2 className="text-lg font-bold text-gray-800">Apartment {apartment.apartmentNumber}</h2>
      <p className="text-gray-600">Owner: {apartment.ownerName}</p>
      <p className="text-black">Apartment ID: {apartment.id}</p>
      <p className="text-black">Temperature: {apartment.temp.toFixed(1)}°C</p>
      <p className="text-black">Heating: {apartment.heatingEnabled ? "ON" : "OFF"}</p>
      <p className="text-black">Cooling: {apartment.coolingEnabled ? "ON" : "OFF"}</p>
    </div>
  );
};

export default ApartmentCard;
