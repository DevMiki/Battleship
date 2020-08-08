package it.playersEnum;

public enum ShipType {
    Mini("Mini",1),Bit("Bit",2),Bytes("Bytes",3), Ya("Ya",4);

    private String type;
    private int code;

    private ShipType(String type, int code) {
        this.type = type;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public int getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
