import React, { useState } from 'react';
import ReCAPTCHA from 'react-google-recaptcha';
import './Contact.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faPhone, faMapMarkerAlt } from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';
import { v4 as uuidv4 } from 'uuid';

interface FormData {
    nom: string;
    prenom: string;
    email: string;
    sujet: string;
    message: string;
    [key: string]: string;
}

const Contact = () => {
    const [formData, setFormData] = useState<FormData>({
        nom: '',
        prenom: '',
        email: '',
        sujet: '',
        message: ''
    });

    const [errors, setErrors] = useState<{ [key: string]: string }>({});
    const [submitMessage, setSubmitMessage] = useState<string | null>(null);
    const [isSubmitting, setIsSubmitting] = useState(false);
    const [captchaToken, setCaptchaToken] = useState<string | null>(null);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const { name, value } = e.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: value
        }));
        setErrors((prevState) => ({
            ...prevState,
            [name]: ''
        }));
        setSubmitMessage(null);
    };

    const validateEmail = (email: string) => {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        const newErrors: { [key: string]: string } = {};
        let isValid = true;

        if (!formData.nom.trim()) { newErrors.nom = "Le nom est requis."; isValid = false; }
        if (!formData.prenom.trim()) { newErrors.prenom = "Le prénom est requis."; isValid = false; }
        if (!formData.sujet.trim()) { newErrors.sujet = "Le sujet est requis."; isValid = false; }
        if (!formData.message.trim()) { newErrors.message = "Le message est requis."; isValid = false; }
        if (!formData.email.trim() || !validateEmail(formData.email)) { newErrors.email = "L'email est invalide."; isValid = false; }
        if (!captchaToken) { newErrors["captcha"] = "Veuillez valider le ReCAPTCHA."; isValid = false; }

        setErrors(newErrors);
        if (!isValid) return;

        setIsSubmitting(true);
        const token = uuidv4();

        try {
            const response = await axios.post("http://localhost:8080/api/contact", {
                ...formData,
                token,
                captcha: captchaToken
            });
            setSubmitMessage(response.data.message);
            setFormData({ nom: '', prenom: '', email: '', sujet: '', message: '' });
            setErrors({});
        } catch (error: any) {
            if (error.response) {
                setSubmitMessage(`Erreur serveur : ${error.response.status} - ${error.response.data.message}`);
            } else if (error.request) {
                setSubmitMessage("Erreur réseau : Impossible de contacter le serveur.");
            } else {
                setSubmitMessage("Erreur : " + error.message);
            }
        } finally {
            setIsSubmitting(false);
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
                <h2>Contactez-nous</h2>
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

                    {/* Ajout du ReCAPTCHA */}
                    <div className="form-group">
                        <ReCAPTCHA
                            sitekey="VOTRE_SITE_KEY"
                            onChange={(token) => setCaptchaToken(token)}
                        />
                        {errors["captcha"] && <span className="error">{errors["captcha"]}</span>}
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