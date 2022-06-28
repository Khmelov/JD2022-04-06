package by.it.ragach.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private ResourceBundle resourceBundle;

   ResMan(){ setLocale(Locale.getDefault());
   }
   private static final String basename = "by.it.ragach.calc.languages.text";

   public void setLocale(Locale locale) {resourceBundle = ResourceBundle.getBundle(basename,locale);
    }

    public String get (String key){
        return resourceBundle.getString(key);
    }
}
