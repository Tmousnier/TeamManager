import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import NavBar from "./components/presentation/navBar/NavBar";
import Accueil from "./components/presentation/accueil/accueil.tsx";

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <NavBar />
        <Accueil />
    </StrictMode>
);
