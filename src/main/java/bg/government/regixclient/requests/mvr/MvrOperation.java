package bg.government.regixclient.requests.mvr;

import bg.government.regixclient.requests.mvr.*;
import bg.government.regixclient.requests.Operation;

public enum MvrOperation implements Operation {
    PERSONAL_IDENTITY_INFO("TechnoLogica.RegiX.MVRBDSAdapter.APIService.IMVRBDSAPI.GetPersonalIdentity");
    
    private final String key;
    
    private MvrOperation(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
