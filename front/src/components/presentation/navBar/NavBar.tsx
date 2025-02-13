import { Link } from "react-router-dom";
import "./NavBar.css";

export default function NavBar() {
    return (
        <nav className="navbar">
            <div className="navbar-brand">
                <span className="logo">TM</span>
                <span className="brand-name">
                     <Link to="/" className="navbar-link">TeamManager</Link>
                </span>
            </div>
            <ul className="navbar-links">
                <li><Link to="/fonctionnalites" className="navbar-link">Fonctionnalités</Link></li>
                <li><Link to="/inscrireClub" className="navbar-link">Inscrire un club</Link></li>
                <li><Link to="/contact" className="navbar-link">Contact</Link></li>
                <li><Link to="/apropos" className="navbar-link">À propos</Link></li>
            </ul>
            <div className="navbar-actions">
                <Link to="/connexion" className="login">Se connecter</Link>
                <Link to="/rejoindreEquipe" className="register-btn">Rejoindre une équipe</Link>
            </div>
        </nav>
    );
}