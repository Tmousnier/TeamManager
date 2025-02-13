import React, { useState, ChangeEvent, FormEvent } from 'react';
import './RejoindreEquipe.css';

interface FormData {
    nom: string;
    prenom: string;
    email: string;
    motDePasse: string;
    dateNaissance: string;
    telephone: string;
    role: string;
    club: string;
    conditions: boolean;
}

const RejoindreEquipe: React.FC = () => {
    const [formData, setFormData] = useState<FormData>({
        nom: '',
        prenom: '',
        email: '',
        motDePasse: '',
        dateNaissance: '',
        telephone: '',
        role: 'joueur',
        club: '',
        conditions: false,
    });

    const handleChange = (event: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        const target = event.target;

        if (target instanceof HTMLInputElement) {
            const { name, type, checked, value } = target;
            setFormData({
                ...formData,
                [name]: type === 'checkbox' ? checked : value,
            });
        } else if (target instanceof HTMLSelectElement) {
            const { name, value } = target;
            setFormData({
                ...formData,
                [name]: value,
            });
        }
    };

    const handleSubmit = (event: FormEvent) => {
        event.preventDefault();
        console.log('Données du formulaire:', formData);

        // Ici, vous pouvez ajouter votre logique pour envoyer les données au backend
        // fetch('/api/rejoindre', { ... })
    };

    return (
        <div className="rejoindre-equipe-container"> {/* Conteneur principal */}
            <div className="container"> {/* Conteneur pour le style */}
                <h1>Rejoindre une équipe</h1>
                <p>Commencez votre aventure sportive avec TeamManager</p>

                <form onSubmit={handleSubmit}>
                    <fieldset>
                        <legend>Informations Personnelles</legend>
                        <div className="form-group">
                            <label htmlFor="nom">Nom :</label>
                            <input type="text" id="nom" name="nom" value={formData.nom} onChange={handleChange} required />
                        </div>
                        <div className="form-group">
                            <label htmlFor="prenom">Prénom :</label>
                            <input type="text" id="prenom" name="prenom" value={formData.prenom} onChange={handleChange} required />
                        </div>
                        <div className="form-group">
                            <label htmlFor="email">Email :</label>
                            <input type="email" id="email" name="email" value={formData.email} onChange={handleChange} required />
                        </div>
                        <div className="form-group">
                            <label htmlFor="motDePasse">Mot de passe :</label>
                            <input type="password" id="motDePasse" name="motDePasse" value={formData.motDePasse} onChange={handleChange} required />
                        </div>
                        <div className="form-group">
                            <label htmlFor="dateNaissance">Date de naissance :</label>
                            <input type="date" id="dateNaissance" name="dateNaissance" value={formData.dateNaissance} onChange={handleChange} required />
                        </div>
                        <div className="form-group">
                            <label htmlFor="telephone">Numéro de téléphone :</label>
                            <input type="tel" id="telephone" name="telephone" value={formData.telephone} onChange={handleChange} required />
                        </div>
                    </fieldset>

                    <fieldset>
                        <legend>Information d'Équipe</legend>
                        <div className="form-group">
                            <label htmlFor="role">Rôle :</label>
                            <select id="role" name="role" value={formData.role} onChange={handleChange}>
                                <option value="joueur">Joueur</option>
                                <option value="parent">Parent</option>
                                <option value="entraineur">Entraîneur</option>
                                <option value="dirigeant">Dirigeant</option>
                            </select>
                        </div>
                        <div className="form-group">
                            <label htmlFor="club">Club :</label>
                            <select id="club" name="club" value={formData.club} onChange={handleChange}>
                                <option value="">Sélectionnez un club</option>
                                {/* Ici, vous devrez mapper vos clubs */}
                                <option value="club1">Club 1</option>
                                <option value="club2">Club 2</option>
                            </select>
                        </div>
                        <div className="form-group">
                            <input type="checkbox" id="conditions" name="conditions" checked={formData.conditions} onChange={handleChange} required />
                            <label htmlFor="conditions">
                                J'accepte les conditions d'utilisation et la politique de confidentialité
                            </label>
                        </div>
                    </fieldset>

                    <button type="submit">Rejoindre l'équipe</button>
                </form>
            </div>
        </div>
    );
};

export default RejoindreEquipe;