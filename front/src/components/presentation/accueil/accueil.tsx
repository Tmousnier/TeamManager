import { useEffect, useState } from "react";
import "./accueil.css";
import teamImage from "../../../../public/image/imageAccueil.jpg";
import { Link } from "react-router-dom";

interface Sport {
    sportNom: string;
    nombreEquipes: number;
}

export default function Accueil() {
    const [stats, setStats] = useState({ members: 0, clubs: 0, equipes: 0 });
    const [sportsStats, setSportsStats] = useState<Sport[]>([]);
    const [loading, setLoading] = useState(true);
    useEffect(() => {
        // Récupérer les statistiques globales
        fetch("http://localhost:8080/api/accueil/stats")
            .then((res) => {
                if (!res.ok) {
                    throw new Error("Erreur lors du chargement des statistiques");
                }
                return res.json(); // Vérifier que la réponse est parsée en JSON
            })
            .then((data) => {
                console.log("Données reçues de /api/accueil/stats:", data);
                setStats(data);
                setLoading(false);
            })
            .catch((err) => {
                console.error("Erreur chargement stats", err);
                setLoading(false);
            });

        // Récupérer les statistiques des sports
        fetch("http://localhost:8080/api/accueil/stats/sports")
            .then((res) => {
                if (!res.ok) {
                    throw new Error("Erreur lors du chargement des statistiques des sports");
                }
                return res.json(); // Vérifier que la réponse est parsée en JSON
            })
            .then((data) => {
                console.log("Données reçues de /api/accueil/stats/sports:", data);
                setSportsStats(data);
            })
            .catch((err) => {
                console.error("Erreur chargement stats sports", err);
            });
    }, []);
    return (
        <section className="accueil-section">
            <div className="content">
                <div className="text-image-container">
                    <div className="text-section">
                        <h1>Gérez votre équipe sportive comme un pro</h1>
                        <p>Une plateforme complète pour la gestion d'équipes sportives.</p>
                        <div className="actions">
                            <Link to="/connexion" className="btn blue-btn">Connexion</Link>
                            <Link to="/inscrireClub" className="btn green-btn">Inscrire mon club</Link>
                        </div>
                    </div>
                    <div className="image-section">
                        <img rel="preload" src={teamImage} alt="Équipe sportive"/>
                    </div>
                </div>

                {/* Section Statistiques */}
                <div className="statistique-section">
                    <h2>Statistiques</h2>
                    <div className="stat-cards-container">
                        <div className="stat-card">
                            <h2 id="members">{stats.members}+</h2>
                            <p>Membres inscrits</p>
                        </div>
                        <div className="stat-card">
                            <h2 id="clubs">{stats.clubs}+</h2>
                            <p>Clubs actifs</p>
                        </div>
                        <div className="stat-card">
                            <h2 id="equipes">{stats.equipes}+</h2>
                            <p>Équipes</p>
                        </div>
                    </div>
                </div>

                {/* Section Sports */}
                <div className="sport-section">
                    <h2>Sports disponibles</h2>
                    <div className="sports-list">
                        {loading ? (
                            <div>Chargement...</div>
                        ) : (
                            sportsStats.map((sport, index) => (
                                <div key={index} className="sport-card">
                                    <h3>{sport.sportNom}</h3>
                                    <p>{sport.nombreEquipes} équipes</p>
                                </div>
                            ))
                        )}
                    </div>
                </div>

                {/* Section "Pourquoi choisir TeamManager ?" */}
                <div className="why-choose-section">
                    <h2>Pourquoi choisir TeamManager ?</h2>
                    <div className="why-choose-cards">
                        <div className="why-choose-card">
                            <img src="../../../../public/image/icone1.png" alt="Gestion simplifiée"/>
                            <h3>Gestion simplifiée</h3>
                            <p>
                                Gérez facilement les effectifs, les présences et les
                                statistiques de votre équipe
                            </p>
                        </div>
                        <div className="why-choose-card">
                            <img src="../../../../public/image/icone2.png" alt="Planification efficace"/>
                            <h3>Planification efficace</h3>
                            <p>
                                Organisez les matchs, les entrainements et les
                                événements en quelques clics
                            </p>
                        </div>
                        <div className="why-choose-card">
                            <img src="../../../../public/image/icone3.png" alt="Suivi complet"/>
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