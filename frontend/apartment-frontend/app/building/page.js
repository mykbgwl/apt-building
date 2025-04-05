"use client";

import { useEffect, useState } from "react";
import axios from "axios";
import { useRouter } from "next/navigation";
import BuildingCard from "@/components/BuildingCard";
import BuildingDialog from "@/components/BuildingDialog";

const BuildingPage = () => {
  const [buildings, setBuildings] = useState([]);
  const [isDialogOpen, setIsDialogOpen] = useState(false);
  const router = useRouter();

  useEffect(() => {
    axios
      .get("http://localhost:8080/building/")
      .then((res) => setBuildings(res.data))
      .catch((err) => console.error(err));
  }, []);

  const navigateToApartments = (id) => {
    router.push(`/apartments?buildingId=${id}`);
  };

  const handleBuildingTemperature = (buildingId, requestedTemperature) => {
    axios
      .put(
        `http://localhost:8080/building/${buildingId}/temperature?requestedTemperature=${requestedTemperature}`, null
      )
      .then((res) => {
        console.log("Temperature Updated", res.data);
        setBuildings((prev) =>
          prev.map((b) =>
            b.id === buildingId ? { ...b, requestedTemperature } : b
          )
        );
      })
      .catch((err) => console.error("Failed to update:", err));
  };

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-2xl font-bold text-gray-800 mb-4">Buildings</h1>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {buildings.map((building) => (
          <BuildingCard
            key={building.id}
            building={building}
            onClick={navigateToApartments}
            onEdit={handleBuildingTemperature} // ✅ Pass this function
          />
        ))}
      </div>

      {isDialogOpen && (
        <BuildingDialog
          isOpen={isDialogOpen}
          onClose={() => setIsDialogOpen(false)}
          onSubmit={handleBuildingTemperature}
          data={null} // ✅ Avoid undefined error
        />
      )}
    </div>
  );
};

export default BuildingPage;
