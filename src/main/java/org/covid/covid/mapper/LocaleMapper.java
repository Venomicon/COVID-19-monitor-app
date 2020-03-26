package org.covid.covid.mapper;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LocaleMapper {
    private Map<String, String> localeMap = new HashMap<>();

    public LocaleMapper() {
        localeMap.put("USA", "en-US");
        localeMap.put("ARGENTINA", "es-AR");
        localeMap.put("AUSTRALIA", "en-AU");
        localeMap.put("AUSTRIA", "de-AT");
        localeMap.put("BELGIUM", "fr-BE");
        localeMap.put("BRAZIL", "pt-BR");
        localeMap.put("CANADA", "en-CA");
        localeMap.put("CHILE", "es-CL");
        localeMap.put("DENMARK", "da-DK");
        localeMap.put("FINLAND", "fi-FI");
        localeMap.put("FRANCE", "fr-FR");
        localeMap.put("GERMANY", "de-DE");
        localeMap.put("CHINA", "zh-HK");
        localeMap.put("INDIA", "en-IN");
        localeMap.put("INDONESIA", "en-ID");
        localeMap.put("IRELAND", "en-IE");
        localeMap.put("ITALY", "it-IT");
        localeMap.put("JAPAN", "ja-JP");
        localeMap.put("KOREA", "ko-KR");
        localeMap.put("MALAYSIA", "en-MY");
        localeMap.put("MEXICO", "es-MX");
        localeMap.put("NETHERLANDS", "nl-NL");
        localeMap.put("NEW ZEALAND", "en-NZ");
        localeMap.put("NORWAY", "no-NO");
        localeMap.put("POLAND", "pl=PL");
        localeMap.put("PORTUGAL", "pt-PT");
        localeMap.put("RUSSIA", "ru-RU");
        localeMap.put("SPAIN", "es-ES");
        localeMap.put("SWITZERLAND", "de-CH");
        localeMap.put("TURKEY", "tr-TR");
        localeMap.put("UK", "en-GB");
    }
}
