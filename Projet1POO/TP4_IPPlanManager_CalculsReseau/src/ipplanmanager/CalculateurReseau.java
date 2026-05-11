package ipplanmanager;

public class CalculateurReseau {

    // Calcule le nombre maximum d'hôtes pour un CIDR donné
    public static int calculerNombreHotes(int cidr) {
        if (cidr < 0 || cidr > 32) {
            return 0;
        }
        int bitsHotes = 32 - cidr;
        return (int) Math.pow(2, bitsHotes) - 2;
    }

    // Retourne la classe réseau selon le premier octet
    public static String obtenirClasseReseau(String adresseIP) {
        String[] parties = adresseIP.split("\\.");
        int premierOctet = Integer.parseInt(parties[0]);
        if (premierOctet >= 1 && premierOctet <= 126) {
            return "Classe A";
        }
        if (premierOctet >= 128 && premierOctet <= 191) {
            return "Classe B";
        }
        if (premierOctet >= 192 && premierOctet <= 223) {
            return "Classe C";
        }
        return "Classe inconnue";
    }

    // Convertit un CIDR en masque décimal pointé
    public static String obtenirMasqueDecimal(int cidr) {
        switch (cidr) {
            case 8:  return "255.0.0.0";
            case 16: return "255.255.0.0";
            case 24: return "255.255.255.0";
            case 25: return "255.255.255.128";
            case 26: return "255.255.255.192";
            case 27: return "255.255.255.224";
            case 28: return "255.255.255.240";
            default: return "Masque non disponible";
        }
    }

    // === TRAVAIL SUPPLÉMENTAIRE — méthode est ReseauPrive ===
    public static boolean estReseauPrive(String adresseIP) {
        String[] parties = adresseIP.split("\\.");
        int octet1 = Integer.parseInt(parties[0]);
        int octet2 = Integer.parseInt(parties[1]);
        // 10.x.x.x
        if (octet1 == 10) {
            return true;
        }
        // 172.16.x.x à 172.31.x.x
        if (octet1 == 172 && octet2 >= 16 && octet2 <= 31) {
            return true;
        }
        // 192.168.x.x
        if (octet1 == 192 && octet2 == 168) {
            return true;
        }
        return false;
    }
}