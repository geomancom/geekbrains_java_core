package Dz_8;

public  final class AppGlobalState {
    private static AppGlobalState INSDTANCE;
    private static final String API_KEY = "GsvXrNaxMpldrOrntrfKZWEQCLCoGxMq";
    private String selectedCity = null;

    private AppGlobalState(){
    }
    public static AppGlobalState getInstance(){
        if (INSDTANCE == null){
            INSDTANCE = new AppGlobalState();
        }
        return INSDTANCE;
    }
    public String getSelectedCity(){
        return selectedCity;
    }
    public String getApiKey(){
        return this.API_KEY;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }
}