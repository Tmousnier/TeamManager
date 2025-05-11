import { Outlet } from "react-router-dom";
import { AuthProvider } from "../components/applis/AuthContext";
import AppNavBar from "../components/applis/NavBar/AppNavBar";

export default function LayoutApp() {
    return (
            <AuthProvider>
                <AppNavBar />
                <Outlet />
            </AuthProvider>
    );
}