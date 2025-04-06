import React, { useState } from "react"; // Reusing the ApartmentDialog
import BuildingDialog from "./BuildingDialog";

const BuildingCard = ({ building, onClick, onEdit }) => {
  const [isDialogOpen, setDialogOpen] = useState(false);

  const handleSave = (buildingId, updatedTemperature) => {
    onEdit(buildingId, updatedTemperature); // Pass updated building details
    setDialogOpen(false);
  };

  return (
    <div className="bg-[#6c7c8c] p-4 rounded-lg shadow-lg hover:shadow-xl transition cursor-pointer">
      <h2 className="text-xl font-semibold text-gray-800">
        Building {building.id}
      </h2>
      <p className="text-gray-600">
        Temperature: {building.requestedTemperature}°C
      </p>
      <p className="text-black">Total Rooms: {building.rooms.length}</p>

      {/* Buttons */}
      <div className="mt-3 flex justify-between">
        <button
          className="bg-blue-500 text-white px-3 py-1 rounded hover:bg-blue-600"
          onClick={() => onClick(building.id)}
        >
          View Rooms
        </button>

        <button
          className="bg-gray-700 text-white px-3 py-1 rounded hover:bg-gray-800"
          onClick={() => setDialogOpen(true)}
        >
          Edit
        </button>
      </div>

      {/* Edit Dialog */}
      {isDialogOpen && (
        <BuildingDialog
          isOpen={isDialogOpen}
          onClose={() => setDialogOpen(false)}
          onSubmit={handleSave} // ✅ Pass handleSave
          data={{
            id: building.id, // ✅ Correct ID field
            temperature: building.requestedTemperature, // ✅ Pre-fill temperature
          }}
        />
      )}
    </div>
  );
};

export default BuildingCard;
