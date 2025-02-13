import "./accueil.css";
import teamImage from "../../../assets/imageAccueil.jpg";
import {Link} from "react-router-dom";

export default function accueil() {
    return (
        <section className="accueil-section">
            <div className="content">
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
        </section>
    );
}
