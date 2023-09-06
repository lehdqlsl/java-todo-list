package Week2;

public enum Option {
    ADD("1"),
    REMOVE("2"),
    SELECT("3"),
    QUIT("4"),
    INVALID("");

    private final String value;

    Option(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static Option fromValue(String value){
        for(Option option : Option.values()){
            if(option.value.equals(value)){
                return option;
            }
        }
        return INVALID;
    }
}
