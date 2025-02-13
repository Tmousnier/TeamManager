import React from 'react';
import './Contact.css'; // Importez votre fichier CSS
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faPhone, faMapMarkerAlt } from '@fortawesome/free-solid-svg-icons';
const Contact: React.FC = () => {
    return (
        <div className="contact-container"> {/* Conteneur principal */}
            <div className="contact-info"> {/* Section d'informations de contact */}
                <div className="info-card">
                    <FontAwesomeIcon icon={faEnvelope} />
                    <h3>Email</h3>
                    <p>mousniert.pro@gmail.com</p>
                </div>
                <div className="info-card">
                    <FontAwesomeIcon icon={faPhone} />
                    <h3>Téléphone</h3>
                    <p>+33 7 83 40 69 45</p>
                </div>
                <div className="info-card">
                    <FontAwesomeIcon icon={faMapMarkerAlt} />
                    <h3>Adresse</h3>
                    <p>Nantes, France</p>
                </div>
            </div>

            <div className="contact-form"> {/* Section du formulaire de contact */}
                <h2>Contactez-Moi</h2>
                <form>
                    <div className="form-group">
                        <label htmlFor="nom">Nom</label>
                        <input type="text" id="nom" name="nom" required />
                    </div>
                    <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <input type="email" id="email" name="email" required />
                    </div>
                    <div className="form-group">
                        <label htmlFor="sujet">Sujet</label>
                        <input type="text" id="sujet" name="sujet" required />
                    </div>
                    <div className="form-group">
                        <label htmlFor="message">Message</label>
                        <textarea id="message" name="message" rows={5} required></textarea>
                    </div>
                    <button type="submit">Envoyer le message</button>
                </form>
            </div>
        </div>
    );
};

export default Contact;