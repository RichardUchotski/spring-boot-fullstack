package org.amigoscodersuapi.customer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Gender {
    MALE("MALE", "male", "Male", "M", "m", "man", "MAN", "Man"),
    FEMALE("FEMALE", "female", "Female", "F", "f"),
    NON_BINARY("NON_BINARY", "non-binary", "Non-binary", "Nonbinary", "NB", "nb", "non binary", "NON BINARY", "Non Binary", "Non binary", "Woman", "woman", "WOMAN"),
    GENDER_FLUID("GENDERFLUID", "genderfluid", "Genderfluid", "Gender Fluid", "GF", "gf", "gender fluid", "Gender fluid"),
    OTHER("OTHER", "other", "Other", "O", "o");

    private final Set<String> acceptedValues;

    Gender(String... values) {
        this.acceptedValues = new HashSet<>(Arrays.asList(values));
    }

    public static Gender fromString(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.acceptedValues.contains(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid gender: " + value);
    }

}
