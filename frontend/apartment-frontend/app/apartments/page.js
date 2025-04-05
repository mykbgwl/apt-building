"use client";

import { useEffect, useState } from "react";
import axios from "axios";
import { useSearchParams } from "next/navigation";
import ApartmentCard from "@/components/ApartmentCard";

const ApartmentsPage = () => {
  const searchParams = useSearchParams();
  const buildingId = searchParams.get("buildingId");

  const [apartments, setApartments] = useState([]);

  useEffect(() => {
    if (buildingId) {
      axios.get(`http://localhost:8080/building/${buildingId}/rooms`) // Replace with actual API
        .then((res) => setApartments(res.data))
        .catch((err) => console.error(err));
    }
  }, [buildingId]);

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-2xl font-bold text-gray-800 mb-4">Apartments in Building {buildingId}</h1>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {apartments.map((apartment) => (
          <ApartmentCard key={apartment.id} apartment={apartment} />
        ))}
      </div>
    </div>
  );
};

export default ApartmentsPage;
