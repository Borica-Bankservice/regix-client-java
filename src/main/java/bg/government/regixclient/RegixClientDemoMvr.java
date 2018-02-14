package bg.government.regixclient;

import java.lang.reflect.Field;

import bg.government.regixclient.requests.mvr.MvrOperation;
import bg.government.regixclient.requests.mvr.bds.PersonalIdentityInfoRequest;
import bg.government.regixclient.responses.mvr.bds.PersonNames;
import bg.government.regixclient.responses.mvr.bds.PersonalIdentityInfoResponse;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import java.io.FileInputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMSource;

public class RegixClientDemoMvr {

    public static void main(String[] args) throws Exception {

        String keystorePassword = "123456";

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        PersonalIdentityInfoRequest personalIdentityInfoRequest = new PersonalIdentityInfoRequest();
        personalIdentityInfoRequest.setIdentityDocumentNumber("1234567890");
        personalIdentityInfoRequest.setEGN("1212124563");
        String keyStorePath = "test_regix_client.jks";

        FileInputStream keyStoreStream = new FileInputStream(keyStorePath);
        RegixClient client = RegixClient.create(keyStoreStream, keystorePassword.toCharArray());
        ServiceRequestData requestData = RegixClient.createRequestData(MvrOperation.PERSONAL_IDENTITY_INFO, personalIdentityInfoRequest);

        CallContext ctx = new CallContext();
        requestData.setCallContext(ctx);

        ServiceResultData serviceResultData = client.executeSynchronous(requestData);
        ElementNSImpl eleNsImplObject;
        eleNsImplObject = (ElementNSImpl) serviceResultData.getData().getResponse().getAny();
        org.w3c.dom.Document document = eleNsImplObject.getOwnerDocument();
        JAXBContext jc = JAXBContext.newInstance(bg.government.regixclient.responses.mvr.bds.ObjectFactory.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement jaxbElement = (JAXBElement) unmarshaller.unmarshal(new DOMSource(document));
        PersonalIdentityInfoResponse myResp = new PersonalIdentityInfoResponse();

        myResp = (PersonalIdentityInfoResponse) jaxbElement.getValue();
        String egn = myResp.getDocumentType();
        PersonNames names = myResp.getPersonNames();
        System.out.println("FirstNameLatin = " + names.getFirstNameLatin());

    }

    @SuppressWarnings("unused")
    private static void setupTLS() throws Exception {
        // enable strong security
        Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
        field.setAccessible(true);
        field.set(null, java.lang.Boolean.FALSE);
    }
}
