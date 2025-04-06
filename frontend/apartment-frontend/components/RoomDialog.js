import React, { useState, useEffect } from "react";

const RoomDialog = ({ isOpen, onClose, onSubmit, data }) => {
  const [roomType, setRoomType] = useState("ROOM");
  const [apartmentNumber, setApartmentNumber] = useState("");
  const [ownerName, setOwnerName] = useState("");
  const [commonRoomType, setCommonRoomType] = useState("");

  useEffect(() => {
    if (data) {
      setRoomType(data.roomType || "ROOM");
      setOwnerName(data.ownerName || "");
      setApartmentNumber(data.apartmentNumber || "");
      setCommonRoomType(data.commonRoomType || "");
    } else {
      setRoomType("ROOM");
      setOwnerName("");
      setApartmentNumber("");
      setCommonRoomType("");
    }
  }, [data]);

  useEffect(() => {
    if (roomType === "COMMON_ROOM") {
      setCommonRoomType(data?.commonRoomType || "GYM"); // Default value
    } else {
      setCommonRoomType(""); // Reset when not COMMON_ROOM
    }
  }, [roomType, data]);

  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
      <div className="bg-white p-6 rounded-lg shadow-lg w-96">
        <h2 className="text-xl font-bold mb-4 text-black">
          {data ? "Edit Room" : "Add New Room"}
        </h2>

        {/* Room Type Selection */}
        <label className="block mb-2 text-black">Room Type:</label>
        <select
          value={roomType}
          onChange={(e) => setRoomType(e.target.value)}
          className="border p-2 w-full rounded mb-4 text-black"
        >
          <option value="ROOM">Room</option>
          <option value="COMMON_ROOM">Common Room</option>
          <option value="APARTMENT">Apartment</option>
        </select>

        {/* Apartment Fields */}
        {roomType === "APARTMENT" && (
          <>
            <label className="block mb-2 text-black">Apartment Number:</label>
            <input
              type="text"
              value={apartmentNumber}
              onChange={(e) => setApartmentNumber(e.target.value)}
              className="border p-2 w-full rounded mb-4 text-black"
            />
            <label className="block mb-2 text-black">Owner Name:</label>
            <input
              type="text"
              value={ownerName}
              onChange={(e) => setOwnerName(e.target.value)}
              className="border p-2 w-full rounded mb-4 text-black"
            />
          </>
        )}

        {/* Common Room Fields */}
        {roomType === "COMMON_ROOM" && (
          <>
            <label className="block mb-2 text-black">Common Room Type:</label>
            <select
              value={commonRoomType}
              onChange={(e) => setCommonRoomType(e.target.value)}
              className="border p-2 w-full rounded mb-4 text-black"
            >
              <option value="GYM">Gym</option>
              <option value="LIBRARY">Library</option>
              <option value="LAUNDRY">Laundry</option>
            </select>
          </>
        )}

        {/* Buttons */}
        <div className="flex justify-end gap-2">
          <button
            onClick={onClose}
            className="bg-gray-300 px-4 py-2 rounded text-black"
          >
            Cancel
          </button>
          <button
            onClick={() =>
              onSubmit(roomType, apartmentNumber, ownerName, commonRoomType)
            }
            className="px-4 py-2 rounded text-white bg-green-500"
          >
            {data ? "Update Room" : "Add Room"}
          </button>
        </div>
      </div>
    </div>
  );
};

export default RoomDialog;
