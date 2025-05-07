import { Outlet } from "react-router-dom";
import NavBar from "../components/presentation/navBar/NavBar";
import Footer from "../components/presentation/footer/footer.tsx";

export default function LayoutPublic() {
    return (
        <>
            <NavBar />
            <Outlet />
            <Footer />
        </>
    );
}
