import {NavLink} from "react-router-dom"; // Importez NavLink
import "./NavBar.css";

export default function NavBar() {
    return (
        <nav className="navbar">
            <div className="navbar-brand">
                <span className="logo">TM</span>
                <span className="brand-name">
                    <NavLink to="/">TeamManager</NavLink>
                </span>
            </div>
            <ul className="navbar-links">
                <li>
                    <NavLink to="/fonctionnalites" className="navbar-link" activeClassName="active">Fonctionnalités</NavLink>
                </li>
                <li>
                    <NavLink to="/contact" className="navbar-link" activeClassName="active">Contact</NavLink>
                </li>
                <li>
                    <NavLink to="/apropos" className="navbar-link" activeClassName="active">À propos</NavLink>
                </li>
            </ul>
            <div className="navbar-actions">
                <NavLink to="/connexion" className="login" activeClassName="active">Se connecter</NavLink>
                <NavLink to="/inscrireClub" className="register-btn" activeClassName="active">Inscrire un club</NavLink>
            </div>
        </nav>
    );
}