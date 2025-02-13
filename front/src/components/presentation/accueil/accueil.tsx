import "./accueil.css";
import teamImage from "../../../assets/imageAccueil.jpg";
import { Link } from "react-router-dom";

export default function accueil() {
    return (
        <section className="accueil-section">
            <div className="content">
                <div className="text-image-container"> {/* Conteneur pour le texte et l'image */}
                    <div className="text-section">
                        <h1>Gérez votre équipe sportive comme un pro</h1>
                        <p>
                            Une plateforme complète pour la gestion d'équipes sportives, la
                            planification des matchs et la communication avec les joueurs.
                        </p>
                        <div className="actions">
                            <Link to="/rejoindreEquipe" className="btn blue-btn">Rejoindre une équipe</Link>
                            <Link to="/inscrireClub" className="btn green-btn">Inscrire mon club</Link>
                        </div>
                    </div>
                    <div className="image-section">
                        <img src={teamImage} alt="Team playing on a field" />
                    </div>
                </div>
                <div className="why-choose-section">
                    <h2>Pourquoi choisir TeamManager ?</h2>
                    <div className="why-choose-cards">
                        <div className="why-choose-card">
                            <img src="../../../../public/image/icone1.png" alt="Gestion simplifiée" />
                            <h3>Gestion simplifiée</h3>
                            <p>
                                Gérez facilement les effectifs, les présences et les
                                statistiques de votre équipe
                            </p>
                        </div>
                        <div className="why-choose-card">
                            <img src="../../../../public/image/icone2.png" alt="Planification efficace" />
                            <h3>Planification efficace</h3>
                            <p>
                                Organisez les matchs, les entrainements et les
                                événements en quelques clics
                            </p>
                        </div>
                        <div className="why-choose-card">
                            <img src="../../../../public/image/icone3.png" alt="Suivi complet" />
                            <h3>Suivi complet</h3>
                            <p>
                                Suivez les performances, les statistiques et la
                                progression de votre équipe
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
}