import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import LayoutPublic from "./layouts/LayoutPublic";
import LayoutApp from "./layouts/LayoutApp";

import { presentationRoutes } from "./routes/PresentationRoutes";
import applicationRoutes from "./routes/ApplicationRoutes";

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <Router>
            <Routes>
                <Route element={<LayoutPublic />}>
                    {presentationRoutes}
                </Route>
                <Route element={<LayoutApp />}>
                    {applicationRoutes}
                </Route>
            </Routes>
        </Router>
    </StrictMode>
);
