import "./NavBar.css";

export default function NavBar() {
    return (
        <nav className="navbar">
            <div className="navbar-brand">
                <span className="logo">TM</span>
                <span className="brand-name">TeamManager</span>
            </div>
            <ul className="navbar-links">
                <li><a href="#features">Fonctionnalités</a></li>
                <li><a href="#register-club">Inscrire un club</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a href="#about">À propos</a></li>
            </ul>
            <div className="navbar-actions">
            <a href="#login" className="login">Se connecter</a>
                <a href="#join-team" className="register-btn">Rejoindre une équipe</a>
            </div>
        </nav>
    );
}
