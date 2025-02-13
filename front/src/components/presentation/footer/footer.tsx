import { FaFacebook, FaTwitter, FaInstagram, FaLinkedin } from "react-icons/fa";
import "./footer.css";

const Footer = () => {
    return (
        <footer className="footer">
            <div className="footer-container">
                <div className="footer-logo">
                    <div className="logo-box">
                        <span className="logo">TM</span>
                    </div>
                    <span className="company-name">TeamManager</span>
                    <div className="social-icons">
                        <FaFacebook />
                        <FaTwitter />
                        <FaInstagram />
                        <FaLinkedin />
                    </div>
                </div>
                <div className="footer-links">
                    <h4>Navigation rapide</h4>
                    <ul>
                        <li>Fonctionnalités</li>
                        <li>Tarifs</li>
                        <li>Rejoindre une équipe</li>
                        <li>Inscrire un club</li>
                    </ul>
                </div>
                <div className="footer-links">
                    <h4>À propos</h4>
                    <ul>
                        <li>Qui sommes-nous</li>
                        <li>Notre équipe</li>
                        <li>Contact</li>
                    </ul>
                </div>
                <div className="footer-contact">
                    <h4>Contact</h4>
                    <p>Des questions ? N'hésitez pas à nous contacter pour plus d'informations.</p>
                    <button className="contact-btn">Nous contacter</button>
                </div>
            </div>
            <div className="footer-bottom">
                <p>© 2024 TeamManager. Tous droits réservés.</p>
            </div>
        </footer>
    );
};

export default Footer;
