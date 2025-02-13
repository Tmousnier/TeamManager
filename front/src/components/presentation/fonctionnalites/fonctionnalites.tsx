import './fonctionnalites.css';
import {Link} from "react-router-dom"; // Importez votre fichier CSS

const Fonctionnalites = () => {
    return (
        <div className="fonctionnalites-container">
            <div className="banner">
                <h2>La Solution Complète pour Votre Club Sportif</h2>
                <p>Découvrez nos fonctionnalités conçues pour simplifier la gestion de votre club</p>
            </div>
            <div className="fonctionnalites-content"> {/* Contenu principal */}
                <h1>Nos Fonctionnalités</h1>
                <p>Tout ce dont vous avez besoin pour gérer votre club efficacement</p>
                <div className="fonctionnalites-grid">
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/gestionMembre.png" alt="Gestion des membres"/>
                        <h3>Gestion des membres</h3>
                        <p>Gérez facilement vos membres et leurs informations personnelles en toute sécurité</p>
                    </div>
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/messagerieClub.png" alt="Messagerie du club"/>
                        <h3>Messagerie du club</h3>
                        <p>Communication centralisée pour tous les membres du club</p>
                    </div>
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/planningeGenerale.png"
                             alt="Planning général"/>
                        <h3>Planning général</h3>
                        <p>Vue d'ensemble des activités et événements du club</p>
                    </div>
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/GestionEquipes.png"
                             alt="Gestion des équipes"/>
                        <h3>Gestion des équipes</h3>
                        <p>Organisez et gérez vos équipes de manière efficace</p>
                    </div>
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/effectifsProfilsJoueur.png"
                             alt="Effectifs et profils joueurs"/>
                        <h3>Effectifs et profils joueurs</h3>
                        <p>Profils détaillés des joueurs et gestion des effectifs</p>
                    </div>
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/messageEquipe.png" alt="Messagerie d'équipe"/>
                        <h3>Messagerie d'équipe</h3>
                        <p>Communication dédiée pour chaque équipe</p>
                    </div>
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/planningSpecifique.png"
                             alt="Planning spécifique"/>
                        <h3>Planning spécifique</h3>
                        <p>Planification détaillée par équipe et par événement</p>
                    </div>
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/convocationPresences.png"
                             alt="Convocations & présences"/>
                        <h3>Convocations & présences</h3>
                        <p>Gestion simplifiée des présences et convocations</p>
                    </div>
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/championnatResultat.png"
                             alt="Championnat & résultats"/>
                        <h3>Championnat & résultats</h3>
                        <p>Suivi des championnats et gestion des résultats</p>
                    </div>
                    <div className="fonctionnalite-card">
                        <img src="../../../../public/image/fonctionnalite/feuilleMatch.png" alt="Feuille de match"/>
                        <h3>Feuille de match</h3>
                        <p>Gestion digitale des feuilles de match</p>
                    </div>
                </div>
            </div>
            <div className="cta-section">
                <h2>Prêt à améliorer la gestion de votre club ?</h2>
                <p>Rejoignez les nombreux clubs qui font confiance à notre solution</p>
                <div className="cta-buttons">
                    <Link to="/rejoindreEquipe" className="cta-buttons-link">Rejoindre une équipe</Link>
                    <Link to="/inscrireClub" className="cta-buttons-link">Inscrire mon club</Link>
                </div>
            </div>
        </div>
    );
};

export default Fonctionnalites;