import './Tarifs.css'; // Assurez-vous d'avoir un fichier CSS pour le style

const Tarifs = () => {
    return (
        <div className="tarifs-container">
            <h1>Tarifs</h1>
            <p>Choisissez le plan qui correspond à vos besoins</p>

            <div className="plan normal">
                <div className="plan-header">
                    <h2>Normal</h2>
                    <span className="populaire">Plus populaire</span>
                </div>
                <div className="prix">
                    <span>9,99 €</span>/mois
                </div>
                <ul className="features">
                    <li>Membres illimités</li>
                    <li>Agenda</li>
                    <li>Gestion des membres / équipes</li>
                    <li>Messagerie</li>
                    <li>Statistiques</li>
                </ul>
                <button className="choisir">Choisir Premium</button>
            </div>

            {/* Ajoutez d'autres plans ici si nécessaire */}
        </div>
    );
};

export default Tarifs;