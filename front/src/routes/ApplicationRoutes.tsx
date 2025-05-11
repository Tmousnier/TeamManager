import React from 'react';
import { Route, Navigate } from 'react-router-dom';
import Login from "../components/presentation/connexion/connexion.tsx";
import ClubDashboard from "../components/applis/dashboard/ClubDashboard.tsx";

const PrivateRoute = ({ children }: { children: React.ReactNode }) => {
    const token = localStorage.getItem('token');
    return token ? children : <Navigate to="/connexion" />;
};

const applicationRoutes = (
    <>
        <Route path="/connexion" element={<Login />} />
        <Route path="/:nomClub/dashboard" element={
            <PrivateRoute>
                <ClubDashboard />
            </PrivateRoute>
        } />
    </>
);

export default applicationRoutes;
