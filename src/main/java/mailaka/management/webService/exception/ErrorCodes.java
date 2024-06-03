package mailaka.management.webService.exception;



public enum ErrorCodes {
    UPDATE_PHOTO_EXCEPTION(1000),
    IMAGE_NOT_VALID(1002),
    HEADER_NOT_VALID(2001),
    SERVICE_INFO_NOT_VALID(4001),
    OUR_SERVICE_NOT_VALID(3001),
    TEXT_ON_BUTTON_NOT_VALID(5001),
    WHO_WE_ARE_NOT_VALID(6001),
    CONTEXT_INCONNU(10000),
    REALISATIONS_NOT_VALID(11000);


    private int code;
    ErrorCodes(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }

}
