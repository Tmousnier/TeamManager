import { Link } from "react-router-dom";  // Utilisation de React Router pour la navigation
import "./NavBar.css";

export default function NavBar() {
    return (
        <nav className="navbar">
            <div className="navbar-brand">
                <span className="logo">TM</span>
                <span className="brand-name">
                     <Link to="/" className="navbar-link">TeamManager</Link> {/* Lien vers la page d'accueil */}
                </span>
            </div>
            <ul className="navbar-links">
                <li><Link to="/features" className="navbar-link">Fonctionnalités</Link></li>  {/* Lien vers fonctionnalités */}
                <li><Link to="/register-club" className="navbar-link">Inscrire un club</Link></li>  {/* Lien vers inscription club */}
                <li><Link to="/contact" className="navbar-link">Contact</Link></li>  {/* Lien vers la page Contact */}
                <li><Link to="/about" className="navbar-link">À propos</Link></li>  {/* Lien vers À propos */}
            </ul>
            <div className="navbar-actions">
                <Link to="/login" className="login">Se connecter</Link>  {/* Lien vers la page de connexion */}
                <a href="#join-team" className="register-btn">Rejoindre une équipe</a>
            </div>
        </nav>
    );
}