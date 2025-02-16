import React, { useState, ChangeEvent, FormEvent, useEffect } from 'react';
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

    const [sports, setSports] = useState<string[]>([]); // Liste des sports
    const [clubs, setClubs] = useState<string[]>([]);  // Liste des clubs disponibles

    // Récupérer la liste des sports (à adapter selon votre modèle de données)
    useEffect(() => {
        fetch('/api/sport/list')
            .then(response => response.json())
            .then(data => setSports(data))
            .catch(error => console.error('Erreur lors de la récupération des sports:', error));
    }, []);

    // Récupérer la liste des clubs quand un sport est sélectionné
    const handleSportChange = (event: ChangeEvent<HTMLSelectElement>) => {
        const sportNom = event.target.value;

        fetch(`/api/club/listBySport/${sportNom}`)
            .then(response => response.json())
            .then(data => setClubs(data.map((club: any) => club.nom)))  // On met à jour la liste des clubs
            .catch(error => console.error('Erreur lors de la récupération des clubs:', error));
    };

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

        // Vérifier si l'utilisateur a accepté les conditions
        if (!formData.conditions) {
            alert('Vous devez accepter les conditions d\'utilisation');
            return;
        }

        // Préparer les données à envoyer
        const membreData = {
            nom: formData.nom,
            prenom: formData.prenom,
            email: formData.email,
            motDePasse: formData.motDePasse,
            dateDeNaissance: formData.dateNaissance,
            numeroTelephone: formData.telephone,
            role: formData.role,
            club: { nom: formData.club }, // Associer le club par son nom (à adapter côté serveur)
        };

        // Envoi des données au backend
        fetch('/api/rejoindre', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(membreData),
        })
            .then(async response => {
                if (!response.ok) {
                    const errorData = await response.json();
                    throw new Error(errorData.message || 'Erreur serveur');
                }
                return response.json();
            })
            .then(data => {
                // Message de succès ou redirection
                alert(data.message || 'Membre ajouté avec succès');
            })
            .catch(error => {
                // Gérer l'erreur
                alert('Erreur lors de l\'ajout du membre: ' + error.message);
            });
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
                            <label htmlFor="sport">Sport :</label>
                            <select id="sport" name="sport" onChange={handleSportChange} required>
                                <option value="">Sélectionnez un sport</option>
                                {sports.map((sport, index) => (
                                    <option key={index} value={sport}>{sport}</option>
                                ))}
                            </select>
                        </div>
                        <div className="form-group">
                            <label htmlFor="club">Club :</label>
                            <select id="club" name="club" value={formData.club} onChange={handleChange} required>
                                <option value="">Sélectionnez un club</option>
                                {clubs.map((club, index) => (
                                    <option key={index} value={club}>{club}</option>
                                ))}
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

