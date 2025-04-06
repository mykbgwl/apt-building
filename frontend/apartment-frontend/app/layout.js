import { Geist, Geist_Mono } from "next/font/google";
import Link from "next/link";
import "./globals.css";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

export const metadata = {
  title: "Building Management",
  description: "Manage buildings, rooms, and temperatures efficiently.",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={`${geistSans.variable} ${geistMono.variable} antialiased`}>
        <nav className="bg-[#0097E0] text-black p-4 shadow-md">
          <div className="container mx-auto flex justify-between items-center">
            <h1 className="text-xl font-bold">🏢 Building Manager</h1>
            <div className="flex space-x-4">
              <Link href="/building" className="hover:underline">Back</Link>
            </div>
          </div>
        </nav>

        <main className="container mx-auto p-6">{children}</main>
      </body>
    </html>
  );
}
