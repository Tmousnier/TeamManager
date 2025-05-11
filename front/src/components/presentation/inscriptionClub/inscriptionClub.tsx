import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './inscriptionClub.css';

const InscriptionClub = () => {
    const [formData, setFormData] = useState({
        nom: '',
        prenom: '',
        email: '',
        password: '',
        dateNaissance: '',
        nomClub: '',
        sport: '',
        idMembre: '',
        nomEquipe: '',
    });

    const [messageSucces, setMessageSucces] = useState('');
    const [messageErreur, setMessageErreur] = useState('');
    const navigate = useNavigate();

    const handleChange = (e: { target: { name: any; value: any; }; }) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        setMessageErreur('');
        setMessageSucces('');

        try {
            const reponse = await fetch('http://localhost:8080/api/clubs/inscription', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData),
            });

            if (reponse.ok) {
                // Vérifier si la réponse a un contenu avant d'essayer de l'analyser
                const contentType = reponse.headers.get('content-type');
                if (contentType && contentType.includes('application/json')) {
                    const donnees = await reponse.json();
                    setMessageSucces(donnees.message || 'Inscription réussie !');
                } else {
                    setMessageSucces('Inscription réussie !'); // si pas de json, on affiche quand même un message de succes.
                }

                setTimeout(() => {
                    navigate('/');
                }, 2000);
            } else {
                // Vérifier si la réponse a un contenu avant d'essayer de l'analyser
                const contentType = reponse.headers.get('content-type');
                if (contentType && contentType.includes('application/json')) {
                    const donneesErreur = await reponse.json();
                    setMessageErreur(donneesErreur.message || 'Erreur lors de l\'inscription.');
                } else {
                    setMessageErreur('Une erreur s\'est produite lors de l\'inscription.');
                }
            }
        } catch (erreur) {
            console.error('Erreur :', erreur);
            setMessageErreur('Une erreur s\'est produite.');
        }
    };
    return (
        <div className="centrage-container">
            <div className="inscription-club-container">
                <div className="form-container">
                    {messageSucces && <div className="message-succes">{messageSucces}</div>}
                    {messageErreur && <div className="message-erreur">{messageErreur}</div>}
                    <form className="inscription-form" onSubmit={handleSubmit}>
                        <section>
                            <h3>Informations personnelles</h3>
                            <div className="form-group-row">
                                <div className="form-group">
                                    <label htmlFor="nom">Nom</label>
                                    <input
                                        type="text"
                                        id="nom"
                                        name="nom"
                                        placeholder="Votre nom"
                                        value={formData.nom}
                                        onChange={handleChange}
                                        required
                                    />
                                </div>
                                <div className="form-group">
                                    <label htmlFor="prenom">Prénom</label>
                                    <input
                                        type="text"
                                        id="prenom"
                                        name="prenom"
                                        placeholder="Votre prénom"
                                        value={formData.prenom}
                                        onChange={handleChange}
                                        required
                                    />
                                </div>
                            </div>
                            <div className="form-group">
                                <label htmlFor="email">Email</label>
                                <input
                                    type="email"
                                    id="email"
                                    name="email"
                                    placeholder="Votre email"
                                    value={formData.email}
                                    onChange={handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="password">Mot de passe</label>
                                <input
                                    type="password"
                                    id="password"
                                    name="password"
                                    placeholder="Créer un mot de passe"
                                    value={formData.password}
                                    onChange={handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="dateNaissance">Date de naissance</label>
                                <input
                                    type="date"
                                    id="dateNaissance"
                                    name="dateNaissance"
                                    value={formData.dateNaissance}
                                    onChange={handleChange}
                                    required
                                />
                            </div>
                        </section>

                        <section>
                            <h3>Informations du club</h3>
                            <div className="form-group">
                                <label htmlFor="nomClub">Nom du club</label>
                                <input
                                    type="text"
                                    id="nomClub"
                                    name="nomClub"
                                    placeholder="Nom du club"
                                    value={formData.nomClub}
                                    onChange={handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="sport">Sport</label>
                                <select
                                    id="sport"
                                    name="sport"
                                    value={formData.sport}
                                    onChange={handleChange}
                                    required
                                >
                                    <option value="">Sélectionnez un sport</option>
                                    <option value="Football">Football</option>
                                    <option value="Basketball">Basketball</option>
                                    <option value="Handball">Handball</option>
                                    <option value="Rugby">Rugby</option>
                                </select>
                            </div>
                        </section>

                        <button type="submit" className="submit-btn">
                            Créer le club
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default InscriptionClub;