import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"; // Importer React Router
import NavBar from "./components/presentation/navBar/NavBar";  // Importer NavBar
import Accueil from "./components/presentation/accueil/accueil.tsx";  // Page d'accueil
import Connexion from "./components/presentation/connexion/connexion.tsx";  // Page de connexion
import Footer from "./components/presentation/footer/footer.tsx";
import InscriptionClub from "./components/presentation/inscriptionClub/inscriptionClub.tsx";
import RejoindreEquipe from "./components/presentation/rejoindreEquipe/rejoindreEquipe.tsx";
import Contact from "./components/presentation/contact/contact.tsx";
import Fonctionnalites from "./components/presentation/fonctionnalites/fonctionnalites.tsx";
createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <Router>
            <NavBar />
            <Routes>
                <Route path="/" element={<Accueil/>} />
                <Route path="/connexion" element={<Connexion/>} />
                <Route path="/inscrireClub" element={<InscriptionClub/>} />
                <Route path="/rejoindreEquipe" element={<RejoindreEquipe/>} />
                <Route path="/contact" element={<Contact/>}/>
                <Route path="/fonctionnalites" element={<Fonctionnalites/>} />
            </Routes>
            <Footer/>
        </Router>
    </StrictMode>
);
