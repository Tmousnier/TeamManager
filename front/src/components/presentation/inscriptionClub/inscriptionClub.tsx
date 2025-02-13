import React, { useState } from 'react';
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
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        console.log('Formulaire soumis :', formData);

        // Ici, vous pouvez ajouter votre logique pour envoyer les données au backend
        // fetch('/api/clubs', {
        //   method: 'POST',
        //   headers: { 'Content-Type': 'application/json' },
        //   body: JSON.stringify(formData)
        // })
        // .then(res => res.json())
        // .then(data => console.log('Réponse du serveur :', data))
        // .catch(err => console.error('Erreur :', err));
    };

    return (
        <div className="centrage-container"> {/* Conteneur pour le centrage */}
            <div className="inscription-club-container">
                <div className="form-container">
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
                                    <option value="football">Football</option>
                                    <option value="basketball">Basketball</option>
                                    <option value="tennis">Tennis</option>
                                    <option value="rugby">Rugby</option>
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