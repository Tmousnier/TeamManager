import { FaFacebook, FaTwitter, FaInstagram, FaLinkedin } from "react-icons/fa";
import "./footer.css";
import {Link, useNavigate} from "react-router-dom";

const Footer = () => {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate('/contact');
    };
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
                        <li><Link to="/fonctionnalites">Fonctionnalités</Link></li>
                        <li><Link to="/tarifs">Tarifs</Link></li>
                        <li><Link to="/inscrireClub">Inscrire un club</Link></li>
                    </ul>
                </div>
                <div className="footer-links">
                    <h4>À propos</h4>
                    <ul>
                        <li><Link to="/apropos">Qui suis-je ?</Link></li>
                    </ul>
                </div>
                <div className="footer-contact">
                    <h4>Contact</h4>
                    <p>Des questions ? N'hésitez pas à nous contacter pour plus d'informations.</p>
                    <button className="contact-btn" onClick={handleClick}>Nous contacter</button>
                </div>
            </div>
            <div className="footer-bottom">
                <p>© 2024 TeamManager. Tous droits réservés.</p>
            </div>
        </footer>
    );
};
export default Footer;