import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"; // Importer React Router
import NavBar from "./components/presentation/navBar/NavBar";  // Importer NavBar
import Accueil from "./components/presentation/accueil/accueil.tsx";  // Page d'accueil
import Connexion from "./components/presentation/connexion/connexion.tsx";  // Page de connexion
import Footer from "./components/presentation/footer/footer.tsx";
import InscriptionClub from "./components/presentation/inscriptionClub/inscriptionClub.tsx";
import Contact from "./components/presentation/contact/contact.tsx";
import Fonctionnalites from "./components/presentation/fonctionnalites/fonctionnalites.tsx";
import Tarifs from "./components/presentation/tarif/Tarifs.tsx";
import APropos from "./components/presentation/apropos/apropos.tsx";
import MotDePasseOublie from "./components/presentation/connexion/mdpOublie.tsx";

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <Router>
            <NavBar />
            <Routes>
                <Route path="/" element={<Accueil/>} />
                <Route path="/connexion" element={<Connexion/>} />
                <Route path="/inscrireClub" element={<InscriptionClub/>} />
                <Route path="/contact" element={<Contact/>}/>
                <Route path="/fonctionnalites" element={<Fonctionnalites/>} />
                <Route path="/tarifs" element={<Tarifs />} />
                <Route path="/apropos" element={<APropos/>} />
                <Route path="/mdpOublie" element={<MotDePasseOublie />} />
            </Routes>
            <Footer/>
        </Router>
    </StrictMode>
);