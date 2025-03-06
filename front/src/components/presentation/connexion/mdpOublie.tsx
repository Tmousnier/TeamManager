import { useState } from "react";
import axios from "axios";
import "./mdpOublie.css"; // Créez ce fichier CSS pour le style

const MotDePasseOublie = () => {
    const [email, setEmail] = useState("");
    const [message, setMessage] = useState("");
    const [errorMessage, setErrorMessage] = useState("");

    const handleSubmit = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/api/connexion/mot-de-passe-oublie", { email });
            setMessage(response.data.message || "Un email de réinitialisation a été envoyé.");
            setErrorMessage("");
        } catch (error) {
            // @ts-ignore
            setErrorMessage(error.response?.data?.message || "Erreur lors de l'envoi de l'email.");
            setMessage("");
        }
    };

    return (
        <div className="password-reset-container">
            <form onSubmit={handleSubmit} className="password-reset-form">
                <h2>Mot de passe oublié ?</h2>
                {message && <div className="success-message">{message}</div>}
                {errorMessage && <div className="error-message">{errorMessage}</div>}

                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>

                <button type="submit" className="submit-btn">
                    Envoyer l'email de réinitialisation
                </button>
            </form>
        </div>
    );
};

export default MotDePasseOublie;