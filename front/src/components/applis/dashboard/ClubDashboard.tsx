import React, { useEffect, useState } from 'react';

import { format } from 'date-fns';
import { fr } from 'date-fns/locale';
import './ClubDashboard.css';
import AppNavBar from '../NavBar/AppNavBar';
import { AlertTriangle } from "lucide-react";

interface Event {
    id: number;
    nom: string;
    dateDebut: string;
    heureDebut: string;
    lieu: string;
    equipeId: number;
}

interface RoleMembre {
    nomRole: string;
}

interface Member {
    id: number;
    nom: string;
    prenom: string;
    roleMembre?: RoleMembre;
    statut: string;
    photo?: string;
    equipeId: number;
}

interface Notification {
    id: number;
    contenu: string;
    dateEnvoi: string;
    equipeId: number;
}

interface Equipe {
    id: number;
    nom: string;
}

interface MembreConnexionDto {
    nom: string;
    prenom: string;
    idClub: number | null;
    nomClub: string | null;
    idEquipe: number | null;
    nomEquipe: string | null;
    role: string | null;
}

const ClubDashboard: React.FC = () => {
    const [events, setEvents] = useState<Event[]>([]);
    const [members, setMembers] = useState<Member[]>([]);
    const [notifications, setNotifications] = useState<Notification[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const [membreInfo, setMembreInfo] = useState<MembreConnexionDto | null>(null);
    const [selectedTeamId, setSelectedTeamId] = useState<number | null>(null);
    const [equipes, setEquipes] = useState<Equipe[]>([]);

    useEffect(() => {
        const fetchDashboardInfo = async () => {
            const token = localStorage.getItem("token");
            if (!token) {
                setError("Token non trouvé, veuillez vous reconnecter.");
                setLoading(false);
                return;
            }

            try {
                const response = await fetch("/api/club-dashboard/infos", {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    },
                });

                if (!response.ok) {
                    const errorData = await response.json();
                    throw new Error(errorData.message || `Erreur HTTP ! Statut: ${response.status}`);
                }

                const data: MembreConnexionDto = await response.json();
                setMembreInfo(data);

                if (data.nomClub) {
                    const equipesResponse = await fetch(`/api/clubs/${data.nomClub}/equipes`);
                    if (!equipesResponse.ok) {
                        throw new Error(`Erreur HTTP ! Statut: ${equipesResponse.status}`);
                    }
                    const equipesData: Equipe[] = await equipesResponse.json();
                    setEquipes(equipesData);

                    if (equipesData.length > 0) {
                        setSelectedTeamId(equipesData[0].id);
                    }

                    const eventsResponse = await fetch(`/api/clubs/${data.nomClub}/events`);
                    if (!eventsResponse.ok) {
                        throw new Error(`Erreur HTTP ! Statut : ${eventsResponse.status}`);
                    }
                    const eventsData: Event[] = await eventsResponse.json();
                    setEvents(eventsData);

                    const membersResponse = await fetch(`/api/clubs/${data.nomClub}/members`);
                    if (!membersResponse.ok) {
                        throw new Error(`Erreur HTTP ! Statut : ${membersResponse.status}`);
                    }
                    const membersData: Member[] = await membersResponse.json();
                    setMembers(membersData);

                    const notificationsResponse = await fetch(`/api/notifications/${data.nomClub}`);
                    if (!notificationsResponse.ok) {
                        throw new Error(`Erreur HTTP ! Statut : ${notificationsResponse.status}`);
                    }
                    const notificationsData: Notification[] = await notificationsResponse.json();
                    setNotifications(notificationsData);
                } else {
                    setError("Nom du club non trouvé dans les informations du membre.");
                }

                setLoading(false);
            } catch (e: any) {
                setError(e.message);
                setLoading(false);
            }
        };

        fetchDashboardInfo();
    }, []);

    const filteredEvents = selectedTeamId ? events.filter(event => event.equipeId === selectedTeamId) : events;
    const filteredMembers = selectedTeamId ? members.filter(member => member.equipeId === selectedTeamId) : members;
    const filteredNotifications = selectedTeamId ? notifications.filter(notification => notification.equipeId === selectedTeamId) : notifications;

    if (loading) {
        return <div className="text-center p-4">Chargement des données du tableau de bord...</div>;
    }

    if (error) {
        return <div className="text-center p-4 text-red-500">Erreur lors du chargement des données du tableau de bord : {error}</div>;
    }

    const formatDate = (dateString: string | number | Date) => {
        try {
            return format(new Date(dateString), 'PPP', { locale: fr });
        } catch (error) {
            return 'Date invalide';
        }
    };

    return (
        <div className="dashboard-container">
            <AppNavBar membreInfo={membreInfo} />

            {membreInfo?.nomClub && (
                <div className="team-selector">
                    <label htmlFor="team">Équipe sélectionnée:</label>
                    <select
                        id="team"
                        value={selectedTeamId || ''}
                        onChange={(e) => setSelectedTeamId(parseInt(e.target.value, 10))}
                    >
                        {equipes.map(equipe => (
                            <option key={equipe.id} value={equipe.id}>{equipe.nom}</option>
                        ))}
                    </select>
                </div>
            )}

            <div className="dashboard-content">
                <div className="events-section">
                    <div className="events-header">
                        <h2>Calendrier des événements</h2>
                        <button className="add-event-button">+</button>
                    </div>
                    {filteredEvents.length > 0 ? (
                        <ul className="event-list">
                            {filteredEvents.map((event) => (
                                <li key={event.id} className="event-item">
                                    <h3>{event.nom}</h3>
                                    <p>
                                        {formatDate(event.dateDebut)} - {event.heureDebut}
                                    </p>
                                    <p>{event.lieu}</p>
                                </li>
                            ))}
                        </ul>
                    ) : (
                        <p className="no-events">Aucun événement à afficher pour le moment.</p>
                    )}
                </div>

                <div className="members-section">
                    <div className="members-header">
                        <h2>Membres de l'équipe</h2>
                        <input
                            type="text"
                            placeholder="Rechercher un membre..."
                            className="member-search"
                        />
                    </div>
                    {filteredMembers.length > 0 ? (
                        <div className="table">
                            <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Rôle</th>
                                <th>Statut</th>
                            </tr>
                            </thead>
                            <tbody>
                            {filteredMembers.map((member) => (
                                <tr key={member.id}>
                                    <td className="member-name">
                                        {member.photo && <img src={member.photo} alt={member.nom} className="member-photo" />}
                                        {member.prenom} {member.nom}
                                    </td>
                                    <td>{member.roleMembre?.nomRole || 'Non défini'}</td>
                                    <td className={`status-${member.statut.toLowerCase()}`}>
                                        {member.statut}
                                    </td>
                                </tr>
                            ))}
                            </tbody>
                        </div>
                    ) : (
                        <p className="no-members">Aucun membre à afficher pour le moment.</p>
                    )}
                </div>

                <div className="notifications-section">
                    <h2>Notifications</h2>
                    {filteredNotifications.length > 0 ? (
                        <ul className="notification-list">
                            {filteredNotifications.map((notification) => (
                                <li key={notification.id} className="notification-item">
                                    <AlertTriangle className="notification-icon" />
                                    <div className="notification-content">
                                        <p>{notification.contenu}</p>
                                        <p className="notification-time">
                                            Il y a {format(new Date(notification.dateEnvoi), "HH'h'mm", { locale: fr })}
                                        </p>
                                    </div>
                                </li>
                            ))}
                        </ul>
                    ) : (
                        <p className="no-notifications">Aucune notification pour le moment.</p>
                    )}
                </div>
            </div>
        </div>
    );
};

export default ClubDashboard;