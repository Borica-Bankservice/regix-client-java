package bg.government.regixclient;

import java.lang.reflect.Field;

import bg.government.regixclient.requests.mvr.MvrOperation;
import bg.government.regixclient.requests.mvr.bds.PersonalIdentityInfoRequest;

public class RegixClientDemoMvr {

    public static void main(String[] args) throws Exception {
        
        String keystorePassword = args[0];
        
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        
        PersonalIdentityInfoRequest personDataRequest = new PersonalIdentityInfoRequest();
        personDataRequest.setIdentityDocumentNumber("test");
        personDataRequest.setEGN("test");
        
        RegixClient client = RegixClient.create(RegixClientDemoMvr.class.getResourceAsStream("/test.jks"), keystorePassword.toCharArray());
        ServiceRequestData requestData = RegixClient.createRequestData(MvrOperation.PERSONAL_IDENTITY_INFO, personDataRequest);
        
        CallContext ctx = new CallContext();
        requestData.setCallContext(ctx);
        
        System.out.println(client.executeSynchronous(requestData).getData().getResponse().getAny());
    }

    @SuppressWarnings("unused")
    private static void setupTLS() throws Exception {
        // enable strong security
        Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
        field.setAccessible(true);
        field.set(null, java.lang.Boolean.FALSE);
    }
}
