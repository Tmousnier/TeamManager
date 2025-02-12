import "./accueil.css";
import teamImage from "../../../assets/imageAccueil.jpg";

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
                        <a href="#join-team" className="btn blue-btn">Rejoindre une équipe</a>
                        <a href="#register-club" className="btn green-btn">Inscrire mon club</a>
                    </div>
                </div>
                <div className="image-section">
                    <img src={teamImage} alt="Team playing on a field" />
                </div>
            </div>
        </section>
    );
}
