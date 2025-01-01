package service;

import API.APIManager;
import org.json.JSONObject;

public class CatFactService {
    private static final String CAT_FACT_API_URL = "https://catfact.ninja/fact";
    private APIManager apiManager;

    public CatFactService() {
        this.apiManager = APIManager.getInstance();
    }

    public String getRandomCatFact() {
        try {
            String response = apiManager.fetchCatFact(CAT_FACT_API_URL);
            JSONObject json = new JSONObject(response);
            return json.getString("fact");
        } catch (Exception e) {
            throw new RuntimeException("Error fetching cat fact: " + e.getMessage(), e);
        }
    }
}