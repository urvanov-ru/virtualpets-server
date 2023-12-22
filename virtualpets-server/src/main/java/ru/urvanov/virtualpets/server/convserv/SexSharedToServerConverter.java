package ru.urvanov.virtualpets.server.convserv;

import org.springframework.core.convert.converter.Converter;

public class SexSharedToServerConverter
        implements
        Converter<ru.urvanov.virtualpets.shared.domain.Sex, ru.urvanov.virtualpets.server.domain.Sex> {

    @Override
    public ru.urvanov.virtualpets.server.domain.Sex convert(ru.urvanov.virtualpets.shared.domain.Sex source) {
        if (source == null) {
            return null;
        }
        switch (source) {
        case MAN:
            return ru.urvanov.virtualpets.server.domain.Sex.MAN;

        case WOMAN:
            return ru.urvanov.virtualpets.server.domain.Sex.WOMAN;
        }
        return null;
    }

}
