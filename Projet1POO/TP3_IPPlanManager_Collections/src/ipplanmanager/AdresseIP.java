package ipplanmanager;

public class AdresseIP {

    private String adresse;

    public AdresseIP(String adresse) {
        setAdresse(adresse);
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        if (adresse == null || !valide(adresse)) {
            this.adresse = "0.0.0.0";
        } else {
            this.adresse = adresse;
        }
    }

    private boolean valide(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;

        try {
            for (String p : parts) {
                int v = Integer.parseInt(p);
                if (v < 0 || v > 255) return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void afficher() {
        System.out.println("IP : " + adresse);
    }
}