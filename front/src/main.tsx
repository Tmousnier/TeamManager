import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"; // Importer React Router
import NavBar from "./components/presentation/navBar/NavBar";  // Importer NavBar
import Accueil from "./components/presentation/accueil/accueil.tsx";  // Page d'accueil
import Login from "./components/presentation/connexion/connexion.tsx";  // Page de connexion

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <Router>
            <NavBar /> {/* NavBar est en dehors des routes, donc visible sur toutes les pages */}
            <Routes>
                <Route path="/" element={<Accueil />} />  {/* Page d'accueil */}
                <Route path="/login" element={<Login />} />  {/* Page de connexion */}
                {/* Tu peux ajouter d'autres routes pour d'autres pages */}
            </Routes>
        </Router>
    </StrictMode>
);
