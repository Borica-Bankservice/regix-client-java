/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.government.regixclient;

import bg.government.regixclient.responses.mvr.bds.PersonNames;
import bg.government.regixclient.responses.mvr.bds.PersonalIdentityInfoResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sbalabanov
 */
public class RegixClientDemoMvrTest {

    public RegixClientDemoMvrTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class RegixClientDemoMvr.
     * @throws java.lang.Exception
     */
    @Test
    public void testPersonalIdentityInfo() throws Exception {
        String expResult = "LYUBOMIR";
        PersonalIdentityInfoResponse myResp = new PersonalIdentityInfoResponse();
        JAXBContext jc = JAXBContext.newInstance(bg.government.regixclient.responses.mvr.bds.ObjectFactory.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        //  InputStream textXml=RegixClientDemoMvrTest.class.getResourceAsStream("response.xml");
        InputStream textXml = new FileInputStream("src\\test\\resources\\response.xml");
        JAXBElement jaxbElement = (JAXBElement) unmarshaller.unmarshal(textXml);

        myResp = (PersonalIdentityInfoResponse) jaxbElement.getValue();
        String egn = myResp.getDocumentType();
        PersonNames names = myResp.getPersonNames();
        String firstNameLatin = names.getFirstNameLatin();
        System.out.println("FirstNameLatin = " + names.getFirstNameLatin());
        assertEquals(expResult, firstNameLatin);

    }

}
