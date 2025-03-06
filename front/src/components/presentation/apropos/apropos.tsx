import './apropos.css'; // Assurez-vous d'avoir un fichier CSS pour le style
import theomousnier from "../../../../public/image/theomousnier.jpg";

const APropos = () => {
    return (
        <div className="apropos-container">
            <h1>À Propos de TeamManager</h1>
            <div className="sectionImage">
                <div className="image-container">
                    <img rel="preload" src={theomousnier} alt="Theo Mousnier photo" /> {/* Remplacez par le chemin de votre image */}
                </div>
                <div className="text-container">
                    <h2>Theo Mousnier</h2>
                    <h3>Fondateur & Développeur</h3>
                </div>
            </div>
            <div className="sectionBloc">
                <div className="section">
                <div className="text-container2">
                    <h2>Mon Histoire</h2>
                    <p>
                        Bonjour, je suis Theo Mousnier, un développeur de 20 ans.
                        Depuis quelque années je me suis intéressé au développement informatique.
                    </p>
                    <p>
                        Mon parcours dans le développement a commencé depuis 3-4 ans, j'ai commencé
                        par apprendre le développement au BTS SIO (Services Informatiques aux Organisations)
                        puis je continue en Bachelor Developpeur Web. Où j'append actuellement à développer des applications
                        web.
                    </p>
                    <p>
                        Pour mon bachelor je dois créer une application web et c'est la que TeamManager est nées.
                        J'ai décidé de créer une application de gestion d'équipe car je suis interesser par le développement
                        et le sport, dont j'ai pratiqué pendant environ 10 ans. J'ai donc décidé de créer une application qui
                        permet de gérer une équipe de sport pour faciliter la vie au club et aux sportifs.
                    </p>
                </div>
            </div>
                <div className="section">
                <div className="text-container2">
                    <h2>TeamManager</h2>
                    <p>
                        TeamManager est né d'une conviction simple : la gestion d'équipe
                        devrait être intuitive et efficace. Notre plateforme combine les meilleures
                        pratiques de gestion avec une interface utilisateur simple.
                    </p>
                    <p>
                        Notre mission est de permettre aux équipes de toutes tailles de se
                        concentrer sur ce qui compte vraiment : la création de valeur et
                        l'innovation, plutôt que la gestion administrative.
                    </p>
                    <p>
                        Aujourd'hui, TeamManager continue d'évoluer grâce aux retours de
                        notre communauté grandissante d'utilisateurs passionnés.
                    </p>
                </div>
            </div>
            </div>

        </div>
    );
};

export default APropos;