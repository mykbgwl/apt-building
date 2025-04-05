"use client";

import { useEffect, useState } from "react";
import axios from "axios";
import { useSearchParams } from "next/navigation";
import ApartmentCard from "@/components/ApartmentCard";
import RoomDialog from "@/components/RoomDialog";

const ApartmentsPage = () => {
  const searchParams = useSearchParams();
  const buildingId = searchParams.get("buildingId");

  const [apartments, setApartments] = useState([]);
  const [isDialogOpen, setIsDialogOpen] = useState(false);
  const [selectedApartment, setSelectedApartment] = useState(false);

  useEffect(() => {
    if (buildingId) {
      axios
        .get(`http://localhost:8080/building/${buildingId}/rooms`)
        .then((res) => setApartments(res.data))
        .catch((err) => console.error(err));
    }
  }, [buildingId]);

  // Open the dialog for adding a new apartment
  const handleOpenAdd = () => {
    setSelectedApartment(false);
    setIsDialogOpen(true);
  };

  // Open the dialog for editing an apartment
  const handleOpenEdit = (apartment) => {
    setSelectedApartment(apartment);
    setIsDialogOpen(true);
  };

  // Handle adding or editing
  const handleSubmit = (
    roomType,
    apartmentNumber,
    ownerName,
    commonRoomType // Added as a parameter
  ) => {
    if (!buildingId) {
      console.error("Error: buildingId is required.");
      return;
    }

    let apartmentNumber1 = apartmentNumber
      ? Number.isNaN(parseInt(apartmentNumber))
        ? null
        : parseInt(apartmentNumber)
      : null;

    let ownerName1 = ownerName ? ownerName.trim() : null;
    let commonRoomType1 = commonRoomType ? commonRoomType.trim() : null;
    let roomType1 = roomType ? roomType.trim() : null;

    if (selectedApartment) {
      // Editing existing apartment
      axios
        .put(
          `http://localhost:8080/room/${selectedApartment.id}/update/${buildingId}`,
          {
            commonRoomType: commonRoomType1 || null,
            roomType: roomType1 || null,
            apartmentNumber: apartmentNumber1,
            ownerName: ownerName1 || null,
          }
        )
        .then(() => {
          setApartments((prev) => {
            return prev.map((apt) =>
              apt.id === selectedApartment.id
                ? {
                    ...apt,
                    ownerName: ownerName1, // ✅ Use the updated value
                    roomType: roomType1, // ✅ Update other fields
                    commonRoomType: commonRoomType1,
                    apartmentNumber: apartmentNumber1,
                  }
                : apt
            );
          });
          setIsDialogOpen(false);
        })
        .catch((err) => console.error("Update Error:", err));
    } else {
      // Adding new apartment
      const requestPayload = {
        buildingId,
        commonRoomType: commonRoomType1 || null,
        roomType: roomType1 || null,
        apartmentNumber: apartmentNumber1,
        ownerName: ownerName1 || null,
      };

      axios
        .post(`http://localhost:8080/room/add/${buildingId}`, requestPayload, {
          headers: { "Content-Type": "application/json" },
        })
        .then((res) => {
          if (res.data) {
            setApartments((prev) => [...prev, res.data]);
          } else {
            console.error("Error: API response is empty");
          }
          setIsDialogOpen(false);
        })
        .catch((err) => console.error("Add Error:", err));
    }
  };

  // Handle deleting an apartment
  const handleDelete = (roomId) => {
    axios
      .delete(`http://localhost:8080/room/${roomId}/remove/${buildingId}`)
      .then(() => {
        setApartments((prev) => prev.filter((apt) => apt.id !== roomId));
      })
      .catch((err) => console.error(err));
  };

  return (
    <div className="container mx-auto p-6">
      <div className="flex justify-between items-center mb-4">
        <h1 className="text-2xl font-bold text-gray-800">
          Apartments in Building {buildingId}
        </h1>
        <button
          onClick={handleOpenAdd}
          className="bg-green-500 text-white px-4 py-2 rounded"
        >
          + Add Apartment
        </button>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {apartments.map((apartment, index) => (
          <ApartmentCard
            key={apartment.id ?? index}
            apartment={apartment}
            onEdit={() => handleOpenEdit(apartment)}
            onDelete={handleDelete}
          />
        ))}
      </div>

      {/* Add/Edit Apartment Modal */}
      <RoomDialog
        isOpen={isDialogOpen}
        onClose={() => setIsDialogOpen(false)}
        onSubmit={handleSubmit}
        apartment={selectedApartment}
      />
    </div>
  );
};

export default ApartmentsPage;
