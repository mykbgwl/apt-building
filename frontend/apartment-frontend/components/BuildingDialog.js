import React, { useState, useEffect } from "react";

const BuildingDialog = ({ isOpen, onClose, onSubmit, data }) => {
  const [temperature, setTemperature] = useState("");

  useEffect(() => {
    if (data) {
      setTemperature(data.temperature || ""); // Pre-fill temperature
    }
  }, [data]);

  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
      <div className="bg-white p-6 rounded-lg shadow-lg w-96">
        <h2 className="text-xl font-bold mb-4 text-black">
          Edit Temperature for Building {data?.id}
        </h2>

        {/* Temperature Input */}
        <label className="block mb-2 text-black">Temperature (°C):</label>
        <input
          type="number"
          value={temperature}
          onChange={(e) => setTemperature(e.target.value)}
          className="border p-2 w-full rounded mb-4 text-black"
          placeholder="Enter temperature"
        />

        {/* Buttons */}
        <div className="flex justify-end gap-2">
          <button
            onClick={onClose}
            className="bg-gray-300 px-4 py-2 rounded text-black"
          >
            Cancel
          </button>
          <button
            onClick={() => {
              if (typeof onSubmit === "function") {
                // ✅ Check if function exists
                onSubmit(data.id, temperature);
              } else {
                console.error("Error: onSubmit is not a function");
              }
            }}
            className="px-4 py-2 rounded text-white bg-green-500"
          >
            Save
          </button>
        </div>
      </div>
    </div>
  );
};

export default BuildingDialog;
