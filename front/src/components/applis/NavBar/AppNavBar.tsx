import React, { useEffect, useState } from "react";
import "./AppNavBar.css";
import { Bell, ChevronDown } from "lucide-react";
import { uploadLogo, getLogoUrl } from "./logoService";

interface MembreConnexionDto {
    nom: string;
    prenom: string;
    idClub: number | null;
    nomClub: string | null;
    idEquipe: number | null;
    nomEquipe: string | null;
    role: string | null;
}

interface AppNavBarProps {
    membreInfo: MembreConnexionDto | null;
}

export default function AppNavBar({ membreInfo }: AppNavBarProps) {
    const [logoUrl, setLogoUrl] = useState<string | null>(null);

    const handleLogoChange = async (event: React.ChangeEvent<HTMLInputElement>) => {
        if (event.target.files && event.target.files[0]) {
            const file = event.target.files[0];
            const uploadedUrl = await uploadLogo(file); // Assuming uploadLogo handles file upload and returns the URL
            setLogoUrl(uploadedUrl);
        }
    };

    useEffect(() => {
        const fetchLogo = async () => {
            const url = await getLogoUrl();
            setLogoUrl(url);
        };

        fetchLogo();
    }, []);

    return (
        <nav className="navbar">
            <div className="left">
                <label className="logoUpload">
                    {logoUrl ? (
                        <img src={logoUrl} alt="Logo du club" className="logo" />
                    ) : (
                        <div className="logoPlaceholder">+</div>
                    )}
                    <input type="file" accept="image/*" onChange={(e) => handleLogoChange(e)} hidden />
                </label>
                {/* Affichage du nom du club et de l'équipe */}
                <span className="clubName">{membreInfo?.nomClub || "Chargement..."}</span>
                {membreInfo?.nomEquipe && (
                    <span className="teamName"> - {membreInfo.nomEquipe}</span>
                )}
                <ul className="navLinks">
                    <li>Tableau de bord</li>
                    <li>Calendrier</li>
                    <li>Équipes</li>
                    <li>Messages</li>
                    <li>Championnat</li>
                    <li>Paramètres</li>
                </ul>
            </div>
            <div className="right">
                <div className="notifications">
                    <Bell size={20} />
                    <span className="badge">2</span>
                </div>
                <div className="profile">
                    <img src="https://i.pravatar.cc/40" alt="Profil" className="avatar" />
                    {/* Affichage du prénom, nom et rôle */}
                    <span>{membreInfo?.prenom} {membreInfo?.nom}</span>
                    <span className="role">{membreInfo?.role || "Rôle non défini"}</span>
                    <ChevronDown size={16} />
                </div>
            </div>
        </nav>
    );
}
