package it.playersEnum;

public enum HitOccurency {

    NAVE_COLPITA("HAI COLPITO LA NAVE!"), NAVE_AFFONDATA("HAI AFFONDATO LA NAVE INCREDIBILE!"), ACQUA_COLPITA("HAI SBAGLIATO RIPROVA"), ACQUA_RICOLPITA("ACQUA DI NUOVO MI SPIACE"), NAVE_RICOLPITA("NON PUOI COLPIRE UNA NAVE COLPITA!");

    private String message;

    HitOccurency(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

