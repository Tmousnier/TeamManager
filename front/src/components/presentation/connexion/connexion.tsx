import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './connexion.css';
import { FaEye, FaEyeSlash } from "react-icons/fa";

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [isFormValid, setIsFormValid] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');
    const [showPassword, setShowPassword] = useState(false);
    useEffect(() => {setIsFormValid(email !== '' && password !== '');}, [email, password]);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await axios.post('/api/auth/login', { email, password });
            alert('Connexion réussie');
        } catch (error) {
            setErrorMessage('Identifiants incorrects');
        }
    };
    const togglePasswordVisibility = () => {setShowPassword(!showPassword);};

    return (
        <div className="login-container">
            <form onSubmit={handleSubmit} className="login-form">
                <h2>Se connecter</h2>
                {errorMessage && <div className="error-message">{errorMessage}</div>}
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input type="email" id="email" value={email} onChange={(e) => setEmail(e.target.value)} required/>
                </div>
                <div className="form-group">
                    <label htmlFor="password">Mot de passe</label>
                    <div className="password-container">
                        <input type={showPassword ? 'text' : 'password'} id="password" value={password} onChange={(e) => setPassword(e.target.value)} required/>
                        <button type="button" className="toggle-password" onClick={togglePasswordVisibility} aria-label="Afficher/Masquer le mot de passe">{showPassword ? <FaEyeSlash /> : <FaEye />}  {/* Affiche l'icône correspondant */}</button>
                    </div>
                </div>
                <button type="submit" className={`submit-btn ${isFormValid ? 'valid' : 'invalid'}`} disabled={!isFormValid}>Se connecter</button>
            </form>
        </div>
    );
};
export default Login;