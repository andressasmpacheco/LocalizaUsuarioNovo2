package br.com.localizausuarionovo;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permissoes {

    public static boolean ValidarPermissoes(String[]permissoes, Activity activity, int requestCode) {

        if (Build.VERSION.SDK_INT >= 23) {

            List<String> ListaPermissoes = new ArrayList<>();

            for (String Permissao : permissoes) {

                Boolean TemPermissao = ContextCompat.checkSelfPermission(activity, Permissao)
                        == PackageManager.PERMISSION_GRANTED;
                if(!TemPermissao) ListaPermissoes.add(Permissao);
            }

            if (ListaPermissoes.isEmpty()) return true;
            String[] NovasPermissoes = new String[ListaPermissoes.size()];
            ListaPermissoes.toArray(NovasPermissoes);

            ActivityCompat.requestPermissions(activity, NovasPermissoes, requestCode);
        }

        return true;
    }
}
