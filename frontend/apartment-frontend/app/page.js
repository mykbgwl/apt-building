"use client";

import { useEffect } from "react";
import { useRouter } from "next/navigation";

const HomePage = () => {
  const router = useRouter();

  useEffect(() => {
    router.push("/building"); // Redirect to the /building page
  }, []);

  return (
    <div className="flex items-center justify-center min-h-screen">
      <p className="text-xl text-gray-700">Redirecting to buildings...</p>
    </div>
  );
};

export default HomePage;
