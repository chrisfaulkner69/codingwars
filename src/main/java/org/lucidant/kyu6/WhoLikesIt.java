package org.lucidant.kyu6;
 class WhoLikesIt {

    private static final String FORMAT = "%s like%s this";

    // Codewars does not yet allow Java 21
    @SuppressWarnings("StringTemplateMigration")
    public static String whoLikesIt(String... names) {
        final int arrayLength = names == null ? 0 : names.length;

        return switch (arrayLength) {
            case 0 -> String.format(FORMAT, "no one", "s");
            case 1 -> String.format(FORMAT, names[0], "s");
            case 2 -> String.format(FORMAT, names[arrayLength - 2] + " and " + names[arrayLength - 1], "");
            case 3 -> String.format(FORMAT, names[0] + ", " + names[1] + " and " + names[2], "");
            default -> String.format(FORMAT, names[0] + ", " + names[1] + " and " + (arrayLength-2) + " others", "");
        };
    }

}
