"use client";

import { useEffect, useState } from "react";
import axios from "axios";
import { useRouter } from "next/navigation";
import BuildingCard from "@/components/BuildingCard";

const BuildingPage = () => {
  const [buildings, setBuildings] = useState([]);
  const router = useRouter();

  useEffect(() => {
    axios.get("http://localhost:8080/building/")
      .then((res) => setBuildings(res.data))
      .catch((err) => console.error(err));
  }, []);

  const navigateToApartments = (id) => {
    router.push(`/apartments?buildingId=${id}`);
  };

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-2xl font-bold text-gray-800 mb-4">Buildings</h1>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {buildings.map((building) => (
          <BuildingCard key={building.id} building={building} onClick={navigateToApartments} />
        ))}
      </div>
    </div>
  );
};

export default BuildingPage;
