import { useState, useEffect } from "react";
import axios from "axios";
import {Link, useNavigate} from "react-router-dom"; // Pour la redirection
import { FaEye, FaEyeSlash } from "react-icons/fa";
import "./connexion.css";

const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [isFormValid, setIsFormValid] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");
    const [showPassword, setShowPassword] = useState(false);

    const [emailError, setEmailError] = useState("");
    const [passwordError, setPasswordError] = useState("");

    const navigate = useNavigate(); // Redirection

    useEffect(() => {
        // Validation du formulaire
        setIsFormValid(email !== "" && password !== "" && !emailError && !passwordError);
    }, [email, password, emailError, passwordError]);

    const validateEmail = (email: string) => {
        // Vérification si l'email est valide
        const regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        if (!email) {
            setEmailError("Il faut entrer un email.");
        } else if (!regex.test(email)) {
            setEmailError("L'email est incorrect.");
        } else {
            setEmailError("");
        }
    };

    const validatePassword = (password: string) => {
        // Vérification si le mot de passe est vide
        if (!password) {
            setPasswordError("Il faut entrer un mot de passe.");
        } else {
            setPasswordError("");
        }
    };

    const handleSubmit = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/api/connexion/login", { email, password });

            // Stocker le token, email et rôle
            localStorage.setItem("token", response.data.token);
            localStorage.setItem("email", response.data.email);
            localStorage.setItem("role", response.data.role);

            alert("Connexion réussie !");
            navigate("/"); // Redirection vers la page d'accueil
        } catch (error) {
            // @ts-ignore
            setErrorMessage(error.response?.data?.message || "Erreur de connexion");
        }
    };

    return (
        <div className="login-container">
            <form onSubmit={handleSubmit} className="login-form">
                <h2>Se connecter</h2>
                {errorMessage && <div className="error-message">{errorMessage}</div>}

                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={(e) => {
                            setEmail(e.target.value);
                            validateEmail(e.target.value);
                        }}
                        onBlur={() => validateEmail(email)}
                        required
                    />
                    {emailError && <div className="error-message">{emailError}</div>}
                </div>

                <div className="form-group">
                    <label htmlFor="password">Mot de passe</label>
                    <div className="password-container">
                        <input
                            type={showPassword ? "text" : "password"}
                            id="password"
                            value={password}
                            onChange={(e) => {
                                setPassword(e.target.value);
                                validatePassword(e.target.value);
                            }}
                            onBlur={() => validatePassword(password)}
                            required
                        />
                        <button
                            type="button"
                            className="toggle-password"
                            onClick={() => setShowPassword(!showPassword)}
                        >
                            {showPassword ? <FaEyeSlash /> : <FaEye />}
                        </button>
                    </div>
                    {passwordError && <div className="error-message">{passwordError}</div>}
                </div>

                <button type="submit" className={`submit-btn ${isFormValid ? "valid" : "invalid"}`} disabled={!isFormValid}>
                    Se connecter
                </button>
                <Link to="/mdpOublie">Mot de passe oublié ?</Link>
            </form>
        </div>
    );
};

export default Login;
