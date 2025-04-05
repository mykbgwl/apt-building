import React from "react";

const BuildingCard = ({ building, onClick }) => {
  return (
    <div 
      className="bg-white p-4 rounded-lg shadow-lg hover:shadow-xl transition cursor-pointer"
      onClick={() => onClick(building.id)}
    >
      <h2 className="text-xl font-semibold text-gray-800">Building {building.id}</h2>
      <p className="text-gray-600">Temperature: {building.requestedTemperature}°C</p>
      <p className="text-black">Total Rooms: {building.rooms.length}</p>
    </div>
  );
};

export default BuildingCard;
