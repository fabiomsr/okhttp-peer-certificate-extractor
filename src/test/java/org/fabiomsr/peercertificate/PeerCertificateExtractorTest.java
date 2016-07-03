package org.fabiomsr.peercertificate;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * Created by fabiomsr on 3/7/16.
 */
public class PeerCertificateExtractorTest {

    /**
     * Extract from crt file
     */
    @Test
    public void extractPeerCertificateFromCrtTest() throws URISyntaxException {
        URL certificateUrl = PeerCertificateExtractorTest.class.getResource("/bob.crt");
        File certificate = new File(certificateUrl.toURI());
        String peerCertificate = PeerCertificateExtractor.extract(certificate);

        String expectedResult = "sha256/u4QJrwx7aSejc080BBQKGyTaoJovFBg4SbQ9nhoohb8=";
        assertTrue(expectedResult.equals(peerCertificate));
    }


    /**
     * Extract from der file
     */
    @Test
    public void extractPeerCertificateFromDerTest() throws URISyntaxException {
        URL certificateUrl = PeerCertificateExtractorTest.class.getResource("/alice.der");
        File certificate = new File(certificateUrl.toURI());
        String peerCertificate = PeerCertificateExtractor.extract(certificate);

        String expectedResult = "sha256/qvsjJ876FNNlPbj00j+TvhyqMy3iZ7VppVTdxCtQT8o=";
        assertTrue(expectedResult.equals(peerCertificate));
    }

    /**
     * Extract from pem file
     */
    @Test
    public void extractPeerCertificateFromPemTest() throws URISyntaxException {
        URL certificateUrl = PeerCertificateExtractorTest.class.getResource("/certificate.pem");
        File certificate = new File(certificateUrl.toURI());
        String peerCertificate = PeerCertificateExtractor.extract(certificate);

        String expectedResult = "sha256/grX4Ta9HpZx6tSHkmCrvpApTQGo67CYDnvprLg5yRME=";
        assertTrue(expectedResult.equals(peerCertificate));
    }

}
