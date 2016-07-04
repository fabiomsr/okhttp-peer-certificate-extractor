# Peer certificate extractor

This tool extracts peer certificates from given certificates.

In order to implement certificate pinning during an SSL connection, a peer certificate needs to be declared first. This peer certificate is a certificate´s public key after being transformed using SHA256 algorithm and base64 encryption. This tool eases the peer certificate extraction task and supports files such as .crt, .der or .pem.

In order to extract a peer certificate:

~~~java
    File certificate = new File(certificateUri);
    String peerCertificate = PeerCertificateExtractor.extract(certificate);
~~~
  
Retrieved peer certificates format:

~~~
    sha256/u4QJrwx7aSejc080BBQKGyTaoJovFBg4SbQ9nhoohb8=
~~~

For further usage examples, navigate to `src/test`

## Okhttp

Enabling okhttp certificate pinning is now made the following way: 

~~~java
    client = new OkHttpClient.Builder()
                .certificatePinner(new CertificatePinner.Builder()
                    .add("publicobject.com", peerCertificate)
                    .build())
                .build();
~~~


License
-------

    Copyright 2016 Fabio Santana (fabiomsr)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
