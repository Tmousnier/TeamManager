// logoService.tsx
export const uploadLogo = async (file: File): Promise<string> => {
    const formData = new FormData();
    formData.append("file", file);

    const response = await fetch("/api/logo", {
        method: "POST",
        body: formData,
    });

    if (!response.ok) {
        throw new Error("Erreur lors de l'upload du logo");
    }

    const { url } = await response.json();
    return url;
};

export const getLogoUrl = async (): Promise<string | null> => {
    const response = await fetch("/api/logo");

    if (!response.ok) {
        return null;
    }

    const { url } = await response.json();
    return url;
};
