import { useState } from 'react';
import './Contact.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faPhone, faMapMarkerAlt } from '@fortawesome/free-solid-svg-icons';

const Contact = () => {
    const [formData, setFormData] = useState({
        nom: '',
        prenom: '',
        email: '',
        sujet: '',
        message: ''
    });
    const [errors, setErrors] = useState({
        nom: '',
        prenom: '',
        email: '',
        sujet: '',
        message: ''
    });
    const [submitMessage, setSubmitMessage] = useState<string | null>(null); // Type string | null
    const [isSubmitting, setIsSubmitting] = useState(false);

    const handleChange = (e: { target: { name: any; value: any; }; }) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
        setErrors({ ...errors, [name]: '' });
        setSubmitMessage(null);
    };

    const validateEmail = (email: string) => {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    };

    const handleSubmit = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        const newErrors = { nom: '', prenom: '', sujet: '', message: '', email: '' };
        let isValid = true;

        if (!formData.nom.trim()) { newErrors.nom = "Le nom est requis."; isValid = false; }
        if (!formData.prenom.trim()) { newErrors.prenom = "Le prénom est requis."; isValid = false; }
        if (!formData.sujet.trim()) { newErrors.sujet = "Le sujet est requis."; isValid = false; }
        if (!formData.message.trim()) { newErrors.message = "Le message est requis."; isValid = false; }
        if (!formData.email.trim() || !validateEmail(formData.email)) { newErrors.email = "L'email est invalide."; isValid = false; }

        setErrors(newErrors);

        if (isValid) {
            setIsSubmitting(true);
            fetch('/api/contact', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData)
            })
                .then(response => {
                    if (!response.ok) {
                        return response.json().then(err => { throw new Error(err.message) });
                    }
                    return response.json();
                })
                .then(data => {
                    setSubmitMessage(data.message);
                    setFormData({ nom: '', prenom: '', email: '', sujet: '', message: '' });
                    setErrors({ nom: '', prenom: '', email: '', sujet: '', message: '' });
                })
                .catch(error => {
                    setSubmitMessage("Erreur lors de l'envoi du message: " + error.message); // Pas de @ts-ignore
                    console.error("Erreur:", error);
                })
                .finally(() => setIsSubmitting(false));
        }
    };

    return (
        <div className="contact-container">
            <div className="contact-info">
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
            <div className="contact-form">
                <h2>Contactez-Moi</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="nom">Nom</label>
                        <input type="text" id="nom" name="nom" value={formData.nom} onChange={handleChange} required />
                        {errors.nom && <span className="error">{errors.nom}</span>}
                    </div>
                    <div className="form-group">
                        <label htmlFor="prenom">Prénom</label>
                        <input type="text" id="prenom" name="prenom" value={formData.prenom} onChange={handleChange} required />
                        {errors.prenom && <span className="error">{errors.prenom}</span>}
                    </div>
                    <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <input type="email" id="email" name="email" value={formData.email} onChange={handleChange} required />
                        {errors.email && <span className="error">{errors.email}</span>}
                    </div>
                    <div className="form-group">
                        <label htmlFor="sujet">Sujet</label>
                        <input type="text" id="sujet" name="sujet" value={formData.sujet} onChange={handleChange} required />
                        {errors.sujet && <span className="error">{errors.sujet}</span>}
                    </div>
                    <div className="form-group">
                        <label htmlFor="message">Message</label>
                        <textarea id="message" name="message" rows={5} value={formData.message} onChange={handleChange} required></textarea>
                        {errors.message && <span className="error">{errors.message}</span>}
                    </div>
                    <button type="submit" disabled={isSubmitting}>
                        {isSubmitting ? "Envoi en cours..." : "Envoyer le message"}
                    </button>
                    {submitMessage && <p className={submitMessage.startsWith("Erreur") ? "error" : "success"}>{submitMessage}</p>}
                </form>
            </div>
        </div>
    );
};
export default Contact;