import React from "react";

const ApartmentCard = ({ apartment, onEdit, onDelete }) => {
  return (
    <div className="bg-[#6c7c8c] p-4 rounded-lg shadow-lg hover:shadow-xl transition">
      <h2 className="text-lg font-bold text-gray-800">
        {apartment.roomType} {apartment.apartmentNumber}
      </h2>
      {apartment.roomType === "APARTMENT" && (
        <p className="text-black">Owner: {apartment.ownerName}</p>
      )}
      {apartment.roomType === "COMMON_ROOM" && (
        <p className="text-black">
          Common Room Type: {apartment.commonRoomType}
        </p>
      )}
      <p className="text-black">Temperature: {apartment.temp?.toFixed(1)}°C</p>
      <p className="text-black">
        Heating: {apartment.heatingEnabled ? "ON" : "OFF"}
      </p>
      <p className="text-black">
        Cooling: {apartment.coolingEnabled ? "ON" : "OFF"}
      </p>

      <div className="flex gap-2 mt-4">
        <button
          onClick={onEdit}
          className="bg-blue-500 text-white px-3 py-1 rounded"
        >
          Edit
        </button>
        <button
          onClick={() => onDelete(apartment.id)}
          className="bg-red-500 text-white px-3 py-1 rounded"
        >
          Delete
        </button>
      </div>
    </div>
  );
};

export default ApartmentCard;
