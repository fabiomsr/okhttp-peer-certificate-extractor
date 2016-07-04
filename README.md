# Peer certificate extractor

Herramienta para la extracción del peer certificate desde un certificado dado. 

Cuando implementamos el certificate pinning en una conexión necesitamos definir un peer certificate, que es la clave pública de un certificado luego de hacerle un sha256 y pasarlo a base64. Esta herramienta facilita esa tarea al extraer el peer certificate desde unos de los archivos soportados: crt, der o pem file.

Esto lo hacemos de esta forma:

~~~java
    File certificate = new File(certificateUri);
    String peerCertificate = PeerCertificateExtractor.extract(certificate);
~~~
  
Esto nos devuelve el peer certificate:

~~~
    sha256/u4QJrwx7aSejc080BBQKGyTaoJovFBg4SbQ9nhoohb8=
~~~

Puedes ver más ejemplos de cómo funciona en la carpeta `src/test`

## Okhttp

Cuando habilitamos el certificate pinning en okhttp lo hacemos de la siguiente forma, en donde el sha256/AAAAAAAA… es el que esta herramienta extrae para ti desde un certificado. 

~~~java
    client = new OkHttpClient.Builder()
                .certificatePinner(new CertificatePinner.Builder()
                    .add("publicobject.com", "sha256/AAAAA...")
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
    