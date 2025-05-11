import React, { createContext, useContext, useState, useEffect, ReactNode } from 'react';

interface Membre {
    id: number;
    email: string;
    role: 'Dirigeant' | 'Entraineur' | 'Joueur' | 'Parent' | 'Responsable';
    equipeId?: number;
    clubId?: number;
}

interface AuthContextType {
    membre: Membre | null;
    login: (membreData: Membre) => void;
    logout: () => void;
}

export const AuthContext = createContext<AuthContextType>({
    membre: null,
    login: () => {},
    logout: () => {},
});

export const useAuth = () => useContext(AuthContext);

interface AuthProviderProps {
    children: ReactNode;
}

export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
    const [membre, setMembre] = useState<Membre | null>(null);

    useEffect(() => {
        const storedMembre = localStorage.getItem('membre');
        if (storedMembre) {
            setMembre(JSON.parse(storedMembre));
        }
    }, []);

    const login = (membreData: Membre) => {
        setMembre(membreData);
        localStorage.setItem('membre', JSON.stringify(membreData));
    };

    const logout = () => {
        setMembre(null);
        localStorage.removeItem('membre');
    };

    return (
        <AuthContext.Provider value={{ membre, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};
