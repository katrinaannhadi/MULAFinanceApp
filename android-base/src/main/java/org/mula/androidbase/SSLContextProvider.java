/* Mula */

package org.mula.androidbase;

import android.content.*;

import androidx.annotation.NonNull;

import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.*;

import javax.inject.*;
import javax.net.ssl.*;

public class SSLContextProvider
{
    private Context context;

    @Inject
    public SSLContextProvider(@NonNull @AppContext Context context)
    {
        this.context = context;
    }

    public SSLContext getCACertSSLContext()
    {
        try
        {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            InputStream caInput = context.getAssets().open("cacert.pem");
            Certificate ca = cf.generateCertificate(caInput);

            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(null, null);
            ks.setCertificateEntry("ca", ca);

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(ks);

            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(null, tmf.getTrustManagers(), null);

            return ctx;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
